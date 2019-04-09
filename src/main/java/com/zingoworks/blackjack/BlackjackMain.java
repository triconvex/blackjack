package com.zingoworks.blackjack;

import com.zingoworks.blackjack.domain.Game;
import com.zingoworks.blackjack.domain.player.Player;

public class BlackjackMain {
    public static void main(String[] args) {
        Player player = new Player();
        Game game = new Game(player);

        game.start(500);
        System.out.println(game.getPlayer().getHand());
    }
}
