package com.google.android.gms.internal;

import android.os.Bundle;

public class dk {
    private final Object li = new Object();
    private final String qL;
    private int qQ = 0;
    private long qR = -1L;
    private long qS = -1L;
    private int qT = 0;
    private int qU = -1;

    public dk(String paramString) {
        this.qL = paramString;
    }

    public void b(ah paramah, long paramLong) {
        synchronized (this.li) {
            if (this.qS == -1L) {
                this.qS = paramLong;
                this.qR = this.qS;
                if ((paramah.extras == null) || (paramah.extras.getInt("gw", 2) != 1)) {
                }
            } else {
                this.qR = paramLong;
            }
        }
        this.qU += 1;
    }

    public void bk() {
        synchronized (this.li) {
            this.qT += 1;
            return;
        }
    }

    public void bl() {
        synchronized (this.li) {
            this.qQ += 1;
            return;
        }
    }

    public long bw() {
        return this.qS;
    }

    public Bundle q(String paramString) {
        synchronized (this.li) {
            Bundle localBundle = new Bundle();
            localBundle.putString("session_id", this.qL);
            localBundle.putLong("basets", this.qS);
            localBundle.putLong("currts", this.qR);
            localBundle.putString("seq_num", paramString);
            localBundle.putInt("preqs", this.qU);
            localBundle.putInt("pclick", this.qQ);
            localBundle.putInt("pimp", this.qT);
            return localBundle;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/dk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */