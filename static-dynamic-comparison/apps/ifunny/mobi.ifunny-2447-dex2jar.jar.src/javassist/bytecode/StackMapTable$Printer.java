package javassist.bytecode;

import java.io.PrintWriter;

class StackMapTable$Printer
        extends StackMapTable.Walker {
    private int offset;
    private PrintWriter writer;

    StackMapTable$Printer(byte[] paramArrayOfByte, PrintWriter paramPrintWriter) {
        super(paramArrayOfByte);
        this.writer = paramPrintWriter;
        this.offset = -1;
    }

    public static void print(StackMapTable paramStackMapTable, PrintWriter paramPrintWriter) {
        try {
            new Printer(paramStackMapTable.get(), paramPrintWriter).parse();
            return;
        } catch (BadBytecode paramStackMapTable) {
            paramPrintWriter.println(paramStackMapTable.getMessage());
        }
    }

    private void printTypeInfo(int paramInt1, int paramInt2) {
        String str = null;
        switch (paramInt1) {
        }
        for (; ; ) {
            this.writer.print("    ");
            this.writer.println(str);
            return;
            str = "top";
            continue;
            str = "integer";
            continue;
            str = "float";
            continue;
            str = "double";
            continue;
            str = "long";
            continue;
            str = "null";
            continue;
            str = "this";
            continue;
            str = "object (cpool_index " + paramInt2 + ")";
            continue;
            str = "uninitialized (offset " + paramInt2 + ")";
        }
    }

    public void appendFrame(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2) {
        this.offset += paramInt2 + 1;
        this.writer.println(this.offset + " append frame: " + paramInt2);
        paramInt1 = 0;
        while (paramInt1 < paramArrayOfInt1.length) {
            printTypeInfo(paramArrayOfInt1[paramInt1], paramArrayOfInt2[paramInt1]);
            paramInt1 += 1;
        }
    }

    public void chopFrame(int paramInt1, int paramInt2, int paramInt3) {
        this.offset += paramInt2 + 1;
        this.writer.println(this.offset + " chop frame: " + paramInt2 + ",    " + paramInt3 + " last locals");
    }

    public void fullFrame(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4) {
        int i = 0;
        this.offset += paramInt2 + 1;
        this.writer.println(this.offset + " full frame: " + paramInt2);
        this.writer.println("[locals]");
        paramInt1 = 0;
        while (paramInt1 < paramArrayOfInt1.length) {
            printTypeInfo(paramArrayOfInt1[paramInt1], paramArrayOfInt2[paramInt1]);
            paramInt1 += 1;
        }
        this.writer.println("[stack]");
        paramInt1 = i;
        while (paramInt1 < paramArrayOfInt3.length) {
            printTypeInfo(paramArrayOfInt3[paramInt1], paramArrayOfInt4[paramInt1]);
            paramInt1 += 1;
        }
    }

    public void sameFrame(int paramInt1, int paramInt2) {
        this.offset += paramInt2 + 1;
        this.writer.println(this.offset + " same frame: " + paramInt2);
    }

    public void sameLocals(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        this.offset += paramInt2 + 1;
        this.writer.println(this.offset + " same locals: " + paramInt2);
        printTypeInfo(paramInt3, paramInt4);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/StackMapTable$Printer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */