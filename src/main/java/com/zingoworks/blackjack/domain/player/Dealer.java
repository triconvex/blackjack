package com.zingoworks.blackjack.domain.player;

import com.zingoworks.blackjack.domain.Deck;
import com.zingoworks.blackjack.domain.Hand;
import com.zingoworks.blackjack.domain.card.Card;
import lombok.Getter;
import lombok.Setter;

import static com.zingoworks.blackjack.domain.HandType.BLACKJACK;
import static com.zingoworks.blackjack.domain.HandType.BURST;

@Getter
@Setter
public class Dealer extends BasePlayer {
    private Hand hand = new Hand();

    public boolean isDealerWin(Player player) {
        //TODO refactoring
        return this.hand.getTotal() > player.getHand().getTotal();
    }

    public boolean isTie(Player player) {
        //TODO refactoring
        return this.hand.getTotal() == player.getHand().getTotal();
    }

    public void play(Deck deck) {
        while (hand.getTotal() < 17) {
            hand.receiveCard(deck.pop());
        }
    }
}
