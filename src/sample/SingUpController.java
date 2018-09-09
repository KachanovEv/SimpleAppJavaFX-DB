package sample;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SingUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField lastname;

    @FXML
    private TextField username;

    @FXML
    private Button authSinginButtom;

    @FXML
    private PasswordField passwordSinUp;

    @FXML
    private TextField name;

    @FXML
    private TextField country;

    @FXML
    private CheckBox male;

    @FXML
    private CheckBox female;

    @FXML
    void initialize() {
        DatabaseHandler dbHandler = new DatabaseHandler();
        authSinginButtom.setOnAction(event -> {

          
            dbHandler.singUpUser(name.getText(), lastname.getText(), username.getText(), passwordSinUp.getText(), country.getText(), "Male" );

        });

    }
}
