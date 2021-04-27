package tasktracking.controller;

import com.github.saacsos.FXRouter;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import tasktracking.models.*;
import tasktracking.services.FileManager;
import tasktracking.services.SearchForwardTable;
import tasktracking.services.SearchProjectTable;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

public class SearchProjectController implements Initializable {

    private SearchProjectTable seeSearchProjectTable;
    private ObservableList<ProjectWorkTable> observableList = FXCollections.observableArrayList();

    @FXML
    TableColumn<ForwardWorkTable, String> JobName,DateStart,DateEnd,Priority,Category,ProjectLeader;
    @FXML
    TableColumn<ForwardWorkTable, Button> Status,Edit;
    @FXML
    private TableView table;

    public void handleUseBackButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("projectwork");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า forwardwork ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    public void handleOnEditChanges(TableColumn.CellEditEvent<ProjectWorkTable, String> projectWorkTableStringCellEditEvent) {
        ProjectWorkTable pwt = (ProjectWorkTable) table.getSelectionModel().getSelectedItem();
        pwt.setJobName(projectWorkTableStringCellEditEvent.getNewValue());
    }

    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                table.setStyle("-fx-alignment: CENTER;");
                seeSearchProjectTable = new SearchProjectTable(new FileManager().readFileProjectList());
                JobName.setCellValueFactory(new PropertyValueFactory<>("JobName"));
                ProjectLeader.setCellValueFactory(new PropertyValueFactory<>("ProjectLeader"));
                DateStart.setCellValueFactory(new PropertyValueFactory<>("DateStart"));
                DateEnd.setCellValueFactory(new PropertyValueFactory<>("DateEnd"));
                Priority.setCellValueFactory(new PropertyValueFactory<>("Priority"));
                Status.setCellValueFactory(new PropertyValueFactory<>("Status"));
                Category.setCellValueFactory(new PropertyValueFactory<>("Category"));
                Edit.setCellValueFactory(new PropertyValueFactory<>("Edit"));
                refreshTable();
            }
        });
    }

    private void refreshTable(){
        observableList.clear();
        ArrayList<ProjectWork> allWork = seeSearchProjectTable.getSearchProjectTable();
        Collections.sort(allWork);
        for (ProjectWork i : allWork){
            observableList.add(new ProjectWorkTable(i));
        }
        table.setItems(observableList);
    }

    public void handleRefreshButton(ActionEvent actionEvent) {
        table.setStyle("-fx-alignment: CENTER;");
        seeSearchProjectTable = new SearchProjectTable(new FileManager().readFileProjectList());
        JobName.setCellValueFactory(new PropertyValueFactory<>("JobName"));
        ProjectLeader.setCellValueFactory(new PropertyValueFactory<>("ProjectLeader"));
        DateStart.setCellValueFactory(new PropertyValueFactory<>("DateStart"));
        DateEnd.setCellValueFactory(new PropertyValueFactory<>("DateEnd"));
        Priority.setCellValueFactory(new PropertyValueFactory<>("Priority"));
        Status.setCellValueFactory(new PropertyValueFactory<>("Status"));
        Category.setCellValueFactory(new PropertyValueFactory<>("Category"));
        Edit.setCellValueFactory(new PropertyValueFactory<>("Edit"));
        refreshTable();
    }
}
