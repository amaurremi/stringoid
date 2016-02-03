package javassist.bytecode.annotation;

import java.lang.reflect.Array;
import java.lang.reflect.Method;

import javassist.ClassPool;
import javassist.bytecode.ConstPool;

public class ArrayMemberValue
        extends MemberValue {
    MemberValue type;
    MemberValue[] values;

    public ArrayMemberValue(ConstPool paramConstPool) {
        super('[', paramConstPool);
        this.type = null;
        this.values = null;
    }

    public ArrayMemberValue(MemberValue paramMemberValue, ConstPool paramConstPool) {
        super('[', paramConstPool);
        this.type = paramMemberValue;
        this.values = null;
    }

    public void accept(MemberValueVisitor paramMemberValueVisitor) {
        paramMemberValueVisitor.visitArrayMemberValue(this);
    }

    Class getType(ClassLoader paramClassLoader) {
        if (this.type == null) {
            throw new ClassNotFoundException("no array type specified");
        }
        return Array.newInstance(this.type.getType(paramClassLoader), 0).getClass();
    }

    public MemberValue getType() {
        return this.type;
    }

    Object getValue(ClassLoader paramClassLoader, ClassPool paramClassPool, Method paramMethod) {
        if (this.values == null) {
            throw new ClassNotFoundException("no array elements found: " + paramMethod.getName());
        }
        int j = this.values.length;
        if (this.type == null) {
            localObject = paramMethod.getReturnType().getComponentType();
            if ((localObject == null) || (j > 0)) {
                throw new ClassNotFoundException("broken array type: " + paramMethod.getName());
            }
        } else {
            localObject = this.type.getType(paramClassLoader);
        }
        Object localObject = Array.newInstance((Class) localObject, j);
        int i = 0;
        while (i < j) {
            Array.set(localObject, i, this.values[i].getValue(paramClassLoader, paramClassPool, paramMethod));
            i += 1;
        }
        return localObject;
    }

    public MemberValue[] getValue() {
        return this.values;
    }

    public void setValue(MemberValue[] paramArrayOfMemberValue) {
        this.values = paramArrayOfMemberValue;
        if ((paramArrayOfMemberValue != null) && (paramArrayOfMemberValue.length > 0)) {
            this.type = paramArrayOfMemberValue[0];
        }
    }

    public String toString() {
        StringBuffer localStringBuffer = new StringBuffer("{");
        if (this.values != null) {
            int i = 0;
            while (i < this.values.length) {
                localStringBuffer.append(this.values[i].toString());
                if (i + 1 < this.values.length) {
                    localStringBuffer.append(", ");
                }
                i += 1;
            }
        }
        localStringBuffer.append("}");
        return localStringBuffer.toString();
    }

    public void write(AnnotationsWriter paramAnnotationsWriter) {
        int j = this.values.length;
        paramAnnotationsWriter.arrayValue(j);
        int i = 0;
        while (i < j) {
            this.values[i].write(paramAnnotationsWriter);
            i += 1;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/annotation/ArrayMemberValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */