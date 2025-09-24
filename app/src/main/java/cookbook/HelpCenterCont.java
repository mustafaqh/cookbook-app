package cookbook;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.scene.Node;

public class HelpCenterCont implements Initializable {
  private Stage stage;
  private Scene scene;
  private Parent root;
  private String home;
  private String browser;
  private String addrecipe;
  private String search;
  private String weekly;
  @FXML
  private Button closeHelpCenter;

  @FXML
  private TextArea homeInformation;

  @FXML
  private TextArea browserHelpcenter;

  @FXML
  private TextArea addRecipeHelpCenter;

  @FXML
  private TextArea searchHelpCenter;

  @FXML
  private TextArea weeklyListHelpCenter;

  @FXML
  void closeHelpCenter(ActionEvent event) throws IOException {
    root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main.fxml")));
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    home = "home window is the main window in owr cook book application,\n" +
        "on the right side of the windo you favorite recipes will appear in a list and you can get,\n " +
        "all the information you need by clicking on the recipe's name.\n" +
        "\n" + "on the button bar you can move between apllication's sections \n" +
        "like \"browse\" where you can browse the recipe and add recipes or remove them from you favoritList\n" +
        ",weekly list where you can choose recipes and add them to you weekly list,\n" +
        "add recipes where you can add a new recipes which you like to your cookbook,\n" +
        "and search where you can search for any recipe which is already in the aplication. \n " +
        "for more information about any section you all what you need is to click on the tab which is labeled by the section name.";

    homeInformation.setText(home);

    browser = "Herer you can find all information you need about the browser section\n"
        + "Argon-cookbook is developed to browse all the recipes that had been added by \n"
        + "different users and by the creator of the application. You can easily go to the \n"
        + "browser window by clicking on the \"Browse\" button at the top of the application  \n"
        + "button bar. You can look through all recipes and also you have the ability to star \n"
        + "any recipe you like to save it in your favorite recipes and go back to it anytime you \n"
        + "want. In addition to that, you can also remove the recipe from your favorites.\n"
        + "\n";
    browserHelpcenter.setText(browser);

    addrecipe = "Add Recipe:\n"
        + "To add a recipe the first thing you need to do is\n"
        + "to fill the first four text fields with name, short description,\n"
        + "long description and steps. Then you press the add recipe button.\n"
        + "The next step is to add the ingredients. You need to enter the\n"
        + "name and amount of the ingredient and also choose between\n"
        + "different unit. Then press the add ingredient button.\n"
        + "lastly you can a tag to the recipe. You can enter your own tag or\n"
        + "select an existing tag, or you can do both add and select a tag.";
    addRecipeHelpCenter.setText(addrecipe);

    search = "In search, you can search for many recipes which are already\n"
        + "in the application or recipes which you had added to it\n"
        + "Searching can be by name where you just write the name\n"
        + "of a recipe in the search field and choose 'searching by name' and you will\n"
        + "get your target recipe or a list of recipes with the same name you had written.\n"
        + "In case, you would like to find recipes which contain a special ingredient\n"
        + "all that you need is to write the ingredient in the search field and choose 'search by ingredient',\n"
        + "you will get a list of recipes in which this ingredient is used in.\n"
        + "Also you can search recipes by tags for example you like to find a ' vegetarian recipe,\n"
        + " just write the tags in the search field and choose search by tag and you will get a list of\n"
        + "recipes which are tagged by the tag you had searched for. ";
    searchHelpCenter.setText(search);

    weekly = "In weekly list you can browse the list of weekly dinners\n"
        + "that you can add. To add a dinner to your weekly list go to \n"
        + "the recipe browser, when you have chosen a recipe choose \n"
        + "the day and week where you want to add that recipe. Now you can \n"
        + "view that recipe in weekly list whenever you want";
    weeklyListHelpCenter.setText(weekly);
  }

}
