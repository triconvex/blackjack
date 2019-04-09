//package com.zingoworks.blackjack.domain.player;
//
//import com.zingoworks.blackjack.domain.Deck;
//

//페어 객체 분리 보류

//public class Pair {
//    private Dealer dealer = new Dealer();
//    private Player player;
//
//    private Pair(Player player) {
//        this.player = player;
//    }
//
//    public static Pair with(Player player) {
//        return new Pair(player);
//    }
//
//    public void generateBasicHand(Deck deck) {
//        this.dealer.draw(deck.pop());
//        this.dealer.draw(deck.pop());
//        this.player.draw(deck.pop());
//        this.player.draw(deck.pop());
//    }
//
//    public boolean isBurst() {
//        return dealer.isBurst() || player.isBurst();
//    }
//
//    public boolean isBlackjack() {
//        return dealer.isBlackjack() || player.isBlackjack();
//    }
//
//}
