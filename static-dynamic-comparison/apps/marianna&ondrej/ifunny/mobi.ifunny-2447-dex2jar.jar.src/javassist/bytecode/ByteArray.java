package javassist.bytecode;

public class ByteArray {
    static void copy32bit(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2) {
        paramArrayOfByte2[paramInt2] = paramArrayOfByte1[paramInt1];
        paramArrayOfByte2[(paramInt2 + 1)] = paramArrayOfByte1[(paramInt1 + 1)];
        paramArrayOfByte2[(paramInt2 + 2)] = paramArrayOfByte1[(paramInt1 + 2)];
        paramArrayOfByte2[(paramInt2 + 3)] = paramArrayOfByte1[(paramInt1 + 3)];
    }

    public static int read32bit(byte[] paramArrayOfByte, int paramInt) {
        return paramArrayOfByte[paramInt] << 24 | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 16 | (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 8 | paramArrayOfByte[(paramInt + 3)] & 0xFF;
    }

    public static int readS16bit(byte[] paramArrayOfByte, int paramInt) {
        return paramArrayOfByte[paramInt] << 8 | paramArrayOfByte[(paramInt + 1)] & 0xFF;
    }

    public static int readU16bit(byte[] paramArrayOfByte, int paramInt) {
        return (paramArrayOfByte[paramInt] & 0xFF) << 8 | paramArrayOfByte[(paramInt + 1)] & 0xFF;
    }

    public static void write16bit(int paramInt1, byte[] paramArrayOfByte, int paramInt2) {
        paramArrayOfByte[paramInt2] = ((byte) (paramInt1 >>> 8));
        paramArrayOfByte[(paramInt2 + 1)] = ((byte) paramInt1);
    }

    public static void write32bit(int paramInt1, byte[] paramArrayOfByte, int paramInt2) {
        paramArrayOfByte[paramInt2] = ((byte) (paramInt1 >>> 24));
        paramArrayOfByte[(paramInt2 + 1)] = ((byte) (paramInt1 >>> 16));
        paramArrayOfByte[(paramInt2 + 2)] = ((byte) (paramInt1 >>> 8));
        paramArrayOfByte[(paramInt2 + 3)] = ((byte) paramInt1);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/ByteArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */