/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Spring2023
 * Instructor: Prof. Brian King
 *
 * Name: Angel Sousani-Twumasi, Aya Tarist, Marina Anglo, Thao Nguyen
 * Section: 10am
 * Date:
 * Time:
 *
 * Project: csci205_final_project
 * Package: KQ
 * Class: MainPage controller
 *
 * Description: This is the MainPage controller responsible for controlling the main aspect of our game.
 * It handles controlling the bison, collisions, calling obstacles and restarting the game.
 *
 * ****************************************
 */


package KQ;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;



/**
 * This class is the MainPage. This is the page that the application transitions to after the user clicks the 'start' button
 * on the Starting Page. This class handles the Bison's movement and the Pipe Obstacle's movement
 */
public class MainPage {

    /** The plane of the Main page scene*/
    @FXML
    private AnchorPane plane;

    /** The background of the application */
    @FXML
    private ImageView background;



    /** The Bison object, a gif */
    @FXML
    private ImageView bison_gif;

    /** The speed that the Bison is travelling at while it is being controlled */
    private double bisonVelocity = 0.0;

    /** The Bison's gravity for when the space key is released and it falls */
    private final double GRAVITY = 0.6;


    /** Comes from PipeObstacle class, uses methods to move the pipes */
    private PipeObstacle pipeObstacle;

    /** The amount of time that has elapsed during the game */
    private int gameTime = 0;

    /** Boolean for when the space key is being pressed */
    private boolean spacePressed = false;

    /** An array list that represents the obstacles that the Bison must avoid */
    public ArrayList<Rectangle> obstacles = new ArrayList<>();


    public void setObstacles(ArrayList<Rectangle> obstacles) {
        this.obstacles = obstacles;
    }

    public void setPipeObstacle(PipeObstacle pipeObstacle) {
        this.pipeObstacle = pipeObstacle;
    }

    public void setScore(Text score) {
        this.score = score;
    }

    /** The total number of points that the player gets by passing through obstacles */
    @FXML
    private Text score;

    /** Keeps count of scores */
    private int scoreCounter = 0;

    /** Bison object */
    private Bison bisonComponent;

    /** A boolean object that checks if the endPage scene is being shown to the user */
    private boolean isEndPageShown;

    public MainPage() {
        this.isEndPageShown = false;
        this.scoreCounter = 0;
    }


    @FXML
    void initialize(URL url, ResourceBundle resourceBundle) {
        int jumpHeight = 100;
        bisonComponent = new Bison(bison_gif, jumpHeight);
        assert background != null : "fx:id=\"background\" was not injected: check your FXML file 'MainPage.fxml'.";
        assert bison_gif != null : "fx:id=\"bison_gif\" was not injected: check your FXML file 'MainPage.fxml'.";
        double planeHeight = 500;
        double planeWidth = 700;
        pipeObstacle = new PipeObstacle(plane, planeHeight, planeWidth);

        gameLoop = new AnimationTimer() {
            @Override
            public void handle(long l) {
                try {
                    update();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };


        Scene scene = bison_gif.getScene();
        spacePressed = false;

        /**
         * Using the cursor to move the bison gif
         */
        scene.setOnMouseMoved(event -> {
            double x = event.getX() - bison_gif.getFitWidth() / 2;
            double y = event.getY() - bison_gif.getFitHeight() / 2;
            bison_gif.setLayoutX(x);
            bison_gif.setLayoutY(y);
        });


        load();

        gameLoop.start();


    }
    /**
     * Update the obstacles as the bison keeps going through them
     */
    public void update() throws IOException {
        gameTime++;

        // Add a point and display it
        if(pointChecker(obstacles, bison_gif)){
            scoreCounter++;
            score.setText(String.valueOf(scoreCounter));
        }

        //Move the pipes and create them as they pass by
        pipeObstacle.moveObstacles(obstacles);
        if(gameTime % 300 == 0){
            obstacles.addAll(pipeObstacle.createsPipes());
        }


        if (bisonComponent.isBisonDead(obstacles, plane)) {
            if (!isEndPageShown) {
                Stage stage = BisonMain.getMainPrimaryStage();
                BisonMain.loadSceneOnStage(stage, FXMLScenes.ENDPAGE);
                isEndPageShown = true;
            }

        }

    }

    /**
     * Load and add all obstacles
     */
    private void load () {
        obstacles.addAll(pipeObstacle.createsPipes());
    }

    AnimationTimer gameLoop = new AnimationTimer() {
        @Override
        public void handle(long now) {
            bisonVelocity = GRAVITY;
            bison_gif.setTranslateY(bison_gif.getTranslateY() + bisonVelocity);

            for (Rectangle obstacle : obstacles) {
                if (bison_gif.getBoundsInParent().intersects(obstacle.getBoundsInParent())){
                    bisonComponent.isBisonDead(obstacles, plane);
                }
            }
        }
    };


    /**
     * Get the bison location and the obstacle location
     * @param obstacles - pipes
     * @param bison_gif - bison
     * @return true if it passes through obstacle
     */

    private boolean pointChecker(ArrayList<Rectangle> obstacles, ImageView bison_gif) {
        for (Rectangle obstacle: obstacles) {
            int bisonPositionX = (int) (bison_gif.getLayoutX() + bison_gif.getX() + bison_gif.getFitWidth() / 2);
            int obstaclePositionX = (int) (obstacle.getLayoutX() + obstacle.getX() + obstacle.getWidth() / 2);
            if (bisonPositionX == obstaclePositionX) {
                return true;
            }
        }
        return false;
    }

    /**
     * A method that returns the score that the user gets after completing a game session
     * @return score
     */
    public Text getScore(){
        return score;
    }

    /**
     * A method that returns the bison_gif object that is generated from the FXML file
     * @return bison_gif
     */
    public ImageView getBison_gif() { return bison_gif; }

    /**
     * A method that sets the bison_gif object that is generated from the FXML file
     * @return bison_gif
     */
    public void setBison_gif(ImageView bison_gif) {
        this.bison_gif = bison_gif;
    }

}


