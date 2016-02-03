package javassist.bytecode.stackmap;

import javassist.bytecode.CodeIterator;

public class Liveness {
    static final int CHANGED_LAST = 1;
    static final int CHANGED_NOW = 3;
    static final int DONE = 2;
    static final int NOT_YET = 0;
    protected static final byte READ = 1;
    protected static final byte UNKNOWN = 0;
    protected static final byte UPDATED = 2;
    public static boolean useArgs = true;
    protected byte[] localsUsage;

    private void computeLiveness1(TypedBlock paramTypedBlock) {
        int k = 0;
        if (paramTypedBlock.updating) {
            computeLiveness1u(paramTypedBlock);
        }
        for (; ; ) {
            return;
            if (paramTypedBlock.inputs == null) {
                paramTypedBlock.updating = true;
                byte[] arrayOfByte = paramTypedBlock.localsUsage;
                int m = arrayOfByte.length;
                boolean[] arrayOfBoolean = new boolean[m];
                int i = 0;
                int n;
                if (i < m) {
                    if (arrayOfByte[i] == 1) {
                    }
                    for (n = 1; ; n = 0) {
                        arrayOfBoolean[i] = n;
                        i += 1;
                        break;
                    }
                }
                for (Object localObject = paramTypedBlock.toCatch; localObject != null; localObject = ((BasicBlock.Catch) localObject).next) {
                    TypedBlock localTypedBlock = (TypedBlock) ((BasicBlock.Catch) localObject).body;
                    computeLiveness1(localTypedBlock);
                    i = 0;
                    while (i < m) {
                        if (localTypedBlock.inputs[i] != 0) {
                            arrayOfBoolean[i] = true;
                        }
                        i += 1;
                    }
                }
                if (paramTypedBlock.exit != null) {
                    i = 0;
                    while (i < paramTypedBlock.exit.length) {
                        localObject = (TypedBlock) paramTypedBlock.exit[i];
                        computeLiveness1((TypedBlock) localObject);
                        int j = 0;
                        if (j < m) {
                            if (arrayOfBoolean[j] == 0) {
                                if ((arrayOfByte[j] != 0) || (localObject.inputs[j] == 0)) {
                                    break label233;
                                }
                            }
                            label233:
                            for (n = 1; ; n = 0) {
                                arrayOfBoolean[j] = n;
                                j += 1;
                                break;
                            }
                        }
                        i += 1;
                    }
                }
                paramTypedBlock.updating = false;
                i = k;
                if (paramTypedBlock.inputs == null) {
                    paramTypedBlock.inputs = arrayOfBoolean;
                    paramTypedBlock.status = 2;
                    return;
                }
                while (i < m) {
                    if ((arrayOfBoolean[i] != 0) && (paramTypedBlock.inputs[i] == 0)) {
                        paramTypedBlock.inputs[i] = true;
                        paramTypedBlock.status = 3;
                    }
                    i += 1;
                }
            }
        }
    }

    private void computeLiveness1u(TypedBlock paramTypedBlock) {
        if (paramTypedBlock.inputs == null) {
            byte[] arrayOfByte = paramTypedBlock.localsUsage;
            int j = arrayOfByte.length;
            boolean[] arrayOfBoolean = new boolean[j];
            int i = 0;
            if (i < j) {
                if (arrayOfByte[i] == 1) {
                }
                for (int k = 1; ; k = 0) {
                    arrayOfBoolean[i] = k;
                    i += 1;
                    break;
                }
            }
            paramTypedBlock.inputs = arrayOfBoolean;
            paramTypedBlock.status = 2;
        }
    }

