/*    */
package android.renderscript;
/*    */ 
/*    */

import android.graphics.SurfaceTexture;

/*    */
/*    */
@Deprecated
/*    */ public class RenderScriptGL extends RenderScript {
    /*    */
    @Deprecated
/*    */ public static class SurfaceConfig {
        /*    */
        @Deprecated
/* 10 */ public SurfaceConfig() {
            throw new RuntimeException("Stub!");
        }

        /*    */
        @Deprecated
/* 12 */ public SurfaceConfig(SurfaceConfig sc) {
            throw new RuntimeException("Stub!");
        }

        /*    */
        @Deprecated
/* 14 */ public void setColor(int minimum, int preferred) {
            throw new RuntimeException("Stub!");
        }

        /*    */
        @Deprecated
/* 16 */ public void setAlpha(int minimum, int preferred) {
            throw new RuntimeException("Stub!");
        }

        /*    */
        @Deprecated
/* 18 */ public void setDepth(int minimum, int preferred) {
            throw new RuntimeException("Stub!");
        }

        /*    */
        @Deprecated
/* 20 */ public void setSamples(int minimum, int preferred, float Q) {
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
/*    */
    @Deprecated
/* 23 */ public RenderScriptGL(android.content.Context ctx, SurfaceConfig sc) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 25 */ public void setSurface(android.view.SurfaceHolder sur, int w, int h) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 27 */ public void setSurfaceTexture(SurfaceTexture sur, int w, int h) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 29 */ public int getHeight() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 31 */ public int getWidth() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 33 */ public void pause() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 35 */ public void resume() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 37 */ public void bindRootScript(Script s) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 39 */ public void bindProgramStore(ProgramStore p) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 41 */ public void bindProgramFragment(ProgramFragment p) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 43 */ public void bindProgramRaster(ProgramRaster p) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 45 */ public void bindProgramVertex(ProgramVertex p) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/renderscript/RenderScriptGL.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */