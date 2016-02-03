package com.everimaging.fotorsdk.algorithms.cpu;

public class a {
    public static float[] a(float paramFloat) {
        float[] arrayOfFloat = new float['Ā'];
        float f = paramFloat;
        if (paramFloat < 0.0F) {
            f = 1.0E-8F;
        }
        int i = 0;
        while (i < 256) {
            arrayOfFloat[i] = ((float) Math.pow(f, i / 255.0D));
            i += 1;
        }
        return arrayOfFloat;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/cpu/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */