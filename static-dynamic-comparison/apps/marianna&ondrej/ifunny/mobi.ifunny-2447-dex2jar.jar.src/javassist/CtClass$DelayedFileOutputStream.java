package javassist;

import java.io.FileOutputStream;
import java.io.OutputStream;

class CtClass$DelayedFileOutputStream
        extends OutputStream {
    private FileOutputStream file = null;
    private String filename;

    CtClass$DelayedFileOutputStream(String paramString) {
        this.filename = paramString;
    }

    private void init() {
        if (this.file == null) {
            this.file = new FileOutputStream(this.filename);
        }
    }

    public void close() {
        init();
        this.file.close();
    }

    public void flush() {
        init();
        this.file.flush();
    }

    public void write(int paramInt) {
        init();
        this.file.write(paramInt);
    }

    public void write(byte[] paramArrayOfByte) {
        init();
        this.file.write(paramArrayOfByte);
    }

    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {
        init();
        this.file.write(paramArrayOfByte, paramInt1, paramInt2);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/CtClass$DelayedFileOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */