package javassist.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

public class ClassFileWriter {
    private ClassFileWriter.ConstPoolWriter constPool;
    private ClassFileWriter.FieldWriter fields;
    private ClassFileWriter.MethodWriter methods;
    private ByteStream output = new ByteStream(512);
    int superClass;
    int thisClass;

    public ClassFileWriter(int paramInt1, int paramInt2) {
        this.output.writeInt(-889275714);
        this.output.writeShort(paramInt2);
        this.output.writeShort(paramInt1);
        this.constPool = new ClassFileWriter.ConstPoolWriter(this.output);
        this.fields = new ClassFileWriter.FieldWriter(this.constPool);
        this.methods = new ClassFileWriter.MethodWriter(this.constPool);
    }

    static void writeAttribute(ByteStream paramByteStream, ClassFileWriter.AttributeWriter paramAttributeWriter, int paramInt) {
        if (paramAttributeWriter == null) {
            paramByteStream.writeShort(paramInt);
            return;
        }
        paramByteStream.writeShort(paramAttributeWriter.size() + paramInt);
        paramByteStream = new DataOutputStream(paramByteStream);
        try {
            paramAttributeWriter.write(paramByteStream);
            paramByteStream.flush();
            return;
        } catch (IOException paramByteStream) {
        }
    }

    public void end(DataOutputStream paramDataOutputStream, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt, ClassFileWriter.AttributeWriter paramAttributeWriter) {
        this.constPool.end();
        this.output.writeTo(paramDataOutputStream);
        paramDataOutputStream.writeShort(paramInt1);
        paramDataOutputStream.writeShort(paramInt2);
        paramDataOutputStream.writeShort(paramInt3);
        if (paramArrayOfInt == null) {
            paramDataOutputStream.writeShort(0);
        }
        for (; ; ) {
            paramDataOutputStream.writeShort(this.fields.size());
            this.fields.write(paramDataOutputStream);
            paramDataOutputStream.writeShort(this.methods.size());
            this.methods.write(paramDataOutputStream);
            if (paramAttributeWriter != null) {
                break;
            }
            paramDataOutputStream.writeShort(0);
            return;
            paramInt2 = paramArrayOfInt.length;
            paramDataOutputStream.writeShort(paramInt2);
            paramInt1 = 0;
            while (paramInt1 < paramInt2) {
                paramDataOutputStream.writeShort(paramArrayOfInt[paramInt1]);
                paramInt1 += 1;
            }
        }
        paramDataOutputStream.writeShort(paramAttributeWriter.size());
        paramAttributeWriter.write(paramDataOutputStream);
    }

    public byte[] end(int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt, ClassFileWriter.AttributeWriter paramAttributeWriter) {
        this.constPool.end();
        this.output.writeShort(paramInt1);
        this.output.writeShort(paramInt2);
        this.output.writeShort(paramInt3);
        if (paramArrayOfInt == null) {
            this.output.writeShort(0);
        }
        for (; ; ) {
            this.output.enlarge(this.fields.dataSize() + this.methods.dataSize() + 6);
            try {
                this.output.writeShort(this.fields.size());
                this.fields.write(this.output);
                this.output.writeShort(this.methods.size());
                this.methods.write(this.output);
                writeAttribute(this.output, paramAttributeWriter, 0);
                return this.output.toByteArray();
                paramInt2 = paramArrayOfInt.length;
                this.output.writeShort(paramInt2);
                paramInt1 = 0;
                while (paramInt1 < paramInt2) {
                    this.output.writeShort(paramArrayOfInt[paramInt1]);
                    paramInt1 += 1;
                }
            } catch (IOException paramArrayOfInt) {
                for (; ; ) {
                }
            }
        }
    }

    public ClassFileWriter.ConstPoolWriter getConstPool() {
        return this.constPool;
    }

    public ClassFileWriter.FieldWriter getFieldWriter() {
        return this.fields;
    }

    public ClassFileWriter.MethodWriter getMethodWriter() {
        return this.methods;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/ClassFileWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */