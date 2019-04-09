package com.zingoworks.blackjack.domain.player;

import com.zingoworks.blackjack.domain.card.Card;

public interface BlackjackPlayer {

    void initialize();

    void draw(Card card);

    boolean isBurst();

    boolean isBlackjack();
}
