package tasktracking.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import tasktracking.models.ForwardWork;
import tasktracking.models.GeneralWork;
import tasktracking.services.FileManager;

import java.net.URL;
import java.util.ResourceBundle;

public class EditForwardController implements Initializable {

    ForwardWork forwardWork;
    @FXML
    private TextField jobname,responsibleman,timestart1,timestart2,timeend1,timeend2,priority,category;

    @FXML
    private DatePicker date;

    @FXML
    private Label error,errornumber1,errornumber2,errornumber3,errortime;


    public void setForwardWork(ForwardWork forwardWork){
        this.forwardWork= forwardWork;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(new Runnable() {
            public void run() {
                jobname.setText(forwardWork.showJobName());
                responsibleman.setText(forwardWork.showResponsibleMan());
                date.setValue(forwardWork.showDateStart());
                timestart1.setText(String.valueOf(forwardWork.showHour1()));
                timestart2.setText(String.valueOf(forwardWork.showMinute1()));
                timeend1.setText(String.valueOf(forwardWork.showHour2()));
                timeend2.setText(String.valueOf(forwardWork.showMinute2()));
                priority.setText(String.valueOf(forwardWork.showPriority()));
                category.setText(forwardWork.showCategory());
            }
        });
    }

    public void handleUseSaveButton(ActionEvent actionEvent){
        try {

            error.setVisible(false);
            errornumber1.setVisible(false);
            errornumber2.setVisible(false);
            errornumber3.setVisible(false);
            errortime.setVisible(false);

            if(jobname.getText().equals("")||responsibleman.getText().equals("")||date.getValue() == null||timestart1.getText().equals("")||timestart2.getText().equals("")
                    ||timeend1.getText().equals("")||timeend2.getText().equals("")||priority.getText().equals("")){
                error.setVisible(true);
                return;
            }

            if( Integer.parseInt(timestart1.getText()) < 0 || Integer.parseInt(timestart1.getText()) > 23){
                errornumber2.setVisible(true);
                return;
            }
            else if( Integer.parseInt(timestart2.getText()) < 0 || Integer.parseInt(timestart2.getText()) > 59){
                errornumber2.setVisible(true);
                return;
            }
            else if( Integer.parseInt(timeend1.getText()) < 0 || Integer.parseInt(timeend1.getText()) > 23){
                errornumber2.setVisible(true);
                return;
            }
            else if( Integer.parseInt(timeend2.getText()) < 0 || Integer.parseInt(timeend2.getText()) > 59){
                errornumber2.setVisible(true);
                return;
            }else if( Integer.parseInt(priority.getText()) < 0 || Integer.parseInt(priority.getText()) > 4){
                errornumber3.setVisible(true);
                return;
            }

            if(Integer.parseInt(timestart1.getText()) > Integer.parseInt(timeend1.getText())){
                errortime.setVisible(true);
                return;
            }else if(Integer.parseInt(timestart1.getText()) == Integer.parseInt(timeend1.getText())){
                if(Integer.parseInt(timestart2.getText()) >= Integer.parseInt(timeend2.getText())){
                    errortime.setVisible(true);
                    return;
                }
            }

            if (new FileManager().checkFileNameForward(jobname.getText())){
                Alert alert = new Alert(Alert.AlertType.ERROR,"Name sum");
                alert.showAndWait();
                return;
            }

            FileManager fileManager = new FileManager();

            fileManager.editFileForwardList(forwardWork.showCount(),jobname.getText(),responsibleman.getText(),priority.getText(),timestart1.getText(),timestart2.getText()
                    ,timeend1.getText(),timeend2.getText(),date,category.getText());

            ((Stage) ((Button) actionEvent.getSource()).getScene().getWindow()).close();
        } catch (NumberFormatException er){
            errornumber1.setVisible(true);
            return;
        }
    }

    public void handleUseDeleteButton(ActionEvent actionEvent) {
        FileManager fileManager = new FileManager();
        fileManager.deleteFileForwardList(forwardWork.showCount());
        ((Stage) ((Button) actionEvent.getSource()).getScene().getWindow()).close();
    }

}
