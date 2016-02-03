package com.flurry.sdk;

public class av<ObjectType>
        extends aw {
    private static final String a = aw.class.getSimpleName();
    private final ex<ObjectType> b;

    public av(ex<ObjectType> paramex, String paramString, long paramLong, boolean paramBoolean) {
        super(paramString, paramLong, paramBoolean);
        if (paramex == null) {
            throw new IllegalArgumentException("Serializer cannot be null");
        }
        this.b = paramex;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */