package tasktracking.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import tasktracking.models.RegularWork;
import tasktracking.services.FileManager;

import java.awt.*;
import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class EditDateRegularController implements Initializable {

    RegularWork regularWork;
    @FXML
    private Button push1,push2,push3,push4,push5,push6;
    @FXML
    private TextField date1,date2,date3,date4,date5,date6;
    @FXML
    private DatePicker date;

    public void setRegularWork(RegularWork regularWork){
        this.regularWork = regularWork;
    }

    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(new Runnable() {
            public void run() {
                date.setValue(regularWork.showDateStart());
                date1.setText(String.valueOf(regularWork.showDateStart().plusDays(1).getDayOfWeek()));
                setStyles(date1,regularWork.showDateStart().plusDays(1).getDayOfWeek());
                date2.setText(String.valueOf(regularWork.showDateStart().plusDays(2).getDayOfWeek()));
                setStyles(date2,regularWork.showDateStart().plusDays(2).getDayOfWeek());
                date3.setText(String.valueOf(regularWork.showDateStart().plusDays(3).getDayOfWeek()));
                setStyles(date3,regularWork.showDateStart().plusDays(3).getDayOfWeek());
                date4.setText(String.valueOf(regularWork.showDateStart().plusDays(4).getDayOfWeek()));
                setStyles(date4,regularWork.showDateStart().plusDays(4).getDayOfWeek());
                date5.setText(String.valueOf(regularWork.showDateStart().plusDays(5).getDayOfWeek()));
                setStyles(date5,regularWork.showDateStart().plusDays(5).getDayOfWeek());
                date6.setText(String.valueOf(regularWork.showDateStart().plusDays(6).getDayOfWeek()));
                setStyles(date6,regularWork.showDateStart().plusDays(6).getDayOfWeek());
                if(regularWork.showDayOfWeeks().get(0).getStatus()==false){
                    push1.setStyle("-fx-background-color: #BA0900; ");
                }else{
                    push1.setStyle("-fx-background-color: #3BB143; ");
                }
                if(regularWork.showDayOfWeeks().get(1).getStatus()==false){
                    push2.setStyle("-fx-background-color: #BA0900; ");
                }else{
                    push2.setStyle("-fx-background-color: #3BB143; ");
                }
                if(regularWork.showDayOfWeeks().get(2).getStatus()==false){
                    push3.setStyle("-fx-background-color: #BA0900; ");
                }else{
                    push3.setStyle("-fx-background-color: #3BB143; ");
                }
                if(regularWork.showDayOfWeeks().get(3).getStatus()==false){
                    push4.setStyle("-fx-background-color: #BA0900; ");
                }else{
                    push4.setStyle("-fx-background-color: #3BB143; ");
                }
                if(regularWork.showDayOfWeeks().get(4).getStatus()==false){
                    push5.setStyle("-fx-background-color: #BA0900; ");
                }else{
                    push5.setStyle("-fx-background-color: #3BB143; ");
                }
                if(regularWork.showDayOfWeeks().get(5).getStatus()==false){
                    push6.setStyle("-fx-background-color: #BA0900; ");
                }else{
                    push6.setStyle("-fx-background-color: #3BB143; ");
                }

            }
        });
    }

    public void setStyles(TextField a, DayOfWeek b){
        if(String.valueOf(b).equals("MONDAY")){
            a.setStyle("-fx-background-color: #FDD741; ");
        }else if(String.valueOf(b).equals("TUESDAY")){
            a.setStyle("-fx-background-color: #FFB7B7; ");
        }else if(String.valueOf(b).equals("WEDNESDAY")){
            a.setStyle("-fx-background-color: #487564; ");
        }else if(String.valueOf(b).equals("THURSDAY")){
            a.setStyle("-fx-background-color: #F57B39; ");
        }else if(String.valueOf(b).equals("FRIDAY")){
            a.setStyle("-fx-background-color: #4E98B8; ");
        }else if(String.valueOf(b).equals("SATURDAY")){
            a.setStyle("-fx-background-color: #E5A8DE; ");
        }else if(String.valueOf(b).equals("SUNDAY")){
            a.setStyle("-fx-background-color: #BE2623; ");
        }
    }

    public void handleUseSaveButton(ActionEvent actionEvent) {
        FileManager fileManager = new FileManager();
        fileManager.editRegularDayOfWeek(regularWork);
        ((Stage) ((Button) actionEvent.getSource()).getScene().getWindow()).close();
    }

    public void handlePush1(ActionEvent actionEvent) {
        regularWork.showDayOfWeeks().get(0).setStatus();
        if(regularWork.showDayOfWeeks().get(0).getStatus()==false){
            push1.setStyle("-fx-background-color: #BA0900; ");
        }else{
            push1.setStyle("-fx-background-color: #3BB143; ");
        }
    }

    public void handlePush2(ActionEvent actionEvent) {
        regularWork.showDayOfWeeks().get(1).setStatus();
        if(regularWork.showDayOfWeeks().get(1).getStatus()==false){
            push2.setStyle("-fx-background-color: #BA0900; ");
        }else{
            push2.setStyle("-fx-background-color: #3BB143; ");
        }
    }

    public void handlePush3(ActionEvent actionEvent) {
        regularWork.showDayOfWeeks().get(2).setStatus();
        if(regularWork.showDayOfWeeks().get(2).getStatus()==false){
            push3.setStyle("-fx-background-color: #BA0900; ");
        }else{
            push3.setStyle("-fx-background-color: #3BB143; ");
        }
    }

    public void handlePush4(ActionEvent actionEvent) {
        regularWork.showDayOfWeeks().get(3).setStatus();
        if(regularWork.showDayOfWeeks().get(3).getStatus()==false){
            push4.setStyle("-fx-background-color: #BA0900; ");
        }else{
            push4.setStyle("-fx-background-color: #3BB143; ");
        }
    }

    public void handlePush5(ActionEvent actionEvent) {
        regularWork.showDayOfWeeks().get(4).setStatus();
        if(regularWork.showDayOfWeeks().get(4).getStatus()==false){
            push5.setStyle("-fx-background-color: #BA0900; ");
        }else{
            push5.setStyle("-fx-background-color: #3BB143; ");
        }
    }

    public void handlePush6(ActionEvent actionEvent) {
        regularWork.showDayOfWeeks().get(5).setStatus();
        if(regularWork.showDayOfWeeks().get(5).getStatus()==false){
            push6.setStyle("-fx-background-color: #BA0900; ");
        }else{
            push6.setStyle("-fx-background-color: #3BB143; ");
        }
    }
}
