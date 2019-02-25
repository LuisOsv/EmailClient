package core;

import interfaces.IFolder;
import interfaces.Visitor;

import java.util.ArrayList;
import java.util.List;

public class SpecialFolder implements IFolder {

    private String name;
    private List<Message> messages;

    public SpecialFolder(String name) {
        this.name = name;
        messages = new ArrayList<>();
    }

    public void showMessages() {
        System.out.println(String.format("Folder Name:%s",name));
        messages.forEach(
                message ->  System.out.println(message.toString())
        );
    }

    @Override
    public void addMessage(Message message) {
        messages.add(message);
    }

    @Override
    public void removeMessage(Message message) {
        messages.remove(message);
    }

    @Override
    public List<Message> getMessages() {
        return messages;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
