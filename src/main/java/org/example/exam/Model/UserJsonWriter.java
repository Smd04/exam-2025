package org.example.exam.Model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Arrays;

public class UserJsonWriter {
    public static void main(String[] args) {
        try {
            User user = new User();
            user.setId(1);
            user.setName("John Doe");
            user.setMail("johndoe@example.com");

            Document doc1 = new Document();
            doc1.setId(101);
            doc1.setTitle("Report.pdf");

            Document doc2 = new Document();
            doc2.setId(102);
            doc2.setTitle("Notes.docx");

            user.setDocs(Arrays.asList(doc1, doc2));

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File("user.json"), user);

            System.out.println("JSON file created successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
