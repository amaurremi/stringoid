package org.apache.commons.lang.math;

public class IEEE754rUtils {
    public static double max(double paramDouble1, double paramDouble2) {
        if (Double.isNaN(paramDouble1)) {
            return paramDouble2;
        }
        if (Double.isNaN(paramDouble2)) {
            return paramDouble1;
        }
        return Math.max(paramDouble1, paramDouble2);
    }

    public static double max(double paramDouble1, double paramDouble2, double paramDouble3) {
        return max(max(paramDouble1, paramDouble2), paramDouble3);
    }

    public static double max(double[] paramArrayOfDouble) {
        if (paramArrayOfDouble == null) {
            throw new IllegalArgumentException("The Array must not be null");
        }
        if (paramArrayOfDouble.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        double d = paramArrayOfDouble[0];
        int i = 1;
        while (i < paramArrayOfDouble.length) {
            d = max(paramArrayOfDouble[i], d);
            i += 1;
        }
        return d;
    }

    public static float max(float paramFloat1, float paramFloat2) {
        if (Float.isNaN(paramFloat1)) {
            return paramFloat2;
        }
        if (Float.isNaN(paramFloat2)) {
            return paramFloat1;
        }
        return Math.max(paramFloat1, paramFloat2);
    }

    public static float max(float paramFloat1, float paramFloat2, float paramFloat3) {
        return max(max(paramFloat1, paramFloat2), paramFloat3);
    }

    public static float max(float[] paramArrayOfFloat) {
        if (paramArrayOfFloat == null) {
            throw new IllegalArgumentException("The Array must not be null");
        }
        if (paramArrayOfFloat.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        float f = paramArrayOfFloat[0];
        int i = 1;
        while (i < paramArrayOfFloat.length) {
            f = max(paramArrayOfFloat[i], f);
            i += 1;
        }
        return f;
    }

    public static double min(double paramDouble1, double paramDouble2) {
        if (Double.isNaN(paramDouble1)) {
            return paramDouble2;
        }
        if (Double.isNaN(paramDouble2)) {
            return paramDouble1;
        }
        return Math.min(paramDouble1, paramDouble2);
    }

    public static double min(double paramDouble1, double paramDouble2, double paramDouble3) {
        return min(min(paramDouble1, paramDouble2), paramDouble3);
    }

    public static double min(double[] paramArrayOfDouble) {
        if (paramArrayOfDouble == null) {
            throw new IllegalArgumentException("The Array must not be null");
        }
        if (paramArrayOfDouble.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        double d = paramArrayOfDouble[0];
        int i = 1;
        while (i < paramArrayOfDouble.length) {
            d = min(paramArrayOfDouble[i], d);
            i += 1;
        }
        return d;
    }

    public static float min(float paramFloat1, float paramFloat2) {
        if (Float.isNaN(paramFloat1)) {
            return paramFloat2;
        }
        if (Float.isNaN(paramFloat2)) {
            return paramFloat1;
        }
        return Math.min(paramFloat1, paramFloat2);
    }

    public static float min(float paramFloat1, float paramFloat2, float paramFloat3) {
        return min(min(paramFloat1, paramFloat2), paramFloat3);
    }

    public static float min(float[] paramArrayOfFloat) {
        if (paramArrayOfFloat == null) {
            throw new IllegalArgumentException("The Array must not be null");
        }
        if (paramArrayOfFloat.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        float f = paramArrayOfFloat[0];
        int i = 1;
        while (i < paramArrayOfFloat.length) {
            f = min(paramArrayOfFloat[i], f);
            i += 1;
        }
        return f;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/org/apache/commons/lang/math/IEEE754rUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */