package com.google.android.gms.internal;

import java.util.PriorityQueue;

public class ao {
    static long a(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3) {
        return ((paramLong1 + 1073807359L - (paramInt1 + 2147483647L) % 1073807359L * paramLong2 % 1073807359L) % 1073807359L * paramLong3 % 1073807359L + (paramInt2 + 2147483647L) % 1073807359L) % 1073807359L;
    }

    static long a(long paramLong, int paramInt) {
        long l;
        if (paramInt == 0) {
            l = 1L;
        }
        do {
            return l;
            l = paramLong;
        } while (paramInt == 1);
        if (paramInt % 2 == 0) {
            return a(paramLong * paramLong % 1073807359L, paramInt / 2) % 1073807359L;
        }
        return a(paramLong * paramLong % 1073807359L, paramInt / 2) % 1073807359L * paramLong % 1073807359L;
    }

    static String a(String[] paramArrayOfString, int paramInt1, int paramInt2) {
        if (paramArrayOfString.length < paramInt1 + paramInt2) {
            mx.b("Unable to construct shingle");
            return "";
        }
        StringBuffer localStringBuffer = new StringBuffer();
        int i = paramInt1;
        while (i < paramInt1 + paramInt2 - 1) {
            localStringBuffer.append(paramArrayOfString[i]);
            localStringBuffer.append(' ');
            i += 1;
        }
        localStringBuffer.append(paramArrayOfString[(paramInt1 + paramInt2 - 1)]);
        return localStringBuffer.toString();
    }

    private static void a(int paramInt1, long paramLong, int paramInt2, String[] paramArrayOfString, int paramInt3, PriorityQueue<ap> paramPriorityQueue) {
        paramPriorityQueue.add(new ap(paramLong, a(paramArrayOfString, paramInt2, paramInt3)));
        if (paramPriorityQueue.size() > paramInt1) {
            paramPriorityQueue.poll();
        }
    }

    public static void a(String[] paramArrayOfString, int paramInt1, int paramInt2, PriorityQueue<ap> paramPriorityQueue) {
        long l1 = b(paramArrayOfString, 0, paramInt2);
        a(paramInt1, l1, 0, paramArrayOfString, paramInt2, paramPriorityQueue);
        long l2 = a(16785407L, paramInt2 - 1);
        int i = 1;
        while (i < paramArrayOfString.length - paramInt2 + 1) {
            l1 = a(am.a(paramArrayOfString[(i - 1)]), am.a(paramArrayOfString[(i + paramInt2 - 1)]), l1, l2, 16785407L);
            a(paramInt1, l1, i, paramArrayOfString, paramInt2, paramPriorityQueue);
            i += 1;
        }
    }

    private static long b(String[] paramArrayOfString, int paramInt1, int paramInt2) {
        long l = (am.a(paramArrayOfString[paramInt1]) + 2147483647L) % 1073807359L;
        int i = paramInt1 + 1;
        while (i < paramInt1 + paramInt2) {
            l = (l * 16785407L % 1073807359L + (am.a(paramArrayOfString[i]) + 2147483647L) % 1073807359L) % 1073807359L;
            i += 1;
        }
        return l;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */