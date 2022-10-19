package com.example.gamepolechudec;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.Arrays;
import java.util.Random;

public class GameActivity extends AppCompatActivity
{
    char[] charAnswer;
    TextView[] textViewArray;
    String randAnswer;

    int counter;

    String[] questArray;
    String[] answerArray;
    TextView[] textViewPlayerScore;
    Button[]  ButtonsArray;
    String Difficulty;
    Button block ;
    Button blockRoll ;
    String quest;
    int queue = 0;
    int rndquest;


    private int[] numbers = {400,50,300,
            150,22,500,350, 250,
            100,50,183,300,0,200,
            100,450};

    TextView tv;
    int oldDeegre=0;
    int deegre=0;
    ImageView iv;
    static final float FACTION = 11.25f;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);



        Bundle arguments = getIntent().getExtras();

        if(arguments!=null)
        {
             Difficulty  = arguments.get("Difficulty").toString();

        }

        switch(Difficulty)
        {
            case("Легкая"):

               questArray = getResources().getStringArray(R.array.quest_easy);
               answerArray = getResources().getStringArray(R.array.answer_easy);
            break;
            case("Средняя"):

                questArray = getResources().getStringArray(R.array.quest_medium);
                answerArray = getResources().getStringArray(R.array.answer_medium);
                break;
            case("Сложная"):

                questArray = getResources().getStringArray(R.array.quest_hard);
                answerArray = getResources().getStringArray(R.array.answer_hard);
                break;
        }




        Random rnd = new Random();
        rndquest = rnd.nextInt(0 + questArray.length);

        randAnswer = answerArray[rndquest];
        quest =  questArray[rndquest];
        charAnswer =    randAnswer.toCharArray();
        int qty =  charAnswer.length;

        sayQeust();
        setContentView(R.layout.game_layout);
        iv = findViewById(R.id.imageViewField);




        textViewArray = new TextView[]
        {
                    (TextView) findViewById(R.id.textView3),
                    (TextView)findViewById(R.id.textView4),
                    (TextView)findViewById(R.id.textView5),
                    (TextView)findViewById(R.id.textView6),
                    (TextView)findViewById(R.id.textView7),
                    (TextView)findViewById(R.id.textView8),
                    (TextView)findViewById(R.id.textView9),
                    (TextView)findViewById(R.id.textView10),
                    (TextView)findViewById(R.id.textView11),
                    (TextView)findViewById(R.id.textView12),
                    (TextView)findViewById(R.id.textView13),
                    (TextView)findViewById(R.id.textView14),
                    (TextView)findViewById(R.id.textView15),
        };

        textViewPlayerScore = new TextView[]
                {
                        (TextView) findViewById(R.id.scorePlayer1),
                        (TextView)findViewById(R.id.scorePlayer2),
                        (TextView)findViewById(R.id.scorePlayer3),

                };
        textViewPlayerScore[0].setTextColor(getResources().getColor(R.color.red));

        for(int i = 0 ; i<qty ;i++)
        {
            textViewArray[i].setBackgroundColor(getResources().getColor(R.color.white));

            textViewArray[i].setText(Character.toString(charAnswer[i]));

        }




        ButtonsArray =  new Button[]
        {

        (Button)findViewById(R.id.button),
        (Button)findViewById(R.id.button2),
        (Button)findViewById(R.id.button3),
        (Button)findViewById(R.id.button4),
        (Button)findViewById(R.id.button5),
        (Button)findViewById(R.id.button6),
        (Button)findViewById(R.id.button7),
        (Button)findViewById(R.id.button8),
        (Button)findViewById(R.id.button9),
        (Button)findViewById(R.id.button10),

         };
        block = findViewById(R.id.buttonBlock);
        blockRoll = findViewById(R.id.btnBlockRoll);












    }


    public void clickBtn(View view)
    {

        Button btn = findViewById(R.id.button);
        btn.setBackgroundColor(getResources().getColor(R.color.darkgray));
        btn.setClickable(false);

        boolean ifContains = false;
        for(int i = 0 ;i <charAnswer.length;i++)
        {
            if (textViewArray[i].getText().toString().contains(btn.getText().toString()))
            {
                textViewArray[i].setTextColor(getResources().getColor(R.color.black));
                counter++;
                ifContains = true;



                if(counter ==charAnswer.length)
                {
                    endGame();
                }
            }
        }


        if (ifContains == true)
        {
            addScore();
        }
        queueplayer();
        block.setVisibility(View.VISIBLE);



    }


    public void clickBtn2(View view)
    {
        Button btn = findViewById(R.id.button2);
        btn.setBackgroundColor(getResources().getColor(R.color.darkgray));
        btn.setClickable(false);

        boolean ifContains = false;
        for(int i = 0 ;i <charAnswer.length;i++)
        {
            if (textViewArray[i].getText().toString().contains(btn.getText().toString()))
            {
                textViewArray[i].setTextColor(getResources().getColor(R.color.black));
                counter++;
                ifContains = true;



                if(counter ==charAnswer.length)
                {
                    endGame();
                }
            }
        }


        if (ifContains == true)
        {
            addScore();
        }
        queueplayer();
        block.setVisibility(View.VISIBLE);
    }
    public void clickBtn3(View view)
    {
        Button btn = findViewById(R.id.button3);
        btn.setBackgroundColor(getResources().getColor(R.color.darkgray));
        btn.setClickable(false);

        boolean ifContains = false;
        for(int i = 0 ;i <charAnswer.length;i++)
        {
            if (textViewArray[i].getText().toString().contains(btn.getText().toString()))
            {
                textViewArray[i].setTextColor(getResources().getColor(R.color.black));
                counter++;
                ifContains = true;



                if(counter ==charAnswer.length)
                {
                    endGame();
                }
            }
        }


        if (ifContains == true)
        {
            addScore();
        }
        queueplayer();
        block.setVisibility(View.VISIBLE);


    }
    public void clickBtn4(View view)
    {
        Button btn = findViewById(R.id.button4);
        btn.setBackgroundColor(getResources().getColor(R.color.darkgray));
        btn.setClickable(false);

        boolean ifContains = false;
        for(int i = 0 ;i <charAnswer.length;i++)
        {
            if (textViewArray[i].getText().toString().contains(btn.getText().toString()))
            {
                textViewArray[i].setTextColor(getResources().getColor(R.color.black));
                counter++;
                ifContains = true;



                if(counter ==charAnswer.length)
                {
                    endGame();
                }
            }
        }


        if (ifContains == true)
        {
            addScore();
        }
        queueplayer();
        block.setVisibility(View.VISIBLE);



    }
    public void clickBtn5(View view)
    {
        Button btn = findViewById(R.id.button5);
        btn.setBackgroundColor(getResources().getColor(R.color.darkgray));
        btn.setClickable(false);

        boolean ifContains = false;
        for(int i = 0 ;i <charAnswer.length;i++)
        {
            if (textViewArray[i].getText().toString().contains(btn.getText().toString()))
            {
                textViewArray[i].setTextColor(getResources().getColor(R.color.black));
                counter++;
                ifContains = true;



                if(counter ==charAnswer.length)
                {
                    endGame();
                }
            }
        }


        if (ifContains == true)
        {
            addScore();
        }
        queueplayer();
        block.setVisibility(View.VISIBLE);

    }
    public void btnclick6(View view)
    {
        Button btn = findViewById(R.id.button6);
        btn.setBackgroundColor(getResources().getColor(R.color.darkgray));
        btn.setClickable(false);

        boolean ifContains = false;
        for(int i = 0 ;i <charAnswer.length;i++)
        {
            if (textViewArray[i].getText().toString().contains(btn.getText().toString()))
            {
                textViewArray[i].setTextColor(getResources().getColor(R.color.black));
                counter++;
                ifContains = true;



                if(counter ==charAnswer.length)
                {
                    endGame();
                }
            }
        }


        if (ifContains == true)
        {
            addScore();
        }
        queueplayer();
        block.setVisibility(View.VISIBLE);


    }

    public void clickBtn7(View view)
    {
        Button btn = findViewById(R.id.button7);
        btn.setBackgroundColor(getResources().getColor(R.color.darkgray));
        btn.setClickable(false);

        boolean ifContains = false;
        queueplayer();


        for(int i = 0 ;i <charAnswer.length;i++)
        {
            if (textViewArray[i].getText().toString().contains(btn.getText().toString()))
            {
                textViewArray[i].setTextColor(getResources().getColor(R.color.black));
                counter++;
                ifContains = true;



                if(counter ==charAnswer.length)
                {
                    endGame();
                }
            }
        }

        if (ifContains == true)
        {
            addScore();
        }
        block.setVisibility(View.VISIBLE);
    }
    public void clickBtn8(View view)
    {
        Button btn = findViewById(R.id.button8);
        btn.setBackgroundColor(getResources().getColor(R.color.darkgray));
        btn.setClickable(false);
        boolean ifContains = false;
        for(int i = 0 ;i <charAnswer.length;i++)
        {
            if (textViewArray[i].getText().toString().contains(btn.getText().toString()))
            {
                textViewArray[i].setTextColor(getResources().getColor(R.color.black));
                counter++;
                ifContains = true;



                if(counter ==charAnswer.length)
                {
                    endGame();
                }
            }
        }


        if (ifContains == true)
        {
            addScore();
        }
        queueplayer();
        block.setVisibility(View.VISIBLE);
    }
    public void clickBtn9(View view)
    {
        Button btn = findViewById(R.id.button9);
        btn.setBackgroundColor(getResources().getColor(R.color.darkgray));
        btn.setClickable(false);
        boolean ifContains = false;
        for(int i = 0 ;i <charAnswer.length;i++)
        {
            if (textViewArray[i].getText().toString().contains(btn.getText().toString()))
            {
                textViewArray[i].setTextColor(getResources().getColor(R.color.black));
                counter++;
                ifContains = true;



                if(counter ==charAnswer.length)
                {
                    endGame();
                }
            }
        }


        if (ifContains == true)
        {
            addScore();
        }
        queueplayer();
        block.setVisibility(View.VISIBLE);
    }
    public void clickBtn10(View view)
    {
        Button btn = findViewById(R.id.button10);
        btn.setBackgroundColor(getResources().getColor(R.color.darkgray));
        btn.setClickable(false);
        boolean ifContains = false;
        for(int i = 0 ;i <charAnswer.length;i++)
        {
            if (textViewArray[i].getText().toString().contains(btn.getText().toString()))
            {
                textViewArray[i].setTextColor(getResources().getColor(R.color.black));
                counter++;
                ifContains = true;



                if(counter ==charAnswer.length)
                {
                    endGame();
                }
            }
        }


        if (ifContains == true)
        {
            addScore();
        }
        queueplayer();
        block.setVisibility(View.VISIBLE);
    }
    public void clickBtn11(View view)
    {
        Button btn = findViewById(R.id.button11);
        btn.setBackgroundColor(getResources().getColor(R.color.darkgray));
        btn.setClickable(false);
        boolean ifContains = false;
        for(int i = 0 ;i <charAnswer.length;i++)
        {
            if (textViewArray[i].getText().toString().contains(btn.getText().toString()))
            {
                textViewArray[i].setTextColor(getResources().getColor(R.color.black));
                counter++;
                ifContains = true;



                if(counter ==charAnswer.length)
                {
                    endGame();
                }
            }
        }


        if (ifContains == true)
        {
            addScore();
        }
        queueplayer();
        block.setVisibility(View.VISIBLE);
    }
    public void clickBtn12(View view)
    {
        Button btn = findViewById(R.id.button12);
        btn.setBackgroundColor(getResources().getColor(R.color.darkgray));
        btn.setClickable(false);
        boolean ifContains = false;
        for(int i = 0 ;i <charAnswer.length;i++)
        {
            if (textViewArray[i].getText().toString().contains(btn.getText().toString()))
            {
                textViewArray[i].setTextColor(getResources().getColor(R.color.black));
                counter++;
                ifContains = true;



                if(counter ==charAnswer.length)
                {
                    endGame();
                }
            }
        }


        if (ifContains == true)
        {
            addScore();
        }
        queueplayer();
        block.setVisibility(View.VISIBLE);
    }
    public void clickBtn13(View view)
    {
        Button btn = findViewById(R.id.button13);
        btn.setBackgroundColor(getResources().getColor(R.color.darkgray));
        btn.setClickable(false);
        boolean ifContains = false;
        for(int i = 0 ;i <charAnswer.length;i++)
        {
            if (textViewArray[i].getText().toString().contains(btn.getText().toString()))
            {
                textViewArray[i].setTextColor(getResources().getColor(R.color.black));
                counter++;
                ifContains = true;



                if(counter ==charAnswer.length)
                {
                    endGame();
                }
            }
        }


        if (ifContains == true)
        {
            addScore();
        }
        queueplayer();
        block.setVisibility(View.VISIBLE);
    }
    public void clickBtn14(View view)
    {
        Button btn = findViewById(R.id.button14);
        btn.setBackgroundColor(getResources().getColor(R.color.darkgray));
        btn.setClickable(false);
        boolean ifContains = false;
        for(int i = 0 ;i <charAnswer.length;i++)
        {
            if (textViewArray[i].getText().toString().contains(btn.getText().toString()))
            {
                textViewArray[i].setTextColor(getResources().getColor(R.color.black));
                counter++;
                ifContains = true;



                if(counter ==charAnswer.length)
                {
                    endGame();
                }
            }
        }


        if (ifContains == true)
        {
            addScore();
        }
        queueplayer();
        block.setVisibility(View.VISIBLE);
    }
    public void clickBtn15(View view)
    {
        Button btn = findViewById(R.id.button15);
        btn.setBackgroundColor(getResources().getColor(R.color.darkgray));
        btn.setClickable(false);
        boolean ifContains = false;
        for(int i = 0 ;i <charAnswer.length;i++)
        {
            if (textViewArray[i].getText().toString().contains(btn.getText().toString()))
            {
                textViewArray[i].setTextColor(getResources().getColor(R.color.black));
                counter++;
                ifContains = true;



                if(counter ==charAnswer.length)
                {
                    endGame();
                }
            }
        }


        if (ifContains == true)
        {
            addScore();
        }
        queueplayer();
        block.setVisibility(View.VISIBLE);
    }
    public void clickBtn16(View view)
    {
        Button btn = findViewById(R.id.button16);
        btn.setBackgroundColor(getResources().getColor(R.color.darkgray));
        btn.setClickable(false);
        boolean ifContains = false;
        for(int i = 0 ;i <charAnswer.length;i++)
        {
            if (textViewArray[i].getText().toString().contains(btn.getText().toString()))
            {
                textViewArray[i].setTextColor(getResources().getColor(R.color.black));
                counter++;
                ifContains = true;



                if(counter ==charAnswer.length)
                {
                    endGame();
                }
            }
        }


        if (ifContains == true)
        {
            addScore();
        }
        queueplayer();
        block.setVisibility(View.VISIBLE);
    }
    public void clickBtn17(View view)
    {
        Button btn = findViewById(R.id.button17);
        btn.setBackgroundColor(getResources().getColor(R.color.darkgray));
        btn.setClickable(false);
        boolean ifContains = false;
        for(int i = 0 ;i <charAnswer.length;i++)
        {
            if (textViewArray[i].getText().toString().contains(btn.getText().toString()))
            {
                textViewArray[i].setTextColor(getResources().getColor(R.color.black));
                counter++;
                ifContains = true;



                if(counter ==charAnswer.length)
                {
                    endGame();
                }
            }
        }


        if (ifContains == true)
        {
            addScore();
        }
        queueplayer();
        block.setVisibility(View.VISIBLE);
    }
    public void clickBtn18(View view)
    {
        Button btn = findViewById(R.id.button18);
        btn.setBackgroundColor(getResources().getColor(R.color.darkgray));
        btn.setClickable(false);
        boolean ifContains = false;
        for(int i = 0 ;i <charAnswer.length;i++)
        {
            if (textViewArray[i].getText().toString().contains(btn.getText().toString()))
            {
                textViewArray[i].setTextColor(getResources().getColor(R.color.black));
                counter++;
                ifContains = true;



                if(counter ==charAnswer.length)
                {
                    endGame();
                }
            }
        }


        if (ifContains == true)
        {
            addScore();
        }
        queueplayer();
        block.setVisibility(View.VISIBLE);
    }
    public void clickBtn19(View view)
    {
        Button btn = findViewById(R.id.button19);
        btn.setBackgroundColor(getResources().getColor(R.color.darkgray));
        btn.setClickable(false);
        boolean ifContains = false;
        for(int i = 0 ;i <charAnswer.length;i++)
        {
            if (textViewArray[i].getText().toString().contains(btn.getText().toString()))
            {
                textViewArray[i].setTextColor(getResources().getColor(R.color.black));
                counter++;
                ifContains = true;



                if(counter ==charAnswer.length)
                {
                    endGame();
                }
            }
        }


        if (ifContains == true)
        {
            addScore();
        }
        queueplayer();
        block.setVisibility(View.VISIBLE);
    }
    public void clickBtn20(View view)
    {
        Button btn = findViewById(R.id.button20);
        btn.setBackgroundColor(getResources().getColor(R.color.darkgray));
        btn.setClickable(false);
      boolean ifContains = false;
        for(int i = 0 ;i <charAnswer.length;i++)
        {
            if (textViewArray[i].getText().toString().contains(btn.getText().toString()))
            {
                textViewArray[i].setTextColor(getResources().getColor(R.color.black));
                counter++;
                ifContains = true;



                if(counter ==charAnswer.length)
                {
                    endGame();
                }
            }
        }


        if (ifContains == true)
        {
            addScore();
        }
        queueplayer();
        block.setVisibility(View.VISIBLE);
    }
    public void clickBtn21(View view)
    {
        Button btn = findViewById(R.id.button21);
        btn.setBackgroundColor(getResources().getColor(R.color.darkgray));
        btn.setClickable(false);
        queueplayer();
        for(int i = 0 ;i <charAnswer.length;i++)
        {
            if (textViewArray[i].getText().toString().contains(btn.getText().toString()))
            {


                textViewArray[i].setTextColor(getResources().getColor(R.color.black));
                counter++;
                if(counter ==charAnswer.length)
                {
                    endGame();
                }
            }
        }
        block.setVisibility(View.VISIBLE);
    }
    public void clickBtn22(View view)
    {
        Button btn = findViewById(R.id.button22);
        btn.setBackgroundColor(getResources().getColor(R.color.darkgray));
        btn.setClickable(false);
        boolean ifContains = false;
        for(int i = 0 ;i <charAnswer.length;i++)
        {
            if (textViewArray[i].getText().toString().contains(btn.getText().toString()))
            {
                textViewArray[i].setTextColor(getResources().getColor(R.color.black));
                counter++;
                ifContains = true;



                if(counter ==charAnswer.length)
                {
                    endGame();
                }
            }
        }


        if (ifContains == true)
        {
            addScore();
        }
        queueplayer();
        block.setVisibility(View.VISIBLE);
    }
    public void clickBtn23(View view)
    {
        Button btn = findViewById(R.id.button23);
        btn.setBackgroundColor(getResources().getColor(R.color.darkgray));
        btn.setClickable(false);
        boolean ifContains = false;
        for(int i = 0 ;i <charAnswer.length;i++)
        {
            if (textViewArray[i].getText().toString().contains(btn.getText().toString()))
            {
                textViewArray[i].setTextColor(getResources().getColor(R.color.black));
                counter++;
                ifContains = true;



                if(counter ==charAnswer.length)
                {
                    endGame();
                }
            }
        }


        if (ifContains == true)
        {
            addScore();
        }
        queueplayer();
        block.setVisibility(View.VISIBLE);
    }
    public void clickBtn24(View view)
    {
        Button btn = findViewById(R.id.button24);
        btn.setBackgroundColor(getResources().getColor(R.color.darkgray));
        btn.setClickable(false);
        boolean ifContains = false;
        for(int i = 0 ;i <charAnswer.length;i++)
        {
            if (textViewArray[i].getText().toString().contains(btn.getText().toString()))
            {
                textViewArray[i].setTextColor(getResources().getColor(R.color.black));
                counter++;
                ifContains = true;



                if(counter ==charAnswer.length)
                {
                    endGame();
                }
            }
        }


        if (ifContains == true)
        {
            addScore();
        }
        queueplayer();
        block.setVisibility(View.VISIBLE);
    }
    public void clickBtn25(View view)
    {
        Button btn = findViewById(R.id.button25);
        btn.setBackgroundColor(getResources().getColor(R.color.darkgray));
        btn.setClickable(false);
        boolean ifContains = false;
        for(int i = 0 ;i <charAnswer.length;i++)
        {
            if (textViewArray[i].getText().toString().contains(btn.getText().toString()))
            {
                textViewArray[i].setTextColor(getResources().getColor(R.color.black));
                counter++;
                ifContains = true;



                if(counter ==charAnswer.length)
                {
                    endGame();
                }
            }
        }


        if (ifContains == true)
        {
            addScore();
        }
        queueplayer();
        block.setVisibility(View.VISIBLE);
    }
    public void clickBtn26(View view)
    {
        Button btn = findViewById(R.id.button26);
        btn.setBackgroundColor(getResources().getColor(R.color.darkgray));
        btn.setClickable(false);
        boolean ifContains = false;
        for(int i = 0 ;i <charAnswer.length;i++)
        {
            if (textViewArray[i].getText().toString().contains(btn.getText().toString()))
            {
                textViewArray[i].setTextColor(getResources().getColor(R.color.black));
                counter++;
                ifContains = true;



                if(counter ==charAnswer.length)
                {
                    endGame();
                }
            }
        }


        if (ifContains == true)
        {
            addScore();
        }
        queueplayer();
        block.setVisibility(View.VISIBLE);
    }
    public void clickBtn27(View view)
    {
        Button btn = findViewById(R.id.button27);
        btn.setBackgroundColor(getResources().getColor(R.color.darkgray));
        btn.setClickable(false);
        boolean ifContains = false;
        for(int i = 0 ;i <charAnswer.length;i++)
        {
            if (textViewArray[i].getText().toString().contains(btn.getText().toString()))
            {
                textViewArray[i].setTextColor(getResources().getColor(R.color.black));
                counter++;
                ifContains = true;



                if(counter ==charAnswer.length)
                {
                    endGame();
                }
            }
        }


        if (ifContains == true)
        {
            addScore();
        }
        queueplayer();
        block.setVisibility(View.VISIBLE);
    }
    public void clickBtn28(View view)
    {
        Button btn = findViewById(R.id.button28);
        btn.setBackgroundColor(getResources().getColor(R.color.darkgray));
        btn.setClickable(false);
        boolean ifContains = false;
        for(int i = 0 ;i <charAnswer.length;i++)
        {
            if (textViewArray[i].getText().toString().contains(btn.getText().toString()))
            {
                textViewArray[i].setTextColor(getResources().getColor(R.color.black));
                counter++;
                ifContains = true;



                if(counter ==charAnswer.length)
                {
                    endGame();
                }
            }
        }


        if (ifContains == true)
        {
            addScore();
        }
        queueplayer();
        block.setVisibility(View.VISIBLE);
    }
    public void clickBtn29(View view)
    {
        Button btn = findViewById(R.id.button29);
        btn.setBackgroundColor(getResources().getColor(R.color.darkgray));
        btn.setClickable(false);
        boolean ifContains = false;
        for(int i = 0 ;i <charAnswer.length;i++)
        {
            if (textViewArray[i].getText().toString().contains(btn.getText().toString()))
            {
                textViewArray[i].setTextColor(getResources().getColor(R.color.black));
                counter++;
                ifContains = true;



                if(counter ==charAnswer.length)
                {
                    endGame();
                }
            }
        }


        if (ifContains == true)
        {
            addScore();
        }
        queueplayer();
        block.setVisibility(View.VISIBLE);
    }
    public void clickBtn30(View view)
    {
        Button btn = findViewById(R.id.button30);
        btn.setBackgroundColor(getResources().getColor(R.color.darkgray));
        btn.setClickable(false);
        boolean ifContains = false;
        for(int i = 0 ;i <charAnswer.length;i++)
        {
            if (textViewArray[i].getText().toString().contains(btn.getText().toString()))
            {
                textViewArray[i].setTextColor(getResources().getColor(R.color.black));
                counter++;
                ifContains = true;



                if(counter ==charAnswer.length)
                {
                    endGame();
                }
            }
        }


        if (ifContains == true)
        {
            addScore();
        }
        queueplayer();
        block.setVisibility(View.VISIBLE);
    }
    public void clickBtn31(View view)
    {
        Button btn = findViewById(R.id.button31);
        btn.setBackgroundColor(getResources().getColor(R.color.darkgray));
        btn.setClickable(false);
        boolean ifContains = false;
        for(int i = 0 ;i <charAnswer.length;i++)
        {
            if (textViewArray[i].getText().toString().contains(btn.getText().toString()))
            {
                textViewArray[i].setTextColor(getResources().getColor(R.color.black));
                counter++;
                ifContains = true;



                if(counter ==charAnswer.length)
                {
                    endGame();
                }
            }
        }


        if (ifContains == true)
        {
            addScore();
        }
        queueplayer();
        block.setVisibility(View.VISIBLE);
    }
    public void clickBtn32(View view)
    {
        Button btn = findViewById(R.id.button32);
        btn.setBackgroundColor(getResources().getColor(R.color.darkgray));
        btn.setClickable(false);
        boolean ifContains = false;
        for(int i = 0 ;i <charAnswer.length;i++)
        {
            if (textViewArray[i].getText().toString().contains(btn.getText().toString()))
            {
                textViewArray[i].setTextColor(getResources().getColor(R.color.black));
                counter++;
                ifContains = true;



                if(counter ==charAnswer.length)
                {
                    endGame();
                }
            }
        }


        if (ifContains)
        {
            addScore();
        }
        queueplayer();
        block.setVisibility(View.VISIBLE);
    }
    public void clickBtn33(View view)
    {
        Button btn = findViewById(R.id.button33);
        btn.setBackgroundColor(getResources().getColor(R.color.darkgray));
        btn.setClickable(false);
        boolean ifContains = false;
        for(int i = 0 ;i <charAnswer.length;i++)
        {
            if (textViewArray[i].getText().toString().contains(btn.getText().toString()))
            {
                textViewArray[i].setTextColor(getResources().getColor(R.color.black));
                counter++;
                ifContains = true;



                if(counter ==charAnswer.length)
                {
                    endGame();
                }
            }
        }


        if (ifContains == true)
        {
            addScore();
        }
        queueplayer();
        block.setVisibility(View.VISIBLE);
    }

    public void sayQeust()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
        builder.setTitle("Вопрос:")
                .setMessage(quest);

        AlertDialog alert = builder.create();
        alert.show();

    }

    public  void endGame()
    {
        String winner="";
        switch (queue)
        {
            case(0):
                winner = "Победил игрок №1";
                break;
            case(1):
                winner = "Победил игрок №2";
                break;
            case(2):
                winner = "Победил игрок №3";
                    break;

        }


        AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
        builder.setTitle(winner)
                .setPositiveButton("Выйти в меню", new DialogInterface.OnClickListener()
                {

                    @Override
                    public void onClick(DialogInterface dialog, int id)
                    {
                        GameActivity.super.finish();
                        Intent i = new Intent(GameActivity.this, MainActivity.class);
                        startActivity(i);
                    }
                });


        AlertDialog alert = builder.create();
        alert.setCancelable(false);
        alert.setCanceledOnTouchOutside(false);
        alert.show();
    }

    public void btnClickReapeatQeust(View view)
    {
        sayQeust();
    }


    @SuppressLint("ClickableViewAccessibility")
    public void clickRoll(View view)
    {



        iv.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Random rndRoll;
                rndRoll = new Random();
                oldDeegre = deegre % 360;
                deegre = rndRoll.nextInt(3600)+720;

                RotateAnimation rotate = new RotateAnimation(oldDeegre,deegre,RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);

                rotate.setDuration(3600);
                rotate.setFillAfter(true);
                rotate.setInterpolator(new DecelerateInterpolator());

                rotate.setAnimationListener(new Animation.AnimationListener()
                {
                    @Override
                    public void onAnimationStart(Animation animation)
                    {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation)
                    {
                        blockRoll.setVisibility(View.VISIBLE);

                        Toast toast;
                        switch (getResult(360-(deegre % 360)))
                        {
                            case(183):
                                toast = Toast.makeText(getApplicationContext(),
                                        "Выпало: банкротсво"+"\nГоворите букву", Toast.LENGTH_SHORT);
                                textViewPlayerScore[queue].setText(String.valueOf(0));

                                toast.show();

                                break;
                            case(22):

                                toast = Toast.makeText(getApplicationContext(),
                                        "Выпало: x2!"+"\nГоворите букву", Toast.LENGTH_SHORT);
                                toast.show();
                                break;
                            default:
                                toast = Toast.makeText(getApplicationContext(),
                                        "Выпало:"+ getResult(360-(deegre % 360))+"\nГоворите букву", Toast.LENGTH_SHORT);
                                toast.show();
                                break;

                        }

                            block.setVisibility(View.INVISIBLE);

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation)
                    {

                    }


                });
                iv.startAnimation(rotate);



            }
        });

        iv.setOnLongClickListener(new View.OnLongClickListener()
        {
            public boolean onLongClick(View v) {
                final String[] field = {"Первый", "Второй", "Третий"};

                AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
                builder.setTitle("Выберите барабан")
                        .setSingleChoiceItems(field, -1,
                                new DialogInterface.OnClickListener()
                                {
                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int item)
                                    {
                                        switch (field[item])
                                        {
                                            case("Первый"):
                                                iv.setImageResource(R.drawable.field);

                                                break;
                                            case("Второй"):
                                                iv.setImageResource(R.drawable.filed2);
                                                break;
                                            case("Третий"):
                                                iv.setImageResource(R.drawable.filed3);
                                                break;


                                        }




                                    }
                                });



                AlertDialog alert = builder.create();
                alert.show();
                return true;
            }
        });



    }

    private Integer getResult(int deegre)
    {
        int text =0;
        int factor_x = 1;
        int factor_y = 3;
        for(int i =0 ; i <16;i++)
        {
            if(deegre >= (FACTION *factor_x)&& deegre<(FACTION * factor_y))
            {
                text = numbers[i];


            }
            factor_x +=2;
            factor_y +=2;
        }

        if(deegre >= (FACTION * 32) && deegre <360 || deegre >= 0 && deegre <(FACTION *1)) text = numbers[numbers.length -1];
        return text;
    }

    public void queueplayer()
    {
        iv.setClickable(true);
        for(int i =0 ; i< textViewPlayerScore.length;i++)
        {
            textViewPlayerScore[i].setTextColor(getResources().getColor(R.color.black));
        }
        queue++;
        if (queue==3)
        {
            queue=0;
        }
        textViewPlayerScore[queue].setTextColor(getResources().getColor(R.color.red));
        blockRoll.setVisibility(View.INVISIBLE);


    }
    public void addScore()
    {
        int score = Integer.valueOf((String) textViewPlayerScore[queue].getText());

        switch (getResult(360-(deegre % 360)))
        {
            case (22):
                score = score*2;
                break;
            case (183):
                score = 0;
                break;
            default:
                score = score + getResult(360-(deegre % 360));
                break;
        }


        textViewPlayerScore[queue].setText(String.valueOf(score));
        queue--;
    }

    public void clickAnswer(View view)
    {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(GameActivity.this);

        final EditText et = new EditText(GameActivity.this);

        alertDialogBuilder.setView(et);
        alertDialogBuilder.setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id)
            {
                String str = String.valueOf(et.getText().toString());
                if(str.equals(randAnswer))
                {
                    endGame();
                }
                else
                {
                    queueplayer();
                }
            }
        });




        AlertDialog alertDialog = alertDialogBuilder.create();

        alertDialog.show();

    }
}
