package ru.sstu.lessons.lesson17.sax;

import jdk.internal.org.xml.sax.Attributes;
import jdk.internal.org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class UserHandler extends DefaultHandler {
    @Override
    public void startDocument() throws org.xml.sax.SAXException {
        System.out.println("Start parse");
    }

    @Override
    public void endDocument() throws org.xml.sax.SAXException {
        System.out.println("End parse");
    }

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws org.xml.sax.SAXException {
        System.out.println(qName);
        if (qName.equals("user")) {
            String dateCreate = attributes.getValue("datecreate");
            System.out.println(dateCreate);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws org.xml.sax.SAXException {
        System.out.println("/" + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws org.xml.sax.SAXException {
        String str = new String(ch, start, length);
        if (str.trim().equals("")) return;
        System.out.println(str);
    }
}
