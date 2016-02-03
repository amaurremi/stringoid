/*   */
package android.opengl;
/*   */

import java.io.Writer;

/*   */
/* 4 */ public class GLDebugHelper {
    public GLDebugHelper() {
        throw new RuntimeException("Stub!");
    }

    /* 5 */
    public static javax.microedition.khronos.opengles.GL wrap(javax.microedition.khronos.opengles.GL gl, int configFlags, Writer log) {
        throw new RuntimeException("Stub!");
    }

    /* 6 */
    public static javax.microedition.khronos.egl.EGL wrap(javax.microedition.khronos.egl.EGL egl, int configFlags, Writer log) {
        throw new RuntimeException("Stub!");
    }

    /*   */
/*   */   public static final int CONFIG_CHECK_GL_ERROR = 1;
    /*   */   public static final int CONFIG_CHECK_THREAD = 2;
    /*   */   public static final int CONFIG_LOG_ARGUMENT_NAMES = 4;
    /*   */   public static final int ERROR_WRONG_THREAD = 28672;
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/opengl/GLDebugHelper.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */