package main.engine;

import com.sun.javafx.geom.Matrix3f;
import com.sun.javafx.geom.Vec3d;
import javafx.scene.layout.Pane;
import main.sprites.Sprite;

import java.util.HashSet;

public class Grid {

    private int numSprites;
    private HashSet<Sprite<Pane>> sprites;

    private Matrix3f transform;

    public Grid() {
        numSprites = 0;
        sprites = new HashSet<>();

        transform = new Matrix3f();
        transform.setIdentity();
    }

    public void addSprite(Sprite<Pane> newSprite, int x, int y) {
        newSprite.setPosition(x, y);
        sprites.add(newSprite);
        numSprites++;
    }

    public void removeSprite(Sprite<Pane> delSprite) {
        sprites.remove(delSprite);
    }

    public Pane render() {
        Pane output = new Pane();
        for (Sprite<Pane> sprite : sprites) {

            // Get Position
            Vec3d position = sprite.getPosition();

            // Get Bounds
            Vec3d size = sprite.getSize();
            size.add(position);
            size.sub(new Vec3d(0,0,1));

            // Transform Position and Bounds
            position = Util.transformVector(position, transform);
            size = Util.transformVector(size, transform);

            // Get Size from Bounds and Position
            size.sub(position);

            // Render into Pane
            Pane rootSprite = sprite.getRoot();
            rootSprite.relocate(position.x, position.y);
            rootSprite.setMinSize(size.x, size.y);
            rootSprite.setMaxSize(size.x, size.y);
            output.getChildren().add(rootSprite);
        }
        return output;
    }

}
