package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MyCommented
        extends FeedPagingList<MyCommented.CommentedContent>
        implements Parcelable {
    public static final Parcelable.Creator<MyCommented> CREATOR = new MyCommented
    .1();
    public MyCommentsList comments;

    public MyCommented() {
        this.comments = new MyCommentsList();
    }

    public MyCommented(Parcel paramParcel) {
        this.comments = ((MyCommentsList) paramParcel.readParcelable(MyCommentsList.class.getClassLoader()));
    }

    public MyCommented copy() {
        MyCommented localMyCommented = new MyCommented();
        localMyCommented.update(this);
        return localMyCommented;
    }

    public int describeContents() {
        return 0;
    }

    public PagingList<MyCommented.CommentedContent> getPagingList() {
        return this.comments;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeParcelable(this.comments, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/MyCommented.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */