package com.example.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "PRODUCT")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRODUCT_ID", unique = true, nullable = false, updatable = false)
	private Long id;

	@Column(name = "PRODUCT_NAME")
	private String name;

	@Embedded
	private Description description = new Description();

}
