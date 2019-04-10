package com.zingoworks.blackjack.domain.player;

import com.zingoworks.blackjack.domain.Deck;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dealer extends BasePlayer {
    public boolean isDealerWin(Player player) {
        //TODO refactoring
        return getHand().getTotal() > player.getHand().getTotal();
    }

    public boolean isTie(Player player) {
        //TODO refactoring
        return getHand().getTotal() == player.getHand().getTotal();
    }

    public void play(Deck deck) {
        while (getHand().getTotal() < 17) {
            getHand().receiveCard(deck.pop());
        }
    }
}
