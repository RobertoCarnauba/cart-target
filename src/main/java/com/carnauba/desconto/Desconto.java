package com.carnauba.desconto;

import com.carnauba.entities.CartItem;

public abstract class Desconto {

	protected Desconto proximo;

	public Desconto(Desconto proximo) {
		super();
		this.proximo = proximo;
	}
	
	public abstract Double calcular(CartItem cartItem);
}
