package com.flurry.sdk;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class aq {
    String a;
    ay b;
    long c;
    long d;
    ar e;
    long f;
    long g;

    public aq(DataInput paramDataInput)
            throws IOException {
        this.a = paramDataInput.readUTF();
        this.b = ay.a(paramDataInput.readInt());
        this.c = paramDataInput.readLong();
        this.d = paramDataInput.readLong();
        this.e = ar.a(paramDataInput.readInt());
        this.f = paramDataInput.readLong();
        this.g = paramDataInput.readLong();
    }

    public aq(String paramString, ay paramay, long paramLong) {
        this.a = paramString;
        this.b = paramay;
        this.c = System.currentTimeMillis();
        this.d = System.currentTimeMillis();
        this.e = ar.a;
        this.f = paramLong;
        this.g = -1L;
    }

    public String a() {
        return this.a;
    }

    public void a(long paramLong) {
        try {
            this.g = paramLong;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void a(ar paramar) {
        try {
            this.e = paramar;
            return;
        } finally {
            paramar =finally;
            throw paramar;
        }
    }

    public void a(DataOutput paramDataOutput)
            throws IOException {
        paramDataOutput.writeUTF(this.a);
        paramDataOutput.writeInt(this.b.a());
        paramDataOutput.writeLong(this.c);
        paramDataOutput.writeLong(this.d);
        paramDataOutput.writeInt(this.e.a());
        paramDataOutput.writeLong(this.f);
        paramDataOutput.writeLong(this.g);
    }

    public ar b() {
        try {
            ar localar = this.e;
            return localar;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public long c() {
        return this.f;
    }

    public boolean d() {
        return (this.f > 0L) && (System.currentTimeMillis() > this.f);
    }

    public void e() {
        try {
            this.d = System.currentTimeMillis();
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public long f() {
        return this.c;
    }

    public String toString() {
        return "url: " + this.a + ", type:" + this.b + ", creation:" + this.c + ", accessed:" + this.d + ", status: " + this.e + ", expiration: " + this.f + ", size: " + this.g;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */