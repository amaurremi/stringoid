/*     */
package android.view;
/*     */ 
/*     */

import android.graphics.Rect;

/*     */
/*     */ public abstract class ViewGroup extends View implements ViewParent, ViewManager {
    public static final int FOCUS_BEFORE_DESCENDANTS = 131072;
    /*     */   public static final int FOCUS_AFTER_DESCENDANTS = 262144;
    /*     */   public static final int FOCUS_BLOCK_DESCENDANTS = 393216;
    /*     */   public static final int PERSISTENT_NO_CACHE = 0;

    /*     */   public static abstract interface OnHierarchyChangeListener {
        public abstract void onChildViewAdded(View paramView1, View paramView2);

        /*     */
        public abstract void onChildViewRemoved(View paramView1, View paramView2);
    }

    /*     */   public static class LayoutParams {
        @Deprecated
/*     */ public static final int FILL_PARENT = -1;

        /*  13 */
        public LayoutParams(android.content.Context c, android.util.AttributeSet attrs) {
            throw new RuntimeException("Stub!");
        }

        public static final int MATCH_PARENT = -1;

        /*  14 */
        public LayoutParams(int width, int height) {
            throw new RuntimeException("Stub!");
        }

        public static final int WRAP_CONTENT = -2;

        /*  15 */
        public LayoutParams(LayoutParams source) {
            throw new RuntimeException("Stub!");
        }

        /*  16 */
        protected void setBaseAttributes(android.content.res.TypedArray a, int widthAttr, int heightAttr) {
            throw new RuntimeException("Stub!");
        }

        /*     */
/*     */
        @ViewDebug.ExportedProperty(category = "layout", mapping = {@ViewDebug.IntToString(from = -1, to = "MATCH_PARENT"), @ViewDebug.IntToString(from = -2, to = "WRAP_CONTENT")})
/*     */ public int width;
        /*     */
        @ViewDebug.ExportedProperty(category = "layout", mapping = {@ViewDebug.IntToString(from = -1, to = "MATCH_PARENT"), @ViewDebug.IntToString(from = -2, to = "WRAP_CONTENT")})
/*     */ public int height;
        /*     */     public android.view.animation.LayoutAnimationController.AnimationParameters layoutAnimationParameters;
    }

    /*     */
/*     */   public static class MarginLayoutParams extends ViewGroup.LayoutParams {
        @ViewDebug.ExportedProperty(category = "layout")
/*     */ public int leftMargin;
        /*     */
        @ViewDebug.ExportedProperty(category = "layout")
/*     */ public int topMargin;
        /*     */
        @ViewDebug.ExportedProperty(category = "layout")
/*     */ public int rightMargin;

        /*     */
/*  31 */
        public MarginLayoutParams(android.content.Context c, android.util.AttributeSet attrs) {
            super();
            throw new RuntimeException("Stub!");
        }

        /*  32 */
        public MarginLayoutParams(int width, int height) {
            super();
            throw new RuntimeException("Stub!");
        }

        /*  33 */
        public MarginLayoutParams(MarginLayoutParams source) {
            super();
            throw new RuntimeException("Stub!");
        }

        /*  34 */
        public MarginLayoutParams(ViewGroup.LayoutParams source) {
            super();
            throw new RuntimeException("Stub!");
        }

        /*  35 */
        public void setMargins(int left, int top, int right, int bottom) {
            throw new RuntimeException("Stub!");
        }

        /*     */
/*     */
        @ViewDebug.ExportedProperty(category = "layout")
/*     */ public int bottomMargin;
    }

    /*     */
/*     */   public static final int PERSISTENT_ANIMATION_CACHE = 1;
    /*     */   public static final int PERSISTENT_SCROLLING_CACHE = 2;
    /*     */   public static final int PERSISTENT_ALL_CACHES = 3;
    /*     */   protected static final int CLIP_TO_PADDING_MASK = 34;

    /*     */
/*  45 */
    public ViewGroup(android.content.Context context) {
        super((android.content.Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /*  46 */
    public ViewGroup(android.content.Context context, android.util.AttributeSet attrs) {
        super((android.content.Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /*  47 */
    public ViewGroup(android.content.Context context, android.util.AttributeSet attrs, int defStyle) {
        super((android.content.Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /*     */
    @ViewDebug.ExportedProperty(category = "focus", mapping = {@ViewDebug.IntToString(from = 131072, to = "FOCUS_BEFORE_DESCENDANTS"), @ViewDebug.IntToString(from = 262144, to = "FOCUS_AFTER_DESCENDANTS"), @ViewDebug.IntToString(from = 393216, to = "FOCUS_BLOCK_DESCENDANTS")})
/*  49 */ public int getDescendantFocusability() {
        throw new RuntimeException("Stub!");
    }

    /*  50 */
    public void setDescendantFocusability(int focusability) {
        throw new RuntimeException("Stub!");
    }

    /*  51 */
    public void requestChildFocus(View child, View focused) {
        throw new RuntimeException("Stub!");
    }

    /*  52 */
    public void focusableViewAvailable(View v) {
        throw new RuntimeException("Stub!");
    }

    /*  53 */
    public boolean showContextMenuForChild(View originalView) {
        throw new RuntimeException("Stub!");
    }

    /*  54 */
    public ActionMode startActionModeForChild(View originalView, ActionMode.Callback callback) {
        throw new RuntimeException("Stub!");
    }

    /*  55 */
    public View focusSearch(View focused, int direction) {
        throw new RuntimeException("Stub!");
    }

    /*  56 */
    public boolean requestChildRectangleOnScreen(View child, Rect rectangle, boolean immediate) {
        throw new RuntimeException("Stub!");
    }

    /*  57 */
    public boolean requestSendAccessibilityEvent(View child, android.view.accessibility.AccessibilityEvent event) {
        throw new RuntimeException("Stub!");
    }

    /*  58 */
    public boolean onRequestSendAccessibilityEvent(View child, android.view.accessibility.AccessibilityEvent event) {
        throw new RuntimeException("Stub!");
    }

    /*  59 */
    public boolean dispatchUnhandledMove(View focused, int direction) {
        throw new RuntimeException("Stub!");
    }

    /*  60 */
    public void clearChildFocus(View child) {
        throw new RuntimeException("Stub!");
    }

    /*  61 */
    public void clearFocus() {
        throw new RuntimeException("Stub!");
    }

    /*  62 */
    public View getFocusedChild() {
        throw new RuntimeException("Stub!");
    }

    /*  63 */
    public boolean hasFocus() {
        throw new RuntimeException("Stub!");
    }

    /*  64 */
    public View findFocus() {
        throw new RuntimeException("Stub!");
    }

    /*  65 */
    public boolean hasFocusable() {
        throw new RuntimeException("Stub!");
    }

    /*  66 */
    public void addFocusables(java.util.ArrayList<View> views, int direction, int focusableMode) {
        throw new RuntimeException("Stub!");
    }

    /*  67 */
    public void findViewsWithText(java.util.ArrayList<View> outViews, CharSequence text, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*  68 */
    public void dispatchWindowFocusChanged(boolean hasFocus) {
        throw new RuntimeException("Stub!");
    }

    /*  69 */
    public void addTouchables(java.util.ArrayList<View> views) {
        throw new RuntimeException("Stub!");
    }

    /*  70 */
    public void dispatchDisplayHint(int hint) {
        throw new RuntimeException("Stub!");
    }

    /*  71 */
    protected void dispatchVisibilityChanged(View changedView, int visibility) {
        throw new RuntimeException("Stub!");
    }

    /*  72 */
    public void dispatchWindowVisibilityChanged(int visibility) {
        throw new RuntimeException("Stub!");
    }

    /*  73 */
    public void dispatchConfigurationChanged(android.content.res.Configuration newConfig) {
        throw new RuntimeException("Stub!");
    }

    /*  74 */
    public void recomputeViewAttributes(View child) {
        throw new RuntimeException("Stub!");
    }

    /*  75 */
    public void bringChildToFront(View child) {
        throw new RuntimeException("Stub!");
    }

    /*  76 */
    public boolean dispatchDragEvent(DragEvent event) {
        throw new RuntimeException("Stub!");
    }

    /*  77 */
    public void dispatchWindowSystemUiVisiblityChanged(int visible) {
        throw new RuntimeException("Stub!");
    }

    /*  78 */
    public void dispatchSystemUiVisibilityChanged(int visible) {
        throw new RuntimeException("Stub!");
    }

    /*  79 */
    public boolean dispatchKeyEventPreIme(KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /*  80 */
    public boolean dispatchKeyEvent(KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /*  81 */
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /*  82 */
    public boolean dispatchTrackballEvent(MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    /*     */
/*  84 */
    protected boolean dispatchHoverEvent(MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    /*  85 */
    public void addChildrenForAccessibility(java.util.ArrayList<View> childrenForAccessibility) {
        throw new RuntimeException("Stub!");
    }

    /*  86 */
    public boolean onInterceptHoverEvent(MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    /*  87 */
    protected boolean dispatchGenericPointerEvent(MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    /*  88 */
    protected boolean dispatchGenericFocusedEvent(MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    /*  89 */
    public boolean dispatchTouchEvent(MotionEvent ev) {
        throw new RuntimeException("Stub!");
    }

    /*  90 */
    public void setMotionEventSplittingEnabled(boolean split) {
        throw new RuntimeException("Stub!");
    }

    /*  91 */
    public boolean isMotionEventSplittingEnabled() {
        throw new RuntimeException("Stub!");
    }

    /*  92 */
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        throw new RuntimeException("Stub!");
    }

    /*  93 */
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        throw new RuntimeException("Stub!");
    }

    /*  94 */
    public boolean requestFocus(int direction, Rect previouslyFocusedRect) {
        throw new RuntimeException("Stub!");
    }

    /*     */
/*  96 */
    protected boolean onRequestFocusInDescendants(int direction, Rect previouslyFocusedRect) {
        throw new RuntimeException("Stub!");
    }

    /*  97 */
    public void setPadding(int left, int top, int right, int bottom) {
        throw new RuntimeException("Stub!");
    }

    /*  98 */
    protected void dispatchSaveInstanceState(android.util.SparseArray<android.os.Parcelable> container) {
        throw new RuntimeException("Stub!");
    }

    /*  99 */
    protected void dispatchFreezeSelfOnly(android.util.SparseArray<android.os.Parcelable> container) {
        throw new RuntimeException("Stub!");
    }

    /* 100 */
    protected void dispatchRestoreInstanceState(android.util.SparseArray<android.os.Parcelable> container) {
        throw new RuntimeException("Stub!");
    }

    /* 101 */
    protected void dispatchThawSelfOnly(android.util.SparseArray<android.os.Parcelable> container) {
        throw new RuntimeException("Stub!");
    }

    /* 102 */
    protected void setChildrenDrawingCacheEnabled(boolean enabled) {
        throw new RuntimeException("Stub!");
    }

    /* 103 */
    protected void onAnimationStart() {
        throw new RuntimeException("Stub!");
    }

    /* 104 */
    protected void onAnimationEnd() {
        throw new RuntimeException("Stub!");
    }

    /* 105 */
    protected void dispatchDraw(android.graphics.Canvas canvas) {
        throw new RuntimeException("Stub!");
    }

    /* 106 */
    protected int getChildDrawingOrder(int childCount, int i) {
        throw new RuntimeException("Stub!");
    }

    /* 107 */
    protected boolean drawChild(android.graphics.Canvas canvas, View child, long drawingTime) {
        throw new RuntimeException("Stub!");
    }

    /* 108 */
    public void setClipChildren(boolean clipChildren) {
        throw new RuntimeException("Stub!");
    }

    /* 109 */
    public void setClipToPadding(boolean clipToPadding) {
        throw new RuntimeException("Stub!");
    }

    /* 110 */
    public void dispatchSetSelected(boolean selected) {
        throw new RuntimeException("Stub!");
    }

    /* 111 */
    public void dispatchSetActivated(boolean activated) {
        throw new RuntimeException("Stub!");
    }

    /* 112 */
    protected void dispatchSetPressed(boolean pressed) {
        throw new RuntimeException("Stub!");
    }

    /* 113 */
    protected void setStaticTransformationsEnabled(boolean enabled) {
        throw new RuntimeException("Stub!");
    }

    /* 114 */
    protected boolean getChildStaticTransformation(View child, android.view.animation.Transformation t) {
        throw new RuntimeException("Stub!");
    }

    /* 115 */
    public void addView(View child) {
        throw new RuntimeException("Stub!");
    }

    /* 116 */
    public void addView(View child, int index) {
        throw new RuntimeException("Stub!");
    }

    /* 117 */
    public void addView(View child, int width, int height) {
        throw new RuntimeException("Stub!");
    }

    /* 118 */
    public void addView(View child, LayoutParams params) {
        throw new RuntimeException("Stub!");
    }

    /* 119 */
    public void addView(View child, int index, LayoutParams params) {
        throw new RuntimeException("Stub!");
    }

    /* 120 */
    public void updateViewLayout(View view, LayoutParams params) {
        throw new RuntimeException("Stub!");
    }

    /* 121 */
    protected boolean checkLayoutParams(LayoutParams p) {
        throw new RuntimeException("Stub!");
    }

    /* 122 */
    public void setOnHierarchyChangeListener(OnHierarchyChangeListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 123 */
    protected boolean addViewInLayout(View child, int index, LayoutParams params) {
        throw new RuntimeException("Stub!");
    }

    /* 124 */
    protected boolean addViewInLayout(View child, int index, LayoutParams params, boolean preventRequestLayout) {
        throw new RuntimeException("Stub!");
    }

    /* 125 */
    protected void cleanupLayoutState(View child) {
        throw new RuntimeException("Stub!");
    }

    /* 126 */
    protected void attachLayoutAnimationParameters(View child, LayoutParams params, int index, int count) {
        throw new RuntimeException("Stub!");
    }

    /* 127 */
    public void removeView(View view) {
        throw new RuntimeException("Stub!");
    }

    /* 128 */
    public void removeViewInLayout(View view) {
        throw new RuntimeException("Stub!");
    }

    /* 129 */
    public void removeViewsInLayout(int start, int count) {
        throw new RuntimeException("Stub!");
    }

    /* 130 */
    public void removeViewAt(int index) {
        throw new RuntimeException("Stub!");
    }

    /* 131 */
    public void removeViews(int start, int count) {
        throw new RuntimeException("Stub!");
    }

    /* 132 */
    public void setLayoutTransition(android.animation.LayoutTransition transition) {
        throw new RuntimeException("Stub!");
    }

    /* 133 */
    public android.animation.LayoutTransition getLayoutTransition() {
        throw new RuntimeException("Stub!");
    }

    /* 134 */
    public void removeAllViews() {
        throw new RuntimeException("Stub!");
    }

    /* 135 */
    public void removeAllViewsInLayout() {
        throw new RuntimeException("Stub!");
    }

    /* 136 */
    protected void removeDetachedView(View child, boolean animate) {
        throw new RuntimeException("Stub!");
    }

    /* 137 */
    protected void attachViewToParent(View child, int index, LayoutParams params) {
        throw new RuntimeException("Stub!");
    }

    /* 138 */
    protected void detachViewFromParent(View child) {
        throw new RuntimeException("Stub!");
    }

    /* 139 */
    protected void detachViewFromParent(int index) {
        throw new RuntimeException("Stub!");
    }

    /* 140 */
    protected void detachViewsFromParent(int start, int count) {
        throw new RuntimeException("Stub!");
    }

    /* 141 */
    protected void detachAllViewsFromParent() {
        throw new RuntimeException("Stub!");
    }

    /* 142 */
    public final void invalidateChild(View child, Rect dirty) {
        throw new RuntimeException("Stub!");
    }

    /* 143 */
    public ViewParent invalidateChildInParent(int[] location, Rect dirty) {
        throw new RuntimeException("Stub!");
    }

    /* 144 */
    public final void offsetDescendantRectToMyCoords(View descendant, Rect rect) {
        throw new RuntimeException("Stub!");
    }

    /* 145 */
    public final void offsetRectIntoDescendantCoords(View descendant, Rect rect) {
        throw new RuntimeException("Stub!");
    }

    /* 146 */
    public boolean getChildVisibleRect(View child, Rect r, android.graphics.Point offset) {
        throw new RuntimeException("Stub!");
    }

    /* 147 */
    public final void layout(int l, int t, int r, int b) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    protected abstract void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4);

    /* 149 */
    protected boolean canAnimate() {
        throw new RuntimeException("Stub!");
    }

    /* 150 */
    public void startLayoutAnimation() {
        throw new RuntimeException("Stub!");
    }

    /* 151 */
    public void scheduleLayoutAnimation() {
        throw new RuntimeException("Stub!");
    }

    /* 152 */
    public void setLayoutAnimation(android.view.animation.LayoutAnimationController controller) {
        throw new RuntimeException("Stub!");
    }

    /* 153 */
    public android.view.animation.LayoutAnimationController getLayoutAnimation() {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @ViewDebug.ExportedProperty
/* 155 */ public boolean isAnimationCacheEnabled() {
        throw new RuntimeException("Stub!");
    }

    /* 156 */
    public void setAnimationCacheEnabled(boolean enabled) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @ViewDebug.ExportedProperty(category = "drawing")
/* 158 */ public boolean isAlwaysDrawnWithCacheEnabled() {
        throw new RuntimeException("Stub!");
    }

    /* 159 */
    public void setAlwaysDrawnWithCacheEnabled(boolean always) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @ViewDebug.ExportedProperty(category = "drawing")
/* 161 */ protected boolean isChildrenDrawnWithCacheEnabled() {
        throw new RuntimeException("Stub!");
    }

    /* 162 */
    protected void setChildrenDrawnWithCacheEnabled(boolean enabled) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @ViewDebug.ExportedProperty(category = "drawing")
/* 164 */ protected boolean isChildrenDrawingOrderEnabled() {
        throw new RuntimeException("Stub!");
    }

    /* 165 */
    protected void setChildrenDrawingOrderEnabled(boolean enabled) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @ViewDebug.ExportedProperty(category = "drawing", mapping = {@ViewDebug.IntToString(from = 0, to = "NONE"), @ViewDebug.IntToString(from = 1, to = "ANIMATION"), @ViewDebug.IntToString(from = 2, to = "SCROLLING"), @ViewDebug.IntToString(from = 3, to = "ALL")})
/* 167 */ public int getPersistentDrawingCache() {
        throw new RuntimeException("Stub!");
    }

    /* 168 */
    public void setPersistentDrawingCache(int drawingCacheToKeep) {
        throw new RuntimeException("Stub!");
    }

    /* 169 */
    public LayoutParams generateLayoutParams(android.util.AttributeSet attrs) {
        throw new RuntimeException("Stub!");
    }

    /* 170 */
    protected LayoutParams generateLayoutParams(LayoutParams p) {
        throw new RuntimeException("Stub!");
    }

    /* 171 */
    protected LayoutParams generateDefaultLayoutParams() {
        throw new RuntimeException("Stub!");
    }

    /* 172 */
    protected void debug(int depth) {
        throw new RuntimeException("Stub!");
    }

    /* 173 */
    public int indexOfChild(View child) {
        throw new RuntimeException("Stub!");
    }

    /* 174 */
    public int getChildCount() {
        throw new RuntimeException("Stub!");
    }

    /* 175 */
    public View getChildAt(int index) {
        throw new RuntimeException("Stub!");
    }

    /* 176 */
    protected void measureChildren(int widthMeasureSpec, int heightMeasureSpec) {
        throw new RuntimeException("Stub!");
    }

    /* 177 */
    protected void measureChild(View child, int parentWidthMeasureSpec, int parentHeightMeasureSpec) {
        throw new RuntimeException("Stub!");
    }

    /* 178 */
    protected void measureChildWithMargins(View child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
        throw new RuntimeException("Stub!");
    }

    /* 179 */
    public static int getChildMeasureSpec(int spec, int padding, int childDimension) {
        throw new RuntimeException("Stub!");
    }

    /* 180 */
    public void clearDisappearingChildren() {
        throw new RuntimeException("Stub!");
    }

    /* 181 */
    public void startViewTransition(View view) {
        throw new RuntimeException("Stub!");
    }

    /* 182 */
    public void endViewTransition(View view) {
        throw new RuntimeException("Stub!");
    }

    /* 183 */
    public boolean gatherTransparentRegion(android.graphics.Region region) {
        throw new RuntimeException("Stub!");
    }

    /* 184 */
    public void requestTransparentRegion(View child) {
        throw new RuntimeException("Stub!");
    }

    /* 185 */
    protected boolean fitSystemWindows(Rect insets) {
        throw new RuntimeException("Stub!");
    }

    /* 186 */
    public android.view.animation.Animation.AnimationListener getLayoutAnimationListener() {
        throw new RuntimeException("Stub!");
    }

    /* 187 */
    protected void drawableStateChanged() {
        throw new RuntimeException("Stub!");
    }

    /* 188 */
    public void jumpDrawablesToCurrentState() {
        throw new RuntimeException("Stub!");
    }

    /* 189 */
    protected int[] onCreateDrawableState(int extraSpace) {
        throw new RuntimeException("Stub!");
    }

    /* 190 */
    public void setAddStatesFromChildren(boolean addsStates) {
        throw new RuntimeException("Stub!");
    }

    /* 191 */
    public boolean addStatesFromChildren() {
        throw new RuntimeException("Stub!");
    }

    /* 192 */
    public void childDrawableStateChanged(View child) {
        throw new RuntimeException("Stub!");
    }

    /* 193 */
    public void setLayoutAnimationListener(android.view.animation.Animation.AnimationListener animationListener) {
        throw new RuntimeException("Stub!");
    }

    /* 194 */
    public boolean shouldDelayChildPressedState() {
        throw new RuntimeException("Stub!");
    }
/*     */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/view/ViewGroup.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */