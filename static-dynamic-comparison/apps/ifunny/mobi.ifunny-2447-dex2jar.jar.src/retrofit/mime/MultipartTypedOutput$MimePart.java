package retrofit.mime;

import java.io.OutputStream;

final class MultipartTypedOutput$MimePart {
    private final TypedOutput body;
    private final String boundary;
    private boolean isBuilt;
    private final boolean isFirst;
    private final String name;
    private byte[] partBoundary;
    private byte[] partHeader;
    private final String transferEncoding;

    public MultipartTypedOutput$MimePart(String paramString1, String paramString2, TypedOutput paramTypedOutput, String paramString3, boolean paramBoolean) {
        this.name = paramString1;
        this.transferEncoding = paramString2;
        this.body = paramTypedOutput;
        this.isFirst = paramBoolean;
        this.boundary = paramString3;
    }

    private void build() {
        if (this.isBuilt) {
            return;
        }
        this.partBoundary = MultipartTypedOutput.access$000(this.boundary, this.isFirst, false);
        this.partHeader = MultipartTypedOutput.access$100(this.name, this.transferEncoding, this.body);
        this.isBuilt = true;
    }

    public long size() {
        long l = -1L;
        build();
        if (this.body.length() > -1L) {
            l = this.body.length() + this.partBoundary.length + this.partHeader.length;
        }
        return l;
    }

    public void writeTo(OutputStream paramOutputStream) {
        build();
        paramOutputStream.write(this.partBoundary);
        paramOutputStream.write(this.partHeader);
        this.body.writeTo(paramOutputStream);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/retrofit/mime/MultipartTypedOutput$MimePart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */