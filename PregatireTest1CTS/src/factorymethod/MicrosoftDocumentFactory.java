package factorymethod;

import exception.InvalidDocumentType;

public class MicrosoftDocumentFactory implements AbstractDocumentFactory{

    @Override
    public Document getDocument(DocumentType documentType) {
        if( documentType == DocumentType.TEXT){
            return new MicrosoftWord();
        }
        else if(documentType == DocumentType.SHEET){
            return new MicrosoftExcel();
        }
        throw new InvalidDocumentType();
    }
}
