package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.fb;
import com.google.android.gms.internal.fo;
import com.google.android.gms.internal.fo.a;
import com.google.android.gms.internal.gm;

public final class PlayerEntity
        extends GamesDowngradeableSafeParcel
        implements Player {
    public static final Parcelable.Creator<PlayerEntity> CREATOR = new PlayerEntityCreatorCompat();
    private final String HA;
    private final Uri HF;
    private final Uri HG;
    private final String HQ;
    private final String HR;
    private final String Ie;
    private final long If;
    private final int Ig;
    private final long Ih;
    private final int xH;

    PlayerEntity(int paramInt1, String paramString1, String paramString2, Uri paramUri1, Uri paramUri2, long paramLong1, int paramInt2, long paramLong2, String paramString3, String paramString4) {
        this.xH = paramInt1;
        this.Ie = paramString1;
        this.HA = paramString2;
        this.HF = paramUri1;
        this.HQ = paramString3;
        this.HG = paramUri2;
        this.HR = paramString4;
        this.If = paramLong1;
        this.Ig = paramInt2;
        this.Ih = paramLong2;
    }

    public PlayerEntity(Player paramPlayer) {
        this.xH = 4;
        this.Ie = paramPlayer.getPlayerId();
        this.HA = paramPlayer.getDisplayName();
        this.HF = paramPlayer.getIconImageUri();
        this.HQ = paramPlayer.getIconImageUrl();
        this.HG = paramPlayer.getHiResImageUri();
        this.HR = paramPlayer.getHiResImageUrl();
        this.If = paramPlayer.getRetrievedTimestamp();
        this.Ig = paramPlayer.gh();
        this.Ih = paramPlayer.getLastPlayedWithTimestamp();
        fb.d(this.Ie);
        fb.d(this.HA);
        if (this.If > 0L) {
        }
        for (boolean bool = true; ; bool = false) {
            fb.x(bool);
            return;
        }
    }

    static int a(Player paramPlayer) {
        return fo.hashCode(new Object[]{paramPlayer.getPlayerId(), paramPlayer.getDisplayName(), paramPlayer.getIconImageUri(), paramPlayer.getHiResImageUri(), Long.valueOf(paramPlayer.getRetrievedTimestamp())});
    }

    static boolean a(Player paramPlayer, Object paramObject) {
        boolean bool2 = true;
        boolean bool1;
        if (!(paramObject instanceof Player)) {
            bool1 = false;
        }
        do {
            do {
                return bool1;
                bool1 = bool2;
            } while (paramPlayer == paramObject);
            paramObject = (Player) paramObject;
            if ((!fo.equal(((Player) paramObject).getPlayerId(), paramPlayer.getPlayerId())) || (!fo.equal(((Player) paramObject).getDisplayName(), paramPlayer.getDisplayName())) || (!fo.equal(((Player) paramObject).getIconImageUri(), paramPlayer.getIconImageUri())) || (!fo.equal(((Player) paramObject).getHiResImageUri(), paramPlayer.getHiResImageUri()))) {
                break;
            }
            bool1 = bool2;
        }
        while (fo.equal(Long.valueOf(((Player) paramObject).getRetrievedTimestamp()), Long.valueOf(paramPlayer.getRetrievedTimestamp())));
        return false;
    }

    static String b(Player paramPlayer) {
        return fo.e(paramPlayer).a("PlayerId", paramPlayer.getPlayerId()).a("DisplayName", paramPlayer.getDisplayName()).a("IconImageUri", paramPlayer.getIconImageUri()).a("IconImageUrl", paramPlayer.getIconImageUrl()).a("HiResImageUri", paramPlayer.getHiResImageUri()).a("HiResImageUrl", paramPlayer.getHiResImageUrl()).a("RetrievedTimestamp", Long.valueOf(paramPlayer.getRetrievedTimestamp())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        return a(this, paramObject);
    }

    public Player freeze() {
        return this;
    }

    public String getDisplayName() {
        return this.HA;
    }

    public void getDisplayName(CharArrayBuffer paramCharArrayBuffer) {
        gm.b(this.HA, paramCharArrayBuffer);
    }

    public Uri getHiResImageUri() {
        return this.HG;
    }

    public String getHiResImageUrl() {
        return this.HR;
    }

    public Uri getIconImageUri() {
        return this.HF;
    }

    public String getIconImageUrl() {
        return this.HQ;
    }

    public long getLastPlayedWithTimestamp() {
        return this.Ih;
    }

    public String getPlayerId() {
        return this.Ie;
    }

    public long getRetrievedTimestamp() {
        return this.If;
    }

    public int getVersionCode() {
        return this.xH;
    }

    public int gh() {
        return this.Ig;
    }

    public boolean hasHiResImage() {
        return getHiResImageUri() != null;
    }

    public boolean hasIconImage() {
        return getIconImageUri() != null;
    }

    public int hashCode() {
        return a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return b(this);
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        Object localObject2 = null;
        if (!eK()) {
            PlayerEntityCreator.a(this, paramParcel, paramInt);
            return;
        }
        paramParcel.writeString(this.Ie);
        paramParcel.writeString(this.HA);
        if (this.HF == null) {
            localObject1 = null;
            paramParcel.writeString((String) localObject1);
            if (this.HG != null) {
                break label82;
            }
        }
        label82:
        for (Object localObject1 = localObject2; ; localObject1 = this.HG.toString()) {
            paramParcel.writeString((String) localObject1);
            paramParcel.writeLong(this.If);
            return;
            localObject1 = this.HF.toString();
            break;
        }
    }

    static final class PlayerEntityCreatorCompat
            extends PlayerEntityCreator {
        public PlayerEntity ao(Parcel paramParcel) {
            if ((PlayerEntity.b(PlayerEntity.gg())) || (PlayerEntity.az(PlayerEntity.class.getCanonicalName()))) {
                return super.ao(paramParcel);
            }
            String str1 = paramParcel.readString();
            String str2 = paramParcel.readString();
            Object localObject1 = paramParcel.readString();
            Object localObject2 = paramParcel.readString();
            if (localObject1 == null) {
                localObject1 = null;
                if (localObject2 != null) {
                    break label93;
                }
            }
            label93:
            for (localObject2 = null; ; localObject2 = Uri.parse((String) localObject2)) {
                return new PlayerEntity(4, str1, str2, (Uri) localObject1, (Uri) localObject2, paramParcel.readLong(), -1, -1L, null, null);
                localObject1 = Uri.parse((String) localObject1);
                break;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/games/PlayerEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */