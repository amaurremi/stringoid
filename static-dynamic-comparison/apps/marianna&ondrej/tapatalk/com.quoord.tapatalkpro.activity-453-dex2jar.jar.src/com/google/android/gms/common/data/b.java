package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.internal.fo;
import com.google.android.gms.internal.fq;

public abstract class b {
    protected final DataHolder BB;
    protected final int BD;
    private final int BE;

    public b(DataHolder paramDataHolder, int paramInt) {
        this.BB = ((DataHolder) fq.f(paramDataHolder));
        if ((paramInt >= 0) && (paramInt < paramDataHolder.getCount())) {
        }
        for (boolean bool = true; ; bool = false) {
            fq.x(bool);
            this.BD = paramInt;
            this.BE = paramDataHolder.G(this.BD);
            return;
        }
    }

    protected void a(String paramString, CharArrayBuffer paramCharArrayBuffer) {
        this.BB.copyToBuffer(paramString, this.BD, this.BE, paramCharArrayBuffer);
    }

    protected Uri ah(String paramString) {
        return this.BB.parseUri(paramString, this.BD, this.BE);
    }

    protected boolean ai(String paramString) {
        return this.BB.hasNull(paramString, this.BD, this.BE);
    }

    public boolean equals(Object paramObject) {
        boolean bool2 = false;
        boolean bool1 = bool2;
        if ((paramObject instanceof b)) {
            paramObject = (b) paramObject;
            bool1 = bool2;
            if (fo.equal(Integer.valueOf(((b) paramObject).BD), Integer.valueOf(this.BD))) {
                bool1 = bool2;
                if (fo.equal(Integer.valueOf(((b) paramObject).BE), Integer.valueOf(this.BE))) {
                    bool1 = bool2;
                    if (((b) paramObject).BB == this.BB) {
                        bool1 = true;
                    }
                }
            }
        }
        return bool1;
    }

    protected boolean getBoolean(String paramString) {
        return this.BB.getBoolean(paramString, this.BD, this.BE);
    }

    protected byte[] getByteArray(String paramString) {
        return this.BB.getByteArray(paramString, this.BD, this.BE);
    }

    protected int getInteger(String paramString) {
        return this.BB.getInteger(paramString, this.BD, this.BE);
    }

    protected long getLong(String paramString) {
        return this.BB.getLong(paramString, this.BD, this.BE);
    }

    protected String getString(String paramString) {
        return this.BB.getString(paramString, this.BD, this.BE);
    }

    public boolean hasColumn(String paramString) {
        return this.BB.hasColumn(paramString);
    }

    public int hashCode() {
        return fo.hashCode(new Object[]{Integer.valueOf(this.BD), Integer.valueOf(this.BE), this.BB});
    }

    public boolean isDataValid() {
        return !this.BB.isClosed();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/common/data/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */