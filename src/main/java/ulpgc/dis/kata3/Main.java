package ulpgc.dis.kata3;

import ulpgc.dis.kata3.control.TsvTitleReader;
import ulpgc.dis.kata3.model.Title;

import java.io.*;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        TsvTitleReader reader = new TsvTitleReader(new File("C:\\Users\\Santi\\Downloads\\title.basics.tsv"));
        List<Title> titles = reader.read();
        HashMap<Title.TitleType, Integer> histograma = new HashMap<>();
        for (Title title : titles) {
            histograma.put(title.titleType(), histograma.getOrDefault(title.titleType(), 0) + 1);
        }
        for (Title.TitleType titleType : histograma.keySet()) {
            System.out.println(titleType + " " + histograma.get(titleType));
        }
    }
}
