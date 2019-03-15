package ru.sstu.lessons.lesson17.jaxb;

import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, JAXBException {

        User u1 = new User(221, "Petr", 21, 12346, new Date());
        List<Document> docList = new ArrayList<>();
        docList.add(new Document(12, "pastor", "12wq"));
        docList.add(new Document(12, "pastor", "12wq"));
        docList.add(new Document(12, "pastor", "12wq"));
        u1.setDocuments(docList);


        //сохранение в XML
        JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.marshal(u1, new File("user2.xml"));

        //чтение из XML
        JAXBContext context = JAXBContext.newInstance(User.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        User c1 = (User) unmarshaller.unmarshal(new File("user2.xml"));


    }
}
