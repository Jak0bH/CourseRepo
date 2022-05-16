package com.github.jak0bh.courserepo.design_patterns.creational.abstractfactory;

public class AbstractFactoryDemo {
	public static void main(String[] args) {
		CreditCardFactory factory = CreditCardFactory.getCreditCardFactory(775);
		CreditCard card = factory.getCreditCard(CardType.PLATINUM);
		System.out.println(card.getClass());

		factory = CreditCardFactory.getCreditCardFactory(600);
		CreditCard card2 = factory.getCreditCard(CardType.GOLD);
		System.out.println(card2.getClass());
	}
}