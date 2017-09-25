package com.example.calcutor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
        bug:1.小數點還沒做，小數點點兩次也還沒做。
            2.按兩次++會做兩次。
            3.輸入數字不會先顯示。
            4.還沒處理不當操作(/0)。
 */

public class MainActivity extends AppCompatActivity {

    private Button btn0, btn1, btn2, btn3, btn4, btn5;
    private Button btn6, btn7, btn8, btn9, btnAdd, btnSub;
    private Button btnTime, btnDiv, btnPt, btnEqu;
    private TextView disply;
    double res = 0, res1 = 0, res2 = 0, cnt = 0, PtCnt = 0;
    //res為暫時儲存, res1為最終結果, res2存放運算前的數字, cnt為確定equ是否被點
    String str = "";//用以處理運算的前一個運算(doPre(str);)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preparation();
        do{
            Clicked();
        }while(cnt < 1);
    }

    //準備btn被點(?
    public void preparation(){
        btn0 = (Button)findViewById(R.id.btn0);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btn5 = (Button)findViewById(R.id.btn5);
        btn6 = (Button)findViewById(R.id.btn6);
        btn7 = (Button)findViewById(R.id.btn7);
        btn8 = (Button)findViewById(R.id.btn8);
        btn9 = (Button)findViewById(R.id.btn9);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnSub = (Button)findViewById(R.id.btnSub);
        btnTime = (Button)findViewById(R.id.btnTime);
        btnDiv = (Button)findViewById(R.id.btnDiv);
        btnPt = (Button)findViewById(R.id.btnPt);
        btnEqu = (Button)findViewById(R.id.btnEqu);
        disply = (TextView)findViewById(R.id.disply);
    }
    //btn被點(?
    public void Clicked(){
        btn0.setOnClickListener(btn0Clicked);
        btn1.setOnClickListener(btn1Clicked);
        btn2.setOnClickListener(btn2Clicked);
        btn3.setOnClickListener(btn3Clicked);
        btn4.setOnClickListener(btn4Clicked);
        btn5.setOnClickListener(btn5Clicked);
        btn6.setOnClickListener(btn6Clicked);
        btn7.setOnClickListener(btn7Clicked);
        btn8.setOnClickListener(btn8Clicked);
        btn9.setOnClickListener(btn9Clicked);
        btnAdd.setOnClickListener(btnAddClicked);
        btnSub.setOnClickListener(btnSubClicked);
        btnTime.setOnClickListener(btnTimeClicked);
        btnDiv.setOnClickListener(btnDivClicked);
        btnPt.setOnClickListener(btnPtClicked);
        btnEqu.setOnClickListener(btnEquClicked);
    }

    private View.OnClickListener btn0Clicked = new View.OnClickListener(){
        public void onClick(View v){
            doCal(i, 0, str);
        }
    };
    private View.OnClickListener btn1Clicked = new View.OnClickListener(){
        public void onClick(View v){
            doCal(i, 1, str);
        }
    };
    private View.OnClickListener btn2Clicked = new View.OnClickListener(){
        public void onClick(View v){
            doCal(i, 2, str);
        }
    };
    private View.OnClickListener btn3Clicked = new View.OnClickListener(){
        public void onClick(View v){
            doCal(i, 3, str);
        }
    };
    private View.OnClickListener btn4Clicked = new View.OnClickListener(){
        public void onClick(View v){
            doCal(i, 4, str);
        }
    };
    private View.OnClickListener btn5Clicked = new View.OnClickListener(){
        public void onClick(View v){
            doCal(i, 5, str);
        }
    };
    private View.OnClickListener btn6Clicked = new View.OnClickListener(){
        public void onClick(View v){
            doCal(i, 6, str);
        }
    };
    private View.OnClickListener btn7Clicked = new View.OnClickListener(){
        public void onClick(View v){
            doCal(i, 7, str);
        }
    };
    private View.OnClickListener btn8Clicked = new View.OnClickListener(){
        public void onClick(View v){
            doCal(i, 8, str);
        }
    };
    private View.OnClickListener btn9Clicked = new View.OnClickListener(){
        public void onClick(View v){
            doCal(i, 9, str);
        }
    };
    private View.OnClickListener btnAddClicked = new View.OnClickListener(){
        public void onClick(View v){
            doPre(str);
            str = "A";
        }
    };
    private View.OnClickListener btnSubClicked = new View.OnClickListener(){
        public void onClick(View v){
            doPre(str);
            str = "B";
        }
    };
    private View.OnClickListener btnTimeClicked = new View.OnClickListener(){
        public void onClick(View v){
            doPre(str);
            str = "C";
        }
    };
    private View.OnClickListener btnDivClicked = new View.OnClickListener(){
        public void onClick(View v){
            doPre(str);
            str = "D";
        }
    };
    private View.OnClickListener btnPtClicked = new View.OnClickListener(){
        public void onClick(View v){
            PtCnt = 1;
        }
    };
    private View.OnClickListener btnEquClicked = new View.OnClickListener(){
        public void onClick(View v){
            doPre(str);
            disply.setText(String.valueOf(res1));
            cnt++;
        }
    };
    public void doPre(String str){
        if(res1 == 0){
            res1 = res;
            disply.setText(String.valueOf(res));
            res = 0;
        }
        else {
            res2 = res;
            disply.setText(String.valueOf(res2));
            res = 0;
            if (res2 != 0 || str != "D") {
                if (str == "A") {
                    res1 = res1 + res2;
                }
                else if (str == "B") {
                    res1 = res1 - res2;
                }
                else if (str == "C") {
                    res1 = res1 * res2;
                }
                else if (str == "D") {
                    res1 = res1 / res2;
                }
            }
            else{
                disply.setText("Invalid Movement");
            }
        }
    }
    public void doCal(int i, int n, String str){
        if(i < 1 && str == "E"){
            res = res + n*Math.pow(0.1, i);
            disply.setText(String.valueOf(res));
        }
        else if(i < 1 && str != "E"){
            res = res*10 + n;   
            disply.setText(String.valueOf(res));
        }
        else if(i == 1){
            disply.setText("Invalid Movement");
        }
    }
}
