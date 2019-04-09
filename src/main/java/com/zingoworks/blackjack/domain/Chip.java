package com.zingoworks.blackjack.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Chip {
    private int amount;

    public Chip(int amount) {
        this.amount = amount;
    }
}
