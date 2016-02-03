/*    */
package android.renderscript;

/*    */
/*    */ public class ProgramStore extends BaseObj
/*    */ {
    /*    */   public static enum DepthFunc
/*    */ {
        /*  7 */     ALWAYS,
        /*  8 */     EQUAL,
        /*  9 */     GREATER,
        /* 10 */     GREATER_OR_EQUAL,
        /* 11 */     LESS,
        /* 12 */     LESS_OR_EQUAL,
        /* 13 */     NOT_EQUAL;

        /*    */
/*    */
        private DepthFunc() {
        }
    }

    /*    */
/* 17 */   public static enum BlendSrcFunc {
        DST_ALPHA,
        /* 18 */     DST_COLOR,
        /* 19 */     ONE,
        /* 20 */     ONE_MINUS_DST_ALPHA,
        /* 21 */     ONE_MINUS_DST_COLOR,
        /* 22 */     ONE_MINUS_SRC_ALPHA,
        /* 23 */     SRC_ALPHA,
        /* 24 */     SRC_ALPHA_SATURATE,
        /* 25 */     ZERO;

        /*    */
/*    */
        private BlendSrcFunc() {
        }
    }

    /*    */
/* 29 */   public static enum BlendDstFunc {
        DST_ALPHA,
        /* 30 */     ONE,
        /* 31 */     ONE_MINUS_DST_ALPHA,
        /* 32 */     ONE_MINUS_SRC_ALPHA,
        /* 33 */     ONE_MINUS_SRC_COLOR,
        /* 34 */     SRC_ALPHA,
        /* 35 */     SRC_COLOR,
        /* 36 */     ZERO;

        /*    */
/*    */
        private BlendDstFunc() {
        }
    }

    /*    */
/* 40 */   public static class Builder {
        public Builder(RenderScript rs) {
            throw new RuntimeException("Stub!");
        }

        /* 41 */
        public Builder setDepthFunc(ProgramStore.DepthFunc func) {
            throw new RuntimeException("Stub!");
        }

        /* 42 */
        public Builder setDepthMaskEnabled(boolean enable) {
            throw new RuntimeException("Stub!");
        }

        /* 43 */
        public Builder setColorMaskEnabled(boolean r, boolean g, boolean b, boolean a) {
            throw new RuntimeException("Stub!");
        }

        /* 44 */
        public Builder setBlendFunc(ProgramStore.BlendSrcFunc src, ProgramStore.BlendDstFunc dst) {
            throw new RuntimeException("Stub!");
        }

        /* 45 */
        public Builder setDitherEnabled(boolean enable) {
            throw new RuntimeException("Stub!");
        }

        /* 46 */
        public ProgramStore create() {
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
/* 48 */   ProgramStore() {
        throw new RuntimeException("Stub!");
    }

    /* 49 */
    public DepthFunc getDepthFunc() {
        throw new RuntimeException("Stub!");
    }

    /* 50 */
    public boolean isDepthMaskEnabled() {
        throw new RuntimeException("Stub!");
    }

    /* 51 */
    public boolean isColorMaskRedEnabled() {
        throw new RuntimeException("Stub!");
    }

    /* 52 */
    public boolean isColorMaskGreenEnabled() {
        throw new RuntimeException("Stub!");
    }

    /* 53 */
    public boolean isColorMaskBlueEnabled() {
        throw new RuntimeException("Stub!");
    }

    /* 54 */
    public boolean isColorMaskAlphaEnabled() {
        throw new RuntimeException("Stub!");
    }

    /* 55 */
    public BlendSrcFunc getBlendSrcFunc() {
        throw new RuntimeException("Stub!");
    }

    /* 56 */
    public BlendDstFunc getBlendDstFunc() {
        throw new RuntimeException("Stub!");
    }

    /* 57 */
    public boolean isDitherEnabled() {
        throw new RuntimeException("Stub!");
    }

    /* 58 */
    public static ProgramStore BLEND_NONE_DEPTH_TEST(RenderScript rs) {
        throw new RuntimeException("Stub!");
    }

    /* 59 */
    public static ProgramStore BLEND_NONE_DEPTH_NONE(RenderScript rs) {
        throw new RuntimeException("Stub!");
    }

    /* 60 */
    public static ProgramStore BLEND_ALPHA_DEPTH_TEST(RenderScript rs) {
        throw new RuntimeException("Stub!");
    }

    /* 61 */
    public static ProgramStore BLEND_ALPHA_DEPTH_NONE(RenderScript rs) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/renderscript/ProgramStore.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */