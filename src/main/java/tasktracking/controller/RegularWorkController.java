package tasktracking.controller;

import com.github.saacsos.FXRouter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;

public class RegularWorkController {

    @FXML
    public void handleUseBackButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("home");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า home ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    @FXML
    public void handleSelectRegularWorkButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("searchregularwork");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า searchregularwork ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    @FXML
    public void handleAddRegularWorkButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("addregularwork");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า addregularwork ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    @FXML
    public void handleCategoryRegularWorkButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("categoryregularwork");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า categoryregularwork ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }
}
