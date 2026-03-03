package ugb.ipsl.info.AndeuDiangue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ugb.ipsl.info.AndeuDiangue.service.DocumentService;

@RestController
public class DocumentController {

    private DocumentService documentService;

    @PostMapping
    public void createDocument(String title, String driverLink) {
        documentService.createDocument(title, driverLink);
    }

    @GetMapping
    public DocumentService getDocument(String title,  String driverLink) {
        documentService.getDocument(title, driverLink);
        return documentService;
    }

    @PutMapping
    public void updateDocument(String title, String driverLink) {
        documentService.updateDocument(title, driverLink);
    }

    @DeleteMapping
    public void deleteDocument(String title, String driverLink) {
        documentService.deleteDocument(title, driverLink);
    }

}
