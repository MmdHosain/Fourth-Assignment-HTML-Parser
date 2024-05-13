package org.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

import static org.example.demo.Main.showList;


public class CountriesView extends MainController{
//{
    public Label name_1;
    public Label capital_1;
    public Label area_1;
    public Label population_1;

    public Label name_2;
    public Label capital_2;
    public Label area_2;
    public Label population_2;

    public Label name_3;
    public Label capital_3;
    public Label area_3;
    public Label population_3;
    public Label pageNum;

    public Parent root;
    public Stage secondStage;
    public Scene scene;
    public void SetValue(int i, ArrayList<Country >countryList)
    {
        i --;
        i *=3;
        countryList = showList;
        name_1.setText(countryList.get(i+2).getName());
        capital_1.setText(countryList.get(i+2).getCapital());
        area_1.setText(String.valueOf(countryList.get(i+2).getArea()));
        population_1.setText(String.valueOf(countryList.get(i+2).getPopulation()));

        name_2.setText(countryList.get(i+1).getName());
        capital_2.setText(countryList.get(i+1).getCapital());
        area_2.setText(String.valueOf(countryList.get(i+1).getArea()));
        population_2.setText(String.valueOf(countryList.get(i+1).getPopulation()));

        name_3.setText(countryList.get(i).getName());
        capital_3.setText(countryList.get(i).getCapital());
        area_3.setText(String.valueOf(countryList.get(i).getArea()));
        population_3.setText(String.valueOf(countryList.get(i).getPopulation()));
        pageNum.setText("page " + ((i/3)+1));
        
    }
    public void addPage(ActionEvent actionEvent) throws IOException {
        if (pageNumber < showList.size()/3)
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("countries-view.fxml"));
             root = loader.load();
            CountriesView controller = loader.getController();
            pageNumber++;
            controller.SetValue(pageNumber,showList);
            secondStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
             scene = new Scene(root);
            secondStage.setScene(scene);
            secondStage.show();
        }
    }
    public void reducePage(ActionEvent actionEvent) throws IOException {
        if (pageNumber>1)
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("countries-view.fxml"));
             root = loader.load();
            CountriesView controller = loader.getController();
            pageNumber--;
            controller.SetValue(pageNumber,showList);
            secondStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
             scene = new Scene(root);
            secondStage.setScene(scene);
            secondStage.show();
        }
    }
    
}
