package tests;

import javafx.collections.ObservableList;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import main.engine.Grid;
import main.sprites.Plot;
import main.sprites.Sprite;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GridTests {

    private Grid grid;
    private Sprite<Pane> plot;

    @Before
    public void setup() {
        grid = new Grid();
        plot = new Plot();
    }

    @Test
    public void testAddRemoveSprite() {
        grid.addSprite(plot, 5, 5);
        assertTrue(grid.removeSprite(plot));
    }

    @Test
    public void testRender() {
        Pane expected = new Pane();

        Plot plot1 = new Plot();
        plot1.setPosition(1, 1);
        grid.addSprite(plot1, 1, 1);

        Plot plot2 = new Plot();
        plot2.setPosition(6, 6);
        grid.addSprite(plot2, 6, 6);

        Plot plot3 = new Plot();
        plot3.setPosition(11, 11);
        grid.addSprite(plot3, 11, 11);

        Plot plot4 = new Plot();
        plot4.setPosition(16, 16);
        grid.addSprite(plot4, 16, 16);

        assertPanesEqual(createExpected(), grid.render());

    }

    private Pane createExpected() {
        Pane expected = new Pane();

        Plot plot1 = new Plot();
        plot1.setPosition(1, 1);
        Pane root1 = plot1.getRoot();
        root1.relocate(plot1.getPosition().x, plot1.getPosition().y);
        root1.setMinSize(plot1.getSize().x, plot1.getSize().y);
        root1.setMaxSize(plot1.getSize().x, plot1.getSize().y);
        expected.getChildren().add(root1);

        Plot plot2 = new Plot();
        plot2.setPosition(6, 6);
        Pane root2 = plot2.getRoot();
        root2.relocate(plot2.getPosition().x, plot2.getPosition().y);
        root2.setMinSize(plot2.getSize().x, plot2.getSize().y);
        root2.setMaxSize(plot2.getSize().x, plot2.getSize().y);
        expected.getChildren().add(root2);

        Plot plot3 = new Plot();
        plot3.setPosition(11, 11);
        Pane root3 = plot3.getRoot();
        root3.relocate(plot3.getPosition().x, plot3.getPosition().y);
        root3.setMinSize(plot3.getSize().x, plot3.getSize().y);
        root3.setMaxSize(plot3.getSize().x, plot3.getSize().y);
        expected.getChildren().add(plot3.getRoot());

        Plot plot4 = new Plot();
        plot4.setPosition(16, 16);
        Pane root4 = plot4.getRoot();
        root4.relocate(plot4.getPosition().x, plot4.getPosition().y);
        root4.setMinSize(plot4.getSize().x, plot4.getSize().y);
        root4.setMaxSize(plot4.getSize().x, plot4.getSize().y);
        expected.getChildren().add(plot4.getRoot());

        return expected;
    }

    private void assertPanesEqual(Pane expected, Pane actual) {
        int numExpectedChildren = expected.getChildren().size();
        int numActualChildren = actual.getChildren().size();
        assertEquals(numExpectedChildren, numActualChildren);

        ObservableList<Node> expectedChildren = expected.getChildren();
        ObservableList<Node> actualChildren = actual.getChildren();

        for (int i = 0; i < numExpectedChildren; i++) {
            Node expectedChild = expectedChildren.get(i);
            Node actualChild = actualChildren.get(i);

            Bounds expectedPosition = expectedChild.localToScene(expectedChild.getBoundsInLocal());
            Bounds actualPosition = actualChild.localToScene(actualChild.getBoundsInLocal());
            assertEquals(expectedPosition, actualPosition);

        }
    }



}
