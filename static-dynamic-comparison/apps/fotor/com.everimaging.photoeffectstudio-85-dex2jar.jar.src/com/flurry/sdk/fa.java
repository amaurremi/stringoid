package com.flurry.sdk;

public class fa {
    private static long a = 1000L;
    private static fa b = null;
    private final fb c = new fb();

    public fa() {
        this.c.a(a);
        this.c.a(true);
    }

    public static fa a() {
        try {
            if (b == null) {
                b = new fa();
            }
            fa localfa = b;
            return localfa;
        } finally {
        }
    }

    public void a(fb.a parama) {
        try {
            this.c.a(parama);
            if ((!this.c.c()) && (this.c.d() > 0)) {
                this.c.a();
            }
            return;
        } finally {
            parama =finally;
            throw parama;
        }
    }

    public boolean b(fb.a parama) {
        try {
            boolean bool = this.c.b(parama);
            if (this.c.d() == 0) {
                this.c.b();
            }
            return bool;
        } finally {
            parama =finally;
            throw parama;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/flurry/sdk/fa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */