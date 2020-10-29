package com.kevin;

public class Poker {
    private final Deck deck;
    Poker() {
        deck = new Deck();
    }

    private void showSizeDeck(){
        var messageCard = (deck.getJuego().size() > 1)?"cartas":"carta";
        System.out.println(String.format("Quedan %s %s", deck.getJuego().size(), messageCard));
    }

    private void showSelectedCard(Card card){
        var showCard = card.toString();
        System.out.printf("La carta es %s%n", showCard);
    }

    public void shuffle() {
        deck.shuffle();
        System.out.println ("Se revolvió el deck.");
    }

    public void head() throws Exception {
        showSelectedCard(deck.head());
        showSizeDeck();
    }

    public void pick() throws Exception {
        showSelectedCard(deck.pick());
        showSizeDeck();
    }

    public void hand() throws Exception {
        deck.hand().forEach(p -> showSelectedCard(p));
        showSizeDeck();
    }

    public void reset(){
        deck.init();
        deck.shuffle();
        System.out.println("El juego se reinició \n y se revolvió el deck.");
    }
}
