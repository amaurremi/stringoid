package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CommentsFeedImpl$Content
        implements Parcelable {
    public static final Parcelable.Creator<Content> CREATOR = new CommentsFeedImpl.Content
    .1();
    public int comments_count;

    public CommentsFeedImpl$Content() {
    }

    public CommentsFeedImpl$Content(Parcel paramParcel) {
        this();
        readFromParcel(paramParcel);
    }

    public int describeContents() {
        return 0;
    }

    public void readFromParcel(Parcel paramParcel) {
        this.comments_count = paramParcel.readInt();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeInt(this.comments_count);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/CommentsFeedImpl$Content.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */