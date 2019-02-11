package ru.sstu.lessons.lesson4;

/**
 * БД для документов
 */
public class DocumentRepository {
    private static Document[] documents;

    static {
        documents = new Document[2];
        documents[0] = new Document("dox1", "121");
        documents[1] = new Document("dox2", "AAA");
    }

    static Document getDocumentByInd(int inx) {
        return documents[inx];
    }
}
