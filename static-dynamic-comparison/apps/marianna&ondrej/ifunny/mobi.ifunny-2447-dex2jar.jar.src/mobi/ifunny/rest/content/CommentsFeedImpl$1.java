package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class CommentsFeedImpl$1
        implements Parcelable.Creator<CommentsFeedImpl> {
    public CommentsFeedImpl createFromParcel(Parcel paramParcel) {
        return new CommentsFeedImpl(paramParcel);
    }

    public CommentsFeedImpl[] newArray(int paramInt) {
        return new CommentsFeedImpl[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/CommentsFeedImpl$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */