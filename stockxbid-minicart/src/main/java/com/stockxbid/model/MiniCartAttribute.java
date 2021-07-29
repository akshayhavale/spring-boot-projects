package com.stockxbid.model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "MINI_CART_ATTRIBUTE")
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class MiniCartAttribute {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MINI_CART_ATTRIBUTE_ID")
	private Long id;

	@Column(name = "PRICE")
	private BigDecimal price;

	@Column(name = "QUANTITY")
	private int quantity;

	@Column(name = "COLOR_CODE")
	private String colorCode;

	@Column(name = "SIZE_CODE")
	private String sizeCode;

	@Column(name = "IMAGE_URL")
	private String imageUrl;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "MINI_CART_ID")
	private MiniCart miniCart;

}
