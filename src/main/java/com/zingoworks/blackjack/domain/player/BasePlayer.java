package com.zingoworks.blackjack.domain.player;

import com.zingoworks.blackjack.domain.Hand;
import com.zingoworks.blackjack.domain.card.Card;

import javax.persistence.Transient;

import static com.zingoworks.blackjack.domain.HandType.BLACKJACK;
import static com.zingoworks.blackjack.domain.HandType.BURST;

public class BasePlayer implements BlackjackPlayer {

    @Transient
    private Hand hand = new Hand();

    @Override
    public void initialize() {
        this.hand = new Hand();
    }

    @Override
    public void draw(Card card) {
        this.hand.receiveCard(card);
    }

    @Override
    public boolean isBurst() {
        return this.hand.getHandType().equals(BURST);
    }

    @Override
    public boolean isBlackjack() {
        return this.hand.getHandType().equals(BLACKJACK);
    }

    public Hand getHand() {
        return hand;
    }

}
