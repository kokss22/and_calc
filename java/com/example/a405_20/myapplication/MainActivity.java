package com.example.a405_20.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Context ctx = MainActivity.this;
        final EditText num = findViewById(R.id.num);
        final TextView result = findViewById(R.id.result);

        // inner class (메모리 리소스를 적게 잡기 위해)
        class Calc{
            private int num,res; // 인스턴스(의) 변수(는 프라이빗으로 변수를 걸어준다.)
            private String op;
            /*public void exe(){
                switch (op){
                    case "+": res = num1 + num2;break;
                    case "-": res = num1 - num2;break;
                    case "*": res = num1 * num2;break;
                    case "/": res = num1 / num2;break;
                }
            }*/

            public void setNum(int num){this.num=num;}
            public int getNum(){return this.num;}
            public void setRes(int res){this.res=res;}
            public int getRes(){return this.res;}
            public void setOp(String op){this.op=op;}
            public String getOp(){return this.op;}
        }

        final Calc calc = new Calc(); // 내부로 접근하는 애들은 밖에서 final을 걸어줘야된다.

        findViewById(R.id.plusBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(num.getText().toString());
                Log.d("입력값1",a+""); // a를 string값으로 바꿔줘야된다.
                calc.setNum(a);
                /*int b = Integer.parseInt(num2.getText().toString());
                Log.d("입력값2",b+"");*/
                calc.setOp("+");
                //calc.exe();
                //int c = calc.getRes();
                //Log.d("결과",c+"");
                //Toast.makeText(ctx,"덧셈 결과 :"+c, Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.minusBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(num.getText().toString());
                Log.d("입력값1",a+"");
                calc.setNum(a);
                calc.setOp("-");
                //calc.exe();
            }
        });
        findViewById(R.id.multiBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(num.getText().toString());
                Log.d("입력값1",a+"");
                calc.setNum(a);
                calc.setOp("*");
                //calc.exe();
            }
        });
        findViewById(R.id.diviBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(num.getText().toString());
                Log.d("입력값1",a+"");
                calc.setNum(a);
                calc.setOp("/");
                //calc.exe();
            }
        });
        findViewById(R.id.equlBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(ctx,"계산 결과 :"+calc.getRes(), Toast.LENGTH_SHORT).show();
                result.setText(calc.getRes()+"");
            }
        });

    }
}
