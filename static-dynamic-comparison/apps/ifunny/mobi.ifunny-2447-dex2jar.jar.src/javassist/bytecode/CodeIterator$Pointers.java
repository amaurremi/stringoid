package javassist.bytecode;

class CodeIterator$Pointers {
    int cursor;
    ExceptionTable etable;
    LineNumberAttribute line;
    int mark;
    int mark0;
    StackMapTable stack;
    StackMap stack2;
    LocalVariableAttribute types;
    LocalVariableAttribute vars;

    CodeIterator$Pointers(int paramInt1, int paramInt2, int paramInt3, ExceptionTable paramExceptionTable, CodeAttribute paramCodeAttribute) {
        this.cursor = paramInt1;
        this.mark = paramInt2;
        this.mark0 = paramInt3;
        this.etable = paramExceptionTable;
        this.line = ((LineNumberAttribute) paramCodeAttribute.getAttribute("LineNumberTable"));
        this.vars = ((LocalVariableAttribute) paramCodeAttribute.getAttribute("LocalVariableTable"));
        this.types = ((LocalVariableAttribute) paramCodeAttribute.getAttribute("LocalVariableTypeTable"));
        this.stack = ((StackMapTable) paramCodeAttribute.getAttribute("StackMapTable"));
        this.stack2 = ((StackMap) paramCodeAttribute.getAttribute("StackMap"));
    }

    void shiftPc(int paramInt1, int paramInt2, boolean paramBoolean) {
        if ((paramInt1 < this.cursor) || ((paramInt1 == this.cursor) && (paramBoolean))) {
            this.cursor += paramInt2;
        }
        if ((paramInt1 < this.mark) || ((paramInt1 == this.mark) && (paramBoolean))) {
            this.mark += paramInt2;
        }
        if ((paramInt1 < this.mark0) || ((paramInt1 == this.mark0) && (paramBoolean))) {
            this.mark0 += paramInt2;
        }
        this.etable.shiftPc(paramInt1, paramInt2, paramBoolean);
        if (this.line != null) {
            this.line.shiftPc(paramInt1, paramInt2, paramBoolean);
        }
        if (this.vars != null) {
            this.vars.shiftPc(paramInt1, paramInt2, paramBoolean);
        }
        if (this.types != null) {
            this.types.shiftPc(paramInt1, paramInt2, paramBoolean);
        }
        if (this.stack != null) {
            this.stack.shiftPc(paramInt1, paramInt2, paramBoolean);
        }
        if (this.stack2 != null) {
            this.stack2.shiftPc(paramInt1, paramInt2, paramBoolean);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/CodeIterator$Pointers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */