package core;

public class Message {
    private String subject;
    private String cc;
    private String from;
    private String to;
    private String body;

    public Message (String subject,String from, String to, String cc, String body) {
        this.subject = subject;
        this.from = from;
        this.to = to;
        this.cc = cc;
        this.body = body;
    }

    @Override
    public String toString() {
        return String.format("Subject:%s \n from:%s \n to:%s \n cc:%s \n body:%s", subject, from, to, cc, body);
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
