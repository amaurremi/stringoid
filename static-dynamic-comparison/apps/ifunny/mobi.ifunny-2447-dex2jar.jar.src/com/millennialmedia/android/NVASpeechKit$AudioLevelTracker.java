package com.millennialmedia.android;

class NVASpeechKit$AudioLevelTracker {
    double a;
    double b;
    int c;
    boolean d;

    public NVASpeechKit$AudioLevelTracker() {
        reset();
    }

    private static double b(double paramDouble) {
        return Math.min(9.99D, Math.max(Math.floor(paramDouble - 40.0D) / 4.004004004004004D, 0.0D));
    }

    public boolean isTrackingAudioSample() {
        return this.d;
    }

    public void reset() {
        this.b = 0.0D;
        this.c = 0;
        this.d = false;
    }

    public void startTrackingAudioSample() {
        reset();
        this.d = true;
    }

    public boolean update(double paramDouble) {
        double d1 = this.b;
        double d2 = this.a;
        this.a = paramDouble;
        this.c += 1;
        this.b = ((d1 * (this.c - 1) + paramDouble) / this.c);
        if (this.d) {
        }
        while (this.a == d2) {
            return false;
        }
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/NVASpeechKit$AudioLevelTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */