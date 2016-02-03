package javassist.bytecode;

class ExceptionTableEntry {
    int catchType;
    int endPc;
    int handlerPc;
    int startPc;

    ExceptionTableEntry(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        this.startPc = paramInt1;
        this.endPc = paramInt2;
        this.handlerPc = paramInt3;
        this.catchType = paramInt4;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/ExceptionTableEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */