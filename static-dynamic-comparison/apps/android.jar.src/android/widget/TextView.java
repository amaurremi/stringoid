/*     */
package android.widget;
/*     */ 
/*     */

import android.graphics.drawable.Drawable;

/*     */
/*     */
@RemoteViews.RemoteView
/*     */ public class TextView extends android.view.View implements android.view.ViewTreeObserver.OnPreDrawListener
/*     */ {
    /*     */   public static abstract interface OnEditorActionListener {
        /*     */
        public abstract boolean onEditorAction(TextView paramTextView, int paramInt, android.view.KeyEvent paramKeyEvent);
/*     */
    }

    /*     */
/*     */   public static enum BufferType {
        /*  13 */     EDITABLE,
        /*  14 */     NORMAL,
        /*  15 */     SPANNABLE;

        /*     */
/*     */
        private BufferType() {
        }
/*     */
    }

    /*     */
/*  20 */   public static class SavedState extends android.view.View.BaseSavedState {
        SavedState() {
            super();
            throw new RuntimeException("Stub!");
        }

        /*  21 */
        public void writeToParcel(android.os.Parcel out, int flags) {
            throw new RuntimeException("Stub!");
        }

        /*  22 */
        public String toString() {
            throw new RuntimeException("Stub!");
        }

        /*     */
/*     */ 
/*  25 */     public static final android.os.Parcelable.Creator<SavedState> CREATOR = null;
    }

    /*     */
/*  27 */
    public TextView(android.content.Context context) {
        super((android.content.Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /*  28 */
    public TextView(android.content.Context context, android.util.AttributeSet attrs) {
        super((android.content.Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /*     */
/*  30 */
    public TextView(android.content.Context context, android.util.AttributeSet attrs, int defStyle) {
        super((android.content.Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /*  31 */
    public void setEnabled(boolean enabled) {
        throw new RuntimeException("Stub!");
    }

    /*  32 */
    public void setTypeface(android.graphics.Typeface tf, int style) {
        throw new RuntimeException("Stub!");
    }

    /*  33 */
    protected boolean getDefaultEditable() {
        throw new RuntimeException("Stub!");
    }

    /*  34 */
    protected android.text.method.MovementMethod getDefaultMovementMethod() {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @android.view.ViewDebug.CapturedViewProperty
/*  36 */ public CharSequence getText() {
        throw new RuntimeException("Stub!");
    }

    /*  37 */
    public int length() {
        throw new RuntimeException("Stub!");
    }

    /*  38 */
    public android.text.Editable getEditableText() {
        throw new RuntimeException("Stub!");
    }

    /*  39 */
    public int getLineHeight() {
        throw new RuntimeException("Stub!");
    }

    /*  40 */
    public final android.text.Layout getLayout() {
        throw new RuntimeException("Stub!");
    }

    /*  41 */
    public final android.text.method.KeyListener getKeyListener() {
        throw new RuntimeException("Stub!");
    }

    /*  42 */
    public void setKeyListener(android.text.method.KeyListener input) {
        throw new RuntimeException("Stub!");
    }

    /*  43 */
    public final android.text.method.MovementMethod getMovementMethod() {
        throw new RuntimeException("Stub!");
    }

    /*  44 */
    public final void setMovementMethod(android.text.method.MovementMethod movement) {
        throw new RuntimeException("Stub!");
    }

    /*  45 */
    public final android.text.method.TransformationMethod getTransformationMethod() {
        throw new RuntimeException("Stub!");
    }

    /*  46 */
    public final void setTransformationMethod(android.text.method.TransformationMethod method) {
        throw new RuntimeException("Stub!");
    }

    /*  47 */
    public int getCompoundPaddingTop() {
        throw new RuntimeException("Stub!");
    }

    /*  48 */
    public int getCompoundPaddingBottom() {
        throw new RuntimeException("Stub!");
    }

    /*  49 */
    public int getCompoundPaddingLeft() {
        throw new RuntimeException("Stub!");
    }

    /*  50 */
    public int getCompoundPaddingRight() {
        throw new RuntimeException("Stub!");
    }

    /*  51 */
    public int getExtendedPaddingTop() {
        throw new RuntimeException("Stub!");
    }

    /*  52 */
    public int getExtendedPaddingBottom() {
        throw new RuntimeException("Stub!");
    }

    /*  53 */
    public int getTotalPaddingLeft() {
        throw new RuntimeException("Stub!");
    }

    /*  54 */
    public int getTotalPaddingRight() {
        throw new RuntimeException("Stub!");
    }

    /*  55 */
    public int getTotalPaddingTop() {
        throw new RuntimeException("Stub!");
    }

    /*  56 */
    public int getTotalPaddingBottom() {
        throw new RuntimeException("Stub!");
    }

    /*  57 */
    public void setCompoundDrawables(Drawable left, Drawable top, Drawable right, Drawable bottom) {
        throw new RuntimeException("Stub!");
    }

    /*  58 */
    public void setCompoundDrawablesWithIntrinsicBounds(int left, int top, int right, int bottom) {
        throw new RuntimeException("Stub!");
    }

    /*  59 */
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable left, Drawable top, Drawable right, Drawable bottom) {
        throw new RuntimeException("Stub!");
    }

    /*  60 */
    public Drawable[] getCompoundDrawables() {
        throw new RuntimeException("Stub!");
    }

    /*  61 */
    public void setCompoundDrawablePadding(int pad) {
        throw new RuntimeException("Stub!");
    }

    /*  62 */
    public int getCompoundDrawablePadding() {
        throw new RuntimeException("Stub!");
    }

    /*  63 */
    public void setPadding(int left, int top, int right, int bottom) {
        throw new RuntimeException("Stub!");
    }

    /*  64 */
    public void setPaddingRelative(int start, int top, int end, int bottom) {
        throw new RuntimeException("Stub!");
    }

    /*  65 */
    public final int getAutoLinkMask() {
        throw new RuntimeException("Stub!");
    }

    /*  66 */
    public void setTextAppearance(android.content.Context context, int resid) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @android.view.ViewDebug.ExportedProperty(category = "text")
/*  68 */ public float getTextSize() {
        throw new RuntimeException("Stub!");
    }

    /*  69 */
    public void setTextSize(float size) {
        throw new RuntimeException("Stub!");
    }

    /*  70 */
    public void setTextSize(int unit, float size) {
        throw new RuntimeException("Stub!");
    }

    /*  71 */
    public float getTextScaleX() {
        throw new RuntimeException("Stub!");
    }

    /*  72 */
    public void setTextScaleX(float size) {
        throw new RuntimeException("Stub!");
    }

    /*  73 */
    public void setTypeface(android.graphics.Typeface tf) {
        throw new RuntimeException("Stub!");
    }

    /*  74 */
    public android.graphics.Typeface getTypeface() {
        throw new RuntimeException("Stub!");
    }

    /*  75 */
    public void setTextColor(int color) {
        throw new RuntimeException("Stub!");
    }

    /*  76 */
    public void setTextColor(android.content.res.ColorStateList colors) {
        throw new RuntimeException("Stub!");
    }

    /*  77 */
    public final android.content.res.ColorStateList getTextColors() {
        throw new RuntimeException("Stub!");
    }

    /*  78 */
    public final int getCurrentTextColor() {
        throw new RuntimeException("Stub!");
    }

    /*  79 */
    public void setHighlightColor(int color) {
        throw new RuntimeException("Stub!");
    }

    /*  80 */
    public int getHighlightColor() {
        throw new RuntimeException("Stub!");
    }

    /*  81 */
    public void setShadowLayer(float radius, float dx, float dy, int color) {
        throw new RuntimeException("Stub!");
    }

    /*  82 */
    public float getShadowRadius() {
        throw new RuntimeException("Stub!");
    }

    /*  83 */
    public float getShadowDx() {
        throw new RuntimeException("Stub!");
    }

    /*  84 */
    public float getShadowDy() {
        throw new RuntimeException("Stub!");
    }

    /*  85 */
    public int getShadowColor() {
        throw new RuntimeException("Stub!");
    }

    /*  86 */
    public android.text.TextPaint getPaint() {
        throw new RuntimeException("Stub!");
    }

    /*  87 */
    public final void setAutoLinkMask(int mask) {
        throw new RuntimeException("Stub!");
    }

    /*  88 */
    public final void setLinksClickable(boolean whether) {
        throw new RuntimeException("Stub!");
    }

    /*  89 */
    public final boolean getLinksClickable() {
        throw new RuntimeException("Stub!");
    }

    /*  90 */
    public android.text.style.URLSpan[] getUrls() {
        throw new RuntimeException("Stub!");
    }

    /*  91 */
    public final void setHintTextColor(int color) {
        throw new RuntimeException("Stub!");
    }

    /*  92 */
    public final void setHintTextColor(android.content.res.ColorStateList colors) {
        throw new RuntimeException("Stub!");
    }

    /*  93 */
    public final android.content.res.ColorStateList getHintTextColors() {
        throw new RuntimeException("Stub!");
    }

    /*  94 */
    public final int getCurrentHintTextColor() {
        throw new RuntimeException("Stub!");
    }

    /*  95 */
    public final void setLinkTextColor(int color) {
        throw new RuntimeException("Stub!");
    }

    /*  96 */
    public final void setLinkTextColor(android.content.res.ColorStateList colors) {
        throw new RuntimeException("Stub!");
    }

    /*  97 */
    public final android.content.res.ColorStateList getLinkTextColors() {
        throw new RuntimeException("Stub!");
    }

    /*  98 */
    public void setGravity(int gravity) {
        throw new RuntimeException("Stub!");
    }

    /*  99 */
    public int getGravity() {
        throw new RuntimeException("Stub!");
    }

    /* 100 */
    public int getPaintFlags() {
        throw new RuntimeException("Stub!");
    }

    /* 101 */
    public void setPaintFlags(int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 102 */
    public void setHorizontallyScrolling(boolean whether) {
        throw new RuntimeException("Stub!");
    }

    /* 103 */
    public void setMinLines(int minlines) {
        throw new RuntimeException("Stub!");
    }

    /* 104 */
    public int getMinLines() {
        throw new RuntimeException("Stub!");
    }

    /* 105 */
    public void setMinHeight(int minHeight) {
        throw new RuntimeException("Stub!");
    }

    /* 106 */
    public int getMinHeight() {
        throw new RuntimeException("Stub!");
    }

    /* 107 */
    public void setMaxLines(int maxlines) {
        throw new RuntimeException("Stub!");
    }

    /* 108 */
    public int getMaxLines() {
        throw new RuntimeException("Stub!");
    }

    /* 109 */
    public void setMaxHeight(int maxHeight) {
        throw new RuntimeException("Stub!");
    }

    /* 110 */
    public int getMaxHeight() {
        throw new RuntimeException("Stub!");
    }

    /* 111 */
    public void setLines(int lines) {
        throw new RuntimeException("Stub!");
    }

    /* 112 */
    public void setHeight(int pixels) {
        throw new RuntimeException("Stub!");
    }

    /* 113 */
    public void setMinEms(int minems) {
        throw new RuntimeException("Stub!");
    }

    /* 114 */
    public int getMinEms() {
        throw new RuntimeException("Stub!");
    }

    /* 115 */
    public void setMinWidth(int minpixels) {
        throw new RuntimeException("Stub!");
    }

    /* 116 */
    public int getMinWidth() {
        throw new RuntimeException("Stub!");
    }

    /* 117 */
    public void setMaxEms(int maxems) {
        throw new RuntimeException("Stub!");
    }

    /* 118 */
    public int getMaxEms() {
        throw new RuntimeException("Stub!");
    }

    /* 119 */
    public void setMaxWidth(int maxpixels) {
        throw new RuntimeException("Stub!");
    }

    /* 120 */
    public int getMaxWidth() {
        throw new RuntimeException("Stub!");
    }

    /* 121 */
    public void setEms(int ems) {
        throw new RuntimeException("Stub!");
    }

    /* 122 */
    public void setWidth(int pixels) {
        throw new RuntimeException("Stub!");
    }

    /* 123 */
    public void setLineSpacing(float add, float mult) {
        throw new RuntimeException("Stub!");
    }

    /* 124 */
    public float getLineSpacingMultiplier() {
        throw new RuntimeException("Stub!");
    }

    /* 125 */
    public float getLineSpacingExtra() {
        throw new RuntimeException("Stub!");
    }

    /* 126 */
    public final void append(CharSequence text) {
        throw new RuntimeException("Stub!");
    }

    /* 127 */
    public void append(CharSequence text, int start, int end) {
        throw new RuntimeException("Stub!");
    }

    /* 128 */
    protected void drawableStateChanged() {
        throw new RuntimeException("Stub!");
    }

    /* 129 */
    public android.os.Parcelable onSaveInstanceState() {
        throw new RuntimeException("Stub!");
    }

    /* 130 */
    public void onRestoreInstanceState(android.os.Parcelable state) {
        throw new RuntimeException("Stub!");
    }

    /* 131 */
    public void setFreezesText(boolean freezesText) {
        throw new RuntimeException("Stub!");
    }

    /* 132 */
    public boolean getFreezesText() {
        throw new RuntimeException("Stub!");
    }

    /* 133 */
    public final void setEditableFactory(android.text.Editable.Factory factory) {
        throw new RuntimeException("Stub!");
    }

    /* 134 */
    public final void setSpannableFactory(android.text.Spannable.Factory factory) {
        throw new RuntimeException("Stub!");
    }

    /* 135 */
    public final void setText(CharSequence text) {
        throw new RuntimeException("Stub!");
    }

    /* 136 */
    public final void setTextKeepState(CharSequence text) {
        throw new RuntimeException("Stub!");
    }

    /* 137 */
    public void setText(CharSequence text, BufferType type) {
        throw new RuntimeException("Stub!");
    }

    /* 138 */
    public final void setText(char[] text, int start, int len) {
        throw new RuntimeException("Stub!");
    }

    /* 139 */
    public final void setTextKeepState(CharSequence text, BufferType type) {
        throw new RuntimeException("Stub!");
    }

    /* 140 */
    public final void setText(int resid) {
        throw new RuntimeException("Stub!");
    }

    /* 141 */
    public final void setText(int resid, BufferType type) {
        throw new RuntimeException("Stub!");
    }

    /* 142 */
    public final void setHint(CharSequence hint) {
        throw new RuntimeException("Stub!");
    }

    /* 143 */
    public final void setHint(int resid) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @android.view.ViewDebug.CapturedViewProperty
/* 145 */ public CharSequence getHint() {
        throw new RuntimeException("Stub!");
    }

    /* 146 */
    public void setInputType(int type) {
        throw new RuntimeException("Stub!");
    }

    /* 147 */
    public void setRawInputType(int type) {
        throw new RuntimeException("Stub!");
    }

    /* 148 */
    public int getInputType() {
        throw new RuntimeException("Stub!");
    }

    /* 149 */
    public void setImeOptions(int imeOptions) {
        throw new RuntimeException("Stub!");
    }

    /* 150 */
    public int getImeOptions() {
        throw new RuntimeException("Stub!");
    }

    /* 151 */
    public void setImeActionLabel(CharSequence label, int actionId) {
        throw new RuntimeException("Stub!");
    }

    /* 152 */
    public CharSequence getImeActionLabel() {
        throw new RuntimeException("Stub!");
    }

    /* 153 */
    public int getImeActionId() {
        throw new RuntimeException("Stub!");
    }

    /* 154 */
    public void setOnEditorActionListener(OnEditorActionListener l) {
        throw new RuntimeException("Stub!");
    }

    /* 155 */
    public void onEditorAction(int actionCode) {
        throw new RuntimeException("Stub!");
    }

    /* 156 */
    public void setPrivateImeOptions(String type) {
        throw new RuntimeException("Stub!");
    }

    /* 157 */
    public String getPrivateImeOptions() {
        throw new RuntimeException("Stub!");
    }

    /* 158 */
    public void setInputExtras(int xmlResId) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /* 159 */
    public android.os.Bundle getInputExtras(boolean create) {
        throw new RuntimeException("Stub!");
    }

    /* 160 */
    public CharSequence getError() {
        throw new RuntimeException("Stub!");
    }

    /* 161 */
    public void setError(CharSequence error) {
        throw new RuntimeException("Stub!");
    }

    /* 162 */
    public void setError(CharSequence error, Drawable icon) {
        throw new RuntimeException("Stub!");
    }

    /* 163 */
    protected boolean setFrame(int l, int t, int r, int b) {
        throw new RuntimeException("Stub!");
    }

    /* 164 */
    public void setFilters(android.text.InputFilter[] filters) {
        throw new RuntimeException("Stub!");
    }

    /* 165 */
    public android.text.InputFilter[] getFilters() {
        throw new RuntimeException("Stub!");
    }

    /* 166 */
    public boolean onPreDraw() {
        throw new RuntimeException("Stub!");
    }

    /* 167 */
    protected void onAttachedToWindow() {
        throw new RuntimeException("Stub!");
    }

    /* 168 */
    protected void onDetachedFromWindow() {
        throw new RuntimeException("Stub!");
    }

    /* 169 */
    public void onScreenStateChanged(int screenState) {
        throw new RuntimeException("Stub!");
    }

    /* 170 */
    protected boolean isPaddingOffsetRequired() {
        throw new RuntimeException("Stub!");
    }

    /* 171 */
    protected int getLeftPaddingOffset() {
        throw new RuntimeException("Stub!");
    }

    /* 172 */
    protected int getTopPaddingOffset() {
        throw new RuntimeException("Stub!");
    }

    /* 173 */
    protected int getBottomPaddingOffset() {
        throw new RuntimeException("Stub!");
    }

    /* 174 */
    protected int getRightPaddingOffset() {
        throw new RuntimeException("Stub!");
    }

    /* 175 */
    protected boolean verifyDrawable(Drawable who) {
        throw new RuntimeException("Stub!");
    }

    /* 176 */
    public void jumpDrawablesToCurrentState() {
        throw new RuntimeException("Stub!");
    }

    /* 177 */
    public void invalidateDrawable(Drawable drawable) {
        throw new RuntimeException("Stub!");
    }

    /* 178 */
    public boolean hasOverlappingRendering() {
        throw new RuntimeException("Stub!");
    }

    /* 179 */
    public boolean isTextSelectable() {
        throw new RuntimeException("Stub!");
    }

    /* 180 */
    public void setTextIsSelectable(boolean selectable) {
        throw new RuntimeException("Stub!");
    }

    /* 181 */
    protected int[] onCreateDrawableState(int extraSpace) {
        throw new RuntimeException("Stub!");
    }

    /* 182 */
    protected void onDraw(android.graphics.Canvas canvas) {
        throw new RuntimeException("Stub!");
    }

    /* 183 */
    public void getFocusedRect(android.graphics.Rect r) {
        throw new RuntimeException("Stub!");
    }

    /* 184 */
    public int getLineCount() {
        throw new RuntimeException("Stub!");
    }

    /* 185 */
    public int getLineBounds(int line, android.graphics.Rect bounds) {
        throw new RuntimeException("Stub!");
    }

    /* 186 */
    public int getBaseline() {
        throw new RuntimeException("Stub!");
    }

    /* 187 */
    public boolean onKeyPreIme(int keyCode, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 188 */
    public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 189 */
    public boolean onKeyMultiple(int keyCode, int repeatCount, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 190 */
    public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 191 */
    public boolean onCheckIsTextEditor() {
        throw new RuntimeException("Stub!");
    }

    /* 192 */
    public android.view.inputmethod.InputConnection onCreateInputConnection(android.view.inputmethod.EditorInfo outAttrs) {
        throw new RuntimeException("Stub!");
    }

    /* 193 */
    public boolean extractText(android.view.inputmethod.ExtractedTextRequest request, android.view.inputmethod.ExtractedText outText) {
        throw new RuntimeException("Stub!");
    }

    /* 194 */
    public void setExtractedText(android.view.inputmethod.ExtractedText text) {
        throw new RuntimeException("Stub!");
    }

    /* 195 */
    public void onCommitCompletion(android.view.inputmethod.CompletionInfo text) {
        throw new RuntimeException("Stub!");
    }

    /* 196 */
    public void onCommitCorrection(android.view.inputmethod.CorrectionInfo info) {
        throw new RuntimeException("Stub!");
    }

    /* 197 */
    public void beginBatchEdit() {
        throw new RuntimeException("Stub!");
    }

    /* 198 */
    public void endBatchEdit() {
        throw new RuntimeException("Stub!");
    }

    /* 199 */
    public void onBeginBatchEdit() {
        throw new RuntimeException("Stub!");
    }

    /* 200 */
    public void onEndBatchEdit() {
        throw new RuntimeException("Stub!");
    }

    /* 201 */
    public boolean onPrivateIMECommand(String action, android.os.Bundle data) {
        throw new RuntimeException("Stub!");
    }

    /* 202 */
    public void setIncludeFontPadding(boolean includepad) {
        throw new RuntimeException("Stub!");
    }

    /* 203 */
    public boolean getIncludeFontPadding() {
        throw new RuntimeException("Stub!");
    }

    /* 204 */
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        throw new RuntimeException("Stub!");
    }

    /* 205 */
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        throw new RuntimeException("Stub!");
    }

    /* 206 */
    public boolean bringPointIntoView(int offset) {
        throw new RuntimeException("Stub!");
    }

    /* 207 */
    public boolean moveCursorToVisibleOffset() {
        throw new RuntimeException("Stub!");
    }

    /* 208 */
    public void computeScroll() {
        throw new RuntimeException("Stub!");
    }

    /* 209 */
    public void debug(int depth) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @android.view.ViewDebug.ExportedProperty(category = "text")
/* 211 */ public int getSelectionStart() {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @android.view.ViewDebug.ExportedProperty(category = "text")
/* 213 */ public int getSelectionEnd() {
        throw new RuntimeException("Stub!");
    }

    /* 214 */
    public boolean hasSelection() {
        throw new RuntimeException("Stub!");
    }

    /* 215 */
    public void setSingleLine() {
        throw new RuntimeException("Stub!");
    }

    /* 216 */
    public void setAllCaps(boolean allCaps) {
        throw new RuntimeException("Stub!");
    }

    /* 217 */
    public void setSingleLine(boolean singleLine) {
        throw new RuntimeException("Stub!");
    }

    /* 218 */
    public void setEllipsize(android.text.TextUtils.TruncateAt where) {
        throw new RuntimeException("Stub!");
    }

    /* 219 */
    public void setMarqueeRepeatLimit(int marqueeLimit) {
        throw new RuntimeException("Stub!");
    }

    /* 220 */
    public int getMarqueeRepeatLimit() {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @android.view.ViewDebug.ExportedProperty
/* 222 */ public android.text.TextUtils.TruncateAt getEllipsize() {
        throw new RuntimeException("Stub!");
    }

    /* 223 */
    public void setSelectAllOnFocus(boolean selectAllOnFocus) {
        throw new RuntimeException("Stub!");
    }

    /* 224 */
    public void setCursorVisible(boolean visible) {
        throw new RuntimeException("Stub!");
    }

    /* 225 */
    public boolean isCursorVisible() {
        throw new RuntimeException("Stub!");
    }

    /* 226 */
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        throw new RuntimeException("Stub!");
    }

    /* 227 */
    protected void onSelectionChanged(int selStart, int selEnd) {
        throw new RuntimeException("Stub!");
    }

    /* 228 */
    public void addTextChangedListener(android.text.TextWatcher watcher) {
        throw new RuntimeException("Stub!");
    }

    /* 229 */
    public void removeTextChangedListener(android.text.TextWatcher watcher) {
        throw new RuntimeException("Stub!");
    }

    /* 230 */
    public void onStartTemporaryDetach() {
        throw new RuntimeException("Stub!");
    }

    /* 231 */
    public void onFinishTemporaryDetach() {
        throw new RuntimeException("Stub!");
    }

    /* 232 */
    protected void onFocusChanged(boolean focused, int direction, android.graphics.Rect previouslyFocusedRect) {
        throw new RuntimeException("Stub!");
    }

    /* 233 */
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        throw new RuntimeException("Stub!");
    }

    /* 234 */
    protected void onVisibilityChanged(android.view.View changedView, int visibility) {
        throw new RuntimeException("Stub!");
    }

    /* 235 */
    public void clearComposingText() {
        throw new RuntimeException("Stub!");
    }

    /* 236 */
    public void setSelected(boolean selected) {
        throw new RuntimeException("Stub!");
    }

    /* 237 */
    public boolean onTouchEvent(android.view.MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 238 */
    public boolean onGenericMotionEvent(android.view.MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 239 */
    public boolean didTouchFocusSelect() {
        throw new RuntimeException("Stub!");
    }

    /* 240 */
    public void cancelLongPress() {
        throw new RuntimeException("Stub!");
    }

    /* 241 */
    public boolean onTrackballEvent(android.view.MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 242 */
    public void setScroller(Scroller s) {
        throw new RuntimeException("Stub!");
    }

    /* 243 */
    protected float getLeftFadingEdgeStrength() {
        throw new RuntimeException("Stub!");
    }

    /* 244 */
    protected float getRightFadingEdgeStrength() {
        throw new RuntimeException("Stub!");
    }

    /* 245 */
    protected int computeHorizontalScrollRange() {
        throw new RuntimeException("Stub!");
    }

    /* 246 */
    protected int computeVerticalScrollRange() {
        throw new RuntimeException("Stub!");
    }

    /* 247 */
    protected int computeVerticalScrollExtent() {
        throw new RuntimeException("Stub!");
    }

    /* 248 */
    public void findViewsWithText(java.util.ArrayList<android.view.View> outViews, CharSequence searched, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 249 */
    public static android.content.res.ColorStateList getTextColors(android.content.Context context, android.content.res.TypedArray attrs) {
        throw new RuntimeException("Stub!");
    }

    /* 250 */
    public static int getTextColor(android.content.Context context, android.content.res.TypedArray attrs, int def) {
        throw new RuntimeException("Stub!");
    }

    /* 251 */
    public boolean onKeyShortcut(int keyCode, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 252 */
    public void onPopulateAccessibilityEvent(android.view.accessibility.AccessibilityEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 253 */
    public void onInitializeAccessibilityEvent(android.view.accessibility.AccessibilityEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 254 */
    public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo info) {
        throw new RuntimeException("Stub!");
    }

    /* 255 */
    public void sendAccessibilityEvent(int eventType) {
        throw new RuntimeException("Stub!");
    }

    /* 256 */
    public boolean isInputMethodTarget() {
        throw new RuntimeException("Stub!");
    }

    /* 257 */
    public boolean onTextContextMenuItem(int id) {
        throw new RuntimeException("Stub!");
    }

    /* 258 */
    public boolean performLongClick() {
        throw new RuntimeException("Stub!");
    }

    /* 259 */
    protected void onScrollChanged(int horiz, int vert, int oldHoriz, int oldVert) {
        throw new RuntimeException("Stub!");
    }

    /* 260 */
    public boolean isSuggestionsEnabled() {
        throw new RuntimeException("Stub!");
    }

    /* 261 */
    public void setCustomSelectionActionModeCallback(android.view.ActionMode.Callback actionModeCallback) {
        throw new RuntimeException("Stub!");
    }

    /* 262 */
    public android.view.ActionMode.Callback getCustomSelectionActionModeCallback() {
        throw new RuntimeException("Stub!");
    }

    /* 263 */
    public int getOffsetForPosition(float x, float y) {
        throw new RuntimeException("Stub!");
    }

    /* 264 */
    public boolean onDragEvent(android.view.DragEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 265 */
    protected void resolveDrawables() {
        throw new RuntimeException("Stub!");
    }

    /* 266 */
    protected void resetResolvedDrawables() {
        throw new RuntimeException("Stub!");
    }
/*     */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/widget/TextView.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */