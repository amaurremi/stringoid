package javassist.bytecode;

import java.io.ByteArrayOutputStream;

public class StackMap$Writer {
    private ByteArrayOutputStream output = new ByteArrayOutputStream();

    public byte[] toByteArray() {
        return this.output.toByteArray();
    }

    public StackMap toStackMap(ConstPool paramConstPool) {
        return new StackMap(paramConstPool, this.output.toByteArray());
    }

    public void write16bit(int paramInt) {
        this.output.write(paramInt >>> 8 & 0xFF);
        this.output.write(paramInt & 0xFF);
    }

    public void writeVerifyTypeInfo(int paramInt1, int paramInt2) {
        this.output.write(paramInt1);
        if ((paramInt1 == 7) || (paramInt1 == 8)) {
            write16bit(paramInt2);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/StackMap$Writer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */