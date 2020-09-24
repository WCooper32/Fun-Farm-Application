package main.engine;

import com.sun.javafx.geom.Matrix3f;
import com.sun.javafx.geom.Vec3d;

public class Util {

    public static Vec3d transformVector(Vec3d vector, Matrix3f transform) {
        Vec3d output = new Vec3d();

        output.x = (vector.x * transform.m00) + (vector.y * transform.m10) + (vector.z * transform.m20);
        output.y = (vector.x * transform.m01) + (vector.y * transform.m11) + (vector.z * transform.m21);
        output.z = (vector.x * transform.m02) + (vector.y * transform.m12) + (vector.z * transform.m22);

        return output;
    }

}
