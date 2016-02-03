package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class YoutubeVideo
        implements Parcelable {
    public static final Parcelable.Creator<YoutubeVideo> CREATOR = new YoutubeVideo
    .1();
    private int duration;
    private String id;
    private long likeCount;
    private YoutubeVideo.YoutubePlayer player;
    private float rating;
    private long ratingCount;
    private YoutubeVideo.YoutubeThumbnail thumbnail;
    private String title;
    private String uploader;
    private long viewCount;

    private YoutubeVideo(Parcel paramParcel) {
        this.id = paramParcel.readString();
        this.title = paramParcel.readString();
        this.uploader = paramParcel.readString();
        this.thumbnail = ((YoutubeVideo.YoutubeThumbnail) paramParcel.readParcelable(YoutubeVideo.YoutubeThumbnail.class.getClassLoader()));
        this.player = ((YoutubeVideo.YoutubePlayer) paramParcel.readParcelable(YoutubeVideo.YoutubePlayer.class.getClassLoader()));
        this.duration = paramParcel.readInt();
        this.rating = paramParcel.readFloat();
        this.likeCount = paramParcel.readLong();
        this.ratingCount = paramParcel.readLong();
        this.viewCount = paramParcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public int getDuration() {
        return this.duration;
    }

    public String getId() {
        return this.id;
    }

    public long getLikeCount() {
        return this.likeCount;
    }

    public YoutubeVideo.YoutubePlayer getPlayer() {
        return this.player;
    }

    public float getRating() {
        return this.rating;
    }

    public long getRatingCount() {
        return this.ratingCount;
    }

    public YoutubeVideo.YoutubeThumbnail getThumbnail() {
        return this.thumbnail;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUploader() {
        return this.uploader;
    }

    public long getViewCount() {
        return this.viewCount;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeString(this.id);
        paramParcel.writeString(this.title);
        paramParcel.writeString(this.uploader);
        paramParcel.writeParcelable(this.thumbnail, paramInt);
        paramParcel.writeParcelable(this.player, paramInt);
        paramParcel.writeInt(this.duration);
        paramParcel.writeFloat(this.rating);
        paramParcel.writeLong(this.likeCount);
        paramParcel.writeLong(this.ratingCount);
        paramParcel.writeLong(this.viewCount);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/YoutubeVideo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */