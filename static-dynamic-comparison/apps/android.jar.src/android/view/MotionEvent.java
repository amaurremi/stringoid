/*     */
package android.view;
/*     */ 
/*     */

import android.graphics.Matrix;

/*     */
/*     */ public final class MotionEvent extends InputEvent implements android.os.Parcelable {
    public static final int INVALID_POINTER_ID = -1;
    /*     */   public static final int ACTION_MASK = 255;

    /*     */   public static final class PointerCoords {
        public float x;
        public float y;
        public float pressure;
        public float size;
        public float touchMajor;

        /*   8 */
        public PointerCoords() {
            throw new RuntimeException("Stub!");
        }

        /*   9 */
        public PointerCoords(PointerCoords other) {
            throw new RuntimeException("Stub!");
        }

        /*  10 */
        public void clear() {
            throw new RuntimeException("Stub!");
        }

        /*  11 */
        public void copyFrom(PointerCoords other) {
            throw new RuntimeException("Stub!");
        }

        /*  12 */
        public float getAxisValue(int axis) {
            throw new RuntimeException("Stub!");
        }

        /*  13 */
        public void setAxisValue(int axis, float value) {
            throw new RuntimeException("Stub!");
        }

        /*     */
/*     */ 
/*     */     public float touchMinor;
        /*     */     public float toolMajor;
        /*     */     public float toolMinor;
        /*     */     public float orientation;
/*     */
    }

    /*     */
/*     */   public static final class PointerProperties
/*     */ {
        /*     */     public int id;

        /*     */
/*  26 */
        public PointerProperties() {
            throw new RuntimeException("Stub!");
        }

        /*  27 */
        public PointerProperties(PointerProperties other) {
            throw new RuntimeException("Stub!");
        }

        /*  28 */
        public void clear() {
            throw new RuntimeException("Stub!");
        }

        /*  29 */
        public void copyFrom(PointerProperties other) {
            throw new RuntimeException("Stub!");
        }

        /*  30 */
        public boolean equals(Object other) {
            throw new RuntimeException("Stub!");
        }

        /*  31 */
        public int hashCode() {
            throw new RuntimeException("Stub!");
        }

        /*     */
/*     */     public int toolType;
    }

    /*     */
/*  35 */   MotionEvent() {
        throw new RuntimeException("Stub!");
    }

    /*  36 */
    protected void finalize() throws Throwable {
        throw new RuntimeException("Stub!");
    }

    /*  37 */
    public static MotionEvent obtain(long downTime, long eventTime, int action, int pointerCount, PointerProperties[] pointerProperties, PointerCoords[] pointerCoords, int metaState, int buttonState, float xPrecision, float yPrecision, int deviceId, int edgeFlags, int source, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @Deprecated
/*  39 */ public static MotionEvent obtain(long downTime, long eventTime, int action, int pointerCount, int[] pointerIds, PointerCoords[] pointerCoords, int metaState, float xPrecision, float yPrecision, int deviceId, int edgeFlags, int source, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*  40 */
    public static MotionEvent obtain(long downTime, long eventTime, int action, float x, float y, float pressure, float size, int metaState, float xPrecision, float yPrecision, int deviceId, int edgeFlags) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @Deprecated
/*  42 */ public static MotionEvent obtain(long downTime, long eventTime, int action, int pointerCount, float x, float y, float pressure, float size, int metaState, float xPrecision, float yPrecision, int deviceId, int edgeFlags) {
        throw new RuntimeException("Stub!");
    }

    /*  43 */
    public static MotionEvent obtain(long downTime, long eventTime, int action, float x, float y, int metaState) {
        throw new RuntimeException("Stub!");
    }

    /*  44 */
    public static MotionEvent obtain(MotionEvent other) {
        throw new RuntimeException("Stub!");
    }

    /*  45 */
    public static MotionEvent obtainNoHistory(MotionEvent other) {
        throw new RuntimeException("Stub!");
    }

    /*  46 */
    public final void recycle() {
        throw new RuntimeException("Stub!");
    }

    /*  47 */
    public final int getDeviceId() {
        throw new RuntimeException("Stub!");
    }

    /*  48 */
    public final int getSource() {
        throw new RuntimeException("Stub!");
    }

    /*  49 */
    public final void setSource(int source) {
        throw new RuntimeException("Stub!");
    }

    /*  50 */
    public final int getAction() {
        throw new RuntimeException("Stub!");
    }

    /*  51 */
    public final int getActionMasked() {
        throw new RuntimeException("Stub!");
    }

    /*  52 */
    public final int getActionIndex() {
        throw new RuntimeException("Stub!");
    }

    /*  53 */
    public final int getFlags() {
        throw new RuntimeException("Stub!");
    }

    /*  54 */
    public final long getDownTime() {
        throw new RuntimeException("Stub!");
    }

    /*  55 */
    public final long getEventTime() {
        throw new RuntimeException("Stub!");
    }

    /*  56 */
    public final float getX() {
        throw new RuntimeException("Stub!");
    }

    /*  57 */
    public final float getY() {
        throw new RuntimeException("Stub!");
    }

    /*  58 */
    public final float getPressure() {
        throw new RuntimeException("Stub!");
    }

    /*  59 */
    public final float getSize() {
        throw new RuntimeException("Stub!");
    }

    /*  60 */
    public final float getTouchMajor() {
        throw new RuntimeException("Stub!");
    }

    /*  61 */
    public final float getTouchMinor() {
        throw new RuntimeException("Stub!");
    }

    /*  62 */
    public final float getToolMajor() {
        throw new RuntimeException("Stub!");
    }

    /*  63 */
    public final float getToolMinor() {
        throw new RuntimeException("Stub!");
    }

    /*  64 */
    public final float getOrientation() {
        throw new RuntimeException("Stub!");
    }

    /*  65 */
    public final float getAxisValue(int axis) {
        throw new RuntimeException("Stub!");
    }

    /*  66 */
    public final int getPointerCount() {
        throw new RuntimeException("Stub!");
    }

    /*  67 */
    public final int getPointerId(int pointerIndex) {
        throw new RuntimeException("Stub!");
    }

    /*  68 */
    public final int getToolType(int pointerIndex) {
        throw new RuntimeException("Stub!");
    }

    /*  69 */
    public final int findPointerIndex(int pointerId) {
        throw new RuntimeException("Stub!");
    }

    /*  70 */
    public final float getX(int pointerIndex) {
        throw new RuntimeException("Stub!");
    }

    /*  71 */
    public final float getY(int pointerIndex) {
        throw new RuntimeException("Stub!");
    }

    /*  72 */
    public final float getPressure(int pointerIndex) {
        throw new RuntimeException("Stub!");
    }

    /*  73 */
    public final float getSize(int pointerIndex) {
        throw new RuntimeException("Stub!");
    }

    /*  74 */
    public final float getTouchMajor(int pointerIndex) {
        throw new RuntimeException("Stub!");
    }

    /*  75 */
    public final float getTouchMinor(int pointerIndex) {
        throw new RuntimeException("Stub!");
    }

    /*  76 */
    public final float getToolMajor(int pointerIndex) {
        throw new RuntimeException("Stub!");
    }

    /*  77 */
    public final float getToolMinor(int pointerIndex) {
        throw new RuntimeException("Stub!");
    }

    /*  78 */
    public final float getOrientation(int pointerIndex) {
        throw new RuntimeException("Stub!");
    }

    /*  79 */
    public final float getAxisValue(int axis, int pointerIndex) {
        throw new RuntimeException("Stub!");
    }

    /*  80 */
    public final void getPointerCoords(int pointerIndex, PointerCoords outPointerCoords) {
        throw new RuntimeException("Stub!");
    }

    /*  81 */
    public final void getPointerProperties(int pointerIndex, PointerProperties outPointerProperties) {
        throw new RuntimeException("Stub!");
    }

    /*  82 */
    public final int getMetaState() {
        throw new RuntimeException("Stub!");
    }

    /*  83 */
    public final int getButtonState() {
        throw new RuntimeException("Stub!");
    }

    /*  84 */
    public final float getRawX() {
        throw new RuntimeException("Stub!");
    }

    /*  85 */
    public final float getRawY() {
        throw new RuntimeException("Stub!");
    }

    /*  86 */
    public final float getXPrecision() {
        throw new RuntimeException("Stub!");
    }

    /*  87 */
    public final float getYPrecision() {
        throw new RuntimeException("Stub!");
    }

    /*  88 */
    public final int getHistorySize() {
        throw new RuntimeException("Stub!");
    }

    /*  89 */
    public final long getHistoricalEventTime(int pos) {
        throw new RuntimeException("Stub!");
    }

    /*  90 */
    public final float getHistoricalX(int pos) {
        throw new RuntimeException("Stub!");
    }

    /*  91 */
    public final float getHistoricalY(int pos) {
        throw new RuntimeException("Stub!");
    }

    /*  92 */
    public final float getHistoricalPressure(int pos) {
        throw new RuntimeException("Stub!");
    }

    /*  93 */
    public final float getHistoricalSize(int pos) {
        throw new RuntimeException("Stub!");
    }

    /*  94 */
    public final float getHistoricalTouchMajor(int pos) {
        throw new RuntimeException("Stub!");
    }

    /*  95 */
    public final float getHistoricalTouchMinor(int pos) {
        throw new RuntimeException("Stub!");
    }

    /*  96 */
    public final float getHistoricalToolMajor(int pos) {
        throw new RuntimeException("Stub!");
    }

    /*  97 */
    public final float getHistoricalToolMinor(int pos) {
        throw new RuntimeException("Stub!");
    }

    /*  98 */
    public final float getHistoricalOrientation(int pos) {
        throw new RuntimeException("Stub!");
    }

    /*  99 */
    public final float getHistoricalAxisValue(int axis, int pos) {
        throw new RuntimeException("Stub!");
    }

    /* 100 */
    public final float getHistoricalX(int pointerIndex, int pos) {
        throw new RuntimeException("Stub!");
    }

    /* 101 */
    public final float getHistoricalY(int pointerIndex, int pos) {
        throw new RuntimeException("Stub!");
    }

    /* 102 */
    public final float getHistoricalPressure(int pointerIndex, int pos) {
        throw new RuntimeException("Stub!");
    }

    /* 103 */
    public final float getHistoricalSize(int pointerIndex, int pos) {
        throw new RuntimeException("Stub!");
    }

    /* 104 */
    public final float getHistoricalTouchMajor(int pointerIndex, int pos) {
        throw new RuntimeException("Stub!");
    }

    /* 105 */
    public final float getHistoricalTouchMinor(int pointerIndex, int pos) {
        throw new RuntimeException("Stub!");
    }

    /* 106 */
    public final float getHistoricalToolMajor(int pointerIndex, int pos) {
        throw new RuntimeException("Stub!");
    }

    /* 107 */
    public final float getHistoricalToolMinor(int pointerIndex, int pos) {
        throw new RuntimeException("Stub!");
    }

    /* 108 */
    public final float getHistoricalOrientation(int pointerIndex, int pos) {
        throw new RuntimeException("Stub!");
    }

    /* 109 */
    public final float getHistoricalAxisValue(int axis, int pointerIndex, int pos) {
        throw new RuntimeException("Stub!");
    }

    /* 110 */
    public final void getHistoricalPointerCoords(int pointerIndex, int pos, PointerCoords outPointerCoords) {
        throw new RuntimeException("Stub!");
    }

    /* 111 */
    public final int getEdgeFlags() {
        throw new RuntimeException("Stub!");
    }

    /* 112 */
    public final void setEdgeFlags(int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 113 */
    public final void setAction(int action) {
        throw new RuntimeException("Stub!");
    }

    /* 114 */
    public final void offsetLocation(float deltaX, float deltaY) {
        throw new RuntimeException("Stub!");
    }

    /* 115 */
    public final void setLocation(float x, float y) {
        throw new RuntimeException("Stub!");
    }

    /* 116 */
    public final void transform(Matrix matrix) {
        throw new RuntimeException("Stub!");
    }

    /* 117 */
    public final void addBatch(long eventTime, float x, float y, float pressure, float size, int metaState) {
        throw new RuntimeException("Stub!");
    }

    /* 118 */
    public final void addBatch(long eventTime, PointerCoords[] pointerCoords, int metaState) {
        throw new RuntimeException("Stub!");
    }

    /* 119 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /* 120 */
    public static String axisToString(int axis) {
        throw new RuntimeException("Stub!");
    }

    /* 121 */
    public static int axisFromString(String symbolicName) {
        throw new RuntimeException("Stub!");
    }

    /* 122 */
    public void writeToParcel(android.os.Parcel out, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*     */
/*     */ 
/*     */   public static final int ACTION_DOWN = 0;
    /*     */
/*     */   public static final int ACTION_UP = 1;
    /*     */   public static final int ACTION_MOVE = 2;
    /*     */   public static final int ACTION_CANCEL = 3;
    /*     */   public static final int ACTION_OUTSIDE = 4;
    /*     */   public static final int ACTION_POINTER_DOWN = 5;
    /*     */   public static final int ACTION_POINTER_UP = 6;
    /*     */   public static final int ACTION_HOVER_MOVE = 7;
    /*     */   public static final int ACTION_SCROLL = 8;
    /*     */   public static final int ACTION_HOVER_ENTER = 9;
    /*     */   public static final int ACTION_HOVER_EXIT = 10;
    /*     */   public static final int ACTION_POINTER_INDEX_MASK = 65280;
    /*     */   public static final int ACTION_POINTER_INDEX_SHIFT = 8;
    /*     */
    @Deprecated
/*     */ public static final int ACTION_POINTER_1_DOWN = 5;
    /*     */
    @Deprecated
/*     */ public static final int ACTION_POINTER_2_DOWN = 261;
    /*     */
    @Deprecated
/*     */ public static final int ACTION_POINTER_3_DOWN = 517;
    /*     */
    @Deprecated
/*     */ public static final int ACTION_POINTER_1_UP = 6;
    /*     */
    @Deprecated
/*     */ public static final int ACTION_POINTER_2_UP = 262;
    /*     */
    @Deprecated
/*     */ public static final int ACTION_POINTER_3_UP = 518;
    /*     */
    @Deprecated
/*     */ public static final int ACTION_POINTER_ID_MASK = 65280;
    /*     */
    @Deprecated
/*     */ public static final int ACTION_POINTER_ID_SHIFT = 8;
    /*     */   public static final int FLAG_WINDOW_IS_OBSCURED = 1;
    /*     */   public static final int EDGE_TOP = 1;
    /*     */   public static final int EDGE_BOTTOM = 2;
    /*     */   public static final int EDGE_LEFT = 4;
    /*     */   public static final int EDGE_RIGHT = 8;
    /*     */   public static final int AXIS_X = 0;
    /*     */   public static final int AXIS_Y = 1;
    /*     */   public static final int AXIS_PRESSURE = 2;
    /*     */   public static final int AXIS_SIZE = 3;
    /*     */   public static final int AXIS_TOUCH_MAJOR = 4;
    /*     */   public static final int AXIS_TOUCH_MINOR = 5;
    /*     */   public static final int AXIS_TOOL_MAJOR = 6;
    /*     */   public static final int AXIS_TOOL_MINOR = 7;
    /*     */   public static final int AXIS_ORIENTATION = 8;
    /*     */   public static final int AXIS_VSCROLL = 9;
    /*     */   public static final int AXIS_HSCROLL = 10;
    /*     */   public static final int AXIS_Z = 11;
    /*     */   public static final int AXIS_RX = 12;
    /*     */   public static final int AXIS_RY = 13;
    /*     */   public static final int AXIS_RZ = 14;
    /*     */   public static final int AXIS_HAT_X = 15;
    /*     */   public static final int AXIS_HAT_Y = 16;
    /*     */   public static final int AXIS_LTRIGGER = 17;
    /*     */   public static final int AXIS_RTRIGGER = 18;
    /*     */   public static final int AXIS_THROTTLE = 19;
    /*     */   public static final int AXIS_RUDDER = 20;
    /*     */   public static final int AXIS_WHEEL = 21;
    /*     */   public static final int AXIS_GAS = 22;
    /*     */   public static final int AXIS_BRAKE = 23;
    /*     */   public static final int AXIS_DISTANCE = 24;
    /*     */   public static final int AXIS_TILT = 25;
    /*     */   public static final int AXIS_GENERIC_1 = 32;
    /*     */   public static final int AXIS_GENERIC_2 = 33;
    /*     */   public static final int AXIS_GENERIC_3 = 34;
    /*     */   public static final int AXIS_GENERIC_4 = 35;
    /*     */   public static final int AXIS_GENERIC_5 = 36;
    /*     */   public static final int AXIS_GENERIC_6 = 37;
    /*     */   public static final int AXIS_GENERIC_7 = 38;
    /*     */   public static final int AXIS_GENERIC_8 = 39;
    /*     */   public static final int AXIS_GENERIC_9 = 40;
    /*     */   public static final int AXIS_GENERIC_10 = 41;
    /*     */   public static final int AXIS_GENERIC_11 = 42;
    /*     */   public static final int AXIS_GENERIC_12 = 43;
    /*     */   public static final int AXIS_GENERIC_13 = 44;
    /*     */   public static final int AXIS_GENERIC_14 = 45;
    /*     */   public static final int AXIS_GENERIC_15 = 46;
    /*     */   public static final int AXIS_GENERIC_16 = 47;
    /*     */   public static final int BUTTON_PRIMARY = 1;
    /*     */   public static final int BUTTON_SECONDARY = 2;
    /*     */   public static final int BUTTON_TERTIARY = 4;
    /*     */   public static final int BUTTON_BACK = 8;
    /*     */   public static final int BUTTON_FORWARD = 16;
    /*     */   public static final int TOOL_TYPE_UNKNOWN = 0;
    /*     */   public static final int TOOL_TYPE_FINGER = 1;
    /*     */   public static final int TOOL_TYPE_STYLUS = 2;
    /*     */   public static final int TOOL_TYPE_MOUSE = 3;
    /*     */   public static final int TOOL_TYPE_ERASER = 4;
    /* 212 */   public static final android.os.Parcelable.Creator<MotionEvent> CREATOR = null;
/*     */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/view/MotionEvent.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */