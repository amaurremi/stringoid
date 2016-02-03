package com.google.android.gms.internal;

import java.io.IOException;
import java.util.List;

public abstract interface it {
    public static final class a
            extends kp<a> {
        public long aaY;
        public c.j aaZ;
        public c.f fK;

        public a() {
            lV();
        }

        public static a l(byte[] paramArrayOfByte)
                throws ks {
            return (a) kt.a(new a(), paramArrayOfByte);
        }

        public void a(ko paramko)
                throws IOException {
            paramko.b(1, this.aaY);
            if (this.fK != null) {
                paramko.a(2, this.fK);
            }
            if (this.aaZ != null) {
                paramko.a(3, this.aaZ);
            }
            super.a(paramko);
        }

        public int c() {
            int j = super.c() + ko.d(1, this.aaY);
            int i = j;
            if (this.fK != null) {
                i = j + ko.b(2, this.fK);
            }
            j = i;
            if (this.aaZ != null) {
                j = i + ko.b(3, this.aaZ);
            }
            this.adY = j;
            return j;
        }

        public boolean equals(Object paramObject) {
            boolean bool2 = false;
            boolean bool1;
            if (paramObject == this) {
                bool1 = true;
            }
            label55:
            do {
                do {
                    do {
                        do {
                            return bool1;
                            bool1 = bool2;
                        } while (!(paramObject instanceof a));
                        paramObject = (a) paramObject;
                        bool1 = bool2;
                    } while (this.aaY != ((a) paramObject).aaY);
                    if (this.fK != null) {
                        break;
                    }
                    bool1 = bool2;
                } while (((a) paramObject).fK != null);
                if (this.aaZ != null) {
                    break label129;
                }
                bool1 = bool2;
            } while (((a) paramObject).aaZ != null);
            for (; ; ) {
                if ((this.adU == null) || (this.adU.isEmpty())) {
                    if (((a) paramObject).adU != null) {
                        bool1 = bool2;
                        if (!((a) paramObject).adU.isEmpty()) {
                            break;
                        }
                    }
                    return true;
                    if (this.fK.equals(((a) paramObject).fK)) {
                        break label55;
                    }
                    return false;
                    label129:
                    if (!this.aaZ.equals(((a) paramObject).aaZ)) {
                        return false;
                    }
                }
            }
            return this.adU.equals(((a) paramObject).adU);
        }

        public int hashCode() {
            int m = 0;
            int n = (int) (this.aaY ^ this.aaY >>> 32);
            int i;
            int j;
            if (this.fK == null) {
                i = 0;
                if (this.aaZ != null) {
                    break label94;
                }
                j = 0;
                label36:
                k = m;
                if (this.adU != null) {
                    if (!this.adU.isEmpty()) {
                        break label105;
                    }
                }
            }
            label94:
            label105:
            for (int k = m; ; k = this.adU.hashCode()) {
                return (j + (i + (n + 527) * 31) * 31) * 31 + k;
                i = this.fK.hashCode();
                break;
                j = this.aaZ.hashCode();
                break label36;
            }
        }

        public a lV() {
            this.aaY = 0L;
            this.fK = null;
            this.aaZ = null;
            this.adU = null;
            this.adY = -1;
            return this;
        }

        public a n(kn paramkn)
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
                        this.aaY = paramkn.mj();
                        break;
                    case 18:
                        if (this.fK == null) {
                            this.fK = new c.f();
                        }
                        paramkn.a(this.fK);
                        break;
                    case 26:
                        if (this.aaZ == null) {
                            this.aaZ = new c.j();
                        }
                        paramkn.a(this.aaZ);
                }
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/it.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */