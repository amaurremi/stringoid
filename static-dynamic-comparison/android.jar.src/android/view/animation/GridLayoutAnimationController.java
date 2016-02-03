/*    */
package android.view.animation;
/*    */ 
/*    */

import android.view.View;

/*    */
/*    */ public class GridLayoutAnimationController extends LayoutAnimationController {
    public static final int DIRECTION_LEFT_TO_RIGHT = 0;
    /*    */   public static final int DIRECTION_RIGHT_TO_LEFT = 1;

    /*    */   public static class AnimationParameters extends LayoutAnimationController.AnimationParameters {
        public int column;
        public int row;

        /*  8 */
        public AnimationParameters() {
            throw new RuntimeException("Stub!");
        }

        /*    */
/*    */     public int columnsCount;
        /*    */     public int rowsCount;
/*    */
    }

    /*    */
/* 14 */
    public GridLayoutAnimationController(android.content.Context context, android.util.AttributeSet attrs) {
        super((Animation) null, 0.0F);
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public GridLayoutAnimationController(Animation animation) {
        super((Animation) null, 0.0F);
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public GridLayoutAnimationController(Animation animation, float columnDelay, float rowDelay) {
        super((Animation) null, 0.0F);
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public float getColumnDelay() {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void setColumnDelay(float columnDelay) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public float getRowDelay() {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public void setRowDelay(float rowDelay) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public int getDirection() {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public void setDirection(int direction) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public int getDirectionPriority() {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public void setDirectionPriority(int directionPriority) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public boolean willOverlap() {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    protected long getDelayForView(View view) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int DIRECTION_TOP_TO_BOTTOM = 0;
    /*    */   public static final int DIRECTION_BOTTOM_TO_TOP = 2;
    /*    */   public static final int DIRECTION_HORIZONTAL_MASK = 1;
    /*    */   public static final int DIRECTION_VERTICAL_MASK = 2;
    /*    */   public static final int PRIORITY_NONE = 0;
    /*    */   public static final int PRIORITY_COLUMN = 1;
    /*    */   public static final int PRIORITY_ROW = 2;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/view/animation/GridLayoutAnimationController.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */