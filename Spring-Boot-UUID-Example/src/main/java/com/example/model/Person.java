package com.example.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

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
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator", parameters = {
			@Parameter(name = "uuid_gen_stratergy_class", value = "org.hibernate.id.uuid.CustomerVersionOneStratergy") })
	@Column(name = "PERSON_ID", unique = true, nullable = false, updatable = false)
	private UUID id;

	@Column(name = "PERSON_NAME")
	private String name;

	@Column(name = "PERSON_AGE")
	private Integer age;

}
