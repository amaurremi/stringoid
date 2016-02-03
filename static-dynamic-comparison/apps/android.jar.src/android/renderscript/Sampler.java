/*    */
package android.renderscript;

/*    */
/*    */ public class Sampler extends BaseObj
/*    */ {
    /*    */   public static enum Value
/*    */ {
        /*  7 */     CLAMP,
        /*  8 */     LINEAR,
        /*  9 */     LINEAR_MIP_LINEAR,
        /* 10 */     LINEAR_MIP_NEAREST,
        /* 11 */     NEAREST,
        /* 12 */     WRAP;

        /*    */
/*    */
        private Value() {
        }
    }

    /*    */
/* 16 */   public static class Builder {
        public Builder(RenderScript rs) {
            throw new RuntimeException("Stub!");
        }

        /* 17 */
        public void setMinification(Sampler.Value v) {
            throw new RuntimeException("Stub!");
        }

        /* 18 */
        public void setMagnification(Sampler.Value v) {
            throw new RuntimeException("Stub!");
        }

        /* 19 */
        public void setWrapS(Sampler.Value v) {
            throw new RuntimeException("Stub!");
        }

        /* 20 */
        public void setWrapT(Sampler.Value v) {
            throw new RuntimeException("Stub!");
        }

        /* 21 */
        public void setAnisotropy(float v) {
            throw new RuntimeException("Stub!");
        }

        /* 22 */
        public Sampler create() {
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
/* 24 */   Sampler() {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public Value getMinification() {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public Value getMagnification() {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public Value getWrapS() {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public Value getWrapT() {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public float getAnisotropy() {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public static Sampler CLAMP_NEAREST(RenderScript rs) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public static Sampler CLAMP_LINEAR(RenderScript rs) {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public static Sampler CLAMP_LINEAR_MIP_LINEAR(RenderScript rs) {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public static Sampler WRAP_NEAREST(RenderScript rs) {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public static Sampler WRAP_LINEAR(RenderScript rs) {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public static Sampler WRAP_LINEAR_MIP_LINEAR(RenderScript rs) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/renderscript/Sampler.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */