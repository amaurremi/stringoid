package mobi.ifunny.social.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class j
        implements Parcelable.Creator<AuthHelper.AuthInfo> {
    public AuthHelper.AuthInfo a(Parcel paramParcel) {
        return new AuthHelper.AuthInfo(paramParcel);
    }

    public AuthHelper.AuthInfo[] a(int paramInt) {
        return new AuthHelper.AuthInfo[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */