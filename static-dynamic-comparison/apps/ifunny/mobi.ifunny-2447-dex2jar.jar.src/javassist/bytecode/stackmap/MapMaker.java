package javassist.bytecode.stackmap;

import javassist.ClassPool;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.ConstPool;
import javassist.bytecode.MethodInfo;
import javassist.bytecode.StackMap;
import javassist.bytecode.StackMap.Writer;
import javassist.bytecode.StackMapTable;
import javassist.bytecode.StackMapTable.Writer;

public class MapMaker
        extends Tracer {
    public MapMaker(ClassPool paramClassPool, MethodInfo paramMethodInfo, CodeAttribute paramCodeAttribute) {
        super(paramClassPool, paramMethodInfo.getConstPool(), paramCodeAttribute.getMaxStack(), paramCodeAttribute.getMaxLocals(), TypedBlock.getRetType(paramMethodInfo.getDescriptor()));
    }

    protected MapMaker(MapMaker paramMapMaker, boolean paramBoolean) {
        super(paramMapMaker, paramBoolean);
    }

    private static int diffSize(TypeData[] paramArrayOfTypeData, int paramInt1, int paramInt2) {
        int j = 0;
        int i = paramInt1;
        int k;
        for (paramInt1 = j; i < paramInt2; paramInt1 = k) {
            j = i + 1;
            TypeData localTypeData = paramArrayOfTypeData[i];
            k = paramInt1 + 1;
            paramInt1 = j;
            if (localTypeData != TOP) {
                paramInt1 = j;
                if (localTypeData.is2WordType()) {
                    paramInt1 = j + 1;
                }
            }
            i = paramInt1;
        }
        return paramInt1;
    }

    private static void evalExpected(ClassPool paramClassPool, int paramInt, TypeData[] paramArrayOfTypeData) {
        int i = 0;
        while (i < paramInt) {
            TypeData localTypeData = paramArrayOfTypeData[i];
            if (localTypeData != null) {
                localTypeData.evalExpectedType(paramClassPool);
            }
            i += 1;
        }
    }

    private int[] fillStackMap(int paramInt1, int paramInt2, int[] paramArrayOfInt, TypeData[] paramArrayOfTypeData) {
        int i = diffSize(paramArrayOfTypeData, paramInt2, paramInt2 + paramInt1);
        ConstPool localConstPool = this.cpool;
        int[] arrayOfInt = new int[i];
        i = 0;
        int j = 0;
        if (i < paramInt1) {
            TypeData localTypeData = paramArrayOfTypeData[(paramInt2 + i)];
            int k;
            if (localTypeData == TOP) {
                arrayOfInt[j] = 0;
                paramArrayOfInt[j] = 0;
                k = i;
            }
            for (; ; ) {
                j += 1;
                i = k + 1;
                break;
                arrayOfInt[j] = localTypeData.getTypeTag();
                paramArrayOfInt[j] = localTypeData.getTypeData(localConstPool);
                k = i;
                if (localTypeData.is2WordType()) {
                    k = i + 1;
                }
            }
        }
        return arrayOfInt;
    }

    private void fixParamTypes(TypedBlock paramTypedBlock) {
        paramTypedBlock = paramTypedBlock.localsTypes;
        int j = paramTypedBlock.length;
        int i = 0;
        while (i < j) {
            TypeData localTypeData = paramTypedBlock[i];
            if ((localTypeData instanceof TypeData.ClassName)) {
                TypeData.setType(localTypeData, localTypeData.getName(), this.classPool);
            }
            i += 1;
        }
    }

    private boolean isTarget(TypedBlock paramTypedBlock1, TypedBlock paramTypedBlock2) {
        int i = paramTypedBlock1.incoming;
        if (i > 1) {
            return true;
        }
        if (i < 1) {
            return false;
        }
        return paramTypedBlock2.stop;
    }

    public static StackMapTable make(ClassPool paramClassPool, MethodInfo paramMethodInfo) {
        CodeAttribute localCodeAttribute = paramMethodInfo.getCodeAttribute();
        if (localCodeAttribute == null) {
        }
        TypedBlock[] arrayOfTypedBlock;
        do {
            return null;
            arrayOfTypedBlock = TypedBlock.makeBlocks(paramMethodInfo, localCodeAttribute, true);
        } while (arrayOfTypedBlock == null);
        paramClassPool = new MapMaker(paramClassPool, paramMethodInfo, localCodeAttribute);
        paramClassPool.make(arrayOfTypedBlock, localCodeAttribute.getCode());
        return paramClassPool.toStackMap(arrayOfTypedBlock);
    }

    private void make(byte[] paramArrayOfByte, TypedBlock paramTypedBlock) {
        for (Object localObject = paramTypedBlock.toCatch; localObject != null; localObject = ((BasicBlock.Catch) localObject).next) {
            traceException(paramArrayOfByte, (BasicBlock.Catch) localObject);
        }
        int j = paramTypedBlock.position;
        int k = paramTypedBlock.length;
        int i = j;
        while (i < k + j) {
            i += doOpcode(i, paramArrayOfByte);
        }
        if (paramTypedBlock.exit != null) {
            i = 0;
            if (i < paramTypedBlock.exit.length) {
                localObject = (TypedBlock) paramTypedBlock.exit[i];
                if (((TypedBlock) localObject).alreadySet()) {
                    mergeMap((TypedBlock) localObject, true);
                }
                for (; ; ) {
                    i += 1;
                    break;
                    recordStackMap((TypedBlock) localObject);
                    new MapMaker(this, true).make(paramArrayOfByte, (TypedBlock) localObject);
                }
            }
        }
    }

    public static StackMap make2(ClassPool paramClassPool, MethodInfo paramMethodInfo) {
        CodeAttribute localCodeAttribute = paramMethodInfo.getCodeAttribute();
        if (localCodeAttribute == null) {
        }
        TypedBlock[] arrayOfTypedBlock;
        do {
            return null;
            arrayOfTypedBlock = TypedBlock.makeBlocks(paramMethodInfo, localCodeAttribute, true);
        } while (arrayOfTypedBlock == null);
        paramClassPool = new MapMaker(paramClassPool, paramMethodInfo, localCodeAttribute);
        paramClassPool.make(arrayOfTypedBlock, localCodeAttribute.getCode());
        return paramClassPool.toStackMap2(paramMethodInfo.getConstPool(), arrayOfTypedBlock);
    }

    private void merge(TypeData paramTypeData1, TypeData paramTypeData2) {
        int k = 0;
        if ((paramTypeData1 != TOP) && (paramTypeData1.isObjectType())) {
        }
        for (int i = 1; ; i = 0) {
            int j = k;
            if (paramTypeData2 != TOP) {
                j = k;
                if (paramTypeData2.isObjectType()) {
                    j = 1;
                }
            }
            if ((i != 0) && (j != 0)) {
                paramTypeData2.merge(paramTypeData1);
            }
            return;
        }
    }

    private void mergeMap(TypedBlock paramTypedBlock, boolean paramBoolean) {
        int j = 0;
        boolean[] arrayOfBoolean = paramTypedBlock.inputs;
        int k = arrayOfBoolean.length;
        int i = 0;
        while (i < k) {
            if (arrayOfBoolean[i] != 0) {
                merge(this.localsTypes[i], paramTypedBlock.localsTypes[i]);
            }
            i += 1;
        }
        if (paramBoolean) {
            k = this.stackTop;
            i = j;
            while (i < k) {
                merge(this.stackTypes[i], paramTypedBlock.stackTypes[i]);
                i += 1;
            }
        }
    }

    private void recordStackMap(TypedBlock paramTypedBlock) {
        TypeData[] arrayOfTypeData = new TypeData[this.stackTypes.length];
        int i = this.stackTop;
        copyFrom(i, this.stackTypes, arrayOfTypeData);
        recordStackMap0(paramTypedBlock, i, arrayOfTypeData);
    }

    private void recordStackMap(TypedBlock paramTypedBlock, int paramInt) {
        if (paramInt == 0) {
        }
        for (String str = "java.lang.Throwable"; ; str = this.cpool.getClassInfo(paramInt)) {
            TypeData[] arrayOfTypeData = new TypeData[this.stackTypes.length];
            arrayOfTypeData[0] = new TypeData.ClassName(str);
            recordStackMap0(paramTypedBlock, 1, arrayOfTypeData);
            return;
        }
    }

    private void recordStackMap0(TypedBlock paramTypedBlock, int paramInt, TypeData[] paramArrayOfTypeData) {
        int j = this.localsTypes.length;
        TypeData[] arrayOfTypeData = new TypeData[j];
        int k = copyFrom(j, this.localsTypes, arrayOfTypeData);
        boolean[] arrayOfBoolean = paramTypedBlock.inputs;
        int i = 0;
        while (i < j) {
            if (arrayOfBoolean[i] == 0) {
                arrayOfTypeData[i] = TOP;
            }
            i += 1;
        }
        paramTypedBlock.setStackMap(paramInt, paramArrayOfTypeData, k, arrayOfTypeData);
    }

    private static int stackMapDiff(int paramInt1, TypeData[] paramArrayOfTypeData1, int paramInt2, TypeData[] paramArrayOfTypeData2) {
        int j = paramInt2 - paramInt1;
        int i;
        if (j > 0) {
            i = paramInt1;
        }
        while (stackMapEq(paramArrayOfTypeData1, paramArrayOfTypeData2, i)) {
            if (j > 0) {
                return diffSize(paramArrayOfTypeData2, i, paramInt2);
                i = paramInt2;
            } else {
                return -diffSize(paramArrayOfTypeData1, i, paramInt1);
            }
        }
        return -100;
    }

    private static boolean stackMapEq(TypeData[] paramArrayOfTypeData1, TypeData[] paramArrayOfTypeData2, int paramInt) {
        int i = 0;
        while (i < paramInt) {
            if (paramArrayOfTypeData1[i] == TOP) {
                if (paramArrayOfTypeData2[i] == TOP) {
                }
            } else {
                while (!paramArrayOfTypeData1[i].equals(paramArrayOfTypeData2[i])) {
                    return false;
                }
            }
            i += 1;
        }
        return true;
    }

    private void toStackMapBody(StackMapTable.Writer paramWriter, TypedBlock paramTypedBlock1, int paramInt1, int paramInt2, TypedBlock paramTypedBlock2) {
        int i = paramTypedBlock1.stackTop;
        if (i == 0) {
            if (paramInt1 == 0) {
                paramWriter.sameFrame(paramInt2);
                return;
            }
            if ((paramInt1 < 0) && (paramInt1 >= -3)) {
                paramWriter.chopFrame(paramInt2, -paramInt1);
                return;
            }
            if ((paramInt1 > 0) && (paramInt1 <= 3)) {
                arrayOfInt1 = new int[paramInt1];
                paramWriter.appendFrame(paramInt2, fillStackMap(paramTypedBlock1.numLocals - paramTypedBlock2.numLocals, paramTypedBlock2.numLocals, arrayOfInt1, paramTypedBlock1.localsTypes), arrayOfInt1);
            }
        } else {
            if ((i == 1) && (paramInt1 == 0)) {
                paramTypedBlock1 = paramTypedBlock1.stackTypes[0];
                if (paramTypedBlock1 == TOP) {
                    paramWriter.sameLocals(paramInt2, 0, 0);
                    return;
                }
                paramWriter.sameLocals(paramInt2, paramTypedBlock1.getTypeTag(), paramTypedBlock1.getTypeData(this.cpool));
                return;
            }
            if ((i == 2) && (paramInt1 == 0)) {
                paramTypedBlock2 = paramTypedBlock1.stackTypes[0];
                if ((paramTypedBlock2 != TOP) && (paramTypedBlock2.is2WordType())) {
                    paramWriter.sameLocals(paramInt2, paramTypedBlock2.getTypeTag(), paramTypedBlock2.getTypeData(this.cpool));
                    return;
                }
            }
        }
        paramTypedBlock2 = new int[i];
        int[] arrayOfInt1 = fillStackMap(i, 0, paramTypedBlock2, paramTypedBlock1.stackTypes);
        int[] arrayOfInt2 = new int[paramTypedBlock1.numLocals];
        paramWriter.fullFrame(paramInt2, fillStackMap(paramTypedBlock1.numLocals, 0, arrayOfInt2, paramTypedBlock1.localsTypes), arrayOfInt2, arrayOfInt1, paramTypedBlock2);
    }

    private void traceException(byte[] paramArrayOfByte, BasicBlock.Catch paramCatch) {
        TypedBlock localTypedBlock = (TypedBlock) paramCatch.body;
        if (localTypedBlock.alreadySet()) {
            mergeMap(localTypedBlock, false);
            return;
        }
        recordStackMap(localTypedBlock, paramCatch.typeIndex);
        paramCatch = new MapMaker(this, false);
        paramCatch.stackTypes[0] = localTypedBlock.stackTypes[0].getSelf();
        paramCatch.stackTop = 1;
        paramCatch.make(paramArrayOfByte, localTypedBlock);
    }

    private void writeStackFrame(StackMap.Writer paramWriter, ConstPool paramConstPool, int paramInt, TypedBlock paramTypedBlock) {
        paramWriter.write16bit(paramInt);
        writeVerifyTypeInfo(paramWriter, paramConstPool, paramTypedBlock.localsTypes, paramTypedBlock.numLocals);
        writeVerifyTypeInfo(paramWriter, paramConstPool, paramTypedBlock.stackTypes, paramTypedBlock.stackTop);
    }

    private void writeVerifyTypeInfo(StackMap.Writer paramWriter, ConstPool paramConstPool, TypeData[] paramArrayOfTypeData, int paramInt) {
        int i = 0;
        TypeData localTypeData;
        int j;
        for (int k = 0; i < paramInt; k = j) {
            localTypeData = paramArrayOfTypeData[i];
            int m = i;
            j = k;
            if (localTypeData != null) {
                m = i;
                j = k;
                if (localTypeData.is2WordType()) {
                    j = k + 1;
                    m = i + 1;
                }
            }
            i = m + 1;
        }
        paramWriter.write16bit(paramInt - k);
        i = 0;
        if (i < paramInt) {
            localTypeData = paramArrayOfTypeData[i];
            if (localTypeData == TOP) {
                paramWriter.writeVerifyTypeInfo(0, 0);
                j = i;
            }
            for (; ; ) {
                i = j + 1;
                break;
                paramWriter.writeVerifyTypeInfo(localTypeData.getTypeTag(), localTypeData.getTypeData(paramConstPool));
                j = i;
                if (localTypeData.is2WordType()) {
                    j = i + 1;
                }
            }
        }
    }

    void evalExpected(TypedBlock paramTypedBlock) {
        ClassPool localClassPool = this.classPool;
        evalExpected(localClassPool, paramTypedBlock.stackTop, paramTypedBlock.stackTypes);
        paramTypedBlock = paramTypedBlock.localsTypes;
        if (paramTypedBlock != null) {
            evalExpected(localClassPool, paramTypedBlock.length, paramTypedBlock);
        }
    }

    void make(TypedBlock[] paramArrayOfTypedBlock, byte[] paramArrayOfByte) {
        int i = 0;
        TypedBlock localTypedBlock = paramArrayOfTypedBlock[0];
        fixParamTypes(localTypedBlock);
        TypeData[] arrayOfTypeData = localTypedBlock.localsTypes;
        copyFrom(arrayOfTypeData.length, arrayOfTypeData, this.localsTypes);
        make(paramArrayOfByte, localTypedBlock);
        int j = paramArrayOfTypedBlock.length;
        while (i < j) {
            evalExpected(paramArrayOfTypedBlock[i]);
            i += 1;
        }
    }

    public StackMapTable toStackMap(TypedBlock[] paramArrayOfTypedBlock) {
        StackMapTable.Writer localWriter = new StackMapTable.Writer(32);
        int k = paramArrayOfTypedBlock.length;
        Object localObject = paramArrayOfTypedBlock[0];
        int j = ((TypedBlock) localObject).length;
        int i = j;
        if (((TypedBlock) localObject).incoming > 0) {
            localWriter.sameFrame(0);
            i = j - 1;
        }
        j = 1;
        if (j < k) {
            TypedBlock localTypedBlock = paramArrayOfTypedBlock[j];
            if (isTarget(localTypedBlock, paramArrayOfTypedBlock[(j - 1)])) {
                localTypedBlock.resetNumLocals();
                toStackMapBody(localWriter, localTypedBlock, stackMapDiff(((TypedBlock) localObject).numLocals, ((TypedBlock) localObject).localsTypes, localTypedBlock.numLocals, localTypedBlock.localsTypes), i, (TypedBlock) localObject);
                i = localTypedBlock.length - 1;
                localObject = localTypedBlock;
            }
            for (; ; ) {
                j += 1;
                break;
                i = localTypedBlock.length + i;
            }
        }
        return localWriter.toStackMapTable(this.cpool);
    }

    public StackMap toStackMap2(ConstPool paramConstPool, TypedBlock[] paramArrayOfTypedBlock) {
        int j = 1;
        int m = 0;
        StackMap.Writer localWriter = new StackMap.Writer();
        int n = paramArrayOfTypedBlock.length;
        boolean[] arrayOfBoolean = new boolean[n];
        boolean bool;
        if (paramArrayOfTypedBlock[0].incoming > 0) {
            bool = true;
            arrayOfBoolean[0] = bool;
            if (arrayOfBoolean[0] == 0) {
                break label122;
            }
            i = 1;
        }
        for (; ; ) {
            if (j >= n) {
                break label127;
            }
            TypedBlock localTypedBlock = paramArrayOfTypedBlock[j];
            bool = isTarget(localTypedBlock, paramArrayOfTypedBlock[(j - 1)]);
            arrayOfBoolean[j] = bool;
            int k = i;
            if (bool) {
                localTypedBlock.resetNumLocals();
                k = i + 1;
            }
            j += 1;
            i = k;
            continue;
            bool = false;
            break;
            label122:
            i = 0;
        }
        label127:
        if (i == 0) {
            return null;
        }
        localWriter.write16bit(i);
        int i = m;
        while (i < n) {
            if (arrayOfBoolean[i] != 0) {
                writeStackFrame(localWriter, paramConstPool, paramArrayOfTypedBlock[i].position, paramArrayOfTypedBlock[i]);
            }
            i += 1;
        }
        return localWriter.toStackMap(paramConstPool);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/stackmap/MapMaker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */