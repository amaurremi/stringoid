package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import java.util.ArrayList;

public class IFunnyList
        extends PagingList<IFunny>
        implements Parcelable {
    public static final Parcelable.Creator<IFunnyList> CREATOR = new IFunnyList
    .1();

    public IFunnyList() {
        this((IFunnyList) null);
    }

    public IFunnyList(Parcel paramParcel) {
        super(paramParcel);
    }

    public IFunnyList(IFunnyList paramIFunnyList) {
        if (paramIFunnyList == null) {
            this.items = new ArrayList();
            this.paging = new Paging();
            return;
        }
        this.items = new ArrayList(paramIFunnyList.items);
        this.paging = new Paging(paramIFunnyList.paging);
    }

    public Parcelable.Creator<IFunny> getListParcelCreator() {
        return IFunny.CREATOR;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/IFunnyList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */