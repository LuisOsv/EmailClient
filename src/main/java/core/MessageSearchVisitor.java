package core;

import interfaces.Visitor;
import java.util.ArrayList;
import java.util.List;

public class MessageSearchVisitor implements Visitor {

    public static class SearchBuilder {
        private String subject;
        private String cc;
        private String from;
        private String to;
        private String body;

        public SearchBuilder subjectContains(String subject) {
            this.subject = subject;
            return this;
        }

        public SearchBuilder andCC(String cc) {
            this.cc = cc;
            return this;
        }

        public SearchBuilder comingFrom(String from) {
            this.from = from;
            return this;
        }

        public SearchBuilder toRecipient(String to) {
            this.to = to;
            return this;
        }

        public SearchBuilder andBodyContains(String body) {
            this.body = body;
            return this;
        }

        public MessageSearchVisitor build() {
            MessageSearchVisitor visitor = new MessageSearchVisitor();
            visitor.subject = this.subject;
            visitor.cc = this.cc;
            visitor.from = this.from;
            visitor.to = this.to;
            visitor.body = this.body;
            return visitor;
        }
    }

    List<Message> results = new ArrayList<Message>();
    private String subject;
    private String cc;
    private String from;
    private String to;
    private String body;


    private MessageSearchVisitor() {
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

    public void search(RootDirectory directory) {
        directory.getFolders().forEach(
                visit -> visit.accept(this)
        );
    }

    public void showResults() {
        if (results.size() > 0) {
            for (Message message : results) {
                System.out.println(message.toString() + "\n");
            }
        } else {
            System.out.println(String.format("No messages with %s subject", subject));
        }
    }

    public List<Message> getResults() {
        return results;
    }

    @Override
    public void visit(RootDirectory rootFolder) {

    }

    @Override
    public void visit(RegularFolder regularFolder) {
        regularFolder.getFolders().forEach(
                folder -> searchMessages(folder.getMessages())
        );

        searchMessages(regularFolder.getMessages());
    }

    @Override
    public void visit(SpecialFolder specialFolder) {
        searchMessages(specialFolder.getMessages());
    }

    private void searchMessages(List<Message> messages) {
        messages.forEach(
                message -> {
                    if (message.getSubject().contains(subject)) {
                        results.add(message);
                    }
                    if (message.getBody().contains(body)) {
                        results.add(message);
                    }
                }
        );
    }
}
