package javassist.bytecode;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Map;

import javassist.bytecode.annotation.AnnotationsWriter;
import javassist.bytecode.annotation.MemberValue;

public class AnnotationDefaultAttribute
        extends AttributeInfo {
    public static final String tag = "AnnotationDefault";

    public AnnotationDefaultAttribute(ConstPool paramConstPool) {
        this(paramConstPool, new byte[]{0, 0});
    }

    AnnotationDefaultAttribute(ConstPool paramConstPool, int paramInt, DataInputStream paramDataInputStream) {
        super(paramConstPool, paramInt, paramDataInputStream);
    }

    public AnnotationDefaultAttribute(ConstPool paramConstPool, byte[] paramArrayOfByte) {
        super(paramConstPool, "AnnotationDefault", paramArrayOfByte);
    }

    public AttributeInfo copy(ConstPool paramConstPool, Map paramMap) {
        paramMap = new AnnotationsAttribute.Copier(this.info, this.constPool, paramConstPool, paramMap);
        try {
            paramMap.memberValue(0);
            paramConstPool = new AnnotationDefaultAttribute(paramConstPool, paramMap.close());
            return paramConstPool;
        } catch (Exception paramConstPool) {
            throw new RuntimeException(paramConstPool.toString());
        }
    }

    public MemberValue getDefaultValue() {
        try {
            MemberValue localMemberValue = new AnnotationsAttribute.Parser(this.info, this.constPool).parseMemberValue();
            return localMemberValue;
        } catch (Exception localException) {
            throw new RuntimeException(localException.toString());
        }
    }

    public void setDefaultValue(MemberValue paramMemberValue) {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        AnnotationsWriter localAnnotationsWriter = new AnnotationsWriter(localByteArrayOutputStream, this.constPool);
        try {
            paramMemberValue.write(localAnnotationsWriter);
            localAnnotationsWriter.close();
            set(localByteArrayOutputStream.toByteArray());
            return;
        } catch (IOException paramMemberValue) {
            throw new RuntimeException(paramMemberValue);
        }
    }

    public String toString() {
        return getDefaultValue().toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/AnnotationDefaultAttribute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */