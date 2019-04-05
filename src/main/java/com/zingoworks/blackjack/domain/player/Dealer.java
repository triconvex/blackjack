package com.zingoworks.blackjack.domain.player;

import com.zingoworks.blackjack.domain.card.Card;
import com.zingoworks.blackjack.domain.HandType;

import java.util.ArrayList;
import java.util.List;

public class Dealer implements BlackjackPlayer{
    private List<Card> hand = new ArrayList<>();

    @Override
    public void initialize() {
        this.hand = new ArrayList<>();
    }

    @Override
    public void draw(Card newCard) {
        this.hand.add(newCard);
    }

    @Override
    public HandType getHandType() {
        return null;
    }
}
