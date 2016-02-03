package com.everimaging.fotor.push;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import java.util.ArrayList;
import java.util.List;

public class PushMessageEntity
        implements Parcelable {
    public static final Parcelable.Creator<PushMessageEntity> CREATOR = new Parcelable.Creator() {
        public PushMessageEntity createFromParcel(Parcel paramAnonymousParcel) {
            return new PushMessageEntity(paramAnonymousParcel);
        }

        public PushMessageEntity[] newArray(int paramAnonymousInt) {
            return new PushMessageEntity[paramAnonymousInt];
        }
    };
    private PushData data;
    private String msg;
    private String pageInfo;
    private boolean status;

    public PushMessageEntity() {
    }

    public PushMessageEntity(Parcel paramParcel) {
        this.data = ((PushData) paramParcel.readParcelable(PushData.class.getClassLoader()));
        this.msg = paramParcel.readString();
        this.pageInfo = paramParcel.readString();
        if (paramParcel.readInt() == 0) {
        }
        for (boolean bool = true; ; bool = false) {
            this.status = bool;
            return;
        }
    }

    public int describeContents() {
        return 0;
    }

    public PushData getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getPageInfo() {
        return this.pageInfo;
    }

    public boolean isStatus() {
        return this.status;
    }

    public void setData(PushData paramPushData) {
        this.data = paramPushData;
    }

    public void setMsg(String paramString) {
        this.msg = paramString;
    }

    public void setPageInfo(String paramString) {
        this.pageInfo = paramString;
    }

    public void setStatus(boolean paramBoolean) {
        this.status = paramBoolean;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramInt = 0;
        paramParcel.writeParcelable(this.data, 0);
        paramParcel.writeString(this.msg);
        paramParcel.writeString(this.pageInfo);
        if (this.status) {
            paramInt = 1;
        }
        paramParcel.writeInt(paramInt);
    }

    static class MessageEntity
            implements Parcelable {
        public static final Parcelable.Creator<MessageEntity> CREATOR = new Parcelable.Creator() {
            public PushMessageEntity.MessageEntity createFromParcel(Parcel paramAnonymousParcel) {
                return new PushMessageEntity.MessageEntity(paramAnonymousParcel);
            }

            public PushMessageEntity.MessageEntity[] newArray(int paramAnonymousInt) {
                return new PushMessageEntity.MessageEntity[paramAnonymousInt];
            }
        };
        public static final int EVENT_ALL = -1;
        public static final int EVENT_BORDER = 16;
        public static final int EVENT_EDIT = 4;
        public static final int EVENT_EFFECT = 8;
        public static final int EVENT_FONTS = 64;
        public static final int EVENT_HOME = 1;
        public static final int EVENT_NONE = 0;
        public static final int EVENT_SAVED_PHOTO = 2;
        public static final int EVENT_STICKER = 32;
        public static final int EVENT_STORE = 128;
        private long endTime;
        private String event;
        private long expireDuration;
        private int id;
        private String jump;
        private String jumpButtonTitle;
        private int level;
        private String link;
        private long localTime;
        private String msgDescription;
        private String showingStyle;
        private String title;

        public MessageEntity() {
            this.localTime = System.currentTimeMillis();
        }

        public MessageEntity(Parcel paramParcel) {
            this.event = paramParcel.readString();
            this.link = paramParcel.readString();
            this.jumpButtonTitle = paramParcel.readString();
            this.jump = paramParcel.readString();
            this.showingStyle = paramParcel.readString();
            this.expireDuration = paramParcel.readLong();
            this.msgDescription = paramParcel.readString();
            this.title = paramParcel.readString();
            this.endTime = paramParcel.readLong();
            this.level = paramParcel.readInt();
            this.id = paramParcel.readInt();
            this.localTime = paramParcel.readLong();
        }

        private int convertToIntEvent() {
            try {
                String[] arrayOfString = this.event.split(",");
                int j = 0;
                int k;
                for (int i = 0; ; i = k | i) {
                    k = i;
                    if (j >= arrayOfString.length) {
                        break;
                    }
                    k = Integer.valueOf(arrayOfString[j]).intValue();
                    j += 1;
                }
                return k;
            } catch (Exception localException) {
                k = 0;
            }
        }

        private static boolean typeOf(int paramInt1, int paramInt2) {
            return (paramInt1 & paramInt2) == paramInt2;
        }

        public int describeContents() {
            return 0;
        }

        public long getEndTime() {
            return this.endTime;
        }

        public String getEvent() {
            return this.event;
        }

        public long getExpireDuration() {
            return this.expireDuration;
        }

        public int getId() {
            return this.id;
        }

        public String getJump() {
            return this.jump;
        }

        public String getJumpButtonTitle() {
            return this.jumpButtonTitle;
        }

        public int getLevel() {
            return this.level;
        }

        public String getLink() {
            return this.link;
        }

        public long getLocalTime() {
            return this.localTime;
        }

        public String getMsgDescription() {
            return this.msgDescription;
        }

        public String getShowingStyle() {
            return this.showingStyle;
        }

        public String getTitle() {
            return this.title;
        }

        public boolean isDialogStyle() {
            return "1".equals(this.showingStyle);
        }

        public boolean isShouldDisplay(int paramInt) {
            int i = convertToIntEvent();
            if ((i == -1) && (paramInt != 0)) {
                return true;
            }
            if ((i == 0) || (paramInt == 0)) {
                return false;
            }
            return typeOf(i, paramInt);
        }

        public boolean isWebStyle() {
            return "2".equals(this.showingStyle);
        }

        public void setEndTime(long paramLong) {
            this.endTime = paramLong;
        }

        public void setEvent(String paramString) {
            this.event = paramString;
        }

        public void setExpireDuration(long paramLong) {
            this.expireDuration = paramLong;
        }

        public void setId(int paramInt) {
            this.id = paramInt;
        }

        public void setJump(String paramString) {
            this.jump = paramString;
        }

        public void setJumpButtonTitle(String paramString) {
            this.jumpButtonTitle = paramString;
        }

        public void setLevel(int paramInt) {
            this.level = paramInt;
        }

        public void setLink(String paramString) {
            this.link = paramString;
        }

        public void setMsgDescription(String paramString) {
            this.msgDescription = paramString;
        }

        public void setShowingStyle(String paramString) {
            this.showingStyle = paramString;
        }

        public void setTitle(String paramString) {
            this.title = paramString;
        }

        public void writeToParcel(Parcel paramParcel, int paramInt) {
            paramParcel.writeString(this.event);
            paramParcel.writeString(this.link);
            paramParcel.writeString(this.jumpButtonTitle);
            paramParcel.writeString(this.jump);
            paramParcel.writeString(this.showingStyle);
            paramParcel.writeLong(this.expireDuration);
            paramParcel.writeString(this.msgDescription);
            paramParcel.writeString(this.title);
            paramParcel.writeLong(this.endTime);
            paramParcel.writeInt(this.level);
            paramParcel.writeInt(this.id);
            paramParcel.writeLong(this.localTime);
        }
    }

    static class PushData
            implements Parcelable {
        public static final Parcelable.Creator<PushData> CREATOR = new Parcelable.Creator() {
            public PushMessageEntity.PushData createFromParcel(Parcel paramAnonymousParcel) {
                return new PushMessageEntity.PushData(paramAnonymousParcel);
            }

            public PushMessageEntity.PushData[] newArray(int paramAnonymousInt) {
                return new PushMessageEntity.PushData[paramAnonymousInt];
            }
        };
        List<PushMessageEntity.MessageEntity> list;
        private int vitality;

        public PushData() {
        }

        public PushData(Parcel paramParcel) {
            this.vitality = paramParcel.readInt();
            this.list = new ArrayList();
            paramParcel.readList(this.list, null);
        }

        public int describeContents() {
            return 0;
        }

        public List<PushMessageEntity.MessageEntity> getList() {
            return this.list;
        }

        public int getVitality() {
            return this.vitality;
        }

        public void setList(List<PushMessageEntity.MessageEntity> paramList) {
            this.list = paramList;
        }

        public void setVitality(int paramInt) {
            this.vitality = paramInt;
        }

        public void writeToParcel(Parcel paramParcel, int paramInt) {
            paramParcel.writeInt(this.vitality);
            paramParcel.writeList(this.list);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/push/PushMessageEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */