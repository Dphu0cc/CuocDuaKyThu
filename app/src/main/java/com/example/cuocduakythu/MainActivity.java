package com.example.cuocduakythu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView txtScore;
    SeekBar sbDog;
    SeekBar sbDragon;
    SeekBar sbPikachu;
    CheckBox cbDog;
    CheckBox cbDragon;
    CheckBox cbPikachu;
    ImageButton imvPlay;
    int score = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        txtScore.setText(score+"");

        CountDownTimer countDownTimer = new CountDownTimer(60000, 300) {
            @Override
            public void onTick(long l) {
                int number1 = ranDom();
                int number2 = ranDom();
                int number3 = ranDom();

                // KIEM TRA WIN
                if (sbDragon.getProgress() >= sbDragon.getMax()) {
                    this.cancel();
                    imvPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "One Win", Toast.LENGTH_SHORT).show();
                    // kiem tra dat cuoc
                    if (cbDragon.isChecked()) {
                        score += 10;
                        Toast.makeText(MainActivity.this, "Ban doan chinh xac", Toast.LENGTH_SHORT).show();
                    } else {
                        score -= 5;
                        Toast.makeText(MainActivity.this, "Ban da doan sai", Toast.LENGTH_SHORT).show();
                    }
                    txtScore.setText(score+"");
                }

                if (sbDog.getProgress() >= sbDog.getMax()) {
                    this.cancel();
                    imvPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Two Win", Toast.LENGTH_SHORT).show();
                    if (cbDog.isChecked()) {
                        score += 10;
                        Toast.makeText(MainActivity.this, "Ban doan chinh xac", Toast.LENGTH_SHORT).show();
                    } else {
                        score -= 5;
                        Toast.makeText(MainActivity.this, "Ban da doan sai", Toast.LENGTH_SHORT).show();
                    }
                    txtScore.setText(score+"");
                }

                if (sbPikachu.getProgress() >= sbPikachu.getMax()) {
                    this.cancel();
                    imvPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Three Win", Toast.LENGTH_SHORT).show();
                    if (cbPikachu.isChecked()) {
                        score += 10;
                        Toast.makeText(MainActivity.this, "Ban doan chinh xac", Toast.LENGTH_SHORT).show();
                    } else {
                        score -= 5;
                        Toast.makeText(MainActivity.this, "Ban da doan sai", Toast.LENGTH_SHORT).show();
                    }
                    txtScore.setText(score+"");
                }

                sbDog.setProgress(sbDog.getProgress()+number1);
                sbDragon.setProgress(sbDragon.getProgress()+number2);
                sbPikachu.setProgress(sbPikachu.getProgress()+number3);
            }

            @Override
            public void onFinish() {

            }
        };

        imvPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cbDog.isChecked()||cbDragon.isChecked()||cbPikachu.isChecked()) {

                    sbDog.setProgress(0);
                    sbDragon.setProgress(0);
                    sbPikachu.setProgress(0);
                    imvPlay.setVisibility(View.INVISIBLE);
                    countDownTimer.start();
                } else {
                    Toast.makeText(MainActivity.this,  "Vui long dat cuoc truoc khi choi!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cbDragon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    // bo check 2, 3
                    cbDog.setChecked(false);
                    cbPikachu.setChecked(false);
                }
            }
        });

        cbDog.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    // bo check 2, 3
                    cbDragon.setChecked(false);
                    cbPikachu.setChecked(false);
                }
            }
        });

        cbPikachu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    // bo check 2, 3
                    cbDragon.setChecked(false);
                    cbDog.setChecked(false);
                }
            }
        });
    }

    private void AnhXa() {
        txtScore    = (TextView) findViewById(R.id.score);
        sbDog       = (SeekBar) findViewById(R.id.dog);
        sbDragon    = (SeekBar) findViewById(R.id.dragon);
        sbPikachu   = (SeekBar) findViewById(R.id.pikachu);
        cbDragon    = (CheckBox) findViewById(R.id.checkBox1);
        cbDog       = (CheckBox)  findViewById(R.id.checkBox2);
        cbPikachu   = (CheckBox) findViewById(R.id.checkBox3);
        imvPlay     = (ImageButton) findViewById(R.id.buttonPlay);
    }

    private int ranDom() {
        Random random = new Random();
        return random.nextInt(5)+1;
    }

}