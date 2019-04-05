package com.zingoworks.blackjack.domain.card;

import org.junit.Test;

import static com.zingoworks.blackjack.domain.card.Suit.CLUB;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class CardTest {

    @Test
    public void isAce() {
        Card aceClub = Card.of(CLUB, 1);
        assertThat(aceClub.isAce()).isTrue();
    }
}