package android.support.v7.internal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.View;
import android.widget.LinearLayout;

public class NativeActionModeAwareLayout
        extends LinearLayout {
    private OnActionModeForChildListener mActionModeForChildListener;

    public NativeActionModeAwareLayout(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public void setActionModeForChildListener(OnActionModeForChildListener paramOnActionModeForChildListener) {
        this.mActionModeForChildListener = paramOnActionModeForChildListener;
    }

    public ActionMode startActionModeForChild(View paramView, ActionMode.Callback paramCallback) {
        ActionMode.Callback localCallback = paramCallback;
        if (this.mActionModeForChildListener != null) {
            localCallback = this.mActionModeForChildListener.onActionModeForChild(paramCallback);
        }
        return super.startActionModeForChild(paramView, localCallback);
    }

    public static abstract interface OnActionModeForChildListener {
        public abstract ActionMode.Callback onActionModeForChild(ActionMode.Callback paramCallback);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/android/support/v7/internal/widget/NativeActionModeAwareLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */