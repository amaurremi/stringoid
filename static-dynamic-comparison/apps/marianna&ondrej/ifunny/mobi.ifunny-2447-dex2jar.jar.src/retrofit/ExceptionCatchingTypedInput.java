package retrofit;

import java.io.IOException;
import java.io.InputStream;

import retrofit.mime.TypedInput;

class ExceptionCatchingTypedInput
        implements TypedInput {
    private final TypedInput delegate;
    private final ExceptionCatchingTypedInput.ExceptionCatchingInputStream delegateStream;

    ExceptionCatchingTypedInput(TypedInput paramTypedInput) {
        this.delegate = paramTypedInput;
        this.delegateStream = new ExceptionCatchingTypedInput.ExceptionCatchingInputStream(paramTypedInput.in());
    }

    IOException getThrownException() {
        return ExceptionCatchingTypedInput.ExceptionCatchingInputStream.access$000(this.delegateStream);
    }

    public InputStream in() {
        return this.delegateStream;
    }

    public long length() {
        return this.delegate.length();
    }

    public String mimeType() {
        return this.delegate.mimeType();
    }

    boolean threwException() {
        return ExceptionCatchingTypedInput.ExceptionCatchingInputStream.access$000(this.delegateStream) != null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/retrofit/ExceptionCatchingTypedInput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */