package com.zingoworks.blackjack.domain;

import org.junit.Test;

import static com.zingoworks.blackjack.domain.Hand.BLACKJACK_NUMBER;
import static com.zingoworks.blackjack.domain.HandType.*;
import static com.zingoworks.blackjack.domain.card.CardTest.*;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class HandTest {
    public static final Hand BLACKJACK_HAND = new Hand();
    public static final Hand BURST_HAND = new Hand();
    public static final Hand NORMAL_HAND = new Hand();

    static {
        BLACKJACK_HAND.receiveCard(ACE_CLUB);
        BLACKJACK_HAND.receiveCard(TEN_CLUB);

        BURST_HAND.receiveCard(FIVE_CLUB);
        BURST_HAND.receiveCard(TEN_CLUB);
        BURST_HAND.receiveCard(TEN_CLUB);

        NORMAL_HAND.receiveCard(ACE_CLUB);
    }

    @Test
    public void getTotalTest() {
        assertThat(BLACKJACK_HAND.getTotal()).isEqualTo(BLACKJACK_NUMBER);
    }

    @Test
    public void getHandTypeTest() {
        assertThat(BLACKJACK_HAND.getHandType()).isEqualTo(BLACKJACK);
        assertThat(BURST_HAND.getHandType()).isEqualTo(BURST);
        assertThat(NORMAL_HAND.getHandType()).isEqualTo(NORMAL);
    }
}