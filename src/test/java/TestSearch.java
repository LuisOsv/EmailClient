import core.*;
import interfaces.IFolder;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class TestSearch {

    @Test
    public void testSearchBySubject() {
        // creating messages
        Message messageTest1 = new Message("subject test1 regression","luis@gmail.com", "junior@gmail.com",
                "queen@tx.com", "this is a test");
        Message messageTest2 = new Message("subject test2 regression","luis@gmail.com", "junior@gmail.com",
                "queen@tx.com", "this is a test");
        Message messageTest3 = new Message("subject test3 smoke","luis@gmail.com", "junior@gmail.com",
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

        MessageSearchVisitor visitor = new MessageSearchVisitor("regression");
        visitor.search(Arrays.asList(inbox, sent, trash, luisFolder));
        visitor.showResults();
        Assert.assertTrue(visitor.getResults().size() == 2);
    }
}
