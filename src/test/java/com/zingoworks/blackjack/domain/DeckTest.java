package com.zingoworks.blackjack.domain;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeckTest {
    private static final Logger log = LoggerFactory.getLogger(DeckTest.class);

    @Test
    public void size() {
        Deck sampleDeck = Deck.newInstance();

        try {
            for (int i = 1; i < 100 ; i++) {
                log.debug("{} 번째 카드 : {}", i, sampleDeck.pop());
            }
        } catch(Exception e) {
            log.debug(e.getMessage());
        }
    }
}