/*    */
package android.animation;
/*    */ 
/*    */

import android.view.View;

/*    */
/*    */ public class LayoutTransition {
    /*    */   public static final int CHANGE_APPEARING = 0;
    /*    */   public static final int CHANGE_DISAPPEARING = 1;

    /*    */
/*  9 */
    public LayoutTransition() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public void setDuration(long duration) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public void enableTransitionType(int transitionType) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void disableTransitionType(int transitionType) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public boolean isTransitionTypeEnabled(int transitionType) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void setStartDelay(int transitionType, long delay) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public long getStartDelay(int transitionType) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public void setDuration(int transitionType, long duration) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public long getDuration(int transitionType) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void setStagger(int transitionType, long duration) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public long getStagger(int transitionType) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public void setInterpolator(int transitionType, TimeInterpolator interpolator) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public TimeInterpolator getInterpolator(int transitionType) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public void setAnimator(int transitionType, Animator animator) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public Animator getAnimator(int transitionType) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public void setAnimateParentHierarchy(boolean animateParentHierarchy) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public boolean isChangingLayout() {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public boolean isRunning() {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public void addChild(android.view.ViewGroup parent, View child) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 29 */ public void showChild(android.view.ViewGroup parent, View child) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public void showChild(android.view.ViewGroup parent, View child, int oldVisibility) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public void removeChild(android.view.ViewGroup parent, View child) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 33 */ public void hideChild(android.view.ViewGroup parent, View child) {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public void hideChild(android.view.ViewGroup parent, View child, int newVisibility) {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public void addTransitionListener(TransitionListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public void removeTransitionListener(TransitionListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public java.util.List<TransitionListener> getTransitionListeners() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int APPEARING = 2;
    /*    */   public static final int DISAPPEARING = 3;
    /*    */   public static final int CHANGING = 4;

    /*    */   public static abstract interface TransitionListener
/*    */ {
        /*    */
        public abstract void startTransition(LayoutTransition paramLayoutTransition, android.view.ViewGroup paramViewGroup, View paramView, int paramInt);

        /*    */
/*    */
        public abstract void endTransition(LayoutTransition paramLayoutTransition, android.view.ViewGroup paramViewGroup, View paramView, int paramInt);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/animation/LayoutTransition.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */