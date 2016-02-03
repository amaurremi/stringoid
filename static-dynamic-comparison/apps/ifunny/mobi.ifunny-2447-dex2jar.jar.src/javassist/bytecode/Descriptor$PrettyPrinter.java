package javassist.bytecode;

import javassist.CtClass;

class Descriptor$PrettyPrinter {
    static int readType(StringBuffer paramStringBuffer, int paramInt, String paramString) {
        char c1 = paramString.charAt(paramInt);
        int j = 0;
        int i = paramInt;
        paramInt = j;
        while (c1 == '[') {
            paramInt += 1;
            i += 1;
            c1 = paramString.charAt(i);
        }
        char c2;
        if (c1 == 'L') {
            i += 1;
            c2 = paramString.charAt(i);
            if (c2 != ';') {
            }
        }
        for (; ; ) {
            if (paramInt <= 0) {
                break label123;
            }
            paramStringBuffer.append("[]");
            paramInt -= 1;
            continue;
            c1 = c2;
            if (c2 == '/') {
                c1 = '.';
            }
            paramStringBuffer.append(c1);
            break;
            paramStringBuffer.append(Descriptor.toPrimitiveClass(c1).getName());
        }
        label123:
        return i + 1;
    }

    static String toString(String paramString) {
        StringBuffer localStringBuffer = new StringBuffer();
        if (paramString.charAt(0) == '(') {
            localStringBuffer.append('(');
            for (int i = 1; paramString.charAt(i) != ')'; i = readType(localStringBuffer, i, paramString)) {
                if (i > 1) {
                    localStringBuffer.append(',');
                }
            }
            localStringBuffer.append(')');
        }
        for (; ; ) {
            return localStringBuffer.toString();
            readType(localStringBuffer, 0, paramString);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/Descriptor$PrettyPrinter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */