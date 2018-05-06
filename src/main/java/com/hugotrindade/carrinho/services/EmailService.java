package com.hugotrindade.carrinho.services;

import org.springframework.mail.SimpleMailMessage;

import com.hugotrindade.carrinho.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido pedido);
	
	void sendEmail(SimpleMailMessage msg);
}
