package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

import java.util.Random;

import mobi.ifunny.gallery.am;
import mobi.ifunny.social.auth.l;

public final class IFunny
        implements Parcelable, am {
    public static final Parcelable.Creator<IFunny> CREATOR = new IFunny
    .1();
    public static final String STATE_DELETED = "deleted";
    public static final String STATE_DRAFT = "draft";
    public static final String STATE_PUBLISHED = "published";
    public static final String TYPE_CAPTION = "caption";
    public static final String TYPE_COMICS = "comics";
    public static final String TYPE_DEM = "dem";
    public static final String TYPE_GIF = "gif";
    public static final String TYPE_GIF_CAPTION = "gif_caption";
    public static final String TYPE_MEANWHILE = "_meanwhile";
    public static final String TYPE_MEM = "mem";
    public static final String TYPE_OLD = "old";
    public static final String TYPE_PIC = "pic";
    public static final String TYPE_SPECIAL = "special";
    public static final String TYPE_VIDEO = "video";
    private static final Random random = new Random(System.currentTimeMillis());
    private String bg_color;
    public String bottom_label;
    public IFunny.CaptionParams caption;
    public IFunny.ComicsParams comics;
    public User creator;
    private long date_create;
    public IFunny.GifParams gif;
    public String id;
    private boolean is_abused;
    private boolean is_featured;
    private boolean is_republished;
    private boolean is_smiled;
    private boolean is_unsmiled;
    public String link;
    public final LoadingHelper loadingHelper = new LoadingHelper(this);
    public IFunny.MemParams mem;
    public Counters num = new Counters();
    public IFunny.PicParams pic;
    public IFunny.ContentSize size;
    public IFunny.Source source;
    public String state;
    private String thumb_large_url;
    private String thumb_url;
    public String title;
    public String top_label;
    public String type;
    public int uniqueId = random.nextInt();
    public String url;
    public IFunny.VideoParams video;

    public IFunny() {
    }

    private IFunny(Parcel paramParcel) {
        this();
        this.id = paramParcel.readString();
        this.uniqueId = paramParcel.readInt();
        this.type = paramParcel.readString();
        this.state = paramParcel.readString();
        this.date_create = paramParcel.readLong();
        this.num = ((Counters) paramParcel.readParcelable(Counters.class.getClassLoader()));
        this.creator = ((User) paramParcel.readParcelable(User.class.getClassLoader()));
        this.source = ((IFunny.Source) paramParcel.readParcelable(IFunny.Source.class.getClassLoader()));
        this.url = paramParcel.readString();
        this.thumb_url = paramParcel.readString();
        this.bg_color = paramParcel.readString();
        this.thumb_large_url = paramParcel.readString();
        this.link = paramParcel.readString();
        if (paramParcel.readInt() == 1) {
            bool1 = true;
            this.is_abused = bool1;
            if (paramParcel.readInt() != 1) {
                break label336;
            }
            bool1 = true;
            label159:
            this.is_smiled = bool1;
            if (paramParcel.readInt() != 1) {
                break label341;
            }
            bool1 = true;
            label174:
            this.is_republished = bool1;
            if (paramParcel.readInt() != 1) {
                break label346;
            }
        }
        label336:
        label341:
        label346:
        for (boolean bool1 = bool2; ; bool1 = false) {
            this.is_featured = bool1;
            this.top_label = paramParcel.readString();
            this.bottom_label = paramParcel.readString();
            this.title = paramParcel.readString();
            this.size = ((IFunny.ContentSize) paramParcel.readParcelable(IFunny.ContentSize.class.getClassLoader()));
            this.video = ((IFunny.VideoParams) paramParcel.readParcelable(IFunny.VideoParams.class.getClassLoader()));
            this.gif = ((IFunny.GifParams) paramParcel.readParcelable(IFunny.GifParams.class.getClassLoader()));
            this.caption = ((IFunny.CaptionParams) paramParcel.readParcelable(IFunny.CaptionParams.class.getClassLoader()));
            this.mem = ((IFunny.MemParams) paramParcel.readParcelable(IFunny.MemParams.class.getClassLoader()));
            this.pic = ((IFunny.PicParams) paramParcel.readParcelable(IFunny.PicParams.class.getClassLoader()));
            this.comics = ((IFunny.ComicsParams) paramParcel.readParcelable(IFunny.ComicsParams.class.getClassLoader()));
            return;
            bool1 = false;
            break;
            bool1 = false;
            break label159;
            bool1 = false;
            break label174;
        }
    }

    public boolean canBeSaved() {
        boolean bool = true;
        String str = this.type;
        int i = -1;
        switch (str.hashCode()) {
        }
        for (; ; ) {
            switch (i) {
                default:
                    bool = false;
            }
            return bool;
            if (str.equals("old")) {
                i = 0;
                continue;
                if (str.equals("dem")) {
                    i = 1;
                    continue;
                    if (str.equals("mem")) {
                        i = 2;
                        continue;
                        if (str.equals("pic")) {
                            i = 3;
                            continue;
                            if (str.equals("special")) {
                                i = 4;
                                continue;
                                if (str.equals("gif")) {
                                    i = 5;
                                    continue;
                                    if (str.equals("caption")) {
                                        i = 6;
                                        continue;
                                        if (str.equals("comics")) {
                                            i = 7;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        if ((paramObject instanceof IFunny)) {
            paramObject = (IFunny) paramObject;
            return this.uniqueId == ((IFunny) paramObject).uniqueId;
        }
        return super.equals(paramObject);
    }

    public long getDateInMillis() {
        return this.date_create * 1000L;
    }

    public User getOriginalAuthor() {
        if (hasSource()) {
            return this.source.creator;
        }
        return this.creator;
    }

    public String getOriginalCid() {
        if (this.source != null) {
            return this.source.id;
        }
        return this.id;
    }

    public String getPhotoUrl_ForGalleryCreatorAvatar() {
        User localUser = getOriginalAuthor();
        if (localUser == null) {
            return null;
        }
        return localUser.getPhotoThumbSmallUrl();
    }

    public String getThumbPlaceholderColor() {
        return this.bg_color;
    }

    public String getThumbUrl(boolean paramBoolean) {
        if ((paramBoolean) && (!TextUtils.isEmpty(this.thumb_large_url))) {
            return this.thumb_large_url;
        }
        return this.thumb_url;
    }

    public boolean hasSource() {
        return this.source != null;
    }

    public int hashCode() {
        return this.uniqueId;
    }

    public boolean isAbused() {
        return this.is_abused;
    }

    public boolean isCreatedByMe() {
        boolean bool = true;
        String str = l.a().d();
        if (TextUtils.isEmpty(str)) {
            bool = false;
        }
        do {
            do {
                return bool;
                if (!hasSource()) {
                    break;
                }
            } while ((this.source.creator != null) && (TextUtils.equals(str, this.source.creator.id)));
            return false;
        } while ((this.creator != null) && (TextUtils.equals(str, this.creator.id)));
        return false;
    }

    public boolean isDeleted() {
        return TextUtils.equals(this.state, "deleted");
    }

    public boolean isFeatured() {
        return this.is_featured;
    }

    public boolean isGifContent() {
        return ("gif".equals(this.type)) || ("gif_caption".equals(this.type));
    }

    public boolean isInMyGallery() {
        String str = l.a().d();
        return (!TextUtils.isEmpty(str)) && (this.creator != null) && (TextUtils.equals(str, this.creator.id));
    }

    public boolean isRated() {
        return (this.is_smiled) || (this.is_unsmiled);
    }

    public boolean isRepublished() {
        return this.is_republished;
    }

    public boolean isSmiled() {
        return this.is_smiled;
    }

    public boolean isUnsmiled() {
        return this.is_unsmiled;
    }

    public boolean isVideoContent() {
        return "video".equals(this.type);
    }

    public boolean needToTrackDecodeTime() {
        return (TextUtils.equals(this.type, "pic")) || (TextUtils.equals(this.type, "caption")) || (TextUtils.equals(this.type, "comics")) || (TextUtils.equals(this.type, "dem")) || (TextUtils.equals(this.type, "mem"));
    }

    public void setAbused(boolean paramBoolean) {
        this.is_abused = paramBoolean;
    }

    public void setCounters(Counters paramCounters) {
        this.num = paramCounters;
    }

    public void setRepublished(boolean paramBoolean) {
        this.is_republished = paramBoolean;
    }

    public void setSmiled(boolean paramBoolean) {
        Counters localCounters;
        if (paramBoolean) {
            if (this.is_unsmiled) {
                localCounters = this.num;
                localCounters.unsmiles -= 1;
                this.is_unsmiled = false;
            }
            if (!this.is_smiled) {
                localCounters = this.num;
                localCounters.smiles += 1;
            }
        }
        for (; ; ) {
            this.is_smiled = paramBoolean;
            return;
            if (this.is_smiled) {
                localCounters = this.num;
                localCounters.smiles -= 1;
            }
        }
    }

    public void setUnsmiled(boolean paramBoolean) {
        Counters localCounters;
        if (paramBoolean) {
            if (this.is_smiled) {
                localCounters = this.num;
                localCounters.smiles -= 1;
                this.is_smiled = false;
            }
            if (!this.is_unsmiled) {
                localCounters = this.num;
                localCounters.unsmiles += 1;
            }
        }
        for (; ; ) {
            this.is_unsmiled = paramBoolean;
            return;
            if (this.is_unsmiled) {
                localCounters = this.num;
                localCounters.unsmiles -= 1;
            }
        }
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        int j = 1;
        paramParcel.writeString(this.id);
        paramParcel.writeInt(this.uniqueId);
        paramParcel.writeString(this.type);
        paramParcel.writeString(this.state);
        paramParcel.writeLong(this.date_create);
        paramParcel.writeParcelable(this.num, paramInt);
        paramParcel.writeParcelable(this.creator, paramInt);
        paramParcel.writeParcelable(this.source, paramInt);
        paramParcel.writeString(this.url);
        paramParcel.writeString(this.thumb_url);
        paramParcel.writeString(this.bg_color);
        paramParcel.writeString(this.thumb_large_url);
        paramParcel.writeString(this.link);
        if (this.is_abused) {
            i = 1;
            paramParcel.writeInt(i);
            if (!this.is_smiled) {
                break label260;
            }
            i = 1;
            label133:
            paramParcel.writeInt(i);
            if (!this.is_republished) {
                break label265;
            }
            i = 1;
            label147:
            paramParcel.writeInt(i);
            if (!this.is_featured) {
                break label270;
            }
        }
        label260:
        label265:
        label270:
        for (int i = j; ; i = 0) {
            paramParcel.writeInt(i);
            paramParcel.writeString(this.top_label);
            paramParcel.writeString(this.bottom_label);
            paramParcel.writeString(this.title);
            paramParcel.writeParcelable(this.size, paramInt);
            paramParcel.writeParcelable(this.video, paramInt);
            paramParcel.writeParcelable(this.gif, paramInt);
            paramParcel.writeParcelable(this.caption, paramInt);
            paramParcel.writeParcelable(this.mem, paramInt);
            paramParcel.writeParcelable(this.pic, paramInt);
            paramParcel.writeParcelable(this.comics, paramInt);
            return;
            i = 0;
            break;
            i = 0;
            break label133;
            i = 0;
            break label147;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/IFunny.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */