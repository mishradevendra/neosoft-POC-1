package com.user.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private Integer userId;
	@NotBlank(message = "first name must not be empty")
	@Size(min = 3, max = 15, message = "User name must be between 3-15 character")
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "SUR_NAME")
	private String surName;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "DOB")
	private Date dob;
	@NotNull(message = "Please enter age")
	@Column(name = "AGE")
	private Integer age;
	@NotEmpty(message = "email must not be empty")
	@Email(message = "email should be a valid email")
	@Column(name = "EMAIL_ID")
	private String emailId;
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "JOIN_DATE")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date joinDate;
	@NotNull(message = "Mobile no muset have 10 digit")
	@Column(name = "MOBILE_NO")
	private Long mobileNo;
	@Column(name = "STREET")
	private String street;
	@Column(name = "CITY")
	private String city;
	@Column(name = "STATE")
	private String state;
	@Column(name = "PIN_CODE")
	@NotNull(message = "Pincode must not be empty")

	private Integer pinCode;
	@Column(name = "COUNTRY")
	private String country;

}
