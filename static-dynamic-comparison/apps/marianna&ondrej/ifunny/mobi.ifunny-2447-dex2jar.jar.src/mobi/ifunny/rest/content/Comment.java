package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

public class Comment
        implements Parcelable {
    public static final Parcelable.Creator<Comment> CREATOR = new Comment
    .1();
    public static final String STATE_ABUSED = "abused";
    public static final String STATE_DELETED = "deleted";
    public static final String STATE_DELETED_SELF = "deleted_self";
    public static final String STATE_HIDDEN = "hidden";
    public static final String STATE_NORMAL = "normal";
    public static final String STATE_TOP = "top";
    private Boolean abused;
    public String cid;
    public long date;
    private Boolean deleted;
    public int depth;
    public String id;
    public boolean is_reply;
    public boolean is_smiled;
    public boolean is_unsmiled;
    public int num_replies;
    public int num_smiles;
    public int num_unsmiles;
    public String parent_comm_id;
    public String root_comm_id;
    private String state;
    public String text;
    private Boolean top;
    public User user;

    public Comment() {
    }

    protected Comment(Parcel paramParcel) {
        this.id = paramParcel.readString();
        this.cid = paramParcel.readString();
        this.state = paramParcel.readString();
        this.date = paramParcel.readLong();
        this.text = paramParcel.readString();
        this.num_smiles = paramParcel.readInt();
        label88:
        label103:
        int i;
        if (paramParcel.readInt() == 1) {
            bool1 = true;
            this.is_smiled = bool1;
            this.num_unsmiles = paramParcel.readInt();
            if (paramParcel.readInt() != 1) {
                break label249;
            }
            bool1 = true;
            this.is_unsmiled = bool1;
            if (paramParcel.readInt() != 1) {
                break label254;
            }
            bool1 = true;
            this.is_reply = bool1;
            this.num_replies = paramParcel.readInt();
            this.parent_comm_id = paramParcel.readString();
            this.root_comm_id = paramParcel.readString();
            this.depth = paramParcel.readInt();
            if (paramParcel.readInt() != 1) {
                break label259;
            }
            i = 1;
            label150:
            if (i != 0) {
                this.user = ((User) User.CREATOR.createFromParcel(paramParcel));
            }
            i = paramParcel.readInt();
            if (i >= 0) {
                if (i != 1) {
                    break label264;
                }
                bool1 = true;
                label186:
                this.abused = Boolean.valueOf(bool1);
            }
            i = paramParcel.readInt();
            if (i >= 0) {
                if (i != 1) {
                    break label269;
                }
                bool1 = true;
                label210:
                this.deleted = Boolean.valueOf(bool1);
            }
            i = paramParcel.readInt();
            if (i >= 0) {
                if (i != 1) {
                    break label274;
                }
            }
        }
        label249:
        label254:
        label259:
        label264:
        label269:
        label274:
        for (boolean bool1 = bool2; ; bool1 = false) {
            this.top = Boolean.valueOf(bool1);
            return;
            bool1 = false;
            break;
            bool1 = false;
            break label88;
            bool1 = false;
            break label103;
            i = 0;
            break label150;
            bool1 = false;
            break label186;
            bool1 = false;
            break label210;
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        if (paramObject == null) {
        }
        while (!(paramObject instanceof Comment)) {
            return false;
        }
        paramObject = (Comment) paramObject;
        return TextUtils.equals(this.id, ((Comment) paramObject).getId());
    }

    public long getDateInMillis() {
        return this.date * 1000L;
    }

    public String getId() {
        return this.id;
    }

    public String getState() {
        return this.state;
    }

    public boolean isAbused() {
        if (this.abused == null) {
            this.abused = Boolean.valueOf(TextUtils.equals(getState(), "abused"));
        }
        return this.abused.booleanValue();
    }

    public boolean isDeleted() {
        if (this.deleted == null) {
            if ((!TextUtils.equals(getState(), "deleted")) && (!TextUtils.equals(getState(), "deleted_self"))) {
                break label49;
            }
        }
        label49:
        for (boolean bool = true; ; bool = false) {
            this.deleted = Boolean.valueOf(bool);
            return this.deleted.booleanValue();
        }
    }

    public boolean isTop() {
        if (this.top == null) {
            this.top = Boolean.valueOf(TextUtils.equals(getState(), "top"));
        }
        return this.top.booleanValue();
    }

    public void setState(String paramString) {
        this.state = paramString;
        this.deleted = null;
        this.abused = null;
        this.top = null;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        int j = -1;
        paramParcel.writeString(this.id);
        paramParcel.writeString(this.cid);
        paramParcel.writeString(this.state);
        paramParcel.writeLong(this.date);
        paramParcel.writeString(this.text);
        paramParcel.writeInt(this.num_smiles);
        int i;
        if (this.is_smiled) {
            i = 1;
            paramParcel.writeInt(i);
            paramParcel.writeInt(this.num_unsmiles);
            if (!this.is_unsmiled) {
                break label194;
            }
            i = 1;
            label82:
            paramParcel.writeInt(i);
            if (!this.is_reply) {
                break label199;
            }
            i = 1;
            label96:
            paramParcel.writeInt(i);
            paramParcel.writeInt(this.num_replies);
            paramParcel.writeString(this.parent_comm_id);
            paramParcel.writeString(this.root_comm_id);
            paramParcel.writeInt(this.depth);
            if (this.user != null) {
                break label204;
            }
            paramParcel.writeInt(0);
            label145:
            if (this.abused != null) {
                break label221;
            }
            paramInt = -1;
            label154:
            paramParcel.writeInt(paramInt);
            if (this.deleted != null) {
                break label241;
            }
            paramInt = -1;
            label168:
            paramParcel.writeInt(paramInt);
            if (this.top != null) {
                break label261;
            }
            paramInt = j;
        }
        for (; ; ) {
            paramParcel.writeInt(paramInt);
            return;
            i = 0;
            break;
            label194:
            i = 0;
            break label82;
            label199:
            i = 0;
            break label96;
            label204:
            paramParcel.writeInt(1);
            this.user.writeToParcel(paramParcel, paramInt);
            break label145;
            label221:
            if (this.abused.booleanValue()) {
                paramInt = 1;
                break label154;
            }
            paramInt = 0;
            break label154;
            label241:
            if (this.deleted.booleanValue()) {
                paramInt = 1;
                break label168;
            }
            paramInt = 0;
            break label168;
            label261:
            if (this.top.booleanValue()) {
                paramInt = 1;
            } else {
                paramInt = 0;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/Comment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */