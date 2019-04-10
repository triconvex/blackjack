package com.zingoworks.blackjack.domain;

import com.zingoworks.blackjack.domain.card.Card;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

import static com.zingoworks.blackjack.domain.HandType.*;

@ToString
public class Hand {
    public static final int BLACKJACK_NUMBER = 21;
    public static final int ACE_RULE_NUMBER = 10;

    private List<Card> hand = new ArrayList<>();

    public void receiveCard(Card card) {
        this.hand.add(card);
    }

    public int getTotal() {
        int sum = hand.stream().mapToInt(Card::getNumber).sum();
        return (hasAce() && sum + ACE_RULE_NUMBER < BLACKJACK_NUMBER)
                ? sum + ACE_RULE_NUMBER
                : sum;
    }

    public HandType getHandType() {
        int total = getTotal();
        if (total == BLACKJACK_NUMBER) {
            return BLACKJACK;
        }
        if (total > BLACKJACK_NUMBER) {
            return BURST;
        }
        return NORMAL;
    }

    private boolean hasAce() {
        for (Card card : hand) {
            if (card.isAce()) {
                return true;
            }
        }

        return false;
    }
}
