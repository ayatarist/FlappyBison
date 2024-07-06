/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Spring2023
 * Instructor: Prof. Brian King
 *
 * Name: Angel Sousani-Twumasi, Aya Tarist, Marina Anglo, Thao Nguyen
 * Section: 10am
 * Date: 4/10/23
 * Time: 5:49 PM
 *
 * Project: csci205_final_project
 * Package: KQ
 * Class: BisonMain
 *
 * Description: Bison Main method that calls all the different scenes from Scene builder and loads
 * the pages.
 *
 * ****************************************
 */
package KQ;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javafx.scene.control.Button;
import javafx.stage.Stage;

import javax.sound.sampled.Clip;
import java.io.File;
import java.io.IOException;

enum FXMLScenes {
    STARTING_PAGE("/starting_page.fxml"),
    MAINPAGE("/MainPage.fxml"),
    ENDPAGE("/EndPage.fxml");

    /** Initialization of String filename for the scenes */
    private final String fileName;

    /** Sets the filename from Scene builder  */
    FXMLScenes(String fileName) {
        this.fileName = fileName;
    }

    /** Gets the filename that is called*/
    public String getFileName() {
        return fileName;
    }
}

public class BisonMain extends Application {


    /**
     * Getter method for the stage
     * @return mainPrimaryStage
     */
    public static Stage getMainPrimaryStage() {
        return mainPrimaryStage;
    }

    /** Initializing the stage */
    private static Stage mainPrimaryStage = null;


    /**
     * Main method to launch the game
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }


    /**
     * the entry point of the application. When the application is launched, the JavaFX runtime calls the start method to
     * initialize the application and display the main window.
     * @param primaryStage the primary stage for this application, onto which
     * the application scene can be set.
     * Applications may create other stages, if needed, but they will not be
     * primary stages.
     * @throws IOException
     */
    @Override
    public void start(Stage primaryStage)  {
        mainPrimaryStage = primaryStage;
        loadSceneOnStage(primaryStage, FXMLScenes.STARTING_PAGE);
        primaryStage.show();
        playBackgroundMusic();

    }

    /**
     * Plays the background music
     */

    private Clip clip;

    public void playBackgroundMusic() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("./src/main/resources/backMusic.wav"));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method displays the different scenes (Starting Page, Main Page, End Page)
     * @param primaryStage
     * @param fxmlScene
     */
    public static void loadSceneOnStage(Stage primaryStage, FXMLScenes fxmlScene) {
        // code inspiration from https://github.com/bkingcs/JavaFXExamples/blob/main/src/main/java/com/brk/javafxexamples/MainApplication.java
        FXMLLoader fxmlLoader = new FXMLLoader(BisonMain.class.getResource(fxmlScene.getFileName()));
        try {
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
        }
        catch (IOException e) {
            throw new RuntimeException("Could not load" + fxmlScene.getFileName());
        }
    }
 }



