package javassist.bytecode.stackmap;

import java.util.ArrayList;

import javassist.ClassPool;
import javassist.bytecode.BadBytecode;

public class TypeData$ArrayElement
        extends TypeData.TypeName {
    TypeData array;

    public TypeData$ArrayElement(TypeData paramTypeData) {
        this.array = paramTypeData;
    }

    public static String getArrayType(String paramString) {
        if (paramString.charAt(0) == '[') {
            return "[" + paramString;
        }
        return "[L" + paramString.replace('.', '/') + ";";
    }

    public static String getElementType(String paramString) {
        int i = paramString.charAt(1);
        String str;
        if (i == 76) {
            str = paramString.substring(2, paramString.length() - 1).replace('/', '.');
        }
        do {
            return str;
            str = paramString;
        } while (i != 91);
        return paramString.substring(1);
    }

    private String getName2(String paramString) {
        if ((paramString.length() > 1) && (paramString.charAt(0) == '[')) {
            int i = paramString.charAt(1);
            if (i == 76) {
                return paramString.substring(2, paramString.length() - 1).replace('/', '.');
            }
            if (i == 91) {
                return paramString.substring(1);
            }
        }
        if (this.array.isNullType()) {
            return "java.lang.Object";
        }
        throw new BadBytecode("bad array type for AALOAD: " + paramString);
    }

    public TypeData copy() {
        return new ArrayElement(this.array);
    }

    public String getExpected() {
        Object localObject;
        if (this.equivalences.size() == 1) {
            localObject = getName2(this.array.getExpected());
        }
        String str;
        do {
            return (String) localObject;
            str = this.expectedName;
            localObject = str;
        } while (str != null);
        return "java.lang.Object";
    }

    public String getName() {
        return getName2(this.array.getName());
    }

    public boolean isNullType() {
        return this.array.isNullType();
    }

    protected void setType(String paramString, ClassPool paramClassPool) {
        super.setType(paramString, paramClassPool);
        this.array.setType(getArrayType(paramString), paramClassPool);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/stackmap/TypeData$ArrayElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */