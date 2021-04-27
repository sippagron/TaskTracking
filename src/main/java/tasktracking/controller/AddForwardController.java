package tasktracking.controller;

import com.github.saacsos.FXRouter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import tasktracking.models.ForwardWork;
import tasktracking.models.GeneralWork;
import tasktracking.services.FileManager;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class AddForwardController {
    @FXML
    private TextField jobname,responsibleman,timestart1,timestart2,timeend1,timeend2,priority,category;

    @FXML
    private DatePicker date;

    @FXML
    private Label error,errornumber1,errornumber2,errornumber3,errortime;

    @FXML
    public void handleUseBackButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("forwardwork");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า forwardwork ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
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
            ArrayList<Integer> number = new ArrayList<>();
            Random r = new Random();
            r.setSeed(191);
            for(int i=0;i<=100;i++){
                number.add(r.nextInt(10000));
            }

            LocalDate a = date.getValue();
            ArrayList<ForwardWork> test = new FileManager().readFileForwardList();

            int go = -1;
            int index = -1;
            boolean check = true;
            for(int i=0;i<test.size();i++){
                //System.out.println(test.get(i).showCount());
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

            if (new FileManager().checkFileNameForward(jobname.getText())){
                Alert alert = new Alert(Alert.AlertType.ERROR,"Name sum");
                alert.showAndWait();
                return;
            }

            ForwardWork forward = new ForwardWork(go,jobname.getText(),responsibleman.getText(),Integer.parseInt(priority.getText()),Integer.parseInt(timestart1.getText()),Integer.parseInt(timestart2.getText())
                    ,Integer.parseInt(timeend1.getText()),Integer.parseInt(timeend2.getText()),a,category.getText());
            FileManager fileManager = new FileManager();
            fileManager.saveFileForwardList(forward);
            fileManager.readFileForwardList();
            FXRouter.goTo("forwardwork");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า forwardwork ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        } catch (NumberFormatException er){
            errornumber1.setVisible(true);
            return;
        }
    }
}
