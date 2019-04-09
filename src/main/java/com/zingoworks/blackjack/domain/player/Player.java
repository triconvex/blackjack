package com.zingoworks.blackjack.domain.player;

import com.zingoworks.blackjack.domain.Hand;
import com.zingoworks.blackjack.domain.card.Card;
import com.zingoworks.blackjack.domain.Chip;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;

import static com.zingoworks.blackjack.domain.HandType.BLACKJACK;
import static com.zingoworks.blackjack.domain.HandType.BURST;

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

    public void betChip(int amount) {
        this.chip = this.chip.subtract(amount);
    }

    @Override
    public void initialize() {
        this.hand = new Hand();
    }

    @Override
    public void draw(Card card) {
        this.hand.receiveCard(card);
    }

    @Override
    public boolean isBurst() {
        return this.hand.getHandType().equals(BURST);
    }

    @Override
    public boolean isBlackjack() {
        return this.hand.getHandType().equals(BLACKJACK);
    }
}
