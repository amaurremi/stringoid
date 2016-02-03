/*     */
package android.hardware;
/*     */ 
/*     */

import java.util.List;

/*     */
/*     */ public class Camera {
    /*   6 */   public static class CameraInfo {
        public CameraInfo() {
            throw new RuntimeException("Stub!");
        }

        /*     */
/*     */     public static final int CAMERA_FACING_BACK = 0;
        /*     */     public static final int CAMERA_FACING_FRONT = 1;
        /*     */     public int facing;
        /*     */     public int orientation;
/*     */
    }

    /*     */
/*     */   public static abstract interface PreviewCallback {
        public abstract void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera);
/*     */
    }

    /*     */
/*     */   public static abstract interface AutoFocusCallback {
        public abstract void onAutoFocus(boolean paramBoolean, Camera paramCamera);
/*     */
    }

    /*     */
/*     */   public static abstract interface AutoFocusMoveCallback {
        public abstract void onAutoFocusMoving(boolean paramBoolean, Camera paramCamera);
/*     */
    }

    /*     */
/*     */   public static abstract interface ShutterCallback {
        public abstract void onShutter();
/*     */
    }

    /*     */
/*     */   public static abstract interface PictureCallback {
        public abstract void onPictureTaken(byte[] paramArrayOfByte, Camera paramCamera);
/*     */
    }

    /*     */
/*     */   public static abstract interface OnZoomChangeListener {
        public abstract void onZoomChange(int paramInt, boolean paramBoolean, Camera paramCamera);
/*     */
    }

    /*     */
/*     */   public static abstract interface FaceDetectionListener {
        public abstract void onFaceDetection(Camera.Face[] paramArrayOfFace, Camera paramCamera);
/*     */
    }

    /*     */
/*     */   public static class Face {
        public android.graphics.Rect rect;
        /*     */     public int score;
        /*     */     public int id;
        /*     */     public android.graphics.Point leftEye;
        /*     */     public android.graphics.Point rightEye;
        /*     */     public android.graphics.Point mouth;

        /*     */
/*  42 */
        public Face() {
            throw new RuntimeException("Stub!");
        }
/*     */
    }

    /*     */
/*     */ 
/*     */   public static final String ACTION_NEW_PICTURE = "android.hardware.action.NEW_PICTURE";
    /*     */   public static final String ACTION_NEW_VIDEO = "android.hardware.action.NEW_VIDEO";

    /*     */   public static abstract interface ErrorCallback {
        /*     */
        public abstract void onError(int paramInt, Camera paramCamera);
/*     */
    }

    /*     */
/*     */   public class Size {
        /*     */     public int width;
        /*     */     public int height;

        /*     */
/*  56 */
        public Size(int w, int h) {
            throw new RuntimeException("Stub!");
        }

        /*  57 */
        public boolean equals(Object obj) {
            throw new RuntimeException("Stub!");
        }

        /*  58 */
        public int hashCode() {
            throw new RuntimeException("Stub!");
        }
/*     */
    }

    /*     */
/*     */   public static class Area {
        public android.graphics.Rect rect;
        /*     */     public int weight;

        /*     */
/*  64 */
        public Area(android.graphics.Rect rect, int weight) {
            throw new RuntimeException("Stub!");
        }

        /*  65 */
        public boolean equals(Object obj) {
            throw new RuntimeException("Stub!");
        }
    }

    /*     */
/*     */   public class Parameters {
        public static final String WHITE_BALANCE_AUTO = "auto";
        /*     */     public static final String WHITE_BALANCE_INCANDESCENT = "incandescent";
        /*     */     public static final String WHITE_BALANCE_FLUORESCENT = "fluorescent";

        /*     */
/*  71 */     Parameters() {
            throw new RuntimeException("Stub!");
        }

        /*  72 */
        public String flatten() {
            throw new RuntimeException("Stub!");
        }

        /*  73 */
        public void unflatten(String flattened) {
            throw new RuntimeException("Stub!");
        }

        /*  74 */
        public void remove(String key) {
            throw new RuntimeException("Stub!");
        }

        /*  75 */
        public void set(String key, String value) {
            throw new RuntimeException("Stub!");
        }

        /*  76 */
        public void set(String key, int value) {
            throw new RuntimeException("Stub!");
        }

        /*  77 */
        public String get(String key) {
            throw new RuntimeException("Stub!");
        }

        /*  78 */
        public int getInt(String key) {
            throw new RuntimeException("Stub!");
        }

        /*  79 */
        public void setPreviewSize(int width, int height) {
            throw new RuntimeException("Stub!");
        }

        /*  80 */
        public Camera.Size getPreviewSize() {
            throw new RuntimeException("Stub!");
        }

        /*  81 */
        public List<Camera.Size> getSupportedPreviewSizes() {
            throw new RuntimeException("Stub!");
        }

        /*  82 */
        public List<Camera.Size> getSupportedVideoSizes() {
            throw new RuntimeException("Stub!");
        }

        /*  83 */
        public Camera.Size getPreferredPreviewSizeForVideo() {
            throw new RuntimeException("Stub!");
        }

        /*  84 */
        public void setJpegThumbnailSize(int width, int height) {
            throw new RuntimeException("Stub!");
        }

        /*  85 */
        public Camera.Size getJpegThumbnailSize() {
            throw new RuntimeException("Stub!");
        }

        /*  86 */
        public List<Camera.Size> getSupportedJpegThumbnailSizes() {
            throw new RuntimeException("Stub!");
        }

        /*  87 */
        public void setJpegThumbnailQuality(int quality) {
            throw new RuntimeException("Stub!");
        }

        /*  88 */
        public int getJpegThumbnailQuality() {
            throw new RuntimeException("Stub!");
        }

        /*  89 */
        public void setJpegQuality(int quality) {
            throw new RuntimeException("Stub!");
        }

        /*  90 */
        public int getJpegQuality() {
            throw new RuntimeException("Stub!");
        }

        /*     */
        @Deprecated
/*  92 */ public void setPreviewFrameRate(int fps) {
            throw new RuntimeException("Stub!");
        }

        /*     */
        @Deprecated
/*  94 */ public int getPreviewFrameRate() {
            throw new RuntimeException("Stub!");
        }

        /*     */
        @Deprecated
/*  96 */ public List<Integer> getSupportedPreviewFrameRates() {
            throw new RuntimeException("Stub!");
        }

        /*  97 */
        public void setPreviewFpsRange(int min, int max) {
            throw new RuntimeException("Stub!");
        }

        /*  98 */
        public void getPreviewFpsRange(int[] range) {
            throw new RuntimeException("Stub!");
        }

        /*  99 */
        public List<int[]> getSupportedPreviewFpsRange() {
            throw new RuntimeException("Stub!");
        }

        /* 100 */
        public void setPreviewFormat(int pixel_format) {
            throw new RuntimeException("Stub!");
        }

        /* 101 */
        public int getPreviewFormat() {
            throw new RuntimeException("Stub!");
        }

        /* 102 */
        public List<Integer> getSupportedPreviewFormats() {
            throw new RuntimeException("Stub!");
        }

        /* 103 */
        public void setPictureSize(int width, int height) {
            throw new RuntimeException("Stub!");
        }

        /* 104 */
        public Camera.Size getPictureSize() {
            throw new RuntimeException("Stub!");
        }

        /* 105 */
        public List<Camera.Size> getSupportedPictureSizes() {
            throw new RuntimeException("Stub!");
        }

        /* 106 */
        public void setPictureFormat(int pixel_format) {
            throw new RuntimeException("Stub!");
        }

        /* 107 */
        public int getPictureFormat() {
            throw new RuntimeException("Stub!");
        }

        /* 108 */
        public List<Integer> getSupportedPictureFormats() {
            throw new RuntimeException("Stub!");
        }

        /* 109 */
        public void setRotation(int rotation) {
            throw new RuntimeException("Stub!");
        }

        /* 110 */
        public void setGpsLatitude(double latitude) {
            throw new RuntimeException("Stub!");
        }

        /* 111 */
        public void setGpsLongitude(double longitude) {
            throw new RuntimeException("Stub!");
        }

        /* 112 */
        public void setGpsAltitude(double altitude) {
            throw new RuntimeException("Stub!");
        }

        /* 113 */
        public void setGpsTimestamp(long timestamp) {
            throw new RuntimeException("Stub!");
        }

        /* 114 */
        public void setGpsProcessingMethod(String processing_method) {
            throw new RuntimeException("Stub!");
        }

        /* 115 */
        public void removeGpsData() {
            throw new RuntimeException("Stub!");
        }

        /* 116 */
        public String getWhiteBalance() {
            throw new RuntimeException("Stub!");
        }

        /* 117 */
        public void setWhiteBalance(String value) {
            throw new RuntimeException("Stub!");
        }

        /* 118 */
        public List<String> getSupportedWhiteBalance() {
            throw new RuntimeException("Stub!");
        }

        /* 119 */
        public String getColorEffect() {
            throw new RuntimeException("Stub!");
        }

        /* 120 */
        public void setColorEffect(String value) {
            throw new RuntimeException("Stub!");
        }

        /* 121 */
        public List<String> getSupportedColorEffects() {
            throw new RuntimeException("Stub!");
        }

        /* 122 */
        public String getAntibanding() {
            throw new RuntimeException("Stub!");
        }

        /* 123 */
        public void setAntibanding(String antibanding) {
            throw new RuntimeException("Stub!");
        }

        /* 124 */
        public List<String> getSupportedAntibanding() {
            throw new RuntimeException("Stub!");
        }

        /* 125 */
        public String getSceneMode() {
            throw new RuntimeException("Stub!");
        }

        /* 126 */
        public void setSceneMode(String value) {
            throw new RuntimeException("Stub!");
        }

        /* 127 */
        public List<String> getSupportedSceneModes() {
            throw new RuntimeException("Stub!");
        }

        /* 128 */
        public String getFlashMode() {
            throw new RuntimeException("Stub!");
        }

        /* 129 */
        public void setFlashMode(String value) {
            throw new RuntimeException("Stub!");
        }

        /* 130 */
        public List<String> getSupportedFlashModes() {
            throw new RuntimeException("Stub!");
        }

        /* 131 */
        public String getFocusMode() {
            throw new RuntimeException("Stub!");
        }

        /* 132 */
        public void setFocusMode(String value) {
            throw new RuntimeException("Stub!");
        }

        /* 133 */
        public List<String> getSupportedFocusModes() {
            throw new RuntimeException("Stub!");
        }

        /* 134 */
        public float getFocalLength() {
            throw new RuntimeException("Stub!");
        }

        /* 135 */
        public float getHorizontalViewAngle() {
            throw new RuntimeException("Stub!");
        }

        /* 136 */
        public float getVerticalViewAngle() {
            throw new RuntimeException("Stub!");
        }

        /* 137 */
        public int getExposureCompensation() {
            throw new RuntimeException("Stub!");
        }

        /* 138 */
        public void setExposureCompensation(int value) {
            throw new RuntimeException("Stub!");
        }

        /* 139 */
        public int getMaxExposureCompensation() {
            throw new RuntimeException("Stub!");
        }

        /* 140 */
        public int getMinExposureCompensation() {
            throw new RuntimeException("Stub!");
        }

        /* 141 */
        public float getExposureCompensationStep() {
            throw new RuntimeException("Stub!");
        }

        /* 142 */
        public void setAutoExposureLock(boolean toggle) {
            throw new RuntimeException("Stub!");
        }

        /* 143 */
        public boolean getAutoExposureLock() {
            throw new RuntimeException("Stub!");
        }

        /* 144 */
        public boolean isAutoExposureLockSupported() {
            throw new RuntimeException("Stub!");
        }

        /* 145 */
        public void setAutoWhiteBalanceLock(boolean toggle) {
            throw new RuntimeException("Stub!");
        }

        /* 146 */
        public boolean getAutoWhiteBalanceLock() {
            throw new RuntimeException("Stub!");
        }

        /* 147 */
        public boolean isAutoWhiteBalanceLockSupported() {
            throw new RuntimeException("Stub!");
        }

        /* 148 */
        public int getZoom() {
            throw new RuntimeException("Stub!");
        }

        /* 149 */
        public void setZoom(int value) {
            throw new RuntimeException("Stub!");
        }

        /* 150 */
        public boolean isZoomSupported() {
            throw new RuntimeException("Stub!");
        }

        /* 151 */
        public int getMaxZoom() {
            throw new RuntimeException("Stub!");
        }

        /* 152 */
        public List<Integer> getZoomRatios() {
            throw new RuntimeException("Stub!");
        }

        /* 153 */
        public boolean isSmoothZoomSupported() {
            throw new RuntimeException("Stub!");
        }

        /* 154 */
        public void getFocusDistances(float[] output) {
            throw new RuntimeException("Stub!");
        }

        /* 155 */
        public int getMaxNumFocusAreas() {
            throw new RuntimeException("Stub!");
        }

        /* 156 */
        public List<Camera.Area> getFocusAreas() {
            throw new RuntimeException("Stub!");
        }

        /* 157 */
        public void setFocusAreas(List<Camera.Area> focusAreas) {
            throw new RuntimeException("Stub!");
        }

        /* 158 */
        public int getMaxNumMeteringAreas() {
            throw new RuntimeException("Stub!");
        }

        /* 159 */
        public List<Camera.Area> getMeteringAreas() {
            throw new RuntimeException("Stub!");
        }

        /* 160 */
        public void setMeteringAreas(List<Camera.Area> meteringAreas) {
            throw new RuntimeException("Stub!");
        }

        /* 161 */
        public int getMaxNumDetectedFaces() {
            throw new RuntimeException("Stub!");
        }

        /* 162 */
        public void setRecordingHint(boolean hint) {
            throw new RuntimeException("Stub!");
        }

        /* 163 */
        public boolean isVideoSnapshotSupported() {
            throw new RuntimeException("Stub!");
        }

        /* 164 */
        public void setVideoStabilization(boolean toggle) {
            throw new RuntimeException("Stub!");
        }

        /* 165 */
        public boolean getVideoStabilization() {
            throw new RuntimeException("Stub!");
        }

        /* 166 */
        public boolean isVideoStabilizationSupported() {
            throw new RuntimeException("Stub!");
        }

        /*     */
/*     */     public static final String WHITE_BALANCE_WARM_FLUORESCENT = "warm-fluorescent";
        /*     */     public static final String WHITE_BALANCE_DAYLIGHT = "daylight";
        /*     */     public static final String WHITE_BALANCE_CLOUDY_DAYLIGHT = "cloudy-daylight";
        /*     */     public static final String WHITE_BALANCE_TWILIGHT = "twilight";
        /*     */     public static final String WHITE_BALANCE_SHADE = "shade";
        /*     */     public static final String EFFECT_NONE = "none";
        /*     */     public static final String EFFECT_MONO = "mono";
        /*     */     public static final String EFFECT_NEGATIVE = "negative";
        /*     */     public static final String EFFECT_SOLARIZE = "solarize";
        /*     */     public static final String EFFECT_SEPIA = "sepia";
        /*     */     public static final String EFFECT_POSTERIZE = "posterize";
        /*     */     public static final String EFFECT_WHITEBOARD = "whiteboard";
        /*     */     public static final String EFFECT_BLACKBOARD = "blackboard";
        /*     */     public static final String EFFECT_AQUA = "aqua";
        /*     */     public static final String ANTIBANDING_AUTO = "auto";
        /*     */     public static final String ANTIBANDING_50HZ = "50hz";
        /*     */     public static final String ANTIBANDING_60HZ = "60hz";
        /*     */     public static final String ANTIBANDING_OFF = "off";
        /*     */     public static final String FLASH_MODE_OFF = "off";
        /*     */     public static final String FLASH_MODE_AUTO = "auto";
        /*     */     public static final String FLASH_MODE_ON = "on";
        /*     */     public static final String FLASH_MODE_RED_EYE = "red-eye";
        /*     */     public static final String FLASH_MODE_TORCH = "torch";
        /*     */     public static final String SCENE_MODE_AUTO = "auto";
        /*     */     public static final String SCENE_MODE_ACTION = "action";
        /*     */     public static final String SCENE_MODE_PORTRAIT = "portrait";
        /*     */     public static final String SCENE_MODE_LANDSCAPE = "landscape";
        /*     */     public static final String SCENE_MODE_NIGHT = "night";
        /*     */     public static final String SCENE_MODE_NIGHT_PORTRAIT = "night-portrait";
        /*     */     public static final String SCENE_MODE_THEATRE = "theatre";
        /*     */     public static final String SCENE_MODE_BEACH = "beach";
        /*     */     public static final String SCENE_MODE_SNOW = "snow";
        /*     */     public static final String SCENE_MODE_SUNSET = "sunset";
        /*     */     public static final String SCENE_MODE_STEADYPHOTO = "steadyphoto";
        /*     */     public static final String SCENE_MODE_FIREWORKS = "fireworks";
        /*     */     public static final String SCENE_MODE_SPORTS = "sports";
        /*     */     public static final String SCENE_MODE_PARTY = "party";
        /*     */     public static final String SCENE_MODE_CANDLELIGHT = "candlelight";
        /*     */     public static final String SCENE_MODE_BARCODE = "barcode";
        /*     */     public static final String FOCUS_MODE_AUTO = "auto";
        /*     */     public static final String FOCUS_MODE_INFINITY = "infinity";
        /*     */     public static final String FOCUS_MODE_MACRO = "macro";
        /*     */     public static final String FOCUS_MODE_FIXED = "fixed";
        /*     */     public static final String FOCUS_MODE_EDOF = "edof";
        /*     */     public static final String FOCUS_MODE_CONTINUOUS_VIDEO = "continuous-video";
        /*     */     public static final String FOCUS_MODE_CONTINUOUS_PICTURE = "continuous-picture";
        /*     */     public static final int FOCUS_DISTANCE_NEAR_INDEX = 0;
        /*     */     public static final int FOCUS_DISTANCE_OPTIMAL_INDEX = 1;
        /*     */     public static final int FOCUS_DISTANCE_FAR_INDEX = 2;
        /*     */     public static final int PREVIEW_FPS_MIN_INDEX = 0;
        /*     */     public static final int PREVIEW_FPS_MAX_INDEX = 1;
    }

    /*     */
