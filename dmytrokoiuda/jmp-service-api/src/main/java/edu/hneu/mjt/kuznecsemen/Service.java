package edu.hneu.mjt.kuznecsemen;

import java.util.List;
import java.util.Optional;

public interface Service {
    void subscribe(BankCard bankCard);
    Optional<Subscription> getSubscriptionByBankCardNumber(String bankCardNumber);
    List<User> getAllUsers();
}
