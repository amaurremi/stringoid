package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class YoutubeVideo$YoutubeThumbnail
        implements Parcelable {
    public static final Parcelable.Creator<YoutubeThumbnail> CREATOR = new YoutubeVideo.YoutubeThumbnail
    .1();
    private String hqDefault;
    private String sqDefault;

    private YoutubeVideo$YoutubeThumbnail(Parcel paramParcel) {
        this.sqDefault = paramParcel.readString();
        this.hqDefault = paramParcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public String getBestQuality() {
        if (this.hqDefault == null) {
            return this.sqDefault;
        }
        return this.hqDefault;
    }

    public String getHqDefault() {
        return this.hqDefault;
    }

    public String getSqDefault() {
        return this.sqDefault;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeString(this.sqDefault);
        paramParcel.writeString(this.hqDefault);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/YoutubeVideo$YoutubeThumbnail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */