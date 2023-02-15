package br.dev.tsantana.ftcreditcard.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cards")
public class CreditCardResource {

	
	@GetMapping
	private String status() {
		return "Ok";
	}
}
