package com.google.android.gms.internal;

import java.util.ArrayList;

public final class gi {
    public static void a(StringBuilder paramStringBuilder, double[] paramArrayOfDouble) {
        int j = paramArrayOfDouble.length;
        int i = 0;
        while (i < j) {
            if (i != 0) {
                paramStringBuilder.append(",");
            }
            paramStringBuilder.append(Double.toString(paramArrayOfDouble[i]));
            i += 1;
        }
    }

    public static void a(StringBuilder paramStringBuilder, float[] paramArrayOfFloat) {
        int j = paramArrayOfFloat.length;
        int i = 0;
        while (i < j) {
            if (i != 0) {
                paramStringBuilder.append(",");
            }
            paramStringBuilder.append(Float.toString(paramArrayOfFloat[i]));
            i += 1;
        }
    }

    public static void a(StringBuilder paramStringBuilder, int[] paramArrayOfInt) {
        int j = paramArrayOfInt.length;
        int i = 0;
        while (i < j) {
            if (i != 0) {
                paramStringBuilder.append(",");
            }
            paramStringBuilder.append(Integer.toString(paramArrayOfInt[i]));
            i += 1;
        }
    }

    public static void a(StringBuilder paramStringBuilder, long[] paramArrayOfLong) {
        int j = paramArrayOfLong.length;
        int i = 0;
        while (i < j) {
            if (i != 0) {
                paramStringBuilder.append(",");
            }
            paramStringBuilder.append(Long.toString(paramArrayOfLong[i]));
            i += 1;
        }
    }

    public static <T> void a(StringBuilder paramStringBuilder, T[] paramArrayOfT) {
        int j = paramArrayOfT.length;
        int i = 0;
        while (i < j) {
            if (i != 0) {
                paramStringBuilder.append(",");
            }
            paramStringBuilder.append(paramArrayOfT[i].toString());
            i += 1;
        }
    }

    public static void a(StringBuilder paramStringBuilder, String[] paramArrayOfString) {
        int j = paramArrayOfString.length;
        int i = 0;
        while (i < j) {
            if (i != 0) {
                paramStringBuilder.append(",");
            }
            paramStringBuilder.append("\"").append(paramArrayOfString[i]).append("\"");
            i += 1;
        }
    }

    public static void a(StringBuilder paramStringBuilder, boolean[] paramArrayOfBoolean) {
        int j = paramArrayOfBoolean.length;
        int i = 0;
        while (i < j) {
            if (i != 0) {
                paramStringBuilder.append(",");
            }
            paramStringBuilder.append(Boolean.toString(paramArrayOfBoolean[i]));
            i += 1;
        }
    }

    public static <T> ArrayList<T> fs() {
        return new ArrayList();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/gi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */