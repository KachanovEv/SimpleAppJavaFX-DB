package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login_field;

    @FXML
    private Button authSinginButtom;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button loginSingUpButtom;

    @FXML
    void initialize() {

        authSinginButtom.setOnAction(event -> {
            String loginText = login_field.getText().trim();
            String loginPassword = password_field.getText().trim();

            if(!loginText.equals("") && !loginPassword.equals(""))
                loginUser(loginText, loginPassword);
            else
                System.out.println("Login and password is empty");
        });

        loginSingUpButtom.setOnAction(event -> {
            loginSingUpButtom.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/singUP.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();

        });
    }

    private void loginUser(String loginText, String loginPassword) {
    }
}



//assert login_field != null : "fx:id=\"login_field\" was not injected: check your FXML file 'sample.fxml'.";
  //      assert authSinginButtom != null : "fx:id=\"authSinginButtom\" was not injected: check your FXML file 'sample.fxml'.";
    //    assert password_field != null : "fx:id=\"password_field\" was not injected: check your FXML file 'sample.fxml'.";
      //  assert loginSingUpButtom != null : "fx:id=\"loginSingUpButtom\" was not injected: check your FXML file 'sample.fxml'.";