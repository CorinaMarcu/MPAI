package factorymethod;

public interface AbstractDocumentFactory {

    Document getDocument(DocumentType documentType);
}
