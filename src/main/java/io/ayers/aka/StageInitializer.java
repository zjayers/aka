package io.ayers.aka;

import io.ayers.aka.event.StageReadyEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class StageInitializer implements ApplicationListener<StageReadyEvent> {

    @Value("classpath:/main.fxml")
    private Resource fxResource;

    @Override
    public void onApplicationEvent(StageReadyEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(fxResource.getURL());
            Parent parent = fxmlLoader.load();

            var stage = event.getStage();
            stage.setScene(new Scene(parent, 800, 600));
            stage.show();

        } catch (IOException e) {
            // Deal with this in a better way
            throw new RuntimeException();
        }
    }
}
