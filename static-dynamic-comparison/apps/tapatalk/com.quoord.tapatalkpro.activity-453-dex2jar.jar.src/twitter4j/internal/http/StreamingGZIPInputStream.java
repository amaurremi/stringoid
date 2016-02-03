package twitter4j.internal.http;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

final class StreamingGZIPInputStream
        extends GZIPInputStream {
    private final InputStream wrapped;

    public StreamingGZIPInputStream(InputStream paramInputStream)
            throws IOException {
        super(paramInputStream);
        this.wrapped = paramInputStream;
    }

    public int available()
            throws IOException {
        return this.wrapped.available();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/internal/http/StreamingGZIPInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */