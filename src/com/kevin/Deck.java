package com.kevin;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Deck {
    public static HashMap<String, String> palos = new HashMap<>();
    private final ArrayList<Card> juego = new ArrayList<>();

    Deck() {
        palos.put("Diamante", "Rojo");
        palos.put("Trébol", "Negro");
        palos.put("Pica", "Negro");
        palos.put("Corazón", "Rojo");
        init();
    }

    private int randomCard() {
        var max = juego.size() - 1;
        return (int) Math.floor(Math.random() * (-max + 1) + max);
    }

    public void init() {
        if (juego.size() > 1) juego.clear();
        for (Map.Entry<String, String> palo : palos.entrySet()) {
            var paloCard = palo.getKey();
            var color = palo.getValue();
            Card card;
            for (int i = 1; i <= 13; i++) {
                card = new Card(paloCard, color, i);
                juego.add(card);
            }
        }
    }

    public ArrayList<Card> getJuego() {
        return juego;
    }

    public void shuffle() {
        Collections.shuffle(juego);
    }

    public Card head() throws Exception {
        if (juego.isEmpty())
            throw new Exception("Ya no quedan cartas para sacar.");

        return juego.remove(juego.size() - 1);
    }

    public Card pick() throws Exception {
        if (juego.isEmpty())
            throw new Exception("Ya no quedan cartas para sacar.");

        return juego.remove(randomCard());
    }


    public ArrayList<Card> hand() throws Exception {
        var cards = new ArrayList<Card>();

        if (juego.isEmpty()) {
            throw new Exception("Ya no quedan cartas");
        } else if (juego.size() < 5) {
            throw new Exception("No quedan suficientes cartas");
        } else {
            for (int i = 1; i <= 5; i++) {
                cards.add(pick());
            }
        }
        return cards;
    }
}