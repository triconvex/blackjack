package com.zingoworks.blackjack;

import com.zingoworks.blackjack.domain.Game;
import com.zingoworks.blackjack.domain.ResultType;
import com.zingoworks.blackjack.domain.player.Player;

public class BlackjackMain {
    public static void main(String[] args) {
        Player player = new Player();
        Game game = new Game(player);

        game.start(500);
        ResultType result = game.play();

        System.out.println(result);
        System.out.println(game.getDealer().getHand().getTotal());
        System.out.println(game.getPlayer().getHand().getTotal());

        game.close();
    }
}
