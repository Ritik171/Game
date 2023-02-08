package com.example.rockpaperscissor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button button, button2, button3;
    TextView score;
    ImageView imageView2, imageView3;
    int Humanscore, Computerscore=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageView3);

        score = (TextView) findViewById(R.id.score);

        button2.setOnClickListener(new View.OnClickListener(){@Override
        public void onClick(View view){
            imageView3.setImageResource(R.drawable.paper);
             String message= play_turn("paper");
            Toast.makeText(MainActivity.this,message, Toast.LENGTH_SHORT).show();

            score.setText(" score Human: "+ Integer.toString(Humanscore)+"Computer: " + Integer.toString(Computerscore));


        }});

        button.setOnClickListener(new View.OnClickListener(){@Override
        public void onClick(View view){
            imageView2.setImageResource(R.drawable.rock);
            String message=play_turn("rock");
            Toast.makeText(MainActivity.this,message, Toast.LENGTH_SHORT).show();
            score.setText(" score Human: "+ Integer.toString(Humanscore)+"Computer: " + Integer.toString(Computerscore));

        }});

        button3.setOnClickListener(new View.OnClickListener(){@Override
        public void onClick(View view){
            imageView3.setImageResource(R.drawable.scissors);
            String message= play_turn("scissors");
            Toast.makeText(MainActivity.this,message, Toast.LENGTH_SHORT).show();
            score.setText(" score Human: "+ Integer.toString(Humanscore)+"Computer: " + Integer.toString(Computerscore));



        }});




    }
    public String play_turn( String player_choice){
        String computer_choice="";
        Random r = new Random();
        // choose 1  2  or 3
        int computer_choice_number = r.nextInt(3) +1;

        if( computer_choice_number==1){
            computer_choice="rock";
        }else
            if(computer_choice_number==2){
                computer_choice="scissors";
            }else
                if( computer_choice_number==3){
                    computer_choice="paper";
                }

                // set the computer image based on his choice
        if (computer_choice == "rock") {
            imageView2.setImageResource(R.drawable.rock);
        }else
        if (computer_choice == "scissors") {
            imageView2.setImageResource(R.drawable.scissors);
        }else if (computer_choice == "paper") {
            imageView2.setImageResource(R.drawable.paper);
        }

        // computer human and computer choice to determine who wins.
        if ( computer_choice==player_choice ){
            return " Draw. Nobody Won";
        }
        else if (player_choice=="rock" && computer_choice=="scissors"){
            Humanscore++;
            return "Rock crushes Scissors You Win!";
        }
        else if (player_choice=="rock" && computer_choice=="paper"){
            Computerscore++;
            return "paper covers rock. Computer Wins!";
        }
        else if (player_choice=="scissors" && computer_choice=="rock"){
            Computerscore++;
            return "Rock crushes Scissors computer Wins!";
        }
        else if (player_choice=="scissors" && computer_choice=="paper"){
            Humanscore++;
            return "Scissors cuts paper. You Win!";
        }
        else if (player_choice=="paper" && computer_choice=="rock"){
            Humanscore++;
            return "paper covers rock. You Win!";
        }
        else if (player_choice=="paper" && computer_choice=="scissors"){
            Computerscore++;
            return "Scissors cuts paper. Computer Wins!";
        }
        else return " Not Sure";




    }
}