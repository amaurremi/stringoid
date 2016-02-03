package javassist.bytecode;

import java.io.PrintWriter;

class StackMap$Printer
        extends StackMap.Walker {
    private PrintWriter writer;

    public StackMap$Printer(StackMap paramStackMap, PrintWriter paramPrintWriter) {
        super(paramStackMap);
        this.writer = paramPrintWriter;
    }

    public int locals(int paramInt1, int paramInt2, int paramInt3) {
        this.writer.println("  * offset " + paramInt2);
        return super.locals(paramInt1, paramInt2, paramInt3);
    }

    public void print() {
        int i = ByteArray.readU16bit(this.info, 0);
        this.writer.println(i + " entries");
        visit();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/StackMap$Printer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */