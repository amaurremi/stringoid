package javassist.bytecode;

import java.io.ByteArrayOutputStream;
import java.util.Map;

import javassist.bytecode.annotation.AnnotationsWriter;

class AnnotationsAttribute$Copier
        extends AnnotationsAttribute.Walker {
    Map classnames;
    ConstPool destPool;
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    ConstPool srcPool;
    AnnotationsWriter writer;

    AnnotationsAttribute$Copier(byte[] paramArrayOfByte, ConstPool paramConstPool1, ConstPool paramConstPool2, Map paramMap) {
        super(paramArrayOfByte);
        this.writer = new AnnotationsWriter(this.output, paramConstPool2);
        this.srcPool = paramConstPool1;
        this.destPool = paramConstPool2;
        this.classnames = paramMap;
    }

    int annotation(int paramInt1, int paramInt2, int paramInt3) {
        this.writer.annotation(copyType(paramInt2), paramInt3);
        return super.annotation(paramInt1, paramInt2, paramInt3);
    }

    int annotationArray(int paramInt1, int paramInt2) {
        this.writer.numAnnotations(paramInt2);
        return super.annotationArray(paramInt1, paramInt2);
    }

    int annotationMemberValue(int paramInt) {
        this.writer.annotationValue();
        return super.annotationMemberValue(paramInt);
    }

    int arrayMemberValue(int paramInt1, int paramInt2) {
        this.writer.arrayValue(paramInt2);
        return super.arrayMemberValue(paramInt1, paramInt2);
    }

    void classMemberValue(int paramInt1, int paramInt2) {
        this.writer.classInfoIndex(copyType(paramInt2));
        super.classMemberValue(paramInt1, paramInt2);
    }

    byte[] close() {
        this.writer.close();
        return this.output.toByteArray();
    }

    void constValueMember(int paramInt1, int paramInt2) {
        this.writer.constValueIndex(paramInt1, copy(paramInt2));
        super.constValueMember(paramInt1, paramInt2);
    }

    int copy(int paramInt) {
        return this.srcPool.copy(paramInt, this.destPool, this.classnames);
    }

    int copyType(int paramInt) {
        String str = Descriptor.rename(this.srcPool.getUtf8Info(paramInt), this.classnames);
        return this.destPool.addUtf8Info(str);
    }

    void enumMemberValue(int paramInt1, int paramInt2, int paramInt3) {
        this.writer.enumConstValue(copyType(paramInt2), copy(paramInt3));
        super.enumMemberValue(paramInt1, paramInt2, paramInt3);
    }

    int memberValuePair(int paramInt1, int paramInt2) {
        this.writer.memberValuePair(copy(paramInt2));
        return super.memberValuePair(paramInt1, paramInt2);
    }

    void parameters(int paramInt1, int paramInt2) {
        this.writer.numParameters(paramInt1);
        super.parameters(paramInt1, paramInt2);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/AnnotationsAttribute$Copier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */