package retrofit.mime;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public final class MultipartTypedOutput
        implements TypedOutput {
    public static final String DEFAULT_TRANSFER_ENCODING = "binary";
    private final String boundary;
    private final byte[] footer;
    private long length;
    private final List<MultipartTypedOutput.MimePart> mimeParts = new LinkedList();

    public MultipartTypedOutput() {
        this(UUID.randomUUID().toString());
    }

    MultipartTypedOutput(String paramString) {
        this.boundary = paramString;
        this.footer = buildBoundary(paramString, false, true);
        this.length = this.footer.length;
    }

    private static byte[] buildBoundary(String paramString, boolean paramBoolean1, boolean paramBoolean2) {
        try {
            StringBuilder localStringBuilder = new StringBuilder(paramString.length() + 8);
            if (!paramBoolean1) {
                localStringBuilder.append("\r\n");
            }
            localStringBuilder.append("--");
            localStringBuilder.append(paramString);
            if (paramBoolean2) {
                localStringBuilder.append("--");
            }
            localStringBuilder.append("\r\n");
            paramString = localStringBuilder.toString().getBytes("UTF-8");
            return paramString;
        } catch (IOException paramString) {
            throw new RuntimeException("Unable to write multipart boundary", paramString);
        }
    }

    private static byte[] buildHeader(String paramString1, String paramString2, TypedOutput paramTypedOutput) {
        try {
            StringBuilder localStringBuilder = new StringBuilder(128);
            localStringBuilder.append("Content-Disposition: form-data; name=\"");
            localStringBuilder.append(paramString1);
            paramString1 = paramTypedOutput.fileName();
            if (paramString1 != null) {
                localStringBuilder.append("\"; filename=\"");
                localStringBuilder.append(paramString1);
            }
            localStringBuilder.append("\"\r\nContent-Type: ");
            localStringBuilder.append(paramTypedOutput.mimeType());
            long l = paramTypedOutput.length();
            if (l != -1L) {
                localStringBuilder.append("\r\nContent-Length: ").append(l);
            }
            localStringBuilder.append("\r\nContent-Transfer-Encoding: ");
            localStringBuilder.append(paramString2);
            localStringBuilder.append("\r\n\r\n");
            paramString1 = localStringBuilder.toString().getBytes("UTF-8");
            return paramString1;
        } catch (IOException paramString1) {
            throw new RuntimeException("Unable to write multipart header", paramString1);
        }
    }

    public void addPart(String paramString1, String paramString2, TypedOutput paramTypedOutput) {
        if (paramString1 == null) {
            throw new NullPointerException("Part name must not be null.");
        }
        if (paramString2 == null) {
            throw new NullPointerException("Transfer encoding must not be null.");
        }
        if (paramTypedOutput == null) {
            throw new NullPointerException("Part body must not be null.");
        }
        paramString1 = new MultipartTypedOutput.MimePart(paramString1, paramString2, paramTypedOutput, this.boundary, this.mimeParts.isEmpty());
        this.mimeParts.add(paramString1);
        long l = paramString1.size();
        if (l == -1L) {
            this.length = -1L;
        }
        while (this.length == -1L) {
            return;
        }
        this.length = (l + this.length);
    }

    public void addPart(String paramString, TypedOutput paramTypedOutput) {
        addPart(paramString, "binary", paramTypedOutput);
    }

    public String fileName() {
        return null;
    }

    public int getPartCount() {
        return this.mimeParts.size();
    }

    List<byte[]> getParts() {
        ArrayList localArrayList = new ArrayList(this.mimeParts.size());
        Iterator localIterator = this.mimeParts.iterator();
        while (localIterator.hasNext()) {
            MultipartTypedOutput.MimePart localMimePart = (MultipartTypedOutput.MimePart) localIterator.next();
            ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
            localMimePart.writeTo(localByteArrayOutputStream);
            localArrayList.add(localByteArrayOutputStream.toByteArray());
        }
        return localArrayList;
    }

    public long length() {
        return this.length;
    }

    public String mimeType() {
        return "multipart/form-data; boundary=" + this.boundary;
    }

    public void writeTo(OutputStream paramOutputStream) {
        Iterator localIterator = this.mimeParts.iterator();
        while (localIterator.hasNext()) {
            ((MultipartTypedOutput.MimePart) localIterator.next()).writeTo(paramOutputStream);
        }
        paramOutputStream.write(this.footer);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/retrofit/mime/MultipartTypedOutput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */