/*    */
package android.renderscript;

/*    */
/*    */
@Deprecated
/*    */ public class ProgramRaster extends BaseObj
/*    */ {
    /*    */
    @Deprecated
/*    */ public static enum CullMode
/*    */ {
        /*  9 */     BACK,
        /* 10 */     FRONT,
        /* 11 */     NONE;

        /*    */
/*    */
        private CullMode() {
        }
    }

    /*    */
/*    */
    @Deprecated
/*    */ public static class Builder {
        @Deprecated
/* 17 */ public Builder(RenderScript rs) {
            throw new RuntimeException("Stub!");
        }

        /*    */
        @Deprecated
/* 19 */ public Builder setPointSpriteEnabled(boolean enable) {
            throw new RuntimeException("Stub!");
        }

        /*    */
        @Deprecated
/* 21 */ public Builder setCullMode(ProgramRaster.CullMode m) {
            throw new RuntimeException("Stub!");
        }

        /*    */
        @Deprecated
/* 23 */ public ProgramRaster create() {
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
/* 25 */   ProgramRaster() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 27 */ public boolean isPointSpriteEnabled() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 29 */ public CullMode getCullMode() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 31 */ public static ProgramRaster CULL_BACK(RenderScript rs) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 33 */ public static ProgramRaster CULL_FRONT(RenderScript rs) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 35 */ public static ProgramRaster CULL_NONE(RenderScript rs) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/renderscript/ProgramRaster.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */