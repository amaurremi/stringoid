package com.umeng.a.a.a.b;

public class k {
    private static int a = Integer.MAX_VALUE;

    public static j a(byte[] paramArrayOfByte, j paramj) {
        Object localObject;
        if (paramArrayOfByte[0] > 16) {
            localObject = new b.a();
        }
        do {
            do {
                return (j) localObject;
                localObject = paramj;
            } while (paramArrayOfByte.length <= 1);
            localObject = paramj;
        } while ((paramArrayOfByte[1] & 0x80) == 0);
        return new b.a();
    }

    public static void a(int paramInt) {
        a = paramInt;
    }

    public static void a(h paramh, byte paramByte)
            throws com.umeng.a.a.a.j {
        a(paramh, paramByte, a);
    }

    public static void a(h paramh, byte paramByte, int paramInt)
            throws com.umeng.a.a.a.j {
        byte b2 = 0;
        byte b3 = 0;
        byte b1 = 0;
        if (paramInt <= 0) {
            throw new com.umeng.a.a.a.j("Maximum skip depth exceeded");
        }
        switch (paramByte) {
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 2:
                paramh.t();
                return;
            case 3:
                paramh.u();
                return;
            case 6:
                paramh.v();
                return;
            case 8:
                paramh.w();
                return;
            case 10:
                paramh.x();
                return;
            case 4:
                paramh.y();
                return;
            case 11:
                paramh.A();
                return;
            case 12:
                paramh.j();
                for (; ; ) {
                    localObject = paramh.l();
                    if (((c) localObject).b == 0) {
                        paramh.k();
                        return;
                    }
                    a(paramh, ((c) localObject).b, paramInt - 1);
                    paramh.m();
                }
            case 13:
                localObject = paramh.n();
                paramByte = b1;
                while (paramByte < ((e) localObject).c) {
                    a(paramh, ((e) localObject).a, paramInt - 1);
                    a(paramh, ((e) localObject).b, paramInt - 1);
                    paramByte += 1;
                }
                paramh.o();
                return;
            case 14:
                localObject = paramh.r();
                paramByte = b2;
                while (paramByte < ((l) localObject).b) {
                    a(paramh, ((l) localObject).a, paramInt - 1);
                    paramByte += 1;
                }
                paramh.s();
                return;
        }
        Object localObject = paramh.p();
        paramByte = b3;
        while (paramByte < ((d) localObject).b) {
            a(paramh, ((d) localObject).a, paramInt - 1);
            paramByte += 1;
        }
        paramh.q();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/a/a/a/b/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */