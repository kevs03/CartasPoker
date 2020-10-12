package com.kevin;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;//recive una llave y un valor
import java.util.Map;

public class Deck {
    //guardar los palos
    private HashMap<String,String> palos = new HashMap<String, String>();
    //guardar los decks
    private ArrayList<Card> juego = new ArrayList<Card>();
    //formato String para mostrar las cartas que quedan
    private String strFormat = "Quedan %s";

    public ArrayList<Card> getJuego() {
        return juego;
    }

    //hay 52 cartas en total, 26 negras y 26 rojas, cada palo tiene 13 cartas
    public void initPalos(){
        palos.put("Diamante","Rojo");
        palos.put("Trebol","Negro");
        palos.put("Pica","Negro");
        palos.put("Corazon","Rojo");
    }

    public void init(){//
        for (Map.Entry<String,String> palo:palos.entrySet()){
            for (int i = 1;i <= 13;i++){
                Card card = new Card(palo.getKey(), palo.getValue());
                card.setValor(i);
                juego.add(card);
            }
        }
    }

    public void shuffle(){//revuelve el mazo
        Collections.shuffle(juego);
        System.out.println("Se mezcló el Deck");
    }

    public void head(){//primera carta que existe y se saca
        var card = juego.get(juego.size()-1);
        juego.remove(card);
        System.out.println(card.toString());
        System.out.println(String.format(strFormat,juego.size()));
    }

    public void pick(){//agarras una carta random
        var card = randomCard();
        juego.remove(card);
        System.out.println(card.toString());
        System.out.println(String.format(strFormat,juego.size()));
    }

    public void hand(){//tomar 5 cartas
        if(juego.size() <= 5){
            for (var card:juego){
                printHand(juego);
            }
        }
        else {
            var cards = new ArrayList<Card>();
            Card card;
            for (int i = 1;i <= 5;i++){
                card = randomCard();
                juego.remove(card);
                cards.add(card);
            }
            printHand(cards);
            System.out.println(String.format(strFormat,juego.size()));
        }
    }

    private void printHand(ArrayList<Card> cards){
        for (var card: cards) System.out.println(card.toString());
    }

    private Card randomCard(){
        var rnd = (int)Math.floor(Math.random() * (1 - juego.size() + 1) + juego.size());
        return juego.get(rnd);
    }
}
