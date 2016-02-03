package javassist.bytecode;

import java.io.ByteArrayOutputStream;

public class StackMapTable$Writer {
    int numOfEntries;
    ByteArrayOutputStream output;

    public StackMapTable$Writer(int paramInt) {
        this.output = new ByteArrayOutputStream(paramInt);
        this.numOfEntries = 0;
        this.output.write(0);
        this.output.write(0);
    }

    private void write16(int paramInt) {
        this.output.write(paramInt >>> 8 & 0xFF);
        this.output.write(paramInt & 0xFF);
    }

    private void writeTypeInfo(int paramInt1, int paramInt2) {
        this.output.write(paramInt1);
        if ((paramInt1 == 7) || (paramInt1 == 8)) {
            write16(paramInt2);
        }
    }

    public void appendFrame(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2) {
        this.numOfEntries += 1;
        int i = paramArrayOfInt1.length;
        this.output.write(i + 251);
        write16(paramInt);
        paramInt = 0;
        while (paramInt < i) {
            writeTypeInfo(paramArrayOfInt1[paramInt], paramArrayOfInt2[paramInt]);
            paramInt += 1;
        }
    }

    public void chopFrame(int paramInt1, int paramInt2) {
        this.numOfEntries += 1;
        this.output.write(251 - paramInt2);
        write16(paramInt1);
    }

    public void fullFrame(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4) {
        int i = 0;
        this.numOfEntries += 1;
        this.output.write(255);
        write16(paramInt);
        int j = paramArrayOfInt1.length;
        write16(j);
        paramInt = 0;
        while (paramInt < j) {
            writeTypeInfo(paramArrayOfInt1[paramInt], paramArrayOfInt2[paramInt]);
            paramInt += 1;
        }
        j = paramArrayOfInt3.length;
        write16(j);
        paramInt = i;
        while (paramInt < j) {
            writeTypeInfo(paramArrayOfInt3[paramInt], paramArrayOfInt4[paramInt]);
            paramInt += 1;
        }
    }

    public void sameFrame(int paramInt) {
        this.numOfEntries += 1;
        if (paramInt < 64) {
            this.output.write(paramInt);
            return;
        }
        this.output.write(251);
        write16(paramInt);
    }

    public void sameLocals(int paramInt1, int paramInt2, int paramInt3) {
        this.numOfEntries += 1;
        if (paramInt1 < 64) {
            this.output.write(paramInt1 + 64);
        }
        for (; ; ) {
            writeTypeInfo(paramInt2, paramInt3);
            return;
            this.output.write(247);
            write16(paramInt1);
        }
    }

    public byte[] toByteArray() {
        byte[] arrayOfByte = this.output.toByteArray();
        ByteArray.write16bit(this.numOfEntries, arrayOfByte, 0);
        return arrayOfByte;
    }

    public StackMapTable toStackMapTable(ConstPool paramConstPool) {
        return new StackMapTable(paramConstPool, toByteArray());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/StackMapTable$Writer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */