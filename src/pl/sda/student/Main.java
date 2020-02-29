package pl.sda.student;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Student student = new Student("Monika", "Żbikowska", 33);
        Student student1 = new Student("Paweł", "Nowak", 33);
        Student student2 = new Student("Igor", "Przybylski", 34);
        Student student3 = new Student("Mateusz", "Sarnowski", 35);
        Student student4 = new Student("Jakub", "Pawlak", 36);
        Student student5 = new Student("Maciej", "Gargulec", 37);

        List <Student> listaStudentow = new ArrayList<>();
        listaStudentow.add(student1);
        listaStudentow.add(student2);
        listaStudentow.add(student3);
        listaStudentow.add(student4);
        listaStudentow.add(student5);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("student1.json"), student1);
            objectMapper.writeValue(new File("student2.json"), student2);
            objectMapper.writeValue(new File("student3.json"), student3);
            objectMapper.writeValue(new File("student4.json"), student4);
            objectMapper.writeValue(new File("student5.json"), student5);
            objectMapper.writeValue(new File("listaStudentow.json"), listaStudentow);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONUtils jsonUtils = new JSONUtils();

        try {
            listaStudentow.add(student);
            jsonUtils.writeList("ListaStudentow1", listaStudentow);
        } catch (IOException e){
            e.printStackTrace();
        }

        try {
            jsonUtils.readList("listaStudentow1.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
