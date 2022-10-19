package com.example.gamepolechudec;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void clickNewGame(View view)
    {
        final String[] Difficulty = {"Легкая", "Средняя", "Сложная"};

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Выберите сложность")
                .setSingleChoiceItems(Difficulty, -1,
                        new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog,
                                                int item)
                            {
                                String Diff =  Difficulty[item];
                                Intent i = new Intent(MainActivity.this, GameActivity.class);
                                i.putExtra("Difficulty", Diff);
                                startActivity(i);

                            }
                        });



        AlertDialog alert = builder.create();
        alert.show();
    }


    public void clickEnd(View view)
    {
        this.finish();
    }
}
