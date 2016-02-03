package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Counters
        implements Parcelable {
    public static final Parcelable.Creator<Counters> CREATOR = new Counters
    .1();
    public int comments;
    public int republished;
    public int smiles;
    public int unsmiles;
    public int views;

    public Counters() {
    }

    public Counters(Parcel paramParcel) {
        this.smiles = paramParcel.readInt();
        this.unsmiles = paramParcel.readInt();
        this.comments = paramParcel.readInt();
        this.republished = paramParcel.readInt();
        this.views = paramParcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeInt(this.smiles);
        paramParcel.writeInt(this.unsmiles);
        paramParcel.writeInt(this.comments);
        paramParcel.writeInt(this.republished);
        paramParcel.writeInt(this.views);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/Counters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */