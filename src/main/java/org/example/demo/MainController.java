package org.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

import static org.example.demo.Main.*;

public class MainController {
    public static int pageNumber ;

    @FXML
    public void showArea(ActionEvent actionEvent) throws IOException {
        pageNumber = 1;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("countries-view.fxml"));
        Parent root = loader.load();
        CountriesView controller = loader.getController();
        showList = areaSorted;
        controller.SetValue(pageNumber,showList);
        Stage secondStage = new Stage();
        Scene scene = new Scene(root);
        secondStage.setScene(scene);
        secondStage.show();

    }
    @FXML
    public void showPopulation(ActionEvent actionEvent) throws IOException {
        pageNumber = 1;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("countries-view.fxml"));
        Parent root = loader.load();
        CountriesView controller = loader.getController();
        showList = popSorted;
        controller.SetValue(pageNumber,showList);
        Stage secondStage = new Stage();
        Scene scene = new Scene(root);
        secondStage.setScene(scene);
        secondStage.show();
    }
    @FXML
    public void showName(ActionEvent actionEvent) throws IOException {
        pageNumber = 1;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("countries-view.fxml"));
        Parent root = loader.load();
        CountriesView controller = loader.getController();
        showList = nameSorted;
        controller.SetValue(pageNumber,showList);
        Stage secondStage = new Stage();
        Scene scene = new Scene(root);
        secondStage.setScene(scene);
        secondStage.show();
    }

}