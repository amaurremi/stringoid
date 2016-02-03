package javassist.bytecode;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javassist.bytecode.annotation.Annotation;
import javassist.bytecode.annotation.AnnotationsWriter;

public class ParameterAnnotationsAttribute
        extends AttributeInfo {
    public static final String invisibleTag = "RuntimeInvisibleParameterAnnotations";
    public static final String visibleTag = "RuntimeVisibleParameterAnnotations";

    ParameterAnnotationsAttribute(ConstPool paramConstPool, int paramInt, DataInputStream paramDataInputStream) {
        super(paramConstPool, paramInt, paramDataInputStream);
    }

    public ParameterAnnotationsAttribute(ConstPool paramConstPool, String paramString) {
        this(paramConstPool, paramString, new byte[]{0});
    }

    public ParameterAnnotationsAttribute(ConstPool paramConstPool, String paramString, byte[] paramArrayOfByte) {
        super(paramConstPool, paramString, paramArrayOfByte);
    }

    public AttributeInfo copy(ConstPool paramConstPool, Map paramMap) {
        paramMap = new AnnotationsAttribute.Copier(this.info, this.constPool, paramConstPool, paramMap);
        try {
            paramMap.parameters();
            paramConstPool = new ParameterAnnotationsAttribute(paramConstPool, getName(), paramMap.close());
            return paramConstPool;
        } catch (Exception paramConstPool) {
            throw new RuntimeException(paramConstPool.toString());
        }
    }

    public Annotation[][] getAnnotations() {
        try {
            Annotation[][] arrayOfAnnotation = new AnnotationsAttribute.Parser(this.info, this.constPool).parseParameters();
            return arrayOfAnnotation;
        } catch (Exception localException) {
            throw new RuntimeException(localException.toString());
        }
    }

    void getRefClasses(Map paramMap) {
        renameClass(paramMap);
    }

    public int numParameters() {
        return this.info[0] & 0xFF;
    }

    void renameClass(String paramString1, String paramString2) {
        HashMap localHashMap = new HashMap();
        localHashMap.put(paramString1, paramString2);
        renameClass(localHashMap);
    }

    void renameClass(Map paramMap) {
        paramMap = new AnnotationsAttribute.Renamer(this.info, getConstPool(), paramMap);
        try {
            paramMap.parameters();
            return;
        } catch (Exception paramMap) {
            throw new RuntimeException(paramMap);
        }
    }

    public void setAnnotations(Annotation[][] paramArrayOfAnnotation) {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        AnnotationsWriter localAnnotationsWriter = new AnnotationsWriter(localByteArrayOutputStream, this.constPool);
        for (; ; ) {
            int i;
            try {
                int k = paramArrayOfAnnotation.length;
                localAnnotationsWriter.numParameters(k);
                i = 0;
                if (i < k) {
                    Annotation[] arrayOfAnnotation = paramArrayOfAnnotation[i];
                    localAnnotationsWriter.numAnnotations(arrayOfAnnotation.length);
                    int j = 0;
                    if (j < arrayOfAnnotation.length) {
                        arrayOfAnnotation[j].write(localAnnotationsWriter);
                        j += 1;
                        continue;
                    }
                } else {
                    localAnnotationsWriter.close();
                    set(localByteArrayOutputStream.toByteArray());
                    return;
                }
            } catch (IOException paramArrayOfAnnotation) {
                throw new RuntimeException(paramArrayOfAnnotation);
            }
            i += 1;
        }
    }

    public String toString() {
        Annotation[][] arrayOfAnnotation = getAnnotations();
        StringBuilder localStringBuilder = new StringBuilder();
        int i = 0;
        int k;
        Annotation[] arrayOfAnnotation1;
        if (i < arrayOfAnnotation.length) {
            k = i + 1;
            arrayOfAnnotation1 = arrayOfAnnotation[i];
            i = 0;
        }
        for (; ; ) {
            int j;
            if (i < arrayOfAnnotation1.length) {
                j = i + 1;
                localStringBuilder.append(arrayOfAnnotation1[i].toString());
                if (j != arrayOfAnnotation1.length) {
                    localStringBuilder.append(" ");
                    i = j;
                }
            } else {
                if (k != arrayOfAnnotation.length) {
                    localStringBuilder.append(", ");
                }
                i = k;
                break;
                return localStringBuilder.toString();
            }
            i = j;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/ParameterAnnotationsAttribute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */