package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class UserSocials
        implements Parcelable {
    public static final Parcelable.Creator<UserSocials> CREATOR = new UserSocials
    .1();
    public UserSocial fb;
    public UserSocial gplus;
    public UserSocial tw;
    public UserSocial vk;

    public UserSocials() {
    }

    public UserSocials(Parcel paramParcel) {
        this.fb = ((UserSocial) paramParcel.readParcelable(UserSocial.class.getClassLoader()));
        this.gplus = ((UserSocial) paramParcel.readParcelable(UserSocial.class.getClassLoader()));
        this.tw = ((UserSocial) paramParcel.readParcelable(UserSocial.class.getClassLoader()));
        this.vk = ((UserSocial) paramParcel.readParcelable(UserSocial.class.getClassLoader()));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeParcelable(this.fb, paramInt);
        paramParcel.writeParcelable(this.gplus, paramInt);
        paramParcel.writeParcelable(this.tw, paramInt);
        paramParcel.writeParcelable(this.vk, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/UserSocials.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */