package edu.hneu.mjt.kuznecsemen;

import java.time.LocalDate;

public record User (
    String name,
    String surname,
    LocalDate birthday
) {}
