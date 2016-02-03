package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class YoutubeVideo$YoutubePlayer
        implements Parcelable {
    public static final Parcelable.Creator<YoutubePlayer> CREATOR = new YoutubeVideo.YoutubePlayer
    .1();
    private String mobile;

    private YoutubeVideo$YoutubePlayer(Parcel paramParcel) {
        this.mobile = paramParcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeString(this.mobile);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/YoutubeVideo$YoutubePlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */