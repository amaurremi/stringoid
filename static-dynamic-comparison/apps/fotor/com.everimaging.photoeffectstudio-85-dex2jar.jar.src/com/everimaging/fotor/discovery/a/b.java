package com.everimaging.fotor.discovery.a;

import com.everimaging.fotor.App;
import com.everimaging.fotor.discovery.entity.InspirationListInfo;
import com.everimaging.fotorsdk.http.l;
import com.everimaging.fotorsdk.http.q;
import com.google.gson.Gson;
import org.apache.http.Header;

public class b {
    private static InspirationListInfo a;

    private static void a(a parama) {
        l locall = new l();
        locall.b("platform", "1");
        locall.b("appVersion", "fotor_" + App.b.b());
        a.b("/getInspiration", locall, new q() {
            public void a(int paramAnonymousInt, Header[] paramAnonymousArrayOfHeader, String paramAnonymousString) {
                paramAnonymousArrayOfHeader = new Gson();
                try {
                    paramAnonymousArrayOfHeader = (InspirationListInfo) paramAnonymousArrayOfHeader.fromJson(paramAnonymousString, InspirationListInfo.class);
                    if ((paramAnonymousArrayOfHeader != null) && (paramAnonymousArrayOfHeader.getData() != null)) {
                        b.a(paramAnonymousArrayOfHeader);
                        this.a.a(b.a());
                    }
                    return;
                } catch (Exception paramAnonymousArrayOfHeader) {
                    paramAnonymousArrayOfHeader.printStackTrace();
                    this.a.b(b.a());
                }
            }

            public void a(int paramAnonymousInt, Header[] paramAnonymousArrayOfHeader, String paramAnonymousString, Throwable paramAnonymousThrowable) {
                this.a.b(b.a());
            }
        });
    }

    public static void a(boolean paramBoolean, a parama) {
        if ((a == null) || (paramBoolean)) {
            a(parama);
            return;
        }
        parama.a(a);
    }

    public static abstract interface a {
        public abstract void a(InspirationListInfo paramInspirationListInfo);

        public abstract void b(InspirationListInfo paramInspirationListInfo);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/discovery/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */