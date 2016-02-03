package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class UserPhoto
        implements Parcelable {
    public static final Parcelable.Creator<UserPhoto> CREATOR = new UserPhoto
    .1();
    public String bg_color;
    public String thumb_large_url;
    public String thumb_small_url;
    public String url;

    public UserPhoto() {
    }

    public UserPhoto(Parcel paramParcel) {
        this();
        readFromParcel(paramParcel);
    }

    public int describeContents() {
        return 0;
    }

    public void readFromParcel(Parcel paramParcel) {
        this.url = paramParcel.readString();
        this.thumb_small_url = paramParcel.readString();
        this.thumb_large_url = paramParcel.readString();
        this.bg_color = paramParcel.readString();
    }

    public String toString() {
        return "UserPhoto{url='" + this.url + '\'' + ", thumb_small_url='" + this.thumb_small_url + '\'' + ", thumb_large_url='" + this.thumb_large_url + '\'' + ", bg_color='" + this.bg_color + '\'' + '}';
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeString(this.url);
        paramParcel.writeString(this.thumb_small_url);
        paramParcel.writeString(this.thumb_large_url);
        paramParcel.writeString(this.bg_color);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/UserPhoto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */