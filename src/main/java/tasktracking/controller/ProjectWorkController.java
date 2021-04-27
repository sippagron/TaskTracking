package tasktracking.controller;

import com.github.saacsos.FXRouter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;

public class ProjectWorkController {
    @FXML

    public void handleUseBackButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("home");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า home ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    public void handleSelectProjectWorkButton(ActionEvent actionEvent) {
        try {

            FXRouter.goTo("searchprojectwork");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า home ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    public void handleAddProjectWorkButton(ActionEvent actionEvent) {
        try {

            FXRouter.goTo("addprojectwork");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า home ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    public void handleCategoryProjectWorkButton(ActionEvent actionEvent) {
        try {

            FXRouter.goTo("categoryprojectwork");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า home ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }
}
