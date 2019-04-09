package com.zingoworks.blackjack.domain.player;

import com.zingoworks.blackjack.domain.Hand;
import com.zingoworks.blackjack.domain.card.Card;
import com.zingoworks.blackjack.domain.HandType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Dealer implements BlackjackPlayer{
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
    public HandType getHandType() {
        return this.hand.getHandType();
    }
}
