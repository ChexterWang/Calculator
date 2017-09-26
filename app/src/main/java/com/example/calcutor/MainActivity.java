package com.example.calcutor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * bug: 1.小數點後按3，出現2999999。
 *      2.操作後不顯示現在數字。
 *      3.
 *      4.
 */

public class MainActivity extends AppCompatActivity {

    private Button btn0, btn1, btn2, btn3, btn4, btn5;
    private Button btn6, btn7, btn8, btn9, btnAdd, btnSub;
    private Button btnTime, btnDiv, btnPt, btnEqu, btnC;
    private TextView disply;
    private double res = 0, res1 = 0, res2 = 0, cnt = 0;
    private int PtCnt = 0, PtNumCnt = 1;
    private String str = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnTime = (Button) findViewById(R.id.btnTime);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnPt = (Button) findViewById(R.id.btnPt);
        btnEqu = (Button) findViewById(R.id.btnEqu);
        btnC = (Button) findViewById(R.id.btnC);
        disply = (TextView) findViewById(R.id.disply);

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
        btnC.setOnClickListener(btnCClicked);
    }

    private View.OnClickListener btn0Clicked = new View.OnClickListener() {
        public void onClick(View v) {
            doCal(PtCnt, 0);
        }
    };
    private View.OnClickListener btn1Clicked = new View.OnClickListener() {
        public void onClick(View v) {
            doCal(PtCnt, 1);
        }
    };
    private View.OnClickListener btn2Clicked = new View.OnClickListener() {
        public void onClick(View v) {
            doCal(PtCnt, 2);
        }
    };
    private View.OnClickListener btn3Clicked = new View.OnClickListener() {
        public void onClick(View v) {
            doCal(PtCnt, 3);
        }
    };
    private View.OnClickListener btn4Clicked = new View.OnClickListener() {
        public void onClick(View v) {
            doCal(PtCnt, 4);
        }
    };
    private View.OnClickListener btn5Clicked = new View.OnClickListener() {
        public void onClick(View v) {
            doCal(PtCnt, 5);
        }
    };
    private View.OnClickListener btn6Clicked = new View.OnClickListener() {
        public void onClick(View v) {
            doCal(PtCnt, 6);
        }
    };
    private View.OnClickListener btn7Clicked = new View.OnClickListener() {
        public void onClick(View v) {
            doCal(PtCnt, 7);
        }
    };
    private View.OnClickListener btn8Clicked = new View.OnClickListener() {
        public void onClick(View v) {
            doCal(PtCnt, 8);
        }
    };
    private View.OnClickListener btn9Clicked = new View.OnClickListener() {
        public void onClick(View v) {
            doCal(PtCnt, 9);
        }
    };
    private View.OnClickListener btnAddClicked = new View.OnClickListener() {
        public void onClick(View v) {
            doPre(str);
            str = "A";
        }
    };
    private View.OnClickListener btnSubClicked = new View.OnClickListener() {
        public void onClick(View v) {
            doPre(str);
            str = "B";
        }
    };
    private View.OnClickListener btnTimeClicked = new View.OnClickListener() {
        public void onClick(View v) {
            doPre(str);
            str = "C";
        }
    };
    private View.OnClickListener btnDivClicked = new View.OnClickListener() {
        public void onClick(View v) {
            doPre(str);
            str = "D";
        }
    };
    private View.OnClickListener btnPtClicked = new View.OnClickListener() {
        public void onClick(View v) {
            PtCnt++;
        }
    };
    private View.OnClickListener btnEquClicked = new View.OnClickListener() {
        public void onClick(View v) {
            doPre(str);
            disply.setText(String.valueOf(res1));
            cnt++;
        }
    };
    private View.OnClickListener btnCClicked = new View.OnClickListener() {
        public void onClick(View v) {
            res = 0;
            res1 = 0;
            res2 = 0;
            cnt = 0;
            PtCnt = 0;
            PtNumCnt = 1;
            str = "";
            disply.setText(String.valueOf(0));
        }
    };

    public void doPre(String str) {
        if (cnt == 0) {
            if (res1 == 0) {
                res1 = res;
                disply.setText(String.valueOf(res));
                res = 0;
            } else {
                res2 = res;
                disply.setText(String.valueOf(res2));
                res = 0;
                if (res2 != 0 || !str.equals("D")) {
                    switch (str) {
                        case ("A"):
                            res1 = res1 + res2;
                            break;
                        case ("B"):
                            res1 = res1 - res2;
                            break;
                        case ("C"):
                            res1 = res1 * res2;
                            break;
                        case ("D"):
                            res1 = res1 / res2;
                            break;
                    }
                }
                else {
                    disply.setText(getText(R.string.imprMove));
                }
            }
        }
    }

    public void doCal(int i, int n) {
        if (cnt == 0) {
            switch (i) {
                case (0):
                    res = res * 10 + n;
                    disply.setText(String.valueOf(res));
                    break;
                case (1):
                    res = res + n * Math.pow(0.1, PtNumCnt);
                    disply.setText(String.valueOf(res));
                    PtNumCnt++;
                    break;
                case (2):
                    disply.setText(getText(R.string.imprMove));
                    break;
            }
        }
    }
}
