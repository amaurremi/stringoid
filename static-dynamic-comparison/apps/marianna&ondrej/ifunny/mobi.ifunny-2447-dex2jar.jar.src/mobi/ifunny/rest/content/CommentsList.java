package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CommentsList
        extends PagingList<Comment>
        implements Parcelable {
    public static final Parcelable.Creator<CommentsList> CREATOR = new CommentsList
    .1();

    public CommentsList() {
    }

    public CommentsList(Parcel paramParcel) {
        super(paramParcel);
    }

    public Parcelable.Creator<Comment> getListParcelCreator() {
        return Comment.CREATOR;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/CommentsList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */