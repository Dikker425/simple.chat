package chat.Client;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    private Network network;

    @FXML
    TextArea textOutput;

    @FXML
    TextField textInput;

    @FXML
    Button sendButton;

    //Закрытие программы через меню
    public void menuItemFileExitAction(ActionEvent actionEvent) {
        network.close();
        Platform.exit();
    }

    // отправка соробщения
    public void sendMessage(ActionEvent actionEvent) {
        network.sendMessage(textInput.getText());
        textInput.clear();
        textInput.requestFocus();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        network = new Network((args -> {
            textOutput.appendText((String) args[0]);
        }));
    }

    public void nameChange(ActionEvent actionEvent) {
        textInput.setText("/changename ");
    }
}
