package javassist.bytecode.analysis;

import java.io.PrintStream;

import javassist.CtClass;
import javassist.CtMethod;
import javassist.Modifier;
import javassist.NotFoundException;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.ConstPool;
import javassist.bytecode.Descriptor;
import javassist.bytecode.InstructionPrinter;
import javassist.bytecode.MethodInfo;

public final class FramePrinter {
    private final PrintStream stream;

    public FramePrinter(PrintStream paramPrintStream) {
        this.stream = paramPrintStream;
    }

    private void addSpacing(int paramInt) {
        while (paramInt > 0) {
            this.stream.print(' ');
            paramInt -= 1;
        }
    }

    private String getMethodString(CtMethod paramCtMethod) {
        try {
            paramCtMethod = Modifier.toString(paramCtMethod.getModifiers()) + " " + paramCtMethod.getReturnType().getName() + " " + paramCtMethod.getName() + Descriptor.toString(paramCtMethod.getSignature()) + ";";
            return paramCtMethod;
        } catch (NotFoundException paramCtMethod) {
            throw new RuntimeException(paramCtMethod);
        }
    }

    public static void print(CtClass paramCtClass, PrintStream paramPrintStream) {
        new FramePrinter(paramPrintStream).print(paramCtClass);
    }

    private void printLocals(Frame paramFrame) {
        this.stream.print("locals [");
        int j = paramFrame.localsLength();
        int i = 0;
        if (i < j) {
            if (i > 0) {
                this.stream.print(", ");
            }
            Object localObject = paramFrame.getLocal(i);
            PrintStream localPrintStream = this.stream;
            if (localObject == null) {
            }
            for (localObject = "empty"; ; localObject = ((Type) localObject).toString()) {
                localPrintStream.print((String) localObject);
                i += 1;
                break;
            }
        }
        this.stream.println("]");
    }

    private void printStack(Frame paramFrame) {
        this.stream.print("stack [");
        int j = paramFrame.getTopIndex();
        int i = 0;
        while (i <= j) {
            if (i > 0) {
                this.stream.print(", ");
            }
            Type localType = paramFrame.getStack(i);
            this.stream.print(localType);
            i += 1;
        }
        this.stream.println("]");
    }

    public void print(CtClass paramCtClass) {
        paramCtClass = paramCtClass.getDeclaredMethods();
        int i = 0;
        while (i < paramCtClass.length) {
            print(paramCtClass[i]);
            i += 1;
        }
    }

    public void print(CtMethod paramCtMethod) {
        this.stream.println("\n" + getMethodString(paramCtMethod));
        MethodInfo localMethodInfo = paramCtMethod.getMethodInfo2();
        ConstPool localConstPool = localMethodInfo.getConstPool();
        Object localObject = localMethodInfo.getCodeAttribute();
        if (localObject == null) {
            return;
        }
        for (; ; ) {
            int i;
            try {
                paramCtMethod = new Analyzer().analyze(paramCtMethod.getDeclaringClass(), localMethodInfo);
                i = String.valueOf(((CodeAttribute) localObject).getCodeLength()).length();
                localObject = ((CodeAttribute) localObject).iterator();
            } catch (BadBytecode paramCtMethod) {
                try {
                    int j = ((CodeIterator) localObject).next();
                    this.stream.println(j + ": " + InstructionPrinter.instructionString((CodeIterator) localObject, j, localConstPool));
                    addSpacing(i + 3);
                    localMethodInfo = paramCtMethod[j];
                    if (localMethodInfo != null) {
                        break label192;
                    }
                    this.stream.println("--DEAD CODE--");
                } catch (BadBytecode paramCtMethod) {
                    throw new RuntimeException(paramCtMethod);
                }
                paramCtMethod = paramCtMethod;
                throw new RuntimeException(paramCtMethod);
            }
            if (!((CodeIterator) localObject).hasNext()) {
                break;
            }
            label192:
            printStack(localMethodInfo);
            addSpacing(i + 3);
            printLocals(localMethodInfo);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/analysis/FramePrinter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */