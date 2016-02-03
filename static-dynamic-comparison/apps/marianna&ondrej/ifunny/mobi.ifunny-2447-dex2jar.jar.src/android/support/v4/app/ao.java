package android.support.v4.app;

import android.content.Context;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

class ao
        extends FrameLayout {
    public ao(Context paramContext) {
        super(paramContext);
    }

    static ViewGroup a(View paramView) {
        ao localao = new ao(paramView.getContext());
        ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
        if (localLayoutParams != null) {
            localao.setLayoutParams(localLayoutParams);
        }
        paramView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        localao.addView(paramView);
        return localao;
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray) {
        dispatchThawSelfOnly(paramSparseArray);
    }

    protected void dispatchSaveInstanceState(SparseArray<Parcelable> paramSparseArray) {
        dispatchFreezeSelfOnly(paramSparseArray);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/app/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */