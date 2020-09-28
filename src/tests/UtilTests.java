package tests;

import main.engine.Util;

import com.sun.javafx.geom.Matrix3f;
import com.sun.javafx.geom.Vec3d;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UtilTests {

    private Vec3d vector;
    private Matrix3f identityMatrix;
    private Matrix3f currentMatrix;

    @Before
    public void setup() {
        vector = new Vec3d(3, 4, 1);

        identityMatrix = new Matrix3f();
        identityMatrix.setIdentity();

        currentMatrix = new Matrix3f();
        currentMatrix.setIdentity();
    }

    @Test
    public void testTransformVectorIdentity() {
        Vec3d expected = vector;
        Vec3d actual = Util.transformVector(vector, identityMatrix);
        assertEquals(expected, actual);
    }

    @Test
    public void testTranslateVector() {
        Vec3d expected = new Vec3d(7, 3, 1);

        currentMatrix.setIdentity();
        currentMatrix.m20 = 4;
        currentMatrix.m21 = -1;
        Vec3d actual = Util.transformVector(vector, currentMatrix);

        assertEquals(expected, actual);
    }

    @Test
    public void testScaleVector() {
        Vec3d expected = new Vec3d(6, 12, 1);

        currentMatrix.setIdentity();
        currentMatrix.m00 = 2;
        currentMatrix.m11 = 3;
        Vec3d actual = Util.transformVector(vector, currentMatrix);

        assertEquals(expected, actual);
    }

}
