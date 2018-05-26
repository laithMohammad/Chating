package actors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "Message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String content;
    byte[] attachment;
    int senderId;
    Date sendingTime;

    public Message(String content, byte[] attachment, int senderId, Date sendingTime) {
        this.content = content;
        this.attachment = attachment;
        this.senderId = senderId;
        this.sendingTime = sendingTime;
    }

    public Message() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public byte[] getAttachment() {
        return attachment;
    }

    public void setAttachment(byte[] attachment) {
        this.attachment = attachment;
    }

    public Date getTime() {
        return sendingTime;
    }

    public void setTime(Date sendingTime) {
        this.sendingTime = sendingTime;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }
}