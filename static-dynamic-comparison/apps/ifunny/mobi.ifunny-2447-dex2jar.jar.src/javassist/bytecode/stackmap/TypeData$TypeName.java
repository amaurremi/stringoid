package javassist.bytecode.stackmap;

import java.util.ArrayList;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.ConstPool;

public abstract class TypeData$TypeName
        extends TypeData {
    private CtClass cache;
    protected ArrayList equivalences = new ArrayList();
    private boolean evalDone;
    protected String expectedName;

    protected TypeData$TypeName() {
        this.equivalences.add(this);
        this.expectedName = null;
        this.cache = null;
        this.evalDone = false;
    }

    private static void add(ArrayList paramArrayList, TypeData paramTypeData) {
        int j = paramArrayList.size();
        int i = 0;
        while (i < j) {
            if (paramArrayList.get(i) == paramTypeData) {
                return;
            }
            i += 1;
        }
        paramArrayList.add(paramTypeData);
    }

    private String evalExpectedType2(ArrayList paramArrayList, int paramInt) {
        int i = 0;
        String str = null;
        Object localObject = str;
        if (i < paramInt) {
            localObject = (TypeData) paramArrayList.get(i);
            if (((TypeData) localObject).isNullType()) {
                break label70;
            }
            if (str == null) {
                str = ((TypeData) localObject).getName();
            }
        }
        label70:
        for (; ; ) {
            i += 1;
            break;
            if (!str.equals(((TypeData) localObject).getName())) {
                localObject = null;
                return (String) localObject;
            }
        }
    }

    private boolean update(ClassPool paramClassPool, String paramString1, String paramString2) {
        if (paramString2 == null) {
        }
        for (; ; ) {
            return false;
            if (paramString1 == null) {
                return true;
            }
            if (paramString1.equals(paramString2)) {
                continue;
            }
            if ((paramString2.charAt(0) == '[') && (paramString1.equals("[Ljava.lang.Object;"))) {
                return true;
            }
            try {
                if (this.cache == null) {
                    this.cache = paramClassPool.get(paramString1);
                }
                paramClassPool = paramClassPool.get(paramString2);
                if (!paramClassPool.subtypeOf(this.cache)) {
                    continue;
                }
                this.cache = paramClassPool;
                return true;
            } catch (NotFoundException paramClassPool) {
                throw new BadBytecode("cannot find " + paramClassPool.getMessage());
            }
        }
    }

    public boolean equals(Object paramObject) {
        if ((paramObject instanceof TypeName)) {
            try {
                paramObject = (TypeName) paramObject;
                boolean bool = getExpected().equals(((TypeName) paramObject).getExpected());
                return bool;
            } catch (BadBytecode paramObject) {
            }
        }
        return false;
    }

    public void evalExpectedType(ClassPool paramClassPool) {
        int k = 0;
        if (this.evalDone) {
            return;
        }
        ArrayList localArrayList = this.equivalences;
        int m = localArrayList.size();
        String str = evalExpectedType2(localArrayList, m);
        Object localObject = str;
        int j = k;
        int i;
        if (str == null) {
            str = this.expectedName;
            i = 0;
            label54:
            localObject = str;
            j = k;
            if (i < m) {
                localObject = (TypeData) localArrayList.get(i);
                if (!(localObject instanceof TypeName)) {
                    break label173;
                }
                localObject = (TypeName) localObject;
                if (!update(paramClassPool, str, ((TypeName) localObject).expectedName)) {
                    break label173;
                }
                str = ((TypeName) localObject).expectedName;
            }
        }
        label173:
        for (; ; ) {
            i += 1;
            break label54;
            while (j < m) {
                paramClassPool = (TypeData) localArrayList.get(j);
                if ((paramClassPool instanceof TypeName)) {
                    paramClassPool = (TypeName) paramClassPool;
                    paramClassPool.expectedName = ((String) localObject);
                    paramClassPool.cache = null;
                    paramClassPool.evalDone = true;
                }
                j += 1;
            }
            break;
        }
    }

    public String getExpected() {
        Object localObject;
        if (this.equivalences.size() == 1) {
            localObject = getName();
        }
        String str;
        do {
            return (String) localObject;
            str = this.expectedName;
            localObject = str;
        } while (str != null);
        return "java.lang.Object";
    }

    public int getTypeData(ConstPool paramConstPool) {
        try {
            String str = getExpected();
            return getTypeData2(paramConstPool, str);
        } catch (BadBytecode paramConstPool) {
            throw new RuntimeException("fatal error: ", paramConstPool);
        }
    }

    protected int getTypeData2(ConstPool paramConstPool, String paramString) {
        return paramConstPool.addClassInfo(paramString);
    }

    public int getTypeTag() {
        return 7;
    }

    public boolean isObjectType() {
        return true;
    }

    protected boolean isTypeName() {
        return true;
    }

    public void merge(TypeData paramTypeData) {
        if (this == paramTypeData) {
            break label5;
        }
        for (; ; ) {
            label5:
            return;
            if ((paramTypeData instanceof TypeName)) {
                Object localObject = (TypeName) paramTypeData;
                paramTypeData = this.equivalences;
                localObject = ((TypeName) localObject).equivalences;
                if (paramTypeData == localObject) {
                    break;
                }
                int j = ((ArrayList) localObject).size();
                int i = 0;
                while (i < j) {
                    TypeName localTypeName = (TypeName) ((ArrayList) localObject).get(i);
                    add(paramTypeData, localTypeName);
                    localTypeName.equivalences = paramTypeData;
                    i += 1;
                }
            }
        }
    }

    protected void setType(String paramString, ClassPool paramClassPool) {
        if (update(paramClassPool, this.expectedName, paramString)) {
            this.expectedName = paramString;
        }
    }

    public String toString() {
        try {
            Object localObject = this.expectedName;
            if (localObject != null) {
                return (String) localObject;
            }
            String str2 = getName();
            localObject = str2;
            if (this.equivalences.size() != 1) {
                localObject = str2 + "?";
                return (String) localObject;
            }
        } catch (BadBytecode localBadBytecode) {
            String str1 = "<" + localBadBytecode.getMessage() + ">";
            return str1;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/stackmap/TypeData$TypeName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */