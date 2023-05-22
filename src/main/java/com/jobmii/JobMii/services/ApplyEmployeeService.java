package com.jobmii.JobMii.services;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.poi.ss.usermodel.*;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import javax.mail.MessagingException;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.jobmii.JobMii.models.Apply_Employee;
import com.jobmii.JobMii.models.Employee;
import com.jobmii.JobMii.models.History;
import com.jobmii.JobMii.models.Role;
import com.jobmii.JobMii.models.Status;
import com.jobmii.JobMii.models.User;
import com.jobmii.JobMii.models.Vacancy;
import com.jobmii.JobMii.repositories.ApplyEmployeeRepository;
import com.jobmii.JobMii.repositories.EmployeeRepository;
import com.jobmii.JobMii.repositories.HistoryRepository;
import com.jobmii.JobMii.repositories.UserRepository;
import com.jobmii.JobMii.repositories.UserRoleRepository;
import com.jobmii.JobMii.repositories.VacancyRepository;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ApplyEmployeeService {
	private UserRepository userRepository;
	private ApplyEmployeeRepository applyEmployeeRepository;
	private HistoryRepository historyRepository;
	private ModelMapper modelMapper;
	private EmployeeRepository employeeRepository;
	private UserRoleRepository userRoleRepository;
	private VacancyRepository vacancyRepository;
	private EmailService emailService;
	private StatusService statusService;
	private RoleService roleService;
	private UserService userService;

	public List<Apply_Employee> getAll() {
		return applyEmployeeRepository.findAll();
	}

	public void updateUserRole(Integer id) {
		userRoleRepository.insertUserRole(id);
	}

	public Apply_Employee getById(Integer id) {
		return applyEmployeeRepository
				.findById(id)
				.orElseThrow(() -> new ResponseStatusException(
						HttpStatus.NOT_FOUND,
						"Employee not found!!"));
	}

	public List<Apply_Employee> getByIdEmployee() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		User user = userRepository.findByUsername(username);
		return applyEmployeeRepository
				.findByIdEmployee(user.getId());
	}

	public List<Apply_Employee> getJobApplicant(int id) {

		return applyEmployeeRepository.findJobApplicant(id);
	}

	public List<Apply_Employee> getJobApply(int id) {

		return applyEmployeeRepository.findJobApply(id);
	}

	public List<Apply_Employee> getDataAcc(int id) {

		return applyEmployeeRepository.getAccept(id);
	}

	public void create(Apply_Employee applyEmployee) throws TemplateNotFoundException, MalformedTemplateNameException,
			ParseException, MessagingException, IOException, TemplateException {
		int employeeId = applyEmployee.getEmployee().getId();
		int vacancyId = applyEmployee.getVacancy().getId();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();

		applyEmployee.setStatus(statusService.getById(1));
		applyEmployee.setApply_date(formatter.format(date));
		applyEmployeeRepository.save(applyEmployee);

		History history = new History();
		history.setApply_employee(applyEmployee);
		history.setStatus(applyEmployee.getStatus());
		history.setUpdate_date(formatter.format(date));
		historyRepository.save(history);

		Employee employee = employeeRepository.findById(employeeId).orElse(null);

		if (employee != null) {
			String email = employee.getEmail();
			String name = employee.getName();
			String content = "Dear " + name + " berikut adalah jadwal kamu untuk inteview pada\n"
					+ applyEmployee.getDate_test() + " " + applyEmployee.getLocation_test();
			Vacancy vacancy = vacancyRepository.findById(vacancyId).orElse(null);
			if (vacancy != null) {
				Employee mitra = vacancy.getMitra();
				String mitraName = mitra.getName();
				String title = "Interview Schedule " + vacancy.getTitle() + " " + mitraName;
				emailService.sendEmail(email, title, applyEmployee.getDate_test(),
						applyEmployee.getLocation_test());

				String content1 = "Dear " + mitraName + " berikut adalah jadwal inteview untuk employee kami pada\n"
						+ applyEmployee.getDate_test() + " " + applyEmployee.getLocation_test();
				String emailClient = mitra.getEmail();
				emailService.sendEmail(emailClient, title, applyEmployee.getDate_test(),
						applyEmployee.getLocation_test());
			} else {
				System.out.println("Vacancy dengan id " + vacancyId + " tidak ditemukan.");
			}
		} else {
			System.out.println("Employee dengan id " + employeeId + " tidak ditemukan.");
		}
	}

	public void update(Integer id, Apply_Employee applyEmployee) {
		getById(id); // method getById
		applyEmployee.setId(id);
		applyEmployee.setApply_date(applyEmployee.getApply_date());
		applyEmployeeRepository.save(applyEmployee);

		User user = new User();
		user = userService.getById(applyEmployee.getEmployee().getId());

		List<Role> roles = new ArrayList<>();
		roles.add(roleService.getById(1));
		user.setRoles(roles);
		userRepository.save(user);

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();

		History history = new History();
		history.setApply_employee(applyEmployee);
		history.setStatus(applyEmployee.getStatus());
		history.setUpdate_date(formatter.format(date));

		historyRepository.save(history);
	}

	public void delete(Integer id) {
		Apply_Employee applyEmployee = getById(id);
		applyEmployeeRepository.delete(applyEmployee);

	}

	public Workbook dataEmploye(Integer vacancyId) {
		List<Object[]> employees = applyEmployeeRepository.findEmployeeAccepted(vacancyId);

		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Data Employee");

		// Nama Header di Excel
		Row headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("No");
		headerRow.createCell(1).setCellValue("Name");
		headerRow.createCell(2).setCellValue("Email");
		headerRow.createCell(3).setCellValue("Phone");
		headerRow.createCell(4).setCellValue("Position");

		int rowNum = 1;
		int employeeNumber = 1; // Nomor awal
		for (Object[] employee : employees) {
			Row dataRow = sheet.createRow(rowNum++);
			dataRow.createCell(0).setCellValue(employeeNumber++); // Nomor
			dataRow.createCell(1).setCellValue(employee[8].toString()); // Name
			dataRow.createCell(2).setCellValue(employee[9].toString()); // Email
			dataRow.createCell(3).setCellValue(employee[10].toString()); // Phone
			dataRow.createCell(4).setCellValue(employee[11].toString()); // Position
		}

		// Save Excel file
		try (FileOutputStream outputStream = new FileOutputStream("employee_data.xlsx")) {
			workbook.write(outputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return workbook;
	}
}