package edu.hneu.mjt.kuznecsemen;

public class CreditBankCard extends BankCard {
    public CreditBankCard(String number, User user) {
        super(number, user, BankCardType.CREDIT);
    }
}
