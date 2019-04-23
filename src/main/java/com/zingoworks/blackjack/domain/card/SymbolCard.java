package com.zingoworks.blackjack.domain.card;

public enum SymbolCard {

    ACE(1),
    JACK(11),
    QUEEN(12),
    KING(13);

    private int number;

    SymbolCard(int number) {
        this.number = number;
    }

    public static SymbolCard of(int number) {
        for (SymbolCard value : SymbolCard.values()) {
            if(value.number == number) {
                return value;
            }
        }

        return null;
    }

}
