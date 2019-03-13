package ru.sstu.lessons.lesson16;


import org.w3c.dom.*;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document d = builder.parse("src/ru/sstu/lessons/lesson16/users.xml");//разбор существующего документа


        //изменение данных в теге lang
        NodeList langList = d.getElementsByTagName("lang");
        if (langList.getLength() > 0) {
            Node lang = langList.item(0);
            lang.setTextContent("ru");
        }

        parseUserFromXML(d);
        parseManual(d);


        Document doc = builder.newDocument();//создание нового документа
        createUserManual(doc);

        List<User> users = new ArrayList<>();
        users.add(new User(5, "Masha", 22, 120000));
        users.add(new User(15, "Mash4a", 202, 120000));
        users.add(new User(50, "Mash4a", 202, 10000));
        users.add(new User(55, "Masha4", 22, 120000));
        Element root = doc.createElement("empl");
        for (User u : users) {
            Element userElement = createUserElement(doc, u);
            root.appendChild(userElement);
        }
        doc.appendChild(root);

        //блок сохранения сокумента
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        DOMSource source = new DOMSource(doc);//что сохряняем
        StreamResult result = new StreamResult(new FileOutputStream("user2.xml"));//куда сохраняем
        transformer.transform(source, result);

//        User u = new User("asd", 231, 2432);
//        String s = null;
//        if (u != null) {
//            s = u.getName();
//        }
//        String s1 = (u != null) ? u.getName() : "";


        //пример чтение документа со сторонних ресурсов
        URL url = new URL("http://www.cbr.ru/scripts/XML_daily.asp?date_req=12/03/2019");
        try (InputStream stream = url.openStream()) {
            Document doc1 = builder.parse(stream);
            Element element = doc1.getDocumentElement();
            NodeList list = element.getChildNodes();
            for (int i = 0; i < list.getLength(); i++) {
                Node n = list.item(i);
                System.out.println(n.getNodeName());
                NodeList val = n.getChildNodes();
                for (int j = 0; j < val.getLength(); j++) {
                    Node nn = val.item(j);
                    System.out.println("\t" + nn.getNodeName());
                    System.out.println("\t\t" + nn.getTextContent());
                }
            }
        }

    }

    private static void parseUserFromXML(Document d) throws ParseException {
        ArrayList<User> users = new ArrayList<>();

        Element root = d.getDocumentElement();
        NodeList nodeList = d.getElementsByTagName("user");//поиск узлов по имени тега

        NodeList rootList = root.getChildNodes();//получение дочерних элементов
        for (int i = 0; i < rootList.getLength(); i++) {
            Node user = rootList.item(i);
            if (user.getNodeName().startsWith("#")) continue;
            if (user.getNodeName().equals("user")) {

                User u = new User();

                NamedNodeMap attrs = user.getAttributes();//получение атрибутов узла
                Node dateNode = attrs.getNamedItem("datecreate");

                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date d1 = format.parse(dateNode.getTextContent());
                System.out.println(dateNode.getTextContent());
                u.setDateCreate(d1);

                NodeList userInfoList = user.getChildNodes();//получение дочерних элементов
                for (int j = 0; j < userInfoList.getLength(); j++) {
                    Node userInfo = userInfoList.item(j);
                    if (userInfo.getNodeName().startsWith("#")) continue;

                    if (userInfo.getNodeName().equals("id")) {
                        String idS = userInfo.getTextContent();
                        u.setId(Integer.valueOf(idS));
                    }

                    if (userInfo.getNodeName().equals("name")) {
                        u.setName(userInfo.getTextContent());
                    }

                    if (userInfo.getNodeName().equals("age")) {
                        String s = userInfo.getTextContent();
                        u.setAge(Integer.valueOf(s));
                    }
                    if (userInfo.getNodeName().equals("salary")) {
                        String s = userInfo.getTextContent();
                        u.setSalary(Double.valueOf(s));
                    }


                    if (userInfo.getNodeName().equals("documents")) {
                        user.removeChild(userInfo);
                    }
                }
                users.add(u);
            }
        }
        for (User u : users) {
            System.out.println(u);
        }
    }

    private static void parseManual(Document d) {
        Element root = d.getDocumentElement();
        System.out.println(root.getTagName());
        //    System.out.println(root.getTextContent());

        NodeList rootList = root.getChildNodes();//получение дочерних элементов
        for (int i = 0; i < rootList.getLength(); i++) {
            Node r = rootList.item(i);
            if (r.getNodeName().startsWith("#")) continue;
            System.out.println("\t" + r.getNodeName());
            if (r.getNodeName().equals("lang")) {
                System.out.println("\t\t" + r.getTextContent());
            }
            if (r.getNodeName().equals("user")) {
                NodeList userInfo = r.getChildNodes();//получение дочерних элементов
                for (int j = 0; j < userInfo.getLength(); j++) {
                    Node user = userInfo.item(j);
                    if (user.getNodeName().startsWith("#")) continue;
                    System.out.println("\t\t" + user.getNodeName());
                    if (user.getNodeName().equals("documents")) {
                        NodeList docList = user.getChildNodes();
                        for (int k = 0; k < docList.getLength(); k++) {
                            Node doc = docList.item(k);
                            if (doc.getNodeName().startsWith("#")) continue;
                            System.out.println("\t\t\t" + doc.getNodeName());
                            NodeList docNodeList = doc.getChildNodes();
                            for (int l = 0; l < docList.getLength(); l++) {
                                Node docInfo = docNodeList.item(l);
                                if (docInfo.getNodeName().startsWith("#")) continue;
                                System.out.println("\t\t\t\t" + docInfo.getNodeName());
                                System.out.println("\t\t\t\t\t" + docInfo.getTextContent());

                            }
                        }
                    } else {
                        System.out.println("\t\t\t" + user.getTextContent());
                    }
                }
            }
        }
    }

    /**
     * Создание узла для пользователя
     * @param doc
     * @param user
     * @return
     */
    private static Element createUserElement(Document doc, User user) {
        Element userElement = doc.createElement("user");

        Element idElement = doc.createElement("id");
        idElement.setTextContent(Integer.toString(user.getId()));

        Element nameElement = doc.createElement("name");
        nameElement.setTextContent(user.getName());

        Element ageElement = doc.createElement("age");
        ageElement.setTextContent(Integer.toString(user.getAge()));

        Element salaryElement = doc.createElement("salary");
        salaryElement.setTextContent(Double.toString(user.getSalary()));

        userElement.appendChild(idElement);
        userElement.appendChild(nameElement);
        userElement.appendChild(ageElement);
        userElement.appendChild(salaryElement);

        Date d = new Date();
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MMMM-dd");

        userElement.setAttribute("datecreate", format.format(d));
        return userElement;
    }

    /**
     * Пример создание структуры xml документа
     * @param doc
     */
    private static void createUserManual(Document doc) {
        Element userElement = doc.createElement("user");

        Element idElement = doc.createElement("id");
        idElement.setTextContent("1");

        Element nameElement = doc.createElement("name");
        nameElement.setTextContent("Ivan");

        Element ageElement = doc.createElement("age");
        ageElement.setTextContent("55");

        Element salaryElement = doc.createElement("salary");
        salaryElement.setTextContent("324324");

        Element documentsElement = doc.createElement("documents");
        Element docElement = doc.createElement("doc");

        Element titleElement = doc.createElement("title");
        titleElement.setTextContent("Docdddd");
        Element idDocElement = doc.createElement("id");
        idDocElement.setTextContent("32");
        Element numberElement = doc.createElement("number");
        numberElement.setTextContent("12AB");

        docElement.appendChild(titleElement);
        docElement.appendChild(idDocElement);
        docElement.appendChild(numberElement);

        documentsElement.appendChild(docElement);

        userElement.appendChild(idElement);
        userElement.appendChild(documentsElement);
        userElement.appendChild(nameElement);
        userElement.appendChild(ageElement);
        userElement.appendChild(salaryElement);

        doc.appendChild(userElement);
    }
}
