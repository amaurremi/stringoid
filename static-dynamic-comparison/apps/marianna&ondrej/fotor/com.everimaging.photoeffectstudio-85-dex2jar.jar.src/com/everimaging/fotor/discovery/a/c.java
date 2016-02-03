package com.everimaging.fotor.discovery.a;

import com.everimaging.fotor.discovery.entity.NewsDataInfo;
import com.everimaging.fotor.discovery.entity.NewsDataInfo.NewsData;
import com.everimaging.fotorsdk.http.l;
import com.everimaging.fotorsdk.http.q;
import com.google.gson.Gson;

import java.util.List;

import org.apache.http.Header;

public class c {
    private static NewsDataInfo.NewsData a;

    private static void a(String paramString1, String paramString2, String paramString3, int paramInt1, final int paramInt2, final a parama) {
        long l = System.currentTimeMillis();
        l locall = new l();
        locall.b("language", paramString1);
        locall.b("platform", "1");
        locall.b("pageInfo.index", String.valueOf(paramInt1));
        locall.b("pageInfo.size", String.valueOf(paramInt2));
        locall.b("timestamp", String.valueOf(l));
        locall.b("appName", paramString2);
        locall.b("udid", paramString3);
        a.b("", locall, new q() {
            public void a(int paramAnonymousInt, Header[] paramAnonymousArrayOfHeader, String paramAnonymousString) {
                try {
                    paramAnonymousArrayOfHeader = (NewsDataInfo) new Gson().fromJson(paramAnonymousString, NewsDataInfo.class);
                    if (paramAnonymousArrayOfHeader != null) {
                        paramAnonymousString = paramAnonymousArrayOfHeader.getData();
                        if (paramAnonymousString != null) {
                            if ((c.a() != null) && (c.a().getDiscoverList() != null)) {
                                break label63;
                            }
                            c.a(paramAnonymousString);
                        }
                    }
                    for (; ; ) {
                        parama.a(c.a());
                        return;
                        label63:
                        paramAnonymousArrayOfHeader = c.a().getDiscoverList();
                        paramAnonymousString = paramAnonymousString.getDiscoverList();
                        if (paramAnonymousString != null) {
                            paramAnonymousInt = paramAnonymousArrayOfHeader.size();
                            int i = (this.a - 1) * paramInt2 + paramAnonymousString.size();
                            if (i > paramAnonymousInt) {
                                c.a().getDiscoverList().addAll(paramAnonymousString.subList(paramAnonymousString.size() - (i - paramAnonymousInt), paramAnonymousString.size()));
                            }
                        }
                    }
                    return;
                } catch (Exception paramAnonymousArrayOfHeader) {
                    parama.b(c.a());
                }
            }

            public void a(int paramAnonymousInt, Header[] paramAnonymousArrayOfHeader, String paramAnonymousString, Throwable paramAnonymousThrowable) {
                parama.b(c.a());
            }
        });
    }

    public static void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, a parama) {
        if ((a == null) || (a.getDiscoverList() == null) || (paramBoolean)) {
            if (!paramBoolean) {
                break label86;
            }
            paramInt1 = 1;
            a = null;
        }
        label86:
        for (; ; ) {
            a(paramString1, paramString2, paramString3, paramInt1, paramInt2, parama);
            return;
            if (paramInt1 * paramInt2 <= a.getDiscoverList().size()) {
                parama.a(a);
                return;
            }
            a(paramString1, paramString2, paramString3, paramInt1, paramInt2, parama);
            return;
        }
    }

    public static abstract interface a {
        public abstract void a(NewsDataInfo.NewsData paramNewsData);

        public abstract void b(NewsDataInfo.NewsData paramNewsData);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/discovery/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */