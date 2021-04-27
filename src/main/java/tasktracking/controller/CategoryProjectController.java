package tasktracking.controller;

import com.github.saacsos.FXRouter;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import tasktracking.models.ForwardWork;
import tasktracking.models.ForwardWorkTable;
import tasktracking.models.ProjectWork;
import tasktracking.models.ProjectWorkTable;
import tasktracking.services.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

public class CategoryProjectController implements Initializable {
    @FXML
    ComboBox combo;

    private SearchProjectTable seeSearchProjectTable;
    private SearchCategoryProjectTable searchCategoryProjectTable;
    private ObservableList<ProjectWorkTable> observableList = FXCollections.observableArrayList();

    @FXML
    TableColumn<ProjectWorkTable, String> JobName,ProjectLeader,DateStart,DateEnd,Priority;
    @FXML
    TableColumn<ProjectWorkTable, Button> Status;
    @FXML
    private TableView table;

    public void handleUseBackButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("projectwork");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า projectwork ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    public void handleUseSubmitButton(ActionEvent actionEvent) {
        table.setStyle("-fx-alignment: CENTER;");
        seeSearchProjectTable = new SearchProjectTable(new FileManager().readFileProjectList());
        JobName.setCellValueFactory(new PropertyValueFactory<>("JobName"));
        ProjectLeader.setCellValueFactory(new PropertyValueFactory<>("ProjectLeader"));
        DateStart.setCellValueFactory(new PropertyValueFactory<>("DateStart"));
        DateEnd.setCellValueFactory(new PropertyValueFactory<>("DateEnd"));
        Priority.setCellValueFactory(new PropertyValueFactory<>("Priority"));
        Status.setCellValueFactory(new PropertyValueFactory<>("Status"));
        refreshTable(combo);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                ArrayList<String> test = new FileManager().checkCategoryProjectList();
                Collections.sort(test);
                for(int i=0;i<test.size();i++){
                    combo.getItems().add(test.get(i));
                }
            }
        });
    }

    private void refreshTable(ComboBox combo){
        observableList.clear();
        for (ProjectWork i : seeSearchProjectTable.getSearchProjectTable()){
            if(i.showCategory().equals(combo.getSelectionModel().getSelectedItem())){
                observableList.add(new ProjectWorkTable(i));
            }
        }
        table.setItems(observableList);
    }

}
