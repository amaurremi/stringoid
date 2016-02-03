package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class UserSocial
        implements Parcelable {
    public static final Parcelable.Creator<UserSocial> CREATOR = new UserSocial
    .1();
    public String id;
    public boolean is_hidden;
    public String nick;

    public UserSocial() {
    }

    public UserSocial(Parcel paramParcel) {
        this.id = paramParcel.readString();
        this.nick = paramParcel.readString();
        if (paramParcel.readByte() != 0) {
        }
        for (boolean bool = true; ; bool = false) {
            this.is_hidden = bool;
            return;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeString(this.id);
        paramParcel.writeString(this.nick);
        if (this.is_hidden) {
        }
        for (paramInt = 1; ; paramInt = 0) {
            paramParcel.writeByte((byte) paramInt);
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/UserSocial.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */