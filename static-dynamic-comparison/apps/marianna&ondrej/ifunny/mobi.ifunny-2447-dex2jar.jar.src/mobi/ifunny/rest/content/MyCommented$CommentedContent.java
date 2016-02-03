package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MyCommented$CommentedContent
        extends Comment
        implements Parcelable {
    public static final Parcelable.Creator<CommentedContent> CREATOR = new MyCommented.CommentedContent
    .1();
    public static final String DELETED_BY_SPAM_FILTER = "del_by_spam_filter";
    public static final String DELETED_CONTENT = "del_content";
    public static final String DELETED_CONTENT_CREATOR = "del_content_creator";
    public static final String DELETED_FOR_ABUSES = "del_for_abuses";
    public static final String DELETED_ROOT_COMMENT = "del_root_comment";
    public static final String DELETED_VIA_PORTAL = "del_via_portal";
    public IFunny content;
    public String deletion_reason;

    public MyCommented$CommentedContent() {
    }

    public MyCommented$CommentedContent(Parcel paramParcel) {
        super(paramParcel);
        this.content = ((IFunny) paramParcel.readParcelable(IFunny.class.getClassLoader()));
        this.deletion_reason = paramParcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            return true;
            if (!(paramObject instanceof CommentedContent)) {
                return false;
            }
            if (!super.equals(paramObject)) {
                return false;
            }
            paramObject = (CommentedContent) paramObject;
            if (this.content == null) {
                break;
            }
        } while (this.content.equals(((CommentedContent) paramObject).content));
        while (((CommentedContent) paramObject).content != null) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        if (this.content != null) {
            return this.content.hashCode();
        }
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        super.writeToParcel(paramParcel, paramInt);
        paramParcel.writeParcelable(this.content, paramInt);
        paramParcel.writeString(this.deletion_reason);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/MyCommented$CommentedContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */