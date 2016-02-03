/*    */
package android.graphics;

/*    */
/*    */ public class Matrix {
    public static final int MSCALE_X = 0;
    /*    */   public static final int MSKEW_X = 1;

    /*    */
/*  6 */   public static enum ScaleToFit {
        CENTER,
        /*  7 */     END,
        /*  8 */     FILL,
        /*  9 */     START;

        /*    */
        private ScaleToFit() {
        }
    }

    /* 11 */
    public Matrix() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public Matrix(Matrix src) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public boolean isIdentity() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public boolean rectStaysRect() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public void set(Matrix src) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public boolean equals(Object obj) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public void reset() {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void setTranslate(float dx, float dy) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public void setScale(float sx, float sy, float px, float py) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public void setScale(float sx, float sy) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public void setRotate(float degrees, float px, float py) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public void setRotate(float degrees) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public void setSinCos(float sinValue, float cosValue, float px, float py) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public void setSinCos(float sinValue, float cosValue) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public void setSkew(float kx, float ky, float px, float py) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public void setSkew(float kx, float ky) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public boolean setConcat(Matrix a, Matrix b) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public boolean preTranslate(float dx, float dy) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public boolean preScale(float sx, float sy, float px, float py) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public boolean preScale(float sx, float sy) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public boolean preRotate(float degrees, float px, float py) {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public boolean preRotate(float degrees) {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public boolean preSkew(float kx, float ky, float px, float py) {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public boolean preSkew(float kx, float ky) {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public boolean preConcat(Matrix other) {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public boolean postTranslate(float dx, float dy) {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public boolean postScale(float sx, float sy, float px, float py) {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    public boolean postScale(float sx, float sy) {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    public boolean postRotate(float degrees, float px, float py) {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    public boolean postRotate(float degrees) {
        throw new RuntimeException("Stub!");
    }

    /* 41 */
    public boolean postSkew(float kx, float ky, float px, float py) {
        throw new RuntimeException("Stub!");
    }

    /* 42 */
    public boolean postSkew(float kx, float ky) {
        throw new RuntimeException("Stub!");
    }

    /* 43 */
    public boolean postConcat(Matrix other) {
        throw new RuntimeException("Stub!");
    }

    /* 44 */
    public boolean setRectToRect(RectF src, RectF dst, ScaleToFit stf) {
        throw new RuntimeException("Stub!");
    }

    /* 45 */
    public boolean setPolyToPoly(float[] src, int srcIndex, float[] dst, int dstIndex, int pointCount) {
        throw new RuntimeException("Stub!");
    }

    /* 46 */
    public boolean invert(Matrix inverse) {
        throw new RuntimeException("Stub!");
    }

    /* 47 */
    public void mapPoints(float[] dst, int dstIndex, float[] src, int srcIndex, int pointCount) {
        throw new RuntimeException("Stub!");
    }

    /* 48 */
    public void mapVectors(float[] dst, int dstIndex, float[] src, int srcIndex, int vectorCount) {
        throw new RuntimeException("Stub!");
    }

    /* 49 */
    public void mapPoints(float[] dst, float[] src) {
        throw new RuntimeException("Stub!");
    }

    /* 50 */
    public void mapVectors(float[] dst, float[] src) {
        throw new RuntimeException("Stub!");
    }

    /* 51 */
    public void mapPoints(float[] pts) {
        throw new RuntimeException("Stub!");
    }

    /* 52 */
    public void mapVectors(float[] vecs) {
        throw new RuntimeException("Stub!");
    }

    /* 53 */
    public boolean mapRect(RectF dst, RectF src) {
        throw new RuntimeException("Stub!");
    }

    /* 54 */
    public boolean mapRect(RectF rect) {
        throw new RuntimeException("Stub!");
    }

    /* 55 */
    public float mapRadius(float radius) {
        throw new RuntimeException("Stub!");
    }

    /* 56 */
    public void getValues(float[] values) {
        throw new RuntimeException("Stub!");
    }

    /* 57 */
    public void setValues(float[] values) {
        throw new RuntimeException("Stub!");
    }

    /* 58 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /* 59 */
    public String toShortString() {
        throw new RuntimeException("Stub!");
    }

    /* 60 */
    protected void finalize() throws Throwable {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int MTRANS_X = 2;
    /*    */   public static final int MSKEW_Y = 3;
    /*    */   public static final int MSCALE_Y = 4;
    /*    */   public static final int MTRANS_Y = 5;
    /*    */   public static final int MPERSP_0 = 6;
    /*    */   public static final int MPERSP_1 = 7;
    /*    */   public static final int MPERSP_2 = 8;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/graphics/Matrix.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */