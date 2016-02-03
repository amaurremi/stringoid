/*    */
package android.widget;
/*    */ 
/*    */

import android.app.SearchableInfo;
/*    */ import android.content.Context;
/*    */ import android.util.AttributeSet;
/*    */ import android.view.CollapsibleActionView;
/*    */ import android.view.KeyEvent;
/*    */ import android.view.View.OnClickListener;
/*    */ import android.view.View.OnFocusChangeListener;
/*    */ import android.view.accessibility.AccessibilityEvent;
/*    */ import android.view.accessibility.AccessibilityNodeInfo;

/*    */
/*    */ 
/*    */ public class SearchView
/*    */ extends LinearLayout
/*    */ implements CollapsibleActionView
/*    */ {
    /*    */
    public SearchView(Context context)
/*    */ {
/* 20 */
        super((Context) null, (AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public SearchView(Context context, AttributeSet attrs) {
        super((Context) null, (AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public void setSearchableInfo(SearchableInfo searchable) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public void setImeOptions(int imeOptions) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public int getImeOptions() {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public void setInputType(int inputType) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public int getInputType() {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public void setOnQueryTextListener(OnQueryTextListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public void setOnCloseListener(OnCloseListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public void setOnSuggestionListener(OnSuggestionListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public void setOnSearchClickListener(View.OnClickListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public CharSequence getQuery() {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public void setQuery(CharSequence query, boolean submit) {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public void setQueryHint(CharSequence hint) {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public CharSequence getQueryHint() {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public void setIconifiedByDefault(boolean iconified) {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public boolean isIconfiedByDefault() {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    public void setIconified(boolean iconify) {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    public boolean isIconified() {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    public void setSubmitButtonEnabled(boolean enabled) {
        throw new RuntimeException("Stub!");
    }

    /* 41 */
    public boolean isSubmitButtonEnabled() {
        throw new RuntimeException("Stub!");
    }

    /* 42 */
    public void setQueryRefinementEnabled(boolean enable) {
        throw new RuntimeException("Stub!");
    }

    /* 43 */
    public boolean isQueryRefinementEnabled() {
        throw new RuntimeException("Stub!");
    }

    /* 44 */
    public void setSuggestionsAdapter(CursorAdapter adapter) {
        throw new RuntimeException("Stub!");
    }

    /* 45 */
    public CursorAdapter getSuggestionsAdapter() {
        throw new RuntimeException("Stub!");
    }

    /* 46 */
    public void setMaxWidth(int maxpixels) {
        throw new RuntimeException("Stub!");
    }

    /* 47 */
    public int getMaxWidth() {
        throw new RuntimeException("Stub!");
    }

    /* 48 */
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        throw new RuntimeException("Stub!");
    }

    /* 49 */
    protected void onDetachedFromWindow() {
        throw new RuntimeException("Stub!");
    }

    /* 50 */
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 51 */
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        throw new RuntimeException("Stub!");
    }

    /* 52 */
    public void onActionViewCollapsed() {
        throw new RuntimeException("Stub!");
    }

    /* 53 */
    public void onActionViewExpanded() {
        throw new RuntimeException("Stub!");
    }

    /* 54 */
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 55 */
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface OnSuggestionListener
/*    */ {
        /*    */
        public abstract boolean onSuggestionSelect(int paramInt);

        /*    */
/*    */
        public abstract boolean onSuggestionClick(int paramInt);
/*    */
    }

    /*    */
/*    */   public static abstract interface OnCloseListener
/*    */ {
        /*    */
        public abstract boolean onClose();
/*    */
    }

    /*    */
/*    */   public static abstract interface OnQueryTextListener
/*    */ {
        /*    */
        public abstract boolean onQueryTextSubmit(String paramString);

        /*    */
/*    */
        public abstract boolean onQueryTextChange(String paramString);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/widget/SearchView.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */