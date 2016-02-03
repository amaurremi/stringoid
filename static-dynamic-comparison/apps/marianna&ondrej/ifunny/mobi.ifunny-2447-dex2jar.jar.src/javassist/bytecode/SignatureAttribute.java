package javassist.bytecode;

import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SignatureAttribute
        extends AttributeInfo {
    public static final String tag = "Signature";

    SignatureAttribute(ConstPool paramConstPool, int paramInt, DataInputStream paramDataInputStream) {
        super(paramConstPool, paramInt, paramDataInputStream);
    }

    public SignatureAttribute(ConstPool paramConstPool, String paramString) {
        super(paramConstPool, "Signature");
        int i = paramConstPool.addUtf8Info(paramString);
        set(new byte[]{(byte) (i >>> 8), (byte) i});
    }

    private static BadBytecode error(String paramString) {
        return new BadBytecode("bad signature: " + paramString);
    }

    private static boolean isNamePart(int paramInt) {
        return (paramInt != 59) && (paramInt != 60);
    }

    private static SignatureAttribute.ObjectType parseArray(String paramString, SignatureAttribute.Cursor paramCursor) {
        int i = 1;
        for (; ; ) {
            int j = paramCursor.position + 1;
            paramCursor.position = j;
            if (paramString.charAt(j) != '[') {
                break;
            }
            i += 1;
        }
        return new SignatureAttribute.ArrayType(i, parseType(paramString, paramCursor));
    }

    private static SignatureAttribute.ClassType parseClassType(String paramString, SignatureAttribute.Cursor paramCursor) {
        if (paramString.charAt(paramCursor.position) == 'L') {
            return parseClassType2(paramString, paramCursor, null);
        }
        throw error(paramString);
    }

    private static SignatureAttribute.ClassType parseClassType2(String paramString, SignatureAttribute.Cursor paramCursor, SignatureAttribute.ClassType paramClassType) {
        int j = paramCursor.position + 1;
        paramCursor.position = j;
        int i;
        do {
            i = paramCursor.position;
            paramCursor.position = (i + 1);
            i = paramString.charAt(i);
        } while ((i != 36) && (i != 60) && (i != 59));
        int k = paramCursor.position;
        Object localObject;
        if (i == 60) {
            localObject = parseTypeArgs(paramString, paramCursor);
            i = paramCursor.position;
            paramCursor.position = (i + 1);
            i = paramString.charAt(i);
        }
        for (; ; ) {
            localObject = SignatureAttribute.ClassType.make(paramString, j, k - 1, (SignatureAttribute.TypeArgument[]) localObject, paramClassType);
            paramClassType = (SignatureAttribute.ClassType) localObject;
            if (i == 36) {
                paramCursor.position -= 1;
                paramClassType = parseClassType2(paramString, paramCursor, (SignatureAttribute.ClassType) localObject);
            }
            return paramClassType;
            localObject = null;
        }
    }

    private static SignatureAttribute.MethodSignature parseMethodSig(String paramString) {
        SignatureAttribute.Cursor localCursor = new SignatureAttribute.Cursor(null);
        SignatureAttribute.TypeParameter[] arrayOfTypeParameter = parseTypeParams(paramString, localCursor);
        int i = localCursor.position;
        localCursor.position = (i + 1);
        if (paramString.charAt(i) != '(') {
            throw error(paramString);
        }
        ArrayList localArrayList1 = new ArrayList();
        while (paramString.charAt(localCursor.position) != ')') {
            localArrayList1.add(parseType(paramString, localCursor));
        }
        localCursor.position += 1;
        SignatureAttribute.Type localType = parseType(paramString, localCursor);
        i = paramString.length();
        ArrayList localArrayList2 = new ArrayList();
        while ((localCursor.position < i) && (paramString.charAt(localCursor.position) == '^')) {
            localCursor.position += 1;
            SignatureAttribute.ObjectType localObjectType = parseObjectType(paramString, localCursor, false);
            if ((localObjectType instanceof SignatureAttribute.ArrayType)) {
                throw error(paramString);
            }
            localArrayList2.add(localObjectType);
        }
        return new SignatureAttribute.MethodSignature(arrayOfTypeParameter, (SignatureAttribute.Type[]) localArrayList1.toArray(new SignatureAttribute.Type[localArrayList1.size()]), localType, (SignatureAttribute.ObjectType[]) localArrayList2.toArray(new SignatureAttribute.ObjectType[localArrayList2.size()]));
    }

    private static SignatureAttribute.ObjectType parseObjectType(String paramString, SignatureAttribute.Cursor paramCursor, boolean paramBoolean) {
        int i = paramCursor.position;
        switch (paramString.charAt(i)) {
            default:
                if (paramBoolean) {
                    return null;
                }
                break;
            case 'L':
                return parseClassType2(paramString, paramCursor, null);
            case 'T':
                return new SignatureAttribute.TypeVariable(paramString, i + 1, paramCursor.indexOf(paramString, 59));
            case '[':
                return parseArray(paramString, paramCursor);
        }
        throw error(paramString);
    }

    private static SignatureAttribute.ClassSignature parseSig(String paramString) {
        SignatureAttribute.Cursor localCursor = new SignatureAttribute.Cursor(null);
        SignatureAttribute.TypeParameter[] arrayOfTypeParameter = parseTypeParams(paramString, localCursor);
        SignatureAttribute.ClassType localClassType = parseClassType(paramString, localCursor);
        int i = paramString.length();
        ArrayList localArrayList = new ArrayList();
        while ((localCursor.position < i) && (paramString.charAt(localCursor.position) == 'L')) {
            localArrayList.add(parseClassType(paramString, localCursor));
        }
        return new SignatureAttribute.ClassSignature(arrayOfTypeParameter, localClassType, (SignatureAttribute.ClassType[]) localArrayList.toArray(new SignatureAttribute.ClassType[localArrayList.size()]));
    }

    private static SignatureAttribute.Type parseType(String paramString, SignatureAttribute.Cursor paramCursor) {
        SignatureAttribute.ObjectType localObjectType = parseObjectType(paramString, paramCursor, true);
        Object localObject = localObjectType;
        if (localObjectType == null) {
            int i = paramCursor.position;
            paramCursor.position = (i + 1);
            localObject = new SignatureAttribute.BaseType(paramString.charAt(i));
        }
        return (SignatureAttribute.Type) localObject;
    }

    private static SignatureAttribute.TypeArgument[] parseTypeArgs(String paramString, SignatureAttribute.Cursor paramCursor) {
        ArrayList localArrayList = new ArrayList();
        int i = paramCursor.position;
        paramCursor.position = (i + 1);
        char c2 = paramString.charAt(i);
        if (c2 != '>') {
            if (c2 == '*') {
            }
            char c1;
            for (SignatureAttribute.TypeArgument localTypeArgument = new SignatureAttribute.TypeArgument(null, '*'); ; localTypeArgument = new SignatureAttribute.TypeArgument(parseObjectType(paramString, paramCursor, false), c1)) {
                localArrayList.add(localTypeArgument);
                break;
                c1 = c2;
                if (c2 != '+') {
                    c1 = c2;
                    if (c2 != '-') {
                        c1 = ' ';
                        paramCursor.position -= 1;
                    }
                }
            }
        }
        return (SignatureAttribute.TypeArgument[]) localArrayList.toArray(new SignatureAttribute.TypeArgument[localArrayList.size()]);
    }

    private static SignatureAttribute.TypeParameter[] parseTypeParams(String paramString, SignatureAttribute.Cursor paramCursor) {
        ArrayList localArrayList1 = new ArrayList();
        if (paramString.charAt(paramCursor.position) == '<') {
            paramCursor.position += 1;
            while (paramString.charAt(paramCursor.position) != '>') {
                int i = paramCursor.position;
                int j = paramCursor.indexOf(paramString, 58);
                SignatureAttribute.ObjectType localObjectType = parseObjectType(paramString, paramCursor, true);
                ArrayList localArrayList2 = new ArrayList();
                while (paramString.charAt(paramCursor.position) == ':') {
                    paramCursor.position += 1;
                    localArrayList2.add(parseObjectType(paramString, paramCursor, false));
                }
                localArrayList1.add(new SignatureAttribute.TypeParameter(paramString, i, j, localObjectType, (SignatureAttribute.ObjectType[]) localArrayList2.toArray(new SignatureAttribute.ObjectType[localArrayList2.size()])));
            }
            paramCursor.position += 1;
        }
        return (SignatureAttribute.TypeParameter[]) localArrayList1.toArray(new SignatureAttribute.TypeParameter[localArrayList1.size()]);
    }

    static String renameClass(String paramString1, String paramString2, String paramString3) {
        HashMap localHashMap = new HashMap();
        localHashMap.put(paramString2, paramString3);
        return renameClass(paramString1, localHashMap);
    }

    static String renameClass(String paramString, Map paramMap) {
        int j = 0;
        if (paramMap == null) {
            return paramString;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        int i = 0;
        for (; ; ) {
            int m = paramString.indexOf('L', j);
            if (m < 0) {
                if (i == 0) {
                    break;
                }
                j = paramString.length();
                if (i < j) {
                    localStringBuilder.append(paramString.substring(i, j));
                }
                return localStringBuilder.toString();
            }
            Object localObject = new StringBuilder();
            j = m;
            label83:
            int k = j + 1;
            try {
                char c = paramString.charAt(k);
                if (c != ';') {
                    ((StringBuilder) localObject).append(c);
                    j = k;
                    if (c != '<') {
                        break label83;
                    }
                    for (; ; ) {
                        j = k + 1;
                        c = paramString.charAt(j);
                        if (c == '>') {
                            break;
                        }
                        ((StringBuilder) localObject).append(c);
                        k = j;
                    }
                    ((StringBuilder) localObject).append(c);
                    break label83;
                }
                j = k + 1;
                localObject = (String) paramMap.get(((StringBuilder) localObject).toString());
                if (localObject != null) {
                    localStringBuilder.append(paramString.substring(i, m));
                    localStringBuilder.append('L');
                    localStringBuilder.append((String) localObject);
                    localStringBuilder.append(c);
                    i = j;
                }
                for (; ; ) {
                    break;
                }
            } catch (IndexOutOfBoundsException paramMap) {
            }
        }
    }

    public static SignatureAttribute.ClassSignature toClassSignature(String paramString) {
        try {
            SignatureAttribute.ClassSignature localClassSignature = parseSig(paramString);
            return localClassSignature;
        } catch (IndexOutOfBoundsException localIndexOutOfBoundsException) {
            throw error(paramString);
        }
    }

    public static SignatureAttribute.ObjectType toFieldSignature(String paramString) {
        try {
            SignatureAttribute.ObjectType localObjectType = parseObjectType(paramString, new SignatureAttribute.Cursor(null), false);
            return localObjectType;
        } catch (IndexOutOfBoundsException localIndexOutOfBoundsException) {
            throw error(paramString);
        }
    }

    public static SignatureAttribute.MethodSignature toMethodSignature(String paramString) {
        try {
            SignatureAttribute.MethodSignature localMethodSignature = parseMethodSig(paramString);
            return localMethodSignature;
        } catch (IndexOutOfBoundsException localIndexOutOfBoundsException) {
            throw error(paramString);
        }
    }

    public AttributeInfo copy(ConstPool paramConstPool, Map paramMap) {
        return new SignatureAttribute(paramConstPool, getSignature());
    }

    public String getSignature() {
        return getConstPool().getUtf8Info(ByteArray.readU16bit(get(), 0));
    }

    void renameClass(String paramString1, String paramString2) {
        setSignature(renameClass(getSignature(), paramString1, paramString2));
    }

    void renameClass(Map paramMap) {
        setSignature(renameClass(getSignature(), paramMap));
    }

    public void setSignature(String paramString) {
        ByteArray.write16bit(getConstPool().addUtf8Info(paramString), this.info, 0);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/SignatureAttribute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */