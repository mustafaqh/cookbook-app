package cookbook;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.scene.Node;
import javax.swing.JOptionPane;

import cookbook.connection.ConnectionUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class InController implements Initializable {

  @FXML
  private Button addButton;

  @FXML
  private Label amoun;

  @FXML
  private TextField amountField;

  @FXML
  private Label name;

  @FXML
  private TextField nameField;

  @FXML
  private Button saveButton;

  @FXML
  private Label unite;

  @FXML
  private TextField uniteField;
  Stage stage = new Stage();
  Scene scene;
  Parent root;
  Connection connection = null;
  PreparedStatement preparedStatement = null;
  int rs;

  public InController() {
    connection = ConnectionUtil.connectDB();
  }

  @FXML
  void addButtonOnAction(ActionEvent event) throws IOException {
    String n = nameField.getText().toString();
    String u = uniteField.getText().toString();
    String a = amountField.getText().toString();
    String query = "INSERT INTO ingredients (name,unit,amount) VALUES (?,?,?)";
    try {
      preparedStatement = connection.prepareStatement(query);
      preparedStatement.setString(1, n);
      preparedStatement.setString(2, u);
      preparedStatement.setString(3, a);
      rs = preparedStatement.executeUpdate();
      if (rs == 1) {
        JOptionPane.showMessageDialog(null, "Your ingredients added successfully!");
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("in.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

      } else {
        JOptionPane.showMessageDialog(null, "Failed");
      }

    } catch (SQLException error) {
      System.out.println("An error has occurred: " + error.getMessage());
    }

  }

  @FXML
  void saveButtonOnAction(ActionEvent event) throws IOException {
    String n = nameField.getText().toString();
    String u = uniteField.getText().toString();
    String a = amountField.getText().toString();
    String query = "INSERT INTO ingredients (name,unit,amount) VALUES (?,?,?)";
    try {
      preparedStatement = connection.prepareStatement(query);
      preparedStatement.setString(1, n);
      preparedStatement.setString(2, u);
      preparedStatement.setString(3, a);
      rs = preparedStatement.executeUpdate();
      if (rs == 1) {
        JOptionPane.showMessageDialog(null, "Your ingredients added successfully! Return to main page");
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

      } else {
        JOptionPane.showMessageDialog(null, "Failed");
      }

    } catch (SQLException error) {
      System.out.println("An error has occurred: " + error.getMessage());
    }

  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    // TODO Auto-generated method stub

  }

}
