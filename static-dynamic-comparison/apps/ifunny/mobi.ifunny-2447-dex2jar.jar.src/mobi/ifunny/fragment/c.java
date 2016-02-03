package mobi.ifunny.fragment;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class c
        implements Parcelable.Creator<FragmentPage.ActivityResultMeta> {
    public FragmentPage.ActivityResultMeta a(Parcel paramParcel) {
        return new FragmentPage.ActivityResultMeta(paramParcel);
    }

    public FragmentPage.ActivityResultMeta[] a(int paramInt) {
        return new FragmentPage.ActivityResultMeta[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/fragment/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */