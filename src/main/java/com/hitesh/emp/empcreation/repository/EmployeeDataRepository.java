package com.hitesh.emp.empcreation.repository;

import org.springframework.stereotype.Repository;

import com.hitesh.emp.empcreation.database.EmployeeInfo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface EmployeeDataRepository extends JpaRepository<EmployeeInfo,Long>{

	 Optional<EmployeeInfo> findById(Long id);
	 
	 Optional<EmployeeInfo> findByMobileNumber(String mobileNumber);
}
