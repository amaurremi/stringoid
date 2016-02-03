package mobi.ifunny.profile;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class j
        implements Parcelable.Creator<SocialData> {
    public SocialData a(Parcel paramParcel) {
        return new SocialData(paramParcel, null);
    }

    public SocialData[] a(int paramInt) {
        return new SocialData[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/profile/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */