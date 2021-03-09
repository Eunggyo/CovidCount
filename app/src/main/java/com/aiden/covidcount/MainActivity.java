package com.aiden.covidcount;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mConBtn = null;
    private HTTPConnection mHttpConnection = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mConBtn=findViewById(R.id.con_btn);
        mConBtn.setOnClickListener(mConBtnListener);
        mHttpConnection = new HTTPConnection();
    }

    private View.OnClickListener mConBtnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(mHttpConnection!=null)
                mHttpConnection.execute();
        }
    };
}