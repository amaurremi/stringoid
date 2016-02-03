package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.kn;
import com.google.android.gms.internal.ko;
import com.google.android.gms.internal.kp;
import com.google.android.gms.internal.ks;
import com.google.android.gms.internal.kt;

import java.io.IOException;
import java.util.List;

public final class y
        extends kp<y> {
    public String FC;
    public long FD;
    public long FE;
    public int versionCode;

    public y() {
        fH();
    }

    public static y g(byte[] paramArrayOfByte)
            throws ks {
        return (y) kt.a(new y(), paramArrayOfByte);
    }

    public void a(ko paramko)
            throws IOException {
        paramko.i(1, this.versionCode);
        paramko.b(2, this.FC);
        paramko.c(3, this.FD);
        paramko.c(4, this.FE);
        super.a(paramko);
    }

    public int c() {
        int i = super.c() + ko.j(1, this.versionCode) + ko.g(2, this.FC) + ko.e(3, this.FD) + ko.e(4, this.FE);
        this.adY = i;
        return i;
    }

    public boolean equals(Object paramObject) {
        boolean bool2 = false;
        boolean bool1;
        if (paramObject == this) {
            bool1 = true;
        }
        do {
            do {
                do {
                    return bool1;
                    bool1 = bool2;
                } while (!(paramObject instanceof y));
                paramObject = (y) paramObject;
                bool1 = bool2;
            } while (this.versionCode != ((y) paramObject).versionCode);
            if (this.FC != null) {
                break;
            }
            bool1 = bool2;
        } while (((y) paramObject).FC != null);
        while (this.FC.equals(((y) paramObject).FC)) {
            bool1 = bool2;
            if (this.FD != ((y) paramObject).FD) {
                break;
            }
            bool1 = bool2;
            if (this.FE != ((y) paramObject).FE) {
                break;
            }
            if ((this.adU != null) && (!this.adU.isEmpty())) {
                break label140;
            }
            if (((y) paramObject).adU != null) {
                bool1 = bool2;
                if (!((y) paramObject).adU.isEmpty()) {
                    break;
                }
            }
            return true;
        }
        return false;
        label140:
        return this.adU.equals(((y) paramObject).adU);
    }

    public y fH() {
        this.versionCode = 1;
        this.FC = "";
        this.FD = -1L;
        this.FE = -1L;
        this.adU = null;
        this.adY = -1;
        return this;
    }

    public int hashCode() {
        int k = 0;
        int m = this.versionCode;
        int i;
        int n;
        int i1;
        if (this.FC == null) {
            i = 0;
            n = (int) (this.FD ^ this.FD >>> 32);
            i1 = (int) (this.FE ^ this.FE >>> 32);
            j = k;
            if (this.adU != null) {
                if (!this.adU.isEmpty()) {
                    break label110;
                }
            }
        }
        label110:
        for (int j = k; ; j = this.adU.hashCode()) {
            return (((i + (m + 527) * 31) * 31 + n) * 31 + i1) * 31 + j;
            i = this.FC.hashCode();
            break;
        }
    }

    public y m(kn paramkn)
            throws IOException {
        for (; ; ) {
            int i = paramkn.mh();
            switch (i) {
                default:
                    if (a(paramkn, i)) {
                    }
                    break;
                case 0:
                    return this;
                case 8:
                    this.versionCode = paramkn.mk();
                    break;
                case 18:
                    this.FC = paramkn.readString();
                    break;
                case 24:
                    this.FD = paramkn.mm();
                    break;
                case 32:
                    this.FE = paramkn.mm();
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/drive/internal/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */