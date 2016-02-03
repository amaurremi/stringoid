package com.google.android.gms.internal;

import com.google.android.gms.ads.mediation.MediationAdRequest;

import java.util.Date;
import java.util.Set;

public final class bt
        implements MediationAdRequest {
    private final Date d;
    private final Set<String> f;
    private final boolean g;
    private final int lZ;
    private final int nD;

    public bt(Date paramDate, int paramInt1, Set<String> paramSet, boolean paramBoolean, int paramInt2) {
        this.d = paramDate;
        this.lZ = paramInt1;
        this.f = paramSet;
        this.g = paramBoolean;
        this.nD = paramInt2;
    }

    public Date getBirthday() {
        return this.d;
    }

    public int getGender() {
        return this.lZ;
    }

    public Set<String> getKeywords() {
        return this.f;
    }

    public boolean isTesting() {
        return this.g;
    }

    public int taggedForChildDirectedTreatment() {
        return this.nD;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */