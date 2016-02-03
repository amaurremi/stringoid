package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class YoutubeVideo$1
        implements Parcelable.Creator<YoutubeVideo> {
    public YoutubeVideo createFromParcel(Parcel paramParcel) {
        return new YoutubeVideo(paramParcel, null);
    }

    public YoutubeVideo[] newArray(int paramInt) {
        return new YoutubeVideo[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/YoutubeVideo$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */