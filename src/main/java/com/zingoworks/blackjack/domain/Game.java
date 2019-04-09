package com.zingoworks.blackjack.domain;

import com.zingoworks.blackjack.domain.player.Dealer;
import com.zingoworks.blackjack.domain.player.Player;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Game {
    private Dealer dealer = new Dealer();
    private Player player;
    private Chip bet = new Chip(0);
    private Deck deck = Deck.newInstance();

    private long id;

    public Game(Player player) {
        this.player = player;
    }

    public void start(int amount) {
        this.bet = new Chip(amount * 2);
        this.player.betChip(amount);

        this.dealer.draw(deck.pop());
        this.dealer.draw(deck.pop());
        this.player.draw(deck.pop());
        this.player.draw(deck.pop());
    }


}