/*    */
package android.renderscript;

/*    */
/*    */
@Deprecated
/*    */ public class ProgramFragmentFixedFunction extends ProgramFragment {
    /*    */
    @Deprecated
/*    */ public static class Builder {
        /*    */
        @Deprecated
/*    */ public static final int MAX_TEXTURE = 2;

        /*    */
/*    */
        @Deprecated
/*    */ public static enum EnvMode {
            /* 12 */       DECAL,
            /* 13 */       MODULATE,
            /* 14 */       REPLACE;

            /*    */
/*    */
            private EnvMode() {
            }
        }

        /*    */
/*    */
        @Deprecated
/* 19 */ public static enum Format {
            ALPHA,
            /* 20 */       LUMINANCE_ALPHA,
            /* 21 */       RGB,
            /* 22 */       RGBA;

            /*    */
            private Format() {
            }
        }

        /*    */
        @Deprecated
/* 25 */ public Builder(RenderScript rs) {
            throw new RuntimeException("Stub!");
        }

        /*    */
        @Deprecated
/* 27 */ public Builder setTexture(EnvMode env, Format fmt, int slot) throws IllegalArgumentException {
            throw new RuntimeException("Stub!");
        }

        /*    */
        @Deprecated
/* 29 */ public Builder setPointSpriteTexCoordinateReplacement(boolean enable) {
            throw new RuntimeException("Stub!");
        }

        /*    */
        @Deprecated
/* 31 */ public Builder setVaryingColor(boolean enable) {
            throw new RuntimeException("Stub!");
        }

        /*    */
        @Deprecated
/* 33 */ public ProgramFragmentFixedFunction create() {
            throw new RuntimeException("Stub!");
        }
/*    */
    }

    /*    */
/*    */   ProgramFragmentFixedFunction() {
/* 37 */
        throw new RuntimeException("Stub!");
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/renderscript/ProgramFragmentFixedFunction.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */