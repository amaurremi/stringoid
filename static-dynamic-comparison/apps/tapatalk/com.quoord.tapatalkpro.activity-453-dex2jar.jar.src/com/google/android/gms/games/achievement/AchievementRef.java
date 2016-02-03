package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.b;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import com.google.android.gms.internal.fb;
import com.google.android.gms.internal.fo;
import com.google.android.gms.internal.fo.a;

public final class AchievementRef
        extends b
        implements Achievement {
    AchievementRef(DataHolder paramDataHolder, int paramInt) {
        super(paramDataHolder, paramInt);
    }

    public String getAchievementId() {
        return getString("external_achievement_id");
    }

    public int getCurrentSteps() {
        boolean bool = true;
        if (getType() == 1) {
        }
        for (; ; ) {
            fb.x(bool);
            return getInteger("current_steps");
            bool = false;
        }
    }

    public String getDescription() {
        return getString("description");
    }

    public void getDescription(CharArrayBuffer paramCharArrayBuffer) {
        a("description", paramCharArrayBuffer);
    }

    public String getFormattedCurrentSteps() {
        boolean bool = true;
        if (getType() == 1) {
        }
        for (; ; ) {
            fb.x(bool);
            return getString("formatted_current_steps");
            bool = false;
        }
    }

    public void getFormattedCurrentSteps(CharArrayBuffer paramCharArrayBuffer) {
        boolean bool = true;
        if (getType() == 1) {
        }
        for (; ; ) {
            fb.x(bool);
            a("formatted_current_steps", paramCharArrayBuffer);
            return;
            bool = false;
        }
    }

    public String getFormattedTotalSteps() {
        boolean bool = true;
        if (getType() == 1) {
        }
        for (; ; ) {
            fb.x(bool);
            return getString("formatted_total_steps");
            bool = false;
        }
    }

    public void getFormattedTotalSteps(CharArrayBuffer paramCharArrayBuffer) {
        boolean bool = true;
        if (getType() == 1) {
        }
        for (; ; ) {
            fb.x(bool);
            a("formatted_total_steps", paramCharArrayBuffer);
            return;
            bool = false;
        }
    }

    public long getLastUpdatedTimestamp() {
        return getLong("last_updated_timestamp");
    }

    public String getName() {
        return getString("name");
    }

    public void getName(CharArrayBuffer paramCharArrayBuffer) {
        a("name", paramCharArrayBuffer);
    }

    public Player getPlayer() {
        return new PlayerRef(this.BB, this.BD);
    }

    public Uri getRevealedImageUri() {
        return ah("revealed_icon_image_uri");
    }

    public String getRevealedImageUrl() {
        return getString("revealed_icon_image_url");
    }

    public int getState() {
        return getInteger("state");
    }

    public int getTotalSteps() {
        boolean bool = true;
        if (getType() == 1) {
        }
        for (; ; ) {
            fb.x(bool);
            return getInteger("total_steps");
            bool = false;
        }
    }

    public int getType() {
        return getInteger("type");
    }

    public Uri getUnlockedImageUri() {
        return ah("unlocked_icon_image_uri");
    }

    public String getUnlockedImageUrl() {
        return getString("unlocked_icon_image_url");
    }

    public String toString() {
        fo.a locala = fo.e(this).a("AchievementId", getAchievementId()).a("Type", Integer.valueOf(getType())).a("Name", getName()).a("Description", getDescription()).a("UnlockedImageUri", getUnlockedImageUri()).a("UnlockedImageUrl", getUnlockedImageUrl()).a("RevealedImageUri", getRevealedImageUri()).a("RevealedImageUrl", getRevealedImageUrl()).a("Player", getPlayer()).a("LastUpdatedTimeStamp", Long.valueOf(getLastUpdatedTimestamp()));
        if (getType() == 1) {
            locala.a("CurrentSteps", Integer.valueOf(getCurrentSteps()));
            locala.a("TotalSteps", Integer.valueOf(getTotalSteps()));
        }
        return locala.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/games/achievement/AchievementRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */