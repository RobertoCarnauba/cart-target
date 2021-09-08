package com.carnauba.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Cart implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyy-MM-dd'T'HH:mm:ss'Z'",timezone = "GMT")
	private Instant moment;

	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	private Integer quantity;
	
	@OneToMany(mappedBy = "id.cart")
	private Set<CartItem> itens = new HashSet<>();
	
	private Double total;

	public Cart(Long id, Instant moment, User user, Integer quantity, Double total) {
		super();
		this.id = id;
		this.moment = moment;
		this.user = user;
		this.quantity = quantity;
		this.total = total;
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getQtd() {
		Integer qtds = 0;
		for(CartItem x : itens) {
			qtds += x.getQuantity();
		}
		
		return qtds;
	}

	public void setQtd(Integer quantity) {
		this.quantity = quantity;
	}


	public void setTotal(Double total) {
		this.total = total;
	}

	
	public Set<CartItem> getItems(){
		return itens;
	}
	
	public Double getTotal() {
		double sum = 0.0;
		for(CartItem x : itens) {
			sum += x.getSubTotal();
		}
		
		return sum;
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
		Cart other = (Cart) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", moment=" + moment + ", user=" + user + ", quantity=" + quantity + ", total=" + total
				+  "]";
	}

	

	

	// Calcular desconto
	// Valor com desconto

}
