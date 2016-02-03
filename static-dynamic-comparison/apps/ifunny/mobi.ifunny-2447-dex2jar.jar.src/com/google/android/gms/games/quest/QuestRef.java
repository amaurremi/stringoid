package com.google.android.gms.games.quest;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.f;
import com.google.android.gms.games.Game;

import java.util.ArrayList;
import java.util.List;

public final class QuestRef
        extends f
        implements Quest {
    private final Game c;
    private final int d;

    public String B_() {
        return e("external_quest_id");
    }

    public String c() {
        return e("quest_name");
    }

    public String d() {
        return e("quest_description");
    }

    public int describeContents() {
        return 0;
    }

    public Uri e() {
        return h("quest_banner_image_uri");
    }

    public boolean equals(Object paramObject) {
        return QuestEntity.a(this, paramObject);
    }

    public String f() {
        return e("quest_banner_image_url");
    }

    public Uri g() {
        return h("quest_icon_image_uri");
    }

    public String h() {
        return e("quest_icon_image_url");
    }

    public int hashCode() {
        return QuestEntity.a(this);
    }

    public List<Milestone> i() {
        ArrayList localArrayList = new ArrayList(this.d);
        int i = 0;
        while (i < this.d) {
            localArrayList.add(new MilestoneRef(this.a, this.b + i));
            i += 1;
        }
        return localArrayList;
    }

    public Game j() {
        return this.c;
    }

    public int k() {
        return c("quest_state");
    }

    public int l() {
        return c("quest_type");
    }

    public long m() {
        return b("accepted_ts");
    }

    public long n() {
        return b("quest_end_ts");
    }

    public long o() {
        return b("quest_last_updated_ts");
    }

    public long p() {
        return b("notification_ts");
    }

    public long q() {
        return b("quest_start_ts");
    }

    public Quest r() {
        return new QuestEntity(this);
    }

    public String toString() {
        return QuestEntity.b(this);
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        ((QuestEntity) r()).writeToParcel(paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/quest/QuestRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */