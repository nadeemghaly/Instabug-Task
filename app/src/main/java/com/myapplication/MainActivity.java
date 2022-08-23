package com.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.instabug.library.Instabug;
import com.instabug.library.invocation.InstabugInvocationEvent;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Button buttonMinus1;
    Button buttonTimes2;
    Button buttonPlus5;
    TextView txtView;

    private int score=0;

    public void add5(View view){
        score+=5;
        txtView.setText(""+score);
    }
    public void minus1(View view){
        score-=2;
        txtView.setText(""+score);
    }
    public void times2(View view){
        score=score*2;
        txtView.setText(""+score);
    }
    public void sendMessage(View view) {
        Instabug.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        score =0;

        new Instabug.Builder(this.getApplication(), "e07bda2c6662b8c9439b79127cc7f165")
                .setInvocationEvents(InstabugInvocationEvent.NONE)
                .build();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonMinus1 = (Button)findViewById(R.id.button5);
        buttonTimes2 = (Button)findViewById(R.id.button4);
        buttonPlus5 = (Button)findViewById(R.id.button3);
        txtView = (TextView) findViewById(R.id.textView25);

        buttonMinus1.setOnClickListener(this::minus1);
        buttonTimes2.setOnClickListener(this::times2);
        buttonPlus5.setOnClickListener(this::add5);

    }
}