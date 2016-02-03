package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class UserStat$1
        implements Parcelable.Creator<UserStat> {
    public UserStat createFromParcel(Parcel paramParcel) {
        return new UserStat(paramParcel);
    }

    public UserStat[] newArray(int paramInt) {
        return new UserStat[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/UserStat$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */