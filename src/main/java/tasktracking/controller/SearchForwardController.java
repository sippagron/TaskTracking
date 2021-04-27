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
import tasktracking.models.ForwardWork;
import tasktracking.models.ForwardWorkTable;
import tasktracking.models.GeneralWork;
import tasktracking.models.GeneralWorkTable;
import tasktracking.services.FileManager;
import tasktracking.services.SearchForwardTable;
import tasktracking.services.SearchGeneralTable;
import tasktracking.services.SearchRegularTable;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

public class SearchForwardController implements Initializable {

    private SearchForwardTable seeSearchForwardTable;
    private ObservableList<ForwardWorkTable> observableList = FXCollections.observableArrayList();

    @FXML
    TableColumn<ForwardWorkTable, String> JobName,Date,TimeStart,TimeEnd,Priority,Category,ResponsibleMan;
    @FXML
    TableColumn<ForwardWorkTable, Button> Status,Edit;
    @FXML
    private TableView table;

    @FXML
    public void handleUseBackButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("forwardwork");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า forwardwork ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                table.setStyle("-fx-alignment: CENTER;");
                seeSearchForwardTable = new SearchForwardTable(new FileManager().readFileForwardList());
                JobName.setCellValueFactory(new PropertyValueFactory<>("JobName"));
                ResponsibleMan.setCellValueFactory(new PropertyValueFactory<>("ResponsibleMan"));
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
        ArrayList<ForwardWork> allWork = seeSearchForwardTable.getSearchForwardTable();
        Collections.sort(allWork);
        for (ForwardWork i : allWork){
            observableList.add(new ForwardWorkTable(i));
        }
        table.setItems(observableList);
    }

    public void handleOnEditChanges(TableColumn.CellEditEvent<ForwardWorkTable, String> forwardWorkTableStringCellEditEvent) {
        ForwardWorkTable fwt = (ForwardWorkTable) table.getSelectionModel().getSelectedItem();
        fwt.setJobName(forwardWorkTableStringCellEditEvent.getNewValue());
    }
    public void handleRefreshButton(ActionEvent actionEvent) {
        table.setStyle("-fx-alignment: CENTER;");
        seeSearchForwardTable = new SearchForwardTable(new FileManager().readFileForwardList());
        JobName.setCellValueFactory(new PropertyValueFactory<>("JobName"));
        ResponsibleMan.setCellValueFactory(new PropertyValueFactory<>("ResponsibleMan"));
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
