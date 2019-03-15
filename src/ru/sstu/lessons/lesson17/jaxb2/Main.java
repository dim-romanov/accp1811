package ru.sstu.lessons.lesson17.jaxb2;

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
        DocList docList = new DocList();
        docList.addDocument(new Document(12, "pastor", "12wq"));
        docList.addDocument(new Document(12, "pastor", "12wq"));
        docList.addDocument(new Document(12, "pastor", "12wq"));
        u1.setDocList(docList);

        List<User> users = new ArrayList<>();
        users.add(u1);
        users.add(u1);
        users.add(u1);
        users.add(u1);

        Empl empl = new Empl();
        empl.setLang("rus");
        empl.setUsers(users);


//        JAXBContext jaxbContext = JAXBContext.newInstance(Empl.class);
//        Marshaller marshaller = jaxbContext.createMarshaller();
//        marshaller.marshal(empl, new File("user2.xml"));

        JAXBContext context = JAXBContext.newInstance(Empl.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Empl empl1 = (Empl) unmarshaller.unmarshal(new File("users.xml"));
        for (User u:empl1.getUsers()){
            System.out.println(u);
            if (u.getDocList() != null)
            System.out.println(u.getDocList().getDocuments());
        }
//

//
//

    }
}
