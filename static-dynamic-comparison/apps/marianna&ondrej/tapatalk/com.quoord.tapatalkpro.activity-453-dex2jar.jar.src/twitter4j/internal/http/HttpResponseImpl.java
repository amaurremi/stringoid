package twitter4j.internal.http;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

public class HttpResponseImpl
        extends HttpResponse {
    private HttpURLConnection con;

    HttpResponseImpl(String paramString) {
        this.responseAsString = paramString;
    }

    HttpResponseImpl(HttpURLConnection paramHttpURLConnection, HttpClientConfiguration paramHttpClientConfiguration)
            throws IOException {
        super(paramHttpClientConfiguration);
        this.con = paramHttpURLConnection;
        this.statusCode = paramHttpURLConnection.getResponseCode();
        paramHttpClientConfiguration = paramHttpURLConnection.getErrorStream();
        this.is = paramHttpClientConfiguration;
        if (paramHttpClientConfiguration == null) {
            this.is = paramHttpURLConnection.getInputStream();
        }
        if ((this.is != null) && ("gzip".equals(paramHttpURLConnection.getContentEncoding()))) {
            this.is = new StreamingGZIPInputStream(this.is);
        }
    }

    public void disconnect() {
        this.con.disconnect();
    }

    public String getResponseHeader(String paramString) {
        return this.con.getHeaderField(paramString);
    }

    public Map<String, List<String>> getResponseHeaderFields() {
        return this.con.getHeaderFields();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/internal/http/HttpResponseImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */