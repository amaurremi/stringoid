package android.support.v7.internal.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class k
        implements Parcelable.Creator<ActionBarView.SavedState> {
    public ActionBarView.SavedState a(Parcel paramParcel) {
        return new ActionBarView.SavedState(paramParcel, null);
    }

    public ActionBarView.SavedState[] a(int paramInt) {
        return new ActionBarView.SavedState[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/internal/widget/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */