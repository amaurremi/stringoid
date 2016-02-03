package org.apache.commons.lang.text;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StrSubstitutor {
    public static final char DEFAULT_ESCAPE = '$';
    public static final StrMatcher DEFAULT_PREFIX = StrMatcher.stringMatcher("${");
    public static final StrMatcher DEFAULT_SUFFIX = StrMatcher.stringMatcher("}");
    private char escapeChar;
    private StrMatcher prefixMatcher;
    private StrMatcher suffixMatcher;
    private StrLookup variableResolver;

    public StrSubstitutor() {
        this((StrLookup) null, DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
    }

    public StrSubstitutor(Map paramMap) {
        this(StrLookup.mapLookup(paramMap), DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
    }

    public StrSubstitutor(Map paramMap, String paramString1, String paramString2) {
        this(StrLookup.mapLookup(paramMap), paramString1, paramString2, '$');
    }

    public StrSubstitutor(Map paramMap, String paramString1, String paramString2, char paramChar) {
        this(StrLookup.mapLookup(paramMap), paramString1, paramString2, paramChar);
    }

    public StrSubstitutor(StrLookup paramStrLookup) {
        this(paramStrLookup, DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
    }

    public StrSubstitutor(StrLookup paramStrLookup, String paramString1, String paramString2, char paramChar) {
        setVariableResolver(paramStrLookup);
        setVariablePrefix(paramString1);
        setVariableSuffix(paramString2);
        setEscapeChar(paramChar);
    }

    public StrSubstitutor(StrLookup paramStrLookup, StrMatcher paramStrMatcher1, StrMatcher paramStrMatcher2, char paramChar) {
        setVariableResolver(paramStrLookup);
        setVariablePrefixMatcher(paramStrMatcher1);
        setVariableSuffixMatcher(paramStrMatcher2);
        setEscapeChar(paramChar);
    }

    private void checkCyclicSubstitution(String paramString, List paramList) {
        if (!paramList.contains(paramString)) {
            return;
        }
        paramString = new StrBuilder(256);
        paramString.append("Infinite loop in property interpolation of ");
        paramString.append(paramList.remove(0));
        paramString.append(": ");
        paramString.appendWithSeparators(paramList, "->");
        throw new IllegalStateException(paramString.toString());
    }

    public static String replace(Object paramObject, Map paramMap) {
        return new StrSubstitutor(paramMap).replace(paramObject);
    }

    public static String replace(Object paramObject, Map paramMap, String paramString1, String paramString2) {
        return new StrSubstitutor(paramMap, paramString1, paramString2).replace(paramObject);
    }

    public static String replaceSystemProperties(Object paramObject) {
        return new StrSubstitutor(StrLookup.systemPropertiesLookup()).replace(paramObject);
    }

    private int substitute(StrBuilder paramStrBuilder, int paramInt1, int paramInt2, List paramList) {
        StrMatcher localStrMatcher1 = getVariablePrefixMatcher();
        StrMatcher localStrMatcher2 = getVariableSuffixMatcher();
        int i5 = getEscapeChar();
        int i1;
        int m;
        int k;
        Object localObject1;
        int j;
        int i;
        Object localObject2;
        if (paramList == null) {
            i1 = 1;
            m = 0;
            k = 0;
            localObject1 = paramStrBuilder.buffer;
            j = paramInt1 + paramInt2;
            i = paramInt1;
            localObject2 = paramList;
            paramList = (List) localObject1;
        }
        for (; ; ) {
            int i3 = i;
            if (i3 >= j) {
                break label418;
            }
            int i2 = localStrMatcher1.isMatch(paramList, i3, paramInt1, j);
            if (i2 == 0) {
                i = i3 + 1;
                continue;
                i1 = 0;
                break;
            }
            if ((i3 > paramInt1) && (paramList[(i3 - 1)] == i5)) {
                paramStrBuilder.deleteCharAt(i3 - 1);
                paramList = paramStrBuilder.buffer;
                k -= 1;
                m = 1;
                j -= 1;
                i = i3;
            } else {
                int n = i3 + i2;
                for (; ; ) {
                    i = n;
                    if (n >= j) {
                        break;
                    }
                    i = localStrMatcher2.isMatch(paramList, n, paramInt1, j);
                    if (i != 0) {
                        break label200;
                    }
                    n += 1;
                }
                label200:
                String str = new String(paramList, i3 + i2, n - i3 - i2);
                int i4 = n + i;
                localObject1 = localObject2;
                if (localObject2 == null) {
                    localObject1 = new ArrayList();
                    ((List) localObject1).add(new String(paramList, paramInt1, paramInt2));
                }
                checkCyclicSubstitution(str, (List) localObject1);
                ((List) localObject1).add(str);
                localObject2 = resolveVariable(str, paramStrBuilder, i3, i4);
                i2 = j;
                n = k;
                i = i4;
                if (localObject2 != null) {
                    i = ((String) localObject2).length();
                    paramStrBuilder.replace(i3, i4, (String) localObject2);
                    m = 1;
                    n = substitute(paramStrBuilder, i3, i, (List) localObject1) + (i - (i4 - i3));
                    i = i4 + n;
                    i2 = j + n;
                    n = k + n;
                    paramList = paramStrBuilder.buffer;
                }
                ((List) localObject1).remove(((List) localObject1).size() - 1);
                j = i2;
                k = n;
                localObject2 = localObject1;
            }
        }
        label418:
        if (i1 != 0) {
            if (m != 0) {
                return 1;
            }
            return 0;
        }
        return k;
    }

    public char getEscapeChar() {
        return this.escapeChar;
    }

    public StrMatcher getVariablePrefixMatcher() {
        return this.prefixMatcher;
    }

    public StrLookup getVariableResolver() {
        return this.variableResolver;
    }

    public StrMatcher getVariableSuffixMatcher() {
        return this.suffixMatcher;
    }

    public String replace(Object paramObject) {
        if (paramObject == null) {
            return null;
        }
        paramObject = new StrBuilder().append(paramObject);
        substitute((StrBuilder) paramObject, 0, ((StrBuilder) paramObject).length());
        return ((StrBuilder) paramObject).toString();
    }

    public String replace(String paramString) {
        String str;
        if (paramString == null) {
            str = null;
        }
        StrBuilder localStrBuilder;
        do {
            return str;
            localStrBuilder = new StrBuilder(paramString);
            str = paramString;
        } while (!substitute(localStrBuilder, 0, paramString.length()));
        return localStrBuilder.toString();
    }

    public String replace(String paramString, int paramInt1, int paramInt2) {
        if (paramString == null) {
            return null;
        }
        StrBuilder localStrBuilder = new StrBuilder(paramInt2).append(paramString, paramInt1, paramInt2);
        if (!substitute(localStrBuilder, 0, paramInt2)) {
            return paramString.substring(paramInt1, paramInt1 + paramInt2);
        }
        return localStrBuilder.toString();
    }

    public String replace(StringBuffer paramStringBuffer) {
        if (paramStringBuffer == null) {
            return null;
        }
        paramStringBuffer = new StrBuilder(paramStringBuffer.length()).append(paramStringBuffer);
        substitute(paramStringBuffer, 0, paramStringBuffer.length());
        return paramStringBuffer.toString();
    }

    public String replace(StringBuffer paramStringBuffer, int paramInt1, int paramInt2) {
        if (paramStringBuffer == null) {
            return null;
        }
        paramStringBuffer = new StrBuilder(paramInt2).append(paramStringBuffer, paramInt1, paramInt2);
        substitute(paramStringBuffer, 0, paramInt2);
        return paramStringBuffer.toString();
    }

    public String replace(StrBuilder paramStrBuilder) {
        if (paramStrBuilder == null) {
            return null;
        }
        paramStrBuilder = new StrBuilder(paramStrBuilder.length()).append(paramStrBuilder);
        substitute(paramStrBuilder, 0, paramStrBuilder.length());
        return paramStrBuilder.toString();
    }

    public String replace(StrBuilder paramStrBuilder, int paramInt1, int paramInt2) {
        if (paramStrBuilder == null) {
            return null;
        }
        paramStrBuilder = new StrBuilder(paramInt2).append(paramStrBuilder, paramInt1, paramInt2);
        substitute(paramStrBuilder, 0, paramInt2);
        return paramStrBuilder.toString();
    }

    public String replace(char[] paramArrayOfChar) {
        if (paramArrayOfChar == null) {
            return null;
        }
        StrBuilder localStrBuilder = new StrBuilder(paramArrayOfChar.length).append(paramArrayOfChar);
        substitute(localStrBuilder, 0, paramArrayOfChar.length);
        return localStrBuilder.toString();
    }

    public String replace(char[] paramArrayOfChar, int paramInt1, int paramInt2) {
        if (paramArrayOfChar == null) {
            return null;
        }
        paramArrayOfChar = new StrBuilder(paramInt2).append(paramArrayOfChar, paramInt1, paramInt2);
        substitute(paramArrayOfChar, 0, paramInt2);
        return paramArrayOfChar.toString();
    }

    public boolean replaceIn(StringBuffer paramStringBuffer) {
        if (paramStringBuffer == null) {
            return false;
        }
        return replaceIn(paramStringBuffer, 0, paramStringBuffer.length());
    }

    public boolean replaceIn(StringBuffer paramStringBuffer, int paramInt1, int paramInt2) {
        if (paramStringBuffer == null) {
        }
        StrBuilder localStrBuilder;
        do {
            return false;
            localStrBuilder = new StrBuilder(paramInt2).append(paramStringBuffer, paramInt1, paramInt2);
        } while (!substitute(localStrBuilder, 0, paramInt2));
        paramStringBuffer.replace(paramInt1, paramInt1 + paramInt2, localStrBuilder.toString());
        return true;
    }

    public boolean replaceIn(StrBuilder paramStrBuilder) {
        if (paramStrBuilder == null) {
            return false;
        }
        return substitute(paramStrBuilder, 0, paramStrBuilder.length());
    }

    public boolean replaceIn(StrBuilder paramStrBuilder, int paramInt1, int paramInt2) {
        if (paramStrBuilder == null) {
            return false;
        }
        return substitute(paramStrBuilder, paramInt1, paramInt2);
    }

    protected String resolveVariable(String paramString, StrBuilder paramStrBuilder, int paramInt1, int paramInt2) {
        paramStrBuilder = getVariableResolver();
        if (paramStrBuilder == null) {
            return null;
        }
        return paramStrBuilder.lookup(paramString);
    }

    public void setEscapeChar(char paramChar) {
        this.escapeChar = paramChar;
    }

    public StrSubstitutor setVariablePrefix(char paramChar) {
        return setVariablePrefixMatcher(StrMatcher.charMatcher(paramChar));
    }

    public StrSubstitutor setVariablePrefix(String paramString) {
        if (paramString == null) {
            throw new IllegalArgumentException("Variable prefix must not be null!");
        }
        return setVariablePrefixMatcher(StrMatcher.stringMatcher(paramString));
    }

    public StrSubstitutor setVariablePrefixMatcher(StrMatcher paramStrMatcher) {
        if (paramStrMatcher == null) {
            throw new IllegalArgumentException("Variable prefix matcher must not be null!");
        }
        this.prefixMatcher = paramStrMatcher;
        return this;
    }

    public void setVariableResolver(StrLookup paramStrLookup) {
        this.variableResolver = paramStrLookup;
    }

    public StrSubstitutor setVariableSuffix(char paramChar) {
        return setVariableSuffixMatcher(StrMatcher.charMatcher(paramChar));
    }

    public StrSubstitutor setVariableSuffix(String paramString) {
        if (paramString == null) {
            throw new IllegalArgumentException("Variable suffix must not be null!");
        }
        return setVariableSuffixMatcher(StrMatcher.stringMatcher(paramString));
    }

    public StrSubstitutor setVariableSuffixMatcher(StrMatcher paramStrMatcher) {
        if (paramStrMatcher == null) {
            throw new IllegalArgumentException("Variable suffix matcher must not be null!");
        }
        this.suffixMatcher = paramStrMatcher;
        return this;
    }

    protected boolean substitute(StrBuilder paramStrBuilder, int paramInt1, int paramInt2) {
        return substitute(paramStrBuilder, paramInt1, paramInt2, null) > 0;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/org/apache/commons/lang/text/StrSubstitutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */