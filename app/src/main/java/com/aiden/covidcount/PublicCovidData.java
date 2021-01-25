package com.aiden.covidcount;

import android.os.AsyncTask;

import org.w3c.dom.Document;
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
    private NodeList mParsingTag = null;

    @Override
    protected Object doInBackground(Object[] objects) {
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

    private void parseData() {
        mDBFactory = DocumentBuilderFactory.newInstance();

        try {
            mDocumentBuilder = mDBFactory.newDocumentBuilder();
            mDocument = mDocumentBuilder.parse("url");
        }catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }catch (SAXException sae) {
            sae.printStackTrace();
        }
    }
}
