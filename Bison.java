/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Spring2023
 * Instructor: Prof. Brian King
 *
 * Name: Angel Sousani-Twumasi, Aya Tarist, Marina Anglo, Thao Nguyen
 * Section: 10am
 * Date: 4/4/23
 * Time: 5:42 PM
 *
 * Project: csci205_final_project
 * Package: KQ
 * Class: Bison
 *
 * Description: This is the Bison class responsible for initializing the ImageView of the
 * Bison, checks if the Bison is dead
 *
 * ****************************************
 */


package KQ;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;

public class Bison {
    /** Initialization of Bison that user controls */
    private ImageView bison;

    /** Initialization of Bison height*/
    private double bisonY;

    /** Initialization of Bison HandleCollision class*/
    HandleCollision collision = new HandleCollision();


    /**
     * Constructor method for Bison class
     * @param bison - Imageview of bison
     * @param bisonY - Bison height
     */
    public Bison(ImageView bison, int bisonY) {
        this.bison = bison;
        this.bisonY = bisonY;

    }


    /**
     * Method that checks if the Bison is dead
     * @param obstacles - pipe obstacles
     * @param plane - anchor plane
     * @return true if Dead
     */
    public boolean isBisonDead(ArrayList<Rectangle> obstacles, AnchorPane plane) {
        // code from https://github.com/Da9el00/FlappyBirdJavaFX/blob/main/src/main/java/com/example/flappybird/Bird.java
         bisonY = bison.getLayoutY() + bison.getY();

        if (collision.bisonCollision(obstacles, bison)) {
            return true;
        }

        return bisonY >= plane.getHeight();
    }

}

