package com.carnauba.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.carnauba.entities.pk.CartItemPK;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class CartItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CartItemPK id = new CartItemPK();
	
	private Integer quantity;
	private Double price;
	
	public CartItem() {
		
	}

	public CartItem(Cart cart, Product product, Integer quantity, Double price) {
		super();
		id.setCart(cart);
		id.setProduct(product);
		this.quantity = quantity;
		this.price = price;
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
	
	@JsonProperty(access = Access.WRITE_ONLY)
	public Cart getCart() {
		return id.getCart();
	}
	
	public void setCart(Cart cart) {
		id.setCart(cart);
	}
	
	public Product getProduct() {
		return id.getProduct();
	}
	
	public void setProduct(Product product) {
		id.setProduct(product);
	}
	
	// retorna o subtotal dos itens do carrinho
	public Double getSubTotal() {
		return price * quantity;
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
		CartItem other = (CartItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
