package com.example.tacademy.chattingct;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {

    RadioGroup categoryView;
    EditText inputView;
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    RecyclerView.LayoutManager layoutManager;

    // 시스템으로부터 현재시간(ms) 가져오기
    long now = System.currentTimeMillis();
    // Data 객체에 시간을 저장
    Date date = new Date(now);
    // 각자 사용할 포맷을 정하고 문자열로 만듬.
    SimpleDateFormat sdfNow = new SimpleDateFormat("MM/dd HH:mm:ss");
    String strNow = sdfNow.format(date);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputView = (EditText)findViewById(R.id.edit_input);
        recyclerView = (RecyclerView)findViewById(R.id.container);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        categoryView = (RadioGroup)findViewById(R.id.category);
        myAdapter = new MyAdapter();
        recyclerView.setAdapter(myAdapter);

        Button btn = (Button)findViewById(R.id.btn_insert);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = categoryView.getCheckedRadioButtonId();
                switch (id) {
                    case R.id.radio_receive :
                        ReceiveData rd = new ReceiveData();
                        rd.iconId = R.mipmap.ic_launcher;
                        rd.message = inputView.getText().toString();
                        rd.date = strNow;
                        myAdapter.add(rd);
                        break;
                    case R.id.radio_send :
                        SendData sd = new SendData();
                        sd.iconId = R.mipmap.ic_launcher;
                        sd.message = inputView.getText().toString();
                        sd.date = strNow;
                        myAdapter.add(sd);
                        break;
                }
                inputView.setText("");
            }
        });

    }

}
