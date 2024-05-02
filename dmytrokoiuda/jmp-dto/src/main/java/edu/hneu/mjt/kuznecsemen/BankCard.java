package edu.hneu.mjt.kuznecsemen;

import java.util.Objects;

public abstract class BankCard {
    private final String number;
    private final User user;
    private final BankCardType type;

    public BankCard(
            String number,
            User user,
            BankCardType type
    ) {
        this.number = number;
        this.user = user;
        this.type = type;
    }

    public String number() {
        return number;
    }

    public User user() {
        return user;
    }

    public BankCardType type() {
        return type;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (BankCard) obj;
        return Objects.equals(this.number, that.number) &&
                Objects.equals(this.user, that.user) &&
                Objects.equals(this.type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, user, type);
    }

    @Override
    public String toString() {
        return String.format("BankCard{number='%s', user=%s, type=%s}", number, user.name(), type);
    }

}
