package com.zingoworks.blackjack.domain.player;

import com.zingoworks.blackjack.domain.card.Card;
import com.zingoworks.blackjack.domain.HandType;

public interface BlackjackPlayer {

    void initialize();

    void draw(Card card);

    HandType getHandType();
}
