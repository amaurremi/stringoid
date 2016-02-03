package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.b;

public final class PlayerRef
        extends b
        implements Player {
    private final PlayerColumnNames Ii;

    public PlayerRef(DataHolder paramDataHolder, int paramInt) {
        this(paramDataHolder, paramInt, null);
    }

    public PlayerRef(DataHolder paramDataHolder, int paramInt, String paramString) {
        super(paramDataHolder, paramInt);
        this.Ii = new PlayerColumnNames(paramString);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        return PlayerEntity.a(this, paramObject);
    }

    public Player freeze() {
        return new PlayerEntity(this);
    }

    public String getDisplayName() {
        return getString(this.Ii.Ik);
    }

    public void getDisplayName(CharArrayBuffer paramCharArrayBuffer) {
        a(this.Ii.Ik, paramCharArrayBuffer);
    }

    public Uri getHiResImageUri() {
        return ah(this.Ii.In);
    }

    public String getHiResImageUrl() {
        return getString(this.Ii.Io);
    }

    public Uri getIconImageUri() {
        return ah(this.Ii.Il);
    }

    public String getIconImageUrl() {
        return getString(this.Ii.Im);
    }

    public long getLastPlayedWithTimestamp() {
        if (!hasColumn(this.Ii.Ir)) {
            return -1L;
        }
        return getLong(this.Ii.Ir);
    }

    public String getPlayerId() {
        return getString(this.Ii.Ij);
    }

    public long getRetrievedTimestamp() {
        return getLong(this.Ii.Ip);
    }

    public int gh() {
        return getInteger(this.Ii.Iq);
    }

    public boolean hasHiResImage() {
        return getHiResImageUri() != null;
    }

    public boolean hasIconImage() {
        return getIconImageUri() != null;
    }

    public int hashCode() {
        return PlayerEntity.a(this);
    }

    public String toString() {
        return PlayerEntity.b(this);
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        ((PlayerEntity) freeze()).writeToParcel(paramParcel, paramInt);
    }

    private static final class PlayerColumnNames {
        public final String Ij;
        public final String Ik;
        public final String Il;
        public final String Im;
        public final String In;
        public final String Io;
        public final String Ip;
        public final String Iq;
        public final String Ir;

        public PlayerColumnNames(String paramString) {
            if (TextUtils.isEmpty(paramString)) {
                this.Ij = "external_player_id";
                this.Ik = "profile_name";
                this.Il = "profile_icon_image_uri";
                this.Im = "profile_icon_image_url";
                this.In = "profile_hi_res_image_uri";
                this.Io = "profile_hi_res_image_url";
                this.Ip = "last_updated";
                this.Iq = "is_in_circles";
                this.Ir = "played_with_timestamp";
                return;
            }
            this.Ij = (paramString + "external_player_id");
            this.Ik = (paramString + "profile_name");
            this.Il = (paramString + "profile_icon_image_uri");
            this.Im = (paramString + "profile_icon_image_url");
            this.In = (paramString + "profile_hi_res_image_uri");
            this.Io = (paramString + "profile_hi_res_image_url");
            this.Ip = (paramString + "last_updated");
            this.Iq = (paramString + "is_in_circles");
            this.Ir = (paramString + "played_with_timestamp");
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/games/PlayerRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */