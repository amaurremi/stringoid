package android.support.v4.app;

class bw
        implements cf {
    final String a;
    final int b;
    final String c;
    final boolean d;

    public bw(String paramString1, int paramInt, String paramString2) {
        this.a = paramString1;
        this.b = paramInt;
        this.c = paramString2;
        this.d = false;
    }

    public void a(ac paramac) {
        if (this.d) {
            paramac.a(this.a);
            return;
        }
        paramac.a(this.a, this.b, this.c);
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder("CancelTask[");
        localStringBuilder.append("packageName:").append(this.a);
        localStringBuilder.append(", id:").append(this.b);
        localStringBuilder.append(", tag:").append(this.c);
        localStringBuilder.append(", all:").append(this.d);
        localStringBuilder.append("]");
        return localStringBuilder.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/app/bw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */