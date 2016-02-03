package mobi.ifunny.rest;

import android.os.SystemClock;
import android.text.TextUtils;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashSet;
import javax.net.ssl.SSLHandshakeException;

import mobi.ifunny.d;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

class IFunnyHttpRetryHandler
        implements HttpRequestRetryHandler {
    private static final int RETRY_SLEEP_TIME_MILLIS = 1500;
    private static HashSet<Class<?>> exceptionBlacklist;
    private static HashSet<Class<?>> exceptionWhitelist = new HashSet();
    private final int maxRetries;

    static {
        exceptionBlacklist = new HashSet();
        exceptionWhitelist.add(NoHttpResponseException.class);
        exceptionWhitelist.add(UnknownHostException.class);
        exceptionWhitelist.add(SocketException.class);
        exceptionBlacklist.add(InterruptedIOException.class);
        exceptionBlacklist.add(SSLHandshakeException.class);
    }

    public IFunnyHttpRetryHandler(int paramInt) {
        this.maxRetries = paramInt;
    }

    public boolean retryRequest(IOException paramIOException, int paramInt, HttpContext paramHttpContext) {
        boolean bool = false;
        if (paramInt > this.maxRetries) {
        }
        while (bool) {
            SystemClock.sleep(1500L);
            return bool;
            if (!exceptionBlacklist.contains(paramIOException.getClass())) {
                if (exceptionWhitelist.contains(paramIOException.getClass())) {
                    bool = true;
                } else {
                    Boolean localBoolean = (Boolean) paramHttpContext.getAttribute("http.request_sent");
                    if ((localBoolean != null) && (localBoolean.booleanValue())) {
                        paramInt = 1;
                        label85:
                        if (paramInt == 0) {
                            break label130;
                        }
                        if (TextUtils.equals("POST", ((HttpUriRequest) paramHttpContext.getAttribute("http.request")).getMethod())) {
                            break label124;
                        }
                    }
                    label124:
                    for (bool = true; ; bool = false) {
                        break;
                        paramInt = 0;
                        break label85;
                    }
                    label130:
                    bool = true;
                }
            }
        }
        d.b(IFunnyRestHttpClient.TAG, "Do not retry after exception", paramIOException);
        return bool;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/IFunnyHttpRetryHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */