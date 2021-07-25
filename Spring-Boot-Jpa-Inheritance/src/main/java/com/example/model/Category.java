package com.example.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.example.auditable.AuditListner;
import com.example.auditable.AuditSection;
import com.example.auditable.Auditable;

@Entity
@EntityListeners(value = AuditListner.class)
@Table(name = "CATEGORY")
public class Category extends BaseEntity<Long, Category> implements Auditable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8354191426794481124L;

	@Id
	@Column(name = "CATEGORY_ID", unique = true, nullable = false)
	@TableGenerator(name = "TABLE_GEN", table = "SM_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "CATEGORY_SEQ_NEXT_VAL")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
	private Long id;

	@Embedded
	private AuditSection auditSection = new AuditSection();

	@Column(name = "CODE")
	private String code;

	@Column(name = "DEPTH")
	private Integer depth;

	@Column(name = "LINEAGE")
	private String lineage;

	@OneToMany(mappedBy = "parent", cascade = CascadeType.REMOVE)
	private List<Category> categories = new ArrayList<Category>();

	@ManyToOne
	@JoinColumn(name = "PARENT_ID")
	private Category parent;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "category")
	private CategoryDescription categoryDescription;

	@Override
	public AuditSection getAuditSection() {
		return this.auditSection;
	}

	@Override
	public void setAuditSection(AuditSection auditSection) {
		this.auditSection = auditSection;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getDepth() {
		return depth;
	}

	public void setDepth(Integer depth) {
		this.depth = depth;
	}

	public String getLineage() {
		return lineage;
	}

	public void setLineage(String lineage) {
		this.lineage = lineage;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}

	public CategoryDescription getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(CategoryDescription categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

}
