/*     */
package android.media;
/*     */ 
/*     */

import android.graphics.drawable.Drawable;

/*     */
/*     */ public class MediaRouter {
    /*   6 */   public static class RouteInfo {
        RouteInfo() {
            throw new RuntimeException("Stub!");
        }

        /*   7 */
        public CharSequence getName() {
            throw new RuntimeException("Stub!");
        }

        /*   8 */
        public CharSequence getName(android.content.Context context) {
            throw new RuntimeException("Stub!");
        }

        /*   9 */
        public CharSequence getStatus() {
            throw new RuntimeException("Stub!");
        }

        /*  10 */
        public int getSupportedTypes() {
            throw new RuntimeException("Stub!");
        }

        /*  11 */
        public MediaRouter.RouteGroup getGroup() {
            throw new RuntimeException("Stub!");
        }

        /*  12 */
        public MediaRouter.RouteCategory getCategory() {
            throw new RuntimeException("Stub!");
        }

        /*  13 */
        public Drawable getIconDrawable() {
            throw new RuntimeException("Stub!");
        }

        /*  14 */
        public void setTag(Object tag) {
            throw new RuntimeException("Stub!");
        }

        /*  15 */
        public Object getTag() {
            throw new RuntimeException("Stub!");
        }

        /*  16 */
        public int getPlaybackType() {
            throw new RuntimeException("Stub!");
        }

        /*  17 */
        public int getPlaybackStream() {
            throw new RuntimeException("Stub!");
        }

        /*  18 */
        public int getVolume() {
            throw new RuntimeException("Stub!");
        }

        /*  19 */
        public void requestSetVolume(int volume) {
            throw new RuntimeException("Stub!");
        }

        /*  20 */
        public void requestUpdateVolume(int direction) {
            throw new RuntimeException("Stub!");
        }

        /*  21 */
        public int getVolumeMax() {
            throw new RuntimeException("Stub!");
        }

        /*  22 */
        public int getVolumeHandling() {
            throw new RuntimeException("Stub!");
        }

        /*  23 */
        public String toString() {
            throw new RuntimeException("Stub!");
        }

        /*     */
/*     */     public static final int PLAYBACK_TYPE_LOCAL = 0;
        /*     */     public static final int PLAYBACK_TYPE_REMOTE = 1;
        /*     */     public static final int PLAYBACK_VOLUME_FIXED = 0;
        /*     */     public static final int PLAYBACK_VOLUME_VARIABLE = 1;
    }

    /*     */
/*     */   public static final int ROUTE_TYPE_LIVE_AUDIO = 1;
    /*     */   public static final int ROUTE_TYPE_USER = 8388608;

    /*  32 */   public static class UserRouteInfo extends MediaRouter.RouteInfo {
        UserRouteInfo() {
            throw new RuntimeException("Stub!");
        }

        /*  33 */
        public void setName(CharSequence name) {
            throw new RuntimeException("Stub!");
        }

        /*  34 */
        public void setName(int resId) {
            throw new RuntimeException("Stub!");
        }

        /*  35 */
        public void setStatus(CharSequence status) {
            throw new RuntimeException("Stub!");
        }

        /*  36 */
        public void setRemoteControlClient(RemoteControlClient rcc) {
            throw new RuntimeException("Stub!");
        }

        /*  37 */
        public RemoteControlClient getRemoteControlClient() {
            throw new RuntimeException("Stub!");
        }

        /*  38 */
        public void setIconDrawable(Drawable icon) {
            throw new RuntimeException("Stub!");
        }

        /*  39 */
        public void setIconResource(int resId) {
            throw new RuntimeException("Stub!");
        }

        /*  40 */
        public void setVolumeCallback(MediaRouter.VolumeCallback vcb) {
            throw new RuntimeException("Stub!");
        }

        /*  41 */
        public void setPlaybackType(int type) {
            throw new RuntimeException("Stub!");
        }

        /*  42 */
        public void setVolumeHandling(int volumeHandling) {
            throw new RuntimeException("Stub!");
        }

        /*  43 */
        public void setVolume(int volume) {
            throw new RuntimeException("Stub!");
        }

        /*  44 */
        public void requestSetVolume(int volume) {
            throw new RuntimeException("Stub!");
        }

        /*  45 */
        public void requestUpdateVolume(int direction) {
            throw new RuntimeException("Stub!");
        }

        /*  46 */
        public void setVolumeMax(int volumeMax) {
            throw new RuntimeException("Stub!");
        }

        /*  47 */
        public void setPlaybackStream(int stream) {
            throw new RuntimeException("Stub!");
        }
/*     */
    }

    /*     */
/*     */   public static class RouteGroup
/*     */ extends MediaRouter.RouteInfo {
        /*  52 */     RouteGroup() {
            throw new RuntimeException("Stub!");
        }

        /*  53 */
        public void addRoute(MediaRouter.RouteInfo route) {
            throw new RuntimeException("Stub!");
        }

        /*  54 */
        public void addRoute(MediaRouter.RouteInfo route, int insertAt) {
            throw new RuntimeException("Stub!");
        }

        /*  55 */
        public void removeRoute(MediaRouter.RouteInfo route) {
            throw new RuntimeException("Stub!");
        }

        /*  56 */
        public void removeRoute(int index) {
            throw new RuntimeException("Stub!");
        }

        /*  57 */
        public int getRouteCount() {
            throw new RuntimeException("Stub!");
        }

        /*  58 */
        public MediaRouter.RouteInfo getRouteAt(int index) {
            throw new RuntimeException("Stub!");
        }

        /*  59 */
        public void setIconDrawable(Drawable icon) {
            throw new RuntimeException("Stub!");
        }

        /*  60 */
        public void setIconResource(int resId) {
            throw new RuntimeException("Stub!");
        }

        /*  61 */
        public void requestSetVolume(int volume) {
            throw new RuntimeException("Stub!");
        }

        /*  62 */
        public void requestUpdateVolume(int direction) {
            throw new RuntimeException("Stub!");
        }

        /*  63 */
        public String toString() {
            throw new RuntimeException("Stub!");
        }
/*     */
    }

    /*     */
/*     */   public static class RouteCategory {
        /*  67 */     RouteCategory() {
            throw new RuntimeException("Stub!");
        }

        /*  68 */
        public CharSequence getName() {
            throw new RuntimeException("Stub!");
        }

        /*  69 */
        public CharSequence getName(android.content.Context context) {
            throw new RuntimeException("Stub!");
        }

        /*  70 */
        public java.util.List<MediaRouter.RouteInfo> getRoutes(java.util.List<MediaRouter.RouteInfo> out) {
            throw new RuntimeException("Stub!");
        }

        /*  71 */
        public int getSupportedTypes() {
            throw new RuntimeException("Stub!");
        }

        /*  72 */
        public boolean isGroupable() {
            throw new RuntimeException("Stub!");
        }

        /*  73 */
        public String toString() {
            throw new RuntimeException("Stub!");
        }
/*     */
    }

    /*     */
/*     */   public static abstract class Callback {
        /*  77 */
        public Callback() {
            throw new RuntimeException("Stub!");
        }

        /*     */
/*     */
        public abstract void onRouteSelected(MediaRouter paramMediaRouter, int paramInt, MediaRouter.RouteInfo paramRouteInfo);

        /*     */
/*     */
        public abstract void onRouteUnselected(MediaRouter paramMediaRouter, int paramInt, MediaRouter.RouteInfo paramRouteInfo);

        /*     */
/*     */
        public abstract void onRouteAdded(MediaRouter paramMediaRouter, MediaRouter.RouteInfo paramRouteInfo);

        /*     */
/*     */
        public abstract void onRouteRemoved(MediaRouter paramMediaRouter, MediaRouter.RouteInfo paramRouteInfo);

        /*     */
        public abstract void onRouteChanged(MediaRouter paramMediaRouter, MediaRouter.RouteInfo paramRouteInfo);

        /*     */
        public abstract void onRouteGrouped(MediaRouter paramMediaRouter, MediaRouter.RouteInfo paramRouteInfo, MediaRouter.RouteGroup paramRouteGroup, int paramInt);

        /*     */
        public abstract void onRouteUngrouped(MediaRouter paramMediaRouter, MediaRouter.RouteInfo paramRouteInfo, MediaRouter.RouteGroup paramRouteGroup);

        /*     */
        public abstract void onRouteVolumeChanged(MediaRouter paramMediaRouter, MediaRouter.RouteInfo paramRouteInfo);
    }

    /*  90 */   public static class SimpleCallback extends MediaRouter.Callback {
        public SimpleCallback() {
            throw new RuntimeException("Stub!");
        }

        /*  91 */
        public void onRouteSelected(MediaRouter router, int type, MediaRouter.RouteInfo info) {
            throw new RuntimeException("Stub!");
        }

        /*  92 */
        public void onRouteUnselected(MediaRouter router, int type, MediaRouter.RouteInfo info) {
            throw new RuntimeException("Stub!");
        }

        /*  93 */
        public void onRouteAdded(MediaRouter router, MediaRouter.RouteInfo info) {
            throw new RuntimeException("Stub!");
        }

        /*  94 */
        public void onRouteRemoved(MediaRouter router, MediaRouter.RouteInfo info) {
            throw new RuntimeException("Stub!");
        }

        /*  95 */
        public void onRouteChanged(MediaRouter router, MediaRouter.RouteInfo info) {
            throw new RuntimeException("Stub!");
        }

        /*  96 */
        public void onRouteGrouped(MediaRouter router, MediaRouter.RouteInfo info, MediaRouter.RouteGroup group, int index) {
            throw new RuntimeException("Stub!");
        }

        /*  97 */
        public void onRouteUngrouped(MediaRouter router, MediaRouter.RouteInfo info, MediaRouter.RouteGroup group) {
            throw new RuntimeException("Stub!");
        }

        /*  98 */
        public void onRouteVolumeChanged(MediaRouter router, MediaRouter.RouteInfo info) {
            throw new RuntimeException("Stub!");
        }
/*     */
    }

    /*     */
/*     */   public static abstract class VolumeCallback {
        /* 102 */
        public VolumeCallback() {
            throw new RuntimeException("Stub!");
        }

        /*     */
/*     */
        public abstract void onVolumeUpdateRequest(MediaRouter.RouteInfo paramRouteInfo, int paramInt);

        /*     */
        public abstract void onVolumeSetRequest(MediaRouter.RouteInfo paramRouteInfo, int paramInt);
    }

    /* 106 */   MediaRouter() {
        throw new RuntimeException("Stub!");
    }

    /* 107 */
    public RouteInfo getSelectedRoute(int type) {
        throw new RuntimeException("Stub!");
    }

    /* 108 */
    public void addCallback(int types, Callback cb) {
        throw new RuntimeException("Stub!");
    }

    /* 109 */
    public void removeCallback(Callback cb) {
        throw new RuntimeException("Stub!");
    }

    /* 110 */
    public void selectRoute(int types, RouteInfo route) {
        throw new RuntimeException("Stub!");
    }

    /* 111 */
    public void addUserRoute(UserRouteInfo info) {
        throw new RuntimeException("Stub!");
    }

    /* 112 */
    public void removeUserRoute(UserRouteInfo info) {
        throw new RuntimeException("Stub!");
    }

    /* 113 */
    public void clearUserRoutes() {
        throw new RuntimeException("Stub!");
    }

    /* 114 */
    public int getCategoryCount() {
        throw new RuntimeException("Stub!");
    }

    /* 115 */
    public RouteCategory getCategoryAt(int index) {
        throw new RuntimeException("Stub!");
    }

    /* 116 */
    public int getRouteCount() {
        throw new RuntimeException("Stub!");
    }

    /* 117 */
    public RouteInfo getRouteAt(int index) {
        throw new RuntimeException("Stub!");
    }

    /* 118 */
    public UserRouteInfo createUserRoute(RouteCategory category) {
        throw new RuntimeException("Stub!");
    }

    /* 119 */
    public RouteCategory createRouteCategory(CharSequence name, boolean isGroupable) {
        throw new RuntimeException("Stub!");
    }

    /* 120 */
    public RouteCategory createRouteCategory(int nameResId, boolean isGroupable) {
        throw new RuntimeException("Stub!");
    }
/*     */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/media/MediaRouter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */