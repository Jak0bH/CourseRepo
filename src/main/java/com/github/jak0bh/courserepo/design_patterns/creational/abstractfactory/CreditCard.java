package com.github.jak0bh.courserepo.design_patterns.creational.abstractfactory;

public abstract class CreditCard {
	protected int cardNumberLength;
	protected int cscNumber;

	public int getCardNumberLength() {
		return cardNumberLength;
	}

	public void setCardNumberLength(int cardNumberLength) {
		this.cardNumberLength = cardNumberLength;
	}

	public int getCscNumber() {
		return cscNumber;
	}

	public void setCscNumber(int cscNumber) {
		this.cscNumber = cscNumber;
	}
}