package cookbook;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.ListView;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

import javafx.scene.input.MouseEvent;

import cookbook.connection.ConnectionUtil;

import java.util.ArrayList;

import java.io.IOException;

import java.util.Objects;

public class WeeklyController implements Initializable {
  private Stage stage;
  private Scene scene;
  private Parent root;
  @FXML
  private ListView<String> WeeklyDinner;
  @FXML
  private ListView<String> Dinners;
  @FXML
  ObservableList<String> items = FXCollections.observableArrayList();

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
  public void switchToWeek(ActionEvent event) throws IOException {
    root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("week2.fxml")));
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  @FXML
  void onSelection(MouseEvent event) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet rs2 = null;
    connection = ConnectionUtil.connectDB();
    int week = Integer.parseInt(WeeklyDinner.getSelectionModel().getSelectedItem());
    ObservableList<String> items2 = FXCollections.observableArrayList();
    ArrayList<String> weekitems = new ArrayList<String>();
    ArrayList<String> weekitems2 = new ArrayList<String>();
    Dinners.getItems().clear();
    Dinners.setItems(items2);
    Preferences userPreferences = Preferences.userRoot();
    String userName = userPreferences.get("Displayname", "Displayname");

    try {
      Statement stmt = connection.createStatement();
      String sql1 = "SELECT Name FROM LoggedIn";
      rs2 = stmt.executeQuery(sql1);
      String sql2 = "SELECT Recipe, Weekday FROM WeeklyList WHERE Username = ? AND WeekNumber = ? ORDER BY Weekday ASC";
      preparedStatement = connection.prepareStatement(sql2);
      rs2.next();
      preparedStatement.setString(1, userName);
      preparedStatement.setInt(2, week);
      rs2 = preparedStatement.executeQuery();

      while (rs2.next()) {
        String y = rs2.getString("Recipe");
        String z = rs2.getString("Weekday");
        weekitems.add(z + ": " + y);
      }

      weekitems2.add("");
      weekitems2.add("");
      weekitems2.add("");
      weekitems2.add("");
      weekitems2.add("");
      weekitems2.add("");
      weekitems2.add("");

      for (int x = 0; x < weekitems.size(); x++) {

        if (weekitems.get(x).startsWith("Mon")) {
          weekitems2.set(0, weekitems.get(x));
        }

        else if (weekitems.get(x).startsWith("Tue")) {
          weekitems2.set(1, weekitems.get(x));
        }

        else if (weekitems.get(x).startsWith("Wed")) {
          weekitems2.set(2, weekitems.get(x));
        }

        else if (weekitems.get(x).startsWith("Thu")) {
          weekitems2.set(3, weekitems.get(x));
        }

        else if (weekitems.get(x).startsWith("Fri")) {
          weekitems2.set(4, weekitems.get(x));
        }

        else if (weekitems.get(x).startsWith("Sat")) {
          weekitems2.set(5, weekitems.get(x));
        }

        else if (weekitems.get(x).startsWith("Sun")) {
          weekitems2.set(6, weekitems.get(x));
        }
      }

      for (int n = 0; n < weekitems2.size(); n++) {
        items2.add(weekitems2.get(n));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void initialize(URL location, ResourceBundle resources) {
    System.out.println("Initializing...");
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;
    connection = ConnectionUtil.connectDB();
    WeeklyDinner.setItems(items);
    try {
      Preferences userPreferences = Preferences.userRoot();
      String userName = userPreferences.get("Displayname", "Displayname");
      Statement stmt = connection.createStatement();
      String sql1 = "SELECT Name FROM LoggedIn";
      rs = stmt.executeQuery(sql1);
      String sql2 = "SELECT WeekNumber FROM WeeklyList WHERE Username = ? ORDER BY WeekNumber ASC";
      preparedStatement = connection.prepareStatement(sql2);
      rs.next();
      preparedStatement.setString(1, userName);
      rs = preparedStatement.executeQuery();
      while (rs.next()) {
        String x = Integer.toString(rs.getInt("WeekNumber"));
        if (!items.contains(x)) {
          items.add(x);
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
