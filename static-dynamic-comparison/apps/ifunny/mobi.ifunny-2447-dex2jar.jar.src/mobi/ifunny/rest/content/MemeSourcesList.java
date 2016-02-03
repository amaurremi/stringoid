package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import java.util.List;

public class MemeSourcesList
        extends PagingList<MemeSource>
        implements Parcelable {
    public static final Parcelable.Creator<MemeSourcesList> CREATOR = new MemeSourcesList
    .1();

    public MemeSourcesList() {
    }

    public MemeSourcesList(Parcel paramParcel) {
        super(paramParcel);
    }

    public Parcelable.Creator<MemeSource> getListParcelCreator() {
        return MemeSource.CREATOR;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeInt(this.items.size());
        super.writeToParcel(paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/MemeSourcesList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */