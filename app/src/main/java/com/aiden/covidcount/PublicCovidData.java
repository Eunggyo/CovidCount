package com.aiden.covidcount;

import android.os.AsyncTask;
import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOError;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/*
    네트워크에 접속해 공공 데이터를 가져오는 클래스.
    네트워크 접속은 UI 스레드에서 할 수 없기에 AsyncTask에서 실행.
 */
public class PublicCovidData extends AsyncTask {
    private DocumentBuilderFactory mDBFactory = null;
    private DocumentBuilder mDocumentBuilder = null;
    private Document mDocument = null;
    private Element mElement = null;
    private NodeList mParsingTag = null;
    private Node mNode = null;
    @Override
    protected Object doInBackground(Object[] objects) {
        parseData();
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
    }

    @Override
    protected void onProgressUpdate(Object[] values) {
        super.onProgressUpdate(values);
    }

    public void parseData() {
        mDBFactory = DocumentBuilderFactory.newInstance();

        try {
            mDocumentBuilder = mDBFactory.newDocumentBuilder();

            mElement = mDocument.getDocumentElement();
            mParsingTag = mElement.getElementsByTagName("deathCnt");
            Log.e("KEG","mParsingTag length = "+ mParsingTag.getLength());
        }catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        }
    }
}
