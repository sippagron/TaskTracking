package tasktracking;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Profile {
    @FXML
    private ImageView image;

    @FXML
    public void initialize() {
        image.setImage(new Image("/S__146718738.jpg"));
    }
}
