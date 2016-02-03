package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MyCommentsList
        extends PagingList<MyCommented.CommentedContent>
        implements Parcelable {
    public static final Parcelable.Creator<MyCommentsList> CREATOR = new MyCommentsList
    .1();

    public MyCommentsList() {
    }

    public MyCommentsList(Parcel paramParcel) {
        super(paramParcel);
    }

    public Parcelable.Creator<MyCommented.CommentedContent> getListParcelCreator() {
        return MyCommented.CommentedContent.CREATOR;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/MyCommentsList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */