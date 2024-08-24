package se.aymeric.api.composite.content;

public class DocumentSummary {

    private final int documentId;
    private final String title;
    private final String fileType; // e.g., PDF, DOCX

    public DocumentSummary(int documentId, String title, String fileType) {
        this.documentId = documentId;
        this.title = title;
        this.fileType = fileType;
    }

    public int getDocumentId() {
        return documentId;
    }

    public String getTitle() {
        return title;
    }

    public String getFileType() {
        return fileType;
    }
}
