package cookbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import cookbook.connection.ConnectionUtil;

public class CreateDataBase {

  /**
   * main program to create database and creat tables.
   * 
   * @param args .
   */
  public static void main(String[] args) {

    // open a connection
    // creat data base Cook book.
    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "3232056Sha+");
        Statement stmt = conn.createStatement();

    ) {
      String sql = "CREATE DATABASE CookBook";
      stmt.executeUpdate(sql);
      System.out.println("Database created successfully...");
      stmt.close();
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    // connect to new data base and creat tabels.
    try (Connection connection = ConnectionUtil.connectDB();

        Statement stmt = connection.createStatement();) {

      // creat recipes tabel
      String sql = "CREATE TABLE recipes "
          + "(Id INTEGER not NULL AUTO_INCREMENT,"
          + "name VARCHAR(255),"
          + " short_description VARCHAR(255),"
          + " description VARCHAR(255),"
          + " steps TEXT,"
          + " PRIMARY KEY (Id))";

      stmt.executeUpdate(sql);
      System.out.println("recipes table created..!");

      String sql1 = "CREATE TABLE Ingredients "
          + "(Id INTEGER not NULL AUTO_INCREMENT,"
          + "name VARCHAR(255), "
          + " PRIMARY KEY (Id))";
      stmt.executeUpdate(sql1);
      System.out.println("Ingredients table created..!");

      String sqlR = "CREATE TABLE RecipeIngredients "
          + "(RecipeId INTEGER, "
          + "IngredientId INTEGER, "
          + " amount FLOAT, "
          + " unit VARCHAR(255))";

      stmt.executeUpdate(sqlR);
      System.out.println("Join table between Ingredient and recipes created..!");

      String sql2 = "CREATE TABLE User "
          + "(First_name VARCHAR(255), "
          + " Last_name VARCHAR(255), "
          + "Display_name VARCHAR(255) not NULL,"
          + "password VARCHAR(255),"
          + " PRIMARY KEY ( Display_name ))";

      stmt.executeUpdate(sql2);
      System.out.println("User table created..!");

      String sqlConn = "CREATE TABLE StarRecipeUser "
          + "(RecipeId INTEGER, "
          + "Display_name VARCHAR(255)) ";

      stmt.executeUpdate(sqlConn);
      System.out.println("Join table between user and star recipes created..!");

      String sql33 = "CREATE TABLE Tags"
          + "(Id INTEGER  AUTO_INCREMENT, "
          + "Name VARCHAR(255),"
          + " PRIMARY KEY (Id))";
      stmt.executeUpdate(sql33);

      System.out.println("Tags tables created...!");

      String sql4 = "CREATE TABLE tagsrecipe"
          + "(Recipe_id INTEGER ,"
          + "Id INTEGER)";

      stmt.executeUpdate(sql4);
      System.out.println("Connecting_table created...!");

      String sql5 = "CREATE TABLE Weeklylist"
          + "(WeekNumber INTEGER, "
          + " Username VARCHAR(255), "
          + " Recipe VARCHAR(255),"
          + " Weekday VARCHAR(255))";

      stmt.executeUpdate(sql5);
      System.out.println("Weeklylist table created..!");

      String sqlHelp = "CREATE TABLE HelpCenter "
          + "(Home TEXT,"
          + " Browse TEXT,"
          + " Weekly_List TEXT,"
          + " Add_Recipe TEXT,"
          + " Search TEXT,"
          + " Additional_Info TEXT)";

      stmt.executeUpdate(sqlHelp);
      System.out.println("Help Center table created..!");
      stmt.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

}
