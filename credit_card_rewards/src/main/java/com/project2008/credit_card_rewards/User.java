package com.project2008.credit_card_rewards;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotEmpty;

public record User (
    @NotEmpty
    String username,
    String firstName,
    String lastName,
    @Length(min = 8, max = 16)
    String password
) {}