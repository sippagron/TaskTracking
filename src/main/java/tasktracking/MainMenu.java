package tasktracking;

import com.github.saacsos.FXRouter;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import tasktracking.services.FileManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class MainMenu extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXRouter.bind(this, primaryStage, "Task Tracking", 1000, 600);
        Image icon = new Image(getClass().getResourceAsStream("/images/140-1404099_important-clipart-todo-list-do-list-icon-png.png"));
        primaryStage.getIcons().add(icon);
        primaryStage.setResizable(false);
        primaryStage.show();

        configRoute();
        FXRouter.goTo("home");
    }

    private static void configRoute() {
        FXRouter.when("home", "FXML/home.fxml");
        FXRouter.when("profile", "FXML/profile.fxml");
        FXRouter.when("generalwork", "FXML/generalworkmenu.fxml");
        FXRouter.when("regularwork", "FXML/regularworkmenu.fxml");
        FXRouter.when("forwardwork", "FXML/forwardworkmenu.fxml");
        FXRouter.when("projectwork", "FXML/projectworkmenu.fxml");

        FXRouter.when("searchgeneralwork", "FXML/searchgeneralwork.fxml");
        FXRouter.when("addgeneralwork", "FXML/addgeneralwork.fxml");
        FXRouter.when("editgeneralwork", "FXML/editgeneralwork.fxml");
        FXRouter.when("categorygeneralwork", "FXML/categorygeneralwork.fxml");

        FXRouter.when("searchregularwork", "FXML/searchregularwork.fxml");
        FXRouter.when("addregularwork", "FXML/addregularwork.fxml");
        FXRouter.when("editregularwork", "FXML/editregularwork.fxml");
        FXRouter.when("categoryregularwork", "FXML/categoryregularwork.fxml");

        FXRouter.when("searchforwardwork", "FXML/searchforwardwork.fxml");
        FXRouter.when("addforwardwork", "FXML/addforwardwork.fxml");
        FXRouter.when("editforwardwork", "FXML/editforwardwork.fxml");
        FXRouter.when("categoryforwardwork", "FXML/categoryforwardwork.fxml");

        FXRouter.when("searchprojectwork", "FXML/searchprojectwork.fxml");
        FXRouter.when("addprojectwork", "FXML/addprojectwork.fxml");
        FXRouter.when("editprojectwork", "FXML/editprojectwork.fxml");
        FXRouter.when("categoryprojectwork", "FXML/categoryprojectwork.fxml");
    }

    public static void main(String[] args){
        launch(args);

    }

}
