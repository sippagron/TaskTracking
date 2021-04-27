package tasktracking.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;

public class CategoryRegularWorkTable {
    private SimpleStringProperty jobName;
    private SimpleStringProperty date;
    private SimpleStringProperty timeStart;
    private SimpleStringProperty timeEnd;
    private SimpleIntegerProperty priority;
    private Button status;

    public CategoryRegularWorkTable(RegularWork regularWork){
        this.jobName = new SimpleStringProperty(regularWork.showJobName());
        this.date = new SimpleStringProperty(regularWork.showForMattedDate());
        this.timeStart = new SimpleStringProperty(regularWork.showTimeStart().toString());
        this.timeEnd = new SimpleStringProperty(regularWork.showTimeEnd().toString());
        this.priority = new SimpleIntegerProperty(regularWork.showPriority());
        if(regularWork.showJobStatus().equals("ยังไม่เริ่ม")){
            status = new Button("Wait");
            status.setStyle("-fx-background-color: #ee204d;");
        }else if(regularWork.showJobStatus().equals("กำลังทำ")){
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

}
