package org.b.f;

import java.nio.ByteBuffer;

import org.b.c;

abstract class b
        implements org.b.b.b {
    private final String a;

    b(String paramString) {
        this.a = paramString;
    }

    void a() {
        throw new c(String.format("Expected %s, but got raw value", new Object[]{this.a}));
    }

    void a(byte paramByte) {
        throw new c(String.format("Expected %s, but got integer value", new Object[]{this.a}));
    }

    void a(double paramDouble) {
        throw new c(String.format("Expected %s, but got float value", new Object[]{this.a}));
    }

    void a(float paramFloat) {
        throw new c(String.format("Expected %s, but got float value", new Object[]{this.a}));
    }

    void a(int paramInt) {
        throw new c(String.format("Expected %s, but got integer value", new Object[]{this.a}));
    }

    void a(long paramLong) {
        throw new c(String.format("Expected %s, but got integer value", new Object[]{this.a}));
    }

    public void a(ByteBuffer paramByteBuffer, boolean paramBoolean) {
        throw new c(String.format("Expected %s, but got raw value", new Object[]{this.a}));
    }

    void a(short paramShort) {
        throw new c(String.format("Expected %s, but got integer value", new Object[]{this.a}));
    }

    void a(boolean paramBoolean) {
        throw new c(String.format("Expected %s, but got boolean", new Object[]{this.a}));
    }

    void a(byte[] paramArrayOfByte) {
        throw new c(String.format("Expected %s, but got raw value", new Object[]{this.a}));
    }

    void b() {
        throw new c(String.format("Expected %s, but got nil value", new Object[]{this.a}));
    }

    void b(byte paramByte) {
        throw new c(String.format("Expected %s, but got integer value", new Object[]{this.a}));
    }

    void b(int paramInt) {
        throw new c(String.format("Expected %s, but got integer value", new Object[]{this.a}));
    }

    void b(long paramLong) {
        throw new c(String.format("Expected %s, but got integer value", new Object[]{this.a}));
    }

    void b(short paramShort) {
        throw new c(String.format("Expected %s, but got integer value", new Object[]{this.a}));
    }

    void c(int paramInt) {
        throw new c(String.format("Expected %s, but got array value", new Object[]{this.a}));
    }

    void d(int paramInt) {
        throw new c(String.format("Expected %s, but got map value", new Object[]{this.a}));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/f/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */