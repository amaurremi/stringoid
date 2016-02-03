package javassist.bytecode;

public final class ClassFileWriter$ConstPoolWriter {
    protected int num;
    ByteStream output;
    protected int startPos;

    ClassFileWriter$ConstPoolWriter(ByteStream paramByteStream) {
        this.output = paramByteStream;
        this.startPos = paramByteStream.getPos();
        this.num = 1;
        this.output.writeShort(1);
    }

    public int addClassInfo(int paramInt) {
        this.output.write(7);
        this.output.writeShort(paramInt);
        paramInt = this.num;
        this.num = (paramInt + 1);
        return paramInt;
    }

    public int addClassInfo(String paramString) {
        int i = addUtf8Info(paramString);
        this.output.write(7);
        this.output.writeShort(i);
        i = this.num;
        this.num = (i + 1);
        return i;
    }

    public int[] addClassInfo(String[] paramArrayOfString) {
        int j = paramArrayOfString.length;
        int[] arrayOfInt = new int[j];
        int i = 0;
        while (i < j) {
            arrayOfInt[i] = addClassInfo(paramArrayOfString[i]);
            i += 1;
        }
        return arrayOfInt;
    }

    public int addDoubleInfo(double paramDouble) {
        this.output.write(6);
        this.output.writeDouble(paramDouble);
        int i = this.num;
        this.num += 2;
        return i;
    }

    public int addFieldrefInfo(int paramInt1, int paramInt2) {
        this.output.write(9);
        this.output.writeShort(paramInt1);
        this.output.writeShort(paramInt2);
        paramInt1 = this.num;
        this.num = (paramInt1 + 1);
        return paramInt1;
    }

    public int addFloatInfo(float paramFloat) {
        this.output.write(4);
        this.output.writeFloat(paramFloat);
        int i = this.num;
        this.num = (i + 1);
        return i;
    }

    public int addIntegerInfo(int paramInt) {
        this.output.write(3);
        this.output.writeInt(paramInt);
        paramInt = this.num;
        this.num = (paramInt + 1);
        return paramInt;
    }

    public int addInterfaceMethodrefInfo(int paramInt1, int paramInt2) {
        this.output.write(11);
        this.output.writeShort(paramInt1);
        this.output.writeShort(paramInt2);
        paramInt1 = this.num;
        this.num = (paramInt1 + 1);
        return paramInt1;
    }

    public int addLongInfo(long paramLong) {
        this.output.write(5);
        this.output.writeLong(paramLong);
        int i = this.num;
        this.num += 2;
        return i;
    }

    public int addMethodrefInfo(int paramInt1, int paramInt2) {
        this.output.write(10);
        this.output.writeShort(paramInt1);
        this.output.writeShort(paramInt2);
        paramInt1 = this.num;
        this.num = (paramInt1 + 1);
        return paramInt1;
    }

    public int addNameAndTypeInfo(int paramInt1, int paramInt2) {
        this.output.write(12);
        this.output.writeShort(paramInt1);
        this.output.writeShort(paramInt2);
        paramInt1 = this.num;
        this.num = (paramInt1 + 1);
        return paramInt1;
    }

    public int addNameAndTypeInfo(String paramString1, String paramString2) {
        return addNameAndTypeInfo(addUtf8Info(paramString1), addUtf8Info(paramString2));
    }

    public int addStringInfo(String paramString) {
        int i = addUtf8Info(paramString);
        this.output.write(8);
        this.output.writeShort(i);
        i = this.num;
        this.num = (i + 1);
        return i;
    }

    public int addUtf8Info(String paramString) {
        this.output.write(1);
        this.output.writeUTF(paramString);
        int i = this.num;
        this.num = (i + 1);
        return i;
    }

    void end() {
        this.output.writeShort(this.startPos, this.num);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/ClassFileWriter$ConstPoolWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */