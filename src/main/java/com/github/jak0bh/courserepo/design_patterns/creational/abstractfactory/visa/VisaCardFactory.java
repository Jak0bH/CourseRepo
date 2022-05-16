package com.github.jak0bh.courserepo.design_patterns.creational.abstractfactory.visa;

import com.github.jak0bh.courserepo.design_patterns.creational.abstractfactory.CardType;
import com.github.jak0bh.courserepo.design_patterns.creational.abstractfactory.CreditCard;
import com.github.jak0bh.courserepo.design_patterns.creational.abstractfactory.CreditCardFactory;
import com.github.jak0bh.courserepo.design_patterns.creational.abstractfactory.Validator;

public class VisaCardFactory extends CreditCardFactory {
	@Override
	public CreditCard getCreditCard(CardType cardType) {
		return switch (cardType) {
			case GOLD -> new VisaGoldCreditCard();
			case PLATINUM -> new VisaPlatinumCreditCard();
		};
	}

	public Validator getValidator(CardType cardType) {
		return new VisaValidator();
	}
}