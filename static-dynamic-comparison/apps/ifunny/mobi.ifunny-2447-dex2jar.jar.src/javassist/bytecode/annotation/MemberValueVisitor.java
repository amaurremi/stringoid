package javassist.bytecode.annotation;

public abstract interface MemberValueVisitor {
    public abstract void visitAnnotationMemberValue(AnnotationMemberValue paramAnnotationMemberValue);

    public abstract void visitArrayMemberValue(ArrayMemberValue paramArrayMemberValue);

    public abstract void visitBooleanMemberValue(BooleanMemberValue paramBooleanMemberValue);

    public abstract void visitByteMemberValue(ByteMemberValue paramByteMemberValue);

    public abstract void visitCharMemberValue(CharMemberValue paramCharMemberValue);

    public abstract void visitClassMemberValue(ClassMemberValue paramClassMemberValue);

    public abstract void visitDoubleMemberValue(DoubleMemberValue paramDoubleMemberValue);

    public abstract void visitEnumMemberValue(EnumMemberValue paramEnumMemberValue);

    public abstract void visitFloatMemberValue(FloatMemberValue paramFloatMemberValue);

    public abstract void visitIntegerMemberValue(IntegerMemberValue paramIntegerMemberValue);

    public abstract void visitLongMemberValue(LongMemberValue paramLongMemberValue);

    public abstract void visitShortMemberValue(ShortMemberValue paramShortMemberValue);

    public abstract void visitStringMemberValue(StringMemberValue paramStringMemberValue);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/annotation/MemberValueVisitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */