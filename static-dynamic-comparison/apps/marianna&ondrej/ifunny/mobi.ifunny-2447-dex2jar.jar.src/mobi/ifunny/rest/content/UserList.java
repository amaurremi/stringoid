package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class UserList
        extends PagingList<User> {
    public static final Parcelable.Creator<UserList> CREATOR = new UserList
    .1();

    public UserList() {
    }

    public UserList(Parcel paramParcel) {
        super(paramParcel);
    }

    public Parcelable.Creator<User> getListParcelCreator() {
        return User.CREATOR;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/UserList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */