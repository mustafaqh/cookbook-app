
package cookbook;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

import cookbook.connection.ConnectionUtil;

public class SearchController {
  private Stage stage;
  private Scene scene;
  private Parent root;

  private Connection conn = null;

  public SearchController() {
    conn = ConnectionUtil.connectDB();
  }

  public void switchToHome(javafx.event.ActionEvent event) throws IOException {
    root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main.fxml")));
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  public void switchToBrowse(javafx.event.ActionEvent event) throws IOException {
    root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("browseRecipe.fxml")));
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  public void switchToAdd(javafx.event.ActionEvent event) throws IOException {
    root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("recipe.fxml")));
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  public void switchToWeek(ActionEvent event) throws IOException {
    root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("week2.fxml")));
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  public void switchToSearch(ActionEvent event) throws IOException {
    root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("search.fxml")));
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  public void switchToMess(ActionEvent event) throws IOException {
    root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mess.fxml")));
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  
  @FXML
  private TextField textField;

  @FXML
  private Label labelName;

  @FXML
  private TextArea details;

  @FXML
  private ListView<String> list = new ListView<>();

  public void searchByName(ActionEvent event) {
    list.getItems().clear();

    try {


      String sql = "Select * from recipes where name = ?";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, textField.getText());
      System.out.println(textField.getText());
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        list.getItems().add(rs.getString("name"));
      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

  }

  public void searchByTag(ActionEvent event) {
    list.getItems().clear();
    try {
      list.refresh();
      String sql = "SELECT recipes.name FROM `recipes` JOIN tagsrecipe on recipes.Id=tagsrecipe.Recipe_id join tags on tagsrecipe.Id = tags.Id where tags.Name = ?";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, textField.getText());
      System.out.println(textField.getText());
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        list.getItems().add(rs.getString("name"));
      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void searchByIng(ActionEvent event) {
    list.getItems().clear();

    try {

      
      String sql = "SELECT recipes.name FROM `recipes` JOIN recipeingredients on recipes.Id = recipeingredients.RecipeId join ingredients on recipeingredients.IngredientId = ingredients.Id where ingredients.name = ?";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, textField.getText());
      System.out.println(textField.getText());
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        list.getItems().add(rs.getString("name"));
      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @FXML
  public void clearSearch(ActionEvent event) {
    textField.setText("");
  }

  @FXML
  void displaySelected(MouseEvent event) {
    String recipe = (String) list.getSelectionModel().getSelectedItem();
    String x = recipe.toString();
    System.out.println(x);
    String query = "SELECT* from recipes where name = ?";
    String query2 = "SELECT Ingredients.name, RecipeIngredients.amount, RecipeIngredients.unit From Recipes join RecipeIngredients on Recipes.id = RecipeIngredients.RecipeId  Join Ingredients ON RecipeIngredients.IngredientId = Ingredients.id where Recipes.id=?";
    Text t = new Text("short discription :");
    t.setFont(Font.font("Broadway", 10));
    String id = "";
    String s1 = "";
    String s2 = "\nIngredients : \n";

    try {

      
      PreparedStatement stmt = conn.prepareStatement(query);
      PreparedStatement stmt2 = conn.prepareStatement(query2);
      stmt.setString(1, x);
      ResultSet rs = stmt.executeQuery();
      if (rs.next()) {
        labelName.setText(rs.getString(2) + ":");
        id = rs.getString(1);
        s1 += ("short discription :\n" + rs.getString(3) + "\n" + "\n"
            + "discription : \n" + rs.getString(4) + "\n" + "\n"
            + "Steps : \n" + rs.getString(5) + "\n");
        id = rs.getString(1);
      }
      stmt2.setString(1, id);
      ResultSet rs2 = stmt2.executeQuery();
      while (rs2.next()) {
        s2 += (rs2.getString(1) + " " + rs2.getString(2) + " " + rs2.getString(3) + "\n");
      }
      String s = s1 + s2;
      details.setText(s);

    } catch (SQLException e) {
      System.out.println(e);
    }

  }

  @FXML
  void swichToHelpcenter(MouseEvent event) throws IOException {
    root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("helpcenter.fxml")));
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

}
