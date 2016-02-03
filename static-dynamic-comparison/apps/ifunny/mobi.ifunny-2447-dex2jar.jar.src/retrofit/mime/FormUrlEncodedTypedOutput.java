package retrofit.mime;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

public final class FormUrlEncodedTypedOutput
        implements TypedOutput {
    final ByteArrayOutputStream content = new ByteArrayOutputStream();

    public void addField(String paramString1, String paramString2) {
        if (paramString1 == null) {
            throw new NullPointerException("name");
        }
        if (paramString2 == null) {
            throw new NullPointerException("value");
        }
        if (this.content.size() > 0) {
            this.content.write(38);
        }
        try {
            paramString1 = URLEncoder.encode(paramString1, "UTF-8");
            paramString2 = URLEncoder.encode(paramString2, "UTF-8");
            this.content.write(paramString1.getBytes("UTF-8"));
            this.content.write(61);
            this.content.write(paramString2.getBytes("UTF-8"));
            return;
        } catch (IOException paramString1) {
            throw new RuntimeException(paramString1);
        }
    }

    public String fileName() {
        return null;
    }

    public long length() {
        return this.content.size();
    }

    public String mimeType() {
        return "application/x-www-form-urlencoded; charset=UTF-8";
    }

    public void writeTo(OutputStream paramOutputStream) {
        paramOutputStream.write(this.content.toByteArray());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/retrofit/mime/FormUrlEncodedTypedOutput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */