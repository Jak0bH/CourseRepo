package com.github.jak0bh.courserepo.design_patterns.creational.abstractfactory;

import com.github.jak0bh.courserepo.design_patterns.creational.abstractfactory.amex.AmexCardFactory;
import com.github.jak0bh.courserepo.design_patterns.creational.abstractfactory.visa.VisaCardFactory;

public abstract class CreditCardFactory {
	public static CreditCardFactory getCreditCardFactory(int creditScore) {
		if (creditScore > 650) {
			return new AmexCardFactory();
		} else {
			return new VisaCardFactory();
		}
	}

	public abstract CreditCard getCreditCard(CardType cardType);

	public abstract Validator getValidator(CardType cardType);
}