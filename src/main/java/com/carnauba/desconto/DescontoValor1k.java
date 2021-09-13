package com.carnauba.desconto;

import com.carnauba.entities.CartItem;

public class DescontoValor1k extends Desconto {

	public DescontoValor1k(Desconto proximo) {
		super(proximo);
	}

	@Override
	public Double calcular(CartItem cartItem) {
		

		if(cartItem.getSubTotal() > 100) {
			System.out.println("chegamos aqui" + cartItem.getSubTotal() * 0.1);
			return cartItem.getSubTotal()*0.1;
			
		}
		System.out.println(cartItem.getCart());
		return proximo.calcular(cartItem);
		
	}
	

}
