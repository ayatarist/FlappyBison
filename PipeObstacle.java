/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Spring2023
 * Instructor: Prof. Brian King
 *
 * Name: Angel Sousani-Twumasi, Aya Tarist, Marina Anglo, Thao Nguyen 
 * Section: 10am
 * Date: 4/4/23
 * Time: 5:43 PM
 *
 * Project: csci205_final_project
 * Package: KQ
 * Class: PipeObstacle
 *
 * Description: The PipeObstacle is the class responsible for regenerating the pipes that the
 * Bison has to go through and avoid hitting
 *
 * ****************************************
 */


package KQ;

import KQ.Bison;
import javafx.scene.control.skin.TextInputControlSkin;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class PipeObstacle {


    private AnchorPane plane;
    private double pipesWidth;
    private double pipesHeight;


    Random random = new Random();

    /**
     * The constructor class for PipeObstacle
     * @param plane
     * @param pipesHeight
     * @param pipesWidth
     */
    public PipeObstacle(AnchorPane plane, double pipesHeight, double pipesWidth) {
        this.plane = plane;
        this.pipesWidth = pipesWidth;
        this.pipesHeight = pipesHeight;
    }

    /**
     * Generate new pipes as the bison does not collide into
     * the pipes

     * ArrayList of rectangles
     */
    public ArrayList<Rectangle> createsPipes() {   // code inspiration from https://www.youtube.com/watch?v=zYVai12kBA4
        int width = 50;
        double xAxis = pipesWidth + 50;
        double space = 200;
        double recTopHeight = random.nextInt((int) (pipesHeight - space - 100)) + 50;
        double recBottomHeight = pipesHeight - space - recTopHeight;

        Rectangle rectangleTop = new Rectangle(xAxis, 0, width, recTopHeight);
        rectangleTop.setFill(Color.SADDLEBROWN);

        Rectangle rectangleBottom = new Rectangle(xAxis, recTopHeight + space, width, recBottomHeight);
        rectangleBottom.setFill(Color.SADDLEBROWN);

        plane.getChildren().addAll(rectangleTop, rectangleBottom);
        return new ArrayList<>(Arrays.asList(rectangleTop, rectangleBottom));
    }


    /**
     * Method that controls movement of obstacles on the screen
     *
     * @param obstacles - pipe obstacles
     */
    public void moveObstacles(ArrayList<Rectangle> obstacles) {
        // code inspiration from https://www.youtube.com/watch?v=zYVai12kBA4
        ArrayList<Rectangle> outOfScreen = new ArrayList<>();
        for (Rectangle rectangle : obstacles) {
            moveRectangle(rectangle, -1.00);

            if (rectangle.getX() <= -rectangle.getWidth()) {
                outOfScreen.add(rectangle);
            }
        }
        obstacles.removeAll(outOfScreen);
        plane.getChildren().removeAll(outOfScreen);

    }

    /**
     * Method to move rectangle for a certain amount of time
     * @param rectangle
     * @param amount
     */
    private void moveRectangle(Rectangle rectangle, double amount) {
        rectangle.setX(rectangle.getX() + amount);
    }


}
