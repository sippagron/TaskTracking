package tasktracking.models;

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
import tasktracking.controller.EditForwardController;
import tasktracking.controller.EditGeneralController;
import tasktracking.controller.EditRegularController;

public class ForwardWorkTable {
    private SimpleStringProperty jobName;
    private SimpleStringProperty responsibleMan;
    private SimpleStringProperty date;
    private SimpleStringProperty timeStart;
    private SimpleStringProperty timeEnd;
    private SimpleIntegerProperty priority;
    private Button status;
    private SimpleStringProperty category;
    private Button edit;

    public ForwardWorkTable(ForwardWork forwardWork){
        this.jobName = new SimpleStringProperty(forwardWork.showJobName());
        this.responsibleMan = new SimpleStringProperty(forwardWork.showResponsibleMan());
        this.date = new SimpleStringProperty(forwardWork.showForMattedDate());
        this.timeStart = new SimpleStringProperty(forwardWork.showTimeStart().toString());
        this.timeEnd = new SimpleStringProperty(forwardWork.showTimeEnd().toString());
        this.priority = new SimpleIntegerProperty(forwardWork.showPriority());
        this.category = new SimpleStringProperty(forwardWork.showCategory());
        if(forwardWork.showJobStatus().equals("ยังไม่เริ่ม")){
            status = new Button("Wait");
            status.setStyle("-fx-background-color: #ee204d;");
        }else if(forwardWork.showJobStatus().equals("กำลังทำ")){
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
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/editforwardwork.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setTitle("Task Tracking");
                    stage.getIcons().add(icon);
                    stage.setResizable(false);
                    stage.setScene(new Scene(root1));
                    EditForwardController editForwardController = fxmlLoader.getController();
                    editForwardController.setForwardWork(forwardWork);
                    stage.show();
                } catch (Exception e){
                    e.printStackTrace();
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
    public String getResponsibleMan(){
        return responsibleMan.get();
    }
    public void setResponsibleMan(String responsibleMan){
        this.responsibleMan.set(responsibleMan);
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
