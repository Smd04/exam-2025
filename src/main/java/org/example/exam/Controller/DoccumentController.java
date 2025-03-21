package org.example.exam.Controller;

import org.example.exam.DAO.DocumenDAO;
import org.example.exam.Model.Book;
import org.example.exam.Model.Document;

import java.util.List;

public class DoccumentController {
    private Document document=new Document();
    private DocumenDAO dao=new DocumenDAO();

    public void insertDoc(Document document){
        dao.create(document);
    }

    public Document get(long id){
        return dao.findDocument(id);
    }

    public List<Document> getAll(){
        return dao.findAll();
    }
}