    private void computeLiveness2(TypedBlock paramTypedBlock) {
        if ((paramTypedBlock.updating) || (paramTypedBlock.status >= 2)) {
            return;
        }
        paramTypedBlock.updating = true;
        if (paramTypedBlock.exit == null) {
            paramTypedBlock.status = 2;
        }
        for (; ; ) {
            if (computeLiveness2except(paramTypedBlock)) {
                paramTypedBlock.status = 3;
            }
            paramTypedBlock.updating = false;
            return;
            int i = 0;
            int j = 0;
            Object localObject;
            while (i < paramTypedBlock.exit.length) {
                localObject = (TypedBlock) paramTypedBlock.exit[i];
                computeLiveness2((TypedBlock) localObject);
                if (((TypedBlock) localObject).status != 2) {
                    j = 1;
                }
                i += 1;
            }
            if (j != 0) {
                localObject = paramTypedBlock.localsUsage;
                int n = localObject.length;
                j = 0;
                int m;
                for (i = 0; j < paramTypedBlock.exit.length; i = m) {
                    TypedBlock localTypedBlock = (TypedBlock) paramTypedBlock.exit[j];
                    m = i;
                    if (localTypedBlock.status != 2) {
                        int k = 0;
                        for (; ; ) {
                            m = i;
                            if (k >= n) {
                                break;
                            }
                            m = i;
                            if (paramTypedBlock.inputs[k] == 0) {
                                m = i;
                                if (localObject[k] == 0) {
                                    m = i;
                                    if (localTypedBlock.inputs[k] != 0) {
                                        paramTypedBlock.inputs[k] = true;
                                        m = 1;
                                    }
                                }
                            }
                            k += 1;
                            i = m;
                        }
                    }
                    j += 1;
                }
                if (i != 0) {
                }
                for (i = 3; ; i = 2) {
                    paramTypedBlock.status = i;
                    break;
                }
            }
            paramTypedBlock.status = 2;
        }
    }

    private boolean computeLiveness2except(TypedBlock paramTypedBlock) {
        BasicBlock.Catch localCatch = paramTypedBlock.toCatch;
        boolean bool2;
        for (boolean bool1 = false; localCatch != null; bool1 = bool2) {
            TypedBlock localTypedBlock = (TypedBlock) localCatch.body;
            computeLiveness2(localTypedBlock);
            bool2 = bool1;
            if (localTypedBlock.status != 2) {
                boolean[] arrayOfBoolean = paramTypedBlock.inputs;
                int j = arrayOfBoolean.length;
                int i = 0;
                for (; ; ) {
                    bool2 = bool1;
                    if (i >= j) {
                        break;
                    }
                    bool2 = bool1;
                    if (arrayOfBoolean[i] == 0) {
                        bool2 = bool1;
                        if (localTypedBlock.inputs[i] != 0) {
                            arrayOfBoolean[i] = true;
                            bool2 = true;
                        }
                    }
                    i += 1;
                    bool1 = bool2;
                }
            }
            localCatch = localCatch.next;
        }
        return bool1;
    }

    private void computeUsage(CodeIterator paramCodeIterator, TypedBlock[] paramArrayOfTypedBlock, int paramInt) {
        int j = paramArrayOfTypedBlock.length;
        int i = 0;
        while (i < j) {
            TypedBlock localTypedBlock = paramArrayOfTypedBlock[i];
            byte[] arrayOfByte = new byte[paramInt];
            localTypedBlock.localsUsage = arrayOfByte;
            this.localsUsage = arrayOfByte;
            int k = localTypedBlock.position;
            analyze(paramCodeIterator, k, localTypedBlock.length + k);
            this.localsUsage = null;
            i += 1;
        }
    }

    private void doOpcode0_53(CodeIterator paramCodeIterator, int paramInt1, int paramInt2) {
        switch (paramInt2) {
            default:
                return;
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
                readLocal(paramCodeIterator.byteAt(paramInt1 + 1));
                return;
            case 26:
            case 27:
            case 28:
            case 29:
                readLocal(paramInt2 - 26);
                return;
            case 30:
            case 31:
            case 32:
            case 33:
                readLocal(paramInt2 - 30);
                return;
            case 34:
            case 35:
            case 36:
            case 37:
                readLocal(paramInt2 - 34);
                return;
            case 38:
            case 39:
            case 40:
            case 41:
                readLocal(paramInt2 - 38);
                return;
        }
        readLocal(paramInt2 - 42);
    }

    private void doOpcode54_95(CodeIterator paramCodeIterator, int paramInt1, int paramInt2) {
        switch (paramInt2) {
            default:
                return;
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
                writeLocal(paramCodeIterator.byteAt(paramInt1 + 1));
                return;
            case 59:
            case 60:
            case 61:
            case 62:
                writeLocal(paramInt2 - 59);
                return;
            case 63:
            case 64:
            case 65:
            case 66:
                writeLocal(paramInt2 - 63);
                return;
            case 67:
            case 68:
            case 69:
            case 70:
                writeLocal(paramInt2 - 67);
                return;
            case 71:
            case 72:
            case 73:
            case 74:
                writeLocal(paramInt2 - 71);
                return;
        }
        writeLocal(paramInt2 - 75);
    }

    private void doWIDE(CodeIterator paramCodeIterator, int paramInt) {
        int i = paramCodeIterator.byteAt(paramInt + 1);
        paramInt = paramCodeIterator.u16bitAt(paramInt + 2);
        switch (i) {
            default:
                return;
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
                readLocal(paramInt);
                return;
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
                writeLocal(paramInt);
                return;
        }
        readLocal(paramInt);
    }

    private boolean hasChanged(TypedBlock[] paramArrayOfTypedBlock) {
        int j = paramArrayOfTypedBlock.length;
        int i = 0;
        boolean bool = false;
        if (i < j) {
            TypedBlock localTypedBlock = paramArrayOfTypedBlock[i];
            if (localTypedBlock.status == 3) {
                localTypedBlock.status = 1;
                bool = true;
            }
            for (; ; ) {
                i += 1;
                break;
                localTypedBlock.status = 0;
            }
        }
        return bool;
    }

    private void useAllArgs(TypedBlock[] paramArrayOfTypedBlock, TypeData[] paramArrayOfTypeData) {
        int i = 0;
        while (i < paramArrayOfTypedBlock.length) {
            byte[] arrayOfByte = paramArrayOfTypedBlock[i].localsUsage;
            int j = 0;
            while (j < paramArrayOfTypeData.length) {
                if (paramArrayOfTypeData[j] != TypeTag.TOP) {
                    arrayOfByte[j] = 1;
                }
                j += 1;
            }
            i += 1;
        }
    }

    protected void analyze(CodeIterator paramCodeIterator, int paramInt1, int paramInt2) {
        paramCodeIterator.begin();
        paramCodeIterator.move(paramInt1);
        for (; ; ) {
            if (paramCodeIterator.hasNext()) {
                paramInt1 = paramCodeIterator.next();
                if (paramInt1 < paramInt2) {
                }
            } else {
                return;
            }
            int i = paramCodeIterator.byteAt(paramInt1);
            if (i < 96) {
                if (i < 54) {
                    doOpcode0_53(paramCodeIterator, paramInt1, i);
                } else {
                    doOpcode54_95(paramCodeIterator, paramInt1, i);
                }
            } else if (i == 132) {
                readLocal(paramCodeIterator.byteAt(paramInt1 + 1));
            } else if (i == 196) {
                doWIDE(paramCodeIterator, paramInt1);
            }
        }
    }

    public void compute(CodeIterator paramCodeIterator, TypedBlock[] paramArrayOfTypedBlock, int paramInt, TypeData[] paramArrayOfTypeData) {
        computeUsage(paramCodeIterator, paramArrayOfTypedBlock, paramInt);
        if (useArgs) {
            useAllArgs(paramArrayOfTypedBlock, paramArrayOfTypeData);
        }
        computeLiveness1(paramArrayOfTypedBlock[0]);
        while (hasChanged(paramArrayOfTypedBlock)) {
            computeLiveness2(paramArrayOfTypedBlock[0]);
        }
    }

    protected final void readLocal(int paramInt) {
        if (this.localsUsage[paramInt] == 0) {
            this.localsUsage[paramInt] = 1;
        }
    }

    protected final void writeLocal(int paramInt) {
        if (this.localsUsage[paramInt] == 0) {
            this.localsUsage[paramInt] = 2;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/stackmap/Liveness.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */