package ru.sstu.lessons.lesson17.jaxb2;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlType(propOrder = {"documents"})
public class DocList {
    private List<Document> documents = new ArrayList<>();

    @XmlElement(name = "doc")
    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public void addDocument(Document d) {
        documents.add(d);
    }
}
