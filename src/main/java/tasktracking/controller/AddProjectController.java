package tasktracking.controller;

import com.github.saacsos.FXRouter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import tasktracking.models.ForwardWork;
import tasktracking.models.ProjectWork;
import tasktracking.services.FileManager;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class AddProjectController {
    @FXML
    private TextField jobname,projectleader,priority,category;

    @FXML
    private DatePicker datestart,dateend;

    @FXML
    private Label error,errornumber1,errornumber2,errornumber3,errortime;
    public void handleUseBackButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("projectwork");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า projectwork ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    public void handleUseSaveButton(ActionEvent actionEvent) {
        try {

            error.setVisible(false);
            errornumber1.setVisible(false);
            errornumber2.setVisible(false);
            errornumber3.setVisible(false);
            errortime.setVisible(false);

            if(jobname.getText().equals("")||projectleader.getText().equals("")||datestart.getValue() == null||dateend.getValue() == null||priority.getText().equals("")){
                error.setVisible(true);
                return;
            }

            if( Integer.parseInt(priority.getText()) < 0 || Integer.parseInt(priority.getText()) > 4){
                errornumber3.setVisible(true);
                return;
            }

            LocalDate a = datestart.getValue();
            LocalDate b = dateend.getValue();

            if(a.compareTo(b) > 0){
                errortime.setVisible(true);
                return;
            }

            ArrayList<Integer> number = new ArrayList<>();
            Random r = new Random();
            r.setSeed(191);
            for(int i=0;i<=100;i++){
                number.add(r.nextInt(10000));
            }


            ArrayList<ProjectWork> test = new FileManager().readFileProjectList();

            int go = -1;
            int index = -1;
            boolean check = true;
            for(int i=0;i<test.size();i++){

                if(test.get(i).showCount() != number.get(i)){
                    check = false;
                    go = number.get(i);
                    break;
                }
                index = i;
            }

            if(check == true){
                go = number.get(index+1);
            }

            if (new FileManager().checkFileNameProject(jobname.getText())){
                Alert alert = new Alert(Alert.AlertType.ERROR,"Name sum");
                alert.showAndWait();
                return;
            }

            ProjectWork project = new ProjectWork(go,jobname.getText(),projectleader.getText(),Integer.parseInt(priority.getText()),0,0
                    ,0,0,a,category.getText());
            project.setDateEnd(b);
            FileManager fileManager = new FileManager();
            fileManager.saveFileProjectList(project);
            fileManager.readFileProjectList();
            FXRouter.goTo("projectwork");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า projectwork ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        } catch (NumberFormatException er){
            errornumber1.setVisible(true);
            return;
        }
    }
}
