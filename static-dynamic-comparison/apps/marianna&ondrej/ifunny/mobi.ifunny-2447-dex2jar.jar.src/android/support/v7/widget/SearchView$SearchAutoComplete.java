package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;

public class SearchView$SearchAutoComplete
        extends AutoCompleteTextView {
    private int a = getThreshold();
    private SearchView b;

    public SearchView$SearchAutoComplete(Context paramContext) {
        super(paramContext);
    }

    public SearchView$SearchAutoComplete(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public SearchView$SearchAutoComplete(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
    }

    private boolean a() {
        return TextUtils.getTrimmedLength(getText()) == 0;
    }

    public boolean enoughToFilter() {
        return (this.a <= 0) || (super.enoughToFilter());
    }

    protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect) {
        super.onFocusChanged(paramBoolean, paramInt, paramRect);
        this.b.onTextFocusChanged();
    }

    public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent) {
        if (paramInt == 4) {
            KeyEvent.DispatcherState localDispatcherState;
            if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0)) {
                localDispatcherState = getKeyDispatcherState();
                if (localDispatcherState != null) {
                    localDispatcherState.startTracking(paramKeyEvent, this);
                }
                return true;
            }
            if (paramKeyEvent.getAction() == 1) {
                localDispatcherState = getKeyDispatcherState();
                if (localDispatcherState != null) {
                    localDispatcherState.handleUpEvent(paramKeyEvent);
                }
                if ((paramKeyEvent.isTracking()) && (!paramKeyEvent.isCanceled())) {
                    this.b.clearFocus();
                    SearchView.access$2100(this.b, false);
                    return true;
                }
            }
        }
        return super.onKeyPreIme(paramInt, paramKeyEvent);
    }

    public void onWindowFocusChanged(boolean paramBoolean) {
        super.onWindowFocusChanged(paramBoolean);
        if ((paramBoolean) && (this.b.hasFocus()) && (getVisibility() == 0)) {
            ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
            if (SearchView.isLandscapeMode(getContext())) {
                SearchView.HIDDEN_METHOD_INVOKER.a(this, true);
            }
        }
    }

    public void performCompletion() {
    }

    protected void replaceText(CharSequence paramCharSequence) {
    }

    void setSearchView(SearchView paramSearchView) {
        this.b = paramSearchView;
    }

    public void setThreshold(int paramInt) {
        super.setThreshold(paramInt);
        this.a = paramInt;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/widget/SearchView$SearchAutoComplete.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */