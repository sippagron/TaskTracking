package tasktracking.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;

public class CategoryProjectWorkTable {
    private SimpleStringProperty jobName;
    private SimpleStringProperty projectLeader;
    private SimpleStringProperty dateStart;
    private SimpleStringProperty dateEnd;
    private SimpleIntegerProperty priority;
    private Button status;

    public CategoryProjectWorkTable(ProjectWork projectWork){
        this.jobName = new SimpleStringProperty(projectWork.showJobName());
        this.projectLeader = new SimpleStringProperty(projectWork.showProjectLeader());
        this.dateStart = new SimpleStringProperty(projectWork.showForMattedDateStart());
        this.dateEnd = new SimpleStringProperty(projectWork.showForMattedDateEnd());
        this.priority = new SimpleIntegerProperty(projectWork.showPriority());
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
    public void setProjectLeader(String responsibleMan){
        this.projectLeader.set(responsibleMan);
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

}
