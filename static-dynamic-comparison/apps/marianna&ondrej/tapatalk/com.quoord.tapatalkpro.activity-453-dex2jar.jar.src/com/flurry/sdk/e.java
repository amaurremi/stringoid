package com.flurry.sdk;

import android.text.TextUtils;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class e {
    private static int a = 1;
    private final int b;
    private final long c;
    private final String d;
    private List<c> e;

    public e(long paramLong1, String paramString, long paramLong2) {
        int i = a;
        a = i + 1;
        this.b = i;
        this.c = paramLong1;
        this.d = paramString;
        this.e = new ArrayList();
    }

    public e(DataInput paramDataInput)
            throws IOException {
        this.b = paramDataInput.readInt();
        this.c = paramDataInput.readLong();
        String str2 = paramDataInput.readUTF();
        String str1 = str2;
        if (str2.equals("")) {
            str1 = null;
        }
        this.d = str1;
        this.e = new ArrayList();
        int j = paramDataInput.readShort();
        for (int i = 0; i < j; i = (short) (i + 1)) {
            this.e.add(new c(paramDataInput));
        }
    }

    public int a() {
        return this.b;
    }

    public void a(c paramc) {
        this.e.add(paramc);
    }

    public void a(DataOutput paramDataOutput)
            throws IOException {
        paramDataOutput.writeInt(this.b);
        paramDataOutput.writeLong(this.c);
        if (this.d == null) {
        }
        for (Object localObject = ""; ; localObject = this.d) {
            paramDataOutput.writeUTF((String) localObject);
            paramDataOutput.writeShort(this.e.size());
            localObject = this.e.iterator();
            while (((Iterator) localObject).hasNext()) {
                ((c) ((Iterator) localObject).next()).a(paramDataOutput);
            }
        }
    }

    public String b() {
        return this.d;
    }

    public long c() {
        return this.c;
    }

    public List<c> d() {
        return this.e;
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            return true;
            if (!(paramObject instanceof e)) {
                return false;
            }
            paramObject = (e) paramObject;
        }
        while ((this.b == ((e) paramObject).b) && (this.c == ((e) paramObject).c) && (TextUtils.equals(this.d, ((e) paramObject).d)) && ((this.e == ((e) paramObject).e) || ((this.e != null) && (this.e.equals(((e) paramObject).e)))));
        return false;
    }

    public int hashCode() {
        int j = (int) (0x11 | this.b | this.c);
        int i = j;
        if (this.d != null) {
            i = j | this.d.hashCode();
        }
        j = i;
        if (this.e != null) {
            j = i | this.e.hashCode();
        }
        return j;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */