package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class User
        implements Parcelable {
    public static final Parcelable.Creator<User> CREATOR = new User
    .1();
    public static final String REG_TYPE_FACEBOOK = "fb";
    public static final String REG_TYPE_GPLUS = "gplus";
    public static final String REG_TYPE_PASSWORD = "pwd";
    public static final String REG_TYPE_TWITTER = "tw";
    public String about;
    public IFunnyList content;
    public String cover_url;
    public String email;
    public String id;
    public boolean is_banned;
    public boolean is_blocked;
    public boolean is_in_subscriptions;
    public boolean is_verified;
    public String nick;
    public UserStat num;
    private UserPhoto photo;
    public UserSocials social;
    public int total_posts;

    public User() {
    }

    public User(Parcel paramParcel) {
        this.id = paramParcel.readString();
        this.nick = paramParcel.readString();
        this.about = paramParcel.readString();
        this.photo = ((UserPhoto) paramParcel.readParcelable(UserPhoto.class.getClassLoader()));
        this.cover_url = paramParcel.readString();
        if (paramParcel.readByte() != 0) {
            bool1 = true;
            this.is_verified = bool1;
            if (paramParcel.readByte() == 0) {
                break label180;
            }
            bool1 = true;
            label77:
            this.is_banned = bool1;
            if (paramParcel.readByte() == 0) {
                break label185;
            }
            bool1 = true;
            label91:
            this.is_blocked = bool1;
            if (paramParcel.readByte() == 0) {
                break label190;
            }
        }
        label180:
        label185:
        label190:
        for (boolean bool1 = bool2; ; bool1 = false) {
            this.is_in_subscriptions = bool1;
            this.email = paramParcel.readString();
            this.social = ((UserSocials) paramParcel.readParcelable(UserSocials.class.getClassLoader()));
            this.num = ((UserStat) paramParcel.readParcelable(UserStat.class.getClassLoader()));
            this.total_posts = paramParcel.readInt();
            this.content = ((IFunnyList) paramParcel.readParcelable(IFunnyList.class.getClassLoader()));
            return;
            bool1 = false;
            break;
            bool1 = false;
            break label77;
            bool1 = false;
            break label91;
        }
    }

    public User(User paramUser) {
        this.id = paramUser.id;
        this.nick = paramUser.nick;
        this.about = paramUser.about;
        Parcel localParcel;
        if (paramUser.photo == null) {
            this.photo = null;
            this.cover_url = paramUser.cover_url;
            this.is_verified = paramUser.is_verified;
            this.is_banned = paramUser.is_banned;
            this.is_blocked = paramUser.is_blocked;
            this.is_in_subscriptions = paramUser.is_in_subscriptions;
            this.email = paramUser.email;
            if (paramUser.social == null) {
                break label208;
            }
            localParcel = Parcel.obtain();
            paramUser.social.writeToParcel(localParcel, 0);
            localParcel.setDataPosition(0);
            this.social = new UserSocials(localParcel);
            localParcel.recycle();
        }
        for (; ; ) {
            if (paramUser.num == null) {
                break label216;
            }
            localParcel = Parcel.obtain();
            paramUser.num.writeToParcel(localParcel, 0);
            localParcel.setDataPosition(0);
            this.num = new UserStat(localParcel);
            localParcel.recycle();
            return;
            localParcel = Parcel.obtain();
            paramUser.photo.writeToParcel(localParcel, 0);
            localParcel.setDataPosition(0);
            this.photo = new UserPhoto(localParcel);
            localParcel.recycle();
            break;
            label208:
            this.social = null;
        }
        label216:
        this.num = null;
    }

    public static User createForNewComment(String paramString1, String paramString2, String paramString3) {
        User localUser = new User();
        localUser.id = paramString1;
        localUser.nick = paramString2;
        localUser.photo = new UserPhoto();
        localUser.photo.thumb_small_url = paramString3;
        return localUser;
    }

    public int describeContents() {
        return 0;
    }

    public String getPhotoBgColor() {
        if (this.photo == null) {
            return null;
        }
        return this.photo.bg_color;
    }

    public String getPhotoThumbLargeUrl() {
        if (this.photo == null) {
            return null;
        }
        return this.photo.thumb_large_url;
    }

    public String getPhotoThumbSmallUrl() {
        if (this.photo == null) {
            return null;
        }
        return this.photo.thumb_small_url;
    }

    public String getPhotoUrl() {
        if (this.photo == null) {
            return null;
        }
        return this.photo.url;
    }

    public void setPhoto(UserPhoto paramUserPhoto) {
        this.photo = paramUserPhoto;
    }

    public void setPhotoThumbLargeUrl(String paramString) {
        if (this.photo == null) {
            this.photo = new UserPhoto();
        }
        this.photo.thumb_large_url = paramString;
    }

    public void setPhotoUrl(String paramString) {
        if (this.photo == null) {
            this.photo = new UserPhoto();
        }
        this.photo.url = paramString;
    }

    public String toString() {
        return "Profile " + this.id + '\n' + this.nick + ' ' + this.about + '\n' + "photo " + this.photo + '\n' + "cover " + this.cover_url;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        int j = 1;
        paramParcel.writeString(this.id);
        paramParcel.writeString(this.nick);
        paramParcel.writeString(this.about);
        paramParcel.writeParcelable(this.photo, paramInt);
        paramParcel.writeString(this.cover_url);
        if (this.is_verified) {
            i = 1;
            paramParcel.writeByte((byte) i);
            if (!this.is_banned) {
                break label154;
            }
            i = 1;
            label68:
            paramParcel.writeByte((byte) i);
            if (!this.is_blocked) {
                break label159;
            }
            i = 1;
            label83:
            paramParcel.writeByte((byte) i);
            if (!this.is_in_subscriptions) {
                break label164;
            }
        }
        label154:
        label159:
        label164:
        for (int i = j; ; i = 0) {
            paramParcel.writeByte((byte) i);
            paramParcel.writeString(this.email);
            paramParcel.writeParcelable(this.social, paramInt);
            paramParcel.writeParcelable(this.num, paramInt);
            paramParcel.writeInt(this.total_posts);
            paramParcel.writeParcelable(this.content, paramInt);
            return;
            i = 0;
            break;
            i = 0;
            break label68;
            i = 0;
            break label83;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/User.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */