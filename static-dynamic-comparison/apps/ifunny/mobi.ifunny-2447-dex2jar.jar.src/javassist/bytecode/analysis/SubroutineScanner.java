package javassist.bytecode.analysis;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.ExceptionTable;
import javassist.bytecode.MethodInfo;
import javassist.bytecode.Opcode;

public class SubroutineScanner
        implements Opcode {
    Set done = new HashSet();
    Map subTable = new HashMap();
    private Subroutine[] subroutines;

    private void scan(int paramInt, CodeIterator paramCodeIterator, Subroutine paramSubroutine) {
        if (this.done.contains(new Integer(paramInt))) {
            return;
        }
        this.done.add(new Integer(paramInt));
        int i = paramCodeIterator.lookAhead();
        paramCodeIterator.move(paramInt);
        for (; ; ) {
            if ((scanOp(paramCodeIterator.next(), paramCodeIterator, paramSubroutine)) && (paramCodeIterator.hasNext())) {
            }
            for (paramInt = 1; paramInt == 0; paramInt = 0) {
                paramCodeIterator.move(i);
                return;
            }
        }
    }

    private void scanLookupSwitch(int paramInt, CodeIterator paramCodeIterator, Subroutine paramSubroutine) {
        int i = (paramInt & 0xFFFFFFFC) + 4;
        scan(paramCodeIterator.s32bitAt(i) + paramInt, paramCodeIterator, paramSubroutine);
        i += 4;
        int j = paramCodeIterator.s32bitAt(i);
        int k = i + 4;
        i = k + 4;
        while (i < j * 8 + k) {
            scan(paramCodeIterator.s32bitAt(i) + paramInt, paramCodeIterator, paramSubroutine);
            i += 8;
        }
    }

    private boolean scanOp(int paramInt, CodeIterator paramCodeIterator, Subroutine paramSubroutine) {
        this.subroutines[paramInt] = paramSubroutine;
        int i = paramCodeIterator.byteAt(paramInt);
        if (i == 170) {
            scanTableSwitch(paramInt, paramCodeIterator, paramSubroutine);
        }
        do {
            return false;
            if (i == 171) {
                scanLookupSwitch(paramInt, paramCodeIterator, paramSubroutine);
                return false;
            }
        } while ((Util.isReturn(i)) || (i == 169) || (i == 191));
        int j;
        if (Util.isJumpInstruction(i)) {
            j = Util.getJumpTarget(paramInt, paramCodeIterator);
            if ((i != 168) && (i != 201)) {
                break label178;
            }
            paramSubroutine = (Subroutine) this.subTable.get(new Integer(j));
            if (paramSubroutine != null) {
                break label170;
            }
            paramSubroutine = new Subroutine(j, paramInt);
            this.subTable.put(new Integer(j), paramSubroutine);
            scan(j, paramCodeIterator, paramSubroutine);
        }
        label170:
        label178:
        do {
            for (; ; ) {
                return true;
                paramSubroutine.addCaller(paramInt);
            }
            scan(j, paramCodeIterator, paramSubroutine);
        } while (!Util.isGoto(i));
        return false;
    }

    private void scanTableSwitch(int paramInt, CodeIterator paramCodeIterator, Subroutine paramSubroutine) {
        int i = (paramInt & 0xFFFFFFFC) + 4;
        scan(paramCodeIterator.s32bitAt(i) + paramInt, paramCodeIterator, paramSubroutine);
        i += 4;
        int k = paramCodeIterator.s32bitAt(i);
        i += 4;
        int m = paramCodeIterator.s32bitAt(i);
        int j = i + 4;
        i = j;
        while (i < (m - k + 1) * 4 + j) {
            scan(paramCodeIterator.s32bitAt(i) + paramInt, paramCodeIterator, paramSubroutine);
            i += 4;
        }
    }

    public Subroutine[] scan(MethodInfo paramMethodInfo) {
        int i = 0;
        Object localObject = paramMethodInfo.getCodeAttribute();
        paramMethodInfo = ((CodeAttribute) localObject).iterator();
        this.subroutines = new Subroutine[((CodeAttribute) localObject).getCodeLength()];
        this.subTable.clear();
        this.done.clear();
        scan(0, paramMethodInfo, null);
        localObject = ((CodeAttribute) localObject).getExceptionTable();
        while (i < ((ExceptionTable) localObject).size()) {
            scan(((ExceptionTable) localObject).handlerPc(i), paramMethodInfo, this.subroutines[localObject.startPc(i)]);
            i += 1;
        }
        return this.subroutines;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/analysis/SubroutineScanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */