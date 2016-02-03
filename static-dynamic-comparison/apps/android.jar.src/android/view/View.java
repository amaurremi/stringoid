/*     */
package android.view;
/*     */ 
/*     */

import android.graphics.Rect;

/*     */
/*     */ public class View implements android.graphics.drawable.Drawable.Callback, KeyEvent.Callback, android.view.accessibility.AccessibilityEventSource {
    protected static final String VIEW_LOG_TAG = "View";
    /*     */   public static final int NO_ID = -1;
    /*     */   public static final int VISIBLE = 0;

    /*     */
/*     */   public static abstract interface OnLayoutChangeListener {
        public abstract void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8);
    }

    /*     */
/*  11 */   public static class DragShadowBuilder {
        public DragShadowBuilder(View view) {
            throw new RuntimeException("Stub!");
        }

        /*  12 */
        public DragShadowBuilder() {
            throw new RuntimeException("Stub!");
        }

        /*     */
/*  14 */
        public final View getView() {
            throw new RuntimeException("Stub!");
        }

        /*  15 */
        public void onProvideShadowMetrics(android.graphics.Point shadowSize, android.graphics.Point shadowTouchPoint) {
            throw new RuntimeException("Stub!");
        }

        /*  16 */
        public void onDrawShadow(android.graphics.Canvas canvas) {
            throw new RuntimeException("Stub!");
        }
    }

    /*     */
/*     */   public static class MeasureSpec {
        public static final int UNSPECIFIED = 0;

        /*     */
/*  20 */
        public MeasureSpec() {
            throw new RuntimeException("Stub!");
        }

        /*  21 */
        public static int makeMeasureSpec(int size, int mode) {
            throw new RuntimeException("Stub!");
        }

        /*  22 */
        public static int getMode(int measureSpec) {
            throw new RuntimeException("Stub!");
        }

        /*  23 */
        public static int getSize(int measureSpec) {
            throw new RuntimeException("Stub!");
        }

        /*  24 */
        public static String toString(int measureSpec) {
            throw new RuntimeException("Stub!");
        }

        /*     */
/*     */     public static final int EXACTLY = 1073741824;
        /*     */     public static final int AT_MOST = Integer.MIN_VALUE;
/*     */
    }

    /*     */
/*     */   public static abstract interface OnKeyListener {
        /*     */
        public abstract boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent);
/*     */
    }

    /*     */
/*     */   public static abstract interface OnTouchListener {
        /*     */
        public abstract boolean onTouch(View paramView, MotionEvent paramMotionEvent);
/*     */
    }

    /*     */
/*     */   public static abstract interface OnHoverListener {
        /*     */
        public abstract boolean onHover(View paramView, MotionEvent paramMotionEvent);
/*     */
    }

    /*     */
/*     */   public static abstract interface OnGenericMotionListener {
        /*     */
        public abstract boolean onGenericMotion(View paramView, MotionEvent paramMotionEvent);
/*     */
    }

    /*     */
/*     */   public static abstract interface OnLongClickListener {
        /*     */
        public abstract boolean onLongClick(View paramView);
/*     */
    }

    /*     */
/*     */   public static abstract interface OnDragListener {
        /*     */
        public abstract boolean onDrag(View paramView, DragEvent paramDragEvent);
/*     */
    }

    /*     */
/*     */   public static abstract interface OnFocusChangeListener {
        /*     */
        public abstract void onFocusChange(View paramView, boolean paramBoolean);
/*     */
    }

    /*     */
/*     */   public static abstract interface OnClickListener {
        /*     */
        public abstract void onClick(View paramView);
/*     */
    }

    /*     */
/*     */   public static abstract interface OnCreateContextMenuListener {
        /*     */
        public abstract void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo);
/*     */
    }

    /*     */
/*     */   public static abstract interface OnSystemUiVisibilityChangeListener {
        /*     */
        public abstract void onSystemUiVisibilityChange(int paramInt);
/*     */
    }

    /*     */
/*     */   public static abstract interface OnAttachStateChangeListener {
        /*     */
        public abstract void onViewAttachedToWindow(View paramView);

        /*     */
/*     */
        public abstract void onViewDetachedFromWindow(View paramView);
/*     */
    }

    /*     */
/*     */   public static class BaseSavedState extends AbsSavedState {
        /*  77 */
        public BaseSavedState(android.os.Parcel source) {
            super();
            throw new RuntimeException("Stub!");
        }

        /*  78 */
        public BaseSavedState(android.os.Parcelable superState) {
            super();
            throw new RuntimeException("Stub!");
        }

        /*     */
/*  80 */     public static final android.os.Parcelable.Creator<BaseSavedState> CREATOR = null;
/*     */
    }

    /*     */
/*     */   public static class AccessibilityDelegate {
        /*  84 */
        public AccessibilityDelegate() {
            throw new RuntimeException("Stub!");
        }

        /*  85 */
        public void sendAccessibilityEvent(View host, int eventType) {
            throw new RuntimeException("Stub!");
        }

        /*  86 */
        public boolean performAccessibilityAction(View host, int action, android.os.Bundle args) {
            throw new RuntimeException("Stub!");
        }

        /*  87 */
        public void sendAccessibilityEventUnchecked(View host, android.view.accessibility.AccessibilityEvent event) {
            throw new RuntimeException("Stub!");
        }

        /*  88 */
        public boolean dispatchPopulateAccessibilityEvent(View host, android.view.accessibility.AccessibilityEvent event) {
            throw new RuntimeException("Stub!");
        }

        /*  89 */
        public void onPopulateAccessibilityEvent(View host, android.view.accessibility.AccessibilityEvent event) {
            throw new RuntimeException("Stub!");
        }

        /*  90 */
        public void onInitializeAccessibilityEvent(View host, android.view.accessibility.AccessibilityEvent event) {
            throw new RuntimeException("Stub!");
        }

        /*  91 */
        public void onInitializeAccessibilityNodeInfo(View host, android.view.accessibility.AccessibilityNodeInfo info) {
            throw new RuntimeException("Stub!");
        }

        /*  92 */
        public boolean onRequestSendAccessibilityEvent(ViewGroup host, View child, android.view.accessibility.AccessibilityEvent event) {
            throw new RuntimeException("Stub!");
        }

        /*  93 */
        public android.view.accessibility.AccessibilityNodeProvider getAccessibilityNodeProvider(View host) {
            throw new RuntimeException("Stub!");
        }
    }

    /*     */
