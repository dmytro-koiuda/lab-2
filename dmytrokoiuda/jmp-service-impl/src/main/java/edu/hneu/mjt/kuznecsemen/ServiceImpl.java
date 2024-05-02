package edu.hneu.mjt.kuznecsemen;

import java.time.LocalDate;
import java.util.*;

public class ServiceImpl implements Service {
    private final Map<String, Subscription> subscriptions = new HashMap<>();
    private final List<User> users = new ArrayList<>();

    @Override
    public void subscribe(BankCard bankCard) {
        var subscription = new Subscription(bankCard.number(), LocalDate.now());
        subscriptions.put(bankCard.number(), subscription);
        users.add(bankCard.user());
    }

    @Override
    public Optional<Subscription> getSubscriptionByBankCardNumber(String bankCardNumber) {
        return Optional.ofNullable(subscriptions.get(bankCardNumber));
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }
}
