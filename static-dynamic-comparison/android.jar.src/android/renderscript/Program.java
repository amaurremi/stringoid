/*    */
package android.renderscript;
/*    */ 
/*    */

import android.content.res.Resources;

/*    */
/*    */ public class Program extends BaseObj {
    /*    */   public static enum TextureType {
        /*  7 */     TEXTURE_2D,
        /*  8 */     TEXTURE_CUBE;

        /*    */
/*    */
        private TextureType() {
        }
    }

    /*    */
/* 12 */   public static class BaseProgramBuilder {
        protected BaseProgramBuilder(RenderScript rs) {
            throw new RuntimeException("Stub!");
        }

        /* 13 */
        public BaseProgramBuilder setShader(String s) {
            throw new RuntimeException("Stub!");
        }

        /* 14 */
        public BaseProgramBuilder setShader(Resources resources, int resourceID) {
            throw new RuntimeException("Stub!");
        }

        /* 15 */
        public int getCurrentConstantIndex() {
            throw new RuntimeException("Stub!");
        }

        /* 16 */
        public int getCurrentTextureIndex() {
            throw new RuntimeException("Stub!");
        }

        /* 17 */
        public BaseProgramBuilder addConstant(Type t) throws IllegalStateException {
            throw new RuntimeException("Stub!");
        }

        /* 18 */
        public BaseProgramBuilder addTexture(Program.TextureType texType) throws IllegalArgumentException {
            throw new RuntimeException("Stub!");
        }

        /* 19 */
        public BaseProgramBuilder addTexture(Program.TextureType texType, String texName) throws IllegalArgumentException {
            throw new RuntimeException("Stub!");
        }

        /* 20 */
        protected void initProgram(Program p) {
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
/* 22 */   Program() {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public int getConstantCount() {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public Type getConstant(int slot) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public int getTextureCount() {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public TextureType getTextureType(int slot) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public String getTextureName(int slot) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public void bindConstants(Allocation a, int slot) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public void bindTexture(Allocation va, int slot) throws IllegalArgumentException {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public void bindSampler(Sampler vs, int slot) throws IllegalArgumentException {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/renderscript/Program.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */