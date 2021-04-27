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
import tasktracking.models.RegularWork;
import tasktracking.models.RegularWorkTable;
import tasktracking.services.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

public class CategoryRegularController implements Initializable {
    @FXML
    ComboBox combo;

    private SearchRegularTable seeSearchRegularTable;
    private SearchCategoryRegularTable searchCategoryRegularTable;
    private ObservableList<RegularWorkTable> observableList = FXCollections.observableArrayList();

    @FXML
    TableColumn<RegularWorkTable, String> JobName,Date,TimeStart,TimeEnd,Priority;
    @FXML
    TableColumn<RegularWorkTable, Button> Status;
    @FXML
    private TableView table;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                ArrayList<String> test = new FileManager().checkCategoryRegularList();
                Collections.sort(test);
                for(int i=0;i<test.size();i++){
                    combo.getItems().add(test.get(i));
                }
            }
        });
    }
    private void refreshTable(ComboBox combo){
        observableList.clear();
        for (RegularWork i : seeSearchRegularTable.getSearchRegularTable()){
            if(i.showCategory().equals(combo.getSelectionModel().getSelectedItem())){
                observableList.add(new RegularWorkTable(i));
            }

        }
        table.setItems(observableList);
    }

    public void handleUseBackButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("regularwork");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า regularwork ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    public void handleUseSubmitButton(ActionEvent actionEvent) {
        table.setStyle("-fx-alignment: CENTER;");
        seeSearchRegularTable = new SearchRegularTable(new FileManager().readFileRegularList());
        JobName.setCellValueFactory(new PropertyValueFactory<>("JobName"));
        Date.setCellValueFactory(new PropertyValueFactory<>("Date"));
        TimeStart.setCellValueFactory(new PropertyValueFactory<>("TimeStart"));
        TimeEnd.setCellValueFactory(new PropertyValueFactory<>("TimeEnd"));
        Priority.setCellValueFactory(new PropertyValueFactory<>("Priority"));
        Status.setCellValueFactory(new PropertyValueFactory<>("Status"));
        refreshTable(combo);
    }
}
