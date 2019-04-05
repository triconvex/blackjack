package com.zingoworks.blackjack.domain;

import com.zingoworks.blackjack.domain.card.Card;
import com.zingoworks.blackjack.domain.card.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> deck = new ArrayList<>();

    private Deck() {
        generateRandomDeck();
    }

    public static Deck newInstance() {
        return new Deck();
    }

    public Card pop() {
        if(deck.size() < 1) {
            throw new IllegalStateException("덱에 남아있는 카드가 없습니다");
        }

        return deck.remove(0);
    }

    private void generateRandomDeck() {
        for (int number = 1; number <= 13; number++) {
            for (Suit suit : Suit.values()) {
                deck.add(Card.of(suit, number));
            }
        }

        Collections.shuffle(deck);
    }
}
