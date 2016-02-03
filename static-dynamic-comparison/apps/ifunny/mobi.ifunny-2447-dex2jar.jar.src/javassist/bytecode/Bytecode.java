package javassist.bytecode;

import javassist.CtClass;
import javassist.CtPrimitiveType;

public class Bytecode
        extends ByteVector
        implements Cloneable, Opcode {
    public static final CtClass THIS = ConstPool.THIS;
    ConstPool constPool;
    int maxLocals;
    int maxStack;
    private int stackDepth;
    ExceptionTable tryblocks;

    public Bytecode(ConstPool paramConstPool) {
        this(paramConstPool, 0, 0);
    }

    public Bytecode(ConstPool paramConstPool, int paramInt1, int paramInt2) {
        this.constPool = paramConstPool;
        this.maxStack = paramInt1;
        this.maxLocals = paramInt2;
        this.tryblocks = new ExceptionTable(paramConstPool);
        this.stackDepth = 0;
    }

    private void addPutfield0(CtClass paramCtClass, String paramString1, String paramString2, String paramString3) {
        add(181);
        if (paramString1 == null) {
        }
        for (int i = this.constPool.addClassInfo(paramCtClass); ; i = this.constPool.addClassInfo(paramString1)) {
            addIndex(this.constPool.addFieldrefInfo(i, paramString2, paramString3));
            growStack(-1 - Descriptor.dataSize(paramString3));
            return;
        }
    }

    private void addPutstatic0(CtClass paramCtClass, String paramString1, String paramString2, String paramString3) {
        add(179);
        if (paramString1 == null) {
        }
        for (int i = this.constPool.addClassInfo(paramCtClass); ; i = this.constPool.addClassInfo(paramString1)) {
            addIndex(this.constPool.addFieldrefInfo(i, paramString2, paramString3));
            growStack(-Descriptor.dataSize(paramString3));
            return;
        }
    }

    public void add(int paramInt) {
        super.add(paramInt);
    }

    public void add32bit(int paramInt) {
        add(paramInt >> 24, paramInt >> 16, paramInt >> 8, paramInt);
    }

    public void addAload(int paramInt) {
        if (paramInt < 4) {
            addOpcode(paramInt + 42);
            return;
        }
        if (paramInt < 256) {
            addOpcode(25);
            add(paramInt);
            return;
        }
        addOpcode(196);
        addOpcode(25);
        addIndex(paramInt);
    }

    public void addAnewarray(String paramString) {
        addOpcode(189);
        addIndex(this.constPool.addClassInfo(paramString));
    }

    public void addAnewarray(CtClass paramCtClass, int paramInt) {
        addIconst(paramInt);
        addOpcode(189);
        addIndex(this.constPool.addClassInfo(paramCtClass));
    }

    public void addAstore(int paramInt) {
        if (paramInt < 4) {
            addOpcode(paramInt + 75);
            return;
        }
        if (paramInt < 256) {
            addOpcode(58);
            add(paramInt);
            return;
        }
        addOpcode(196);
        addOpcode(58);
        addIndex(paramInt);
    }

    public void addCheckcast(String paramString) {
        addOpcode(192);
        addIndex(this.constPool.addClassInfo(paramString));
    }

    public void addCheckcast(CtClass paramCtClass) {
        addOpcode(192);
        addIndex(this.constPool.addClassInfo(paramCtClass));
    }

    public void addConstZero(CtClass paramCtClass) {
        if (paramCtClass.isPrimitive()) {
            if (paramCtClass == CtClass.longType) {
                addOpcode(9);
                return;
            }
            if (paramCtClass == CtClass.floatType) {
                addOpcode(11);
                return;
            }
            if (paramCtClass == CtClass.doubleType) {
                addOpcode(14);
                return;
            }
            if (paramCtClass == CtClass.voidType) {
                throw new RuntimeException("void type?");
            }
            addOpcode(3);
            return;
        }
        addOpcode(1);
    }

    public void addDconst(double paramDouble) {
        if ((paramDouble == 0.0D) || (paramDouble == 1.0D)) {
            addOpcode((int) paramDouble + 14);
            return;
        }
        addLdc2w(paramDouble);
    }

    public void addDload(int paramInt) {
        if (paramInt < 4) {
            addOpcode(paramInt + 38);
            return;
        }
        if (paramInt < 256) {
            addOpcode(24);
            add(paramInt);
            return;
        }
        addOpcode(196);
        addOpcode(24);
        addIndex(paramInt);
    }

    public void addDstore(int paramInt) {
        if (paramInt < 4) {
            addOpcode(paramInt + 71);
            return;
        }
        if (paramInt < 256) {
            addOpcode(57);
            add(paramInt);
            return;
        }
        addOpcode(196);
        addOpcode(57);
        addIndex(paramInt);
    }

    public void addExceptionHandler(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        this.tryblocks.add(paramInt1, paramInt2, paramInt3, paramInt4);
    }

    public void addExceptionHandler(int paramInt1, int paramInt2, int paramInt3, String paramString) {
        addExceptionHandler(paramInt1, paramInt2, paramInt3, this.constPool.addClassInfo(paramString));
    }

    public void addExceptionHandler(int paramInt1, int paramInt2, int paramInt3, CtClass paramCtClass) {
        addExceptionHandler(paramInt1, paramInt2, paramInt3, this.constPool.addClassInfo(paramCtClass));
    }

    public void addFconst(float paramFloat) {
        if ((paramFloat == 0.0F) || (paramFloat == 1.0F) || (paramFloat == 2.0F)) {
            addOpcode((int) paramFloat + 11);
            return;
        }
        addLdc(this.constPool.addFloatInfo(paramFloat));
    }

    public void addFload(int paramInt) {
        if (paramInt < 4) {
            addOpcode(paramInt + 34);
            return;
        }
        if (paramInt < 256) {
            addOpcode(23);
            add(paramInt);
            return;
        }
        addOpcode(196);
        addOpcode(23);
        addIndex(paramInt);
    }

    public void addFstore(int paramInt) {
        if (paramInt < 4) {
            addOpcode(paramInt + 67);
            return;
        }
        if (paramInt < 256) {
            addOpcode(56);
            add(paramInt);
            return;
        }
        addOpcode(196);
        addOpcode(56);
        addIndex(paramInt);
    }

    public void addGap(int paramInt) {
        super.addGap(paramInt);
    }

    public void addGetfield(String paramString1, String paramString2, String paramString3) {
        add(180);
        int i = this.constPool.addClassInfo(paramString1);
        addIndex(this.constPool.addFieldrefInfo(i, paramString2, paramString3));
        growStack(Descriptor.dataSize(paramString3) - 1);
    }

    public void addGetfield(CtClass paramCtClass, String paramString1, String paramString2) {
        add(180);
        int i = this.constPool.addClassInfo(paramCtClass);
        addIndex(this.constPool.addFieldrefInfo(i, paramString1, paramString2));
        growStack(Descriptor.dataSize(paramString2) - 1);
    }

    public void addGetstatic(String paramString1, String paramString2, String paramString3) {
        add(178);
        int i = this.constPool.addClassInfo(paramString1);
        addIndex(this.constPool.addFieldrefInfo(i, paramString2, paramString3));
        growStack(Descriptor.dataSize(paramString3));
    }

    public void addGetstatic(CtClass paramCtClass, String paramString1, String paramString2) {
        add(178);
        int i = this.constPool.addClassInfo(paramCtClass);
        addIndex(this.constPool.addFieldrefInfo(i, paramString1, paramString2));
        growStack(Descriptor.dataSize(paramString2));
    }

    public void addIconst(int paramInt) {
        if ((paramInt < 6) && (-2 < paramInt)) {
            addOpcode(paramInt + 3);
            return;
        }
        if ((paramInt <= 127) && (-128 <= paramInt)) {
            addOpcode(16);
            add(paramInt);
            return;
        }
        if ((paramInt <= 32767) && (32768 <= paramInt)) {
            addOpcode(17);
            add(paramInt >> 8);
            add(paramInt);
            return;
        }
        addLdc(this.constPool.addIntegerInfo(paramInt));
    }

    public void addIload(int paramInt) {
        if (paramInt < 4) {
            addOpcode(paramInt + 26);
            return;
        }
        if (paramInt < 256) {
            addOpcode(21);
            add(paramInt);
            return;
        }
        addOpcode(196);
        addOpcode(21);
        addIndex(paramInt);
    }

    public void addIndex(int paramInt) {
        add(paramInt >> 8, paramInt);
    }

    public void addInstanceof(String paramString) {
        addOpcode(193);
        addIndex(this.constPool.addClassInfo(paramString));
    }

    public void addInvokeinterface(int paramInt1, String paramString1, String paramString2, int paramInt2) {
        add(185);
        addIndex(this.constPool.addInterfaceMethodrefInfo(paramInt1, paramString1, paramString2));
        add(paramInt2);
        add(0);
        growStack(Descriptor.dataSize(paramString2) - 1);
    }

    public void addInvokeinterface(String paramString1, String paramString2, String paramString3, int paramInt) {
        addInvokeinterface(this.constPool.addClassInfo(paramString1), paramString2, paramString3, paramInt);
    }

    public void addInvokeinterface(CtClass paramCtClass, String paramString1, String paramString2, int paramInt) {
        addInvokeinterface(this.constPool.addClassInfo(paramCtClass), paramString1, paramString2, paramInt);
    }

    public void addInvokeinterface(CtClass paramCtClass1, String paramString, CtClass paramCtClass2, CtClass[] paramArrayOfCtClass, int paramInt) {
        addInvokeinterface(paramCtClass1, paramString, Descriptor.ofMethod(paramCtClass2, paramArrayOfCtClass), paramInt);
    }

    public void addInvokespecial(int paramInt, String paramString1, String paramString2) {
        add(183);
        addIndex(this.constPool.addMethodrefInfo(paramInt, paramString1, paramString2));
        growStack(Descriptor.dataSize(paramString2) - 1);
    }

    public void addInvokespecial(String paramString1, String paramString2, String paramString3) {
        addInvokespecial(this.constPool.addClassInfo(paramString1), paramString2, paramString3);
    }

    public void addInvokespecial(CtClass paramCtClass, String paramString1, String paramString2) {
        addInvokespecial(this.constPool.addClassInfo(paramCtClass), paramString1, paramString2);
    }

    public void addInvokespecial(CtClass paramCtClass1, String paramString, CtClass paramCtClass2, CtClass[] paramArrayOfCtClass) {
        addInvokespecial(paramCtClass1, paramString, Descriptor.ofMethod(paramCtClass2, paramArrayOfCtClass));
    }

    public void addInvokestatic(int paramInt, String paramString1, String paramString2) {
        add(184);
        addIndex(this.constPool.addMethodrefInfo(paramInt, paramString1, paramString2));
        growStack(Descriptor.dataSize(paramString2));
    }

    public void addInvokestatic(String paramString1, String paramString2, String paramString3) {
        addInvokestatic(this.constPool.addClassInfo(paramString1), paramString2, paramString3);
    }

    public void addInvokestatic(CtClass paramCtClass, String paramString1, String paramString2) {
        addInvokestatic(this.constPool.addClassInfo(paramCtClass), paramString1, paramString2);
    }

    public void addInvokestatic(CtClass paramCtClass1, String paramString, CtClass paramCtClass2, CtClass[] paramArrayOfCtClass) {
        addInvokestatic(paramCtClass1, paramString, Descriptor.ofMethod(paramCtClass2, paramArrayOfCtClass));
    }

    public void addInvokevirtual(int paramInt, String paramString1, String paramString2) {
        add(182);
        addIndex(this.constPool.addMethodrefInfo(paramInt, paramString1, paramString2));
        growStack(Descriptor.dataSize(paramString2) - 1);
    }

    public void addInvokevirtual(String paramString1, String paramString2, String paramString3) {
        addInvokevirtual(this.constPool.addClassInfo(paramString1), paramString2, paramString3);
    }

    public void addInvokevirtual(CtClass paramCtClass, String paramString1, String paramString2) {
        addInvokevirtual(this.constPool.addClassInfo(paramCtClass), paramString1, paramString2);
    }

    public void addInvokevirtual(CtClass paramCtClass1, String paramString, CtClass paramCtClass2, CtClass[] paramArrayOfCtClass) {
        addInvokevirtual(paramCtClass1, paramString, Descriptor.ofMethod(paramCtClass2, paramArrayOfCtClass));
    }

    public void addIstore(int paramInt) {
        if (paramInt < 4) {
            addOpcode(paramInt + 59);
            return;
        }
        if (paramInt < 256) {
            addOpcode(54);
            add(paramInt);
            return;
        }
        addOpcode(196);
        addOpcode(54);
        addIndex(paramInt);
    }

    public void addLconst(long paramLong) {
        if ((paramLong == 0L) || (paramLong == 1L)) {
            addOpcode((int) paramLong + 9);
            return;
        }
        addLdc2w(paramLong);
    }

    public void addLdc(int paramInt) {
        if (paramInt > 255) {
            addOpcode(19);
            addIndex(paramInt);
            return;
        }
        addOpcode(18);
        add(paramInt);
    }

    public void addLdc(String paramString) {
        addLdc(this.constPool.addStringInfo(paramString));
    }

    public void addLdc2w(double paramDouble) {
        addOpcode(20);
        addIndex(this.constPool.addDoubleInfo(paramDouble));
    }

    public void addLdc2w(long paramLong) {
        addOpcode(20);
        addIndex(this.constPool.addLongInfo(paramLong));
    }

    public void addLload(int paramInt) {
        if (paramInt < 4) {
            addOpcode(paramInt + 30);
            return;
        }
        if (paramInt < 256) {
            addOpcode(22);
            add(paramInt);
            return;
        }
        addOpcode(196);
        addOpcode(22);
        addIndex(paramInt);
    }

    public int addLoad(int paramInt, CtClass paramCtClass) {
        if (paramCtClass.isPrimitive()) {
            if ((paramCtClass == CtClass.booleanType) || (paramCtClass == CtClass.charType) || (paramCtClass == CtClass.byteType) || (paramCtClass == CtClass.shortType) || (paramCtClass == CtClass.intType)) {
                addIload(paramInt);
            }
        }
        for (; ; ) {
            return 1;
            if (paramCtClass == CtClass.longType) {
                addLload(paramInt);
                return 2;
            }
            if (paramCtClass == CtClass.floatType) {
                addFload(paramInt);
            } else {
                if (paramCtClass == CtClass.doubleType) {
                    addDload(paramInt);
                    return 2;
                }
                throw new RuntimeException("void type?");
                addAload(paramInt);
            }
        }
    }

    public int addLoadParameters(CtClass[] paramArrayOfCtClass, int paramInt) {
        int k = 0;
        int i = 0;
        if (paramArrayOfCtClass != null) {
            int m = paramArrayOfCtClass.length;
            int j = 0;
            for (; ; ) {
                k = i;
                if (j >= m) {
                    break;
                }
                k = addLoad(i + paramInt, paramArrayOfCtClass[j]);
                j += 1;
                i = k + i;
            }
        }
        return k;
    }

    public void addLstore(int paramInt) {
        if (paramInt < 4) {
            addOpcode(paramInt + 63);
            return;
        }
        if (paramInt < 256) {
            addOpcode(55);
            add(paramInt);
            return;
        }
        addOpcode(196);
        addOpcode(55);
        addIndex(paramInt);
    }

    public int addMultiNewarray(String paramString, int paramInt) {
        add(197);
        addIndex(this.constPool.addClassInfo(paramString));
        add(paramInt);
        growStack(1 - paramInt);
        return paramInt;
    }

    public int addMultiNewarray(CtClass paramCtClass, int paramInt) {
        add(197);
        addIndex(this.constPool.addClassInfo(paramCtClass));
        add(paramInt);
        growStack(1 - paramInt);
        return paramInt;
    }

    public int addMultiNewarray(CtClass paramCtClass, int[] paramArrayOfInt) {
        int j = paramArrayOfInt.length;
        int i = 0;
        while (i < j) {
            addIconst(paramArrayOfInt[i]);
            i += 1;
        }
        growStack(j);
        return addMultiNewarray(paramCtClass, j);
    }

    public void addNew(String paramString) {
        addOpcode(187);
        addIndex(this.constPool.addClassInfo(paramString));
    }

    public void addNew(CtClass paramCtClass) {
        addOpcode(187);
        addIndex(this.constPool.addClassInfo(paramCtClass));
    }

    public void addNewarray(int paramInt1, int paramInt2) {
        addIconst(paramInt2);
        addOpcode(188);
        add(paramInt1);
    }

    public void addOpcode(int paramInt) {
        add(paramInt);
        growStack(STACK_GROW[paramInt]);
    }

    public void addPrintln(String paramString) {
        addGetstatic("java.lang.System", "err", "Ljava/io/PrintStream;");
        addLdc(paramString);
        addInvokevirtual("java.io.PrintStream", "println", "(Ljava/lang/String;)V");
    }

    public void addPutfield(String paramString1, String paramString2, String paramString3) {
        addPutfield0(null, paramString1, paramString2, paramString3);
    }

    public void addPutfield(CtClass paramCtClass, String paramString1, String paramString2) {
        addPutfield0(paramCtClass, null, paramString1, paramString2);
    }

    public void addPutstatic(String paramString1, String paramString2, String paramString3) {
        addPutstatic0(null, paramString1, paramString2, paramString3);
    }

    public void addPutstatic(CtClass paramCtClass, String paramString1, String paramString2) {
        addPutstatic0(paramCtClass, null, paramString1, paramString2);
    }

    public void addRet(int paramInt) {
        if (paramInt < 256) {
            addOpcode(169);
            add(paramInt);
            return;
        }
        addOpcode(196);
        addOpcode(169);
        addIndex(paramInt);
    }

    public void addReturn(CtClass paramCtClass) {
        if (paramCtClass == null) {
            addOpcode(177);
            return;
        }
        if (paramCtClass.isPrimitive()) {
            addOpcode(((CtPrimitiveType) paramCtClass).getReturnOp());
            return;
        }
        addOpcode(176);
    }

    public int addStore(int paramInt, CtClass paramCtClass) {
        if (paramCtClass.isPrimitive()) {
            if ((paramCtClass == CtClass.booleanType) || (paramCtClass == CtClass.charType) || (paramCtClass == CtClass.byteType) || (paramCtClass == CtClass.shortType) || (paramCtClass == CtClass.intType)) {
                addIstore(paramInt);
            }
        }
        for (; ; ) {
            return 1;
            if (paramCtClass == CtClass.longType) {
                addLstore(paramInt);
                return 2;
            }
            if (paramCtClass == CtClass.floatType) {
                addFstore(paramInt);
            } else {
                if (paramCtClass == CtClass.doubleType) {
                    addDstore(paramInt);
                    return 2;
                }
                throw new RuntimeException("void type?");
                addAstore(paramInt);
            }
        }
    }

    public Object clone() {
        try {
            Bytecode localBytecode = (Bytecode) super.clone();
            localBytecode.tryblocks = ((ExceptionTable) this.tryblocks.clone());
            return localBytecode;
        } catch (CloneNotSupportedException localCloneNotSupportedException) {
            throw new RuntimeException(localCloneNotSupportedException);
        }
    }

    public int currentPc() {
        return getSize();
    }

    public byte[] get() {
        return copy();
    }

    public ConstPool getConstPool() {
        return this.constPool;
    }

    public ExceptionTable getExceptionTable() {
        return this.tryblocks;
    }

    public int getMaxLocals() {
        return this.maxLocals;
    }

    public int getMaxStack() {
        return this.maxStack;
    }

    public int getStackDepth() {
        return this.stackDepth;
    }

    public void growStack(int paramInt) {
        setStackDepth(this.stackDepth + paramInt);
    }

    public void incMaxLocals(int paramInt) {
        this.maxLocals += paramInt;
    }

    public int length() {
        return getSize();
    }

    public int read(int paramInt) {
        return super.read(paramInt);
    }

    public int read16bit(int paramInt) {
        return (read(paramInt) << 8) + (read(paramInt + 1) & 0xFF);
    }

    public int read32bit(int paramInt) {
        return (read16bit(paramInt) << 16) + (read16bit(paramInt + 2) & 0xFFFF);
    }

    public void setMaxLocals(int paramInt) {
        this.maxLocals = paramInt;
    }

    public void setMaxLocals(boolean paramBoolean, CtClass[] paramArrayOfCtClass, int paramInt) {
        if (!paramBoolean) {
            paramInt += 1;
        }
        for (; ; ) {
            int j = paramInt;
            if (paramArrayOfCtClass != null) {
                CtClass localCtClass1 = CtClass.doubleType;
                CtClass localCtClass2 = CtClass.longType;
                int k = paramArrayOfCtClass.length;
                int i = 0;
                j = paramInt;
                if (i < k) {
                    CtClass localCtClass3 = paramArrayOfCtClass[i];
                    if ((localCtClass3 == localCtClass1) || (localCtClass3 == localCtClass2)) {
                        paramInt += 2;
                    }
                    for (; ; ) {
                        i += 1;
                        break;
                        paramInt += 1;
                    }
                }
            }
            this.maxLocals = j;
            return;
        }
    }

    public void setMaxStack(int paramInt) {
        this.maxStack = paramInt;
    }

    public void setStackDepth(int paramInt) {
        this.stackDepth = paramInt;
        if (this.stackDepth > this.maxStack) {
            this.maxStack = this.stackDepth;
        }
    }

    public CodeAttribute toCodeAttribute() {
        return new CodeAttribute(this.constPool, this.maxStack, this.maxLocals, get(), this.tryblocks);
    }

    public void write(int paramInt1, int paramInt2) {
        super.write(paramInt1, paramInt2);
    }

    public void write16bit(int paramInt1, int paramInt2) {
        write(paramInt1, paramInt2 >> 8);
        write(paramInt1 + 1, paramInt2);
    }

    public void write32bit(int paramInt1, int paramInt2) {
        write16bit(paramInt1, paramInt2 >> 16);
        write16bit(paramInt1 + 2, paramInt2);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/Bytecode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */