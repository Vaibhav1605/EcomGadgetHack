package com.ecom.ecombackend.modclass;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	
	@NotNull(message="Product Name should not be Empty")
	@NotBlank(message="Product Name should not be Blank")
	private String productName;
	
	@NotNull(message="Product Desc should not be Empty")
	@NotBlank(message="Product Desc should not be Blank")
	private String productDesc;
	
	@NotNull(message="Product Price should not be Empty")
	private double productPrice;
	
	@NotNull(message="Product Stock should not be Empty")
	private double productStock;

	@ManyToOne
	private Category category;

	@Transient
	private MultipartFile productImage;

	@OneToOne(mappedBy = "product")
	private CartItems cartItems;

	public CartItems getCartItems() {
		return cartItems;
	}

	public void setCartItems(CartItems cartItems) {
		this.cartItems = cartItems;
	}

	public MultipartFile getProductImage() {
		return productImage;
	}

	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return this.productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public double getProductStock() {
		return productStock;
	}

	public void setProductStock(double productStock) {
		this.productStock = productStock;
	}

}
