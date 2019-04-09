package com.zingoworks.blackjack.domain.player;

import com.zingoworks.blackjack.domain.Deck;
import com.zingoworks.blackjack.domain.Hand;
import com.zingoworks.blackjack.domain.card.Card;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import static com.zingoworks.blackjack.domain.HandType.BLACKJACK;
import static com.zingoworks.blackjack.domain.HandType.BURST;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Dealer implements BlackjackPlayer{
    private Hand hand = new Hand();

    public boolean isDealerWin(Player player) {
        //TODO refactoring
        return this.hand.getTotal() > player.getHand().getTotal();
    }

    public boolean isTie(Player player) {
        //TODO refactoring
        return this.hand.getTotal() == player.getHand().getTotal();
    }

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

    public void play(Deck deck) {
        while(hand.getTotal() < 17) {
            hand.receiveCard(deck.pop());
        }
    }
}
