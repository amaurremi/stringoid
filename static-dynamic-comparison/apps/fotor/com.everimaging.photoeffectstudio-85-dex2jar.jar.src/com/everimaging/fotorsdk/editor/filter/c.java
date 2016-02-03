package com.everimaging.fotorsdk.editor.filter;

import com.everimaging.fotorsdk.editor.filter.jni.b;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;

public class c {
    private static final String a = c.class.getSimpleName();
    private static final FotorLoggerFactory.c b = FotorLoggerFactory.a(a, FotorLoggerFactory.LoggerType.CONSOLE);
    private a c;
    private boolean d = false;

    public c(a.a parama) {
        if (parama.getRenderScript() != null) {
        }
        b.c(new Object[]{" run in jni mode"});
        this.c = new b(parama);
    }

    public void a() {
        if ((this.c != null) && (!this.d)) {
            this.c.a();
        }
        this.d = true;
    }

    public float[] a(float[] paramArrayOfFloat) {
        float[] arrayOfFloat = null;
        try {
            if (this.c != null) {
                arrayOfFloat = this.c.a(paramArrayOfFloat);
            }
            return arrayOfFloat;
        } catch (Throwable paramArrayOfFloat) {
        }
        return null;
    }

    protected void finalize()
            throws Throwable {
        super.finalize();
        a();
    }

    public static abstract interface a {
        public abstract void a();

        public abstract float[] a(float[] paramArrayOfFloat);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/filter/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */