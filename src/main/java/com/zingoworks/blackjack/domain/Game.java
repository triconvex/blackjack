package com.zingoworks.blackjack.domain;

import com.zingoworks.blackjack.domain.player.Dealer;
import com.zingoworks.blackjack.domain.player.Player;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import static com.zingoworks.blackjack.domain.ResultType.*;

@Slf4j
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Game {
    public static final int ZERO = 0;

    private Dealer dealer = new Dealer();
    private Player player;
    private Chip bet = new Chip(ZERO);
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

    public ResultType play() {
        if(isBlackjack()) {
            if(dealer.isTie(player)) {
                log.debug("*** 둘 다 블랙잭");
                return TIE;
            }

            log.debug("*** 블랙잭");
            return dealer.isDealerWin(player) ? PLAYER_LOSE : PLAYER_WIN;
        }

        dealer.play(deck);

        //플레이어 턴 실행

        if(dealer.isTie(player)) {
            log.debug("*** 무승부");
            return TIE;
        }

        if(dealer.isBurst() && player.isBurst()) {
            log.debug("*** 둘다 버스트");
            return PLAYER_LOSE;
        }

        if(player.isBurst()) {
            log.debug("*** 플레이어 버스트");
            return PLAYER_LOSE;
        }

        if(dealer.isBurst()) {
            log.debug("*** 딜러 버스트");
            return PLAYER_WIN;
        }

        return dealer.isDealerWin(player) ? PLAYER_LOSE : PLAYER_WIN;
    }

    public void close() {
        this.bet = new Chip(ZERO);
        this.dealer.initialize();
        this.player.initialize();
        this.deck = Deck.newInstance();
    }

    public boolean isBlackjack() {
        return dealer.isBlackjack() || player.isBlackjack();
    }
}