package javassist.bytecode.analysis;

import java.util.Collection;
import java.util.Iterator;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.ConstPool;
import javassist.bytecode.Descriptor;
import javassist.bytecode.ExceptionTable;
import javassist.bytecode.MethodInfo;
import javassist.bytecode.Opcode;

public class Analyzer
        implements Opcode {
    private CtClass clazz;
    private Analyzer.ExceptionInfo[] exceptions;
    private Frame[] frames;
    private final SubroutineScanner scanner = new SubroutineScanner();
    private Subroutine[] subroutines;

    private void analyzeNextEntry(MethodInfo paramMethodInfo, CodeIterator paramCodeIterator, IntQueue paramIntQueue, Executor paramExecutor) {
        int i = paramIntQueue.take();
        paramCodeIterator.move(i);
        paramCodeIterator.next();
        Frame localFrame = this.frames[i].copy();
        Subroutine localSubroutine = this.subroutines[i];
        for (; ; ) {
            int j;
            try {
                paramExecutor.execute(paramMethodInfo, i, paramCodeIterator, localFrame, localSubroutine);
                j = paramCodeIterator.byteAt(i);
                if (j == 170) {
                    mergeTableSwitch(paramIntQueue, i, paramCodeIterator, localFrame);
                    mergeExceptionHandlers(paramIntQueue, paramMethodInfo, i, localFrame);
                    return;
                }
            } catch (RuntimeException paramMethodInfo) {
                throw new BadBytecode(paramMethodInfo.getMessage() + "[pos = " + i + "]", paramMethodInfo);
            }
            if (j == 171) {
                mergeLookupSwitch(paramIntQueue, i, paramCodeIterator, localFrame);
            } else if (j == 169) {
                mergeRet(paramIntQueue, paramCodeIterator, i, localFrame, localSubroutine);
            } else {
                if (Util.isJumpInstruction(j)) {
                    int k = Util.getJumpTarget(i, paramCodeIterator);
                    if (Util.isJsr(j)) {
                        mergeJsr(paramIntQueue, this.frames[i], this.subroutines[k], i, lookAhead(paramCodeIterator, i));
                    }
                    for (; ; ) {
                        merge(paramIntQueue, localFrame, k);
                        break;
                        if (!Util.isGoto(j)) {
                            merge(paramIntQueue, localFrame, lookAhead(paramCodeIterator, i));
                        }
                    }
                }
                if ((j != 191) && (!Util.isReturn(j))) {
                    merge(paramIntQueue, localFrame, lookAhead(paramCodeIterator, i));
                }
            }
        }
    }

    private Analyzer.ExceptionInfo[] buildExceptionInfo(MethodInfo paramMethodInfo) {
        ConstPool localConstPool = paramMethodInfo.getConstPool();
        ClassPool localClassPool = this.clazz.getClassPool();
        ExceptionTable localExceptionTable = paramMethodInfo.getCodeAttribute().getExceptionTable();
        Analyzer.ExceptionInfo[] arrayOfExceptionInfo = new Analyzer.ExceptionInfo[localExceptionTable.size()];
        int i = 0;
        if (i < localExceptionTable.size()) {
            int j = localExceptionTable.catchType(i);
            if (j == 0) {
            }
            for (; ; ) {
                try {
                    paramMethodInfo = Type.THROWABLE;
                    arrayOfExceptionInfo[i] = new Analyzer.ExceptionInfo(localExceptionTable.startPc(i), localExceptionTable.endPc(i), localExceptionTable.handlerPc(i), paramMethodInfo, null);
                    i += 1;
                } catch (NotFoundException paramMethodInfo) {
                    throw new IllegalStateException(paramMethodInfo.getMessage());
                }
                paramMethodInfo = Type.get(localClassPool.get(localConstPool.getClassInfo(j)));
            }
        }
        return arrayOfExceptionInfo;
    }

    private Frame firstFrame(MethodInfo paramMethodInfo, int paramInt1, int paramInt2) {
        int i = 0;
        Frame localFrame = new Frame(paramInt1, paramInt2);
        if ((paramMethodInfo.getAccessFlags() & 0x8) == 0) {
            paramInt1 = 1;
            localFrame.setLocal(0, Type.get(this.clazz));
        }
        for (; ; ) {
            try {
                paramMethodInfo = Descriptor.getParameterTypes(paramMethodInfo.getDescriptor(), this.clazz.getClassPool());
                paramInt2 = i;
                if (paramInt2 < paramMethodInfo.length) {
                    Type localType = zeroExtend(Type.get(paramMethodInfo[paramInt2]));
                    i = paramInt1 + 1;
                    localFrame.setLocal(paramInt1, localType);
                    if (localType.getSize() == 2) {
                        paramInt1 = i + 1;
                        localFrame.setLocal(i, Type.TOP);
                        paramInt2 += 1;
                    }
                } else {
                    return localFrame;
                }
            } catch (NotFoundException paramMethodInfo) {
                throw new RuntimeException(paramMethodInfo);
            }
            paramInt1 = i;
            continue;
            paramInt1 = 0;
        }
    }

    private int getNext(CodeIterator paramCodeIterator, int paramInt1, int paramInt2) {
        paramCodeIterator.move(paramInt1);
        paramCodeIterator.next();
        paramInt1 = paramCodeIterator.lookAhead();
        paramCodeIterator.move(paramInt2);
        paramCodeIterator.next();
        return paramInt1;
    }

    private int lookAhead(CodeIterator paramCodeIterator, int paramInt) {
        if (!paramCodeIterator.hasNext()) {
            throw new BadBytecode("Execution falls off end! [pos = " + paramInt + "]");
        }
        return paramCodeIterator.lookAhead();
    }

    private void merge(IntQueue paramIntQueue, Frame paramFrame, int paramInt) {
        Frame localFrame = this.frames[paramInt];
        if (localFrame == null) {
            this.frames[paramInt] = paramFrame.copy();
        }
        for (boolean bool = true; ; bool = localFrame.merge(paramFrame)) {
            if (bool) {
                paramIntQueue.add(paramInt);
            }
            return;
        }
    }

    private void mergeExceptionHandlers(IntQueue paramIntQueue, MethodInfo paramMethodInfo, int paramInt, Frame paramFrame) {
        int i = 0;
        while (i < this.exceptions.length) {
            paramMethodInfo = this.exceptions[i];
            if ((paramInt >= Analyzer.ExceptionInfo.access$100(paramMethodInfo)) && (paramInt < Analyzer.ExceptionInfo.access$200(paramMethodInfo))) {
                Frame localFrame = paramFrame.copy();
                localFrame.clearStack();
                localFrame.push(Analyzer.ExceptionInfo.access$300(paramMethodInfo));
                merge(paramIntQueue, localFrame, Analyzer.ExceptionInfo.access$400(paramMethodInfo));
            }
            i += 1;
        }
    }

    private void mergeJsr(IntQueue paramIntQueue, Frame paramFrame, Subroutine paramSubroutine, int paramInt1, int paramInt2) {
        int j = 0;
        int k = 1;
        if (paramSubroutine == null) {
            throw new BadBytecode("No subroutine at jsr target! [pos = " + paramInt1 + "]");
        }
        Frame localFrame = this.frames[paramInt2];
        if (localFrame == null) {
            paramSubroutine = this.frames;
            paramFrame = paramFrame.copy();
            paramSubroutine[paramInt2] = paramFrame;
            paramInt1 = 1;
        }
        for (; ; ) {
            if (!paramFrame.isJsrMerged()) {
                paramFrame.setJsrMerged(true);
                paramInt1 = k;
            }
            for (; ; ) {
                if ((paramInt1 != 0) && (paramFrame.isRetMerged())) {
                    paramIntQueue.add(paramInt2);
                }
                return;
                paramInt1 = 0;
                if (j >= paramFrame.localsLength()) {
                    break;
                }
                int i = paramInt1;
                Type localType1;
                Type localType2;
                if (!paramSubroutine.isAccessed(j)) {
                    localType1 = localFrame.getLocal(j);
                    localType2 = paramFrame.getLocal(j);
                    if (localType1 != null) {
                        break label183;
                    }
                    localFrame.setLocal(j, localType2);
                    i = 1;
                }
                for (; ; ) {
                    j += 1;
                    paramInt1 = i;
                    break;
                    label183:
                    localType2 = localType1.merge(localType2);
                    localFrame.setLocal(j, localType2);
                    if (localType2.equals(localType1)) {
                        i = paramInt1;
                        if (!localType2.popChanged()) {
                        }
                    } else {
                        i = 1;
                    }
                }
            }
            paramFrame = localFrame;
        }
    }

    private void mergeLookupSwitch(IntQueue paramIntQueue, int paramInt, CodeIterator paramCodeIterator, Frame paramFrame) {
        int i = (paramInt & 0xFFFFFFFC) + 4;
        merge(paramIntQueue, paramFrame, paramCodeIterator.s32bitAt(i) + paramInt);
        i += 4;
        int j = paramCodeIterator.s32bitAt(i);
        int k = i + 4;
        i = k + 4;
        while (i < j * 8 + k) {
            merge(paramIntQueue, paramFrame, paramCodeIterator.s32bitAt(i) + paramInt);
            i += 8;
        }
    }

    private void mergeRet(IntQueue paramIntQueue, CodeIterator paramCodeIterator, int paramInt, Frame paramFrame, Subroutine paramSubroutine) {
        if (paramSubroutine == null) {
            throw new BadBytecode("Ret on no subroutine! [pos = " + paramInt + "]");
        }
        Iterator localIterator = paramSubroutine.callers().iterator();
        int i;
        Frame localFrame;
        boolean bool;
        if (localIterator.hasNext()) {
            i = getNext(paramCodeIterator, ((Integer) localIterator.next()).intValue(), paramInt);
            localFrame = this.frames[i];
            if (localFrame == null) {
                Object localObject = this.frames;
                localFrame = paramFrame.copyStack();
                localObject[i] = localFrame;
                bool = true;
                label118:
                localObject = paramSubroutine.accessed().iterator();
                label130:
                if (!((Iterator) localObject).hasNext()) {
                    break label207;
                }
                int j = ((Integer) ((Iterator) localObject).next()).intValue();
                Type localType1 = localFrame.getLocal(j);
                Type localType2 = paramFrame.getLocal(j);
                if (localType1 == localType2) {
                    break label247;
                }
                localFrame.setLocal(j, localType2);
                bool = true;
            }
        }
        label207:
        label247:
        for (; ; ) {
            break label130;
            bool = localFrame.mergeStack(paramFrame);
            break label118;
            if (!localFrame.isRetMerged()) {
                localFrame.setRetMerged(true);
                bool = true;
            }
            if ((!bool) || (!localFrame.isJsrMerged())) {
                break;
            }
            paramIntQueue.add(i);
            break;
            return;
        }
    }

    private void mergeTableSwitch(IntQueue paramIntQueue, int paramInt, CodeIterator paramCodeIterator, Frame paramFrame) {
        int i = (paramInt & 0xFFFFFFFC) + 4;
        merge(paramIntQueue, paramFrame, paramCodeIterator.s32bitAt(i) + paramInt);
        i += 4;
        int k = paramCodeIterator.s32bitAt(i);
        i += 4;
        int m = paramCodeIterator.s32bitAt(i);
        int j = i + 4;
        i = j;
        while (i < (m - k + 1) * 4 + j) {
            merge(paramIntQueue, paramFrame, paramCodeIterator.s32bitAt(i) + paramInt);
            i += 4;
        }
    }

    private Type zeroExtend(Type paramType) {
        Type localType;
        if ((paramType != Type.SHORT) && (paramType != Type.BYTE) && (paramType != Type.CHAR)) {
            localType = paramType;
            if (paramType != Type.BOOLEAN) {
            }
        } else {
            localType = Type.INTEGER;
        }
        return localType;
    }

    public Frame[] analyze(CtClass paramCtClass, MethodInfo paramMethodInfo) {
        this.clazz = paramCtClass;
        Object localObject = paramMethodInfo.getCodeAttribute();
        if (localObject == null) {
            return null;
        }
        int i = ((CodeAttribute) localObject).getMaxLocals();
        int j = ((CodeAttribute) localObject).getMaxStack();
        int k = ((CodeAttribute) localObject).getCodeLength();
        localObject = ((CodeAttribute) localObject).iterator();
        IntQueue localIntQueue = new IntQueue();
        this.exceptions = buildExceptionInfo(paramMethodInfo);
        this.subroutines = this.scanner.scan(paramMethodInfo);
        paramCtClass = new Executor(paramCtClass.getClassPool(), paramMethodInfo.getConstPool());
        this.frames = new Frame[k];
        this.frames[localObject.lookAhead()] = firstFrame(paramMethodInfo, i, j);
        localIntQueue.add(((CodeIterator) localObject).next());
        while (!localIntQueue.isEmpty()) {
            analyzeNextEntry(paramMethodInfo, (CodeIterator) localObject, localIntQueue, paramCtClass);
        }
        return this.frames;
    }

    public Frame[] analyze(CtMethod paramCtMethod) {
        return analyze(paramCtMethod.getDeclaringClass(), paramCtMethod.getMethodInfo2());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/analysis/Analyzer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */