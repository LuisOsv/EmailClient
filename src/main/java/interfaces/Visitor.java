package interfaces;

import core.RegularFolder;
import core.RootDirectory;
import core.SpecialFolder;

public interface Visitor {

    void visit(RootDirectory rootFolder);

    void visit(RegularFolder regularFolder);

    void visit(SpecialFolder specialFolder);
}
