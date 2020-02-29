package pl.sda.student;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JSONUtils {
    public void writeList(String nameFile, List list) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File(nameFile + ".json"), list);
    }

    public void readList(String name) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Student[] studentLista;
        studentLista = objectMapper.readValue(new File(name), Student[].class);
        for (int i = 0; i < studentLista.length; i++) {
            System.out.println(studentLista[i].toString());
        }
    }
}
