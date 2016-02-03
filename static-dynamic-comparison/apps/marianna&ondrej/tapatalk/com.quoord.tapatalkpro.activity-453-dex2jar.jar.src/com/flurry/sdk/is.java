package com.flurry.sdk;

public abstract interface is {
    public abstract sh a();

    public abstract mq b();

    public static class a
            implements is {
        protected final String a;
        protected final sh b;
        protected final mq c;
        protected final qv d;

        public a(String paramString, sh paramsh, qv paramqv, mq parammq) {
            this.a = paramString;
            this.b = paramsh;
            this.c = parammq;
            this.d = paramqv;
        }

        public a a(sh paramsh) {
            return new a(this.a, paramsh, this.d, this.c);
        }

        public sh a() {
            return this.b;
        }

        public mq b() {
            return this.c;
        }

        public String c() {
            return this.a;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/is.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */