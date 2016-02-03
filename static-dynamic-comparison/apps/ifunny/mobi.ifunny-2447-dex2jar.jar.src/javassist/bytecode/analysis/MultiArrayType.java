package javassist.bytecode.analysis;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;

public class MultiArrayType
        extends Type {
    private MultiType component;
    private int dims;

    public MultiArrayType(MultiType paramMultiType, int paramInt) {
        super(null);
        this.component = paramMultiType;
        this.dims = paramInt;
    }

    public boolean equals(Object paramObject) {
        if (!(paramObject instanceof MultiArrayType)) {
        }
        do {
            return false;
            paramObject = (MultiArrayType) paramObject;
        }
        while ((!this.component.equals(((MultiArrayType) paramObject).component)) || (this.dims != ((MultiArrayType) paramObject).dims));
        return true;
    }

    public Type getComponent() {
        if (this.dims == 1) {
            return this.component;
        }
        return new MultiArrayType(this.component, this.dims - 1);
    }

    public CtClass getCtClass() {
        CtClass localCtClass = this.component.getCtClass();
        if (localCtClass == null) {
            return null;
        }
        Object localObject2 = localCtClass.getClassPool();
        Object localObject1 = localObject2;
        if (localObject2 == null) {
            localObject1 = ClassPool.getDefault();
        }
        localObject2 = arrayName(localCtClass.getName(), this.dims);
        try {
            localObject1 = ((ClassPool) localObject1).get((String) localObject2);
            return (CtClass) localObject1;
        } catch (NotFoundException localNotFoundException) {
            throw new RuntimeException(localNotFoundException);
        }
    }

    public int getDimensions() {
        return this.dims;
    }

    public int getSize() {
        return 1;
    }

    public boolean isArray() {
        return true;
    }

    public boolean isAssignableFrom(Type paramType) {
        throw new UnsupportedOperationException("Not implemented");
    }

    public boolean isAssignableTo(Type paramType) {
        if (eq(paramType.getCtClass(), Type.OBJECT.getCtClass())) {
        }
        Type localType;
        do {
            do {
                return true;
            }
            while ((eq(paramType.getCtClass(), Type.CLONEABLE.getCtClass())) || (eq(paramType.getCtClass(), Type.SERIALIZABLE.getCtClass())));
            if (!paramType.isArray()) {
                return false;
            }
            localType = getRootComponent(paramType);
            int i = paramType.getDimensions();
            if (i > this.dims) {
                return false;
            }
            if (i >= this.dims) {
                break;
            }
        }
        while ((eq(localType.getCtClass(), Type.OBJECT.getCtClass())) || (eq(localType.getCtClass(), Type.CLONEABLE.getCtClass())) || (eq(localType.getCtClass(), Type.SERIALIZABLE.getCtClass())));
        return false;
        return this.component.isAssignableTo(localType);
    }

    public boolean isReference() {
        return true;
    }

    boolean popChanged() {
        return this.component.popChanged();
    }

    public String toString() {
        return arrayName(this.component.toString(), this.dims);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/analysis/MultiArrayType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */