/*    */
package android.renderscript;
/*    */ 
/*    */

import android.content.res.Resources;

/*    */
/*    */
@Deprecated
/*    */ public class Font extends BaseObj {
    /*    */
    @Deprecated
/*    */ public static enum Style {
        /*  9 */     BOLD,
        /* 10 */     BOLD_ITALIC,
        /* 11 */     ITALIC,
        /* 12 */     NORMAL;

        /*    */
        private Style() {
        }
    }

    /* 14 */   Font() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 16 */ public static Font createFromFile(RenderScript rs, Resources res, String path, float pointSize) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 18 */ public static Font createFromFile(RenderScript rs, Resources res, java.io.File path, float pointSize) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 20 */ public static Font createFromAsset(RenderScript rs, Resources res, String path, float pointSize) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 22 */ public static Font createFromResource(RenderScript rs, Resources res, int id, float pointSize) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 24 */ public static Font create(RenderScript rs, Resources res, String familyName, Style fontStyle, float pointSize) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/renderscript/Font.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */