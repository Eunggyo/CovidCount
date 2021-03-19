package com.aiden.covidcount;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    private Button mConBtn = null;
    private Button mDocumentParseBtn = null;
    private Button mXmlPullParserBtn = null;
    private Button mJsonParseBtn = null;
    private Context mContext = null;

    private HTTPConnection mHttpConnection = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        mConBtn=findViewById(R.id.con_btn);
        mConBtn.setOnClickListener(mConBtnListener);
        mDocumentParseBtn = findViewById(R.id.xml_document_parse_btn);
        mDocumentParseBtn.setOnClickListener(mDocumentParseBtnListener);
        mXmlPullParserBtn = findViewById(R.id.xml_xmlpullparser_parse_btn);
        mXmlPullParserBtn.setOnClickListener(mXmlPullParserBtnListener);
        mJsonParseBtn = findViewById(R.id.json_parse_btn);
        mJsonParseBtn.setOnClickListener(mmJsonParseBtnListener);
        mHttpConnection = new HTTPConnection();

    }

    private View.OnClickListener mConBtnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(mHttpConnection!=null)
                mHttpConnection.execute();
        }
    };

    private View.OnClickListener mDocumentParseBtnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(mContext!=null) {
                InputStream is = ParsingTool.getAssetXml(mContext);
                ParsingTool.parseXml(is);
            }


        }
    };

    private View.OnClickListener mXmlPullParserBtnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    private View.OnClickListener mmJsonParseBtnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
}