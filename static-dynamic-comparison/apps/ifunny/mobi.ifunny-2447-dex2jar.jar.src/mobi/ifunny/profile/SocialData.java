package mobi.ifunny.profile;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class SocialData
        implements Parcelable {
    public static final Parcelable.Creator<SocialData> CREATOR = new j();
    public static String a;
    public static String b;
    private static final String c = SocialData.class.getSimpleName();
    private String d;
    private String e;
    private String f;
    private long g;
    private String h;
    private String i;
    private String j;

    static {
        a = "01/01/90";
        b = "male";
    }

    public SocialData() {
    }

    private SocialData(Parcel paramParcel) {
        this.d = paramParcel.readString();
        this.e = paramParcel.readString();
        this.f = paramParcel.readString();
        this.g = paramParcel.readLong();
        this.h = paramParcel.readString();
        this.i = paramParcel.readString();
        this.j = paramParcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeString(this.d);
        paramParcel.writeString(this.e);
        paramParcel.writeString(this.f);
        paramParcel.writeLong(this.g);
        paramParcel.writeString(this.h);
        paramParcel.writeString(this.i);
        paramParcel.writeString(this.j);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/profile/SocialData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */