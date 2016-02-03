package com.everimaging.fotor.discovery.a;

import com.everimaging.fotor.App;
import com.everimaging.fotor.discovery.entity.SuggestionList;
import com.everimaging.fotor.log.LoggerFactory;
import com.everimaging.fotor.log.LoggerFactory.LoggerType;
import com.everimaging.fotor.log.LoggerFactory.c;
import com.everimaging.fotorsdk.http.c;
import com.everimaging.fotorsdk.http.l;
import com.everimaging.fotorsdk.http.q;
import com.google.gson.Gson;

import java.util.Locale;

import org.apache.http.Header;

public class d {
    private static final String a = d.class.getSimpleName();
    private static final LoggerFactory.c b = LoggerFactory.a(a, LoggerFactory.LoggerType.CONSOLE);
    private static SuggestionList c;

    public static SuggestionList a(boolean paramBoolean) {
        if ((c == null) || (c.getData() == null) || (paramBoolean)) {
            l locall = new l();
            locall.b("platform", "1");
            locall.b("appVersion", "fotor_" + App.b.b());
            locall.b("country", Locale.getDefault().getCountry());
            a(locall, new q() {
                public void a(int paramAnonymousInt, Header[] paramAnonymousArrayOfHeader, String paramAnonymousString) {
                    paramAnonymousArrayOfHeader = new Gson();
                    try {
                        paramAnonymousArrayOfHeader = (SuggestionList) paramAnonymousArrayOfHeader.fromJson(paramAnonymousString, SuggestionList.class);
                        if ((paramAnonymousArrayOfHeader != null) && (paramAnonymousArrayOfHeader.getData() != null)) {
                            d.a(paramAnonymousArrayOfHeader);
                        }
                        return;
                    } catch (Exception paramAnonymousArrayOfHeader) {
                        d.a().equals("load error:" + paramAnonymousArrayOfHeader.getMessage());
                    }
                }

                public void a(int paramAnonymousInt, Header[] paramAnonymousArrayOfHeader, String paramAnonymousString, Throwable paramAnonymousThrowable) {
                    d.a().d(new Object[]{"load failure: statusCode" + paramAnonymousInt, "error:" + paramAnonymousThrowable});
                }
            });
        }
        return c;
    }

    private static void a(l paraml, c paramc) {
        b.c(new Object[]{"load suggestion:/recApp"});
        a.a(a.b("/recApp"), paraml, paramc);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/discovery/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */