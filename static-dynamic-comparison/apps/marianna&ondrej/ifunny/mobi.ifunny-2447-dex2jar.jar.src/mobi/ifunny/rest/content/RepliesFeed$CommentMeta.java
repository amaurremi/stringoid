package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class RepliesFeed$CommentMeta
        implements Parcelable {
    public static final Parcelable.Creator<CommentMeta> CREATOR = new RepliesFeed.CommentMeta
    .1();
    public int replies_count;

    public RepliesFeed$CommentMeta() {
    }

    public RepliesFeed$CommentMeta(Parcel paramParcel) {
        this();
        readFromParcel(paramParcel);
    }

    public int describeContents() {
        return 0;
    }

    public void readFromParcel(Parcel paramParcel) {
        this.replies_count = paramParcel.readInt();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeInt(this.replies_count);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/RepliesFeed$CommentMeta.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */