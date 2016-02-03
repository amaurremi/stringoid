package javassist.bytecode;

import java.util.Map;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtPrimitiveType;
import javassist.NotFoundException;

public class Descriptor {
    public static String appendParameter(String paramString1, String paramString2) {
        int i = paramString2.indexOf(')');
        if (i < 0) {
            return paramString2;
        }
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append(paramString2.substring(0, i));
        localStringBuffer.append('L');
        localStringBuffer.append(paramString1.replace('.', '/'));
        localStringBuffer.append(';');
        localStringBuffer.append(paramString2.substring(i));
        return localStringBuffer.toString();
    }

    public static String appendParameter(CtClass paramCtClass, String paramString) {
        int i = paramString.indexOf(')');
        if (i < 0) {
            return paramString;
        }
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append(paramString.substring(0, i));
        toDescriptor(localStringBuffer, paramCtClass);
        localStringBuffer.append(paramString.substring(i));
        return localStringBuffer.toString();
    }

    public static int arrayDimension(String paramString) {
        int i = 0;
        while (paramString.charAt(i) == '[') {
            i += 1;
        }
        return i;
    }

    public static String changeReturnType(String paramString1, String paramString2) {
        int i = paramString2.indexOf(')');
        if (i < 0) {
            return paramString2;
        }
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append(paramString2.substring(0, i + 1));
        localStringBuffer.append('L');
        localStringBuffer.append(paramString1.replace('.', '/'));
        localStringBuffer.append(';');
        return localStringBuffer.toString();
    }

    public static int dataSize(String paramString) {
        return dataSize(paramString, true);
    }

    private static int dataSize(String paramString, boolean paramBoolean) {
        int j = paramString.charAt(0);
        int i;
        int m;
        if (j == 40) {
            j = 1;
            i = 0;
            m = paramString.charAt(j);
            if (m == 41) {
                j = paramString.charAt(j + 1);
            }
        }
        for (; ; ) {
            int k = i;
            if (paramBoolean) {
                if ((j != 74) && (j != 68)) {
                    break label165;
                }
                k = i + 2;
            }
            label165:
            do {
                return k;
                for (k = 0; m == 91; k = 1) {
                    j += 1;
                    m = paramString.charAt(j);
                }
                if (m == 76) {
                    int n = paramString.indexOf(';', j) + 1;
                    j = n;
                    if (n <= 0) {
                        throw new IndexOutOfBoundsException("bad descriptor");
                    }
                } else {
                    j += 1;
                }
                if ((k == 0) && ((m == 74) || (m == 68))) {
                    i -= 2;
                    break;
                }
                i -= 1;
                break;
                k = i;
            } while (j == 86);
            return i + 1;
            i = 0;
        }
    }

    public static boolean eqParamTypes(String paramString1, String paramString2) {
        if (paramString1.charAt(0) != '(') {
            return false;
        }
        int i = 0;
        for (; ; ) {
            int j = paramString1.charAt(i);
            if (j != paramString2.charAt(i)) {
                break;
            }
            if (j == 41) {
                return true;
            }
            i += 1;
        }
    }

    public static String getParamDescriptor(String paramString) {
        return paramString.substring(0, paramString.indexOf(')') + 1);
    }

    public static CtClass[] getParameterTypes(String paramString, ClassPool paramClassPool) {
        int i = 0;
        if (paramString.charAt(0) != '(') {
            return null;
        }
        CtClass[] arrayOfCtClass = new CtClass[numOfParameters(paramString)];
        int j = 1;
        for (; ; ) {
            j = toCtClass(paramClassPool, paramString, j, arrayOfCtClass, i);
            if (j <= 0) {
                return arrayOfCtClass;
            }
            i += 1;
        }
    }

    public static CtClass getReturnType(String paramString, ClassPool paramClassPool) {
        int i = paramString.indexOf(')');
        if (i < 0) {
            return null;
        }
        CtClass[] arrayOfCtClass = new CtClass[1];
        toCtClass(paramClassPool, paramString, i + 1, arrayOfCtClass, 0);
        return arrayOfCtClass[0];
    }

    public static String insertParameter(String paramString1, String paramString2) {
        if (paramString2.charAt(0) != '(') {
            return paramString2;
        }
        return "(L" + paramString1.replace('.', '/') + ';' + paramString2.substring(1);
    }

    public static String insertParameter(CtClass paramCtClass, String paramString) {
        if (paramString.charAt(0) != '(') {
            return paramString;
        }
        return "(" + of(paramCtClass) + paramString.substring(1);
    }

