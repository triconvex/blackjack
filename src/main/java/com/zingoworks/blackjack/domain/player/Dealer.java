package com.zingoworks.blackjack.domain.player;

import com.zingoworks.blackjack.domain.Deck;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dealer extends BasePlayer {
    public boolean isDealerWin(User user) {
        //TODO refactoring
        return getHand().getTotal() > user.getHand().getTotal();
    }

    public boolean isTie(User user) {
        //TODO refactoring
        return getHand().getTotal() == user.getHand().getTotal();
    }

    public void play(Deck deck) {
        while (getHand().getTotal() < 17) {
            getHand().receiveCard(deck.pop());
        }
    }
}
