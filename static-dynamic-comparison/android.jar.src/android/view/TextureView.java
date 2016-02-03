/*    */
package android.view;
/*    */ 
/*    */

import android.content.Context;
/*    */ import android.graphics.Canvas;
/*    */ import android.graphics.SurfaceTexture;
/*    */ import android.util.AttributeSet;

/*    */
/*    */ public class TextureView extends View
/*    */ {
    /*    */
    public TextureView(Context context)
/*    */ {
/* 12 */
        super((Context) null, (AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /*    */
/* 14 */
    public TextureView(Context context, AttributeSet attrs) {
        super((Context) null, (AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /*    */
/* 16 */
    public TextureView(Context context, AttributeSet attrs, int defStyle) {
        super((Context) null, (AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public boolean isOpaque() {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void setOpaque(boolean opaque) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    protected void onAttachedToWindow() {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    protected void onDetachedFromWindow() {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public void setLayerType(int layerType, android.graphics.Paint paint) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public int getLayerType() {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public void buildLayer() {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public final void draw(Canvas canvas) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    protected final void onDraw(Canvas canvas) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    protected void onVisibilityChanged(View changedView, int visibility) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public void setTransform(android.graphics.Matrix transform) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public android.graphics.Matrix getTransform(android.graphics.Matrix transform) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public android.graphics.Bitmap getBitmap() {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public android.graphics.Bitmap getBitmap(int width, int height) {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public android.graphics.Bitmap getBitmap(android.graphics.Bitmap bitmap) {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public boolean isAvailable() {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public Canvas lockCanvas() {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public Canvas lockCanvas(android.graphics.Rect dirty) {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public void unlockCanvasAndPost(Canvas canvas) {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public SurfaceTexture getSurfaceTexture() {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    public SurfaceTextureListener getSurfaceTextureListener() {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    public void setSurfaceTextureListener(SurfaceTextureListener listener) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface SurfaceTextureListener
/*    */ {
        /*    */
        public abstract void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2);

        /*    */
/*    */
        public abstract void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2);

        /*    */
/*    */
        public abstract boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture);

        /*    */
/*    */
        public abstract void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/view/TextureView.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */