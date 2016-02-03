package retrofit.mime;

import java.io.InputStream;

public abstract interface TypedInput {
    public abstract InputStream in();

    public abstract long length();

    public abstract String mimeType();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/retrofit/mime/TypedInput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */