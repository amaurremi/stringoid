package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class RepliesFeed
        extends CommentsFeed<Comment> {
    public static final Parcelable.Creator<RepliesFeed> CREATOR = new RepliesFeed
    .1();
    public RepliesFeed.CommentMeta comment;
    private CommentsList replies;

    public RepliesFeed() {
        this.replies = new CommentsList();
        this.comment = new RepliesFeed.CommentMeta();
    }

    public RepliesFeed(Parcel paramParcel) {
        this.comment = ((RepliesFeed.CommentMeta) paramParcel.readParcelable(RepliesFeed.CommentMeta.class.getClassLoader()));
        this.replies = ((CommentsList) paramParcel.readParcelable(CommentsList.class.getClassLoader()));
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
        return this.comment.replies_count;
    }

    public PagingList<Comment> getPagingList() {
        return this.replies;
    }

    public void setExhibitCommentsCount(int paramInt) {
        this.comment.replies_count = paramInt;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeParcelable(this.comment, paramInt);
        paramParcel.writeParcelable(this.replies, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/RepliesFeed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */