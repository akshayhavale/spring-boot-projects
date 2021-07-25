package com.example.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORY_DESCRIPTION")
public class CategoryDescription extends Description {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4690759978106862077L;

	@Column(name = "CATEGORY_NAME")
	private String categoryName;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CATEGORY_ID")
	private Category category;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
