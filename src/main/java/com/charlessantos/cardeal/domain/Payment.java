package com.charlessantos.cardeal.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.charlessantos.cardeal.domain.enums.StatusPayment;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Payment implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	private Integer status;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="purchase_order_id")
	@MapsId
	private PurchaseOrder purchaseOrder;
	
	public Payment() {}

	public Payment(Integer id, StatusPayment status, PurchaseOrder purchaseOrder) {
		super();
		this.id = id;
		this.status = (status == null) ? null : status.getCode();
		this.purchaseOrder = purchaseOrder; 
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public StatusPayment getStatus() {
		return StatusPayment.toEnum(this.status);
	}

	public void setStatus(StatusPayment status) {
		this.status = status.getCode();
	}

	@JsonIgnore
	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	@JsonIgnore
	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
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
		Payment other = (Payment) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
