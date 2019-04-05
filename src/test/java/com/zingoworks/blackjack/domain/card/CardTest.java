package com.zingoworks.blackjack.domain.card;

import org.junit.Test;

import static com.zingoworks.blackjack.domain.card.Suit.CLUB;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class CardTest {
    public static final Card ACE_CLUB = Card.of(CLUB, 1);
    public static final Card FIVE_CLUB = Card.of(CLUB, 5);
    public static final Card TEN_CLUB = Card.of(CLUB, 10);

    @Test
    public void isAceTest() {
        assertThat(ACE_CLUB.isAce()).isTrue();
    }
}