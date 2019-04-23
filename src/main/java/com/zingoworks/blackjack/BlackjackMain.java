package com.zingoworks.blackjack;

import com.zingoworks.blackjack.domain.Game;
import com.zingoworks.blackjack.domain.ResultType;
import com.zingoworks.blackjack.domain.player.User;

public class BlackjackMain {

    public static void main(String[] args) {
        User user = new User();
        Game game = new Game(user);

        game.start(500);
        ResultType result = game.play();

        System.out.println(result);
        System.out.println(game.getDealer().getHand().getTotal());
        System.out.println(game.getUser().getHand().getTotal());

        game.close();
    }

}
