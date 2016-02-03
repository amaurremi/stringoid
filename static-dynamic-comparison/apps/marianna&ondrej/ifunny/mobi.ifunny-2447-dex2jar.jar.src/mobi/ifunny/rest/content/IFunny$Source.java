package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class IFunny$Source
        implements Parcelable {
    public static final Parcelable.Creator<Source> CREATOR = new IFunny.Source
    .1();
    public User creator;
    public String id;

    public IFunny$Source() {
    }

    public IFunny$Source(Parcel paramParcel) {
        this.creator = ((User) paramParcel.readParcelable(User.class.getClassLoader()));
        this.id = paramParcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeParcelable(this.creator, paramInt);
        paramParcel.writeString(this.id);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/IFunny$Source.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */