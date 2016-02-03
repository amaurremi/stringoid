/*    */
package android.renderscript;
/*    */ 
/*    */

import android.graphics.SurfaceTexture;

/*    */
/*    */
@Deprecated
/*    */ public class RSTextureView extends android.view.TextureView implements android.view.TextureView.SurfaceTextureListener {
    /*    */
    @Deprecated
/*  8 */ public RSTextureView(android.content.Context context) {
        super((android.content.Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 10 */ public RSTextureView(android.content.Context context, android.util.AttributeSet attrs) {
        super((android.content.Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 12 */ public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 14 */ public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 16 */ public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 18 */ public void onSurfaceTextureUpdated(SurfaceTexture surface) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 20 */ public void pause() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 22 */ public void resume() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 24 */ public RenderScriptGL createRenderScriptGL(RenderScriptGL.SurfaceConfig sc) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 26 */ public void destroyRenderScriptGL() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 28 */ public void setRenderScriptGL(RenderScriptGL rs) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 30 */ public RenderScriptGL getRenderScriptGL() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/renderscript/RSTextureView.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */