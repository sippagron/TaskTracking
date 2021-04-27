package tasktracking.controller;

import com.github.saacsos.FXRouter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;

public class GeneralWorkController {

    @FXML

    public void handleUseBackButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("home");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า home ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    public void handleSelectGeneralWorkButton(ActionEvent actionEvent){
        try {
            FXRouter.goTo("searchgeneralwork");
        }catch (IOException e) {
            System.err.println("ไปที่หน้า searchgenaralwork ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    public void handleAddGeneralWorkButton(ActionEvent actionEvent){
        try {
            FXRouter.goTo("addgeneralwork");
        }catch (IOException e) {
            System.err.println("ไปที่หน้า addgeneralwork ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    public void handleCategoryGeneralWorkButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("categorygeneralwork");
        }catch (IOException e) {
            System.err.println("ไปที่หน้า categorygeneralwork ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }
}
