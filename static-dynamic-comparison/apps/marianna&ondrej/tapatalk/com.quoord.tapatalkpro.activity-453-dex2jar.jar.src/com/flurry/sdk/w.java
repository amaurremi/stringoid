package com.flurry.sdk;

import java.util.List;

public class w {
    private static final String a = w.class.getSimpleName();

    int a(byte[] paramArrayOfByte) {
        ed localed = new ed();
        localed.update(paramArrayOfByte);
        return localed.b();
    }

    public <A extends gw, B extends gw> void a(Object paramObject, String paramString, A paramA, Class<A> paramClass, Class<B> paramClass1, a<B> parama) {
        a(paramObject, paramString, v.a(paramA, paramClass), paramClass1, parama);
    }

    public <B extends gw> void a(Object paramObject, final String paramString, byte[] paramArrayOfByte, final Class<B> paramClass, final a<B> parama) {
        el localel = new el();
        localel.a(paramString);
        localel.a(en.a.c);
        localel.a("Content-Type", "avro/binary");
        localel.a("Accept", "avro/binary");
        localel.a("FM-Checksum", Integer.toString(a(paramArrayOfByte)));
        localel.a(new ew());
        localel.b(new ew());
        localel.a(paramArrayOfByte);
        localel.a(new el.a() {
            public void a(el<byte[], byte[]> paramAnonymousel, byte[] paramAnonymousArrayOfByte) {
                Object localObject = null;
                int i = paramAnonymousel.e();
                if ((paramAnonymousel.c()) && (paramAnonymousArrayOfByte != null) && (paramAnonymousArrayOfByte.length > 0)) {
                    paramAnonymousel = paramAnonymousel.b("FM-Checksum");
                    if ((paramAnonymousel != null) && (paramAnonymousel.size() > 0) && (Integer.toString(w.this.a(paramAnonymousArrayOfByte)).equals(paramAnonymousel.get(0)))) {
                        eo.a(4, w.a(), "Request successful, decoding");
                        try {
                            paramAnonymousel = v.a(paramAnonymousArrayOfByte, paramClass);
                            parama.a(i, paramAnonymousel);
                            return;
                        } catch (Throwable paramAnonymousel) {
                            for (; ; ) {
                                eo.a(6, w.a(), "Error decoding response", paramAnonymousel);
                                paramAnonymousel = (el<byte[], byte[]>) localObject;
                            }
                        }
                    }
                    eo.a(6, w.a(), "Response was received, but checksum failed.");
                }
                for (; ; ) {
                    parama.a(i, null);
                    return;
                    eo.a(6, w.a(), "Request to url = " + paramString + " failed.");
                }
            }
        });
        em.a().a(paramObject, localel);
    }

    public static abstract interface a<B extends gw> {
        public abstract void a(int paramInt, B paramB);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */