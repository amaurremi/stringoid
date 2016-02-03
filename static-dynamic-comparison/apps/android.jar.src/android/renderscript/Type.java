/*    */
package android.renderscript;

/*    */
/*    */ public class Type extends BaseObj
/*    */ {
    /*    */   public static enum CubemapFace
/*    */ {
        /*  7 */     NEGATIVE_X,
        /*  8 */     NEGATIVE_Y,
        /*  9 */     NEGATIVE_Z,
        /* 10 */     POSITIVE_X,
        /* 11 */     POSITIVE_Y,
        /* 12 */     POSITIVE_Z,
        /* 13 */     POSITVE_X,
        /* 14 */     POSITVE_Y,
        /* 15 */     POSITVE_Z;

        /*    */
/*    */
        private CubemapFace() {
        }
    }

    /*    */
/* 19 */   public static class Builder {
        public Builder(RenderScript rs, Element e) {
            throw new RuntimeException("Stub!");
        }

        /* 20 */
        public Builder setX(int value) {
            throw new RuntimeException("Stub!");
        }

        /* 21 */
        public Builder setY(int value) {
            throw new RuntimeException("Stub!");
        }

        /* 22 */
        public Builder setMipmaps(boolean value) {
            throw new RuntimeException("Stub!");
        }

        /* 23 */
        public Builder setFaces(boolean value) {
            throw new RuntimeException("Stub!");
        }

        /* 24 */
        public Type create() {
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
/* 26 */   Type() {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public Element getElement() {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public int getX() {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public int getY() {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public int getZ() {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public boolean hasMipmaps() {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public boolean hasFaces() {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public int getCount() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/renderscript/Type.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */