/*    */
package android.opengl;
/*    */

import javax.microedition.khronos.opengles.GL10;

/*    */
/*  4 */ public class GLU {
    public GLU() {
        throw new RuntimeException("Stub!");
    }

    /*  5 */
    public static String gluErrorString(int error) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public static void gluLookAt(GL10 gl, float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public static void gluOrtho2D(GL10 gl, float left, float right, float bottom, float top) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public static void gluPerspective(GL10 gl, float fovy, float aspect, float zNear, float zFar) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public static int gluProject(float objX, float objY, float objZ, float[] model, int modelOffset, float[] project, int projectOffset, int[] view, int viewOffset, float[] win, int winOffset) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public static int gluUnProject(float winX, float winY, float winZ, float[] model, int modelOffset, float[] project, int projectOffset, int[] view, int viewOffset, float[] obj, int objOffset) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/opengl/GLU.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */