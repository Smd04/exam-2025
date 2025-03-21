package org.example.exam.Model;

import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class Magazine extends Document {
    private String publisher;
    private String issueNumber;
    private Date dateIsuue;

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(String issueNumber) {
        this.issueNumber = issueNumber;
    }

    public Date getDateIsuue() {
        return dateIsuue;
    }

    public void setDateIsuue(Date dateIsuue) {
        this.dateIsuue = dateIsuue;
    }
}
