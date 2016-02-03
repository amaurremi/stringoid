package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import java.util.Arrays;
import java.util.List;

public class News
        implements Parcelable {
    public static final List<String> AVAILABLE_NEWS_TYPES = Arrays.asList(new String[]{"smile", "smile_for_comment", "smile_for_reply", "smile_for_repub", "repub", "repub_of_repub", "comment", "comment_for_repub", "reply_for_comment", "subscribe", "friend_registered", "featured", "ban", "unban"});
    public static final Parcelable.Creator<News> CREATOR = new News
    .1();
    public static final String TYPE_BAN = "ban";
    public static final String TYPE_COMMENT = "comment";
    public static final String TYPE_COMMENT_FOR_REPUB = "comment_for_repub";
    public static final String TYPE_FEATURED = "featured";
    public static final String TYPE_FRIEND_REGISTERED = "friend_registered";
    public static final String TYPE_REPLY_FOR_COMMENT = "reply_for_comment";
    public static final String TYPE_REPUB = "repub";
    public static final String TYPE_REPUB_OF_REPUB = "repub_of_repub";
    public static final String TYPE_SMILE = "smile";
    public static final String TYPE_SMILE_FOR_COMMENT = "smile_for_comment";
    public static final String TYPE_SMILE_FOR_REPLY = "smile_for_reply";
    public static final String TYPE_SMILE_FOR_REPUB = "smile_for_repub";
    public static final String TYPE_SPECIAL = "special";
    public static final String TYPE_SUBSCRIBE = "subscribe";
    public static final String TYPE_UNBAN = "unban";
    public Comment comment;
    public IFunny content;
    public long date;
    public Comment reply;
    public String text;
    public String type;
    public String url;
    public User user;

    public News() {
    }

    public News(Parcel paramParcel) {
        this.type = paramParcel.readString();
        this.date = paramParcel.readLong();
        this.user = ((User) paramParcel.readParcelable(User.class.getClassLoader()));
        this.content = ((IFunny) paramParcel.readParcelable(IFunny.class.getClassLoader()));
        this.comment = ((Comment) paramParcel.readParcelable(Comment.class.getClassLoader()));
        this.reply = ((Comment) paramParcel.readParcelable(Comment.class.getClassLoader()));
        this.text = paramParcel.readString();
        this.url = paramParcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "News(" + this.type + ')';
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeString(this.type);
        paramParcel.writeLong(this.date);
        paramParcel.writeParcelable(this.user, paramInt);
        paramParcel.writeParcelable(this.content, paramInt);
        paramParcel.writeParcelable(this.comment, paramInt);
        paramParcel.writeParcelable(this.reply, paramInt);
        paramParcel.writeString(this.text);
        paramParcel.writeString(this.url);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/News.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */