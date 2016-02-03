package com.flurry.sdk;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ca<ObjectType>
        implements ex<ObjectType> {
    private Class<ObjectType> a;

    public ca(Class<ObjectType> paramClass) {
        this.a = paramClass;
    }

    public ObjectType a(InputStream paramInputStream)
            throws IOException {
        if (paramInputStream == null) {
            return null;
        }
        jq localjq = new jq();
        oc localoc = new oc("AvroJsonObjectSerializerModule", new hq(1, 0, 0, null));
        localoc.a(CharSequence.class, new a(null));
        localjq.a(localoc);
        return (ObjectType) localjq.a(paramInputStream, this.a);
    }

    public void a(OutputStream paramOutputStream, ObjectType paramObjectType)
            throws IOException {
        if ((paramOutputStream == null) || (paramObjectType == null)) {
            return;
        }
        jq localjq = new jq();
        localjq.a(ju.a.m, false);
        localjq.a(ju.a.b, false);
        localjq.a(ju.a.c, false);
        localjq.a(paramOutputStream, paramObjectType);
    }

    static class a
            extends jl {
        public Object a(String paramString, iz paramiz)
                throws IOException, hk {
            return paramString;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/ca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */