package tasktracking.models;

import tasktracking.controller.EditGeneralController;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class GeneralWorkTable {
    private SimpleStringProperty jobName;
    private SimpleStringProperty date;
    private SimpleStringProperty timeStart;
    private SimpleStringProperty timeEnd;
    private SimpleIntegerProperty priority;
    private Button status;
    private SimpleStringProperty category;
    private Button edit;

    public GeneralWorkTable(GeneralWork generalWork){
        this.jobName = new SimpleStringProperty(generalWork.showJobName());
        this.date = new SimpleStringProperty(generalWork.showForMattedDate());
        this.timeStart = new SimpleStringProperty(generalWork.showTimeStart().toString());
        this.timeEnd = new SimpleStringProperty(generalWork.showTimeEnd().toString());
        this.priority = new SimpleIntegerProperty(generalWork.showPriority());
        this.category = new SimpleStringProperty(generalWork.showCategory());
        if(generalWork.showJobStatus().equals("ยังไม่เริ่ม")){
            status = new Button("Wait");
            status.setStyle("-fx-background-color: #ee204d;");
        }else if(generalWork.showJobStatus().equals("กำลังทำ")){
            status = new Button("Now");
            status.setStyle("-fx-background-color: #fce883;");
        }else{
            status = new Button("Finished");
            status.setStyle("-fx-background-color: #1cac78;");
        }

        edit = new Button("edit");
        edit.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                try{
                    Image icon = new Image(getClass().getResourceAsStream("/images/140-1404099_important-clipart-todo-list-do-list-icon-png.png"));
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/editgeneralwork.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setTitle("Task Tracking");
                    stage.getIcons().add(icon);
                    stage.setResizable(false);
                    stage.setScene(new Scene(root1));
                    EditGeneralController editGeneralController = fxmlLoader.getController();
                    editGeneralController.setGeneralWork(generalWork);
                    stage.show();
                } catch (Exception e){
                    System.err.println(e.getMessage());
                }
            }
        });


    }

    public String getJobName(){
        return jobName.get();
    }
    public void setJobName(String jobName){
        this.jobName.set(jobName);
    }
    public String getDate(){
        return date.get();
    }
    public void setDate(String date){
        this.date.set(date);
    }
    public String getTimeStart(){
        return timeStart.get();
    }
    public void setTimeStart(String timeStart){
        this.timeStart.set(timeStart);
    }
    public String getTimeEnd(){
        return timeEnd.get();
    }
    public void setTimeEnd(String timeEnd){
        this.timeEnd.set(timeEnd);
    }
    public int getPriority(){
        return priority.get();
    }
    public void setPriority(int priority){
        this.priority.set(priority);
    }
    public Button getStatus(){
        return status;
    }
    public String getCategory(){
        return  category.get();
    }
    public Button getEdit(){
        return edit;
    }

}
