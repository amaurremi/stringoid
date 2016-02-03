package javassist.expr;

import java.util.Iterator;
import java.util.LinkedList;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtBehavior;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtPrimitiveType;
import javassist.NotFoundException;
import javassist.bytecode.Bytecode;
import javassist.bytecode.ClassFile;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.CodeIterator.Gap;
import javassist.bytecode.ConstPool;
import javassist.bytecode.ExceptionTable;
import javassist.bytecode.ExceptionsAttribute;
import javassist.bytecode.MethodInfo;
import javassist.bytecode.Opcode;

public abstract class Expr
        implements Opcode {
    static final String javaLangObject = "java.lang.Object";
    int currentPos;
    boolean edited;
    CodeIterator iterator;
    int maxLocals;
    int maxStack;
    CtClass thisClass;
    MethodInfo thisMethod;

    protected Expr(int paramInt, CodeIterator paramCodeIterator, CtClass paramCtClass, MethodInfo paramMethodInfo) {
        this.currentPos = paramInt;
        this.iterator = paramCodeIterator;
        this.thisClass = paramCtClass;
        this.thisMethod = paramMethodInfo;
    }

    private static void addClass(LinkedList paramLinkedList, CtClass paramCtClass) {
        Iterator localIterator = paramLinkedList.iterator();
        while (localIterator.hasNext()) {
            if (localIterator.next() == paramCtClass) {
                return;
            }
        }
        paramLinkedList.add(paramCtClass);
    }

    static final boolean checkResultValue(CtClass paramCtClass, String paramString) {
        if (paramString.indexOf("$_") >= 0) {
        }
        for (boolean bool = true; (!bool) && (paramCtClass != CtClass.voidType); bool = false) {
            throw new CannotCompileException("the resulting value is not stored in $_");
        }
        return bool;
    }

    static final void storeStack(CtClass[] paramArrayOfCtClass, boolean paramBoolean, int paramInt, Bytecode paramBytecode) {
        storeStack0(0, paramArrayOfCtClass.length, paramArrayOfCtClass, paramInt + 1, paramBytecode);
        if (paramBoolean) {
            paramBytecode.addOpcode(1);
        }
        paramBytecode.addAstore(paramInt);
    }

    private static void storeStack0(int paramInt1, int paramInt2, CtClass[] paramArrayOfCtClass, int paramInt3, Bytecode paramBytecode) {
        if (paramInt1 >= paramInt2) {
            return;
        }
        CtClass localCtClass = paramArrayOfCtClass[paramInt1];
        if ((localCtClass instanceof CtPrimitiveType)) {
        }
        for (int i = ((CtPrimitiveType) localCtClass).getDataSize(); ; i = 1) {
            storeStack0(paramInt1 + 1, paramInt2, paramArrayOfCtClass, i + paramInt3, paramBytecode);
            paramBytecode.addStore(paramInt3, localCtClass);
            return;
        }
    }

    protected final boolean edited() {
        return this.edited;
    }

    protected final ConstPool getConstPool() {
        return this.thisMethod.getConstPool();
    }

    public CtClass getEnclosingClass() {
        return this.thisClass;
    }

    public String getFileName() {
        ClassFile localClassFile = this.thisClass.getClassFile2();
        if (localClassFile == null) {
            return null;
        }
        return localClassFile.getSourceFile();
    }

    public int getLineNumber() {
        return this.thisMethod.getLineNumber(this.currentPos);
    }

    public int indexOfBytecode() {
        return this.currentPos;
    }

    protected final int locals() {
        return this.maxLocals;
    }

    public CtClass[] mayThrow() {
        j = 0;
        localClassPool = this.thisClass.getClassPool();
        localConstPool = this.thisMethod.getConstPool();
        localLinkedList = new LinkedList();
        try {
            localExceptionTable = this.thisMethod.getCodeAttribute().getExceptionTable();
            k = this.currentPos;
            m = localExceptionTable.size();
            i = 0;
        } catch (NullPointerException localNullPointerException) {
            try {
                for (; ; ) {
                    ExceptionTable localExceptionTable;
                    int m;
                    int n;
                    addClass(localLinkedList, localClassPool.get(localConstPool.getClassInfo(n)));
                    i += 1;
                }
                localNullPointerException = localNullPointerException;
                Object localObject = this.thisMethod.getExceptionsAttribute();
                if (localObject == null) {
                    break label178;
                }
                localObject = ((ExceptionsAttribute) localObject).getExceptions();
                if (localObject == null) {
                    break label178;
                }
                int k = localObject.length;
                int i = j;
                for (; ; ) {
                    if (i >= k) {
                        break label178;
                    }
                    try {
                        addClass(localLinkedList, localClassPool.get(localObject[i]));
                        i += 1;
                        continue;
                        return (CtClass[]) localLinkedList.toArray(new CtClass[localLinkedList.size()]);
                    } catch (NotFoundException localNotFoundException1) {
                        for (; ; ) {
                        }
                    }
                }
            } catch (NotFoundException localNotFoundException2) {
                for (; ; ) {
                }
            }
        }
        if (i < m) {
            if ((localExceptionTable.startPc(i) <= k) && (k < localExceptionTable.endPc(i))) {
                n = localExceptionTable.catchType(i);
                if (n <= 0) {
                }
            }
        }
    }

    public abstract void replace(String paramString);

    public void replace(String paramString, ExprEditor paramExprEditor) {
        replace(paramString);
        if (paramExprEditor != null) {
            runEditor(paramExprEditor, this.iterator);
        }
    }

    protected void replace0(int paramInt1, Bytecode paramBytecode, int paramInt2) {
        byte[] arrayOfByte = paramBytecode.get();
        this.edited = true;
        int j = arrayOfByte.length - paramInt2;
        int i = 0;
        while (i < paramInt2) {
            this.iterator.writeByte(0, paramInt1 + i);
            i += 1;
        }
        paramInt2 = paramInt1;
        if (j > 0) {
            paramInt2 = this.iterator.insertGapAt(paramInt1, j, false).position;
        }
        this.iterator.write(arrayOfByte, paramInt2);
        this.iterator.insert(paramBytecode.getExceptionTable(), paramInt2);
        this.maxLocals = paramBytecode.getMaxLocals();
        this.maxStack = paramBytecode.getMaxStack();
    }

    protected void runEditor(ExprEditor paramExprEditor, CodeIterator paramCodeIterator) {
        CodeAttribute localCodeAttribute = paramCodeIterator.get();
        int i = localCodeAttribute.getMaxLocals();
        int j = localCodeAttribute.getMaxStack();
        int k = locals();
        localCodeAttribute.setMaxStack(stack());
        localCodeAttribute.setMaxLocals(k);
        ExprEditor.LoopContext localLoopContext = new ExprEditor.LoopContext(k);
        k = paramCodeIterator.getCodeLength();
        int m = paramCodeIterator.lookAhead();
        paramCodeIterator.move(this.currentPos);
        if (paramExprEditor.doit(this.thisClass, this.thisMethod, localLoopContext, paramCodeIterator, m)) {
            this.edited = true;
        }
        paramCodeIterator.move(paramCodeIterator.getCodeLength() + m - k);
        localCodeAttribute.setMaxLocals(i);
        localCodeAttribute.setMaxStack(j);
        this.maxLocals = localLoopContext.maxLocals;
        this.maxStack += localLoopContext.maxStack;
    }

    protected final int stack() {
        return this.maxStack;
    }

    public CtBehavior where() {
        MethodInfo localMethodInfo = this.thisMethod;
        CtBehavior[] arrayOfCtBehavior = this.thisClass.getDeclaredBehaviors();
        int i = arrayOfCtBehavior.length - 1;
        Object localObject;
        if (i >= 0) {
            if (arrayOfCtBehavior[i].getMethodInfo2() == localMethodInfo) {
                localObject = arrayOfCtBehavior[i];
            }
        }
        CtConstructor localCtConstructor;
        do {
            return (CtBehavior) localObject;
            i -= 1;
            break;
            localCtConstructor = this.thisClass.getClassInitializer();
            if (localCtConstructor == null) {
                break label74;
            }
            localObject = localCtConstructor;
        } while (localCtConstructor.getMethodInfo2() == localMethodInfo);
        label74:
        i = arrayOfCtBehavior.length - 1;
        while (i >= 0) {
            if ((this.thisMethod.getName().equals(arrayOfCtBehavior[i].getMethodInfo2().getName())) && (this.thisMethod.getDescriptor().equals(arrayOfCtBehavior[i].getMethodInfo2().getDescriptor()))) {
                return arrayOfCtBehavior[i];
            }
            i -= 1;
        }
        throw new RuntimeException("fatal: not found");
    }

    protected final boolean withinStatic() {
        return (this.thisMethod.getAccessFlags() & 0x8) != 0;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/expr/Expr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */