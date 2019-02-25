import core.*;
import interfaces.IFolder;

public class Demo {

    public static void main(String args[]) {
        // creating messages
        Message messageTest1 = new Message("subject testing1","luis@gmail.com", "junior@gmail.com",
                "queen@tx.com", "this is a test");
        Message messageTest2 = new Message("subject testing2","luis@gmail.com", "junior@gmail.com",
                "queen@tx.com", "this is a test");
        Message messageTest3 = new Message("subject testing3","luis@gmail.com", "junior@gmail.com",
                "queen@tx.com", "this is a test");

        // creating folders
        IFolder luisFolder = new RegularFolder("luisFolder");
        IFolder inbox = new SpecialFolder("inbox");
        IFolder sent = new SpecialFolder("sent");
        IFolder trash = new SpecialFolder("trash");

        // adding messages to folders
        inbox.addMessage(messageTest1);
        luisFolder.addMessage(messageTest2);
        luisFolder.addMessage(messageTest3);

        RootDirectory rootDirectory = new RootDirectory("root");
        rootDirectory.addFolder(luisFolder);
        rootDirectory.addFolder(inbox);
        rootDirectory.addFolder(sent);
        rootDirectory.addFolder(trash);

//        rootDirectory.showMessages();

        MessageSearchVisitor visitor = new MessageSearchVisitor("testing2");
        visitor.search(luisFolder);
        visitor.showResults();

    }

}
