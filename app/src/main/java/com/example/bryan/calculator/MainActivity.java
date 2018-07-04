package com.example.bryan.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText editLine; TextView resultLine;
    Button btn_div, btn_add, btn_getResult, btn_mul, btn_sub;
    Button btn_cancel;

    String num_first;
    int value;
    int DIVISION=0;
    int ADD=1;
    int MULTI=2;
    int SUB=3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editLine = (EditText)findViewById(R.id.editLine);
        num_first="";
        btn_div = (Button)findViewById(R.id.Btn_div);
        btn_add = (Button)findViewById(R.id.Btn_add);
        btn_getResult = (Button)findViewById(R.id.Btn_getResult);
        btn_mul = (Button)findViewById(R.id.Btn_multi);
        btn_sub = (Button)findViewById(R.id.Btn_sub);

        btn_div.setOnClickListener(calListener);
        btn_add.setOnClickListener(calListener);
        btn_getResult.setOnClickListener(calListener);
        btn_mul.setOnClickListener(calListener);
        btn_sub.setOnClickListener(calListener);

        btn_cancel = (Button)findViewById(R.id.Btn_cancel);
        btn_cancel.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                num_first="";
                editLine.setText("");

            }
        });
    }
    //연산자용 익명내부클래스
    Button.OnClickListener calListener = new Button.OnClickListener(){
        public void onClick(View v){
            switch (v.getId()){
                case R.id.Btn_add:editLine.getText().toString();//첫번째로 입력했던 값들 저장. clear 될거니까.
                    editLine.setText(editLine.getText().toString()+"+");
                    value = ADD;
                    break;
                case R.id.Btn_sub:editLine.getText().toString();
                    editLine.setText(editLine.getText().toString()+"-");
                    value=SUB;
                    break;
                case R.id.Btn_multi:editLine.getText().toString();
                    editLine.setText(editLine.getText().toString()+"*");
                    value=MULTI;
                    break;
                case R.id.Btn_div:editLine.getText().toString();
                    editLine.setText(editLine.getText().toString()+"/");
                    value=DIVISION;
                    break;
                case R.id.Btn_getResult:
                    if (value == MULTI) {
                        editLine.setText("" + (Double.parseDouble(num_first) * Double.parseDouble(editLine.getText().toString())));
                    } else if (value == SUB){
                        editLine.setText("" + (Double.parseDouble(num_first) - Double.parseDouble(editLine.getText().toString())));
                    } else if (value == ADD){
                        editLine.setText("" + (Double.parseDouble(num_first) + Double.parseDouble(editLine.getText().toString())));
                    } else if (value == DIVISION){
                        editLine.setText("" + (Double.parseDouble(num_first) / Double.parseDouble(editLine.getText().toString())));
                    }
                    num_first = editLine.getText().toString(); // 최종 결과값을 가지고, 바로 다음 연산을 가능하게 하도록 number에 들어가 있는 값을 교체해준다.
                    break;
            }
        }
    };
    //숫자입력용
    public void onClick(View v){
        switch(v.getId()){
            case R.id.num0:editLine.setText(editLine.getText().toString()+0);
                break;
            case R.id.num1:editLine.setText(editLine.getText().toString()+1);
                break;
            case R.id.num2:editLine.setText(editLine.getText().toString()+2);
                break;
            case R.id.num3:editLine.setText(editLine.getText().toString()+3);
                break;
            case R.id.num4:editLine.setText(editLine.getText().toString()+4);
                break;
            case R.id.num5:editLine.setText(editLine.getText().toString()+5);
                break;
            case R.id.num6:editLine.setText(editLine.getText().toString()+6);
                break;
            case R.id.num7:editLine.setText(editLine.getText().toString()+7);
                break;
            case R.id.num8:editLine.setText(editLine.getText().toString()+8);
                break;
            case R.id.num9:editLine.setText(editLine.getText().toString()+9);
                break;
        }
    }
}
