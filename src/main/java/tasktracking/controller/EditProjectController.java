package tasktracking.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import tasktracking.models.ProjectWork;
import tasktracking.services.FileManager;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class EditProjectController implements Initializable {

    ProjectWork projectWork;
    @FXML
    private TextField jobname, projectleader,priority,category;

    @FXML
    private DatePicker datestart,dateend;

    @FXML
    private Label error,errornumber1,errornumber2,errornumber3,errortime;

    public void setProjectWork(ProjectWork projectWork){
        this.projectWork= projectWork;
    }

    public void handleUseSaveButton(ActionEvent actionEvent) {
        try {

            error.setVisible(false);
            errornumber1.setVisible(false);
            errornumber2.setVisible(false);
            errornumber3.setVisible(false);
            errortime.setVisible(false);

            if(jobname.getText().equals("")|| projectleader.getText().equals("")||datestart.getValue() == null||dateend.getValue() == null||priority.getText().equals("")){
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

            if (new FileManager().checkFileNameProject(jobname.getText())){
                Alert alert = new Alert(Alert.AlertType.ERROR,"Name sum");
                alert.showAndWait();
                return;
            }

            FileManager fileManager = new FileManager();

            fileManager.editFileProjectList(projectWork.showCount(),jobname.getText(), projectleader.getText(),priority.getText(),"0","0","0","0",datestart,dateend,category.getText());

            ((Stage) ((Button) actionEvent.getSource()).getScene().getWindow()).close();
        } catch (NumberFormatException er){
            errornumber1.setVisible(true);
            return;
        }
    }

    public void handleUseDeleteButton(ActionEvent actionEvent) {
        FileManager fileManager = new FileManager();
        fileManager.deleteFileProjectList(projectWork.showCount());
        ((Stage) ((Button) actionEvent.getSource()).getScene().getWindow()).close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(new Runnable() {
            public void run() {
                jobname.setText(projectWork.showJobName());
                projectleader.setText(projectWork.showProjectLeader());
                datestart.setValue(projectWork.showDateStart());
                dateend.setValue(projectWork.showDateEnd());
                priority.setText(String.valueOf(projectWork.showPriority()));
                category.setText(projectWork.showCategory());
            }
        });
    }
}
