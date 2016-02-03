package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class NewsList
        extends PagingList<News>
        implements Parcelable {
    public static final Parcelable.Creator<NewsList> CREATOR = new NewsList
    .1();

    public NewsList() {
    }

    public NewsList(Parcel paramParcel) {
        super(paramParcel);
    }

    public Parcelable.Creator<News> getListParcelCreator() {
        return News.CREATOR;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/NewsList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */