/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Spring2023
 * Instructor: Prof. Brian King
 *
 * Name: Angel Sousani-Twumasi, Aya Tarist, Marina Anglo, Thao Nguyen
 * Section: 10am
 * Date: 4/26/23
 * Time: 10:13 AM
 *
 * Project: csci205_final_project
 * Package: KQ
 * Class: HandleCollision
 *
 * Description: This is the class that handles collisions with the pipe obstacles for
 * when the Bison is flying
 *
 *
 * ****************************************
 */


package KQ;

import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class HandleCollision {

    /**
     * Method for check Bison Collision
     * @param obstacles- obstacles
     * @param bison - bison
     * @return true if there is collision
     */
    public boolean bisonCollision(ArrayList<Rectangle> obstacles, ImageView bison) {
        // following code from https://github.com/Da9el00/FlappyBirdJavaFX/blob/main/src/main/java/com/example/flappybird/CollisionHandler.java
        for (Rectangle rectangle : obstacles) {
            if (rectangle.getBoundsInParent().intersects(bison.getBoundsInParent())) {
                return true;
            }
        }
        return false;
    }
}
