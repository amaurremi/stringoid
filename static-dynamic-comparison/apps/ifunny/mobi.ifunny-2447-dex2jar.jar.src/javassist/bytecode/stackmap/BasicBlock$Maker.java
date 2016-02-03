package javassist.bytecode.stackmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.ExceptionTable;
import javassist.bytecode.MethodInfo;

public class BasicBlock$Maker {
    private void addCatchers(BasicBlock[] paramArrayOfBasicBlock, ExceptionTable paramExceptionTable) {
        if (paramExceptionTable == null) {
            return;
        }
        int j;
        for (int i = paramExceptionTable.size(); ; i = j) {
            j = i - 1;
            if (j < 0) {
                break;
            }
            BasicBlock localBasicBlock1 = BasicBlock.find(paramArrayOfBasicBlock, paramExceptionTable.handlerPc(j));
            int k = paramExceptionTable.startPc(j);
            int m = paramExceptionTable.endPc(j);
            int n = paramExceptionTable.catchType(j);
            localBasicBlock1.incoming -= 1;
            i = 0;
            while (i < paramArrayOfBasicBlock.length) {
                BasicBlock localBasicBlock2 = paramArrayOfBasicBlock[i];
                int i1 = localBasicBlock2.position;
                if ((k <= i1) && (i1 < m)) {
                    localBasicBlock2.toCatch = new BasicBlock.Catch(localBasicBlock1, n, localBasicBlock2.toCatch);
                    localBasicBlock1.incoming += 1;
                }
                i += 1;
            }
        }
    }

    private static BasicBlock getBBlock(BasicBlock.Mark paramMark) {
        BasicBlock localBasicBlock = paramMark.block;
        if ((localBasicBlock != null) && (paramMark.size > 0)) {
            localBasicBlock.exit = paramMark.jump;
            localBasicBlock.length = paramMark.size;
            localBasicBlock.stop = paramMark.alwaysJmp;
        }
        return localBasicBlock;
    }

    private BasicBlock[] makeArray(BasicBlock paramBasicBlock) {
        BasicBlock[] arrayOfBasicBlock = makeArray(1);
        arrayOfBasicBlock[0] = paramBasicBlock;
        return arrayOfBasicBlock;
    }

    private BasicBlock[] makeArray(BasicBlock paramBasicBlock1, BasicBlock paramBasicBlock2) {
        BasicBlock[] arrayOfBasicBlock = makeArray(2);
        arrayOfBasicBlock[0] = paramBasicBlock1;
        arrayOfBasicBlock[1] = paramBasicBlock2;
        return arrayOfBasicBlock;
    }

    private BasicBlock[] makeBlocks(HashMap paramHashMap) {
        BasicBlock.Mark[] arrayOfMark = (BasicBlock.Mark[]) paramHashMap.values().toArray(new BasicBlock.Mark[paramHashMap.size()]);
        Arrays.sort(arrayOfMark);
        ArrayList localArrayList = new ArrayList();
        int i;
        if ((arrayOfMark.length > 0) && (arrayOfMark[0].position == 0) && (arrayOfMark[0].block != null)) {
            i = 1;
            paramHashMap = getBBlock(arrayOfMark[0]);
        }
        BasicBlock.Mark localMark;
        Object localObject;
        int j;
        for (; ; ) {
            localArrayList.add(paramHashMap);
            for (; ; ) {
                if (i >= arrayOfMark.length) {
                    break label315;
                }
                localMark = arrayOfMark[i];
                localObject = getBBlock(localMark);
                if (localObject != null) {
                    break;
                }
                localObject = paramHashMap;
                if (paramHashMap.length > 0) {
                    j = paramHashMap.position;
                    localObject = makeBlock(paramHashMap.length + j);
                    localArrayList.add(localObject);
                }
                ((BasicBlock) localObject).length = (localMark.position + localMark.size - ((BasicBlock) localObject).position);
                ((BasicBlock) localObject).exit = localMark.jump;
                ((BasicBlock) localObject).stop = localMark.alwaysJmp;
                paramHashMap = (HashMap) localObject;
                i += 1;
            }
            paramHashMap = makeBlock(0);
            i = 0;
        }
        if (paramHashMap.length == 0) {
            paramHashMap.length = (localMark.position - paramHashMap.position);
            ((BasicBlock) localObject).incoming += 1;
            paramHashMap.exit = makeArray((BasicBlock) localObject);
        }
        for (; ; ) {
            localArrayList.add(localObject);
            paramHashMap = (HashMap) localObject;
            break;
            j = paramHashMap.position;
            if (paramHashMap.length + j < localMark.position) {
                paramHashMap = makeBlock(paramHashMap.length + j);
                paramHashMap.length = (localMark.position - j);
                paramHashMap.exit = makeArray((BasicBlock) localObject);
            }
        }
        label315:
        return (BasicBlock[]) localArrayList.toArray(makeArray(localArrayList.size()));
    }

    private void makeGoto(HashMap paramHashMap, int paramInt1, int paramInt2, int paramInt3) {
        makeMark(paramHashMap, paramInt1, makeArray(makeMark(paramHashMap, paramInt2).block), paramInt3, true);
    }

    private BasicBlock.Mark makeMark(HashMap paramHashMap, int paramInt) {
        return makeMark0(paramHashMap, paramInt, true, true);
    }

    private BasicBlock.Mark makeMark(HashMap paramHashMap, int paramInt1, BasicBlock[] paramArrayOfBasicBlock, int paramInt2, boolean paramBoolean) {
        paramHashMap = makeMark0(paramHashMap, paramInt1, false, false);
        paramHashMap.setJump(paramArrayOfBasicBlock, paramInt2, paramBoolean);
        return paramHashMap;
    }

    private BasicBlock.Mark makeMark0(HashMap paramHashMap, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
        Integer localInteger = new Integer(paramInt);
        BasicBlock.Mark localMark2 = (BasicBlock.Mark) paramHashMap.get(localInteger);
        BasicBlock.Mark localMark1 = localMark2;
        if (localMark2 == null) {
            localMark1 = new BasicBlock.Mark(paramInt);
            paramHashMap.put(localInteger, localMark1);
        }
        if (paramBoolean1) {
            if (localMark1.block == null) {
                localMark1.block = makeBlock(paramInt);
            }
            if (paramBoolean2) {
                paramHashMap = localMark1.block;
                paramHashMap.incoming += 1;
            }
        }
        return localMark1;
    }

    private HashMap makeMarks(CodeIterator paramCodeIterator, int paramInt1, int paramInt2, ExceptionTable paramExceptionTable) {
        paramCodeIterator.begin();
        paramCodeIterator.move(paramInt1);
        HashMap localHashMap = new HashMap();
        for (; ; ) {
            int j;
            if (paramCodeIterator.hasNext()) {
                j = paramCodeIterator.next();
                if (j < paramInt2) {
                }
            } else {
                if (paramExceptionTable == null) {
                    break;
                }
                paramInt1 = paramExceptionTable.size();
                for (; ; ) {
                    paramInt1 -= 1;
                    if (paramInt1 < 0) {
                        break;
                    }
                    makeMark0(localHashMap, paramExceptionTable.startPc(paramInt1), true, false);
                    makeMark(localHashMap, paramExceptionTable.handlerPc(paramInt1));
                }
            }
            paramInt1 = paramCodeIterator.byteAt(j);
            Object localObject;
            if (((153 <= paramInt1) && (paramInt1 <= 166)) || (paramInt1 == 198) || (paramInt1 == 199)) {
                localObject = makeMark(localHashMap, paramCodeIterator.s16bitAt(j + 1) + j);
                BasicBlock.Mark localMark = makeMark(localHashMap, j + 3);
                makeMark(localHashMap, j, makeArray(((BasicBlock.Mark) localObject).block, localMark.block), 3, false);
            } else {
                if ((167 <= paramInt1) && (paramInt1 <= 171)) {
                }
                int i;
                int k;
                switch (paramInt1) {
                    default:
                        break;
                    case 167:
                        makeGoto(localHashMap, j, paramCodeIterator.s16bitAt(j + 1) + j, 3);
                        break;
                    case 168:
                        makeJsr(localHashMap, j, paramCodeIterator.s16bitAt(j + 1) + j, 3);
                        break;
                    case 169:
                        makeMark(localHashMap, j, null, 2, true);
                        break;
                    case 170:
                        paramInt1 = (j & 0xFFFFFFFC) + 4;
                        i = paramCodeIterator.s32bitAt(paramInt1 + 4);
                        k = paramCodeIterator.s32bitAt(paramInt1 + 8) - i + 1;
                        localObject = makeArray(k + 1);
                        localObject[0] = makeMark(localHashMap, paramCodeIterator.s32bitAt(paramInt1) + j).block;
                        i = paramInt1 + 12;
                        k = i + k * 4;
                        paramInt1 = 1;
                        while (i < k) {
                            localObject[paramInt1] = makeMark(localHashMap, paramCodeIterator.s32bitAt(i) + j).block;
                            i += 4;
                            paramInt1 += 1;
                        }
                        makeMark(localHashMap, j, (BasicBlock[]) localObject, k - j, true);
                        break;
                    case 171:
                        i = (j & 0xFFFFFFFC) + 4;
                        paramInt1 = paramCodeIterator.s32bitAt(i + 4);
                        localObject = makeArray(paramInt1 + 1);
                        localObject[0] = makeMark(localHashMap, paramCodeIterator.s32bitAt(i) + j).block;
                        i = i + 8 + 4;
                        k = paramInt1 * 8 + i - 4;
                        paramInt1 = 1;
                        while (i < k) {
                            localObject[paramInt1] = makeMark(localHashMap, paramCodeIterator.s32bitAt(i) + j).block;
                            i += 8;
                            paramInt1 += 1;
                        }
                        makeMark(localHashMap, j, (BasicBlock[]) localObject, k - j, true);
                        continue;
                        if (((172 <= paramInt1) && (paramInt1 <= 177)) || (paramInt1 == 191)) {
                            makeMark(localHashMap, j, null, 1, true);
                        } else if (paramInt1 == 200) {
                            makeGoto(localHashMap, j, paramCodeIterator.s32bitAt(j + 1) + j, 5);
                        } else if (paramInt1 == 201) {
                            makeJsr(localHashMap, j, paramCodeIterator.s32bitAt(j + 1) + j, 5);
                        } else if ((paramInt1 == 196) && (paramCodeIterator.byteAt(j + 1) == 169)) {
                            makeMark(localHashMap, j, null, 1, true);
                        }
                        break;
                }
            }
        }
        return localHashMap;
    }

    public BasicBlock[] make(CodeIterator paramCodeIterator, int paramInt1, int paramInt2, ExceptionTable paramExceptionTable) {
        paramCodeIterator = makeBlocks(makeMarks(paramCodeIterator, paramInt1, paramInt2, paramExceptionTable));
        addCatchers(paramCodeIterator, paramExceptionTable);
        return paramCodeIterator;
    }

    public BasicBlock[] make(MethodInfo paramMethodInfo) {
        paramMethodInfo = paramMethodInfo.getCodeAttribute();
        if (paramMethodInfo == null) {
            return null;
        }
        CodeIterator localCodeIterator = paramMethodInfo.iterator();
        return make(localCodeIterator, 0, localCodeIterator.getCodeLength(), paramMethodInfo.getExceptionTable());
    }

    protected BasicBlock[] makeArray(int paramInt) {
        return new BasicBlock[paramInt];
    }

    protected BasicBlock makeBlock(int paramInt) {
        return new BasicBlock(paramInt);
    }

    protected void makeJsr(HashMap paramHashMap, int paramInt1, int paramInt2, int paramInt3) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/stackmap/BasicBlock$Maker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */