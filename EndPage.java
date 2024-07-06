/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Spring2023* Instructor: Prof. Brian King
 *
 * Name: Angel Sousani-Twumasi, Aya Tarist, Marina Anglo, Thao Nguyen
 * Section: 02
 * Date: 4/26/23
 * Time: 6:18 PM
 *
 * Project: csci205_final_project
 * Package: KQ
 * Class: EndPage
 *
 * Description: EndPage Controller that controls the display for Endpage
 *
 * *****************************************/
package KQ;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import KQ.MainPage;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.*;

public class EndPage {

    /** Resource Bundle from FXML scene builder */
    @FXML
    private ResourceBundle resources;

    /**  URL location from FXML scene builder*/
    @FXML
    private URL location;

    /** Restart button */
    @FXML
    private Button restartBtn;

    @FXML
    void initialize(URL url, ResourceBundle resourceBundle) {
        assert restartBtn != null : "fx:id=\"restartBtn\" was not injected: check your FXML file 'EndPage.fxml'.";
    }

    @FXML
    void onRestartBtnNext(ActionEvent actionEvent) {
        Stage stage = (Stage) restartBtn.getScene().getWindow();
        BisonMain.loadSceneOnStage(stage, FXMLScenes.STARTING_PAGE);
    }



}


