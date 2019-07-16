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
    private String text;
    private String done;

    public Task() {
    }

    public Task(String text) {
        this.text = text;
    }

    public Task(String text, String done) {
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

    public String isDone() {
        return done;
    }

    public void setDone(String done) {
        this.done = done;
    }

   /*
    private String header;

    private String description;
    private String status;

    public Task(){}

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

        System.out.println(this.status + this.description + this.header);

        switch (status.toLowerCase()){
            case "new": return statusType.New;
            case "inprogress": return statusType.InProgress;
            case "done": return statusType.Done;
            case "fail":return statusType.Fail;
            default:return statusType.Unknown;
        }


    }

    public void setStatus(String status) {
        this.status=status;

    }


*/

}
