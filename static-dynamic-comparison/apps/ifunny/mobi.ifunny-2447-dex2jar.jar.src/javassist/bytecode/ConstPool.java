package javassist.bytecode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javassist.CtClass;

public final class ConstPool {
    public static final int CONST_Class = 7;
    public static final int CONST_Double = 6;
    public static final int CONST_Fieldref = 9;
    public static final int CONST_Float = 4;
    public static final int CONST_Integer = 3;
    public static final int CONST_InterfaceMethodref = 11;
    public static final int CONST_Long = 5;
    public static final int CONST_Methodref = 10;
    public static final int CONST_NameAndType = 12;
    public static final int CONST_String = 8;
    public static final int CONST_Utf8 = 1;
    public static final CtClass THIS = null;
    LongVector items;
    HashMap itemsCache;
    int numOfItems;
    int thisClassInfo;

    public ConstPool(DataInputStream paramDataInputStream) {
        this.itemsCache = null;
        this.thisClassInfo = 0;
        read(paramDataInputStream);
    }

    public ConstPool(String paramString) {
        this.items = new LongVector();
        this.itemsCache = null;
        this.numOfItems = 0;
        addItem0(null);
        this.thisClassInfo = addClassInfo(paramString);
    }

    private int addItem(ConstInfo paramConstInfo) {
        if (this.itemsCache == null) {
            this.itemsCache = makeItemsCache(this.items);
        }
        ConstInfo localConstInfo = (ConstInfo) this.itemsCache.get(paramConstInfo);
        if (localConstInfo != null) {
            return localConstInfo.index;
        }
        this.items.addElement(paramConstInfo);
        this.itemsCache.put(paramConstInfo, paramConstInfo);
        int i = this.numOfItems;
        this.numOfItems = (i + 1);
        return i;
    }

    private int addItem0(ConstInfo paramConstInfo) {
        this.items.addElement(paramConstInfo);
        int i = this.numOfItems;
        this.numOfItems = (i + 1);
        return i;
    }

    private static HashMap makeItemsCache(LongVector paramLongVector) {
        HashMap localHashMap = new HashMap();
        int i = 1;
        for (; ; ) {
            ConstInfo localConstInfo = paramLongVector.elementAt(i);
            if (localConstInfo == null) {
                return localHashMap;
            }
            localHashMap.put(localConstInfo, localConstInfo);
            i += 1;
        }
    }

    private void read(DataInputStream paramDataInputStream) {
        int i = paramDataInputStream.readUnsignedShort();
        this.items = new LongVector(i);
        this.numOfItems = 0;
        addItem0(null);
        for (; ; ) {
            int j = i - 1;
            if (j <= 0) {
                break;
            }
            int k = readOne(paramDataInputStream);
            if (k != 5) {
                i = j;
                if (k != 6) {
                }
            } else {
                addConstInfoPadding();
                i = j - 1;
            }
        }
    }

    private int readOne(DataInputStream paramDataInputStream) {
        int i = paramDataInputStream.readUnsignedByte();
        switch (i) {
            case 2:
            default:
                throw new IOException("invalid constant type: " + i + " at " + this.numOfItems);
            case 1:
                paramDataInputStream = new Utf8Info(paramDataInputStream, this.numOfItems);
        }
        for (; ; ) {
            addItem0(paramDataInputStream);
            return i;
            paramDataInputStream = new IntegerInfo(paramDataInputStream, this.numOfItems);
            continue;
            paramDataInputStream = new FloatInfo(paramDataInputStream, this.numOfItems);
            continue;
            paramDataInputStream = new LongInfo(paramDataInputStream, this.numOfItems);
            continue;
            paramDataInputStream = new DoubleInfo(paramDataInputStream, this.numOfItems);
            continue;
            paramDataInputStream = new ClassInfo(paramDataInputStream, this.numOfItems);
            continue;
            paramDataInputStream = new StringInfo(paramDataInputStream, this.numOfItems);
            continue;
            paramDataInputStream = new FieldrefInfo(paramDataInputStream, this.numOfItems);
            continue;
            paramDataInputStream = new MethodrefInfo(paramDataInputStream, this.numOfItems);
            continue;
            paramDataInputStream = new InterfaceMethodrefInfo(paramDataInputStream, this.numOfItems);
            continue;
            paramDataInputStream = new NameAndTypeInfo(paramDataInputStream, this.numOfItems);
        }
    }

    public int addClassInfo(String paramString) {
        return addItem(new ClassInfo(addUtf8Info(Descriptor.toJvmName(paramString)), this.numOfItems));
    }

