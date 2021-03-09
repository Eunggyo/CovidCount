package com.aiden.covidcount;

import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class ParsingTool {
    public static void parseXml(InputStream is) {
        Log.e("KEG","parseXml");
        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(is);
            document.getDocumentElement().normalize();
            Element element = document.getDocumentElement();    //루트 엘리먼트 구함

            Log.e("KEG","name = "+ element.getNodeName());
            NodeList items = document.getElementsByTagName("response");
            Log.e("KEG","length = " +items.getLength());
            Node item = items.item(1);
            Node text=item.getFirstChild();
            Log.e("KEG","text = "+ text.getNodeValue());

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(is!=null) {

        }
    }

}

