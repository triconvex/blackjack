package com.zingoworks.blackjack.domain.player;

import com.zingoworks.blackjack.domain.card.Card;
import com.zingoworks.blackjack.domain.Chip;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Player {
    public static final int DEFAULT_CHIP_AMOUNT = 2000;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private List<Card> hand = new ArrayList<>();

    @Transient
    private Chip chip = new Chip(DEFAULT_CHIP_AMOUNT);

}
