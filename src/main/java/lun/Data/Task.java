package lun.Data;

import lun.Data.statusType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String header;
    private statusType status;
    private String description;


    public Task(String header) {
        this.header = header;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public statusType getStatus() {
        return status;
    }

    public void setStatus(String status) {

        switch (status.toLowerCase()){
            case "new": this.status = statusType.New; break;
            case "inprogress": this.status = statusType.InProgress; break;
            case "done": this.status = statusType.Done; break;
            case "fail": this.status = statusType.Fail; break;
            default: this.status = statusType.Unknown;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /*


         public Todo(String text) {
        this.text = text;
    }

    public Todo(String text, boolean done) {
        this.text = text;
        this.done = done;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

         */



}
