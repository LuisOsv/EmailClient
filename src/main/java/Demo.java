import core.*;
import interfaces.IFolder;

public class Demo {

    public static void main(String args[]) {
        // creating messages
        System.out.println("    creating messages");
        Message messageTest1 = new Message("subject test1 regression","luis@gmail.com", "junior@gmail.com",
                "queen@tx.com", "this is a test");
        Message messageTest2 = new Message("subject test2 regression","luis@gmail.com", "junior@gmail.com",
                "queen@tx.com", "this is a test");
        Message messageTest3 = new Message("subject test3 smoke","luis@gmail.com", "junior@gmail.com",
                "queen@tx.com", "this is a test");
        Message messageTest4 = new Message("subject test3 smoke","luis@gmail.com", "junior@gmail.com",
                "queen@tx.com", "this is a test with mix test data");
        Message messageTest5 = new Message("subject test3 smoke","luis@gmail.com", "junior@gmail.com",
                "queen@tx.com", "this is a test with mix test data");

        // creating folders
        System.out.println("    creating folders");
        IFolder luisFolder = new RegularFolder("luisFolder");
        IFolder inbox = new SpecialFolder("inbox");
        IFolder sent = new SpecialFolder("sent");
        IFolder trash = new SpecialFolder("trash");

        // adding messages to folders
        System.out.println("    adding messages to folders");
        inbox.addMessage(messageTest1);
        inbox.addMessage(messageTest4);
        inbox.addMessage(messageTest5);
        luisFolder.addMessage(messageTest2);
        luisFolder.addMessage(messageTest3);


        RootDirectory rootDirectory = new RootDirectory("root");
        rootDirectory.addFolder(luisFolder);
        rootDirectory.addFolder(inbox);
        rootDirectory.addFolder(sent);
        rootDirectory.addFolder(trash);

        System.out.println("    search message by subject and body");
        MessageSearchVisitor visitor = new MessageSearchVisitor.SearchBuilder()
                .subjectContains("regression")
                .andBodyContains("test data")
                .build();
        visitor.search(rootDirectory);
        visitor.showResults();
    }
}
