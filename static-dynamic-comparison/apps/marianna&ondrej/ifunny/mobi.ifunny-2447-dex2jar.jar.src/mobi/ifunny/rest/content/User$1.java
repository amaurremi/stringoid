package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class User$1
        implements Parcelable.Creator<User> {
    public User createFromParcel(Parcel paramParcel) {
        return new User(paramParcel);
    }

    public User[] newArray(int paramInt) {
        return new User[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/User$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */