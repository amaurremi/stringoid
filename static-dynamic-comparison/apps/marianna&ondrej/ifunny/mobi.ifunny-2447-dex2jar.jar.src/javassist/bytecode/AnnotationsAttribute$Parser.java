package javassist.bytecode;

import javassist.bytecode.annotation.Annotation;
import javassist.bytecode.annotation.AnnotationMemberValue;
import javassist.bytecode.annotation.ArrayMemberValue;
import javassist.bytecode.annotation.BooleanMemberValue;
import javassist.bytecode.annotation.ByteMemberValue;
import javassist.bytecode.annotation.CharMemberValue;
import javassist.bytecode.annotation.ClassMemberValue;
import javassist.bytecode.annotation.DoubleMemberValue;
import javassist.bytecode.annotation.EnumMemberValue;
import javassist.bytecode.annotation.FloatMemberValue;
import javassist.bytecode.annotation.IntegerMemberValue;
import javassist.bytecode.annotation.LongMemberValue;
import javassist.bytecode.annotation.MemberValue;
import javassist.bytecode.annotation.ShortMemberValue;
import javassist.bytecode.annotation.StringMemberValue;

class AnnotationsAttribute$Parser
        extends AnnotationsAttribute.Walker {
    Annotation[] allAnno;
    Annotation[][] allParams;
    Annotation currentAnno;
    MemberValue currentMember;
    ConstPool pool;

    AnnotationsAttribute$Parser(byte[] paramArrayOfByte, ConstPool paramConstPool) {
        super(paramArrayOfByte);
        this.pool = paramConstPool;
    }

    int annotation(int paramInt1, int paramInt2, int paramInt3) {
        this.currentAnno = new Annotation(paramInt2, this.pool);
        return super.annotation(paramInt1, paramInt2, paramInt3);
    }

    int annotationArray(int paramInt1, int paramInt2) {
        Annotation[] arrayOfAnnotation = new Annotation[paramInt2];
        int j = 0;
        int i = paramInt1;
        paramInt1 = j;
        while (paramInt1 < paramInt2) {
            i = annotation(i);
            arrayOfAnnotation[paramInt1] = this.currentAnno;
            paramInt1 += 1;
        }
        this.allAnno = arrayOfAnnotation;
        return i;
    }

    int annotationMemberValue(int paramInt) {
        Annotation localAnnotation = this.currentAnno;
        paramInt = super.annotationMemberValue(paramInt);
        this.currentMember = new AnnotationMemberValue(this.currentAnno, this.pool);
        this.currentAnno = localAnnotation;
        return paramInt;
    }

    int arrayMemberValue(int paramInt1, int paramInt2) {
        ArrayMemberValue localArrayMemberValue = new ArrayMemberValue(this.pool);
        MemberValue[] arrayOfMemberValue = new MemberValue[paramInt2];
        int j = 0;
        int i = paramInt1;
        paramInt1 = j;
        while (paramInt1 < paramInt2) {
            i = memberValue(i);
            arrayOfMemberValue[paramInt1] = this.currentMember;
            paramInt1 += 1;
        }
        localArrayMemberValue.setValue(arrayOfMemberValue);
        this.currentMember = localArrayMemberValue;
        return i;
    }

    void classMemberValue(int paramInt1, int paramInt2) {
        this.currentMember = new ClassMemberValue(paramInt2, this.pool);
        super.classMemberValue(paramInt1, paramInt2);
    }

    void constValueMember(int paramInt1, int paramInt2) {
        Object localObject = this.pool;
        switch (paramInt1) {
            default:
                throw new RuntimeException("unknown tag:" + paramInt1);
            case 66:
                localObject = new ByteMemberValue(paramInt2, (ConstPool) localObject);
        }
        for (; ; ) {
            this.currentMember = ((MemberValue) localObject);
            super.constValueMember(paramInt1, paramInt2);
            return;
            localObject = new CharMemberValue(paramInt2, (ConstPool) localObject);
            continue;
            localObject = new DoubleMemberValue(paramInt2, (ConstPool) localObject);
            continue;
            localObject = new FloatMemberValue(paramInt2, (ConstPool) localObject);
            continue;
            localObject = new IntegerMemberValue(paramInt2, (ConstPool) localObject);
            continue;
            localObject = new LongMemberValue(paramInt2, (ConstPool) localObject);
            continue;
            localObject = new ShortMemberValue(paramInt2, (ConstPool) localObject);
            continue;
            localObject = new BooleanMemberValue(paramInt2, (ConstPool) localObject);
            continue;
            localObject = new StringMemberValue(paramInt2, (ConstPool) localObject);
        }
    }

    void enumMemberValue(int paramInt1, int paramInt2, int paramInt3) {
        this.currentMember = new EnumMemberValue(paramInt2, paramInt3, this.pool);
        super.enumMemberValue(paramInt1, paramInt2, paramInt3);
    }

    int memberValuePair(int paramInt1, int paramInt2) {
        paramInt1 = super.memberValuePair(paramInt1, paramInt2);
        this.currentAnno.addMemberValue(paramInt2, this.currentMember);
        return paramInt1;
    }

    void parameters(int paramInt1, int paramInt2) {
        Annotation[][] arrayOfAnnotation = new Annotation[paramInt1][];
        int j = 0;
        int i = paramInt2;
        paramInt2 = j;
        while (paramInt2 < paramInt1) {
            i = annotationArray(i);
            arrayOfAnnotation[paramInt2] = this.allAnno;
            paramInt2 += 1;
        }
        this.allParams = arrayOfAnnotation;
    }

    Annotation[] parseAnnotations() {
        annotationArray();
        return this.allAnno;
    }

    MemberValue parseMemberValue() {
        memberValue(0);
        return this.currentMember;
    }

    Annotation[][] parseParameters() {
        parameters();
        return this.allParams;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/AnnotationsAttribute$Parser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */