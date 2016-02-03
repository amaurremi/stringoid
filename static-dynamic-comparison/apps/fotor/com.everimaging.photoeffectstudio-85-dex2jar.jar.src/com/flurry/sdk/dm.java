package com.flurry.sdk;

import java.util.Timer;
import java.util.TimerTask;

class dm {
    private Timer a;
    private a b;
    private b c;

    dm(b paramb) {
        this.c = paramb;
    }

    public void a() {
        try {
            if (this.a != null) {
                this.a.cancel();
                this.a = null;
            }
            this.b = null;
            return;
        } finally {
        }
    }

    public void a(long paramLong) {
        try {
            if (b()) {
                a();
            }
            this.a = new Timer("FlurrySessionTimer");
            this.b = new a(this.c);
            this.a.schedule(this.b, paramLong);
            return;
        } finally {
        }
    }

    public boolean b() {
        return this.a != null;
    }

    class a
            extends TimerTask {
        private dm.b b;

        a(dm.b paramb) {
            this.b = paramb;
        }

        public void run() {
            dm.this.a();
            if (this.b != null) {
                this.b.q();
            }
        }
    }

    public static abstract interface b {
        public abstract void q();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/flurry/sdk/dm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */