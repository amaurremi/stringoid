package com.everimaging.fotorsdk.algorithms.cpu;

import android.support.v8.renderscript.Float3;

public class c {
    protected float a(float paramFloat1, float paramFloat2, float paramFloat3) {
        if (paramFloat1 < paramFloat2) {
            return paramFloat2;
        }
        if (paramFloat1 > paramFloat3) {
            return paramFloat3;
        }
        return paramFloat1;
    }

    public Float3 a(float paramFloat1, float paramFloat2) {
        Float3 localFloat3 = new Float3();
        paramFloat1 = a(5400.0F * paramFloat1 + 6500.0F, 1200.0F, 12000.0F);
        paramFloat2 = a(paramFloat2, 0.02F, 5.0F);
        paramFloat1 /= 1000.0F;
        float f1;
        float f2;
        if (paramFloat1 < 4.0F) {
            f1 = 0.27475F / (paramFloat1 * paramFloat1 * paramFloat1);
            f2 = 0.98598F / (paramFloat1 * paramFloat1);
            paramFloat1 = 1.17444F / paramFloat1 + (f1 - f2) + 0.145986F;
        }
        for (; ; ) {
            f2 = -3.0F * paramFloat1 * paramFloat1 + 2.87F * paramFloat1 - 0.275F;
            f1 = paramFloat1 / f2;
            paramFloat1 = (1.0F - paramFloat1 - f2) / f2;
            localFloat3.x = (3.24074F * f1 - 1.53726F - 0.498571F * paramFloat1);
            localFloat3.y = (-f1 * 0.969258F + 1.87599F + 0.0415557F * paramFloat1);
            localFloat3.z = (paramFloat1 * 1.05707F + (0.0556352F * f1 - 0.203996F));
            localFloat3.y /= paramFloat2;
            paramFloat1 = b(b(localFloat3.x, localFloat3.y), localFloat3.z);
            localFloat3.x /= paramFloat1;
            localFloat3.y /= paramFloat1;
            localFloat3.z /= paramFloat1;
            localFloat3.x = (1.0F / localFloat3.x);
            localFloat3.y = (1.0F / localFloat3.y);
            localFloat3.z = (1.0F / localFloat3.z);
            paramFloat1 = localFloat3.x * 0.299F + localFloat3.y * 0.587F + localFloat3.z * 0.114F;
            localFloat3.x /= paramFloat1;
            localFloat3.y /= paramFloat1;
            localFloat3.z /= paramFloat1;
            return localFloat3;
            if (paramFloat1 < 7.0F) {
                f1 = -4.607F / (paramFloat1 * paramFloat1 * paramFloat1);
                f2 = 2.9678F / (paramFloat1 * paramFloat1);
                paramFloat1 = 0.09911F / paramFloat1 + (f1 + f2) + 0.244063F;
            } else {
                f1 = -2.0064F / (paramFloat1 * paramFloat1 * paramFloat1);
                f2 = 1.9018F / (paramFloat1 * paramFloat1);
                paramFloat1 = 0.24748F / paramFloat1 + (f1 + f2) + 0.23704F;
            }
        }
    }

    protected float b(float paramFloat1, float paramFloat2) {
        if (paramFloat1 > paramFloat2) {
            return paramFloat1;
        }
        return paramFloat2;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/cpu/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */