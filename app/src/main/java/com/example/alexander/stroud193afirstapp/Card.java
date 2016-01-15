package com.example.alexander.stroud193afirstapp;

/**
 * Created by Alexander on 1/12/2016.
 */
public class Card {
    private String suit, value;
    private int imageId;
    private boolean color; //true for red, false for black

    public Card(String suit, String value, int imageId){
        this.suit = suit.toUpperCase();
        this.value = value;
        this.imageId = imageId;
        if(this.suit.equals("HEARTS") || this.suit.equals("DIAMONDS")){
            color = true;
        } else color = false;
    }

    public String toString(){
        return value +" - " +suit;
    }

    public boolean getColor(){
        return color;
    }

    public int getImageId() { return imageId; }
}
