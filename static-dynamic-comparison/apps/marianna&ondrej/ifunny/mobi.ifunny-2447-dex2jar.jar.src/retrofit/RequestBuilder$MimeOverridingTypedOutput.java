package retrofit;

import java.io.OutputStream;

import retrofit.mime.TypedOutput;

class RequestBuilder$MimeOverridingTypedOutput
        implements TypedOutput {
    private final TypedOutput delegate;
    private final String mimeType;

    RequestBuilder$MimeOverridingTypedOutput(TypedOutput paramTypedOutput, String paramString) {
        this.delegate = paramTypedOutput;
        this.mimeType = paramString;
    }

    public String fileName() {
        return this.delegate.fileName();
    }

    public long length() {
        return this.delegate.length();
    }

    public String mimeType() {
        return this.mimeType;
    }

    public void writeTo(OutputStream paramOutputStream) {
        this.delegate.writeTo(paramOutputStream);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/retrofit/RequestBuilder$MimeOverridingTypedOutput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */