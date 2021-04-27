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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.TextFieldTableCell;
import tasktracking.models.GeneralWork;
import tasktracking.models.GeneralWorkTable;
import tasktracking.services.FileManager;
import tasktracking.services.SearchGeneralTable;
import javafx.event.EventHandler;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.ResourceBundle;

public class SearchGeneralController implements Initializable {

    private SearchGeneralTable seeSearchGeneralTable;
    private ObservableList<GeneralWorkTable> observableList = FXCollections.observableArrayList();

    @FXML
    TableColumn<GeneralWorkTable, String> JobName,Date,TimeStart,TimeEnd,Priority,Category;
    @FXML
    TableColumn<GeneralWorkTable, Button> Status,Edit;
    @FXML
    private TableView table;


    @FXML
    public void handleUseBackButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("generalwork");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า generalwork ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                table.setStyle("-fx-alignment: CENTER;");
                seeSearchGeneralTable = new SearchGeneralTable(new FileManager().readFileGenaralList());
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
        ArrayList<GeneralWork> allWork = seeSearchGeneralTable.getSearchGeneralTable();
        Collections.sort(allWork);
        for (GeneralWork i : allWork){
            observableList.add(new GeneralWorkTable(i));
        }
        table.setItems(observableList);
    }

    public void handleOnEditChanges(TableColumn.CellEditEvent<GeneralWorkTable, String> generalWorkTableStringCellEditEvent) {
        GeneralWorkTable gwt = (GeneralWorkTable) table.getSelectionModel().getSelectedItem();
        gwt.setJobName(generalWorkTableStringCellEditEvent.getNewValue());
    }

    public void handleRefreshButton(ActionEvent actionEvent) {
        table.setStyle("-fx-alignment: CENTER;");
        seeSearchGeneralTable = new SearchGeneralTable(new FileManager().readFileGenaralList());
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