    public static int numOfParameters(String paramString) {
        int j = 0;
        int i = 1;
        int m = paramString.charAt(i);
        if (m == 41) {
            return j;
        }
        for (; ; ) {
            int k;
            if (i == 91) {
                k += 1;
                i = paramString.charAt(k);
            } else {
                if (i == 76) {
                    k = paramString.indexOf(';', k) + 1;
                    i = k;
                    if (k <= 0) {
                        throw new IndexOutOfBoundsException("bad descriptor");
                    }
                } else {
                    i = k + 1;
                }
                j += 1;
                break;
                k = i;
                i = m;
            }
        }
    }

    public static String of(String paramString) {
        if (paramString.equals("void")) {
            return "V";
        }
        if (paramString.equals("int")) {
            return "I";
        }
        if (paramString.equals("byte")) {
            return "B";
        }
        if (paramString.equals("long")) {
            return "J";
        }
        if (paramString.equals("double")) {
            return "D";
        }
        if (paramString.equals("float")) {
            return "F";
        }
        if (paramString.equals("char")) {
            return "C";
        }
        if (paramString.equals("short")) {
            return "S";
        }
        if (paramString.equals("boolean")) {
            return "Z";
        }
        return "L" + toJvmName(paramString) + ";";
    }

    public static String of(CtClass paramCtClass) {
        StringBuffer localStringBuffer = new StringBuffer();
        toDescriptor(localStringBuffer, paramCtClass);
        return localStringBuffer.toString();
    }

    public static String ofConstructor(CtClass[] paramArrayOfCtClass) {
        return ofMethod(CtClass.voidType, paramArrayOfCtClass);
    }

    public static String ofMethod(CtClass paramCtClass, CtClass[] paramArrayOfCtClass) {
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append('(');
        if (paramArrayOfCtClass != null) {
            int j = paramArrayOfCtClass.length;
            int i = 0;
            while (i < j) {
                toDescriptor(localStringBuffer, paramArrayOfCtClass[i]);
                i += 1;
            }
        }
        localStringBuffer.append(')');
        if (paramCtClass != null) {
            toDescriptor(localStringBuffer, paramCtClass);
        }
        return localStringBuffer.toString();
    }

    public static String ofParameters(CtClass[] paramArrayOfCtClass) {
        return ofMethod(null, paramArrayOfCtClass);
    }

    public static int paramSize(String paramString) {
        return -dataSize(paramString, false);
    }

    public static String rename(String paramString1, String paramString2, String paramString3) {
        int i = 0;
        if (paramString1.indexOf(paramString2) < 0) {
        }
        label171:
        for (; ; ) {
            return paramString1;
            StringBuffer localStringBuffer = new StringBuffer();
            int j = 0;
            i = paramString1.indexOf('L', i);
            if (i < 0) {
            }
            for (; ; ) {
                if (j == 0) {
                    break label171;
                }
                i = paramString1.length();
                if (j < i) {
                    localStringBuffer.append(paramString1.substring(j, i));
                }
                return localStringBuffer.toString();
                if ((paramString1.startsWith(paramString2, i + 1)) && (paramString1.charAt(paramString2.length() + i + 1) == ';')) {
                    localStringBuffer.append(paramString1.substring(j, i));
                    localStringBuffer.append('L');
                    localStringBuffer.append(paramString3);
                    localStringBuffer.append(';');
                    i = i + paramString2.length() + 2;
                    j = i;
                    break;
                }
                int k = paramString1.indexOf(';', i) + 1;
                i = k;
                if (k >= 1) {
                    break;
                }
            }
        }
    }

    public static String rename(String paramString, Map paramMap) {
        int j = 0;
        if (paramMap == null) {
        }
        StringBuffer localStringBuffer;
        int i;
        int k;
        int m;
        do {
            while (i == 0) {
                return paramString;
                localStringBuffer = new StringBuffer();
                i = 0;
                k = paramString.indexOf('L', j);
                if (k >= 0) {
                    break;
                }
            }
            j = paramString.length();
            if (i < j) {
                localStringBuffer.append(paramString.substring(i, j));
            }
            return localStringBuffer.toString();
            m = paramString.indexOf(';', k);
        } while (m < 0);
        j = m + 1;
        String str = (String) paramMap.get(paramString.substring(k + 1, m));
        if (str != null) {
            localStringBuffer.append(paramString.substring(i, k));
            localStringBuffer.append('L');
            localStringBuffer.append(str);
            localStringBuffer.append(';');
            i = j;
        }
        for (; ; ) {
            break;
        }
    }

    public static String toArrayComponent(String paramString, int paramInt) {
        return paramString.substring(paramInt);
    }

    public static String toClassName(String paramString) {
        int j = 0;
        int k = paramString.charAt(0);
        int i = 0;
        while (k == 91) {
            i += 1;
            j += 1;
            k = paramString.charAt(j);
        }
        String str;
        if (k == 76) {
            k = paramString.indexOf(';', j);
            str = paramString.substring(j + 1, k).replace('/', '.');
            j = k;
        }
        while (j + 1 != paramString.length()) {
            throw new RuntimeException("multiple descriptors?: " + paramString);
            if (k == 86) {
                str = "void";
            } else if (k == 73) {
                str = "int";
            } else if (k == 66) {
                str = "byte";
            } else if (k == 74) {
                str = "long";
            } else if (k == 68) {
                str = "double";
            } else if (k == 70) {
                str = "float";
            } else if (k == 67) {
                str = "char";
            } else if (k == 83) {
                str = "short";
            } else if (k == 90) {
                str = "boolean";
            } else {
                throw new RuntimeException("bad descriptor: " + paramString);
            }
        }
        if (i == 0) {
            return str;
        }
        paramString = new StringBuffer(str);
        do {
            paramString.append("[]");
            j = i - 1;
            i = j;
        } while (j > 0);
        return paramString.toString();
    }

    private static int toCtClass(ClassPool paramClassPool, String paramString, int paramInt1, CtClass[] paramArrayOfCtClass, int paramInt2) {
        int j = 0;
        char c = paramString.charAt(paramInt1);
        int i = paramInt1;
        paramInt1 = j;
        while (c == '[') {
            paramInt1 += 1;
            i += 1;
            c = paramString.charAt(i);
        }
        int k;
        if (c == 'L') {
            j = i + 1;
            k = paramString.indexOf(';', j);
            i = k + 1;
        }
        for (paramString = paramString.substring(j, k).replace('/', '.'); ; paramString = paramString.getName()) {
            str = paramString;
            if (paramInt1 <= 0) {
                break label167;
            }
            paramString = new StringBuffer(paramString);
            while (paramInt1 > 0) {
                paramString.append("[]");
                paramInt1 -= 1;
            }
            paramString = toPrimitiveClass(c);
            if (paramString == null) {
                return -1;
            }
            i += 1;
            if (paramInt1 == 0) {
                paramArrayOfCtClass[paramInt2] = paramString;
                return i;
            }
        }
        String str = paramString.toString();
        label167:
        paramArrayOfCtClass[paramInt2] = paramClassPool.get(str);
        return i;
    }

    public static CtClass toCtClass(String paramString, ClassPool paramClassPool) {
        CtClass[] arrayOfCtClass = new CtClass[1];
        if (toCtClass(paramClassPool, paramString, 0, arrayOfCtClass, 0) >= 0) {
            return arrayOfCtClass[0];
        }
        return paramClassPool.get(paramString.replace('/', '.'));
    }

    private static void toDescriptor(StringBuffer paramStringBuffer, CtClass paramCtClass) {
        if (paramCtClass.isArray()) {
            paramStringBuffer.append('[');
            try {
                toDescriptor(paramStringBuffer, paramCtClass.getComponentType());
                return;
            } catch (NotFoundException localNotFoundException) {
                paramStringBuffer.append('L');
                paramCtClass = paramCtClass.getName();
                paramStringBuffer.append(toJvmName(paramCtClass.substring(0, paramCtClass.length() - 2)));
                paramStringBuffer.append(';');
                return;
            }
        }
        if (paramCtClass.isPrimitive()) {
            paramStringBuffer.append(((CtPrimitiveType) paramCtClass).getDescriptor());
            return;
        }
        paramStringBuffer.append('L');
        paramStringBuffer.append(paramCtClass.getName().replace('.', '/'));
        paramStringBuffer.append(';');
    }

    public static String toJavaName(String paramString) {
        return paramString.replace('/', '.');
    }

    public static String toJvmName(String paramString) {
        return paramString.replace('.', '/');
    }

    public static String toJvmName(CtClass paramCtClass) {
        if (paramCtClass.isArray()) {
            return of(paramCtClass);
        }
        return toJvmName(paramCtClass.getName());
    }

    static CtClass toPrimitiveClass(char paramChar) {
        switch (paramChar) {
            default:
                return null;
            case 'Z':
                return CtClass.booleanType;
            case 'C':
                return CtClass.charType;
            case 'B':
                return CtClass.byteType;
            case 'S':
                return CtClass.shortType;
            case 'I':
                return CtClass.intType;
            case 'J':
                return CtClass.longType;
            case 'F':
                return CtClass.floatType;
            case 'D':
                return CtClass.doubleType;
        }
        return CtClass.voidType;
    }

    public static String toString(String paramString) {
        return Descriptor.PrettyPrinter.toString(paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/Descriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */