package ulpgc.dis.kata3.control;

import ulpgc.dis.kata3.model.Title;

import java.io.IOException;
import java.util.List;

public interface TitleReader {
    List<Title> read() throws IOException;
}
