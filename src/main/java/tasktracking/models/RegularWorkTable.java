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
import tasktracking.controller.EditDateRegularController;
import tasktracking.controller.EditRegularController;

public class RegularWorkTable {
    private SimpleStringProperty jobName;
    private Button date;
    private SimpleStringProperty timeStart;
    private SimpleStringProperty timeEnd;
    private SimpleIntegerProperty priority;
    private Button status;
    private SimpleStringProperty category;
    private Button edit;
    public RegularWorkTable(RegularWork regularWork){
        this.jobName = new SimpleStringProperty(regularWork.showJobName());
        if(regularWork.dayOfWeek().toString().equals("MONDAY")){
            date = new Button("MONDAY");
            date.setStyle("-fx-background-color: #FDD741; ");
            date.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {
                    try{
                        Image icon = new Image(getClass().getResourceAsStream("/images/140-1404099_important-clipart-todo-list-do-list-icon-png.png"));
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/editdateregularwork.fxml"));
                        Parent root1 = (Parent) fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.setTitle("Task Tracking");
                        stage.getIcons().add(icon);
                        stage.setResizable(false);
                        stage.setScene(new Scene(root1));
                        EditDateRegularController editDateRegularController = fxmlLoader.getController();
                        editDateRegularController.setRegularWork(regularWork);
                        stage.show();
                    } catch (Exception e){
                        System.err.println(e.getMessage());
                    }
                }
            });
        }else if(regularWork.dayOfWeek().toString().equals("TUESDAY")){
            date = new Button("TUESDAY");
            date.setStyle("-fx-background-color: #FFB7B7; ");
            date.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {
                    try{
                        Image icon = new Image(getClass().getResourceAsStream("/images/140-1404099_important-clipart-todo-list-do-list-icon-png.png"));
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/editdateregularwork.fxml"));
                        Parent root1 = (Parent) fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.setTitle("Task Tracking");
                        stage.getIcons().add(icon);
                        stage.setResizable(false);
                        stage.setScene(new Scene(root1));
                        EditDateRegularController editDateRegularController = fxmlLoader.getController();
                        editDateRegularController.setRegularWork(regularWork);
                        stage.show();
                    } catch (Exception e){
                        System.err.println(e.getMessage());
                    }
                }
            });
        }else if(regularWork.dayOfWeek().toString().equals("WEDNESDAY")){
            date = new Button("WEDNESDAY");
            date.setStyle("-fx-background-color: #487564; ");
            date.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {
                    try{
                        Image icon = new Image(getClass().getResourceAsStream("/images/140-1404099_important-clipart-todo-list-do-list-icon-png.png"));
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/editdateregularwork.fxml"));
                        Parent root1 = (Parent) fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.setTitle("Task Tracking");
                        stage.getIcons().add(icon);
                        stage.setResizable(false);
                        stage.setScene(new Scene(root1));
                        EditDateRegularController editDateRegularController = fxmlLoader.getController();
                        editDateRegularController.setRegularWork(regularWork);
                        stage.show();
                    } catch (Exception e){
                        System.err.println(e.getMessage());
                    }
                }
            });
        }else if(regularWork.dayOfWeek().toString().equals("THURSDAY")){
            date = new Button("THURSDAY");
            date.setStyle("-fx-background-color: #F57B39; ");
            date.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {
                    try{
                        Image icon = new Image(getClass().getResourceAsStream("/images/140-1404099_important-clipart-todo-list-do-list-icon-png.png"));
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/editdateregularwork.fxml"));
                        Parent root1 = (Parent) fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.setTitle("Task Tracking");
                        stage.getIcons().add(icon);
                        stage.setResizable(false);
                        stage.setScene(new Scene(root1));
                        EditDateRegularController editDateRegularController = fxmlLoader.getController();
                        editDateRegularController.setRegularWork(regularWork);
                        stage.show();
                    } catch (Exception e){
                        System.err.println(e.getMessage());
                    }
                }
            });
        }else if(regularWork.dayOfWeek().toString().equals("FRIDAY")){
            date = new Button("FRIDAY");
            date.setStyle("-fx-background-color: #4E98B8; ");
            date.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {
                    try{
                        Image icon = new Image(getClass().getResourceAsStream("/images/140-1404099_important-clipart-todo-list-do-list-icon-png.png"));
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/editdateregularwork.fxml"));
                        Parent root1 = (Parent) fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.setTitle("Task Tracking");
                        stage.getIcons().add(icon);
                        stage.setResizable(false);
                        stage.setScene(new Scene(root1));
                        EditDateRegularController editDateRegularController = fxmlLoader.getController();
                        editDateRegularController.setRegularWork(regularWork);
                        stage.show();
                    } catch (Exception e){
                        System.err.println(e.getMessage());
                    }
                }
            });
        }else if(regularWork.dayOfWeek().toString().equals("SATURDAY")){
            date = new Button("SATURDAY");
            date.setStyle("-fx-background-color: #E5A8DE; ");
            date.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {
                    try{
                        Image icon = new Image(getClass().getResourceAsStream("/images/140-1404099_important-clipart-todo-list-do-list-icon-png.png"));
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/editdateregularwork.fxml"));
                        Parent root1 = (Parent) fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.setTitle("Task Tracking");
                        stage.getIcons().add(icon);
                        stage.setResizable(false);
                        stage.setScene(new Scene(root1));
                        EditDateRegularController editDateRegularController = fxmlLoader.getController();
                        editDateRegularController.setRegularWork(regularWork);
                        stage.show();
                    } catch (Exception e){
                        System.err.println(e.getMessage());
                    }
                }
            });
        }else if(regularWork.dayOfWeek().toString().equals("SUNDAY")){
            date = new Button("SUNDAY");
            date.setStyle("-fx-background-color: #BE2623; ");
            date.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {
                    try{
                        Image icon = new Image(getClass().getResourceAsStream("/images/140-1404099_important-clipart-todo-list-do-list-icon-png.png"));
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/editdateregularwork.fxml"));
                        Parent root1 = (Parent) fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.setTitle("Task Tracking");
                        stage.getIcons().add(icon);
                        stage.setResizable(false);
                        stage.setScene(new Scene(root1));
                        EditDateRegularController editDateRegularController = fxmlLoader.getController();
                        editDateRegularController.setRegularWork(regularWork);
                        stage.show();
                    } catch (Exception e){
                        System.err.println(e.getMessage());
                    }
                }
            });
        }
        this.timeStart = new SimpleStringProperty(regularWork.showTimeStart().toString());
        this.timeEnd = new SimpleStringProperty(regularWork.showTimeEnd().toString());
        this.priority = new SimpleIntegerProperty(regularWork.showPriority());
        this.category = new SimpleStringProperty(regularWork.showCategory());
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

        edit = new Button("edit");
        edit.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                try{
                    Image icon = new Image(getClass().getResourceAsStream("/images/140-1404099_important-clipart-todo-list-do-list-icon-png.png"));
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/editregularwork.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setTitle("Task Tracking");
                    stage.getIcons().add(icon);
                    stage.setResizable(false);
                    stage.setScene(new Scene(root1));
                    EditRegularController editRegularController = fxmlLoader.getController();
                    editRegularController.setRegularWork(regularWork);
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
    public Button getDate(){
        return date;
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
