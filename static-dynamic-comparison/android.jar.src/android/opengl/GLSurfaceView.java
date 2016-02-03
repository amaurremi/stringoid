/*    */
package android.opengl;
/*    */ 
/*    */

import android.content.Context;
/*    */ import android.util.AttributeSet;
/*    */ import android.view.SurfaceHolder;
/*    */ import android.view.SurfaceHolder.Callback;
/*    */ import android.view.SurfaceView;
/*    */ import javax.microedition.khronos.egl.EGL10;
/*    */ import javax.microedition.khronos.egl.EGLConfig;
/*    */ import javax.microedition.khronos.egl.EGLContext;
/*    */ import javax.microedition.khronos.egl.EGLDisplay;
/*    */ import javax.microedition.khronos.egl.EGLSurface;
/*    */ import javax.microedition.khronos.opengles.GL;
/*    */ import javax.microedition.khronos.opengles.GL10;

/*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GLSurfaceView
/*    */ extends SurfaceView
/*    */ implements SurfaceHolder.Callback
/*    */ {
    /*    */   public static final int RENDERMODE_WHEN_DIRTY = 0;
    /*    */   public static final int RENDERMODE_CONTINUOUSLY = 1;
    /*    */   public static final int DEBUG_CHECK_GL_ERROR = 1;
    /*    */   public static final int DEBUG_LOG_GL_CALLS = 2;

    /*    */
/*    */
    public GLSurfaceView(Context context)
/*    */ {
/* 30 */
        super((Context) null, (AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public GLSurfaceView(Context context, AttributeSet attrs) {
        super((Context) null, (AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    protected void finalize() throws Throwable {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public void setGLWrapper(GLWrapper glWrapper) {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public void setDebugFlags(int debugFlags) {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public int getDebugFlags() {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public void setPreserveEGLContextOnPause(boolean preserveOnPause) {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public boolean getPreserveEGLContextOnPause() {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    public void setRenderer(Renderer renderer) {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    public void setEGLContextFactory(EGLContextFactory factory) {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    public void setEGLWindowSurfaceFactory(EGLWindowSurfaceFactory factory) {
        throw new RuntimeException("Stub!");
    }

    /* 41 */
    public void setEGLConfigChooser(EGLConfigChooser configChooser) {
        throw new RuntimeException("Stub!");
    }

    /* 42 */
    public void setEGLConfigChooser(boolean needDepth) {
        throw new RuntimeException("Stub!");
    }

    /* 43 */
    public void setEGLConfigChooser(int redSize, int greenSize, int blueSize, int alphaSize, int depthSize, int stencilSize) {
        throw new RuntimeException("Stub!");
    }

    /* 44 */
    public void setEGLContextClientVersion(int version) {
        throw new RuntimeException("Stub!");
    }

    /* 45 */
    public void setRenderMode(int renderMode) {
        throw new RuntimeException("Stub!");
    }

    /* 46 */
    public int getRenderMode() {
        throw new RuntimeException("Stub!");
    }

    /* 47 */
    public void requestRender() {
        throw new RuntimeException("Stub!");
    }

    /* 48 */
    public void surfaceCreated(SurfaceHolder holder) {
        throw new RuntimeException("Stub!");
    }

    /* 49 */
    public void surfaceDestroyed(SurfaceHolder holder) {
        throw new RuntimeException("Stub!");
    }

    /* 50 */
    public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {
        throw new RuntimeException("Stub!");
    }

    /* 51 */
    public void onPause() {
        throw new RuntimeException("Stub!");
    }

    /* 52 */
    public void onResume() {
        throw new RuntimeException("Stub!");
    }

    /* 53 */
    public void queueEvent(Runnable r) {
        throw new RuntimeException("Stub!");
    }

    /* 54 */
    protected void onAttachedToWindow() {
        throw new RuntimeException("Stub!");
    }

    /* 55 */
    protected void onDetachedFromWindow() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface EGLConfigChooser
/*    */ {
        /*    */
        public abstract EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay);
/*    */
    }

    /*    */
/*    */   public static abstract interface EGLWindowSurfaceFactory
/*    */ {
        /*    */
        public abstract EGLSurface createWindowSurface(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, Object paramObject);

        /*    */
/*    */
        public abstract void destroySurface(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface);
/*    */
    }

    /*    */
/*    */   public static abstract interface EGLContextFactory
/*    */ {
        /*    */
        public abstract EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig);

        /*    */
/*    */
        public abstract void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext);
/*    */
    }

    /*    */
/*    */   public static abstract interface Renderer
/*    */ {
        /*    */
        public abstract void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig);

        /*    */
/*    */
        public abstract void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2);

        /*    */
/*    */
        public abstract void onDrawFrame(GL10 paramGL10);
/*    */
    }

    /*    */
/*    */   public static abstract interface GLWrapper
/*    */ {
        /*    */
        public abstract GL wrap(GL paramGL);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/opengl/GLSurfaceView.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */