package com.example.alexander.stroud193afirstapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class DrawCardActivity extends AppCompatActivity {

    ArrayList<Card> deck;
    ArrayList<Card> drawn;
    private boolean replacement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_card);
        deck = new ArrayList<Card>();
        drawn = new ArrayList<Card>();
        fillDeck();
        replacement = true;
    }

    public void drawCard(View view) {
        Button pressed = (Button) view;
        ImageView cardPic = (ImageView) findViewById(R.id.currentCardImage);
        Card nextCard;
        int nextImageId;
        if (replacement) {
            int nextCardInt = (int) (Math.random() * 52);
            nextImageId = deck.get(nextCardInt).getImageId();
        } else if(pressed.getText().equals("Reset Deck")) {
            fillDeck();
            nextImageId = R.drawable.deckback;
            pressed.setText("Next Card");
            TextView cardsLeft = (TextView) findViewById(R.id.cardsRemainingText);
            cardsLeft.setText("Cards Remaining: " + deck.size());
        } else {
            int nextCardInt = (int) (Math.random()*deck.size());
            nextCard = deck.get(nextCardInt);
            nextImageId = nextCard.getImageId();
            drawn.add(nextCard);
            deck.remove(nextCardInt);
            TextView cardsLeft = (TextView) findViewById(R.id.cardsRemainingText);
            cardsLeft.setText("Cards Remaining: " + deck.size());
            if(deck.size()==0) {
                pressed.setText("Reset Deck");
            }
        }
        cardPic.setImageResource(nextImageId);
    }

    private void fillDeck() {
        deck.clear();
        deck.add(new Card("hearts","A",R.drawable.ah));
        deck.add(new Card("hearts","2",R.drawable.twoh));
        deck.add(new Card("hearts","3",R.drawable.threeh));
        deck.add(new Card("hearts","4",R.drawable.fourh));
        deck.add(new Card("hearts","5",R.drawable.fiveh));
        deck.add(new Card("hearts","6",R.drawable.sixh));
        deck.add(new Card("hearts","7",R.drawable.sevenh));
        deck.add(new Card("hearts","8",R.drawable.eighth));
        deck.add(new Card("hearts","9",R.drawable.nineh));
        deck.add(new Card("hearts","10",R.drawable.tenh));
        deck.add(new Card("hearts","J",R.drawable.jh));
        deck.add(new Card("hearts","Q",R.drawable.qh));
        deck.add(new Card("hearts","K",R.drawable.kh));
        deck.add(new Card("diamonds","A",R.drawable.ad));
        deck.add(new Card("diamonds","2",R.drawable.twod));
        deck.add(new Card("diamonds","3",R.drawable.threed));
        deck.add(new Card("diamonds","4",R.drawable.fourd));
        deck.add(new Card("diamonds","5",R.drawable.fived));
        deck.add(new Card("diamonds","6",R.drawable.sixd));
        deck.add(new Card("diamonds","7",R.drawable.sevend));
        deck.add(new Card("diamonds","8",R.drawable.eightd));
        deck.add(new Card("diamonds","9",R.drawable.nined));
        deck.add(new Card("diamonds","10",R.drawable.tend));
        deck.add(new Card("diamonds","J",R.drawable.jd));
        deck.add(new Card("diamonds","Q",R.drawable.qd));
        deck.add(new Card("diamonds","K",R.drawable.kd));
        deck.add(new Card("spades","A",R.drawable.as));
        deck.add(new Card("spades","2",R.drawable.twos));
        deck.add(new Card("spades","3",R.drawable.threes));
        deck.add(new Card("spades","4",R.drawable.fours));
        deck.add(new Card("spades","5",R.drawable.fives));
        deck.add(new Card("spades","6",R.drawable.sixs));
        deck.add(new Card("spades","7",R.drawable.sevens));
        deck.add(new Card("spades","8",R.drawable.eights));
        deck.add(new Card("spades","9",R.drawable.nines));
        deck.add(new Card("spades","10",R.drawable.tens));
        deck.add(new Card("spades","J",R.drawable.js));
        deck.add(new Card("spades","Q",R.drawable.qs));
        deck.add(new Card("spades","K",R.drawable.ks));
        deck.add(new Card("clubs","A",R.drawable.ac));
        deck.add(new Card("clubs","2",R.drawable.twoc));
        deck.add(new Card("clubs","3",R.drawable.threec));
        deck.add(new Card("clubs","4",R.drawable.fourc));
        deck.add(new Card("clubs","5",R.drawable.fivec));
        deck.add(new Card("clubs","6",R.drawable.sixc));
        deck.add(new Card("clubs","7",R.drawable.sevenc));
        deck.add(new Card("clubs","8",R.drawable.eightc));
        deck.add(new Card("clubs","9",R.drawable.ninec));
        deck.add(new Card("clubs","10",R.drawable.tenc));
        deck.add(new Card("clubs","J",R.drawable.jc));
        deck.add(new Card("clubs","Q",R.drawable.qc));
        deck.add(new Card("clubs","K",R.drawable.kc));
    }

    public void setWithReplacement(View view) {
        replacement = true;
        fillDeck();
        drawn.clear();
        TextView cardsLeft = (TextView) findViewById(R.id.cardsRemainingText);
        cardsLeft.setText("Cards Remaining: -");
    }

    public void setWithoutReplacement(View view) {
        replacement = false;
        TextView cardsLeft = (TextView) findViewById(R.id.cardsRemainingText);
        cardsLeft.setText("Cards Remaining: " + deck.size());
    }
}
