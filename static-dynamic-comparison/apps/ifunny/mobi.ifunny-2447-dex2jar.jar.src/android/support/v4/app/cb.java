package android.support.v4.app;

import android.app.Notification;

class cb
        implements cf {
    final String a;
    final int b;
    final String c;
    final Notification d;

    public cb(String paramString1, int paramInt, String paramString2, Notification paramNotification) {
        this.a = paramString1;
        this.b = paramInt;
        this.c = paramString2;
        this.d = paramNotification;
    }

    public void a(ac paramac) {
        paramac.a(this.a, this.b, this.c, this.d);
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder("NotifyTask[");
        localStringBuilder.append("packageName:").append(this.a);
        localStringBuilder.append(", id:").append(this.b);
        localStringBuilder.append(", tag:").append(this.c);
        localStringBuilder.append("]");
        return localStringBuilder.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/app/cb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */