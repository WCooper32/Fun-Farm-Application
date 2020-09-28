package main.sprites;

import com.sun.javafx.geom.Vec3d;
import javafx.scene.layout.Pane;

public abstract class Sprite<T extends Pane> {

    protected final T root;
    private final Vec3d position;

    public Sprite(T rootPane) {
        this.root = rootPane;
        position = new Vec3d(0, 0, 1);
    }

    public abstract Vec3d getSize();

    public Pane getRoot() {
        return root;
    }

    public void setPosition(double x, double y) {
        position.x = x;
        position.y = y;
    }

    public Vec3d getPosition() {
        return position;
    }

}
