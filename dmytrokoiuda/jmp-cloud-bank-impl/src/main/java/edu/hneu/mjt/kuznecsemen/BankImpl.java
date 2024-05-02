package edu.hneu.mjt.kuznecsemen;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BankImpl implements Bank {
    @Override
    public BankCard createBankCard(User user, BankCardType cardType) {
        switch (cardType) {
            case CREDIT -> {
                return new CreditBankCard(generateCardNumber(), user);
            }
            case DEBIT -> {
                return new DebitBankCard(generateCardNumber(), user);
            }
            default -> {
                return null;
            }
        }
    }

    private String generateCardNumber() {
        Random random = new Random();
        return IntStream.range(0, 19)
                .mapToObj(i -> (i+1) % 5 == 0 && i < 19 && i > 0 ? "-" : String.valueOf(random.nextInt(10)))
                .collect(Collectors.joining());
    }
}
