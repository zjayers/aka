package io.ayers.aka;


import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AkaApplication {

    public static void main(String[] args) {
        Application.launch(FxApplication.class, args);
    }

}
