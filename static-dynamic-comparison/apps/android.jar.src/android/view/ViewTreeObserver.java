/*    */
package android.view;

/*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class ViewTreeObserver
/*    */ {
    /* 28 */   ViewTreeObserver() {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public void addOnGlobalFocusChangeListener(OnGlobalFocusChangeListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public void removeOnGlobalFocusChangeListener(OnGlobalFocusChangeListener victim) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public void addOnGlobalLayoutListener(OnGlobalLayoutListener listener) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 33 */ public void removeGlobalOnLayoutListener(OnGlobalLayoutListener victim) {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public void removeOnGlobalLayoutListener(OnGlobalLayoutListener victim) {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public void addOnPreDrawListener(OnPreDrawListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public void removeOnPreDrawListener(OnPreDrawListener victim) {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public void addOnDrawListener(OnDrawListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    public void removeOnDrawListener(OnDrawListener victim) {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    public void addOnScrollChangedListener(OnScrollChangedListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    public void removeOnScrollChangedListener(OnScrollChangedListener victim) {
        throw new RuntimeException("Stub!");
    }

    /* 41 */
    public void addOnTouchModeChangeListener(OnTouchModeChangeListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 42 */
    public void removeOnTouchModeChangeListener(OnTouchModeChangeListener victim) {
        throw new RuntimeException("Stub!");
    }

    /* 43 */
    public boolean isAlive() {
        throw new RuntimeException("Stub!");
    }

    /* 44 */
    public final void dispatchOnGlobalLayout() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/* 46 */
    public final boolean dispatchOnPreDraw() {
        throw new RuntimeException("Stub!");
    }

    /* 47 */
    public final void dispatchOnDraw() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface OnScrollChangedListener
/*    */ {
        /*    */
        public abstract void onScrollChanged();
/*    */
    }

    /*    */
/*    */   public static abstract interface OnTouchModeChangeListener
/*    */ {
        /*    */
        public abstract void onTouchModeChanged(boolean paramBoolean);
/*    */
    }

    /*    */
/*    */   public static abstract interface OnDrawListener
/*    */ {
        /*    */
        public abstract void onDraw();
/*    */
    }

    /*    */
/*    */   public static abstract interface OnPreDrawListener
/*    */ {
        /*    */
        public abstract boolean onPreDraw();
/*    */
    }

    /*    */
/*    */   public static abstract interface OnGlobalLayoutListener
/*    */ {
        /*    */
        public abstract void onGlobalLayout();
/*    */
    }

    /*    */
/*    */   public static abstract interface OnGlobalFocusChangeListener
/*    */ {
        /*    */
        public abstract void onGlobalFocusChanged(View paramView1, View paramView2);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/view/ViewTreeObserver.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */