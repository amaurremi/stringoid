package javassist.expr;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtBehavior;
import javassist.CtClass;
import javassist.CtField;
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

public class FieldAccess
        extends Expr {
    int opcode;

    protected FieldAccess(int paramInt1, CodeIterator paramCodeIterator, CtClass paramCtClass, MethodInfo paramMethodInfo, int paramInt2) {
        super(paramInt1, paramCodeIterator, paramCtClass, paramMethodInfo);
        this.opcode = paramInt2;
    }

    private CtClass getCtClass() {
        return this.thisClass.getClassPool().get(getClassName());
    }

    static boolean isStatic(int paramInt) {
        return (paramInt == 178) || (paramInt == 179);
    }

    public String getClassName() {
        int i = this.iterator.u16bitAt(this.currentPos + 1);
        return getConstPool().getFieldrefClassName(i);
    }

    public CtField getField() {
        return getCtClass().getField(getFieldName());
    }

    public String getFieldName() {
        int i = this.iterator.u16bitAt(this.currentPos + 1);
        return getConstPool().getFieldrefName(i);
    }

    public String getFileName() {
        return super.getFileName();
    }

    public int getLineNumber() {
        return super.getLineNumber();
    }

    public String getSignature() {
        int i = this.iterator.u16bitAt(this.currentPos + 1);
        return getConstPool().getFieldrefType(i);
    }

    public boolean isReader() {
        return (this.opcode == 180) || (this.opcode == 178);
    }

    public boolean isStatic() {
        return isStatic(this.opcode);
    }

    public boolean isWriter() {
        return (this.opcode == 181) || (this.opcode == 179);
    }

    public CtClass[] mayThrow() {
        return super.mayThrow();
    }

    public void replace(String paramString) {
        this.thisClass.getClassFile();
        ConstPool localConstPool = getConstPool();
        int i = this.currentPos;
        int j = this.iterator.u16bitAt(i + 1);
        Javac localJavac = new Javac(this.thisClass);
        CodeAttribute localCodeAttribute = this.iterator.get();
        for (; ; ) {
            try {
                localObject2 = Descriptor.toCtClass(localConstPool.getFieldrefType(j), this.thisClass.getClassPool());
                bool2 = isReader();
                if (!bool2) {
                    continue;
                }
                arrayOfCtClass = new CtClass[0];
                localObject1 = localObject2;
                k = localCodeAttribute.getMaxLocals();
                localJavac.recordParams(localConstPool.getFieldrefClassName(j), arrayOfCtClass, true, k, withinStatic());
                boolean bool1 = checkResultValue((CtClass) localObject1, paramString);
                if (bool2) {
                    bool1 = true;
                }
                m = localJavac.recordReturnType((CtClass) localObject1, bool1);
                if (!bool2) {
                    continue;
                }
                localJavac.recordProceed(new FieldAccess.ProceedForRead((CtClass) localObject1, this.opcode, j, k));
                localObject2 = localJavac.getBytecode();
                storeStack(arrayOfCtClass, isStatic(), k, (Bytecode) localObject2);
                localJavac.recordLocalVariables(localCodeAttribute, i);
                if (bool1) {
                    if (localObject1 != CtClass.voidType) {
                        continue;
                    }
                    ((Bytecode) localObject2).addOpcode(1);
                    ((Bytecode) localObject2).addAstore(m);
                }
            } catch (CompileError paramString) {
                Object localObject2;
                boolean bool2;
                CtClass[] arrayOfCtClass;
                Object localObject1;
                int k;
                int m;
                throw new CannotCompileException(paramString);
                ((Bytecode) localObject2).addConstZero((CtClass) localObject1);
                ((Bytecode) localObject2).addStore(m, (CtClass) localObject1);
                continue;
            } catch (NotFoundException paramString) {
                throw new CannotCompileException(paramString);
            } catch (BadBytecode paramString) {
                throw new CannotCompileException("broken method");
            }
            localJavac.compileStmnt(paramString);
            if (bool2) {
                ((Bytecode) localObject2).addLoad(m, (CtClass) localObject1);
            }
            replace0(i, (Bytecode) localObject2, 3);
            return;
            arrayOfCtClass = new CtClass[1];
            arrayOfCtClass[0] = localObject2;
            localObject1 = CtClass.voidType;
            continue;
            localJavac.recordType((CtClass) localObject2);
            localJavac.recordProceed(new FieldAccess.ProceedForWrite(arrayOfCtClass[0], this.opcode, j, k));
        }
    }

    public CtBehavior where() {
        return super.where();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/expr/FieldAccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */