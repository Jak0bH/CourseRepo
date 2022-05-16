package com.github.jak0bh.courserepo.design_patterns.creational.abstractfactory.visa;

import com.github.jak0bh.courserepo.design_patterns.creational.abstractfactory.CreditCard;
import com.github.jak0bh.courserepo.design_patterns.creational.abstractfactory.Validator;

public class VisaValidator implements Validator {
	@Override
	public boolean isValid(CreditCard creditCard) {
		return false;
	}
}