package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.f;

public final class GameBadgeRef
        extends f
        implements GameBadge {
    GameBadgeRef(DataHolder paramDataHolder, int paramInt) {
        super(paramDataHolder, paramInt);
    }

    public int describeContents() {
        return 0;
    }

    public Uri e() {
        return h("badge_icon_image_uri");
    }

    public boolean equals(Object paramObject) {
        return GameBadgeEntity.a(this, paramObject);
    }

    public GameBadge f() {
        return new GameBadgeEntity(this);
    }

    public int hashCode() {
        return GameBadgeEntity.a(this);
    }

    public int o_() {
        return c("badge_type");
    }

    public String p_() {
        return e("badge_title");
    }

    public String q_() {
        return e("badge_description");
    }

    public String toString() {
        return GameBadgeEntity.b(this);
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        ((GameBadgeEntity) f()).writeToParcel(paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/internal/game/GameBadgeRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */