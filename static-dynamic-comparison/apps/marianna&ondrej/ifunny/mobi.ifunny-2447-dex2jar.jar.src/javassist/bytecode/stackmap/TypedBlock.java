package javassist.bytecode.stackmap;

import javassist.bytecode.BadBytecode;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.ConstPool;
import javassist.bytecode.MethodInfo;

public class TypedBlock
        extends BasicBlock {
    public boolean[] inputs = null;
    public TypeData[] localsTypes = null;
    public byte[] localsUsage;
    public int numLocals;
    public int stackTop;
    public TypeData[] stackTypes;
    public int status;
    public boolean updating = false;

    protected TypedBlock(int paramInt) {
        super(paramInt);
    }

    private static int descToTag(String paramString, int paramInt1, int paramInt2, TypeData[] paramArrayOfTypeData) {
        char c = paramString.charAt(paramInt1);
        if (c == ')') {
            return 0;
        }
        for (; ; ) {
            int i;
            int j;
            if (c == '[') {
                i += 1;
                j += 1;
                c = paramString.charAt(j);
            } else {
                if (c == 'L') {
                    j = paramString.indexOf(';', j + 1);
                    if (i > 0) {
                        i = j + 1;
                        paramArrayOfTypeData[paramInt2] = new TypeData.ClassName(paramString.substring(paramInt1, i));
                        return i;
                    }
                    i = j + 1;
                    paramArrayOfTypeData[paramInt2] = new TypeData.ClassName(paramString.substring(paramInt1 + 1, i - 1).replace('/', '.'));
                    return i;
                }
                if (i > 0) {
                    i = j + 1;
                    paramArrayOfTypeData[paramInt2] = new TypeData.ClassName(paramString.substring(paramInt1, i));
                    return i;
                }
                TypeData localTypeData = toPrimitiveTag(c);
                if (localTypeData == null) {
                    throw new BadBytecode("bad method descriptor: " + paramString);
                }
                paramArrayOfTypeData[paramInt2] = localTypeData;
                return j + 1;
                j = paramInt1;
                i = 0;
            }
        }
    }

    public static String getRetType(String paramString) {
        int i = paramString.indexOf(')');
        if (i < 0) {
            return "java.lang.Object";
        }
        int j = paramString.charAt(i + 1);
        if (j == 91) {
            return paramString.substring(i + 1);
        }
        if (j == 76) {
            return paramString.substring(i + 2, paramString.length() - 1).replace('/', '.');
        }
        return "java.lang.Object";
    }

    public static TypedBlock[] makeBlocks(MethodInfo paramMethodInfo, CodeAttribute paramCodeAttribute, boolean paramBoolean) {
        TypedBlock[] arrayOfTypedBlock = (TypedBlock[]) new TypedBlock.Maker().make(paramMethodInfo);
        if ((paramBoolean) && (arrayOfTypedBlock.length < 2) && ((arrayOfTypedBlock.length == 0) || (arrayOfTypedBlock[0].incoming == 0))) {
            return null;
        }
        ConstPool localConstPool = paramMethodInfo.getConstPool();
        if ((paramMethodInfo.getAccessFlags() & 0x8) != 0) {
        }
        for (paramBoolean = true; ; paramBoolean = false) {
            arrayOfTypedBlock[0].initFirstBlock(paramCodeAttribute.getMaxStack(), paramCodeAttribute.getMaxLocals(), localConstPool.getClassName(), paramMethodInfo.getDescriptor(), paramBoolean, paramMethodInfo.isConstructor());
            new Liveness().compute(paramCodeAttribute.iterator(), arrayOfTypedBlock, paramCodeAttribute.getMaxLocals(), arrayOfTypedBlock[0].localsTypes);
            return arrayOfTypedBlock;
        }
    }

    private void printTypes(StringBuffer paramStringBuffer, int paramInt, TypeData[] paramArrayOfTypeData) {
        if (paramArrayOfTypeData == null) {
            return;
        }
        int i = 0;
        label8:
        if (i < paramInt) {
            if (i > 0) {
                paramStringBuffer.append(", ");
            }
            localObject = paramArrayOfTypeData[i];
            if (localObject != null) {
                break label57;
            }
        }
        label57:
        for (Object localObject = "<>"; ; localObject = localObject.toString()) {
            paramStringBuffer.append((String) localObject);
            i += 1;
            break label8;
            break;
        }
    }

    private static TypeData toPrimitiveTag(char paramChar) {
        switch (paramChar) {
            default:
                return null;
            case 'B':
            case 'C':
            case 'I':
            case 'S':
            case 'Z':
                return TypeTag.INTEGER;
            case 'J':
                return TypeTag.LONG;
            case 'F':
                return TypeTag.FLOAT;
        }
        return TypeTag.DOUBLE;
    }

    public boolean alreadySet() {
        return this.localsTypes != null;
    }

    void initFirstBlock(int paramInt1, int paramInt2, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2) {
        int i = 0;
        if (paramString2.charAt(0) != '(') {
            throw new BadBytecode("no method descriptor: " + paramString2);
        }
        this.stackTop = 0;
        this.stackTypes = new TypeData[paramInt1];
        TypeData[] arrayOfTypeData = new TypeData[paramInt2];
        if (paramBoolean2) {
            arrayOfTypeData[0] = new TypeData.UninitThis(paramString1);
        }
        int j;
        for (; ; ) {
            paramInt1 = i;
            if (paramBoolean1) {
                paramInt1 = -1;
            }
            paramInt2 = 1;
            for (; ; ) {
                j = paramInt1 + 1;
                try {
                    i = descToTag(paramString2, paramInt2, j, arrayOfTypeData);
                    if (i <= 0) {
                        break label196;
                    }
                    paramInt2 = i;
                    paramInt1 = j;
                    if (arrayOfTypeData[j].is2WordType()) {
                        paramInt1 = j + 1;
                        arrayOfTypeData[paramInt1] = TypeTag.TOP;
                        paramInt2 = i;
                    }
                } catch (StringIndexOutOfBoundsException paramString1) {
                    throw new BadBytecode("bad method descriptor: " + paramString2);
                }
            }
            if (!paramBoolean1) {
                arrayOfTypeData[0] = new TypeData.ClassName(paramString1);
            }
        }
        label196:
        this.numLocals = j;
        this.localsTypes = arrayOfTypeData;
    }

    public void resetNumLocals() {
        int i;
        if (this.localsTypes != null) {
            i = this.localsTypes.length;
        }
        for (; ; ) {
            if ((i > 0) && (this.localsTypes[(i - 1)] == TypeTag.TOP)) {
                if (i > 1) {
                    TypeData localTypeData = this.localsTypes[(i - 2)];
                    if ((localTypeData != TypeTag.LONG) && (localTypeData != TypeTag.DOUBLE)) {
                    }
                }
            } else {
                this.numLocals = i;
                return;
            }
            i -= 1;
        }
    }

    public void setStackMap(int paramInt1, TypeData[] paramArrayOfTypeData1, int paramInt2, TypeData[] paramArrayOfTypeData2) {
        this.stackTop = paramInt1;
        this.stackTypes = paramArrayOfTypeData1;
        this.numLocals = paramInt2;
        this.localsTypes = paramArrayOfTypeData2;
    }

    protected void toString2(StringBuffer paramStringBuffer) {
        super.toString2(paramStringBuffer);
        paramStringBuffer.append(",\n stack={");
        printTypes(paramStringBuffer, this.stackTop, this.stackTypes);
        paramStringBuffer.append("}, locals={");
        printTypes(paramStringBuffer, this.numLocals, this.localsTypes);
        paramStringBuffer.append("}, inputs={");
        if (this.inputs != null) {
            int i = 0;
            if (i < this.inputs.length) {
                if (this.inputs[i] != 0) {
                }
                for (String str = "1, "; ; str = "0, ") {
                    paramStringBuffer.append(str);
                    i += 1;
                    break;
                }
            }
        }
        paramStringBuffer.append('}');
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/stackmap/TypedBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */