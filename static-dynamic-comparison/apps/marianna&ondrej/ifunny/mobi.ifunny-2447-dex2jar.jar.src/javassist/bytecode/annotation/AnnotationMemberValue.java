package javassist.bytecode.annotation;

import java.lang.reflect.Method;

import javassist.ClassPool;
import javassist.bytecode.ConstPool;

public class AnnotationMemberValue
        extends MemberValue {
    Annotation value;

    public AnnotationMemberValue(ConstPool paramConstPool) {
        this(null, paramConstPool);
    }

    public AnnotationMemberValue(Annotation paramAnnotation, ConstPool paramConstPool) {
        super('@', paramConstPool);
        this.value = paramAnnotation;
    }

    public void accept(MemberValueVisitor paramMemberValueVisitor) {
        paramMemberValueVisitor.visitAnnotationMemberValue(this);
    }

    Class getType(ClassLoader paramClassLoader) {
        if (this.value == null) {
            throw new ClassNotFoundException("no type specified");
        }
        return loadClass(paramClassLoader, this.value.getTypeName());
    }

    Object getValue(ClassLoader paramClassLoader, ClassPool paramClassPool, Method paramMethod) {
        return AnnotationImpl.make(paramClassLoader, getType(paramClassLoader), paramClassPool, this.value);
    }

    public Annotation getValue() {
        return this.value;
    }

    public void setValue(Annotation paramAnnotation) {
        this.value = paramAnnotation;
    }

    public String toString() {
        return this.value.toString();
    }

    public void write(AnnotationsWriter paramAnnotationsWriter) {
        paramAnnotationsWriter.annotationValue();
        this.value.write(paramAnnotationsWriter);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/annotation/AnnotationMemberValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */