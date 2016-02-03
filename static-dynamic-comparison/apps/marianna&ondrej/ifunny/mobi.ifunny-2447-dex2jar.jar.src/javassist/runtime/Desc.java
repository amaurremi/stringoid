package javassist.runtime;

public class Desc {
    public static boolean useContextClassLoader = false;

    private static Class getClassObject(String paramString) {
        if (useContextClassLoader) {
            return Class.forName(paramString, true, Thread.currentThread().getContextClassLoader());
        }
        return Class.forName(paramString);
    }

    private static Class[] getClassType(String paramString, int paramInt1, int paramInt2, int paramInt3) {
        int i = paramInt2;
        while (paramString.charAt(i) == '[') {
            i += 1;
        }
        int j = i;
        if (paramString.charAt(i) == 'L') {
            i = paramString.indexOf(';', i);
            j = i;
            if (i < 0) {
                throw new IndexOutOfBoundsException("bad descriptor");
            }
        }
        if (paramString.charAt(paramInt2) == 'L') {
        }
        for (String str = paramString.substring(paramInt2 + 1, j); ; str = paramString.substring(paramInt2, j + 1)) {
            paramString = getType(paramString, paramInt1, j + 1, paramInt3 + 1);
            try {
                paramString[paramInt3] = getClassObject(str.replace('/', '.'));
                return paramString;
            } catch (ClassNotFoundException paramString) {
                throw new RuntimeException(paramString.getMessage());
            }
        }
    }

    public static Class getClazz(String paramString) {
        try {
            Class localClass = getClassObject(paramString);
            return localClass;
        } catch (ClassNotFoundException localClassNotFoundException) {
            throw new RuntimeException("$class: internal error, could not find class '" + paramString + "' (Desc.useContextClassLoader: " + Boolean.toString(useContextClassLoader) + ")", localClassNotFoundException);
        }
    }

    public static Class[] getParams(String paramString) {
        if (paramString.charAt(0) != '(') {
            throw new RuntimeException("$sig: internal error");
        }
        return getType(paramString, paramString.length(), 1, 0);
    }

    public static Class getType(String paramString) {
        paramString = getType(paramString, paramString.length(), 0, 0);
        if ((paramString == null) || (paramString.length != 1)) {
            throw new RuntimeException("$type: internal error");
        }
        return paramString[0];
    }

    private static Class[] getType(String paramString, int paramInt1, int paramInt2, int paramInt3) {
        if (paramInt2 >= paramInt1) {
            return new Class[paramInt3];
        }
        Class localClass;
        switch (paramString.charAt(paramInt2)) {
            case 'E':
            case 'G':
            case 'H':
            case 'K':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'T':
            case 'U':
            case 'W':
            case 'X':
            case 'Y':
            default:
                return new Class[paramInt3];
            case 'Z':
                localClass = Boolean.TYPE;
            case 'C':
            case 'B':
            case 'S':
            case 'I':
            case 'J':
            case 'F':
            case 'D':
            case 'V':
                for (; ; ) {
                    paramString = getType(paramString, paramInt1, paramInt2 + 1, paramInt3 + 1);
                    paramString[paramInt3] = localClass;
                    return paramString;
                    localClass = Character.TYPE;
                    continue;
                    localClass = Byte.TYPE;
                    continue;
                    localClass = Short.TYPE;
                    continue;
                    localClass = Integer.TYPE;
                    continue;
                    localClass = Long.TYPE;
                    continue;
                    localClass = Float.TYPE;
                    continue;
                    localClass = Double.TYPE;
                    continue;
                    localClass = Void.TYPE;
                }
        }
        return getClassType(paramString, paramInt1, paramInt2, paramInt3);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/runtime/Desc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */