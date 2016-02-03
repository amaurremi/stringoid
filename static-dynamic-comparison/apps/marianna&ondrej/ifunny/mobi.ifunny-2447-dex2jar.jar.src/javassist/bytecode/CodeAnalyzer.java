package javassist.bytecode;

class CodeAnalyzer
        implements Opcode {
    private CodeAttribute codeAttr;
    private ConstPool constPool;

    public CodeAnalyzer(CodeAttribute paramCodeAttribute) {
        this.codeAttr = paramCodeAttribute;
        this.constPool = paramCodeAttribute.getConstPool();
    }

    private void checkTarget(int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt, int paramInt4) {
        if ((paramInt2 < 0) || (paramInt3 <= paramInt2)) {
            throw new BadBytecode("bad branch offset at " + paramInt1);
        }
        paramInt3 = paramArrayOfInt[paramInt2];
        if (paramInt3 == 0) {
            paramArrayOfInt[paramInt2] = (-paramInt4);
        }
        while ((paramInt3 == paramInt4) || (paramInt3 == -paramInt4)) {
            return;
        }
        throw new BadBytecode("verification error (" + paramInt4 + "," + paramInt3 + ") at " + paramInt1);
    }

    private int getFieldSize(CodeIterator paramCodeIterator, int paramInt) {
        return Descriptor.dataSize(this.constPool.getFieldrefType(paramCodeIterator.u16bitAt(paramInt + 1)));
    }

    private void initStack(int[] paramArrayOfInt, CodeAttribute paramCodeAttribute) {
        int i = 0;
        paramArrayOfInt[0] = -1;
        paramCodeAttribute = paramCodeAttribute.getExceptionTable();
        if (paramCodeAttribute != null) {
            int j = paramCodeAttribute.size();
            while (i < j) {
                paramArrayOfInt[paramCodeAttribute.handlerPc(i)] = -2;
                i += 1;
            }
        }
    }

    private static boolean isEnd(int paramInt) {
        return ((172 <= paramInt) && (paramInt <= 177)) || (paramInt == 191);
    }

    private boolean processBranch(int paramInt1, CodeIterator paramCodeIterator, int paramInt2, int paramInt3, int[] paramArrayOfInt1, int paramInt4, int[] paramArrayOfInt2) {
        if (((153 <= paramInt1) && (paramInt1 <= 166)) || (paramInt1 == 198) || (paramInt1 == 199)) {
            checkTarget(paramInt2, paramInt2 + paramCodeIterator.s16bitAt(paramInt2 + 1), paramInt3, paramArrayOfInt1, paramInt4);
        }
        for (; ; ) {
            return false;
            switch (paramInt1) {
            }
        }
        checkTarget(paramInt2, paramInt2 + paramCodeIterator.s16bitAt(paramInt2 + 1), paramInt3, paramArrayOfInt1, paramInt4);
        return true;
        checkTarget(paramInt2, paramInt2 + paramCodeIterator.s32bitAt(paramInt2 + 1), paramInt3, paramArrayOfInt1, paramInt4);
        return true;
        if (paramInt1 == 168) {
        }
        for (paramInt1 = paramInt2 + paramCodeIterator.s16bitAt(paramInt2 + 1); ; paramInt1 = paramInt2 + paramCodeIterator.s32bitAt(paramInt2 + 1)) {
            checkTarget(paramInt2, paramInt1, paramInt3, paramArrayOfInt1, paramInt4);
            if (paramArrayOfInt2[0] >= 0) {
                break;
            }
            paramArrayOfInt2[0] = paramInt4;
            return false;
        }
        if (paramInt4 == paramArrayOfInt2[0]) {
            return false;
        }
        throw new BadBytecode("sorry, cannot compute this data flow due to JSR: " + paramInt4 + "," + paramArrayOfInt2[0]);
        if (paramArrayOfInt2[0] < 0) {
            paramArrayOfInt2[0] = (paramInt4 + 1);
            return false;
        }
        if (paramInt4 + 1 == paramArrayOfInt2[0]) {
            return true;
        }
        throw new BadBytecode("sorry, cannot compute this data flow due to RET: " + paramInt4 + "," + paramArrayOfInt2[0]);
        int m = (paramInt2 & 0xFFFFFFFC) + 4;
        checkTarget(paramInt2, paramInt2 + paramCodeIterator.s32bitAt(m), paramInt3, paramArrayOfInt1, paramInt4);
        if (paramInt1 == 171) {
            j = paramCodeIterator.s32bitAt(m + 4);
            i = 0;
            paramInt1 = m + 12;
            while (i < j) {
                checkTarget(paramInt2, paramInt2 + paramCodeIterator.s32bitAt(paramInt1), paramInt3, paramArrayOfInt1, paramInt4);
                i += 1;
                paramInt1 += 8;
            }
        }
        int j = paramCodeIterator.s32bitAt(m + 4);
        int k = paramCodeIterator.s32bitAt(m + 8);
        int i = 0;
        paramInt1 = m + 12;
        while (i < k - j + 1) {
            checkTarget(paramInt2, paramInt2 + paramCodeIterator.s32bitAt(paramInt1), paramInt3, paramArrayOfInt1, paramInt4);
            i += 1;
            paramInt1 += 4;
        }
        return true;
    }

    private void visitBytecode(CodeIterator paramCodeIterator, int[] paramArrayOfInt, int paramInt) {
        int i = paramArrayOfInt.length;
        paramCodeIterator.move(paramInt);
        paramInt = -paramArrayOfInt[paramInt];
        for (; ; ) {
            int k;
            if (paramCodeIterator.hasNext()) {
                int j = paramCodeIterator.next();
                paramArrayOfInt[j] = paramInt;
                k = paramCodeIterator.byteAt(j);
                paramInt = visitInst(k, paramCodeIterator, j, paramInt);
                if (paramInt < 1) {
                    throw new BadBytecode("stack underflow at " + j);
                }
                if (!processBranch(k, paramCodeIterator, j, i, paramArrayOfInt, paramInt, new int[]{-1})) {
                    break label108;
                }
            }
            label108:
            while (isEnd(k)) {
                return;
            }
            if ((k == 168) || (k == 201)) {
                paramInt -= 1;
            }
        }
    }

    private int visitInst(int paramInt1, CodeIterator paramCodeIterator, int paramInt2, int paramInt3) {
        int i = paramInt1;
        switch (paramInt1) {
        }
        for (i = paramInt1; ; i = paramCodeIterator.byteAt(paramInt2 + 1)) {
            return STACK_GROW[i] + paramInt3;
            return getFieldSize(paramCodeIterator, paramInt2) - 1 + paramInt3;
            return paramInt3 - (getFieldSize(paramCodeIterator, paramInt2) + 1);
            return getFieldSize(paramCodeIterator, paramInt2) + paramInt3;
            return paramInt3 - getFieldSize(paramCodeIterator, paramInt2);
            return Descriptor.dataSize(this.constPool.getMethodrefType(paramCodeIterator.u16bitAt(paramInt2 + 1))) - 1 + paramInt3;
            return Descriptor.dataSize(this.constPool.getMethodrefType(paramCodeIterator.u16bitAt(paramInt2 + 1))) + paramInt3;
            return Descriptor.dataSize(this.constPool.getInterfaceMethodrefType(paramCodeIterator.u16bitAt(paramInt2 + 1))) - 1 + paramInt3;
            return 1;
            return 1 - paramCodeIterator.byteAt(paramInt2 + 3) + paramInt3;
        }
    }

    public int computeMaxStack() {
        CodeIterator localCodeIterator = this.codeAttr.iterator();
        int m = localCodeIterator.getCodeLength();
        int[] arrayOfInt = new int[m];
        this.constPool = this.codeAttr.getConstPool();
        initStack(arrayOfInt, this.codeAttr);
        do {
            i = 0;
            j = 0;
            while (i < m) {
                if (arrayOfInt[i] < 0) {
                    visitBytecode(localCodeIterator, arrayOfInt, i);
                    j = 1;
                }
                i += 1;
            }
        } while (j != 0);
        int j = 1;
        int i = 0;
        while (i < m) {
            int k = j;
            if (arrayOfInt[i] > j) {
                k = arrayOfInt[i];
            }
            i += 1;
            j = k;
        }
        return j - 1;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/CodeAnalyzer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */