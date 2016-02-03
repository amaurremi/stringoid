package javassist.expr;

import javassist.CannotCompileException;
import javassist.CtClass;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.ConstPool;
import javassist.bytecode.ExceptionTable;
import javassist.bytecode.MethodInfo;

public class ExprEditor {
    public boolean doit(CtClass paramCtClass, MethodInfo paramMethodInfo) {
        int i = 0;
        CodeAttribute localCodeAttribute = paramMethodInfo.getCodeAttribute();
        if (localCodeAttribute == null) {
            return false;
        }
        CodeIterator localCodeIterator = localCodeAttribute.iterator();
        ExprEditor.LoopContext localLoopContext = new ExprEditor.LoopContext(localCodeAttribute.getMaxLocals());
        boolean bool = false;
        while (localCodeIterator.hasNext()) {
            if (loopBody(localCodeIterator, paramCtClass, paramMethodInfo, localLoopContext)) {
                bool = true;
            }
        }
        ExceptionTable localExceptionTable = localCodeAttribute.getExceptionTable();
        int j = localExceptionTable.size();
        if (i < j) {
            Handler localHandler = new Handler(localExceptionTable, i, localCodeIterator, paramCtClass, paramMethodInfo);
            edit(localHandler);
            if (!localHandler.edited()) {
                break label214;
            }
            localLoopContext.updateMax(localHandler.locals(), localHandler.stack());
            bool = true;
        }
        label214:
        for (; ; ) {
            i += 1;
            break;
            if (localCodeAttribute.getMaxLocals() < localLoopContext.maxLocals) {
                localCodeAttribute.setMaxLocals(localLoopContext.maxLocals);
            }
            localCodeAttribute.setMaxStack(localCodeAttribute.getMaxStack() + localLoopContext.maxStack);
            if (bool) {
            }
            try {
                paramMethodInfo.rebuildStackMapIf6(paramCtClass.getClassPool(), paramCtClass.getClassFile2());
                return bool;
            } catch (BadBytecode paramCtClass) {
                throw new CannotCompileException(paramCtClass.getMessage(), paramCtClass);
            }
        }
    }

    boolean doit(CtClass paramCtClass, MethodInfo paramMethodInfo, ExprEditor.LoopContext paramLoopContext, CodeIterator paramCodeIterator, int paramInt) {
        boolean bool1 = false;
        while ((paramCodeIterator.hasNext()) && (paramCodeIterator.lookAhead() < paramInt)) {
            int i = paramCodeIterator.getCodeLength();
            if (loopBody(paramCodeIterator, paramCtClass, paramMethodInfo, paramLoopContext)) {
                boolean bool2 = true;
                int j = paramCodeIterator.getCodeLength();
                bool1 = bool2;
                if (i != j) {
                    paramInt += j - i;
                    bool1 = bool2;
                }
            }
        }
        return bool1;
    }

    public void edit(Cast paramCast) {
    }

    public void edit(ConstructorCall paramConstructorCall) {
    }

    public void edit(FieldAccess paramFieldAccess) {
    }

    public void edit(Handler paramHandler) {
    }

    public void edit(Instanceof paramInstanceof) {
    }

    public void edit(MethodCall paramMethodCall) {
    }

    public void edit(NewArray paramNewArray) {
    }

    public void edit(NewExpr paramNewExpr) {
    }

    final boolean loopBody(CodeIterator paramCodeIterator, CtClass paramCtClass, MethodInfo paramMethodInfo, ExprEditor.LoopContext paramLoopContext) {
        Object localObject = null;
        int i;
        int j;
        for (; ; ) {
            try {
                i = paramCodeIterator.next();
                j = paramCodeIterator.byteAt(i);
                if (j >= 178) {
                    break label414;
                }
                if ((localObject == null) || (!((Expr) localObject).edited())) {
                    break;
                }
                paramLoopContext.updateMax(((Expr) localObject).locals(), ((Expr) localObject).stack());
                return true;
            } catch (BadBytecode paramCodeIterator) {
                label55:
                label81:
                throw new CannotCompileException(paramCodeIterator);
            }
            localObject = new MethodCall(i, paramCodeIterator, paramCtClass, paramMethodInfo);
            edit((MethodCall) localObject);
            continue;
            localObject = new FieldAccess(i, paramCodeIterator, paramCtClass, paramMethodInfo, j);
            edit((FieldAccess) localObject);
            continue;
            label119:
            if (j == 187) {
                j = paramCodeIterator.u16bitAt(i + 1);
                paramLoopContext.newList = new ExprEditor.NewOp(paramLoopContext.newList, i, paramMethodInfo.getConstPool().getClassInfo(j));
            } else if (j == 183) {
                ExprEditor.NewOp localNewOp = paramLoopContext.newList;
                if ((localNewOp != null) && (paramMethodInfo.getConstPool().isConstructor(localNewOp.type, paramCodeIterator.u16bitAt(i + 1)) > 0)) {
                    localObject = new NewExpr(i, paramCodeIterator, paramCtClass, paramMethodInfo, localNewOp.type, localNewOp.pos);
                    edit((NewExpr) localObject);
                    paramLoopContext.newList = localNewOp.next;
                } else {
                    localObject = new MethodCall(i, paramCodeIterator, paramCtClass, paramMethodInfo);
                    if (((MethodCall) localObject).getMethodName().equals("<init>")) {
                        localObject = new ConstructorCall(i, paramCodeIterator, paramCtClass, paramMethodInfo);
                        edit((ConstructorCall) localObject);
                    } else {
                        edit((MethodCall) localObject);
                    }
                }
            }
        }
        for (; ; ) {
            label316:
            localObject = new NewArray(i, paramCodeIterator, paramCtClass, paramMethodInfo, j);
            edit((NewArray) localObject);
            break;
            label414:
            do {
                if (j == 193) {
                    localObject = new Instanceof(i, paramCodeIterator, paramCtClass, paramMethodInfo);
                    edit((Instanceof) localObject);
                    break;
                }
                if (j != 192) {
                    break;
                }
                localObject = new Cast(i, paramCodeIterator, paramCtClass, paramMethodInfo);
                edit((Cast) localObject);
                break;
                return false;
                if (j < 188) {
                    if ((j == 184) || (j == 185) || (j == 182)) {
                        break label55;
                    }
                    if ((j == 180) || (j == 178) || (j == 181)) {
                        break label81;
                    }
                    if (j != 179) {
                        break label119;
                    }
                    break label81;
                }
                if ((j == 188) || (j == 189)) {
                    break label316;
                }
            } while (j != 197);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/expr/ExprEditor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */