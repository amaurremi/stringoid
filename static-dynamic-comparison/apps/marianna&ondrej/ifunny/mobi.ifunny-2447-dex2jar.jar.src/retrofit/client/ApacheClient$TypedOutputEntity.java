package retrofit.client;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.http.entity.AbstractHttpEntity;
import retrofit.mime.TypedOutput;

class ApacheClient$TypedOutputEntity
        extends AbstractHttpEntity {
    final TypedOutput typedOutput;

    ApacheClient$TypedOutputEntity(TypedOutput paramTypedOutput) {
        this.typedOutput = paramTypedOutput;
        setContentType(paramTypedOutput.mimeType());
    }

    public InputStream getContent() {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        this.typedOutput.writeTo(localByteArrayOutputStream);
        return new ByteArrayInputStream(localByteArrayOutputStream.toByteArray());
    }

    public long getContentLength() {
        return this.typedOutput.length();
    }

    public boolean isRepeatable() {
        return true;
    }

    public boolean isStreaming() {
        return false;
    }

    public void writeTo(OutputStream paramOutputStream) {
        this.typedOutput.writeTo(paramOutputStream);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/retrofit/client/ApacheClient$TypedOutputEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */