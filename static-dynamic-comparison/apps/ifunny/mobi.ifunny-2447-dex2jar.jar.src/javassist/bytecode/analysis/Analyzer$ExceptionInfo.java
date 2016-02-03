package javassist.bytecode.analysis;

class Analyzer$ExceptionInfo {
    private int end;
    private int handler;
    private int start;
    private Type type;

    private Analyzer$ExceptionInfo(int paramInt1, int paramInt2, int paramInt3, Type paramType) {
        this.start = paramInt1;
        this.end = paramInt2;
        this.handler = paramInt3;
        this.type = paramType;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/analysis/Analyzer$ExceptionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */