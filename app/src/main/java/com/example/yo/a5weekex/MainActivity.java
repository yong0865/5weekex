package com.example.yo.a5weekex;

import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1, b2, b3, b4,b5,b6,b7,b8;
    EditText e1, e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        b4 = (Button) findViewById(R.id.b4);
        b5 = (Button) findViewById(R.id.b5);
        b6 = (Button) findViewById(R.id.b6);
        b7 = (Button) findViewById(R.id.b7);
        b8 = (Button) findViewById(R.id.b8);
        e1 = (EditText) findViewById(R.id.e1);
        e2 = (EditText) findViewById(R.id.e2);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b1:
                Toast.makeText(getApplicationContext(), "일반 메세지 창", Toast.LENGTH_SHORT).show();
                break;

            case R.id.b2:
                String x = e1.getText().toString();
                String y = e2.getText().toString();
                Toast toastView2 = Toast.makeText(getApplicationContext(), "위치 지정 메세지 창입니다.",
                        Toast.LENGTH_SHORT);
                toastView2.setGravity(Gravity.LEFT | Gravity.TOP, Integer.parseInt(x) , Integer.parseInt(y));
                toastView2.show();
                break;

            case R.id.b3:
                View view = getLayoutInflater().inflate(R.layout.mytoast,null);

                TextView textView3 = (TextView)view.findViewById((R.id.textView3));
                textView3.setText("레이아웃으로 만든 토스트 창입니다.");

                Toast toastView3 = new Toast(this);
                toastView3.setDuration(Toast.LENGTH_SHORT);
                toastView3.setGravity(Gravity.CENTER,0,100);
                toastView3.setView(view);
                toastView3.show();
                break;

            case R.id.b4:
                Snackbar.make(v,"Message",1000).setAction("확인", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).show();
                break;
            case R.id.b5:
                AlertDialog.Builder dig = new AlertDialog.Builder(this);

                dig.setTitle("제목").setMessage("내용").setIcon(R.mipmap.ic_launcher)
                        .setPositiveButton("닫기",null)
                        .setNegativeButton("확인",null);
                        dig.show();
                break;
            case R.id.b6:




                break;
            case R.id.b7:
                AlertDialog.Builder dig2 = new AlertDialog.Builder(this);
                final String data[] = {"치킨","피자","짜장","탕수"};
                final boolean checked[] = {true, false,true,false};
                dig2.setTitle("먹고싶은 메뉴")
                        .setMultiChoiceItems(data, checked, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                checked[which] = isChecked;
                            }
                        })
                        .setIcon(R.mipmap.ic_launcher)
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String print="" ;
                                for(int i = 0 ; i <data.length ;i++){
                                    if(checked[i] == true){
                                        print = print +","+data[i] ;
                                    }
                                }
                                Toast.makeText(getApplicationContext(), print +"체크되었습니다", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("닫기",null)
                        .show();
                break;
            case R.id.b8:
                View digview = View.inflate(this,R.layout.mytoast,null);
                final EditText e4 = (EditText)digview. findViewById(R.id.e4);

                AlertDialog.Builder dig4 = new AlertDialog.Builder(this);

                dig4.setTitle("먹고싶은메뉴는?")
                        .setView(digview)
                        .setMessage("내용").setIcon(R.mipmap.ic_launcher)
                        .setPositiveButton("닫기",null)
                        .setNegativeButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                dig4.show();
                break;

        }
    }

}
