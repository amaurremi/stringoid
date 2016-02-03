/*    */
package android.widget;
/*    */ 
/*    */

import android.content.Context;
/*    */ import android.util.AttributeSet;
/*    */ import android.view.KeyEvent;

/*    */
/*    */ public class AutoCompleteTextView extends EditText implements Filter.FilterListener
/*    */ {
    /*    */
    public AutoCompleteTextView(Context context)
/*    */ {
/* 11 */
        super((Context) null, (AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public AutoCompleteTextView(Context context, AttributeSet attrs) {
        super((Context) null, (AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public AutoCompleteTextView(Context context, AttributeSet attrs, int defStyle) {
        super((Context) null, (AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void setOnClickListener(android.view.View.OnClickListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public void setCompletionHint(CharSequence hint) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public CharSequence getCompletionHint() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public int getDropDownWidth() {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void setDropDownWidth(int width) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public int getDropDownHeight() {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public void setDropDownHeight(int height) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public int getDropDownAnchor() {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public void setDropDownAnchor(int id) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public android.graphics.drawable.Drawable getDropDownBackground() {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public void setDropDownBackgroundDrawable(android.graphics.drawable.Drawable d) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public void setDropDownBackgroundResource(int id) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public void setDropDownVerticalOffset(int offset) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public int getDropDownVerticalOffset() {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public void setDropDownHorizontalOffset(int offset) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public int getDropDownHorizontalOffset() {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public int getThreshold() {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public void setThreshold(int threshold) {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public void setOnItemClickListener(AdapterView.OnItemClickListener l) {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener l) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 35 */ public AdapterView.OnItemClickListener getItemClickListener() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 37 */ public AdapterView.OnItemSelectedListener getItemSelectedListener() {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    public AdapterView.OnItemClickListener getOnItemClickListener() {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    public AdapterView.OnItemSelectedListener getOnItemSelectedListener() {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    public ListAdapter getAdapter() {
        throw new RuntimeException("Stub!");
    }
/* 41 */   public <T extends ListAdapter,extends Filterable>

    void setAdapter(T adapter) {
        throw new RuntimeException("Stub!");
    }

    /* 42 */
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 43 */
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 44 */
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 45 */
    public boolean enoughToFilter() {
        throw new RuntimeException("Stub!");
    }

    /* 46 */
    public boolean isPopupShowing() {
        throw new RuntimeException("Stub!");
    }

    /* 47 */
    protected CharSequence convertSelectionToString(Object selectedItem) {
        throw new RuntimeException("Stub!");
    }

    /* 48 */
    public void clearListSelection() {
        throw new RuntimeException("Stub!");
    }

    /* 49 */
    public void setListSelection(int position) {
        throw new RuntimeException("Stub!");
    }

    /* 50 */
    public int getListSelection() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/* 52 */
    protected void performFiltering(CharSequence text, int keyCode) {
        throw new RuntimeException("Stub!");
    }

    /* 53 */
    public void performCompletion() {
        throw new RuntimeException("Stub!");
    }

    /* 54 */
    public void onCommitCompletion(android.view.inputmethod.CompletionInfo completion) {
        throw new RuntimeException("Stub!");
    }

    /* 55 */
    public boolean isPerformingCompletion() {
        throw new RuntimeException("Stub!");
    }

    /* 56 */
    protected void replaceText(CharSequence text) {
        throw new RuntimeException("Stub!");
    }

    /* 57 */
    public void onFilterComplete(int count) {
        throw new RuntimeException("Stub!");
    }

    /* 58 */
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        throw new RuntimeException("Stub!");
    }

    /* 59 */
    protected void onDisplayHint(int hint) {
        throw new RuntimeException("Stub!");
    }

    /* 60 */
    protected void onFocusChanged(boolean focused, int direction, android.graphics.Rect previouslyFocusedRect) {
        throw new RuntimeException("Stub!");
    }

    /* 61 */
    protected void onAttachedToWindow() {
        throw new RuntimeException("Stub!");
    }

    /* 62 */
    protected void onDetachedFromWindow() {
        throw new RuntimeException("Stub!");
    }

    /* 63 */
    public void dismissDropDown() {
        throw new RuntimeException("Stub!");
    }

    /* 64 */
    protected boolean setFrame(int l, int t, int r, int b) {
        throw new RuntimeException("Stub!");
    }

    /* 65 */
    public void showDropDown() {
        throw new RuntimeException("Stub!");
    }

    /* 66 */
    public void setValidator(Validator validator) {
        throw new RuntimeException("Stub!");
    }

    /* 67 */
    public Validator getValidator() {
        throw new RuntimeException("Stub!");
    }

    /* 68 */
    public void performValidation() {
        throw new RuntimeException("Stub!");
    }

    /* 69 */
    protected Filter getFilter() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface Validator
/*    */ {
        /*    */
        public abstract boolean isValid(CharSequence paramCharSequence);

        /*    */
/*    */
        public abstract CharSequence fixText(CharSequence paramCharSequence);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/widget/AutoCompleteTextView.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */