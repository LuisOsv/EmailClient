package core;

import interfaces.IFolder;

import java.util.ArrayList;
import java.util.List;

public class RootDirectory {

    String name;
    private List<IFolder>  folders;

    public RootDirectory(String name) {
        folders = new ArrayList<>();
        this.name = name;
    }

    public void showMessages() {
        folders.forEach(
                folder -> {
                    System.out.println();
                    folder.showMessages();
                }
        );
    }

    public void addFolder(IFolder folder) {
        folders.add(folder);
    }

    public void removeFolder(IFolder folder) {
        folders.remove(folder);
    }
}