/*     */   public static final int CAMERA_ERROR_UNKNOWN = 1;
    /*     */   public static final int CAMERA_ERROR_SERVER_DIED = 100;

    /* 222 */   Camera() {
        throw new RuntimeException("Stub!");
    }

    /*     */
    public static native int getNumberOfCameras();

    /*     */
    public static native void getCameraInfo(int paramInt, CameraInfo paramCameraInfo);

    /* 225 */
    public static Camera open(int cameraId) {
        throw new RuntimeException("Stub!");
    }

    /* 226 */
    public static Camera open() {
        throw new RuntimeException("Stub!");
    }

    /* 227 */
    protected void finalize() {
        throw new RuntimeException("Stub!");
    }

    /* 228 */
    public final void release() {
        throw new RuntimeException("Stub!");
    }

    /*     */
    public final native void unlock();

    /*     */
    public final native void lock();

    /*     */
    public final native void reconnect() throws java.io.IOException;

    /* 232 */
    public final void setPreviewDisplay(android.view.SurfaceHolder holder) throws java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /*     */
    public final native void setPreviewTexture(android.graphics.SurfaceTexture paramSurfaceTexture) throws java.io.IOException;

    /*     */
    public final native void startPreview();

    /* 235 */
    public final void stopPreview() {
        throw new RuntimeException("Stub!");
    }

    /* 236 */
    public final void setPreviewCallback(PreviewCallback cb) {
        throw new RuntimeException("Stub!");
    }

    /* 237 */
    public final void setOneShotPreviewCallback(PreviewCallback cb) {
        throw new RuntimeException("Stub!");
    }

    /* 238 */
    public final void setPreviewCallbackWithBuffer(PreviewCallback cb) {
        throw new RuntimeException("Stub!");
    }

    /* 239 */
    public final void addCallbackBuffer(byte[] callbackBuffer) {
        throw new RuntimeException("Stub!");
    }

    /* 240 */
    public final void autoFocus(AutoFocusCallback cb) {
        throw new RuntimeException("Stub!");
    }

    /* 241 */
    public final void cancelAutoFocus() {
        throw new RuntimeException("Stub!");
    }

    /* 242 */
    public void setAutoFocusMoveCallback(AutoFocusMoveCallback cb) {
        throw new RuntimeException("Stub!");
    }

    /* 243 */
    public final void takePicture(ShutterCallback shutter, PictureCallback raw, PictureCallback jpeg) {
        throw new RuntimeException("Stub!");
    }

    /* 244 */
    public final void takePicture(ShutterCallback shutter, PictureCallback raw, PictureCallback postview, PictureCallback jpeg) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    public final native void startSmoothZoom(int paramInt);

    /*     */
    public final native void stopSmoothZoom();

    /*     */
    public final native void setDisplayOrientation(int paramInt);

    /* 248 */
    public final void setZoomChangeListener(OnZoomChangeListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 249 */
    public final void setFaceDetectionListener(FaceDetectionListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 250 */
    public final void startFaceDetection() {
        throw new RuntimeException("Stub!");
    }

    /* 251 */
    public final void stopFaceDetection() {
        throw new RuntimeException("Stub!");
    }

    /* 252 */
    public final void setErrorCallback(ErrorCallback cb) {
        throw new RuntimeException("Stub!");
    }

    /* 253 */
    public void setParameters(Parameters params) {
        throw new RuntimeException("Stub!");
    }

    /* 254 */
    public Parameters getParameters() {
        throw new RuntimeException("Stub!");
    }
/*     */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/hardware/Camera.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */