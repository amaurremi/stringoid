package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import java.util.ArrayList;
import java.util.List;

public abstract class PagingList<T extends Parcelable>
        implements Parcelable {
    public List<T> items = new ArrayList();
    public Paging paging;

    public PagingList() {
        this.paging = new Paging();
    }

    public PagingList(Parcel paramParcel) {
        paramParcel.readTypedList(this.items, getListParcelCreator());
        this.paging = ((Paging) paramParcel.readParcelable(Paging.class.getClassLoader()));
    }

    public void clear() {
        this.items.clear();
        this.paging.clear();
    }

    public int describeContents() {
        return 0;
    }

    public abstract Parcelable.Creator<T> getListParcelCreator();

    public void update(Feed<T> paramFeed) {
        clear();
        this.items.addAll(paramFeed.getList());
        this.paging.update(paramFeed.getPaging());
    }

    public void updateNext(Feed<T> paramFeed) {
        this.items.addAll(paramFeed.getList());
        this.paging.updateNext(paramFeed.getPaging());
    }

    public void updatePrev(Feed<T> paramFeed) {
        this.items.addAll(0, paramFeed.getList());
        this.paging.updatePrev(paramFeed.getPaging());
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeTypedList(this.items);
        paramParcel.writeParcelable(this.paging, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/PagingList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */