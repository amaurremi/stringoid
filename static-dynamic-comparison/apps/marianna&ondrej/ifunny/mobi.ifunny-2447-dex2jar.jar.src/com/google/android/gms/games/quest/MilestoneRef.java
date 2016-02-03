package com.google.android.gms.games.quest;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.f;

public final class MilestoneRef
        extends f
        implements Milestone {
    MilestoneRef(DataHolder paramDataHolder, int paramInt) {
        super(paramDataHolder, paramInt);
    }

    private long i() {
        return b("initial_value");
    }

    public String A_() {
        return e("external_milestone_id");
    }

    public long c() {
        switch (e()) {
            case 1:
            default:
                return 0L;
            case 3:
            case 4:
                return f();
        }
        return b("current_value") - i();
    }

    public String d() {
        return e("external_event_id");
    }

    public int describeContents() {
        return 0;
    }

    public int e() {
        return c("milestone_state");
    }

    public boolean equals(Object paramObject) {
        return MilestoneEntity.a(this, paramObject);
    }

    public long f() {
        return b("target_value");
    }

    public byte[] g() {
        return g("completion_reward_data");
    }

    public Milestone h() {
        return new MilestoneEntity(this);
    }

    public int hashCode() {
        return MilestoneEntity.a(this);
    }

    public String toString() {
        return MilestoneEntity.b(this);
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        ((MilestoneEntity) h()).writeToParcel(paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/quest/MilestoneRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */