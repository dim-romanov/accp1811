package ru.sstu.lessons.lesson17.sax;

import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, JAXBException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        UserHandler u = new UserHandler();
        parser.parse(new File("users.xml"), u);

        UserListHandler userListHandler = new UserListHandler();
        parser.parse(new File("users.xml"), userListHandler);

        List<User> users = userListHandler.getUsers();
        System.out.println("---Users list---");
        for (User user : users) {
            System.out.println(user);
        }

        User u1 = new User(221, "Petr", 21, 12346, new Date());
        u1.addDocument(new Document(12,"pastor","12wq"));
        u1.addDocument(new Document(12,"pastor","12wq"));
        u1.addDocument(new Document(12,"pastor","12wq"));


    }
}
