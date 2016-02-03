/*    */
package android.app;
/*    */

import android.os.IBinder;

/*    */
/*  4 */ public class WallpaperManager {
    WallpaperManager() {
        throw new RuntimeException("Stub!");
    }

    /*  5 */
    public static WallpaperManager getInstance(android.content.Context context) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public android.graphics.drawable.Drawable getDrawable() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public android.graphics.drawable.Drawable peekDrawable() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public android.graphics.drawable.Drawable getFastDrawable() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public android.graphics.drawable.Drawable peekFastDrawable() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public void forgetLoadedWallpaper() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public WallpaperInfo getWallpaperInfo() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void setResource(int resid) throws java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void setBitmap(android.graphics.Bitmap bitmap) throws java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void setStream(java.io.InputStream data) throws java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public int getDesiredMinimumWidth() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public int getDesiredMinimumHeight() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public void suggestDesiredDimensions(int minimumWidth, int minimumHeight) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void setWallpaperOffsets(IBinder windowToken, float xOffset, float yOffset) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public void setWallpaperOffsetSteps(float xStep, float yStep) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public void sendWallpaperCommand(IBinder windowToken, String action, int x, int y, int z, android.os.Bundle extras) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public void clearWallpaperOffsets(IBinder windowToken) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public void clear() throws java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final String ACTION_LIVE_WALLPAPER_CHOOSER = "android.service.wallpaper.LIVE_WALLPAPER_CHOOSER";
    /*    */   public static final String ACTION_CHANGE_LIVE_WALLPAPER = "android.service.wallpaper.CHANGE_LIVE_WALLPAPER";
    /*    */   public static final String EXTRA_LIVE_WALLPAPER_COMPONENT = "android.service.wallpaper.extra.LIVE_WALLPAPER_COMPONENT";
    /*    */   public static final String WALLPAPER_PREVIEW_META_DATA = "android.wallpaper.preview";
    /*    */   public static final String COMMAND_TAP = "android.wallpaper.tap";
    /*    */   public static final String COMMAND_SECONDARY_TAP = "android.wallpaper.secondaryTap";
    /*    */   public static final String COMMAND_DROP = "android.home.drop";
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/app/WallpaperManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */