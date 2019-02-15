package com.capgemini.annapurna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

//@Controller
public class EWalletController {

	@Autowired
	private RestTemplate restTemplate;

	/*
	 * @RequestMapping("/aa") public String indexForm() { return "index"; }
	 */

	//@RequestMapping("/AddMoneyLink")
	public String depositForm() {
		return "addMoney";
	}

	//@RequestMapping("/AddMoneyForm")
	public String deposit(@RequestParam Integer profileId, @RequestParam Double amount, Model model) {
		restTemplate.put("http://localhost:7979/ewallets/" + profileId + "?currentBalance=" + amount, null);
		model.addAttribute("message", "money added Successfully!");
		return "addMoney";
	}

	//@RequestMapping("/PassMoneyLink")
	public String deductAmount() {
		return "passMoney";
	}

	//@RequestMapping("/passMoneyForm")
	public String deduct(@RequestParam Integer profileId, @RequestParam Double amount, Model model) {
		restTemplate.put("http://localhost:7979/ewallets/" + profileId + "/pay?currentBalance=" + amount, null);
		model.addAttribute("message", "money deducted Successfully!");
		return "addMoney";
	}

	//@RequestMapping("/StatementForm")
	public String statementForm() {
		return "statements";
	}

	//@RequestMapping("/statement/{profileId}")
	public String statement(@RequestParam Integer profileId, Model model) {
		ResponseEntity<List> entity = restTemplate
				.getForEntity("http://localhost:7979/ewallets/statements/" + profileId, List.class);
		model.addAttribute("statements", entity.getBody());
		return "statements";
	}

}
