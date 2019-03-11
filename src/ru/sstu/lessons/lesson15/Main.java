package ru.sstu.lessons.lesson15;

import org.xml.sax.SAXException;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, SAXException, TransformerException {
        SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        try {
            Schema schema = factory.newSchema(new File("src/ru/sstu/lessons/lesson15/schema.xsd"));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource("src/ru/sstu/lessons/lesson15/users.xml"));
            System.out.println("OK");
        } catch (SAXException | IOException e) {
            System.err.println(e.getMessage());
        }

        File xmlFile = new File("src/ru/sstu/lessons/lesson15/users.xml");
        File xsltFile = new File("src/ru/sstu/lessons/lesson15/view.xsl");
        Source xmlSource = new StreamSource(xmlFile);
        Source xsltSource = new StreamSource(xsltFile);
        TransformerFactory transFact = TransformerFactory.newInstance();
        Transformer trans = transFact.newTransformer(xsltSource);
        trans.transform(xmlSource, new StreamResult(new FileOutputStream(new File("index.html"))));
    }
}
