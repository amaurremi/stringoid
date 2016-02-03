package android.support.v7.internal.view.menu;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class i
        implements Parcelable.Creator<ActionMenuPresenter.SavedState> {
    public ActionMenuPresenter.SavedState a(Parcel paramParcel) {
        return new ActionMenuPresenter.SavedState(paramParcel);
    }

    public ActionMenuPresenter.SavedState[] a(int paramInt) {
        return new ActionMenuPresenter.SavedState[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/internal/view/menu/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */