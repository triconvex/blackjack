package com.zingoworks.blackjack.domain.player;

import com.zingoworks.blackjack.domain.Hand;
import com.zingoworks.blackjack.domain.HandType;
import com.zingoworks.blackjack.domain.card.Card;
import com.zingoworks.blackjack.domain.Chip;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Player implements BlackjackPlayer{
    public static final int DEFAULT_CHIP_AMOUNT = 2000;

    @Id
    @GeneratedValue
    private long id;

    @Size(min = 2, max = 20)
    @Column(unique = true, nullable = false, length = 20)
    private String userId;

    @Size(min = 4, max = 20)
    @Column(nullable = false, length = 20)
    private String password;

    @Size(min = 2, max = 20)
    @Column(nullable = false, length = 20)
    private String name;

    @Transient
    private Hand hand = new Hand();

    @Transient
    private Chip chip = new Chip(DEFAULT_CHIP_AMOUNT);

    @Override
    public void initialize() {
        this.hand = new Hand();
    }

    @Override
    public void draw(Card card) {
        this.hand.receiveCard(card);
    }

    @Override
    public HandType getHandType() {
        return this.hand.getHandType();
    }
}
