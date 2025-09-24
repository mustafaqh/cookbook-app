package cookbook;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class WelcomeCon implements Initializable {

  @FXML
  private Button Login;

  @FXML
  private Text welcome;

  @FXML
  private Button welcomeButton;

  private Stage stage;
  private Scene scene;
  private Parent root;

  @FXML
  void handlebuttonOnAction(ActionEvent event) throws IOException {
    root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("FXMLDocument.fxml")));
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();

  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    TranslateTransition transition = new TranslateTransition();
    transition.setDuration(Duration.seconds(5));
    transition.setNode(welcomeButton);

    transition.setToX(-50);
    transition.setToY(-100);

    ScaleTransition transition2 = new ScaleTransition(Duration.seconds(3), welcomeButton);
    transition2.setToX(1);
    transition2.setToY(1);

    transition.play();
    transition2.play();

  }

}
