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
import tasktracking.controller.EditProjectController;

public class ProjectWorkTable {

    private SimpleStringProperty jobName;
    private SimpleStringProperty projectLeader;
    private SimpleStringProperty dateStart;
    private SimpleStringProperty dateEnd;
    private SimpleIntegerProperty priority;
    private Button status;
    private SimpleStringProperty category;
    private Button edit;

    public ProjectWorkTable(ProjectWork projectWork){
        this.jobName = new SimpleStringProperty(projectWork.showJobName());
        this.projectLeader = new SimpleStringProperty(projectWork.showProjectLeader());
        this.dateStart = new SimpleStringProperty(projectWork.showForMattedDateStart());
        this.dateEnd = new SimpleStringProperty(projectWork.showForMattedDateEnd());
        this.priority = new SimpleIntegerProperty(projectWork.showPriority());
        this.category = new SimpleStringProperty(projectWork.showCategory());
        if(projectWork.showJobStatus().equals("ยังไม่เริ่ม")){
            status = new Button("Wait");
            status.setStyle("-fx-background-color: #ee204d;");
        }else if(projectWork.showJobStatus().equals("กำลังทำ")){
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
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/editprojectwork.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setTitle("Task Tracking");
                    stage.getIcons().add(icon);
                    stage.setResizable(false);
                    stage.setScene(new Scene(root1));
                    EditProjectController editProjectController = fxmlLoader.getController();
                    editProjectController.setProjectWork(projectWork);
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
    public String getProjectLeader(){
        return projectLeader.get();
    }
    public void setProjectLeader(String projectLeader){
        this.projectLeader.set(projectLeader);
    }
    public String getDateStart(){
        return dateStart.get();
    }
    public void setDateStart(String date){
        this.dateStart.set(date);
    }
    public String getDateEnd(){
        return dateEnd.get();
    }
    public void setDateEnd(String date){
        this.dateEnd.set(date);
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
