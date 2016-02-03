package javassist.bytecode.annotation;

import java.io.OutputStream;

import javassist.bytecode.ByteArray;
import javassist.bytecode.ConstPool;

public class AnnotationsWriter {
    private OutputStream output;
    private ConstPool pool;

    public AnnotationsWriter(OutputStream paramOutputStream, ConstPool paramConstPool) {
        this.output = paramOutputStream;
        this.pool = paramConstPool;
    }

    private void write16bit(int paramInt) {
        byte[] arrayOfByte = new byte[2];
        ByteArray.write16bit(paramInt, arrayOfByte, 0);
        this.output.write(arrayOfByte);
    }

    public void annotation(int paramInt1, int paramInt2) {
        write16bit(paramInt1);
        write16bit(paramInt2);
    }

    public void annotation(String paramString, int paramInt) {
        annotation(this.pool.addUtf8Info(paramString), paramInt);
    }

    public void annotationValue() {
        this.output.write(64);
    }

    public void arrayValue(int paramInt) {
        this.output.write(91);
        write16bit(paramInt);
    }

    public void classInfoIndex(int paramInt) {
        this.output.write(99);
        write16bit(paramInt);
    }

    public void classInfoIndex(String paramString) {
        classInfoIndex(this.pool.addUtf8Info(paramString));
    }

    public void close() {
        this.output.close();
    }

    public void constValueIndex(byte paramByte) {
        constValueIndex(66, this.pool.addIntegerInfo(paramByte));
    }

    public void constValueIndex(char paramChar) {
        constValueIndex(67, this.pool.addIntegerInfo(paramChar));
    }

    public void constValueIndex(double paramDouble) {
        constValueIndex(68, this.pool.addDoubleInfo(paramDouble));
    }

    public void constValueIndex(float paramFloat) {
        constValueIndex(70, this.pool.addFloatInfo(paramFloat));
    }

    public void constValueIndex(int paramInt) {
        constValueIndex(73, this.pool.addIntegerInfo(paramInt));
    }

    public void constValueIndex(int paramInt1, int paramInt2) {
        this.output.write(paramInt1);
        write16bit(paramInt2);
    }

    public void constValueIndex(long paramLong) {
        constValueIndex(74, this.pool.addLongInfo(paramLong));
    }

    public void constValueIndex(String paramString) {
        constValueIndex(115, this.pool.addUtf8Info(paramString));
    }

    public void constValueIndex(short paramShort) {
        constValueIndex(83, this.pool.addIntegerInfo(paramShort));
    }

    public void constValueIndex(boolean paramBoolean) {
        ConstPool localConstPool = this.pool;
        if (paramBoolean) {
        }
        for (int i = 1; ; i = 0) {
            constValueIndex(90, localConstPool.addIntegerInfo(i));
            return;
        }
    }

    public void enumConstValue(int paramInt1, int paramInt2) {
        this.output.write(101);
        write16bit(paramInt1);
        write16bit(paramInt2);
    }

    public void enumConstValue(String paramString1, String paramString2) {
        enumConstValue(this.pool.addUtf8Info(paramString1), this.pool.addUtf8Info(paramString2));
    }

    public ConstPool getConstPool() {
        return this.pool;
    }

    public void memberValuePair(int paramInt) {
        write16bit(paramInt);
    }

    public void memberValuePair(String paramString) {
        memberValuePair(this.pool.addUtf8Info(paramString));
    }

    public void numAnnotations(int paramInt) {
        write16bit(paramInt);
    }

    public void numParameters(int paramInt) {
        this.output.write(paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/annotation/AnnotationsWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */