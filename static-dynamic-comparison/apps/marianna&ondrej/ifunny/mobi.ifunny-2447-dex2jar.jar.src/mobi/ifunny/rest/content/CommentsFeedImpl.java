package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class CommentsFeedImpl
        extends CommentsFeed<Comment> {
    public static final Parcelable.Creator<CommentsFeedImpl> CREATOR = new CommentsFeedImpl
    .1();
    private CommentsList comments;
    public CommentsFeedImpl.Content content;

    public CommentsFeedImpl() {
        this.comments = new CommentsList();
        this.content = new CommentsFeedImpl.Content();
    }

    public CommentsFeedImpl(Parcel paramParcel) {
        this.content = ((CommentsFeedImpl.Content) paramParcel.readParcelable(CommentsFeedImpl.Content.class.getClassLoader()));
        this.comments = ((CommentsList) paramParcel.readParcelable(CommentsList.class.getClassLoader()));
    }

    public Feed<Comment> copy() {
        CommentsFeedImpl localCommentsFeedImpl = new CommentsFeedImpl();
        localCommentsFeedImpl.update(this);
        return localCommentsFeedImpl;
    }

    public int describeContents() {
        return 0;
    }

    public int getExhibitCommentsCount() {
        return this.content.comments_count;
    }

    public PagingList<Comment> getPagingList() {
        return this.comments;
    }

    public void setExhibitCommentsCount(int paramInt) {
        this.content.comments_count = paramInt;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeParcelable(this.content, paramInt);
        paramParcel.writeParcelable(this.comments, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/CommentsFeedImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */