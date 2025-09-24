package cookbook;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;
import javax.swing.JOptionPane;
import javafx.scene.Node;
import java.sql.Statement;
import cookbook.connection.ConnectionUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.util.Objects;
import javafx.scene.control.ComboBox;

public class BrowseRecipeCont implements Initializable {
  Preferences userPreferences = Preferences.userRoot();
  String userName = userPreferences.get("Displayname", "Displayname");

  Stage stage = new Stage();

  Scene scene;

  Parent root;

  Connection connection = null;
  PreparedStatement preparedStatement = null;

  public BrowseRecipeCont() {
    connection = ConnectionUtil.connectDB();
  }

  @FXML
  private RadioButton star;

  @FXML
  private TextArea ScreenLD;

  @FXML
  private TextArea screenIngr;

  @FXML
  private TextArea screenSD;

  @FXML
  private TextArea screenSte;

  @FXML
  private TextField screen;

  @FXML
  private Button close;

  @FXML
  private Button starr;

  @FXML
  private Button unstar;

  @FXML
  private TextField Week;

  @FXML
  private ComboBox<String> comb;

  int rss;
  int recipeId;

  @FXML
  void close(ActionEvent event) throws IOException {
    root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main.fxml")));
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  @FXML
  void displaySelected(MouseEvent event) {
    String recipe = recipeList.getSelectionModel().getSelectedItem();
    String search = recipe.toString();

    screen.setText(recipe + " is selected");
    String query = "SELECT * from recipes where name = ?";
    String query2 = "SELECT Ingredients.name, RecipeIngredients.amount, RecipeIngredients.unit From Recipes join RecipeIngredients on Recipes.id = RecipeIngredients.RecipeId  Join Ingredients ON RecipeIngredients.IngredientId = Ingredients.id where Recipes.id=?";
    String details = " ";
    String shortDe = "Short descreption: \n";
    String LongDe = "Long descreption: \n";
    String steps = "Steps: \n";
    String id = " ";
    String ing = "Ingredients  \n";
    try {
      PreparedStatement stmt = connection.prepareStatement(query);
      PreparedStatement stmt2 = connection.prepareStatement(query2);
      stmt.setString(1, search);
      // stmt2.setString(1, search);
      ResultSet rs = stmt.executeQuery();

      if (rs.next()) {
        id = rs.getString(1);
        System.out.print(id);

        stmt2.setString(1, id);
        details += rs.getString(2);
        shortDe += rs.getString(3);
        LongDe += rs.getString(4);
        steps += rs.getString(5);
      }
      ResultSet rs2 = stmt2.executeQuery();

      while (rs2.next()) {
        ing += rs2.getString(1) + " ";
        ing += rs2.getString(2) + " ";
        ing += rs2.getString(3) + "\n";
      }

      screen.setText(details);
      screenSD.setText(shortDe);
      ScreenLD.setText(LongDe);
      screenSte.setText(steps);
      screenIngr.setText(ing);

    } catch (SQLException e) {
      System.out.println(e);
    }

  }

  ObservableList<String> list = FXCollections.observableArrayList();
  @FXML
  private ListView<String> recipeList;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    loadData();
    ObservableList<String> Daylist = FXCollections.observableArrayList("Monday", "Tuesday", "Wednesday", "Thursday",
        "Friday", "Saturday", "Sunday");
    comb.setItems(Daylist);
  }

  public void loadData() {

    list.removeAll(list);

    try {
      ArrayList<String> names = new ArrayList<String>();
      System.out.println("Connection established......");

      // Creating a Statement object
      Statement stmt = connection.createStatement();
      // Retrieving the data
      ResultSet rs = stmt.executeQuery("SELECT name from recipes");
      System.out.println("Contents of the table");
      while (rs.next()) {
        names.add(rs.getString("Name"));
      }
      list.addAll(names);

      // list.add(test);

      recipeList.getItems().addAll(list);
      // System.out.print(list);

    } catch (SQLException error) {
      System.out.println("An error has occurred: " + error.getMessage());
    }

  }

  @FXML
  void starOnAction(ActionEvent event) {
    String id = "";

    String query = "SELECT Id from recipes where name = ?";
    Preferences userPreferences = Preferences.userRoot();
    String userName = userPreferences.get("Displayname", "Displayname");
    String starQuery = "INSERT INTO StarRecipeUser VALUES (?,?)";
    String recipe = recipeList.getSelectionModel().getSelectedItem().toString();

    try {
      PreparedStatement stmt = connection.prepareStatement(query);
      stmt.setString(1, recipe);
      ResultSet rs = stmt.executeQuery();
      if (rs.next()) {
        id = rs.getString(1);
        System.out.print("the id is " + (id));
      }
      PreparedStatement preparedStatement1 = connection.prepareStatement(starQuery);

      preparedStatement1.setString(1, id);
      preparedStatement1.setString(2, userName);

      rss = preparedStatement1.executeUpdate();
      if (rss == 1) {
        JOptionPane.showMessageDialog(null, "recipe added to favorites successfully! ");

      } else {
        JOptionPane.showMessageDialog(null, "Failed");
      }

    } catch (SQLException error) {
      System.out.println("An error has occurred: " + error.getMessage());
    }

  }

  @FXML
  void unstarOnAction(ActionEvent event) throws SQLException {
    int rss1;
    String recipeId = "";
    String query = "SELECT Id from recipes where name = ?";
    Preferences userPreferences = Preferences.userRoot();
    String userName = userPreferences.get("Displayname", "Displayname");
    String unStarQuery = "DELETE from StarRecipeUser WHERE RecipeId = ? and Display_name =?";
    String recipe1 = recipeList.getSelectionModel().getSelectedItem().toString();
    try {
      PreparedStatement stmt = connection.prepareStatement(query);
      stmt.setString(1, recipe1);
      ResultSet res = stmt.executeQuery();
      if (res.next()) {
        recipeId = res.getString(1);
        if (res.getString(1).equals(recipeId)) {

          PreparedStatement deletStmt = connection.prepareStatement(unStarQuery);
          deletStmt.setString(1, recipeId);
          deletStmt.setString(2, userName);
          rss1 = deletStmt.executeUpdate();
          if (rss1 == 1) {
            JOptionPane.showMessageDialog(null, "recipe removed from favorites successfully! ");
          } else {
            JOptionPane.showMessageDialog(null, "recipe is not in your favorite");
          }
        }

      } else {
        JOptionPane.showMessageDialog(null, "Failed ");
      }
    } catch (SQLException error) {
      System.out.println("An error has occurred: " + error.getMessage());
    }

  }

  @FXML
  void AddToWeekly(ActionEvent event) {

    String weekk = Week.getText().toString();
    String dayd = comb.getSelectionModel().getSelectedItem().toString();
    Preferences userPreferences = Preferences.userRoot();
    String userName = userPreferences.get("Displayname", "Displayname");
    String recipe = recipeList.getSelectionModel().getSelectedItem().toString();

    try {
      String sql2 = "INSERT INTO Weeklylist (WeekNumber, Username, Recipe, Weekday) values (?, ?, ?, ?)";
      preparedStatement = connection.prepareStatement(sql2);
      preparedStatement.setString(1, weekk);
      preparedStatement.setString(2, userName);
      preparedStatement.setString(3, recipe);
      preparedStatement.setString(4, dayd);
      preparedStatement.executeUpdate();

      if (rss == 1) {

        JOptionPane.showMessageDialog(null, "Failed");

      } else {

        JOptionPane.showMessageDialog(null, "Added successfully to weeklylist! ");

      }

    } catch (SQLException error) {
      System.out.println("An error has occurred: " + error.getMessage());
    }
  }

}
