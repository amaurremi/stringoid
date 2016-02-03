package com.google.android.gms.games.internal.notification;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.b;
import com.google.android.gms.internal.fo;
import com.google.android.gms.internal.fo.a;

public final class GameNotificationRef
        extends b
        implements GameNotification {
    GameNotificationRef(DataHolder paramDataHolder, int paramInt) {
        super(paramDataHolder, paramInt);
    }

    public long getId() {
        return getLong("_id");
    }

    public String getText() {
        return getString("text");
    }

    public String getTitle() {
        return getString("title");
    }

    public int getType() {
        return getInteger("type");
    }

    public String hp() {
        return getString("notification_id");
    }

    public String hq() {
        return getString("ticker");
    }

    public String hr() {
        return getString("coalesced_text");
    }

    public boolean hs() {
        return getInteger("acknowledged") > 0;
    }

    public boolean ht() {
        return getInteger("alert_level") == 0;
    }

    public String toString() {
        return fo.e(this).a("Id", Long.valueOf(getId())).a("NotificationId", hp()).a("Type", Integer.valueOf(getType())).a("Title", getTitle()).a("Ticker", hq()).a("Text", getText()).a("CoalescedText", hr()).a("isAcknowledged", Boolean.valueOf(hs())).a("isSilent", Boolean.valueOf(ht())).toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/games/internal/notification/GameNotificationRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */