package com.jobmii.JobMii.services;

import javax.mail.internet.InternetAddress;
import java.io.File;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import lombok.AllArgsConstructor;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.jobmii.JobMii.models.dto.requests.ClientRequest;
import com.jobmii.JobMii.models.dto.requests.EmployeeRequest;
import com.jobmii.JobMii.models.dto.responses.MailResponse;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

@Service
@AllArgsConstructor
public class EmailService {
	private JavaMailSender sender;
	private Configuration config;

	public MailResponse sendEmail(EmployeeRequest request) {
		MailResponse response = new MailResponse();
		MimeMessage message = sender.createMimeMessage();
		try {
			// set mediaType
			MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
					StandardCharsets.UTF_8.name());
			Map<String, Object> model1 = new HashMap<>();

			model1.put("email_to", request.getEmail());
			model1.put("username", request.getUsername());
			model1.put("password", request.getPassword());
			// model1.put("subject", "Akun Baru JobMii");
			// model1.put("date", formatter.format(date));
			Template t = config.getTemplate("email-template.ftl");
			String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model1);

			helper.setSubject("Akun Baru JobMii");
			helper.setTo(request.getEmail());
			helper.setText(html, true);

			// helper.setFrom(request.getFrom());
			sender.send(message);

			// response.setMessage("mail send to : " + request.getEmail());
			// response.setStatus(Boolean.TRUE);

		} catch (MessagingException | IOException | TemplateException e) {
			response.setMessage("Mail Sending failure : " + e.getMessage());
			response.setStatus(Boolean.FALSE);
		}

		return response;
	}

	public void sendEmailFix(EmployeeRequest employeeRequest) throws MessagingException, TemplateNotFoundException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException {

		// SimpleMailMessage message = new SimpleMailMessage();
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
				StandardCharsets.UTF_8.name());
		Map<String, Object> model1 = new HashMap<>();

		model1.put("email_to", employeeRequest.getEmail());
		model1.put("username", employeeRequest.getUsername());
		model1.put("password", employeeRequest.getPassword());
		// model1.put("subject", "Akun Baru JobMii");
		// model1.put("date", formatter.format(date));
		Template t = config.getTemplate("email-template.ftl");
		String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model1);

		helper.setTo(employeeRequest.getEmail());
		helper.setSubject("Registration Account JobMii Success");
		helper.setText(html, true);

		sender.send(message);
	}

	public void sendEmailClient(ClientRequest clientRequest) throws MessagingException, TemplateNotFoundException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException {

		// SimpleMailMessage message = new SimpleMailMessage();
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
				StandardCharsets.UTF_8.name());
		Map<String, Object> model1 = new HashMap<>();

		model1.put("email_to", clientRequest.getEmail());
		model1.put("username", clientRequest.getUsername());
		model1.put("password", clientRequest.getPassword());
		// model1.put("subject", "Akun Baru JobMii");
		// model1.put("date", formatter.format(date));
		Template t = config.getTemplate("email-template.ftl");
		String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model1);

		helper.setTo(clientRequest.getEmail());
		helper.setSubject("Registration Account JobMii Success");
		helper.setText(html, true);

		sender.send(message);
	}
}
