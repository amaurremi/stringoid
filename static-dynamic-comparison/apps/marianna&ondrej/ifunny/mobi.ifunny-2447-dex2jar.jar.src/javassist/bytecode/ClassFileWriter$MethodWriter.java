package javassist.bytecode;

import java.io.OutputStream;

public final class ClassFileWriter$MethodWriter {
    private int catchCount;
    private int catchPos;
    protected int codeIndex;
    protected ClassFileWriter.ConstPoolWriter constPool;
    private boolean isAbstract;
    private int methodCount;
    protected ByteStream output = new ByteStream(256);
    protected int stackIndex;
    private int startPos;
    protected int throwsIndex;

    ClassFileWriter$MethodWriter(ClassFileWriter.ConstPoolWriter paramConstPoolWriter) {
        this.constPool = paramConstPoolWriter;
        this.methodCount = 0;
        this.codeIndex = 0;
        this.throwsIndex = 0;
        this.stackIndex = 0;
    }

    private void writeThrows(int[] paramArrayOfInt) {
        if (this.throwsIndex == 0) {
            this.throwsIndex = this.constPool.addUtf8Info("Exceptions");
        }
        this.output.writeShort(this.throwsIndex);
        this.output.writeInt(paramArrayOfInt.length * 2 + 2);
        this.output.writeShort(paramArrayOfInt.length);
        int i = 0;
        while (i < paramArrayOfInt.length) {
            this.output.writeShort(paramArrayOfInt[i]);
            i += 1;
        }
    }

    public void add(int paramInt) {
        this.output.write(paramInt);
    }

    public void add16(int paramInt) {
        this.output.writeShort(paramInt);
    }

    public void add32(int paramInt) {
        this.output.writeInt(paramInt);
    }

    public void addCatch(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        this.catchCount += 1;
        this.output.writeShort(paramInt1);
        this.output.writeShort(paramInt2);
        this.output.writeShort(paramInt3);
        this.output.writeShort(paramInt4);
    }

    public void addInvoke(int paramInt, String paramString1, String paramString2, String paramString3) {
        int i = this.constPool.addClassInfo(paramString1);
        int j = this.constPool.addNameAndTypeInfo(paramString2, paramString3);
        i = this.constPool.addMethodrefInfo(i, j);
        add(paramInt);
        add16(i);
    }

    public void begin(int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt, ClassFileWriter.AttributeWriter paramAttributeWriter) {
        this.methodCount += 1;
        this.output.writeShort(paramInt1);
        this.output.writeShort(paramInt2);
        this.output.writeShort(paramInt3);
        boolean bool;
        if ((paramInt1 & 0x400) != 0) {
            bool = true;
            this.isAbstract = bool;
            if (!this.isAbstract) {
                break label167;
            }
        }
        label167:
        for (paramInt1 = 0; ; paramInt1 = 1) {
            paramInt2 = paramInt1;
            if (paramArrayOfInt != null) {
                paramInt2 = paramInt1 + 1;
            }
            ClassFileWriter.writeAttribute(this.output, paramAttributeWriter, paramInt2);
            if (paramArrayOfInt != null) {
                writeThrows(paramArrayOfInt);
            }
            if (!this.isAbstract) {
                if (this.codeIndex == 0) {
                    this.codeIndex = this.constPool.addUtf8Info("Code");
                }
                this.startPos = this.output.getPos();
                this.output.writeShort(this.codeIndex);
                this.output.writeBlank(12);
            }
            this.catchPos = -1;
            this.catchCount = 0;
            return;
            bool = false;
            break;
        }
    }

    public void begin(int paramInt, String paramString1, String paramString2, String[] paramArrayOfString, ClassFileWriter.AttributeWriter paramAttributeWriter) {
        int i = this.constPool.addUtf8Info(paramString1);
        int j = this.constPool.addUtf8Info(paramString2);
        if (paramArrayOfString == null) {
        }
        for (paramString1 = null; ; paramString1 = this.constPool.addClassInfo(paramArrayOfString)) {
            begin(paramInt, i, j, paramString1, paramAttributeWriter);
            return;
        }
    }

    public void codeEnd(int paramInt1, int paramInt2) {
        if (!this.isAbstract) {
            this.output.writeShort(this.startPos + 6, paramInt1);
            this.output.writeShort(this.startPos + 8, paramInt2);
            this.output.writeInt(this.startPos + 10, this.output.getPos() - this.startPos - 14);
            this.catchPos = this.output.getPos();
            this.catchCount = 0;
            this.output.writeShort(0);
        }
    }

    int dataSize() {
        return this.output.size();
    }

    public void end(StackMapTable.Writer paramWriter, ClassFileWriter.AttributeWriter paramAttributeWriter) {
        if (this.isAbstract) {
            return;
        }
        this.output.writeShort(this.catchPos, this.catchCount);
        if (paramWriter == null) {
        }
        for (int i = 0; ; i = 1) {
            ClassFileWriter.writeAttribute(this.output, paramAttributeWriter, i);
            if (paramWriter != null) {
                if (this.stackIndex == 0) {
                    this.stackIndex = this.constPool.addUtf8Info("StackMapTable");
                }
                this.output.writeShort(this.stackIndex);
                paramWriter = paramWriter.toByteArray();
                this.output.writeInt(paramWriter.length);
                this.output.write(paramWriter);
            }
            this.output.writeInt(this.startPos + 2, this.output.getPos() - this.startPos - 6);
            return;
        }
    }

    int size() {
        return this.methodCount;
    }

    void write(OutputStream paramOutputStream) {
        this.output.writeTo(paramOutputStream);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/ClassFileWriter$MethodWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */