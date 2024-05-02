package edu.hneu.mjt.kuznecsemen;

public class DebitBankCard extends BankCard{
    public DebitBankCard(String number, User user) {
        super(number, user, BankCardType.DEBIT);
    }
}
