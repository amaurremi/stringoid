package javassist.bytecode;

import java.io.OutputStream;

public final class ClassFileWriter$FieldWriter {
    protected ClassFileWriter.ConstPoolWriter constPool;
    private int fieldCount;
    protected ByteStream output = new ByteStream(128);

    ClassFileWriter$FieldWriter(ClassFileWriter.ConstPoolWriter paramConstPoolWriter) {
        this.constPool = paramConstPoolWriter;
        this.fieldCount = 0;
    }

    public void add(int paramInt1, int paramInt2, int paramInt3, ClassFileWriter.AttributeWriter paramAttributeWriter) {
        this.fieldCount += 1;
        this.output.writeShort(paramInt1);
        this.output.writeShort(paramInt2);
        this.output.writeShort(paramInt3);
        ClassFileWriter.writeAttribute(this.output, paramAttributeWriter, 0);
    }

    public void add(int paramInt, String paramString1, String paramString2, ClassFileWriter.AttributeWriter paramAttributeWriter) {
        add(paramInt, this.constPool.addUtf8Info(paramString1), this.constPool.addUtf8Info(paramString2), paramAttributeWriter);
    }

    int dataSize() {
        return this.output.size();
    }

    int size() {
        return this.fieldCount;
    }

    void write(OutputStream paramOutputStream) {
        this.output.writeTo(paramOutputStream);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/ClassFileWriter$FieldWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */