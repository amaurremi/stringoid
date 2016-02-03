package retrofit.mime;

import java.io.OutputStream;

public abstract interface TypedOutput {
    public abstract String fileName();

    public abstract long length();

    public abstract String mimeType();

    public abstract void writeTo(OutputStream paramOutputStream);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/retrofit/mime/TypedOutput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */