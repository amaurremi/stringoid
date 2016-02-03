/*     */
package android.widget;
/*     */ 
/*     */

import android.content.Context;
/*     */ import android.view.View;
/*     */ import android.view.ViewGroup.LayoutParams;

/*     */
/*     */ public abstract class AbsListView extends AdapterView<ListAdapter> implements android.text.TextWatcher, android.view.ViewTreeObserver.OnGlobalLayoutListener, Filter.FilterListener, android.view.ViewTreeObserver.OnTouchModeChangeListener
/*     */ {
    /*     */   public static final int TRANSCRIPT_MODE_DISABLED = 0;
    /*     */   public static final int TRANSCRIPT_MODE_NORMAL = 1;
    /*     */   public static final int TRANSCRIPT_MODE_ALWAYS_SCROLL = 2;
    /*     */   public static final int CHOICE_MODE_NONE = 0;
    /*     */   public static final int CHOICE_MODE_SINGLE = 1;
    /*     */   public static final int CHOICE_MODE_MULTIPLE = 2;
    /*     */   public static final int CHOICE_MODE_MULTIPLE_MODAL = 3;

    /*     */
/*     */   public static abstract interface RecyclerListener
/*     */ {
        /*     */
        public abstract void onMovedToScrapHeap(View paramView);
/*     */
    }

    /*     */
/*     */   public static class LayoutParams extends ViewGroup.LayoutParams
/*     */ {
        /*     */
        public LayoutParams(Context c, android.util.AttributeSet attrs)
/*     */ {
/*  26 */
            super();
            throw new RuntimeException("Stub!");
        }

        /*  27 */
        public LayoutParams(int w, int h) {
            super();
            throw new RuntimeException("Stub!");
        }

        /*  28 */
        public LayoutParams(int w, int h, int viewType) {
            super();
            throw new RuntimeException("Stub!");
        }

        /*  29 */
        public LayoutParams(ViewGroup.LayoutParams source) {
            super();
            throw new RuntimeException("Stub!");
/*     */
        }
/*     */
    }

    /*     */
/*     */
    public AbsListView(Context context)
/*     */ {
/*  35 */
        super((Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /*  36 */
    public AbsListView(Context context, android.util.AttributeSet attrs) {
        super((Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /*  37 */
    public AbsListView(Context context, android.util.AttributeSet attrs, int defStyle) {
        super((Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /*  38 */
    public void setOverScrollMode(int mode) {
        throw new RuntimeException("Stub!");
    }

    /*  39 */
    public void setAdapter(ListAdapter adapter) {
        throw new RuntimeException("Stub!");
    }

    /*  40 */
    public int getCheckedItemCount() {
        throw new RuntimeException("Stub!");
    }

    /*  41 */
    public boolean isItemChecked(int position) {
        throw new RuntimeException("Stub!");
    }

    /*  42 */
    public int getCheckedItemPosition() {
        throw new RuntimeException("Stub!");
    }

    /*  43 */
    public android.util.SparseBooleanArray getCheckedItemPositions() {
        throw new RuntimeException("Stub!");
    }

    /*  44 */
    public long[] getCheckedItemIds() {
        throw new RuntimeException("Stub!");
    }

    /*  45 */
    public void clearChoices() {
        throw new RuntimeException("Stub!");
    }

    /*  46 */
    public void setItemChecked(int position, boolean value) {
        throw new RuntimeException("Stub!");
    }

    /*  47 */
    public boolean performItemClick(View view, int position, long id) {
        throw new RuntimeException("Stub!");
    }

    /*  48 */
    public int getChoiceMode() {
        throw new RuntimeException("Stub!");
    }

    /*  49 */
    public void setChoiceMode(int choiceMode) {
        throw new RuntimeException("Stub!");
    }

    /*  50 */
    public void setMultiChoiceModeListener(MultiChoiceModeListener listener) {
        throw new RuntimeException("Stub!");
    }

    /*  51 */
    public void setFastScrollEnabled(boolean enabled) {
        throw new RuntimeException("Stub!");
    }

    /*  52 */
    public void setFastScrollAlwaysVisible(boolean alwaysShow) {
        throw new RuntimeException("Stub!");
    }

    /*  53 */
    public boolean isFastScrollAlwaysVisible() {
        throw new RuntimeException("Stub!");
    }

    /*  54 */
    public int getVerticalScrollbarWidth() {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @android.view.ViewDebug.ExportedProperty
/*  56 */ public boolean isFastScrollEnabled() {
        throw new RuntimeException("Stub!");
    }

    /*  57 */
    public void setVerticalScrollbarPosition(int position) {
        throw new RuntimeException("Stub!");
    }

    /*  58 */
    public void setSmoothScrollbarEnabled(boolean enabled) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @android.view.ViewDebug.ExportedProperty
/*  60 */ public boolean isSmoothScrollbarEnabled() {
        throw new RuntimeException("Stub!");
    }

    /*  61 */
    public void setOnScrollListener(OnScrollListener l) {
        throw new RuntimeException("Stub!");
    }

    /*  62 */
    public void addFocusables(java.util.ArrayList<View> views, int direction, int focusableMode) {
        throw new RuntimeException("Stub!");
    }

    /*  63 */
    public View focusSearch(int direction) {
        throw new RuntimeException("Stub!");
    }

    /*  64 */
    public View focusSearch(View focused, int direction) {
        throw new RuntimeException("Stub!");
    }

    /*  65 */
    public void sendAccessibilityEvent(int eventType) {
        throw new RuntimeException("Stub!");
    }

    /*  66 */
    public void onInitializeAccessibilityEvent(android.view.accessibility.AccessibilityEvent event) {
        throw new RuntimeException("Stub!");
    }

    /*  67 */
    public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo info) {
        throw new RuntimeException("Stub!");
    }

    /*  68 */
    public boolean performAccessibilityAction(int action, android.os.Bundle arguments) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @android.view.ViewDebug.ExportedProperty
/*  70 */ public boolean isScrollingCacheEnabled() {
        throw new RuntimeException("Stub!");
    }

    /*  71 */
    public void setScrollingCacheEnabled(boolean enabled) {
        throw new RuntimeException("Stub!");
    }

    /*  72 */
    public void setTextFilterEnabled(boolean textFilterEnabled) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @android.view.ViewDebug.ExportedProperty
/*  74 */ public boolean isTextFilterEnabled() {
        throw new RuntimeException("Stub!");
    }

    /*  75 */
    public void getFocusedRect(android.graphics.Rect r) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @android.view.ViewDebug.ExportedProperty
/*  77 */ public boolean isStackFromBottom() {
        throw new RuntimeException("Stub!");
    }

    /*  78 */
    public void setStackFromBottom(boolean stackFromBottom) {
        throw new RuntimeException("Stub!");
    }

    /*  79 */
    public android.os.Parcelable onSaveInstanceState() {
        throw new RuntimeException("Stub!");
    }

    /*  80 */
    public void onRestoreInstanceState(android.os.Parcelable state) {
        throw new RuntimeException("Stub!");
    }

    /*  81 */
    public void setFilterText(String filterText) {
        throw new RuntimeException("Stub!");
    }

    /*  82 */
    public CharSequence getTextFilter() {
        throw new RuntimeException("Stub!");
    }

    /*  83 */
    protected void onFocusChanged(boolean gainFocus, int direction, android.graphics.Rect previouslyFocusedRect) {
        throw new RuntimeException("Stub!");
    }

    /*  84 */
    public void requestLayout() {
        throw new RuntimeException("Stub!");
    }

    /*  85 */
    protected int computeVerticalScrollExtent() {
        throw new RuntimeException("Stub!");
    }

    /*  86 */
    protected int computeVerticalScrollOffset() {
        throw new RuntimeException("Stub!");
    }

    /*  87 */
    protected int computeVerticalScrollRange() {
        throw new RuntimeException("Stub!");
    }

    /*  88 */
    protected float getTopFadingEdgeStrength() {
        throw new RuntimeException("Stub!");
    }

    /*  89 */
    protected float getBottomFadingEdgeStrength() {
        throw new RuntimeException("Stub!");
    }

    /*  90 */
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        throw new RuntimeException("Stub!");
    }

    /*  91 */
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        throw new RuntimeException("Stub!");
    }

    /*  92 */
    protected void layoutChildren() {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @android.view.ViewDebug.ExportedProperty
/*  94 */ public View getSelectedView() {
        throw new RuntimeException("Stub!");
    }

    /*  95 */
    public int getListPaddingTop() {
        throw new RuntimeException("Stub!");
    }

    /*  96 */
    public int getListPaddingBottom() {
        throw new RuntimeException("Stub!");
    }

    /*  97 */
    public int getListPaddingLeft() {
        throw new RuntimeException("Stub!");
    }

    /*  98 */
    public int getListPaddingRight() {
        throw new RuntimeException("Stub!");
    }

    /*  99 */
    protected void dispatchDraw(android.graphics.Canvas canvas) {
        throw new RuntimeException("Stub!");
    }

    /* 100 */
    protected boolean isPaddingOffsetRequired() {
        throw new RuntimeException("Stub!");
    }

    /* 101 */
    protected int getLeftPaddingOffset() {
        throw new RuntimeException("Stub!");
    }

    /* 102 */
    protected int getTopPaddingOffset() {
        throw new RuntimeException("Stub!");
    }

    /* 103 */
    protected int getRightPaddingOffset() {
        throw new RuntimeException("Stub!");
    }

    /* 104 */
    protected int getBottomPaddingOffset() {
        throw new RuntimeException("Stub!");
    }

    /* 105 */
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        throw new RuntimeException("Stub!");
    }

    /* 106 */
    public void setDrawSelectorOnTop(boolean onTop) {
        throw new RuntimeException("Stub!");
    }

    /* 107 */
    public void setSelector(int resID) {
        throw new RuntimeException("Stub!");
    }

    /* 108 */
    public void setSelector(android.graphics.drawable.Drawable sel) {
        throw new RuntimeException("Stub!");
    }

    /* 109 */
    public android.graphics.drawable.Drawable getSelector() {
        throw new RuntimeException("Stub!");
    }

    /* 110 */
    public void setScrollIndicators(View up, View down) {
        throw new RuntimeException("Stub!");
    }

    /* 111 */
    protected void drawableStateChanged() {
        throw new RuntimeException("Stub!");
    }

    /* 112 */
    protected int[] onCreateDrawableState(int extraSpace) {
        throw new RuntimeException("Stub!");
    }

    /* 113 */
    public boolean verifyDrawable(android.graphics.drawable.Drawable dr) {
        throw new RuntimeException("Stub!");
    }

    /* 114 */
    public void jumpDrawablesToCurrentState() {
        throw new RuntimeException("Stub!");
    }

    /* 115 */
    protected void onAttachedToWindow() {
        throw new RuntimeException("Stub!");
    }

    /* 116 */
    protected void onDetachedFromWindow() {
        throw new RuntimeException("Stub!");
    }

    /* 117 */
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        throw new RuntimeException("Stub!");
    }

    /* 118 */
    protected android.view.ContextMenu.ContextMenuInfo getContextMenuInfo() {
        throw new RuntimeException("Stub!");
    }

    /* 119 */
    public boolean showContextMenuForChild(View originalView) {
        throw new RuntimeException("Stub!");
    }

    /* 120 */
    public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 121 */
    public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 122 */
    protected void dispatchSetPressed(boolean pressed) {
        throw new RuntimeException("Stub!");
    }

    /* 123 */
    public int pointToPosition(int x, int y) {
        throw new RuntimeException("Stub!");
    }

    /* 124 */
    public long pointToRowId(int x, int y) {
        throw new RuntimeException("Stub!");
    }

    /* 125 */
    public void onTouchModeChanged(boolean isInTouchMode) {
        throw new RuntimeException("Stub!");
    }

    /* 126 */
    public boolean onTouchEvent(android.view.MotionEvent ev) {
        throw new RuntimeException("Stub!");
    }

    /* 127 */
    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) {
        throw new RuntimeException("Stub!");
    }

    /* 128 */
    public boolean onGenericMotionEvent(android.view.MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 129 */
    public void draw(android.graphics.Canvas canvas) {
        throw new RuntimeException("Stub!");
    }

    /* 130 */
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        throw new RuntimeException("Stub!");
    }

    /* 131 */
    public boolean onInterceptTouchEvent(android.view.MotionEvent ev) {
        throw new RuntimeException("Stub!");
    }

    /* 132 */
    public void addTouchables(java.util.ArrayList<View> views) {
        throw new RuntimeException("Stub!");
    }

    /* 133 */
    public void setFriction(float friction) {
        throw new RuntimeException("Stub!");
    }

    /* 134 */
    public void setVelocityScale(float scale) {
        throw new RuntimeException("Stub!");
    }

    /* 135 */
    public void smoothScrollToPosition(int position) {
        throw new RuntimeException("Stub!");
    }

    /* 136 */
    public void smoothScrollToPositionFromTop(int position, int offset, int duration) {
        throw new RuntimeException("Stub!");
    }

    /* 137 */
    public void smoothScrollToPositionFromTop(int position, int offset) {
        throw new RuntimeException("Stub!");
    }

    /* 138 */
    public void smoothScrollToPosition(int position, int boundPosition) {
        throw new RuntimeException("Stub!");
    }

    /* 139 */
    public void smoothScrollBy(int distance, int duration) {
        throw new RuntimeException("Stub!");
    }

    /* 140 */
    public void invalidateViews() {
        throw new RuntimeException("Stub!");
    }

    /* 141 */
    protected void handleDataChanged() {
        throw new RuntimeException("Stub!");
    }

    /* 142 */
    protected void onDisplayHint(int hint) {
        throw new RuntimeException("Stub!");
    }

    /* 143 */
    protected boolean isInFilterMode() {
        throw new RuntimeException("Stub!");
    }

    /* 144 */
    public android.view.inputmethod.InputConnection onCreateInputConnection(android.view.inputmethod.EditorInfo outAttrs) {
        throw new RuntimeException("Stub!");
    }

    /* 145 */
    public boolean checkInputConnectionProxy(View view) {
        throw new RuntimeException("Stub!");
    }

    /* 146 */
    public void clearTextFilter() {
        throw new RuntimeException("Stub!");
    }

    /* 147 */
    public boolean hasTextFilter() {
        throw new RuntimeException("Stub!");
    }

    /* 148 */
    public void onGlobalLayout() {
        throw new RuntimeException("Stub!");
    }

    /* 149 */
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        throw new RuntimeException("Stub!");
    }

    /* 150 */
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        throw new RuntimeException("Stub!");
    }

    /* 151 */
    public void afterTextChanged(android.text.Editable s) {
        throw new RuntimeException("Stub!");
    }

    /* 152 */
    public void onFilterComplete(int count) {
        throw new RuntimeException("Stub!");
    }

    /* 153 */
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        throw new RuntimeException("Stub!");
    }

    /* 154 */
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        throw new RuntimeException("Stub!");
    }

    /* 155 */
    public LayoutParams generateLayoutParams(android.util.AttributeSet attrs) {
        throw new RuntimeException("Stub!");
    }

    /* 156 */
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        throw new RuntimeException("Stub!");
    }

    /* 157 */
    public void setTranscriptMode(int mode) {
        throw new RuntimeException("Stub!");
    }

    /* 158 */
    public int getTranscriptMode() {
        throw new RuntimeException("Stub!");
    }

    /* 159 */
    public int getSolidColor() {
        throw new RuntimeException("Stub!");
    }

    /* 160 */
    public void setCacheColorHint(int color) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @android.view.ViewDebug.ExportedProperty(category = "drawing")
/* 162 */ public int getCacheColorHint() {
        throw new RuntimeException("Stub!");
    }

    /* 163 */
    public void reclaimViews(java.util.List<View> views) {
        throw new RuntimeException("Stub!");
    }

    /* 164 */
    public void setRemoteViewsAdapter(android.content.Intent intent) {
        throw new RuntimeException("Stub!");
    }

    /* 165 */
    public void deferNotifyDataSetChanged() {
        throw new RuntimeException("Stub!");
    }

    /* 166 */
    public boolean onRemoteAdapterConnected() {
        throw new RuntimeException("Stub!");
    }

    /* 167 */
    public void onRemoteAdapterDisconnected() {
        throw new RuntimeException("Stub!");
    }

    /* 168 */
    public void setRecyclerListener(RecyclerListener listener) {
        throw new RuntimeException("Stub!");
    }

    /*     */
/*     */   public static abstract interface MultiChoiceModeListener
/*     */ extends android.view.ActionMode.Callback
/*     */ {
        /*     */
        public abstract void onItemCheckedStateChanged(android.view.ActionMode paramActionMode, int paramInt, long paramLong, boolean paramBoolean);
/*     */
    }

    /*     */
/*     */   public static abstract interface SelectionBoundsAdjuster
/*     */ {
        /*     */
        public abstract void adjustListItemSelectionBounds(android.graphics.Rect paramRect);
/*     */
    }

    /*     */
/*     */   public static abstract interface OnScrollListener
/*     */ {
        /*     */     public static final int SCROLL_STATE_IDLE = 0;
        /*     */     public static final int SCROLL_STATE_TOUCH_SCROLL = 1;
        /*     */     public static final int SCROLL_STATE_FLING = 2;

        /*     */
/*     */
        public abstract void onScrollStateChanged(AbsListView paramAbsListView, int paramInt);

        /*     */
/*     */
        public abstract void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3);
/*     */
    }
/*     */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/widget/AbsListView.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */