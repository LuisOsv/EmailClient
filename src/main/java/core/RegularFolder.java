package core;

import interfaces.IFolder;
import interfaces.Visitor;

import java.util.ArrayList;
import java.util.List;

public class RegularFolder implements IFolder {

    private String name;
    private List<Message> messages;
    private List<IFolder> folders;

    public RegularFolder(String name) {
        this.name = name;
        messages = new ArrayList<>();
        folders = new ArrayList<>();
    }

    public void addFolder(IFolder folder) {
        folders.add(folder);
    }

    public void removeFolder(IFolder folder) {
        folders.remove(folder);
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

    public List<IFolder> getFolders() {
        return folders;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
