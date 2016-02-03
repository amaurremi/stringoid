package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AccessToken
        implements Parcelable {
    public static final Parcelable.Creator<AccessToken> CREATOR = new AccessToken
    .1();
    public String access_token;
    public long expires_in;
    public String token_type;

    public AccessToken() {
    }

    private AccessToken(Parcel paramParcel) {
        this.access_token = paramParcel.readString();
        this.token_type = paramParcel.readString();
        this.expires_in = paramParcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeString(this.access_token);
        paramParcel.writeString(this.token_type);
        paramParcel.writeLong(this.expires_in);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/AccessToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */