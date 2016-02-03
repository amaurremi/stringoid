package retrofit.converter;

import java.io.OutputStream;

import retrofit.mime.TypedOutput;

class GsonConverter$JsonTypedOutput
        implements TypedOutput {
    private final byte[] jsonBytes;
    private final String mimeType;

    GsonConverter$JsonTypedOutput(byte[] paramArrayOfByte, String paramString) {
        this.jsonBytes = paramArrayOfByte;
        this.mimeType = ("application/json; charset=" + paramString);
    }

    public String fileName() {
        return null;
    }

    public long length() {
        return this.jsonBytes.length;
    }

    public String mimeType() {
        return this.mimeType;
    }

    public void writeTo(OutputStream paramOutputStream) {
        paramOutputStream.write(this.jsonBytes);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/retrofit/converter/GsonConverter$JsonTypedOutput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */