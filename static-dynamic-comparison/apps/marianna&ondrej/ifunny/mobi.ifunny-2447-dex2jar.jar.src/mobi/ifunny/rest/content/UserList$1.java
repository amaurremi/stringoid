package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class UserList$1
        implements Parcelable.Creator<UserList> {
    public UserList createFromParcel(Parcel paramParcel) {
        return new UserList(paramParcel);
    }

    public UserList[] newArray(int paramInt) {
        return new UserList[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/UserList$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */