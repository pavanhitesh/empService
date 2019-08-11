package com.hitesh.emp.empcreation.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="employee_info")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeInfo {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	private String empFirstName;
	private String empLastName;
	private String empStack;
	private int empExperience;
	private String empCompany;
	private String mobileNumber;
	
}