    public int addClassInfo(CtClass paramCtClass) {
        if (paramCtClass == THIS) {
            return this.thisClassInfo;
        }
        if (!paramCtClass.isArray()) {
            return addClassInfo(paramCtClass.getName());
        }
        return addClassInfo(Descriptor.toJvmName(paramCtClass));
    }

    int addConstInfoPadding() {
        return addItem0(new ConstInfoPadding(this.numOfItems));
    }

    public int addDoubleInfo(double paramDouble) {
        int i = addItem(new DoubleInfo(paramDouble, this.numOfItems));
        if (i == this.numOfItems - 1) {
            addConstInfoPadding();
        }
        return i;
    }

    public int addFieldrefInfo(int paramInt1, int paramInt2) {
        return addItem(new FieldrefInfo(paramInt1, paramInt2, this.numOfItems));
    }

    public int addFieldrefInfo(int paramInt, String paramString1, String paramString2) {
        return addFieldrefInfo(paramInt, addNameAndTypeInfo(paramString1, paramString2));
    }

    public int addFloatInfo(float paramFloat) {
        return addItem(new FloatInfo(paramFloat, this.numOfItems));
    }

    public int addIntegerInfo(int paramInt) {
        return addItem(new IntegerInfo(paramInt, this.numOfItems));
    }

    public int addInterfaceMethodrefInfo(int paramInt1, int paramInt2) {
        return addItem(new InterfaceMethodrefInfo(paramInt1, paramInt2, this.numOfItems));
    }

    public int addInterfaceMethodrefInfo(int paramInt, String paramString1, String paramString2) {
        return addInterfaceMethodrefInfo(paramInt, addNameAndTypeInfo(paramString1, paramString2));
    }

    public int addLongInfo(long paramLong) {
        int i = addItem(new LongInfo(paramLong, this.numOfItems));
        if (i == this.numOfItems - 1) {
            addConstInfoPadding();
        }
        return i;
    }

    public int addMethodrefInfo(int paramInt1, int paramInt2) {
        return addItem(new MethodrefInfo(paramInt1, paramInt2, this.numOfItems));
    }

    public int addMethodrefInfo(int paramInt, String paramString1, String paramString2) {
        return addMethodrefInfo(paramInt, addNameAndTypeInfo(paramString1, paramString2));
    }

    public int addNameAndTypeInfo(int paramInt1, int paramInt2) {
        return addItem(new NameAndTypeInfo(paramInt1, paramInt2, this.numOfItems));
    }

    public int addNameAndTypeInfo(String paramString1, String paramString2) {
        return addNameAndTypeInfo(addUtf8Info(paramString1), addUtf8Info(paramString2));
    }

    public int addStringInfo(String paramString) {
        return addItem(new StringInfo(addUtf8Info(paramString), this.numOfItems));
    }

    public int addUtf8Info(String paramString) {
        return addItem(new Utf8Info(paramString, this.numOfItems));
    }

    public int copy(int paramInt, ConstPool paramConstPool, Map paramMap) {
        if (paramInt == 0) {
            return 0;
        }
        return getItem(paramInt).copy(this, paramConstPool, paramMap);
    }

    public String eqMember(String paramString1, String paramString2, int paramInt) {
        MemberrefInfo localMemberrefInfo = (MemberrefInfo) getItem(paramInt);
        NameAndTypeInfo localNameAndTypeInfo = (NameAndTypeInfo) getItem(localMemberrefInfo.nameAndTypeIndex);
        if ((getUtf8Info(localNameAndTypeInfo.memberName).equals(paramString1)) && (getUtf8Info(localNameAndTypeInfo.typeDescriptor).equals(paramString2))) {
            return getClassInfo(localMemberrefInfo.classIndex);
        }
        return null;
    }

    public String getClassInfo(int paramInt) {
        ClassInfo localClassInfo = (ClassInfo) getItem(paramInt);
        if (localClassInfo == null) {
            return null;
        }
        return Descriptor.toJavaName(getUtf8Info(localClassInfo.name));
    }

    public String getClassInfoByDescriptor(int paramInt) {
        Object localObject = (ClassInfo) getItem(paramInt);
        if (localObject == null) {
            localObject = null;
        }
        String str;
        do {
            return (String) localObject;
            str = getUtf8Info(((ClassInfo) localObject).name);
            localObject = str;
        } while (str.charAt(0) == '[');
        return Descriptor.of(str);
    }

    public String getClassName() {
        return getClassInfo(this.thisClassInfo);
    }

    public Set getClassNames() {
        HashSet localHashSet = new HashSet();
        LongVector localLongVector = this.items;
        int j = this.numOfItems;
        int i = 1;
        while (i < j) {
            String str = localLongVector.elementAt(i).getClassName(this);
            if (str != null) {
                localHashSet.add(str);
            }
            i += 1;
        }
        return localHashSet;
    }

    public double getDoubleInfo(int paramInt) {
        return ((DoubleInfo) getItem(paramInt)).value;
    }

    public int getFieldrefClass(int paramInt) {
        return ((FieldrefInfo) getItem(paramInt)).classIndex;
    }

    public String getFieldrefClassName(int paramInt) {
        FieldrefInfo localFieldrefInfo = (FieldrefInfo) getItem(paramInt);
        if (localFieldrefInfo == null) {
            return null;
        }
        return getClassInfo(localFieldrefInfo.classIndex);
    }

    public String getFieldrefName(int paramInt) {
        Object localObject = (FieldrefInfo) getItem(paramInt);
        if (localObject == null) {
            return null;
        }
        localObject = (NameAndTypeInfo) getItem(((FieldrefInfo) localObject).nameAndTypeIndex);
        if (localObject == null) {
            return null;
        }
        return getUtf8Info(((NameAndTypeInfo) localObject).memberName);
    }

    public int getFieldrefNameAndType(int paramInt) {
        return ((FieldrefInfo) getItem(paramInt)).nameAndTypeIndex;
    }

    public String getFieldrefType(int paramInt) {
        Object localObject = (FieldrefInfo) getItem(paramInt);
        if (localObject == null) {
            return null;
        }
        localObject = (NameAndTypeInfo) getItem(((FieldrefInfo) localObject).nameAndTypeIndex);
        if (localObject == null) {
            return null;
        }
        return getUtf8Info(((NameAndTypeInfo) localObject).typeDescriptor);
    }

    public float getFloatInfo(int paramInt) {
        return ((FloatInfo) getItem(paramInt)).value;
    }

    public int getIntegerInfo(int paramInt) {
        return ((IntegerInfo) getItem(paramInt)).value;
    }

    public int getInterfaceMethodrefClass(int paramInt) {
        return ((InterfaceMethodrefInfo) getItem(paramInt)).classIndex;
    }

    public String getInterfaceMethodrefClassName(int paramInt) {
        return getClassInfo(((InterfaceMethodrefInfo) getItem(paramInt)).classIndex);
    }

    public String getInterfaceMethodrefName(int paramInt) {
        Object localObject = (InterfaceMethodrefInfo) getItem(paramInt);
        if (localObject == null) {
            return null;
        }
        localObject = (NameAndTypeInfo) getItem(((InterfaceMethodrefInfo) localObject).nameAndTypeIndex);
        if (localObject == null) {
            return null;
        }
        return getUtf8Info(((NameAndTypeInfo) localObject).memberName);
    }

    public int getInterfaceMethodrefNameAndType(int paramInt) {
        return ((InterfaceMethodrefInfo) getItem(paramInt)).nameAndTypeIndex;
    }

    public String getInterfaceMethodrefType(int paramInt) {
        Object localObject = (InterfaceMethodrefInfo) getItem(paramInt);
        if (localObject == null) {
            return null;
        }
        localObject = (NameAndTypeInfo) getItem(((InterfaceMethodrefInfo) localObject).nameAndTypeIndex);
        if (localObject == null) {
            return null;
        }
        return getUtf8Info(((NameAndTypeInfo) localObject).typeDescriptor);
    }

    ConstInfo getItem(int paramInt) {
        return this.items.elementAt(paramInt);
    }

    public Object getLdcValue(int paramInt) {
        ConstInfo localConstInfo = getItem(paramInt);
        if ((localConstInfo instanceof StringInfo)) {
            return getStringInfo(paramInt);
        }
        if ((localConstInfo instanceof FloatInfo)) {
            return new Float(getFloatInfo(paramInt));
        }
        if ((localConstInfo instanceof IntegerInfo)) {
            return new Integer(getIntegerInfo(paramInt));
        }
        if ((localConstInfo instanceof LongInfo)) {
            return new Long(getLongInfo(paramInt));
        }
        if ((localConstInfo instanceof DoubleInfo)) {
            return new Double(getDoubleInfo(paramInt));
        }
        return null;
    }

    public long getLongInfo(int paramInt) {
        return ((LongInfo) getItem(paramInt)).value;
    }

    public int getMemberClass(int paramInt) {
        return ((MemberrefInfo) getItem(paramInt)).classIndex;
    }

    public int getMemberNameAndType(int paramInt) {
        return ((MemberrefInfo) getItem(paramInt)).nameAndTypeIndex;
    }

    public int getMethodrefClass(int paramInt) {
        return ((MethodrefInfo) getItem(paramInt)).classIndex;
    }

    public String getMethodrefClassName(int paramInt) {
        MethodrefInfo localMethodrefInfo = (MethodrefInfo) getItem(paramInt);
        if (localMethodrefInfo == null) {
            return null;
        }
        return getClassInfo(localMethodrefInfo.classIndex);
    }

    public String getMethodrefName(int paramInt) {
        Object localObject = (MethodrefInfo) getItem(paramInt);
        if (localObject == null) {
            return null;
        }
        localObject = (NameAndTypeInfo) getItem(((MethodrefInfo) localObject).nameAndTypeIndex);
        if (localObject == null) {
            return null;
        }
        return getUtf8Info(((NameAndTypeInfo) localObject).memberName);
    }

    public int getMethodrefNameAndType(int paramInt) {
        return ((MethodrefInfo) getItem(paramInt)).nameAndTypeIndex;
    }

    public String getMethodrefType(int paramInt) {
        Object localObject = (MethodrefInfo) getItem(paramInt);
        if (localObject == null) {
            return null;
        }
        localObject = (NameAndTypeInfo) getItem(((MethodrefInfo) localObject).nameAndTypeIndex);
        if (localObject == null) {
            return null;
        }
        return getUtf8Info(((NameAndTypeInfo) localObject).typeDescriptor);
    }

    public int getNameAndTypeDescriptor(int paramInt) {
        return ((NameAndTypeInfo) getItem(paramInt)).typeDescriptor;
    }

    public int getNameAndTypeName(int paramInt) {
        return ((NameAndTypeInfo) getItem(paramInt)).memberName;
    }

    public int getSize() {
        return this.numOfItems;
    }

    public String getStringInfo(int paramInt) {
        return getUtf8Info(((StringInfo) getItem(paramInt)).string);
    }

    public int getTag(int paramInt) {
        return getItem(paramInt).getTag();
    }

    public int getThisClassInfo() {
        return this.thisClassInfo;
    }

    public String getUtf8Info(int paramInt) {
        return ((Utf8Info) getItem(paramInt)).string;
    }

    public int isConstructor(String paramString, int paramInt) {
        return isMember(paramString, "<init>", paramInt);
    }

    public int isMember(String paramString1, String paramString2, int paramInt) {
        MemberrefInfo localMemberrefInfo = (MemberrefInfo) getItem(paramInt);
        if (getClassInfo(localMemberrefInfo.classIndex).equals(paramString1)) {
            paramString1 = (NameAndTypeInfo) getItem(localMemberrefInfo.nameAndTypeIndex);
            if (getUtf8Info(paramString1.memberName).equals(paramString2)) {
                return paramString1.typeDescriptor;
            }
        }
        return 0;
    }

    public void print() {
        print(new PrintWriter(System.out, true));
    }

    public void print(PrintWriter paramPrintWriter) {
        int j = this.numOfItems;
        int i = 1;
        while (i < j) {
            paramPrintWriter.print(i);
            paramPrintWriter.print(" ");
            this.items.elementAt(i).print(paramPrintWriter);
            i += 1;
        }
    }

    void prune() {
        this.itemsCache = null;
    }

    public void renameClass(String paramString1, String paramString2) {
        LongVector localLongVector = this.items;
        int j = this.numOfItems;
        int i = 1;
        while (i < j) {
            localLongVector.elementAt(i).renameClass(this, paramString1, paramString2, this.itemsCache);
            i += 1;
        }
    }

    public void renameClass(Map paramMap) {
        LongVector localLongVector = this.items;
        int j = this.numOfItems;
        int i = 1;
        while (i < j) {
            localLongVector.elementAt(i).renameClass(this, paramMap, this.itemsCache);
            i += 1;
        }
    }

    void setThisClassInfo(int paramInt) {
        this.thisClassInfo = paramInt;
    }

    public void write(DataOutputStream paramDataOutputStream) {
        paramDataOutputStream.writeShort(this.numOfItems);
        LongVector localLongVector = this.items;
        int j = this.numOfItems;
        int i = 1;
        while (i < j) {
            localLongVector.elementAt(i).write(paramDataOutputStream);
            i += 1;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/ConstPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */