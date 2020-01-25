package com.charlessantos.cardeal.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItemOrder implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private ItemOrderPK id = new ItemOrderPK();
	
	private Double discount;
	private Integer quantity;
	private Double price;

	public ItemOrder() {}

	public ItemOrder(Product product, PurchaseOrder purchaseOrder, Double discount, Integer quantity, Double price) {
		super();
		id.setOrder(purchaseOrder);
		id.setProduct(product);
		this.discount = discount;
		this.quantity = quantity;
		this.price = price;
	}

	public ItemOrderPK getId() {
		return id;
	}

	public void setId(ItemOrderPK itemOrderPK) {
		this.id = itemOrderPK;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	@JsonIgnore
	public PurchaseOrder getPurchaseOrder() {
		return id.getOrder();
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.id.setOrder(purchaseOrder);
	}

	public Product getProduct() {
		return id.getProduct();
	}

	public void setProduct(Product product) {
		this.id.setProduct(product);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemOrder other = (ItemOrder) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
