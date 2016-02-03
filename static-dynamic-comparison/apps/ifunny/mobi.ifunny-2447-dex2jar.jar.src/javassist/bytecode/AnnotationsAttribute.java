package javassist.bytecode;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javassist.bytecode.annotation.Annotation;
import javassist.bytecode.annotation.AnnotationsWriter;

public class AnnotationsAttribute
        extends AttributeInfo {
    public static final String invisibleTag = "RuntimeInvisibleAnnotations";
    public static final String visibleTag = "RuntimeVisibleAnnotations";

    AnnotationsAttribute(ConstPool paramConstPool, int paramInt, DataInputStream paramDataInputStream) {
        super(paramConstPool, paramInt, paramDataInputStream);
    }

    public AnnotationsAttribute(ConstPool paramConstPool, String paramString) {
        this(paramConstPool, paramString, new byte[]{0, 0});
    }

    public AnnotationsAttribute(ConstPool paramConstPool, String paramString, byte[] paramArrayOfByte) {
        super(paramConstPool, paramString, paramArrayOfByte);
    }

    public void addAnnotation(Annotation paramAnnotation) {
        Object localObject = paramAnnotation.getTypeName();
        Annotation[] arrayOfAnnotation = getAnnotations();
        int i = 0;
        while (i < arrayOfAnnotation.length) {
            if (arrayOfAnnotation[i].getTypeName().equals(localObject)) {
                arrayOfAnnotation[i] = paramAnnotation;
                setAnnotations(arrayOfAnnotation);
                return;
            }
            i += 1;
        }
        localObject = new Annotation[arrayOfAnnotation.length + 1];
        System.arraycopy(arrayOfAnnotation, 0, localObject, 0, arrayOfAnnotation.length);
        localObject[arrayOfAnnotation.length] = paramAnnotation;
        setAnnotations((Annotation[]) localObject);
    }

    public AttributeInfo copy(ConstPool paramConstPool, Map paramMap) {
        paramMap = new AnnotationsAttribute.Copier(this.info, this.constPool, paramConstPool, paramMap);
        try {
            paramMap.annotationArray();
            paramConstPool = new AnnotationsAttribute(paramConstPool, getName(), paramMap.close());
            return paramConstPool;
        } catch (Exception paramConstPool) {
            throw new RuntimeException(paramConstPool);
        }
    }

    public Annotation getAnnotation(String paramString) {
        Annotation[] arrayOfAnnotation = getAnnotations();
        int i = 0;
        while (i < arrayOfAnnotation.length) {
            if (arrayOfAnnotation[i].getTypeName().equals(paramString)) {
                return arrayOfAnnotation[i];
            }
            i += 1;
        }
        return null;
    }

    public Annotation[] getAnnotations() {
        try {
            Annotation[] arrayOfAnnotation = new AnnotationsAttribute.Parser(this.info, this.constPool).parseAnnotations();
            return arrayOfAnnotation;
        } catch (Exception localException) {
            throw new RuntimeException(localException);
        }
    }

    void getRefClasses(Map paramMap) {
        renameClass(paramMap);
    }

    public int numAnnotations() {
        return ByteArray.readU16bit(this.info, 0);
    }

    void renameClass(String paramString1, String paramString2) {
        HashMap localHashMap = new HashMap();
        localHashMap.put(paramString1, paramString2);
        renameClass(localHashMap);
    }

    void renameClass(Map paramMap) {
        paramMap = new AnnotationsAttribute.Renamer(this.info, getConstPool(), paramMap);
        try {
            paramMap.annotationArray();
            return;
        } catch (Exception paramMap) {
            throw new RuntimeException(paramMap);
        }
    }

    public void setAnnotation(Annotation paramAnnotation) {
        setAnnotations(new Annotation[]{paramAnnotation});
    }

    public void setAnnotations(Annotation[] paramArrayOfAnnotation) {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        AnnotationsWriter localAnnotationsWriter = new AnnotationsWriter(localByteArrayOutputStream, this.constPool);
        try {
            int j = paramArrayOfAnnotation.length;
            localAnnotationsWriter.numAnnotations(j);
            int i = 0;
            while (i < j) {
                paramArrayOfAnnotation[i].write(localAnnotationsWriter);
                i += 1;
            }
            localAnnotationsWriter.close();
            set(localByteArrayOutputStream.toByteArray());
            return;
        } catch (IOException paramArrayOfAnnotation) {
            throw new RuntimeException(paramArrayOfAnnotation);
        }
    }

    public String toString() {
        Annotation[] arrayOfAnnotation = getAnnotations();
        StringBuilder localStringBuilder = new StringBuilder();
        int i = 0;
        for (; ; ) {
            int j;
            if (i < arrayOfAnnotation.length) {
                j = i + 1;
                localStringBuilder.append(arrayOfAnnotation[i].toString());
                if (j != arrayOfAnnotation.length) {
                    localStringBuilder.append(", ");
                    i = j;
                }
            } else {
                return localStringBuilder.toString();
            }
            i = j;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/AnnotationsAttribute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */