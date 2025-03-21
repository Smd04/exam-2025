package org.example.exam.Model;


import jakarta.persistence.*;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String mail;

    @ManyToMany
    @JoinTable(name = "user_doc")
    private List<Document> docs=new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Borrow> borrows = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<Document> getDocs() {
        return docs;
    }

    public void setDocs(List<Document> docs) {
        this.docs = docs;
    }

    public List<Borrow> getBorrows() {
        return borrows;
    }

    public void setBorrows(List<Borrow> borrows) {
        this.borrows = borrows;
    }

    public void borrowBook(Book book, Date dateBorrow, Date returnDate) {
        Borrow borrow = new Borrow();
        borrow.setUser(this);
        borrow.setBook(book);
        borrow.setDateBorrow(dateBorrow);
        borrow.setReturnDate(returnDate);
        borrows.add(borrow);
    }
}
