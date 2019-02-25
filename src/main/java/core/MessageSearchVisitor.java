package core;

import interfaces.Visitor;
import java.util.ArrayList;
import java.util.List;

public class MessageSearchVisitor implements Visitor {

    List<Message> results = new ArrayList<Message>();
    private String messageSubject;

    public MessageSearchVisitor(String messageSubject) {
        this.messageSubject = messageSubject;
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
            System.out.println(String.format("No messages with %s subject", messageSubject));
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
                    if (message.getSubject().contains(messageSubject)) {
                        results.add(message);
                    }
                }
        );
    }


}
