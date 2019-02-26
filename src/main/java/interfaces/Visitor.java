package interfaces;

import core.RegularFolder;
import core.SpecialFolder;

public interface Visitor {

    void visit(RegularFolder regularFolder);

    void visit(SpecialFolder specialFolder);
}
