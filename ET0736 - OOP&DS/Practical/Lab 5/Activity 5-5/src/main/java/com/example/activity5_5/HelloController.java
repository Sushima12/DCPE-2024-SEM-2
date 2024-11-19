package com.example.activity5_5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HelloController {

    @FXML
    private ListView<String> schoolList;

    @FXML
    void onClearButtonClick(ActionEvent event) {
        schoolList.getItems().clear();

    }

    @FXML
    void onImportButtonClick(ActionEvent event) {
        String a = "src/main/java/com/example/activity5_5/a.txt";
        try {
            String s;
            File myFile = new File(a);
            Scanner sc = new Scanner(myFile);

            schoolList.getItems().add("School is fun");
            while (sc.hasNextLine()) { // loop to read entire file
                s = sc.nextLine();
                schoolList.getItems().add(s);
                System.out.println(s);
            }
        } catch(FileNotFoundException e) {
            System.out.println("File Not Found...");

        }
    }

}
