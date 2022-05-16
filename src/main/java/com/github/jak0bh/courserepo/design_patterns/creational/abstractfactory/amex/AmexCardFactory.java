package com.github.jak0bh.courserepo.design_patterns.creational.abstractfactory.amex;

import com.github.jak0bh.courserepo.design_patterns.creational.abstractfactory.CardType;
import com.github.jak0bh.courserepo.design_patterns.creational.abstractfactory.CreditCard;
import com.github.jak0bh.courserepo.design_patterns.creational.abstractfactory.CreditCardFactory;
import com.github.jak0bh.courserepo.design_patterns.creational.abstractfactory.Validator;

public class AmexCardFactory extends CreditCardFactory {
	@Override
	public CreditCard getCreditCard(CardType cardType) {
		return switch (cardType) {
			case GOLD -> new AmexGoldCreditCard();
			case PLATINUM -> new AmexPlatinumCreditCard();
		};
	}

	@Override
	public Validator getValidator(CardType cardType) {
		return switch (cardType) {
			case GOLD -> new AmexGoldValidator();
			case PLATINUM -> new AmexPlatinumValidator();
		};
	}
}