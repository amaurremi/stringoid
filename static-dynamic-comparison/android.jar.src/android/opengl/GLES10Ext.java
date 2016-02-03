/*   */
package android.opengl;
/*   */

import java.nio.IntBuffer;

/*   */
/* 4 */ public class GLES10Ext {
    public GLES10Ext() {
        throw new RuntimeException("Stub!");
    }

    /*   */
/*   */
    public static native int glQueryMatrixxOES(int[] paramArrayOfInt1, int paramInt1, int[] paramArrayOfInt2, int paramInt2);

    /*   */
/*   */
    public static native int glQueryMatrixxOES(IntBuffer paramIntBuffer1, IntBuffer paramIntBuffer2);
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/opengl/GLES10Ext.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */