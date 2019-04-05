package com.zingoworks.blackjack.domain.card;

import java.util.Objects;

public class Card {
    public static final int MAX_CARD_NUMBER = 10;
    public static final int MIN_CARD_RANGE = 1;
    public static final int MAX_CARD_RANGE = 13;

    private final Suit suit;
    private final String name;
    private final int number;

    private Card(Suit suit, int number) {
        if(suit == null || number < MIN_CARD_RANGE || number > MAX_CARD_RANGE) {
            throw new IllegalArgumentException("잘못 된 카드 정보입니다.");
        }

        this.suit = suit;
        this.number = convertToValidNumber(number);
        this.name = convertToName(number);
    }

    public static Card of(Suit suit, int value) {
        return new Card(suit, value);
    }

    public boolean isAce() {
        return this.name.equals("ACE");
    }

    private String convertToName(int number) {
        if(SymbolCard.of(number) != null) {
            return SymbolCard.of(number).toString();
        }

        return String.valueOf(number);
    }

    private int convertToValidNumber(int number) {
        if(number > MAX_CARD_NUMBER) {
            return MAX_CARD_NUMBER;
        }

        return number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return suit == card.suit &&
                Objects.equals(name, card.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, name);
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", name='" + name + '\'' +
                '}';
    }
}
