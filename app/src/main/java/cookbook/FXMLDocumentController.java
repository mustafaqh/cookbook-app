package cookbook;

import cookbook.connection.ConnectionUtil;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

import javafx.scene.control.Alert.AlertType;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable {

  @FXML
  private TextField nameField;
  @FXML
  private PasswordField passwordField;

  Stage stage = new Stage();
  Scene scene;

  Connection connection = null;
  PreparedStatement preparedStatement = null;
  ResultSet rs = null;

  public FXMLDocumentController() {
    connection = ConnectionUtil.connectDB();
  }

  @FXML
  private void handleButtonAction(ActionEvent event) {

    String Displayname = nameField.getText().toString();
    String password = passwordField.getText().toString();
    String sql = "SELECT * FROM user WHERE Display_name = ? and password = ?";
    try {
      preparedStatement = connection.prepareStatement(sql);

      preparedStatement.setString(1, Displayname);
      preparedStatement.setString(2, password);
      rs = preparedStatement.executeQuery();
      if (!rs.next()) {
        Box("Enter Correct Username and Password", "Failed", null);
      } else {
        Box("Welcome " + Displayname, "Success", null);

        Preferences userPreferences = Preferences.userRoot();
        userPreferences.put("Displayname", Displayname);

        Node source = (Node) event.getSource();
        stage = (Stage) source.getScene().getWindow();
        stage.close();
        scene = new Scene(FXMLLoader.load(getClass().getResource("main.fxml")));
        stage.setScene(scene);
        ;
        stage.show();

      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void Box(String infoMessage, String titleBar, String headerMessage) {
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle(titleBar);
    alert.setHeaderText(headerMessage);
    alert.setContentText(infoMessage);
    alert.showAndWait();
  }

  @Override
  public void initialize(URL url, ResourceBundle rb) {

  }
}