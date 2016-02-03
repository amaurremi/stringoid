package com.flurry.sdk;

import java.io.PrintStream;
import java.io.PrintWriter;

public abstract class ff
        implements Runnable {
    private static final String a = ff.class.getSimpleName();
    PrintStream g;
    PrintWriter h;

    public abstract void a();

    public final void run() {
        try {
            a();
            return;
        } catch (Throwable localThrowable) {
            if (this.g == null) {
                break label33;
            }
        }
        localThrowable.printStackTrace(this.g);
        for (; ; ) {
            eo.a(6, a, "", localThrowable);
            return;
            label33:
            if (this.h != null) {
                localThrowable.printStackTrace(this.h);
            } else {
                localThrowable.printStackTrace();
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/flurry/sdk/ff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */