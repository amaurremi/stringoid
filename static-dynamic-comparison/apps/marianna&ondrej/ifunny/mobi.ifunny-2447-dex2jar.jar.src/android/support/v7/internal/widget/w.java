package android.support.v7.internal.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

class w
        implements AdapterView.OnItemSelectedListener {
    w(u paramu) {
    }

    public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
        if (paramInt != -1) {
            paramAdapterView = u.a(this.a);
            if (paramAdapterView != null) {
                x.a(paramAdapterView, false);
            }
        }
    }

    public void onNothingSelected(AdapterView<?> paramAdapterView) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/internal/widget/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */