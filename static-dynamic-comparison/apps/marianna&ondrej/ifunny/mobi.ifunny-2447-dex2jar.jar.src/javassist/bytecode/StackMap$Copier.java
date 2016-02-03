package javassist.bytecode;

import java.util.Map;

class StackMap$Copier
        extends StackMap.Walker {
    Map classnames;
    byte[] dest;
    ConstPool destCp;
    ConstPool srcCp;

    StackMap$Copier(StackMap paramStackMap, ConstPool paramConstPool, Map paramMap) {
        super(paramStackMap);
        this.srcCp = paramStackMap.getConstPool();
        this.dest = new byte[this.info.length];
        this.destCp = paramConstPool;
        this.classnames = paramMap;
    }

    public StackMap getStackMap() {
        return new StackMap(this.destCp, this.dest);
    }

    public int locals(int paramInt1, int paramInt2, int paramInt3) {
        ByteArray.write16bit(paramInt2, this.dest, paramInt1 - 4);
        return super.locals(paramInt1, paramInt2, paramInt3);
    }

    public void objectVariable(int paramInt1, int paramInt2) {
        this.dest[paramInt1] = 7;
        ByteArray.write16bit(this.srcCp.copy(paramInt2, this.destCp, this.classnames), this.dest, paramInt1 + 1);
    }

    public void typeInfo(int paramInt, byte paramByte) {
        this.dest[paramInt] = paramByte;
    }

    public int typeInfoArray(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {
        ByteArray.write16bit(paramInt3, this.dest, paramInt1 - 2);
        return super.typeInfoArray(paramInt1, paramInt2, paramInt3, paramBoolean);
    }

    public void uninitialized(int paramInt1, int paramInt2) {
        this.dest[paramInt1] = 8;
        ByteArray.write16bit(paramInt2, this.dest, paramInt1 + 1);
    }

    public void visit() {
        ByteArray.write16bit(ByteArray.readU16bit(this.info, 0), this.dest, 0);
        super.visit();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/StackMap$Copier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */