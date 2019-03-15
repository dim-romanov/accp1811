package ru.sstu.lessons.lesson17.sax;

import org.xml.sax.helpers.DefaultHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class UserListHandler extends DefaultHandler {
    private List<User> users = new ArrayList<>();
    private User user;
    private Document document;
    private String open = "";
    private boolean isOpenDoc;

    public List<User> getUsers() {
        return users;
    }


    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws org.xml.sax.SAXException {
        open = qName;
        if (qName.equals("user")) {
            user = new User();
            String dateCreate = attributes.getValue("datecreate");
            System.out.println(dateCreate);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

            try {
                user.setDateCreate(df.parse(dateCreate));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (qName.equals("doc")) {
            document = new Document();
            isOpenDoc = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws org.xml.sax.SAXException {
        if (qName.equals("user")) {
            users.add(user);
            user = null;
        }
        if (qName.equals("doc")) {
            user.addDocument(document);
            document = null;
            isOpenDoc = false;
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws org.xml.sax.SAXException {
        String str = new String(ch, start, length);
        if (str.trim().equals("")) return;
        if (!isOpenDoc) {
            switch (open) {
                case "id":
                    user.setId(Integer.valueOf(str));
                    break;
                case "age":
                    user.setAge(Integer.valueOf(str));
                    break;
                case "name":
                    user.setName(str);
                    break;
                case "salary":
                    user.setSalary(Double.valueOf(str));
                    break;
            }
        }
        if (isOpenDoc) {
            switch (open) {
                case "id":
                    document.setId(Integer.valueOf(str));
                    break;
                case "title":
                    document.setType(str);
                    break;
                case "number":
                    document.setNumber(str);
                    break;
            }
        }
    }
}
