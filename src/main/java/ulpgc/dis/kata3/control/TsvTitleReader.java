package ulpgc.dis.kata3.control;

import ulpgc.dis.kata3.model.Title;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TsvTitleReader implements TitleReader {
    private final File source;
    private final TsvTitleDeserializer deserializer;

    public TsvTitleReader(File source) {
        this.source = source;
        deserializer = new TsvTitleDeserializer();
    }

    @Override
    public List<Title> read() throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader(source))) {
            readHeaderWith(reader);
            return readTitlesWith(reader);
        }
    }

    private static void readHeaderWith(BufferedReader reader) throws IOException {
        reader.readLine();
    }

    private List<Title> readTitlesWith(BufferedReader reader) throws IOException {
        List<Title> titles = new ArrayList<>();
        while (true) {
            String l = reader.readLine();
            if (l == null) break;
            titles.add(titleOf(l));
        }
        return titles;
    }

    private Title titleOf(String line) {
        return deserializer.deserialize(line);
    }
}
