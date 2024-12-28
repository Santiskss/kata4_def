package ulpgc.dis.kata3.control;

import ulpgc.dis.kata3.model.Title;

public interface TitleDeserializer {
    Title deserialize(String content);
}
