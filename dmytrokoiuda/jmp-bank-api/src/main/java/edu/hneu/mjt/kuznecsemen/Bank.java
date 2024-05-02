package edu.hneu.mjt.kuznecsemen;

public interface Bank {
    BankCard createBankCard(User user, BankCardType cardType);
}
