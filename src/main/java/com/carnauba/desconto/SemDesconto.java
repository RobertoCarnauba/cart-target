package com.carnauba.desconto;

import com.carnauba.entities.CartItem;

public class SemDesconto extends Desconto {

	public SemDesconto() {
		super(null);
	}
	
	@Override
	public Double calcular(CartItem cartItem) {
		return null;
	}

}
