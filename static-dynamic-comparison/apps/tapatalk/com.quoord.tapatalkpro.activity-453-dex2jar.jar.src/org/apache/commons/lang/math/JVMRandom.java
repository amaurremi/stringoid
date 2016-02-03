package org.apache.commons.lang.math;

import java.util.Random;

public final class JVMRandom
        extends Random {
    private static final Random SHARED_RANDOM = new Random();
    private static final long serialVersionUID = 1L;
    private boolean constructed = false;

    private static int bitsRequired(long paramLong) {
        long l = paramLong;
        int i = 0;
        for (; ; ) {
            int j;
            if (paramLong < 0L) {
                j = 64 - i;
            }
            do {
                return j;
                j = i;
            } while (l == 0L);
            i += 1;
            paramLong <<= 1;
            l >>= 1;
        }
    }

    private static long next63bits() {
        return SHARED_RANDOM.nextLong() & 0x7FFFFFFFFFFFFFFF;
    }

    public static long nextLong(long paramLong) {
        if (paramLong <= 0L) {
            throw new IllegalArgumentException("Upper bound for nextInt must be positive");
        }
        if ((-paramLong & paramLong) == paramLong) {
            return next63bits() >> 63 - bitsRequired(paramLong - 1L);
        }
        long l1;
        long l2;
        do {
            l1 = next63bits();
            l2 = l1 % paramLong;
        } while (l1 - l2 + (paramLong - 1L) < 0L);
        return l2;
    }

    public boolean nextBoolean() {
        return SHARED_RANDOM.nextBoolean();
    }

    public void nextBytes(byte[] paramArrayOfByte) {
        throw new UnsupportedOperationException();
    }

    public double nextDouble() {
        return SHARED_RANDOM.nextDouble();
    }

    public float nextFloat() {
        return SHARED_RANDOM.nextFloat();
    }

    public double nextGaussian() {
        try {
            throw new UnsupportedOperationException();
        } finally {
        }
    }

    public int nextInt() {
        return nextInt(Integer.MAX_VALUE);
    }

    public int nextInt(int paramInt) {
        return SHARED_RANDOM.nextInt(paramInt);
    }

    public long nextLong() {
        return nextLong(Long.MAX_VALUE);
    }

    public void setSeed(long paramLong) {
        try {
            if (this.constructed) {
                throw new UnsupportedOperationException();
            }
        } finally {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/org/apache/commons/lang/math/JVMRandom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */