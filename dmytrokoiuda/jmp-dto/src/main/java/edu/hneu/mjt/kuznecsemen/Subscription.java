package edu.hneu.mjt.kuznecsemen;

import java.time.LocalDate;

public record Subscription(
        String bankcard,
        LocalDate startDate
) { }
