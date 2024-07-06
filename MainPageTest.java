/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Spring2023* Instructor: Prof. Brian King
 *
 * Name: Thao Nguyen
 * Section: 02
 * Date: 5/1/23
 * Time: 10:44 AM
 *
 * Project: csci205_final_project
 * Package: PACKAGE_NAME
 * Class: KQtesting.MainPageTest
 *
 * Description:
 *
 * *****************************************/
package KQtesting;
import KQ.Bison;
import KQ.MainPage;
import KQ.PipeObstacle;
import javafx.scene.layout.AnchorPane;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import static org.junit.jupiter.api.Assertions.*;
import javafx.animation.AnimationTimer;


public class MainPageTest {

    /** A bison_gif object */
    private ImageView bison_gif;
    /** Generated PipeObstacle objects */
    private PipeObstacle pipeObstacle;

    /** A new mainPage object */
    MainPage mainPage = new MainPage();


    /**
     * A test to see if points are counted correctly
     * @throws IOException
     */
    @Test
    void testAddPoints() throws IOException {
        // create a new game object
        Bison bisonComponent;
        double planeHeight = 500;
        double planeWidth = 700;
        AnchorPane anchorPane = new AnchorPane();
        pipeObstacle = new PipeObstacle(anchorPane, planeHeight, planeWidth);
        int jumpHeight = 100;
        bison_gif = new ImageView();
        mainPage.setBison_gif(bison_gif);
        bisonComponent = new Bison(mainPage.getBison_gif(), jumpHeight);
        // only generate two pipes
        ArrayList<Rectangle> obstacles = new ArrayList<>(2);
//        AnchorPane anchorPane = new AnchorPane();
        Text score = new Text();
        // make sure that the score is initially null
        Assertions.assertNull(mainPage.getScore());
        mainPage.setObstacles(obstacles);
        mainPage.setPipeObstacle(pipeObstacle);
        mainPage.setScore(score);

        ArrayList<Rectangle> newObstacles = pipeObstacle.createsPipes();
        obstacles.addAll(newObstacles);

        // call the update method that updates obstacles as the bison goes through them
        AnimationTimer gameLoop = new AnimationTimer() {
            @Override
            public void handle(long l) {
                try {
                    mainPage.update();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        // the expected amount of points
        Text expected = new Text("2");

        Text gameScore = mainPage.getScore();

        // make sure that the score is 2
        Assertions.assertEquals(expected, gameScore);


        gameLoop.start();


    }

    /**
     * A test to see if obstacles are generated correctly
     */
    @Test
    public void testSetObstacles() {
        // create a new obstacles ArrayList
        ArrayList<Rectangle> obstacles = new ArrayList<>();
        Rectangle obstacle1 = new Rectangle(100, 100);
        Rectangle obstacle2 = new Rectangle(150, 150);
        obstacles.add(obstacle1);
        obstacles.add(obstacle2);
        // add two obstacles
        mainPage.setObstacles(obstacles);

        // make sure that the two obstacles that were generated match the obstacles that mainPage sets
        assertEquals(obstacles, mainPage.obstacles);
    }
}