package com.carnauba.desconto;

import java.math.BigDecimal;

import com.carnauba.entities.CartItem;

public class CalcularDesconto {

	public Double calcular (CartItem cartItem) {
		
		Desconto desconto = new DescontoValor1k(
				new SemDesconto());
		return desconto.calcular(cartItem);
		
	}
}
