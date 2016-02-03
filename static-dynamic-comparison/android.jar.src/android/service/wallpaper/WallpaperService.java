/*    */
package android.service.wallpaper;
/*    */ 
/*    */

import android.view.SurfaceHolder;

/*    */
/*    */ public abstract class WallpaperService extends android.app.Service {
    public static final String SERVICE_INTERFACE = "android.service.wallpaper.WallpaperService";

    /*    */
/*  7 */   public class Engine {
        public Engine() {
            throw new RuntimeException("Stub!");
        }

        /*  8 */
        public SurfaceHolder getSurfaceHolder() {
            throw new RuntimeException("Stub!");
        }

        /*  9 */
        public int getDesiredMinimumWidth() {
            throw new RuntimeException("Stub!");
        }

        /* 10 */
        public int getDesiredMinimumHeight() {
            throw new RuntimeException("Stub!");
        }

        /* 11 */
        public boolean isVisible() {
            throw new RuntimeException("Stub!");
        }

        /* 12 */
        public boolean isPreview() {
            throw new RuntimeException("Stub!");
        }

        /* 13 */
        public void setTouchEventsEnabled(boolean enabled) {
            throw new RuntimeException("Stub!");
        }

        /* 14 */
        public void setOffsetNotificationsEnabled(boolean enabled) {
            throw new RuntimeException("Stub!");
        }

        /* 15 */
        public void onCreate(SurfaceHolder surfaceHolder) {
            throw new RuntimeException("Stub!");
        }

        /* 16 */
        public void onDestroy() {
            throw new RuntimeException("Stub!");
        }

        /* 17 */
        public void onVisibilityChanged(boolean visible) {
            throw new RuntimeException("Stub!");
        }

        /* 18 */
        public void onTouchEvent(android.view.MotionEvent event) {
            throw new RuntimeException("Stub!");
        }

        /* 19 */
        public void onOffsetsChanged(float xOffset, float yOffset, float xOffsetStep, float yOffsetStep, int xPixelOffset, int yPixelOffset) {
            throw new RuntimeException("Stub!");
        }

        /* 20 */
        public android.os.Bundle onCommand(String action, int x, int y, int z, android.os.Bundle extras, boolean resultRequested) {
            throw new RuntimeException("Stub!");
        }

        /* 21 */
        public void onDesiredSizeChanged(int desiredWidth, int desiredHeight) {
            throw new RuntimeException("Stub!");
        }

        /* 22 */
        public void onSurfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            throw new RuntimeException("Stub!");
        }

        /* 23 */
        public void onSurfaceRedrawNeeded(SurfaceHolder holder) {
            throw new RuntimeException("Stub!");
        }

        /* 24 */
        public void onSurfaceCreated(SurfaceHolder holder) {
            throw new RuntimeException("Stub!");
        }

        /* 25 */
        public void onSurfaceDestroyed(SurfaceHolder holder) {
            throw new RuntimeException("Stub!");
        }

        /* 26 */
        protected void dump(String prefix, java.io.FileDescriptor fd, java.io.PrintWriter out, String[] args) {
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
/* 28 */
    public WallpaperService() {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public void onCreate() {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public void onDestroy() {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public final android.os.IBinder onBind(android.content.Intent intent) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public abstract Engine onCreateEngine();

    /* 33 */
    protected void dump(java.io.FileDescriptor fd, java.io.PrintWriter out, String[] args) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final String SERVICE_META_DATA = "android.service.wallpaper";
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/service/wallpaper/WallpaperService.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */