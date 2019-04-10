package com.zingoworks.blackjack.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Embeddable
public class Chip {

    @Column
    private final int amount;

    private Chip() {
        this.amount = 0;
    }

    public Chip(int amount) {
        this.amount = amount;
    }

    public Chip sum(int amount) {
        return new Chip(this.amount + amount);
    }

    public Chip subtract(int amount) {
        if(this.amount - amount < 0) {
            throw new IllegalArgumentException("보유 칩이 부족합니다.");
        }
        return new Chip(this.amount - amount);
    }
}
