package ugb.ipsl.info.AndeuDiangue.service;

import org.springframework.stereotype.Service;
import ugb.ipsl.info.AndeuDiangue.entity.Document;
import ugb.ipsl.info.AndeuDiangue.repository.DocumentRepository;

@Service
public class DocumentService {

    private DocumentRepository documentRepository;

    public void createDocument(String title, String driverLink) {
        documentRepository.save(new Document(title, driverLink));
    }

    public Document getDocument(String title,  String driverLink) {
        return null;
    }

    public void updateDocument(String title, String driverLink) {

    }

    public void deleteDocument(String title, String driverLink) {
        documentRepository.delete(new Document(title, driverLink));
    }

}

