package mobi.ifunny.d;

import android.support.v4.app.k;

import java.io.IOException;
import java.io.Reader;

import mobi.ifunny.l.h;
import mobi.ifunny.rest.retrofit.RestHttpHandler;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

public class e<T extends h>
        extends a<T, String> {
    public e(k paramk, T paramT, String paramString1, AbstractHttpClient paramAbstractHttpClient, HttpContext paramHttpContext, String paramString2, String paramString3, c paramc, RestHttpHandler<String, T> paramRestHttpHandler) {
        super(paramk, paramT, paramString1, paramAbstractHttpClient, paramHttpContext, paramString2, paramString3, paramc, paramRestHttpHandler);
    }

    protected String b(Reader paramReader) {
        StringBuilder localStringBuilder = new StringBuilder();
        char[] arrayOfChar = new char['က'];
        try {
            for (; ; ) {
                int i = paramReader.read(arrayOfChar, 0, 4096);
                if (i < 0) {
                    return localStringBuilder.toString();
                }
                localStringBuilder.append(arrayOfChar, 0, i);
            }
        } catch (IOException localIOException) {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/d/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */