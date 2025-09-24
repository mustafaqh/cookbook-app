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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;


import cookbook.connection.ConnectionUtil;

public class Controller implements Initializable {
  private Stage stage;
  private Scene scene;
  private Parent root;

  @FXML
  private TextArea theDetails;

  @FXML
  private Label mainUserName;

  @FXML
  private Label mainrRecipeName;

  @FXML
  private ImageView helpCenter;
  Connection conn = null;
  public Controller() {
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

  public void switchToShop(ActionEvent event) throws IOException {
    root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("shop.fxml")));
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

  @FXML

  ListView<String> mainFavoriteRecipe;
  ObservableList<String> fav = FXCollections.observableArrayList();

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    laodListItem();
  }

  public void laodListItem() {
    Preferences userPreferences = Preferences.userRoot();
    String userName = userPreferences.get("Displayname", "Displayname");
    String sqll = "SELECT RecipeId from starrecipeuser WHERE Display_name =?";
    ArrayList<String> ResBames = new ArrayList<String>();
    String sqll2 = "SELECT name from recipes WHERE Id =?";
    mainUserName.setText(userName);

    try {
      fav.removeAll(fav);
      PreparedStatement stmet = conn.prepareStatement(sqll);
      stmet.setString(1, userName);
      ResultSet rs = stmet.executeQuery();

      while (rs.next()) {
        String recId = rs.getString(1);
        PreparedStatement stmt1 = conn.prepareStatement(sqll2);
        stmt1.setString(1, recId);
        ResultSet res1 = stmt1.executeQuery();
        if (res1.next()) {
          String name = res1.getString("name");
          ResBames.add(name);

        }

      }

      fav.addAll(ResBames);

      mainFavoriteRecipe.getItems().addAll(fav);

    } catch (SQLException e) {
      System.out.println(e);
    }

  }

  @FXML
  void showDetail(MouseEvent event) {
    String recipe = (String) mainFavoriteRecipe.getSelectionModel().getSelectedItem();
    String x = recipe.toString();
    System.out.println(x);
    String query = "SELECT* from recipes where name = ?";
    String query2 = "SELECT Ingredients.name, RecipeIngredients.amount, RecipeIngredients.unit From Recipes join RecipeIngredients on Recipes.id = RecipeIngredients.RecipeId  Join Ingredients ON RecipeIngredients.IngredientId = Ingredients.id where Recipes.id=?";
    String d1 = " ";
    String d2 = "\nIngredients : \n";

    String id = "";

    try {

      
      PreparedStatement stmt = conn.prepareStatement(query);
      PreparedStatement stmt2 = conn.prepareStatement(query2);
      stmt.setString(1, x);
      ResultSet rs = stmt.executeQuery();

      if (rs.next()) {

        mainrRecipeName.setText(rs.getString(2) + ":");

        d1 += ("\n" + "Short Discription :\n" + rs.getString(3) + "\n" + "\n"
            + "Discription : \n" + rs.getString(4) + "\n" + "\n"
            + "Steps : \n" + rs.getString(5) + "\n");
        id = rs.getString(1);
      }

      stmt2.setString(1, id);
      ResultSet rs2 = stmt2.executeQuery();
      while (rs2.next()) {
        d2 += (rs2.getString(1) + " " + rs2.getString(2) + " " + rs2.getString(3) + "\n");
      }
      String d3 = d1 + d2;
      theDetails.setText(d3);

    } catch (SQLException e) {
      System.out.println(e);
    }

  }

  @FXML
  void openHelpCenter(MouseEvent event) throws IOException {
    root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("helpcenter.fxml")));
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  @FXML
  void Logout(MouseEvent event) throws IOException {
    root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("welcome.fxml")));
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();

  }

}
