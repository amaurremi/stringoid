package twitter4j;

import java.io.InputStream;
import java.util.zip.GZIPInputStream;

final class StreamingGZIPInputStream
        extends GZIPInputStream {
    private final InputStream wrapped;

    public StreamingGZIPInputStream(InputStream paramInputStream) {
        super(paramInputStream);
        this.wrapped = paramInputStream;
    }

    public int available() {
        return this.wrapped.available();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/StreamingGZIPInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */