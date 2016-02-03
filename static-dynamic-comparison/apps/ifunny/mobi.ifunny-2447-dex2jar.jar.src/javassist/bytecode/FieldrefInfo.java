package javassist.bytecode;

import java.io.DataInputStream;

class FieldrefInfo
        extends MemberrefInfo {
    static final int tag = 9;

    public FieldrefInfo(int paramInt1, int paramInt2, int paramInt3) {
        super(paramInt1, paramInt2, paramInt3);
    }

    public FieldrefInfo(DataInputStream paramDataInputStream, int paramInt) {
        super(paramDataInputStream, paramInt);
    }

    protected int copy2(ConstPool paramConstPool, int paramInt1, int paramInt2) {
        return paramConstPool.addFieldrefInfo(paramInt1, paramInt2);
    }

    public int getTag() {
        return 9;
    }

    public String getTagName() {
        return "Field";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/FieldrefInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */