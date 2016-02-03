package javassist.bytecode;

import java.util.Map;

class AnnotationsAttribute$Renamer
        extends AnnotationsAttribute.Walker {
    Map classnames;
    ConstPool cpool;

    AnnotationsAttribute$Renamer(byte[] paramArrayOfByte, ConstPool paramConstPool, Map paramMap) {
        super(paramArrayOfByte);
        this.cpool = paramConstPool;
        this.classnames = paramMap;
    }

    private void renameType(int paramInt1, int paramInt2) {
        String str1 = this.cpool.getUtf8Info(paramInt2);
        String str2 = Descriptor.rename(str1, this.classnames);
        if (!str1.equals(str2)) {
            ByteArray.write16bit(this.cpool.addUtf8Info(str2), this.info, paramInt1);
        }
    }

    int annotation(int paramInt1, int paramInt2, int paramInt3) {
        renameType(paramInt1 - 4, paramInt2);
        return super.annotation(paramInt1, paramInt2, paramInt3);
    }

    void classMemberValue(int paramInt1, int paramInt2) {
        renameType(paramInt1 + 1, paramInt2);
        super.classMemberValue(paramInt1, paramInt2);
    }

    void enumMemberValue(int paramInt1, int paramInt2, int paramInt3) {
        renameType(paramInt1 + 1, paramInt2);
        super.enumMemberValue(paramInt1, paramInt2, paramInt3);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/AnnotationsAttribute$Renamer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */