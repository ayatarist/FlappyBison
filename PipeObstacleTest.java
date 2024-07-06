package KQtesting;

import KQ.Bison;
import KQ.BisonMain;
import KQ.PipeObstacle;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import javafx.scene.paint.Color;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class PipeObstacleTest {

    @Test
    public void testCreatePipes() {
        AnchorPane pane = new AnchorPane();
        double height = 600.0;
        double width = 800.0;
        PipeObstacle pipeObstacle = new PipeObstacle(pane, height, width);

        ArrayList<Rectangle> pipes = pipeObstacle.createsPipes();

        // Assert that the returned ArrayList has a size of 2
        assertEquals(2, pipes.size());

        // Assert that the two rectangles have the expected heights
        assertEquals(50.0, pipes.get(0).getHeight(), 0.0);
        assertEquals(150.0, pipes.get(1).getHeight(), 0.0);

    }
}
