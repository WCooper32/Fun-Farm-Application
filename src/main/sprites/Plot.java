package main.sprites;

import com.sun.javafx.geom.Vec3d;
import javafx.scene.layout.Pane;

public class Plot extends Sprite<Pane> {

    @Override
    public Vec3d getSize() {
        return new Vec3d(64, 48, 1);
    }

    public Plot() {
        super(new Pane());
        root.setId("plot");
    }

}