/*  95 */
    public View(android.content.Context context) {
        throw new RuntimeException("Stub!");
    }

    /*  96 */
    public View(android.content.Context context, android.util.AttributeSet attrs) {
        throw new RuntimeException("Stub!");
    }

    /*  97 */
    public View(android.content.Context context, android.util.AttributeSet attrs, int defStyle) {
        throw new RuntimeException("Stub!");
    }

    /*  98 */
    protected void initializeFadingEdge(android.content.res.TypedArray a) {
        throw new RuntimeException("Stub!");
    }

    /*  99 */
    public int getVerticalFadingEdgeLength() {
        throw new RuntimeException("Stub!");
    }

    /* 100 */
    public void setFadingEdgeLength(int length) {
        throw new RuntimeException("Stub!");
    }

    /* 101 */
    public int getHorizontalFadingEdgeLength() {
        throw new RuntimeException("Stub!");
    }

    /* 102 */
    public int getVerticalScrollbarWidth() {
        throw new RuntimeException("Stub!");
    }

    /* 103 */
    protected int getHorizontalScrollbarHeight() {
        throw new RuntimeException("Stub!");
    }

    /* 104 */
    protected void initializeScrollbars(android.content.res.TypedArray a) {
        throw new RuntimeException("Stub!");
    }

    /* 105 */
    public void setVerticalScrollbarPosition(int position) {
        throw new RuntimeException("Stub!");
    }

    /* 106 */
    public int getVerticalScrollbarPosition() {
        throw new RuntimeException("Stub!");
    }

    /* 107 */
    public void setOnFocusChangeListener(OnFocusChangeListener l) {
        throw new RuntimeException("Stub!");
    }

    /* 108 */
    public void addOnLayoutChangeListener(OnLayoutChangeListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 109 */
    public void removeOnLayoutChangeListener(OnLayoutChangeListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 110 */
    public void addOnAttachStateChangeListener(OnAttachStateChangeListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 111 */
    public void removeOnAttachStateChangeListener(OnAttachStateChangeListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 112 */
    public OnFocusChangeListener getOnFocusChangeListener() {
        throw new RuntimeException("Stub!");
    }

    /* 113 */
    public void setOnClickListener(OnClickListener l) {
        throw new RuntimeException("Stub!");
    }

    /* 114 */
    public boolean hasOnClickListeners() {
        throw new RuntimeException("Stub!");
    }

    /* 115 */
    public void setOnLongClickListener(OnLongClickListener l) {
        throw new RuntimeException("Stub!");
    }

    /* 116 */
    public void setOnCreateContextMenuListener(OnCreateContextMenuListener l) {
        throw new RuntimeException("Stub!");
    }

    /* 117 */
    public boolean performClick() {
        throw new RuntimeException("Stub!");
    }

    /* 118 */
    public boolean callOnClick() {
        throw new RuntimeException("Stub!");
    }

    /* 119 */
    public boolean performLongClick() {
        throw new RuntimeException("Stub!");
    }

    /* 120 */
    public boolean showContextMenu() {
        throw new RuntimeException("Stub!");
    }

    /* 121 */
    public ActionMode startActionMode(ActionMode.Callback callback) {
        throw new RuntimeException("Stub!");
    }

    /* 122 */
    public void setOnKeyListener(OnKeyListener l) {
        throw new RuntimeException("Stub!");
    }

    /* 123 */
    public void setOnTouchListener(OnTouchListener l) {
        throw new RuntimeException("Stub!");
    }

    /* 124 */
    public void setOnGenericMotionListener(OnGenericMotionListener l) {
        throw new RuntimeException("Stub!");
    }

    /* 125 */
    public void setOnHoverListener(OnHoverListener l) {
        throw new RuntimeException("Stub!");
    }

    /* 126 */
    public void setOnDragListener(OnDragListener l) {
        throw new RuntimeException("Stub!");
    }

    /* 127 */
    public boolean requestRectangleOnScreen(Rect rectangle) {
        throw new RuntimeException("Stub!");
    }

    /* 128 */
    public boolean requestRectangleOnScreen(Rect rectangle, boolean immediate) {
        throw new RuntimeException("Stub!");
    }

    /* 129 */
    public void clearFocus() {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @ViewDebug.ExportedProperty(category = "focus")
/* 131 */ public boolean hasFocus() {
        throw new RuntimeException("Stub!");
    }

    /* 132 */
    public boolean hasFocusable() {
        throw new RuntimeException("Stub!");
    }

    /* 133 */
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        throw new RuntimeException("Stub!");
    }

    /* 134 */
    public void sendAccessibilityEvent(int eventType) {
        throw new RuntimeException("Stub!");
    }

    /* 135 */
    public void announceForAccessibility(CharSequence text) {
        throw new RuntimeException("Stub!");
    }

    /* 136 */
    public void sendAccessibilityEventUnchecked(android.view.accessibility.AccessibilityEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 137 */
    public boolean dispatchPopulateAccessibilityEvent(android.view.accessibility.AccessibilityEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 138 */
    public void onPopulateAccessibilityEvent(android.view.accessibility.AccessibilityEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 139 */
    public void onInitializeAccessibilityEvent(android.view.accessibility.AccessibilityEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 140 */
    public android.view.accessibility.AccessibilityNodeInfo createAccessibilityNodeInfo() {
        throw new RuntimeException("Stub!");
    }

    /* 141 */
    public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo info) {
        throw new RuntimeException("Stub!");
    }

    /* 142 */
    public void setAccessibilityDelegate(AccessibilityDelegate delegate) {
        throw new RuntimeException("Stub!");
    }

    /* 143 */
    public android.view.accessibility.AccessibilityNodeProvider getAccessibilityNodeProvider() {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @ViewDebug.ExportedProperty(category = "accessibility")
/* 145 */ public CharSequence getContentDescription() {
        throw new RuntimeException("Stub!");
    }

    /* 146 */
    public void setContentDescription(CharSequence contentDescription) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @ViewDebug.ExportedProperty(category = "focus")
/* 148 */ public boolean isFocused() {
        throw new RuntimeException("Stub!");
    }

    /* 149 */
    public View findFocus() {
        throw new RuntimeException("Stub!");
    }

    /* 150 */
    public boolean isScrollContainer() {
        throw new RuntimeException("Stub!");
    }

    /* 151 */
    public void setScrollContainer(boolean isScrollContainer) {
        throw new RuntimeException("Stub!");
    }

    /* 152 */
    public int getDrawingCacheQuality() {
        throw new RuntimeException("Stub!");
    }

    /* 153 */
    public void setDrawingCacheQuality(int quality) {
        throw new RuntimeException("Stub!");
    }

    /* 154 */
    public boolean getKeepScreenOn() {
        throw new RuntimeException("Stub!");
    }

    /* 155 */
    public void setKeepScreenOn(boolean keepScreenOn) {
        throw new RuntimeException("Stub!");
    }

    /* 156 */
    public int getNextFocusLeftId() {
        throw new RuntimeException("Stub!");
    }

    /* 157 */
    public void setNextFocusLeftId(int nextFocusLeftId) {
        throw new RuntimeException("Stub!");
    }

    /* 158 */
    public int getNextFocusRightId() {
        throw new RuntimeException("Stub!");
    }

    /* 159 */
    public void setNextFocusRightId(int nextFocusRightId) {
        throw new RuntimeException("Stub!");
    }

    /* 160 */
    public int getNextFocusUpId() {
        throw new RuntimeException("Stub!");
    }

    /* 161 */
    public void setNextFocusUpId(int nextFocusUpId) {
        throw new RuntimeException("Stub!");
    }

    /* 162 */
    public int getNextFocusDownId() {
        throw new RuntimeException("Stub!");
    }

    /* 163 */
    public void setNextFocusDownId(int nextFocusDownId) {
        throw new RuntimeException("Stub!");
    }

    /* 164 */
    public int getNextFocusForwardId() {
        throw new RuntimeException("Stub!");
    }

    /* 165 */
    public void setNextFocusForwardId(int nextFocusForwardId) {
        throw new RuntimeException("Stub!");
    }

    /* 166 */
    public boolean isShown() {
        throw new RuntimeException("Stub!");
    }

    /* 167 */
    protected boolean fitSystemWindows(Rect insets) {
        throw new RuntimeException("Stub!");
    }

    /* 168 */
    public void setFitsSystemWindows(boolean fitSystemWindows) {
        throw new RuntimeException("Stub!");
    }

    /* 169 */
    public boolean getFitsSystemWindows() {
        throw new RuntimeException("Stub!");
    }

    /* 170 */
    public void requestFitSystemWindows() {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @ViewDebug.ExportedProperty(mapping = {@ViewDebug.IntToString(from = 0, to = "VISIBLE"), @ViewDebug.IntToString(from = 4, to = "INVISIBLE"), @ViewDebug.IntToString(from = 8, to = "GONE")})
/* 172 */ public int getVisibility() {
        throw new RuntimeException("Stub!");
    }

    /* 173 */
    public void setVisibility(int visibility) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @ViewDebug.ExportedProperty
/* 175 */ public boolean isEnabled() {
        throw new RuntimeException("Stub!");
    }

    /* 176 */
    public void setEnabled(boolean enabled) {
        throw new RuntimeException("Stub!");
    }

    /* 177 */
    public void setFocusable(boolean focusable) {
        throw new RuntimeException("Stub!");
    }

    /* 178 */
    public void setFocusableInTouchMode(boolean focusableInTouchMode) {
        throw new RuntimeException("Stub!");
    }

    /* 179 */
    public void setSoundEffectsEnabled(boolean soundEffectsEnabled) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @ViewDebug.ExportedProperty
/* 181 */ public boolean isSoundEffectsEnabled() {
        throw new RuntimeException("Stub!");
    }

    /* 182 */
    public void setHapticFeedbackEnabled(boolean hapticFeedbackEnabled) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @ViewDebug.ExportedProperty
/* 184 */ public boolean isHapticFeedbackEnabled() {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @ViewDebug.ExportedProperty(category = "layout")
/* 186 */ public boolean hasTransientState() {
        throw new RuntimeException("Stub!");
    }

    /* 187 */
    public void setHasTransientState(boolean hasTransientState) {
        throw new RuntimeException("Stub!");
    }

    /* 188 */
    public void setWillNotDraw(boolean willNotDraw) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @ViewDebug.ExportedProperty(category = "drawing")
/* 190 */ public boolean willNotDraw() {
        throw new RuntimeException("Stub!");
    }

    /* 191 */
    public void setWillNotCacheDrawing(boolean willNotCacheDrawing) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @ViewDebug.ExportedProperty(category = "drawing")
/* 193 */ public boolean willNotCacheDrawing() {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @ViewDebug.ExportedProperty
/* 195 */ public boolean isClickable() {
        throw new RuntimeException("Stub!");
    }

    /* 196 */
    public void setClickable(boolean clickable) {
        throw new RuntimeException("Stub!");
    }

    /* 197 */
    public boolean isLongClickable() {
        throw new RuntimeException("Stub!");
    }

    /* 198 */
    public void setLongClickable(boolean longClickable) {
        throw new RuntimeException("Stub!");
    }

    /* 199 */
    public void setPressed(boolean pressed) {
        throw new RuntimeException("Stub!");
    }

    /* 200 */
    protected void dispatchSetPressed(boolean pressed) {
        throw new RuntimeException("Stub!");
    }

    /* 201 */
    public boolean isPressed() {
        throw new RuntimeException("Stub!");
    }

    /* 202 */
    public boolean isSaveEnabled() {
        throw new RuntimeException("Stub!");
    }

    /* 203 */
    public void setSaveEnabled(boolean enabled) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @ViewDebug.ExportedProperty
/* 205 */ public boolean getFilterTouchesWhenObscured() {
        throw new RuntimeException("Stub!");
    }

    /* 206 */
    public void setFilterTouchesWhenObscured(boolean enabled) {
        throw new RuntimeException("Stub!");
    }

    /* 207 */
    public boolean isSaveFromParentEnabled() {
        throw new RuntimeException("Stub!");
    }

    /* 208 */
    public void setSaveFromParentEnabled(boolean enabled) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @ViewDebug.ExportedProperty(category = "focus")
/* 210 */ public final boolean isFocusable() {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @ViewDebug.ExportedProperty
/* 212 */ public final boolean isFocusableInTouchMode() {
        throw new RuntimeException("Stub!");
    }

    /* 213 */
    public View focusSearch(int direction) {
        throw new RuntimeException("Stub!");
    }

    /* 214 */
    public boolean dispatchUnhandledMove(View focused, int direction) {
        throw new RuntimeException("Stub!");
    }

    /* 215 */
    public java.util.ArrayList<View> getFocusables(int direction) {
        throw new RuntimeException("Stub!");
    }

    /* 216 */
    public void addFocusables(java.util.ArrayList<View> views, int direction) {
        throw new RuntimeException("Stub!");
    }

    /* 217 */
    public void addFocusables(java.util.ArrayList<View> views, int direction, int focusableMode) {
        throw new RuntimeException("Stub!");
    }

    /* 218 */
    public void findViewsWithText(java.util.ArrayList<View> outViews, CharSequence searched, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 219 */
    public java.util.ArrayList<View> getTouchables() {
        throw new RuntimeException("Stub!");
    }

    /* 220 */
    public void addTouchables(java.util.ArrayList<View> views) {
        throw new RuntimeException("Stub!");
    }

    /* 221 */
    public final boolean requestFocus() {
        throw new RuntimeException("Stub!");
    }

    /* 222 */
    public final boolean requestFocus(int direction) {
        throw new RuntimeException("Stub!");
    }

    /* 223 */
    public boolean requestFocus(int direction, Rect previouslyFocusedRect) {
        throw new RuntimeException("Stub!");
    }

    /* 224 */
    public final boolean requestFocusFromTouch() {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @ViewDebug.ExportedProperty(category = "accessibility", mapping = {@ViewDebug.IntToString(from = 0, to = "auto"), @ViewDebug.IntToString(from = 1, to = "yes"), @ViewDebug.IntToString(from = 2, to = "no")})
/* 226 */ public int getImportantForAccessibility() {
        throw new RuntimeException("Stub!");
    }

    /* 227 */
    public void setImportantForAccessibility(int mode) {
        throw new RuntimeException("Stub!");
    }

    /* 228 */
    public ViewParent getParentForAccessibility() {
        throw new RuntimeException("Stub!");
    }

    /* 229 */
    public void addChildrenForAccessibility(java.util.ArrayList<View> children) {
        throw new RuntimeException("Stub!");
    }

    /* 230 */
    public boolean performAccessibilityAction(int action, android.os.Bundle arguments) {
        throw new RuntimeException("Stub!");
    }

    /* 231 */
    public void onStartTemporaryDetach() {
        throw new RuntimeException("Stub!");
    }

    /* 232 */
    public void onFinishTemporaryDetach() {
        throw new RuntimeException("Stub!");
    }

    /* 233 */
    public KeyEvent.DispatcherState getKeyDispatcherState() {
        throw new RuntimeException("Stub!");
    }

    /* 234 */
    public boolean dispatchKeyEventPreIme(KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 235 */
    public boolean dispatchKeyEvent(KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 236 */
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 237 */
    public boolean dispatchTouchEvent(MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 238 */
    public boolean onFilterTouchEventForSecurity(MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 239 */
    public boolean dispatchTrackballEvent(MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 240 */
    public boolean dispatchGenericMotionEvent(MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 241 */
    protected boolean dispatchHoverEvent(MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 242 */
    protected boolean dispatchGenericPointerEvent(MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 243 */
    protected boolean dispatchGenericFocusedEvent(MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 244 */
    public void dispatchWindowFocusChanged(boolean hasFocus) {
        throw new RuntimeException("Stub!");
    }

    /* 245 */
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        throw new RuntimeException("Stub!");
    }

    /* 246 */
    public boolean hasWindowFocus() {
        throw new RuntimeException("Stub!");
    }

    /* 247 */
    protected void dispatchVisibilityChanged(View changedView, int visibility) {
        throw new RuntimeException("Stub!");
    }

    /* 248 */
    protected void onVisibilityChanged(View changedView, int visibility) {
        throw new RuntimeException("Stub!");
    }

    /* 249 */
    public void dispatchDisplayHint(int hint) {
        throw new RuntimeException("Stub!");
    }

    /* 250 */
    protected void onDisplayHint(int hint) {
        throw new RuntimeException("Stub!");
    }

    /* 251 */
    public void dispatchWindowVisibilityChanged(int visibility) {
        throw new RuntimeException("Stub!");
    }

    /* 252 */
    protected void onWindowVisibilityChanged(int visibility) {
        throw new RuntimeException("Stub!");
    }

    /* 253 */
    public int getWindowVisibility() {
        throw new RuntimeException("Stub!");
    }

    /* 254 */
    public void getWindowVisibleDisplayFrame(Rect outRect) {
        throw new RuntimeException("Stub!");
    }

    /* 255 */
    public void dispatchConfigurationChanged(android.content.res.Configuration newConfig) {
        throw new RuntimeException("Stub!");
    }

    /* 256 */
    protected void onConfigurationChanged(android.content.res.Configuration newConfig) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @ViewDebug.ExportedProperty
/* 258 */ public boolean isInTouchMode() {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @ViewDebug.CapturedViewProperty
/* 260 */ public final android.content.Context getContext() {
        throw new RuntimeException("Stub!");
    }

    /* 261 */
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 262 */
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 263 */
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 264 */
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 265 */
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 266 */
    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 267 */
    public boolean onCheckIsTextEditor() {
        throw new RuntimeException("Stub!");
    }

    /* 268 */
    public android.view.inputmethod.InputConnection onCreateInputConnection(android.view.inputmethod.EditorInfo outAttrs) {
        throw new RuntimeException("Stub!");
    }

    /* 269 */
    public boolean checkInputConnectionProxy(View view) {
        throw new RuntimeException("Stub!");
    }

    /* 270 */
    public void createContextMenu(ContextMenu menu) {
        throw new RuntimeException("Stub!");
    }

    /* 271 */
    protected ContextMenu.ContextMenuInfo getContextMenuInfo() {
        throw new RuntimeException("Stub!");
    }

    /* 272 */
    protected void onCreateContextMenu(ContextMenu menu) {
        throw new RuntimeException("Stub!");
    }

    /* 273 */
    public boolean onTrackballEvent(MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 274 */
    public boolean onGenericMotionEvent(MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 275 */
    public boolean onHoverEvent(MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @ViewDebug.ExportedProperty
/* 277 */ public boolean isHovered() {
        throw new RuntimeException("Stub!");
    }

    /* 278 */
    public void setHovered(boolean hovered) {
        throw new RuntimeException("Stub!");
    }

    /* 279 */
    public void onHoverChanged(boolean hovered) {
        throw new RuntimeException("Stub!");
    }

    /* 280 */
    public boolean onTouchEvent(MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 281 */
    public void cancelLongPress() {
        throw new RuntimeException("Stub!");
    }

    /* 282 */
    public void setTouchDelegate(TouchDelegate delegate) {
        throw new RuntimeException("Stub!");
    }

    /* 283 */
    public TouchDelegate getTouchDelegate() {
        throw new RuntimeException("Stub!");
    }

    /* 284 */
    public void bringToFront() {
        throw new RuntimeException("Stub!");
    }

    /* 285 */
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        throw new RuntimeException("Stub!");
    }

    /* 286 */
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        throw new RuntimeException("Stub!");
    }

    /* 287 */
    protected void dispatchDraw(android.graphics.Canvas canvas) {
        throw new RuntimeException("Stub!");
    }

    /* 288 */
    public final ViewParent getParent() {
        throw new RuntimeException("Stub!");
    }

    /* 289 */
    public void setScrollX(int value) {
        throw new RuntimeException("Stub!");
    }

    /* 290 */
    public void setScrollY(int value) {
        throw new RuntimeException("Stub!");
    }

    /* 291 */
    public final int getScrollX() {
        throw new RuntimeException("Stub!");
    }

    /* 292 */
    public final int getScrollY() {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @ViewDebug.ExportedProperty(category = "layout")
/* 294 */ public final int getWidth() {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @ViewDebug.ExportedProperty(category = "layout")
/* 296 */ public final int getHeight() {
        throw new RuntimeException("Stub!");
    }

    /* 297 */
    public void getDrawingRect(Rect outRect) {
        throw new RuntimeException("Stub!");
    }

    /* 298 */
    public final int getMeasuredWidth() {
        throw new RuntimeException("Stub!");
    }

    /* 299 */
    public final int getMeasuredWidthAndState() {
        throw new RuntimeException("Stub!");
    }

    /* 300 */
    public final int getMeasuredHeight() {
        throw new RuntimeException("Stub!");
    }

    /* 301 */
    public final int getMeasuredHeightAndState() {
        throw new RuntimeException("Stub!");
    }

    /* 302 */
    public final int getMeasuredState() {
        throw new RuntimeException("Stub!");
    }

    /* 303 */
    public android.graphics.Matrix getMatrix() {
        throw new RuntimeException("Stub!");
    }

    /* 304 */
    public float getCameraDistance() {
        throw new RuntimeException("Stub!");
    }

    /* 305 */
    public void setCameraDistance(float distance) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @ViewDebug.ExportedProperty(category = "drawing")
/* 307 */ public float getRotation() {
        throw new RuntimeException("Stub!");
    }

    /* 308 */
    public void setRotation(float rotation) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @ViewDebug.ExportedProperty(category = "drawing")
/* 310 */ public float getRotationY() {
        throw new RuntimeException("Stub!");
    }

    /* 311 */
    public void setRotationY(float rotationY) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @ViewDebug.ExportedProperty(category = "drawing")
/* 313 */ public float getRotationX() {
        throw new RuntimeException("Stub!");
    }

    /* 314 */
    public void setRotationX(float rotationX) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @ViewDebug.ExportedProperty(category = "drawing")
/* 316 */ public float getScaleX() {
        throw new RuntimeException("Stub!");
    }

    /* 317 */
    public void setScaleX(float scaleX) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @ViewDebug.ExportedProperty(category = "drawing")
/* 319 */ public float getScaleY() {
        throw new RuntimeException("Stub!");
    }

    /* 320 */
    public void setScaleY(float scaleY) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @ViewDebug.ExportedProperty(category = "drawing")
/* 322 */ public float getPivotX() {
        throw new RuntimeException("Stub!");
    }

    /* 323 */
    public void setPivotX(float pivotX) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @ViewDebug.ExportedProperty(category = "drawing")
/* 325 */ public float getPivotY() {
        throw new RuntimeException("Stub!");
    }

    /* 326 */
    public void setPivotY(float pivotY) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @ViewDebug.ExportedProperty(category = "drawing")
/* 328 */ public float getAlpha() {
        throw new RuntimeException("Stub!");
    }

    /* 329 */
    public boolean hasOverlappingRendering() {
        throw new RuntimeException("Stub!");
    }

    /* 330 */
    public void setAlpha(float alpha) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @ViewDebug.CapturedViewProperty
/* 332 */ public final int getTop() {
        throw new RuntimeException("Stub!");
    }

    /* 333 */
    public final void setTop(int top) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @ViewDebug.CapturedViewProperty
/* 335 */ public final int getBottom() {
        throw new RuntimeException("Stub!");
    }

    /* 336 */
    public boolean isDirty() {
        throw new RuntimeException("Stub!");
    }

    /* 337 */
    public final void setBottom(int bottom) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @ViewDebug.CapturedViewProperty
/* 339 */ public final int getLeft() {
        throw new RuntimeException("Stub!");
    }

    /* 340 */
    public final void setLeft(int left) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @ViewDebug.CapturedViewProperty
/* 342 */ public final int getRight() {
        throw new RuntimeException("Stub!");
    }

    /* 343 */
    public final void setRight(int right) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @ViewDebug.ExportedProperty(category = "drawing")
/* 345 */ public float getX() {
        throw new RuntimeException("Stub!");
    }

    /* 346 */
    public void setX(float x) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @ViewDebug.ExportedProperty(category = "drawing")
/* 348 */ public float getY() {
        throw new RuntimeException("Stub!");
    }

    /* 349 */
    public void setY(float y) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @ViewDebug.ExportedProperty(category = "drawing")
/* 351 */ public float getTranslationX() {
        throw new RuntimeException("Stub!");
    }

    /* 352 */
    public void setTranslationX(float translationX) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @ViewDebug.ExportedProperty(category = "drawing")
/* 354 */ public float getTranslationY() {
        throw new RuntimeException("Stub!");
    }

    /* 355 */
    public void setTranslationY(float translationY) {
        throw new RuntimeException("Stub!");
    }

    /* 356 */
    public void getHitRect(Rect outRect) {
        throw new RuntimeException("Stub!");
    }

    /* 357 */
    public void getFocusedRect(Rect r) {
        throw new RuntimeException("Stub!");
    }

    /* 358 */
    public boolean getGlobalVisibleRect(Rect r, android.graphics.Point globalOffset) {
        throw new RuntimeException("Stub!");
    }

    /* 359 */
    public final boolean getGlobalVisibleRect(Rect r) {
        throw new RuntimeException("Stub!");
    }

    /* 360 */
    public final boolean getLocalVisibleRect(Rect r) {
        throw new RuntimeException("Stub!");
    }

    /* 361 */
    public void offsetTopAndBottom(int offset) {
        throw new RuntimeException("Stub!");
    }

    /* 362 */
    public void offsetLeftAndRight(int offset) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @ViewDebug.ExportedProperty(deepExport = true, prefix = "layout_")
/* 364 */ public ViewGroup.LayoutParams getLayoutParams() {
        throw new RuntimeException("Stub!");
    }

    /* 365 */
    public void setLayoutParams(ViewGroup.LayoutParams params) {
        throw new RuntimeException("Stub!");
    }

    /* 366 */
    public void scrollTo(int x, int y) {
        throw new RuntimeException("Stub!");
    }

    /* 367 */
    public void scrollBy(int x, int y) {
        throw new RuntimeException("Stub!");
    }

    /* 368 */
    protected boolean awakenScrollBars() {
        throw new RuntimeException("Stub!");
    }

    /* 369 */
    protected boolean awakenScrollBars(int startDelay) {
        throw new RuntimeException("Stub!");
    }

    /* 370 */
    protected boolean awakenScrollBars(int startDelay, boolean invalidate) {
        throw new RuntimeException("Stub!");
    }

    /* 371 */
    public void invalidate(Rect dirty) {
        throw new RuntimeException("Stub!");
    }

    /* 372 */
    public void invalidate(int l, int t, int r, int b) {
        throw new RuntimeException("Stub!");
    }

    /* 373 */
    public void invalidate() {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @ViewDebug.ExportedProperty(category = "drawing")
/* 375 */ public boolean isOpaque() {
        throw new RuntimeException("Stub!");
    }

    /* 376 */
    public android.os.Handler getHandler() {
        throw new RuntimeException("Stub!");
    }

    /* 377 */
    public boolean post(Runnable action) {
        throw new RuntimeException("Stub!");
    }

    /* 378 */
    public boolean postDelayed(Runnable action, long delayMillis) {
        throw new RuntimeException("Stub!");
    }

    /* 379 */
    public void postOnAnimation(Runnable action) {
        throw new RuntimeException("Stub!");
    }

    /* 380 */
    public void postOnAnimationDelayed(Runnable action, long delayMillis) {
        throw new RuntimeException("Stub!");
    }

    /* 381 */
    public boolean removeCallbacks(Runnable action) {
        throw new RuntimeException("Stub!");
    }

    /* 382 */
    public void postInvalidate() {
        throw new RuntimeException("Stub!");
    }

    /* 383 */
    public void postInvalidate(int left, int top, int right, int bottom) {
        throw new RuntimeException("Stub!");
    }

    /* 384 */
    public void postInvalidateDelayed(long delayMilliseconds) {
        throw new RuntimeException("Stub!");
    }

    /* 385 */
    public void postInvalidateDelayed(long delayMilliseconds, int left, int top, int right, int bottom) {
        throw new RuntimeException("Stub!");
    }

    /* 386 */
    public void postInvalidateOnAnimation() {
        throw new RuntimeException("Stub!");
    }

    /* 387 */
    public void postInvalidateOnAnimation(int left, int top, int right, int bottom) {
        throw new RuntimeException("Stub!");
    }

    /* 388 */
    public void computeScroll() {
        throw new RuntimeException("Stub!");
    }

    /* 389 */
    public boolean isHorizontalFadingEdgeEnabled() {
        throw new RuntimeException("Stub!");
    }

    /* 390 */
    public void setHorizontalFadingEdgeEnabled(boolean horizontalFadingEdgeEnabled) {
        throw new RuntimeException("Stub!");
    }

    /* 391 */
    public boolean isVerticalFadingEdgeEnabled() {
        throw new RuntimeException("Stub!");
    }

    /* 392 */
    public void setVerticalFadingEdgeEnabled(boolean verticalFadingEdgeEnabled) {
        throw new RuntimeException("Stub!");
    }

    /* 393 */
    protected float getTopFadingEdgeStrength() {
        throw new RuntimeException("Stub!");
    }

    /* 394 */
    protected float getBottomFadingEdgeStrength() {
        throw new RuntimeException("Stub!");
    }

    /* 395 */
    protected float getLeftFadingEdgeStrength() {
        throw new RuntimeException("Stub!");
    }

    /* 396 */
    protected float getRightFadingEdgeStrength() {
        throw new RuntimeException("Stub!");
    }

    /* 397 */
    public boolean isHorizontalScrollBarEnabled() {
        throw new RuntimeException("Stub!");
    }

    /* 398 */
    public void setHorizontalScrollBarEnabled(boolean horizontalScrollBarEnabled) {
        throw new RuntimeException("Stub!");
    }

    /* 399 */
    public boolean isVerticalScrollBarEnabled() {
        throw new RuntimeException("Stub!");
    }

    /* 400 */
    public void setVerticalScrollBarEnabled(boolean verticalScrollBarEnabled) {
        throw new RuntimeException("Stub!");
    }

    /* 401 */
    public void setScrollbarFadingEnabled(boolean fadeScrollbars) {
        throw new RuntimeException("Stub!");
    }

    /* 402 */
    public boolean isScrollbarFadingEnabled() {
        throw new RuntimeException("Stub!");
    }

    /* 403 */
    public int getScrollBarDefaultDelayBeforeFade() {
        throw new RuntimeException("Stub!");
    }

    /* 404 */
    public void setScrollBarDefaultDelayBeforeFade(int scrollBarDefaultDelayBeforeFade) {
        throw new RuntimeException("Stub!");
    }

    /* 405 */
    public int getScrollBarFadeDuration() {
        throw new RuntimeException("Stub!");
    }

    /* 406 */
    public void setScrollBarFadeDuration(int scrollBarFadeDuration) {
        throw new RuntimeException("Stub!");
    }

    /* 407 */
    public int getScrollBarSize() {
        throw new RuntimeException("Stub!");
    }

    /* 408 */
    public void setScrollBarSize(int scrollBarSize) {
        throw new RuntimeException("Stub!");
    }

    /* 409 */
    public void setScrollBarStyle(int style) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @ViewDebug.ExportedProperty(mapping = {@ViewDebug.IntToString(from = 0, to = "INSIDE_OVERLAY"), @ViewDebug.IntToString(from = 16777216, to = "INSIDE_INSET"), @ViewDebug.IntToString(from = 33554432, to = "OUTSIDE_OVERLAY"), @ViewDebug.IntToString(from = 50331648, to = "OUTSIDE_INSET")})
/* 411 */ public int getScrollBarStyle() {
        throw new RuntimeException("Stub!");
    }

    /* 412 */
    protected int computeHorizontalScrollRange() {
        throw new RuntimeException("Stub!");
    }

    /* 413 */
    protected int computeHorizontalScrollOffset() {
        throw new RuntimeException("Stub!");
    }

    /* 414 */
    protected int computeHorizontalScrollExtent() {
        throw new RuntimeException("Stub!");
    }

    /* 415 */
    protected int computeVerticalScrollRange() {
        throw new RuntimeException("Stub!");
    }

    /* 416 */
    protected int computeVerticalScrollOffset() {
        throw new RuntimeException("Stub!");
    }

    /* 417 */
    protected int computeVerticalScrollExtent() {
        throw new RuntimeException("Stub!");
    }

    /* 418 */
    public boolean canScrollHorizontally(int direction) {
        throw new RuntimeException("Stub!");
    }

    /* 419 */
    public boolean canScrollVertically(int direction) {
        throw new RuntimeException("Stub!");
    }

    /* 420 */
    protected final void onDrawScrollBars(android.graphics.Canvas canvas) {
        throw new RuntimeException("Stub!");
    }

    /* 421 */
    protected void onDraw(android.graphics.Canvas canvas) {
        throw new RuntimeException("Stub!");
    }

    /* 422 */
    protected void onAttachedToWindow() {
        throw new RuntimeException("Stub!");
    }

    /* 423 */
    public void onScreenStateChanged(int screenState) {
        throw new RuntimeException("Stub!");
    }

    /* 424 */
    protected void onDetachedFromWindow() {
        throw new RuntimeException("Stub!");
    }

    /* 425 */
    protected int getWindowAttachCount() {
        throw new RuntimeException("Stub!");
    }

    /* 426 */
    public android.os.IBinder getWindowToken() {
        throw new RuntimeException("Stub!");
    }

    /* 427 */
    public android.os.IBinder getApplicationWindowToken() {
        throw new RuntimeException("Stub!");
    }

    /* 428 */
    public void saveHierarchyState(android.util.SparseArray<android.os.Parcelable> container) {
        throw new RuntimeException("Stub!");
    }

    /* 429 */
    protected void dispatchSaveInstanceState(android.util.SparseArray<android.os.Parcelable> container) {
        throw new RuntimeException("Stub!");
    }

    /* 430 */
    protected android.os.Parcelable onSaveInstanceState() {
        throw new RuntimeException("Stub!");
    }

    /* 431 */
    public void restoreHierarchyState(android.util.SparseArray<android.os.Parcelable> container) {
        throw new RuntimeException("Stub!");
    }

    /* 432 */
    protected void dispatchRestoreInstanceState(android.util.SparseArray<android.os.Parcelable> container) {
        throw new RuntimeException("Stub!");
    }

    /* 433 */
    protected void onRestoreInstanceState(android.os.Parcelable state) {
        throw new RuntimeException("Stub!");
    }

    /* 434 */
    public long getDrawingTime() {
        throw new RuntimeException("Stub!");
    }

    /* 435 */
    public void setDuplicateParentStateEnabled(boolean enabled) {
        throw new RuntimeException("Stub!");
    }

    /* 436 */
    public boolean isDuplicateParentStateEnabled() {
        throw new RuntimeException("Stub!");
    }

    /* 437 */
    public void setLayerType(int layerType, android.graphics.Paint paint) {
        throw new RuntimeException("Stub!");
    }

    /* 438 */
    public int getLayerType() {
        throw new RuntimeException("Stub!");
    }

    /* 439 */
    public void buildLayer() {
        throw new RuntimeException("Stub!");
    }

    /* 440 */
    public void setDrawingCacheEnabled(boolean enabled) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @ViewDebug.ExportedProperty(category = "drawing")
/* 442 */ public boolean isDrawingCacheEnabled() {
        throw new RuntimeException("Stub!");
    }

    /* 443 */
    public android.graphics.Bitmap getDrawingCache() {
        throw new RuntimeException("Stub!");
    }

    /* 444 */
    public android.graphics.Bitmap getDrawingCache(boolean autoScale) {
        throw new RuntimeException("Stub!");
    }

    /* 445 */
    public void destroyDrawingCache() {
        throw new RuntimeException("Stub!");
    }

    /* 446 */
    public void setDrawingCacheBackgroundColor(int color) {
        throw new RuntimeException("Stub!");
    }

    /* 447 */
    public int getDrawingCacheBackgroundColor() {
        throw new RuntimeException("Stub!");
    }

    /* 448 */
    public void buildDrawingCache() {
        throw new RuntimeException("Stub!");
    }

    /* 449 */
    public void buildDrawingCache(boolean autoScale) {
        throw new RuntimeException("Stub!");
    }

    /* 450 */
    public boolean isInEditMode() {
        throw new RuntimeException("Stub!");
    }

    /* 451 */
    protected boolean isPaddingOffsetRequired() {
        throw new RuntimeException("Stub!");
    }

    /* 452 */
    protected int getLeftPaddingOffset() {
        throw new RuntimeException("Stub!");
    }

    /* 453 */
    protected int getRightPaddingOffset() {
        throw new RuntimeException("Stub!");
    }

    /* 454 */
    protected int getTopPaddingOffset() {
        throw new RuntimeException("Stub!");
    }

    /* 455 */
    protected int getBottomPaddingOffset() {
        throw new RuntimeException("Stub!");
    }

    /* 456 */
    public boolean isHardwareAccelerated() {
        throw new RuntimeException("Stub!");
    }

    /* 457 */
    public void draw(android.graphics.Canvas canvas) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @ViewDebug.ExportedProperty(category = "drawing")
/* 459 */ public int getSolidColor() {
        throw new RuntimeException("Stub!");
    }

    /* 460 */
    public boolean isLayoutRequested() {
        throw new RuntimeException("Stub!");
    }

    /*     */
/* 462 */
    public void layout(int l, int t, int r, int b) {
        throw new RuntimeException("Stub!");
    }

    /* 463 */
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        throw new RuntimeException("Stub!");
    }

    /* 464 */
    protected void onFinishInflate() {
        throw new RuntimeException("Stub!");
    }

    /* 465 */
    public android.content.res.Resources getResources() {
        throw new RuntimeException("Stub!");
    }

    /* 466 */
    public void invalidateDrawable(android.graphics.drawable.Drawable drawable) {
        throw new RuntimeException("Stub!");
    }

    /* 467 */
    public void scheduleDrawable(android.graphics.drawable.Drawable who, Runnable what, long when) {
        throw new RuntimeException("Stub!");
    }

    /* 468 */
    public void unscheduleDrawable(android.graphics.drawable.Drawable who, Runnable what) {
        throw new RuntimeException("Stub!");
    }

    /* 469 */
    public void unscheduleDrawable(android.graphics.drawable.Drawable who) {
        throw new RuntimeException("Stub!");
    }

    /* 470 */
    protected boolean verifyDrawable(android.graphics.drawable.Drawable who) {
        throw new RuntimeException("Stub!");
    }

    /* 471 */
    protected void drawableStateChanged() {
        throw new RuntimeException("Stub!");
    }

    /* 472 */
    public void refreshDrawableState() {
        throw new RuntimeException("Stub!");
    }

    /* 473 */
    public final int[] getDrawableState() {
        throw new RuntimeException("Stub!");
    }

    /* 474 */
    protected int[] onCreateDrawableState(int extraSpace) {
        throw new RuntimeException("Stub!");
    }

    /* 475 */
    protected static int[] mergeDrawableStates(int[] baseState, int[] additionalState) {
        throw new RuntimeException("Stub!");
    }

    /* 476 */
    public void jumpDrawablesToCurrentState() {
        throw new RuntimeException("Stub!");
    }

    /* 477 */
    public void setBackgroundColor(int color) {
        throw new RuntimeException("Stub!");
    }

    /* 478 */
    public void setBackgroundResource(int resid) {
        throw new RuntimeException("Stub!");
    }

    /* 479 */
    public void setBackground(android.graphics.drawable.Drawable background) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @Deprecated
/* 481 */ public void setBackgroundDrawable(android.graphics.drawable.Drawable background) {
        throw new RuntimeException("Stub!");
    }

    /* 482 */
    public android.graphics.drawable.Drawable getBackground() {
        throw new RuntimeException("Stub!");
    }

    /* 483 */
    public void setPadding(int left, int top, int right, int bottom) {
        throw new RuntimeException("Stub!");
    }

    /* 484 */
    public int getPaddingTop() {
        throw new RuntimeException("Stub!");
    }

    /* 485 */
    public int getPaddingBottom() {
        throw new RuntimeException("Stub!");
    }

    /* 486 */
    public int getPaddingLeft() {
        throw new RuntimeException("Stub!");
    }

    /* 487 */
    public int getPaddingRight() {
        throw new RuntimeException("Stub!");
    }

    /* 488 */
    public void setSelected(boolean selected) {
        throw new RuntimeException("Stub!");
    }

    /* 489 */
    protected void dispatchSetSelected(boolean selected) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @ViewDebug.ExportedProperty
/* 491 */ public boolean isSelected() {
        throw new RuntimeException("Stub!");
    }

    /* 492 */
    public void setActivated(boolean activated) {
        throw new RuntimeException("Stub!");
    }

    /* 493 */
    protected void dispatchSetActivated(boolean activated) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @ViewDebug.ExportedProperty
/* 495 */ public boolean isActivated() {
        throw new RuntimeException("Stub!");
    }

    /* 496 */
    public ViewTreeObserver getViewTreeObserver() {
        throw new RuntimeException("Stub!");
    }

    /* 497 */
    public View getRootView() {
        throw new RuntimeException("Stub!");
    }

    /* 498 */
    public void getLocationOnScreen(int[] location) {
        throw new RuntimeException("Stub!");
    }

    /* 499 */
    public void getLocationInWindow(int[] location) {
        throw new RuntimeException("Stub!");
    }

    /* 500 */
    public final View findViewById(int id) {
        throw new RuntimeException("Stub!");
    }

    /* 501 */
    public final View findViewWithTag(Object tag) {
        throw new RuntimeException("Stub!");
    }

    /* 502 */
    public void setId(int id) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @ViewDebug.CapturedViewProperty
/* 504 */ public int getId() {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @ViewDebug.ExportedProperty
/* 506 */ public Object getTag() {
        throw new RuntimeException("Stub!");
    }

    /* 507 */
    public void setTag(Object tag) {
        throw new RuntimeException("Stub!");
    }

    /* 508 */
    public Object getTag(int key) {
        throw new RuntimeException("Stub!");
    }

    /* 509 */
    public void setTag(int key, Object tag) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @ViewDebug.ExportedProperty(category = "layout")
/* 511 */ public int getBaseline() {
        throw new RuntimeException("Stub!");
    }

    /* 512 */
    public void requestLayout() {
        throw new RuntimeException("Stub!");
    }

    /* 513 */
    public void forceLayout() {
        throw new RuntimeException("Stub!");
    }

    /* 514 */
    public final void measure(int widthMeasureSpec, int heightMeasureSpec) {
        throw new RuntimeException("Stub!");
    }

    /* 515 */
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        throw new RuntimeException("Stub!");
    }

    /* 516 */
    protected final void setMeasuredDimension(int measuredWidth, int measuredHeight) {
        throw new RuntimeException("Stub!");
    }

    /* 517 */
    public static int combineMeasuredStates(int curState, int newState) {
        throw new RuntimeException("Stub!");
    }

    /* 518 */
    public static int resolveSize(int size, int measureSpec) {
        throw new RuntimeException("Stub!");
    }

    /* 519 */
    public static int resolveSizeAndState(int size, int measureSpec, int childMeasuredState) {
        throw new RuntimeException("Stub!");
    }

    /* 520 */
    public static int getDefaultSize(int size, int measureSpec) {
        throw new RuntimeException("Stub!");
    }

    /* 521 */
    protected int getSuggestedMinimumHeight() {
        throw new RuntimeException("Stub!");
    }

    /* 522 */
    protected int getSuggestedMinimumWidth() {
        throw new RuntimeException("Stub!");
    }

    /* 523 */
    public int getMinimumHeight() {
        throw new RuntimeException("Stub!");
    }

    /* 524 */
    public void setMinimumHeight(int minHeight) {
        throw new RuntimeException("Stub!");
    }

    /* 525 */
    public int getMinimumWidth() {
        throw new RuntimeException("Stub!");
    }

    /* 526 */
    public void setMinimumWidth(int minWidth) {
        throw new RuntimeException("Stub!");
    }

    /* 527 */
    public android.view.animation.Animation getAnimation() {
        throw new RuntimeException("Stub!");
    }

    /* 528 */
    public void startAnimation(android.view.animation.Animation animation) {
        throw new RuntimeException("Stub!");
    }

    /* 529 */
    public void clearAnimation() {
        throw new RuntimeException("Stub!");
    }

    /* 530 */
    public void setAnimation(android.view.animation.Animation animation) {
        throw new RuntimeException("Stub!");
    }

    /* 531 */
    protected void onAnimationStart() {
        throw new RuntimeException("Stub!");
    }

    /* 532 */
    protected void onAnimationEnd() {
        throw new RuntimeException("Stub!");
    }

    /* 533 */
    protected boolean onSetAlpha(int alpha) {
        throw new RuntimeException("Stub!");
    }

    /* 534 */
    public void playSoundEffect(int soundConstant) {
        throw new RuntimeException("Stub!");
    }

    /* 535 */
    public boolean performHapticFeedback(int feedbackConstant) {
        throw new RuntimeException("Stub!");
    }

    /* 536 */
    public boolean performHapticFeedback(int feedbackConstant, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 537 */
    public void setSystemUiVisibility(int visibility) {
        throw new RuntimeException("Stub!");
    }

    /* 538 */
    public int getSystemUiVisibility() {
        throw new RuntimeException("Stub!");
    }

    /* 539 */
    public int getWindowSystemUiVisibility() {
        throw new RuntimeException("Stub!");
    }

    /* 540 */
    public void onWindowSystemUiVisibilityChanged(int visible) {
        throw new RuntimeException("Stub!");
    }

    /* 541 */
    public void dispatchWindowSystemUiVisiblityChanged(int visible) {
        throw new RuntimeException("Stub!");
    }

    /* 542 */
    public void setOnSystemUiVisibilityChangeListener(OnSystemUiVisibilityChangeListener l) {
        throw new RuntimeException("Stub!");
    }

    /* 543 */
    public void dispatchSystemUiVisibilityChanged(int visibility) {
        throw new RuntimeException("Stub!");
    }

    /* 544 */
    public final boolean startDrag(android.content.ClipData data, DragShadowBuilder shadowBuilder, Object myLocalState, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 545 */
    public boolean onDragEvent(DragEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 546 */
    public boolean dispatchDragEvent(DragEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 547 */
    public static View inflate(android.content.Context context, int resource, ViewGroup root) {
        throw new RuntimeException("Stub!");
    }

    /*     */
/* 549 */
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
        throw new RuntimeException("Stub!");
    }

    /* 550 */
    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) {
        throw new RuntimeException("Stub!");
    }

    /* 551 */
    public int getOverScrollMode() {
        throw new RuntimeException("Stub!");
    }

    /* 552 */
    public void setOverScrollMode(int overScrollMode) {
        throw new RuntimeException("Stub!");
    }

    /* 553 */
    public ViewPropertyAnimator animate() {
        throw new RuntimeException("Stub!");
    }

    /*     */
/*     */ 
/*     */   public static final int INVISIBLE = 4;
    /*     */
/*     */   public static final int GONE = 8;
    /*     */   public static final int DRAWING_CACHE_QUALITY_LOW = 524288;
    /*     */   public static final int DRAWING_CACHE_QUALITY_HIGH = 1048576;
    /*     */   public static final int DRAWING_CACHE_QUALITY_AUTO = 0;
    /*     */   public static final int SCROLLBARS_INSIDE_OVERLAY = 0;
    /*     */   public static final int SCROLLBARS_INSIDE_INSET = 16777216;
    /*     */   public static final int SCROLLBARS_OUTSIDE_OVERLAY = 33554432;
    /*     */   public static final int SCROLLBARS_OUTSIDE_INSET = 50331648;
    /*     */   public static final int KEEP_SCREEN_ON = 67108864;
    /*     */   public static final int SOUND_EFFECTS_ENABLED = 134217728;
    /*     */   public static final int HAPTIC_FEEDBACK_ENABLED = 268435456;
    /*     */   public static final int FOCUSABLES_ALL = 0;
    /*     */   public static final int FOCUSABLES_TOUCH_MODE = 1;
    /*     */   public static final int FOCUS_BACKWARD = 1;
    /*     */   public static final int FOCUS_FORWARD = 2;
    /*     */   public static final int FOCUS_LEFT = 17;
    /*     */   public static final int FOCUS_UP = 33;
    /*     */   public static final int FOCUS_RIGHT = 66;
    /*     */   public static final int FOCUS_DOWN = 130;
    /*     */   public static final int MEASURED_SIZE_MASK = 16777215;
    /*     */   public static final int MEASURED_STATE_MASK = -16777216;
    /*     */   public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;
    /*     */   public static final int MEASURED_STATE_TOO_SMALL = 16777216;
    /* 581 */   protected static final int[] EMPTY_STATE_SET = null;
    /* 582 */   protected static final int[] ENABLED_STATE_SET = null;
    /* 583 */   protected static final int[] FOCUSED_STATE_SET = null;
    /* 584 */   protected static final int[] SELECTED_STATE_SET = null;
    /* 585 */   protected static final int[] WINDOW_FOCUSED_STATE_SET = null;
    /* 586 */   protected static final int[] ENABLED_FOCUSED_STATE_SET = null;
    /* 587 */   protected static final int[] ENABLED_SELECTED_STATE_SET = null;
    /* 588 */   protected static final int[] ENABLED_WINDOW_FOCUSED_STATE_SET = null;
    /* 589 */   protected static final int[] FOCUSED_SELECTED_STATE_SET = null;
    /* 590 */   protected static final int[] FOCUSED_WINDOW_FOCUSED_STATE_SET = null;
    /* 591 */   protected static final int[] SELECTED_WINDOW_FOCUSED_STATE_SET = null;
    /* 592 */   protected static final int[] ENABLED_FOCUSED_SELECTED_STATE_SET = null;
    /* 593 */   protected static final int[] ENABLED_FOCUSED_WINDOW_FOCUSED_STATE_SET = null;
    /* 594 */   protected static final int[] ENABLED_SELECTED_WINDOW_FOCUSED_STATE_SET = null;
    /* 595 */   protected static final int[] FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET = null;
    /* 596 */   protected static final int[] ENABLED_FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET = null;
    /* 597 */   protected static final int[] PRESSED_WINDOW_FOCUSED_STATE_SET = null;
    /* 598 */   protected static final int[] PRESSED_SELECTED_STATE_SET = null;
    /* 599 */   protected static final int[] PRESSED_SELECTED_WINDOW_FOCUSED_STATE_SET = null;
    /* 600 */   protected static final int[] PRESSED_FOCUSED_STATE_SET = null;
    /* 601 */   protected static final int[] PRESSED_FOCUSED_WINDOW_FOCUSED_STATE_SET = null;
    /* 602 */   protected static final int[] PRESSED_FOCUSED_SELECTED_STATE_SET = null;
    /* 603 */   protected static final int[] PRESSED_FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET = null;
    /* 604 */   protected static final int[] PRESSED_ENABLED_STATE_SET = null;
    /* 605 */   protected static final int[] PRESSED_ENABLED_WINDOW_FOCUSED_STATE_SET = null;
    /* 606 */   protected static final int[] PRESSED_ENABLED_SELECTED_STATE_SET = null;
    /* 607 */   protected static final int[] PRESSED_ENABLED_SELECTED_WINDOW_FOCUSED_STATE_SET = null;
    /* 608 */   protected static final int[] PRESSED_ENABLED_FOCUSED_STATE_SET = null;
    /* 609 */   protected static final int[] PRESSED_ENABLED_FOCUSED_WINDOW_FOCUSED_STATE_SET = null;
    /* 610 */   protected static final int[] PRESSED_ENABLED_FOCUSED_SELECTED_STATE_SET = null;
    /* 611 */   protected static final int[] PRESSED_ENABLED_FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET = null;
    /*     */
/*     */   public static final int TEXT_ALIGNMENT_INHERIT = 0;
    /*     */
/*     */   public static final int TEXT_ALIGNMENT_RESOLVED_DEFAULT = 131072;
    /*     */
/*     */   public static final int IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0;
    /*     */
/*     */   public static final int IMPORTANT_FOR_ACCESSIBILITY_YES = 1;
    /*     */
/*     */   public static final int IMPORTANT_FOR_ACCESSIBILITY_NO = 2;
    /*     */
/*     */   public static final int OVER_SCROLL_ALWAYS = 0;
    /*     */
/*     */   public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
    /*     */
/*     */   public static final int OVER_SCROLL_NEVER = 2;
    /*     */
/*     */   public static final int SYSTEM_UI_FLAG_VISIBLE = 0;
    /*     */
/*     */   public static final int SYSTEM_UI_FLAG_LOW_PROFILE = 1;
    /*     */   public static final int SYSTEM_UI_FLAG_HIDE_NAVIGATION = 2;
    /*     */   public static final int SYSTEM_UI_FLAG_FULLSCREEN = 4;
    /*     */   public static final int SYSTEM_UI_FLAG_LAYOUT_STABLE = 256;
    /*     */   public static final int SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION = 512;
    /*     */   public static final int SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN = 1024;
    /*     */
    @Deprecated
/*     */ public static final int STATUS_BAR_HIDDEN = 1;
    /*     */
    @Deprecated
/*     */ public static final int STATUS_BAR_VISIBLE = 0;
    /*     */   public static final int SYSTEM_UI_LAYOUT_FLAGS = 1536;
    /*     */   public static final int FIND_VIEWS_WITH_TEXT = 1;
    /*     */   public static final int FIND_VIEWS_WITH_CONTENT_DESCRIPTION = 2;
    /*     */   public static final int SCREEN_STATE_OFF = 0;
    /*     */   public static final int SCREEN_STATE_ON = 1;
    /*     */   public static final int SCROLLBAR_POSITION_DEFAULT = 0;
    /*     */   public static final int SCROLLBAR_POSITION_LEFT = 1;
    /*     */   public static final int SCROLLBAR_POSITION_RIGHT = 2;
    /*     */   public static final int LAYER_TYPE_NONE = 0;
    /*     */   public static final int LAYER_TYPE_SOFTWARE = 1;
    /*     */   public static final int LAYER_TYPE_HARDWARE = 2;
    /* 652 */   public static final android.util.Property<View, Float> ALPHA = null;
    public static final android.util.Property<View, Float> TRANSLATION_X = null;
    public static final android.util.Property<View, Float> TRANSLATION_Y = null;
    public static final android.util.Property<View, Float> X = null;
    public static final android.util.Property<View, Float> Y = null;
    public static final android.util.Property<View, Float> ROTATION = null;
    public static final android.util.Property<View, Float> ROTATION_X = null;
    public static final android.util.Property<View, Float> ROTATION_Y = null;
    public static final android.util.Property<View, Float> SCALE_X = null;
    public static final android.util.Property<View, Float> SCALE_Y = null;
/*     */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/view/View.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */