package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "PERSON")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personid_generator")
	@SequenceGenerator(name = "personid_generator", initialValue = 1, allocationSize = 1, sequenceName = "personid_seq")
	@Column(name = "PERSON_ID", unique = true, nullable = false, updatable = false)
	private Long id;

	@Column(name = "PERSON_NAME")
	private String name;

	@Column(name = "PERSON_AGE")
	private Integer age;

}
