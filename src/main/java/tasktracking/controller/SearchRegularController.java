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
import tasktracking.models.GeneralWork;
import tasktracking.models.GeneralWorkTable;
import tasktracking.models.RegularWork;
import tasktracking.models.RegularWorkTable;
import tasktracking.services.FileManager;
import tasktracking.services.SearchGeneralTable;
import tasktracking.services.SearchRegularTable;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

public class SearchRegularController implements Initializable {

    private SearchRegularTable seeSearchRegularTable;
    private ObservableList<RegularWorkTable> observableList = FXCollections.observableArrayList();

    @FXML
    TableColumn<RegularWorkTable, String> JobName,Date,TimeStart,TimeEnd,Priority,Category;
    @FXML
    TableColumn<RegularWorkTable, Button> Status,Edit;
    @FXML
    private TableView table;


    public void handleUseBackButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("regularwork");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า regularwork ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                table.setStyle("-fx-alignment: CENTER;");
                seeSearchRegularTable = new SearchRegularTable(new FileManager().readFileRegularList());
                JobName.setCellValueFactory(new PropertyValueFactory<>("JobName"));
                Date.setCellValueFactory(new PropertyValueFactory<>("Date"));
                TimeStart.setCellValueFactory(new PropertyValueFactory<>("TimeStart"));
                TimeEnd.setCellValueFactory(new PropertyValueFactory<>("TimeEnd"));
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
        ArrayList<RegularWork> allWork = seeSearchRegularTable.getSearchRegularTable();
        Collections.sort(allWork);
        for (RegularWork i : allWork){
            observableList.add(new RegularWorkTable(i));
        }
        table.setItems(observableList);
    }

    public void handleOnEditChanges(TableColumn.CellEditEvent<RegularWorkTable, String> regularWorkTableStringCellEditEvent) {
        RegularWorkTable rwt = (RegularWorkTable) table.getSelectionModel().getSelectedItem();
        rwt.setJobName(regularWorkTableStringCellEditEvent.getNewValue());
    }

    public void handleRefreshButton(ActionEvent actionEvent) {
        table.setStyle("-fx-alignment: CENTER;");
        seeSearchRegularTable = new SearchRegularTable(new FileManager().readFileRegularList());
        JobName.setCellValueFactory(new PropertyValueFactory<>("JobName"));
        Date.setCellValueFactory(new PropertyValueFactory<>("Date"));
        TimeStart.setCellValueFactory(new PropertyValueFactory<>("TimeStart"));
        TimeEnd.setCellValueFactory(new PropertyValueFactory<>("TimeEnd"));
        Priority.setCellValueFactory(new PropertyValueFactory<>("Priority"));
        Status.setCellValueFactory(new PropertyValueFactory<>("Status"));
        Category.setCellValueFactory(new PropertyValueFactory<>("Category"));
        Edit.setCellValueFactory(new PropertyValueFactory<>("Edit"));
        refreshTable();
    }
}
