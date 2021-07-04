package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

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
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
	@TableGenerator(name = "TABLE_GEN", table = "SM_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "PERSON_SEQ_NEXT_VAL")
	@Column(name = "PERSON_ID", unique = true, nullable = false, updatable = false)
	private Long id;

	@Column(name = "PERSON_NAME")
	private String name;

	@Column(name = "PERSON_AGE")
	private Integer age;

}
