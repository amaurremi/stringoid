package android.support.v7.internal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.View;
import android.widget.LinearLayout;

public class NativeActionModeAwareLayout
        extends LinearLayout {
    private ad a;

    public NativeActionModeAwareLayout(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public void setActionModeForChildListener(ad paramad) {
        this.a = paramad;
    }

    public ActionMode startActionModeForChild(View paramView, ActionMode.Callback paramCallback) {
        ActionMode.Callback localCallback = paramCallback;
        if (this.a != null) {
            localCallback = this.a.a(paramCallback);
        }
        return super.startActionModeForChild(paramView, localCallback);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/internal/widget/NativeActionModeAwareLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */