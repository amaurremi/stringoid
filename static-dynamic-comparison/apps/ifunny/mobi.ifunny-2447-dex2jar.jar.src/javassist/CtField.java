package javassist;

import java.util.List;
import java.util.ListIterator;

import javassist.bytecode.AccessFlag;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.AttributeInfo;
import javassist.bytecode.ClassFile;
import javassist.bytecode.ConstPool;
import javassist.bytecode.Descriptor;
import javassist.bytecode.FieldInfo;
import javassist.compiler.CompileError;
import javassist.compiler.Javac;
import javassist.compiler.ast.ASTree;

public class CtField
        extends CtMember {
    static final String javaLangString = "java.lang.String";
    protected FieldInfo fieldInfo;

    private CtField(String paramString1, String paramString2, CtClass paramCtClass) {
        super(paramCtClass);
        ClassFile localClassFile = paramCtClass.getClassFile2();
        if (localClassFile == null) {
            throw new CannotCompileException("bad declaring class: " + paramCtClass.getName());
        }
        this.fieldInfo = new FieldInfo(localClassFile.getConstPool(), paramString2, paramString1);
    }

    public CtField(CtClass paramCtClass1, String paramString, CtClass paramCtClass2) {
        this(Descriptor.of(paramCtClass1), paramString, paramCtClass2);
    }

    public CtField(CtField paramCtField, CtClass paramCtClass) {
        this(paramCtField.fieldInfo.getDescriptor(), paramCtField.fieldInfo.getName(), paramCtClass);
        paramCtClass = paramCtField.fieldInfo.getAttributes().listIterator();
        FieldInfo localFieldInfo = this.fieldInfo;
        localFieldInfo.setAccessFlags(paramCtField.fieldInfo.getAccessFlags());
        paramCtField = localFieldInfo.getConstPool();
        while (paramCtClass.hasNext()) {
            localFieldInfo.addAttribute(((AttributeInfo) paramCtClass.next()).copy(paramCtField, null));
        }
    }

    CtField(FieldInfo paramFieldInfo, CtClass paramCtClass) {
        super(paramCtClass);
        this.fieldInfo = paramFieldInfo;
    }

    private Object[] getAnnotations(boolean paramBoolean) {
        Object localObject = getFieldInfo2();
        AnnotationsAttribute localAnnotationsAttribute = (AnnotationsAttribute) ((FieldInfo) localObject).getAttribute("RuntimeInvisibleAnnotations");
        localObject = (AnnotationsAttribute) ((FieldInfo) localObject).getAttribute("RuntimeVisibleAnnotations");
        return CtClassType.toAnnotationType(paramBoolean, getDeclaringClass().getClassPool(), localAnnotationsAttribute, (AnnotationsAttribute) localObject);
    }

    public static CtField make(String paramString, CtClass paramCtClass) {
        paramCtClass = new Javac(paramCtClass);
        try {
            paramString = paramCtClass.compile(paramString);
            if ((paramString instanceof CtField)) {
                paramString = (CtField) paramString;
                return paramString;
            }
        } catch (CompileError paramString) {
            throw new CannotCompileException(paramString);
        }
        throw new CannotCompileException("not a field");
    }

    protected void extendToString(StringBuffer paramStringBuffer) {
        paramStringBuffer.append(' ');
        paramStringBuffer.append(getName());
        paramStringBuffer.append(' ');
        paramStringBuffer.append(this.fieldInfo.getDescriptor());
    }

    public Object getAnnotation(Class paramClass) {
        Object localObject = getFieldInfo2();
        AnnotationsAttribute localAnnotationsAttribute = (AnnotationsAttribute) ((FieldInfo) localObject).getAttribute("RuntimeInvisibleAnnotations");
        localObject = (AnnotationsAttribute) ((FieldInfo) localObject).getAttribute("RuntimeVisibleAnnotations");
        return CtClassType.getAnnotationType(paramClass, getDeclaringClass().getClassPool(), localAnnotationsAttribute, (AnnotationsAttribute) localObject);
    }

    public Object[] getAnnotations() {
        return getAnnotations(false);
    }

    public byte[] getAttribute(String paramString) {
        paramString = this.fieldInfo.getAttribute(paramString);
        if (paramString == null) {
            return null;
        }
        return paramString.get();
    }

    public Object[] getAvailableAnnotations() {
        try {
            Object[] arrayOfObject = getAnnotations(true);
            return arrayOfObject;
        } catch (ClassNotFoundException localClassNotFoundException) {
            throw new RuntimeException("Unexpected exception", localClassNotFoundException);
        }
    }

    public Object getConstantValue() {
        int i = this.fieldInfo.getConstantValue();
        if (i == 0) {
            return null;
        }
        ConstPool localConstPool = this.fieldInfo.getConstPool();
        switch (localConstPool.getTag(i)) {
            case 7:
            default:
                throw new RuntimeException("bad tag: " + localConstPool.getTag(i) + " at " + i);
            case 5:
                return new Long(localConstPool.getLongInfo(i));
            case 4:
                return new Float(localConstPool.getFloatInfo(i));
            case 6:
                return new Double(localConstPool.getDoubleInfo(i));
            case 3:
                i = localConstPool.getIntegerInfo(i);
                if ("Z".equals(this.fieldInfo.getDescriptor())) {
                    if (i != 0) {
                    }
                    for (boolean bool = true; ; bool = false) {
                        return new Boolean(bool);
                    }
                }
                return new Integer(i);
        }
        return localConstPool.getStringInfo(i);
    }

    public CtClass getDeclaringClass() {
        return super.getDeclaringClass();
    }

    public FieldInfo getFieldInfo() {
        this.declaringClass.checkModify();
        return this.fieldInfo;
    }

    public FieldInfo getFieldInfo2() {
        return this.fieldInfo;
    }

    CtField.Initializer getInit() {
        ASTree localASTree = getInitAST();
        if (localASTree == null) {
            return null;
        }
        return CtField.Initializer.byExpr(localASTree);
    }

    protected ASTree getInitAST() {
        return null;
    }

    public int getModifiers() {
        return AccessFlag.toModifier(this.fieldInfo.getAccessFlags());
    }

    public String getName() {
        return this.fieldInfo.getName();
    }

    public String getSignature() {
        return this.fieldInfo.getDescriptor();
    }

    public CtClass getType() {
        return Descriptor.toCtClass(this.fieldInfo.getDescriptor(), this.declaringClass.getClassPool());
    }

    public boolean hasAnnotation(Class paramClass) {
        Object localObject = getFieldInfo2();
        AnnotationsAttribute localAnnotationsAttribute = (AnnotationsAttribute) ((FieldInfo) localObject).getAttribute("RuntimeInvisibleAnnotations");
        localObject = (AnnotationsAttribute) ((FieldInfo) localObject).getAttribute("RuntimeVisibleAnnotations");
        return CtClassType.hasAnnotationType(paramClass, getDeclaringClass().getClassPool(), localAnnotationsAttribute, (AnnotationsAttribute) localObject);
    }

    public void setAttribute(String paramString, byte[] paramArrayOfByte) {
        this.declaringClass.checkModify();
        this.fieldInfo.addAttribute(new AttributeInfo(this.fieldInfo.getConstPool(), paramString, paramArrayOfByte));
    }

    public void setModifiers(int paramInt) {
        this.declaringClass.checkModify();
        this.fieldInfo.setAccessFlags(AccessFlag.of(paramInt));
    }

    public void setName(String paramString) {
        this.declaringClass.checkModify();
        this.fieldInfo.setName(paramString);
    }

    public void setType(CtClass paramCtClass) {
        this.declaringClass.checkModify();
        this.fieldInfo.setDescriptor(Descriptor.of(paramCtClass));
    }

    public String toString() {
        return getDeclaringClass().getName() + "." + getName() + ":" + this.fieldInfo.getDescriptor();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/CtField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */