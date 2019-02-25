package interfaces;

import core.Message;

import java.util.List;


public interface IFolder extends interfaces.Visitable {
    void showMessages();
    void addMessage(Message message);
    void removeMessage(Message message);
    List<Message> getMessages();
}
