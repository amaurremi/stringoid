package mobi.ifunny.social.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AuthHelper$AuthInfo
        implements Parcelable, Cloneable {
    public static final Parcelable.Creator<AuthInfo> CREATOR = new j();
    public String a;
    public String b;
    public String c;

    public AuthHelper$AuthInfo() {
    }

    public AuthHelper$AuthInfo(Parcel paramParcel) {
        this.a = paramParcel.readString();
        this.b = paramParcel.readString();
        this.c = paramParcel.readString();
    }

    protected AuthInfo a() {
        AuthInfo localAuthInfo = (AuthInfo) super.clone();
        localAuthInfo.a = this.a;
        localAuthInfo.b = this.b;
        localAuthInfo.c = this.c;
        return localAuthInfo;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeString(this.a);
        paramParcel.writeString(this.b);
        paramParcel.writeString(this.c);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/AuthHelper$AuthInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */