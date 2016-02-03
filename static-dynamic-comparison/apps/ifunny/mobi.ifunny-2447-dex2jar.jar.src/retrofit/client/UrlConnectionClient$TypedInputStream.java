package retrofit.client;

import java.io.InputStream;

import retrofit.mime.TypedInput;

class UrlConnectionClient$TypedInputStream
        implements TypedInput {
    private final long length;
    private final String mimeType;
    private final InputStream stream;

    private UrlConnectionClient$TypedInputStream(String paramString, long paramLong, InputStream paramInputStream) {
        this.mimeType = paramString;
        this.length = paramLong;
        this.stream = paramInputStream;
    }

    public InputStream in() {
        return this.stream;
    }

    public long length() {
        return this.length;
    }

    public String mimeType() {
        return this.mimeType;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/retrofit/client/UrlConnectionClient$TypedInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */