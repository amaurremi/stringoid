package javassist.expr;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtBehavior;
import javassist.CtClass;
import javassist.CtMethod;
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

public class MethodCall
        extends Expr {
    protected MethodCall(int paramInt, CodeIterator paramCodeIterator, CtClass paramCtClass, MethodInfo paramMethodInfo) {
        super(paramInt, paramCodeIterator, paramCtClass, paramMethodInfo);
    }

    private int getNameAndType(ConstPool paramConstPool) {
        int j = this.currentPos;
        int i = this.iterator.byteAt(j);
        j = this.iterator.u16bitAt(j + 1);
        if (i == 185) {
            return paramConstPool.getInterfaceMethodrefNameAndType(j);
        }
        return paramConstPool.getMethodrefNameAndType(j);
    }

    public String getClassName() {
        Object localObject1 = getConstPool();
        int j = this.currentPos;
        int i = this.iterator.byteAt(j);
        j = this.iterator.u16bitAt(j + 1);
        if (i == 185) {
        }
        for (localObject1 = ((ConstPool) localObject1).getInterfaceMethodrefClassName(j); ; localObject1 = ((ConstPool) localObject1).getMethodrefClassName(j)) {
            Object localObject2 = localObject1;
            if (((String) localObject1).charAt(0) == '[') {
                localObject2 = Descriptor.toClassName((String) localObject1);
            }
            return (String) localObject2;
        }
    }

    protected CtClass getCtClass() {
        return this.thisClass.getClassPool().get(getClassName());
    }

    public String getFileName() {
        return super.getFileName();
    }

    public int getLineNumber() {
        return super.getLineNumber();
    }

    public CtMethod getMethod() {
        return getCtClass().getMethod(getMethodName(), getSignature());
    }

    public String getMethodName() {
        ConstPool localConstPool = getConstPool();
        return localConstPool.getUtf8Info(localConstPool.getNameAndTypeName(getNameAndType(localConstPool)));
    }

    public String getSignature() {
        ConstPool localConstPool = getConstPool();
        return localConstPool.getUtf8Info(localConstPool.getNameAndTypeDescriptor(getNameAndType(localConstPool)));
    }

    public boolean isSuper() {
        return (this.iterator.byteAt(this.currentPos) == 183) && (!where().getDeclaringClass().getName().equals(getClassName()));
    }

    public CtClass[] mayThrow() {
        return super.mayThrow();
    }

    public void replace(String paramString) {
        this.thisClass.getClassFile();
        Object localObject2 = getConstPool();
        int j = this.currentPos;
        int i = this.iterator.u16bitAt(j + 1);
        int k = this.iterator.byteAt(j);
        Object localObject1;
        Object localObject3;
        CodeAttribute localCodeAttribute;
        if (k == 185) {
            localObject1 = ((ConstPool) localObject2).getInterfaceMethodrefClassName(i);
            str = ((ConstPool) localObject2).getInterfaceMethodrefName(i);
            localObject2 = ((ConstPool) localObject2).getInterfaceMethodrefType(i);
            i = 5;
            localJavac = new Javac(this.thisClass);
            localObject3 = this.thisClass.getClassPool();
            localCodeAttribute = this.iterator.get();
        }
        for (; ; ) {
            try {
                arrayOfCtClass = Descriptor.getParameterTypes((String) localObject2, (ClassPool) localObject3);
                localObject3 = Descriptor.getReturnType((String) localObject2, (ClassPool) localObject3);
                m = localCodeAttribute.getMaxLocals();
                localJavac.recordParams((String) localObject1, arrayOfCtClass, true, m, withinStatic());
                n = localJavac.recordReturnType((CtClass) localObject3, true);
                if (k != 184) {
                    continue;
                }
                localJavac.recordStaticProceed((String) localObject1, str);
            } catch (CompileError paramString) {
                CtClass[] arrayOfCtClass;
                int m;
                int n;
                throw new CannotCompileException(paramString);
                localJavac.recordProceed("$0", str);
                continue;
            } catch (NotFoundException paramString) {
                throw new CannotCompileException(paramString);
                boolean bool = false;
                continue;
            } catch (BadBytecode paramString) {
                throw new CannotCompileException("broken method");
            }
            checkResultValue((CtClass) localObject3, paramString);
            localObject1 = localJavac.getBytecode();
            if (k != 184) {
                continue;
            }
            bool = true;
            storeStack(arrayOfCtClass, bool, m, (Bytecode) localObject1);
            localJavac.recordLocalVariables(localCodeAttribute, j);
            if (localObject3 != CtClass.voidType) {
                ((Bytecode) localObject1).addConstZero((CtClass) localObject3);
                ((Bytecode) localObject1).addStore(n, (CtClass) localObject3);
            }
            localJavac.compileStmnt(paramString);
            if (localObject3 != CtClass.voidType) {
                ((Bytecode) localObject1).addLoad(n, (CtClass) localObject3);
            }
            replace0(j, (Bytecode) localObject1, i);
            return;
            if ((k == 184) || (k == 183) || (k == 182)) {
                localObject1 = ((ConstPool) localObject2).getMethodrefClassName(i);
                str = ((ConstPool) localObject2).getMethodrefName(i);
                localObject2 = ((ConstPool) localObject2).getMethodrefType(i);
                i = 3;
                break;
            }
            throw new CannotCompileException("not method invocation");
            if (k != 183) {
                continue;
            }
            localJavac.recordSpecialProceed("$0", (String) localObject1, str, (String) localObject2);
        }
    }

    public CtBehavior where() {
        return super.where();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/expr/MethodCall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */