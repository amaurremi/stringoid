package javassist.bytecode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

class ClassInfo
        extends ConstInfo {
    static final int tag = 7;
    int name;

    public ClassInfo(int paramInt1, int paramInt2) {
        super(paramInt2);
        this.name = paramInt1;
    }

    public ClassInfo(DataInputStream paramDataInputStream, int paramInt) {
        super(paramInt);
        this.name = paramDataInputStream.readUnsignedShort();
    }

    public int copy(ConstPool paramConstPool1, ConstPool paramConstPool2, Map paramMap) {
        paramConstPool1 = paramConstPool1.getUtf8Info(this.name);
        if (paramMap != null) {
            paramMap = (String) paramMap.get(paramConstPool1);
            if (paramMap != null) {
                paramConstPool1 = paramMap;
            }
        }
        for (; ; ) {
            return paramConstPool2.addClassInfo(paramConstPool1);
        }
    }

    public boolean equals(Object paramObject) {
        return ((paramObject instanceof ClassInfo)) && (((ClassInfo) paramObject).name == this.name);
    }

    public String getClassName(ConstPool paramConstPool) {
        return paramConstPool.getUtf8Info(this.name);
    }

    public int getTag() {
        return 7;
    }

    public int hashCode() {
        return this.name;
    }

    public void print(PrintWriter paramPrintWriter) {
        paramPrintWriter.print("Class #");
        paramPrintWriter.println(this.name);
    }

    public void renameClass(ConstPool paramConstPool, String paramString1, String paramString2, HashMap paramHashMap) {
        String str = paramConstPool.getUtf8Info(this.name);
        if (str.equals(paramString1)) {
        }
        for (; ; ) {
            if (paramString2 != null) {
                if (paramHashMap != null) {
                    break;
                }
                this.name = paramConstPool.addUtf8Info(paramString2);
            }
            return;
            if (str.charAt(0) == '[') {
                paramString1 = Descriptor.rename(str, paramString1, paramString2);
                paramString2 = paramString1;
                if (str != paramString1) {
                }
            } else {
                paramString2 = null;
            }
        }
        paramHashMap.remove(this);
        this.name = paramConstPool.addUtf8Info(paramString2);
        paramHashMap.put(this, this);
    }

    public void renameClass(ConstPool paramConstPool, Map paramMap, HashMap paramHashMap) {
        String str2 = paramConstPool.getUtf8Info(this.name);
        if (str2.charAt(0) == '[') {
            paramMap = Descriptor.rename(str2, paramMap);
            if (str2 == paramMap) {
                break label83;
            }
        }
        for (; ; ) {
            if (paramMap != null) {
                if (paramHashMap != null) {
                    break;
                }
                this.name = paramConstPool.addUtf8Info(paramMap);
            }
            return;
            String str1 = (String) paramMap.get(str2);
            if (str1 != null) {
                paramMap = str1;
                if (!str1.equals(str2)) {
                }
            } else {
                label83:
                paramMap = null;
            }
        }
        paramHashMap.remove(this);
        this.name = paramConstPool.addUtf8Info(paramMap);
        paramHashMap.put(this, this);
    }

    public void write(DataOutputStream paramDataOutputStream) {
        paramDataOutputStream.writeByte(7);
        paramDataOutputStream.writeShort(this.name);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/ClassInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */