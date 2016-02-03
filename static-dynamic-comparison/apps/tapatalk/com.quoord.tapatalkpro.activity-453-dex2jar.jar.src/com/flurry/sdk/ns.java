package com.flurry.sdk;

public class ns
        extends nr {
    protected final String a;
    protected final String b;

    protected ns(sh paramsh, qs paramqs) {
        super(paramsh, paramqs);
        paramsh = paramsh.p().getName();
        int i = paramsh.lastIndexOf('.');
        if (i < 0) {
            this.a = "";
            this.b = ".";
            return;
        }
        this.b = paramsh.substring(0, i + 1);
        this.a = paramsh.substring(0, i);
    }

    public sh a(String paramString) {
        Object localObject = paramString;
        if (paramString.startsWith(".")) {
            localObject = new StringBuilder(paramString.length() + this.a.length());
            if (this.a.length() != 0) {
                break label62;
            }
            ((StringBuilder) localObject).append(paramString.substring(1));
        }
        for (; ; ) {
            localObject = ((StringBuilder) localObject).toString();
            return super.a((String) localObject);
            label62:
            ((StringBuilder) localObject).append(this.a).append(paramString);
        }
    }

    public String a(Object paramObject) {
        String str = paramObject.getClass().getName();
        paramObject = str;
        if (str.startsWith(this.b)) {
            paramObject = str.substring(this.b.length() - 1);
        }
        return (String) paramObject;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/ns.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */