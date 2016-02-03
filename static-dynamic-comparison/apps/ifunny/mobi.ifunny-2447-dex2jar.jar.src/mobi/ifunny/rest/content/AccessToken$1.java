package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class AccessToken$1
        implements Parcelable.Creator<AccessToken> {
    public AccessToken createFromParcel(Parcel paramParcel) {
        return new AccessToken(paramParcel, null);
    }

    public AccessToken[] newArray(int paramInt) {
        return new AccessToken[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/AccessToken$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */