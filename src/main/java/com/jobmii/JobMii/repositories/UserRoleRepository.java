package com.jobmii.JobMii.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserRoleRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void insertUserRole(Integer userId) {
		entityManager.createNativeQuery("INSERT INTO tb_user_role (user_id, role_id) VALUES (?, 1)")
				.setParameter(1, userId)
				.executeUpdate();
	}
}
