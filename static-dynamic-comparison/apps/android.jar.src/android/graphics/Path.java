/*    */
package android.graphics;

/*    */
/*    */ public class Path
/*    */ {
    /*    */   public static enum FillType {
        /*  6 */     EVEN_ODD,
        /*  7 */     INVERSE_EVEN_ODD,
        /*  8 */     INVERSE_WINDING,
        /*  9 */     WINDING;

        /*    */
/*    */
        private FillType() {
        }
    }

    /*    */
/* 13 */   public static enum Direction {
        CCW,
        /* 14 */     CW;

        /*    */
        private Direction() {
        }
    }

    /* 16 */
    public Path() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public Path(Path src) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void reset() {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public void rewind() {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public void set(Path src) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public FillType getFillType() {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public void setFillType(FillType ft) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public boolean isInverseFillType() {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public void toggleInverseFillType() {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public boolean isEmpty() {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public boolean isRect(RectF rect) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/* 28 */
    public void computeBounds(RectF bounds, boolean exact) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public void incReserve(int extraPtCount) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public void moveTo(float x, float y) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public void rMoveTo(float dx, float dy) {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public void lineTo(float x, float y) {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public void rLineTo(float dx, float dy) {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public void quadTo(float x1, float y1, float x2, float y2) {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public void rQuadTo(float dx1, float dy1, float dx2, float dy2) {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public void cubicTo(float x1, float y1, float x2, float y2, float x3, float y3) {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public void rCubicTo(float x1, float y1, float x2, float y2, float x3, float y3) {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    public void arcTo(RectF oval, float startAngle, float sweepAngle, boolean forceMoveTo) {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    public void arcTo(RectF oval, float startAngle, float sweepAngle) {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    public void close() {
        throw new RuntimeException("Stub!");
    }

    /* 41 */
    public void addRect(RectF rect, Direction dir) {
        throw new RuntimeException("Stub!");
    }

    /* 42 */
    public void addRect(float left, float top, float right, float bottom, Direction dir) {
        throw new RuntimeException("Stub!");
    }

    /* 43 */
    public void addOval(RectF oval, Direction dir) {
        throw new RuntimeException("Stub!");
    }

    /* 44 */
    public void addCircle(float x, float y, float radius, Direction dir) {
        throw new RuntimeException("Stub!");
    }

    /* 45 */
    public void addArc(RectF oval, float startAngle, float sweepAngle) {
        throw new RuntimeException("Stub!");
    }

    /* 46 */
    public void addRoundRect(RectF rect, float rx, float ry, Direction dir) {
        throw new RuntimeException("Stub!");
    }

    /* 47 */
    public void addRoundRect(RectF rect, float[] radii, Direction dir) {
        throw new RuntimeException("Stub!");
    }

    /* 48 */
    public void addPath(Path src, float dx, float dy) {
        throw new RuntimeException("Stub!");
    }

    /* 49 */
    public void addPath(Path src) {
        throw new RuntimeException("Stub!");
    }

    /* 50 */
    public void addPath(Path src, Matrix matrix) {
        throw new RuntimeException("Stub!");
    }

    /* 51 */
    public void offset(float dx, float dy, Path dst) {
        throw new RuntimeException("Stub!");
    }

    /* 52 */
    public void offset(float dx, float dy) {
        throw new RuntimeException("Stub!");
    }

    /* 53 */
    public void setLastPoint(float dx, float dy) {
        throw new RuntimeException("Stub!");
    }

    /* 54 */
    public void transform(Matrix matrix, Path dst) {
        throw new RuntimeException("Stub!");
    }

    /* 55 */
    public void transform(Matrix matrix) {
        throw new RuntimeException("Stub!");
    }

    /* 56 */
    protected void finalize() throws Throwable {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/graphics/Path.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */