package cookbook;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import java.sql.Statement;
import cookbook.connection.ConnectionUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javafx.stage.Stage;

public class RecipeControler implements Initializable {

  @FXML
  private Button addButton;

  @FXML
  private Label Tags;

  @FXML
  private Button tagbutton;

  @FXML
  private TextField tagsField;

  @FXML
  private Label name;

  @FXML
  private Label sh_description;

  @FXML
  private Label steps;

  @FXML
  private TextField ingreField;

  @FXML
  private TextField amountField;

  @FXML
  private ComboBox<String> unit;

  @FXML
  private ComboBox<String> selecttag;

  @FXML
  private Button addIngbutton;

  @FXML
  private Button closebutton;

  @FXML
  private Button addselected;

  @FXML
  private TextArea Sh_des_FieldText;

  @FXML
  private TextArea lo_des_FieldText;

  @FXML
  private TextArea nameFieldText;

  @FXML
  private TextArea stepsFieldText;

  Stage stage = new Stage();

  Scene scene;

  Parent root;

  Connection connection = null;

  int rss;
  int recipeId;
  int ingId;
  int tagid;
  int rs;
  int r;
  ResultSet res;

  public RecipeControler() {
    connection = ConnectionUtil.connectDB();
  }

  @FXML
  void ButtonOnAction(ActionEvent event) throws IOException {

    String name = nameFieldText.getText().toString();
    String shortdescription = Sh_des_FieldText.getText().toString();
    String longdescription = lo_des_FieldText.getText().toString();
    String steps = stepsFieldText.getText().toString();

    try {
      PreparedStatement preparedStatement1 = connection.prepareStatement(
          "insert into recipes (name,short_description,description,steps) values(?,?,?,?)",
          Statement.RETURN_GENERATED_KEYS);
      preparedStatement1.setString(1, name);
      preparedStatement1.setString(2, shortdescription);
      preparedStatement1.setString(3, longdescription);
      preparedStatement1.setString(4, steps);
      rss = preparedStatement1.executeUpdate();
      ResultSet resultSet = preparedStatement1.getGeneratedKeys();
      if (resultSet.next()) {
        recipeId = resultSet.getInt(1);
        System.out.print("id is " + recipeId);
      }

      if (rss == 1) {
        JOptionPane.showMessageDialog(null, "Your recipe added successfully! ");
        nameFieldText.setText(null);
        Sh_des_FieldText.setText(null);
        lo_des_FieldText.setText(null);
        stepsFieldText.setText(null);

      } else {
        JOptionPane.showMessageDialog(null, "Failed");
      }

    } catch (SQLException error) {
      System.out.println("An error has occurred: " + error.getMessage());
    }
  }

  @FXML
  void addIngbutton(ActionEvent event) throws SQLException {
    String ingname = ingreField.getText().toString();
    String ingamount = amountField.getText().toString();
    String unitcom = unit.getSelectionModel().getSelectedItem().toString();

    try {
      PreparedStatement ps = connection.prepareStatement(
          "insert into recipes (name,short_description,description,steps) values(?,?,?,?)",
          Statement.RETURN_GENERATED_KEYS);

      ResultSet resultSet = ps.getGeneratedKeys();
      if (resultSet.next()) {
        recipeId = resultSet.getInt(1);
        System.out.print("id is " + recipeId);
      }

      PreparedStatement prep = connection.prepareStatement(
          "INSERT INTO recipeingredients (RecipeId,ingredientId,amount,unit) VALUES (?,?,?,?)");
      PreparedStatement prep2 = connection.prepareStatement("INSERT INTO ingredients (name) VALUES (?)",
          Statement.RETURN_GENERATED_KEYS);

      prep2.setString(1, ingname);
      prep2.executeUpdate();
      ResultSet rsm = prep2.getGeneratedKeys();
      if (rsm.next()) {
        ingId = rsm.getInt(1);
      }

      prep.setInt(1, recipeId);
      prep.setInt(2, ingId);
      prep.setString(3, ingamount);
      prep.setString(4, unitcom);
      prep.executeUpdate();

      if (rss == 1) {
        JOptionPane.showMessageDialog(null, "Your ingredients added successfully! ");
        ingreField.setText(null);
        amountField.setText(null);

      } else {
        JOptionPane.showMessageDialog(null, "Failed");
      }

    } catch (SQLException error) {
      System.out.println("An error has occurred: " + error.getMessage());
    }
  }

  @FXML
  void addtagButton(ActionEvent event) throws SQLException {

    String tags = tagsField.getText().toString();
    try {
      PreparedStatement preparedStatement1 = connection.prepareStatement(
          "insert into recipes (name,short_description,description,steps) values(?,?,?,?)",
          Statement.RETURN_GENERATED_KEYS);
      PreparedStatement preparedStatement2 = connection.prepareStatement(
          "insert into tags (Name) values(?)",
          Statement.RETURN_GENERATED_KEYS);

      PreparedStatement preparedStatement3 = connection.prepareStatement(
          "insert into tagsrecipe (Recipe_id,Id) values(?,?)");
      preparedStatement2.setString(1, tags);

      rss = preparedStatement2.executeUpdate();
      ResultSet resultSet1 = preparedStatement1.getGeneratedKeys();
      if (resultSet1.next()) {
        recipeId = resultSet1.getInt(1);
        System.out.print("id is " + recipeId);
      }
      ResultSet resultSet2 = preparedStatement2.getGeneratedKeys();
      if (resultSet2.next()) {
        tagid = resultSet2.getInt(1);
        System.out.print("tag is " + tagid);
      }

      preparedStatement3.setInt(1, recipeId);
      preparedStatement3.setInt(2, tagid);
      r = preparedStatement3.executeUpdate();
      if (rss == 1) {
        JOptionPane.showMessageDialog(null, "Your tag added successfully! ");
        tagsField.setText(null);

      } else {
        JOptionPane.showMessageDialog(null, "Failed");
      }

    } catch (SQLException error) {
      System.out.println("An error has occurred: " + error.getMessage());
    }

  }

  @FXML
  void addselctedtag(ActionEvent event) {
    String selectatag = selecttag.getSelectionModel().getSelectedItem().toString();
    try {
      PreparedStatement preparedStatement1 = connection.prepareStatement(
          "insert into recipes (name,short_description,description,steps) values(?,?,?,?)",
          Statement.RETURN_GENERATED_KEYS);
      PreparedStatement preparedStatement4 = connection.prepareStatement(
          "Select * from tags Where Name=?");
      PreparedStatement preparedStatement3 = connection.prepareStatement(
          "insert into tagsrecipe (Recipe_id,Id) values(?,?)");

      ResultSet resultSet1 = preparedStatement1.getGeneratedKeys();

      if (resultSet1.next()) {
        recipeId = resultSet1.getInt(1);
        System.out.print("id is " + recipeId);
      }
      preparedStatement4.setString(1, selectatag);
      res = preparedStatement4.executeQuery();
      if (res.next()) {
        tagid = res.getInt("Id");
        System.out.print("tag is " + tagid);
      }

      preparedStatement3.setInt(1, recipeId);
      preparedStatement3.setInt(2, tagid);
      r = preparedStatement3.executeUpdate();
      if (rss == 1) {
        JOptionPane.showMessageDialog(null, "Your tag added successfully! ");
        tagsField.setText(null);

      } else {
        JOptionPane.showMessageDialog(null, "Failed");
      }

    } catch (SQLException error) {
      System.out.println("An error has occurred: " + error.getMessage());
    }

  }

  @FXML
  void closebuttonOnAction(ActionEvent event) throws IOException {
    root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main.fxml")));
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();

  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    ObservableList<String> list = FXCollections.observableArrayList("ml", "tbs", "l", "g", "kg", "cup", "pcs", "tbsp");
    unit.setItems(list);

    ObservableList<String> taglist = FXCollections.observableArrayList("vegetarian", "vegan", "lactose free",
        "gluten free", "starter", "main course", "dessert", "sweets");
    selecttag.setItems(taglist);
  }

}
