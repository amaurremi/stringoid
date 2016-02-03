package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class UserPhoto$1
        implements Parcelable.Creator<UserPhoto> {
    public UserPhoto createFromParcel(Parcel paramParcel) {
        return new UserPhoto(paramParcel);
    }

    public UserPhoto[] newArray(int paramInt) {
        return new UserPhoto[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/UserPhoto$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */