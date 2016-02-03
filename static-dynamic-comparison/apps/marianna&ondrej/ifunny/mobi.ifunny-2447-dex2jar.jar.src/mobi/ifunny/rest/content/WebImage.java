package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import mobi.ifunny.gallery.am;

public class WebImage
        implements Parcelable, am {
    public static final Parcelable.Creator<WebImage> CREATOR = new WebImage
    .1();
    public WebImage.Size size;
    public String thumb_url;
    public String url;

    public WebImage() {
    }

    private WebImage(Parcel paramParcel) {
        this.url = paramParcel.readString();
        this.thumb_url = paramParcel.readString();
        this.size = ((WebImage.Size) paramParcel.readParcelable(WebImage.Size.class.getClassLoader()));
    }

    public int describeContents() {
        return 0;
    }

    public String getThumbPlaceholderColor() {
        return null;
    }

    public String getThumbUrl(boolean paramBoolean) {
        return this.thumb_url;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeString(this.url);
        paramParcel.writeString(this.thumb_url);
        paramParcel.writeParcelable(this.size, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/WebImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */