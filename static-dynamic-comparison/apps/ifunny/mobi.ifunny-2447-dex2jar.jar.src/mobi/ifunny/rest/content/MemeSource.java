package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import mobi.ifunny.gallery.am;

public class MemeSource
        implements Parcelable, am {
    public static final Parcelable.Creator<MemeSource> CREATOR = new MemeSource
    .1();
    public String bottom_label;
    public String id;
    public String thumb_url;
    public String top_label;
    public String url;

    public MemeSource() {
    }

    private MemeSource(Parcel paramParcel) {
        this.id = paramParcel.readString();
        this.url = paramParcel.readString();
        this.thumb_url = paramParcel.readString();
        this.top_label = paramParcel.readString();
        this.bottom_label = paramParcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        if ((paramObject instanceof MemeSource)) {
            paramObject = (MemeSource) paramObject;
            return TextUtils.equals(this.id, ((MemeSource) paramObject).id);
        }
        return super.equals(paramObject);
    }

    public String getThumbPlaceholderColor() {
        return null;
    }

    public String getThumbUrl(boolean paramBoolean) {
        return this.thumb_url;
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeString(this.id);
        paramParcel.writeString(this.url);
        paramParcel.writeString(this.thumb_url);
        paramParcel.writeString(this.top_label);
        paramParcel.writeString(this.bottom_label);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/MemeSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */