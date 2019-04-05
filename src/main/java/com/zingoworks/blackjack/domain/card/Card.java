package com.zingoworks.blackjack.domain.card;

import java.util.Objects;

public class Card {
    private final Suit suit;
    private final String name;

    private Card(Suit suit, int number) {
        if(suit == null || number < 1 || number > 13) {
            throw new IllegalArgumentException("잘못 된 카드 정보입니다.");
        }

        this.suit = suit;
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
