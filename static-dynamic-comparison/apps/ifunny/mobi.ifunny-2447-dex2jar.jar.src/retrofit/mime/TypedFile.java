package retrofit.mime;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TypedFile
        implements TypedInput, TypedOutput {
    private static final int BUFFER_SIZE = 4096;
    private final File file;
    private final String mimeType;

    public TypedFile(String paramString, File paramFile) {
        if (paramString == null) {
            throw new NullPointerException("mimeType");
        }
        if (paramFile == null) {
            throw new NullPointerException("file");
        }
        this.mimeType = paramString;
        this.file = paramFile;
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
            return true;
        }
        if ((paramObject instanceof TypedFile)) {
            paramObject = (TypedFile) paramObject;
            return this.file.equals(((TypedFile) paramObject).file);
        }
        return false;
    }

    public File file() {
        return this.file;
    }

    public String fileName() {
        return this.file.getName();
    }

    public int hashCode() {
        return this.file.hashCode();
    }

    public InputStream in() {
        return new FileInputStream(this.file);
    }

    public long length() {
        return this.file.length();
    }

    public String mimeType() {
        return this.mimeType;
    }

    public void moveTo(TypedFile paramTypedFile) {
        if (!mimeType().equals(paramTypedFile.mimeType())) {
            throw new IOException("Type mismatch.");
        }
        if (!this.file.renameTo(paramTypedFile.file())) {
            throw new IOException("Rename failed!");
        }
    }

    public String toString() {
        return this.file.getAbsolutePath() + " (" + mimeType() + ")";
    }

    public void writeTo(OutputStream paramOutputStream) {
        byte[] arrayOfByte = new byte['က'];
        FileInputStream localFileInputStream = new FileInputStream(this.file);
        try {
            for (; ; ) {
                int i = localFileInputStream.read(arrayOfByte);
                if (i == -1) {
                    break;
                }
                paramOutputStream.write(arrayOfByte, 0, i);
            }
        } finally {
            localFileInputStream.close();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/retrofit/mime/TypedFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */