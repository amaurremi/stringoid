package javassist.expr;

import javassist.CannotCompileException;
import javassist.CtBehavior;
import javassist.CtClass;
import javassist.CtPrimitiveType;
import javassist.NotFoundException;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.Bytecode;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.ConstPool;
import javassist.bytecode.Descriptor;
import javassist.bytecode.MethodInfo;
import javassist.compiler.CompileError;
import javassist.compiler.Javac;

public class NewArray
        extends Expr {
    int opcode;

    protected NewArray(int paramInt1, CodeIterator paramCodeIterator, CtClass paramCtClass, MethodInfo paramMethodInfo, int paramInt2) {
        super(paramInt1, paramCodeIterator, paramCtClass, paramMethodInfo);
        this.opcode = paramInt2;
    }

    private void replace2(String paramString) {
        this.thisClass.getClassFile();
        Object localObject1 = getConstPool();
        int n = this.currentPos;
        int j;
        int i;
        int k;
        if (this.opcode == 188) {
            j = this.iterator.byteAt(this.currentPos + 1);
            localObject1 = (CtPrimitiveType) getPrimitiveType(j);
            localObject1 = "[" + ((CtPrimitiveType) localObject1).getDescriptor();
            i = 1;
            k = 2;
        }
        CodeAttribute localCodeAttribute;
        CtClass[] arrayOfCtClass;
        for (; ; ) {
            localObject2 = Descriptor.toCtClass((String) localObject1, this.thisClass.getClassPool());
            localObject1 = new Javac(this.thisClass);
            localCodeAttribute = this.iterator.get();
            arrayOfCtClass = new CtClass[i];
            m = 0;
            while (m < i) {
                arrayOfCtClass[m] = CtClass.intType;
                m += 1;
            }
            if (this.opcode == 189) {
                j = this.iterator.u16bitAt(n + 1);
                localObject1 = ((ConstPool) localObject1).getClassInfo(j);
                if (((String) localObject1).startsWith("[")) {
                }
                for (localObject1 = "[" + (String) localObject1; ; localObject1 = "[L" + (String) localObject1 + ";") {
                    i = 1;
                    k = 3;
                    break;
                }
            }
            if (this.opcode != 197) {
                break;
            }
            j = this.iterator.u16bitAt(this.currentPos + 1);
            localObject1 = ((ConstPool) localObject1).getClassInfo(j);
            i = this.iterator.byteAt(this.currentPos + 3);
            k = 4;
        }
        throw new RuntimeException("bad opcode: " + this.opcode);
        int m = localCodeAttribute.getMaxLocals();
        ((Javac) localObject1).recordParams("java.lang.Object", arrayOfCtClass, true, m, withinStatic());
        checkResultValue((CtClass) localObject2, paramString);
        int i1 = ((Javac) localObject1).recordReturnType((CtClass) localObject2, true);
        ((Javac) localObject1).recordProceed(new NewArray.ProceedForArray((CtClass) localObject2, this.opcode, j, i));
        Object localObject2 = ((Javac) localObject1).getBytecode();
        storeStack(arrayOfCtClass, true, m, (Bytecode) localObject2);
        ((Javac) localObject1).recordLocalVariables(localCodeAttribute, n);
        ((Bytecode) localObject2).addOpcode(1);
        ((Bytecode) localObject2).addAstore(i1);
        ((Javac) localObject1).compileStmnt(paramString);
        ((Bytecode) localObject2).addAload(i1);
        replace0(n, (Bytecode) localObject2, k);
    }

    public CtClass getComponentType() {
        if (this.opcode == 188) {
            return getPrimitiveType(this.iterator.byteAt(this.currentPos + 1));
        }
        if ((this.opcode == 189) || (this.opcode == 197)) {
            int i = this.iterator.u16bitAt(this.currentPos + 1);
            String str = getConstPool().getClassInfo(i);
            return Descriptor.toCtClass(Descriptor.toArrayComponent(str, Descriptor.arrayDimension(str)), this.thisClass.getClassPool());
        }
        throw new RuntimeException("bad opcode: " + this.opcode);
    }

    public int getCreatedDimensions() {
        if (this.opcode == 197) {
            return this.iterator.byteAt(this.currentPos + 3);
        }
        return 1;
    }

    public int getDimension() {
        int i = 1;
        if (this.opcode == 188) {
            return 1;
        }
        if ((this.opcode == 189) || (this.opcode == 197)) {
            int j = this.iterator.u16bitAt(this.currentPos + 1);
            j = Descriptor.arrayDimension(getConstPool().getClassInfo(j));
            if (this.opcode == 189) {
            }
            for (; ; ) {
                return i + j;
                i = 0;
            }
        }
        throw new RuntimeException("bad opcode: " + this.opcode);
    }

    public String getFileName() {
        return super.getFileName();
    }

    public int getLineNumber() {
        return super.getLineNumber();
    }

    CtClass getPrimitiveType(int paramInt) {
        switch (paramInt) {
            default:
                throw new RuntimeException("bad atype: " + paramInt);
            case 4:
                return CtClass.booleanType;
            case 5:
                return CtClass.charType;
            case 6:
                return CtClass.floatType;
            case 7:
                return CtClass.doubleType;
            case 8:
                return CtClass.byteType;
            case 9:
                return CtClass.shortType;
            case 10:
                return CtClass.intType;
        }
        return CtClass.longType;
    }

    public CtClass[] mayThrow() {
        return super.mayThrow();
    }

    public void replace(String paramString) {
        try {
            replace2(paramString);
            return;
        } catch (CompileError paramString) {
            throw new CannotCompileException(paramString);
        } catch (NotFoundException paramString) {
            throw new CannotCompileException(paramString);
        } catch (BadBytecode paramString) {
            throw new CannotCompileException("broken method");
        }
    }

    public CtBehavior where() {
        return super.where();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/expr/NewArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */