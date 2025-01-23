package factorymethod;

import exception.InvalidDocumentType;

public class GoogleDocumentFactory implements AbstractDocumentFactory{
    @Override
    public Document getDocument(DocumentType documentType) {
        if(documentType == DocumentType.TEXT){
            return new GoogleDoc();
        }
        else if(documentType ==DocumentType.SHEET){
            return new GoogleSpreadSheet();
        }
        throw new InvalidDocumentType();
    }
}
