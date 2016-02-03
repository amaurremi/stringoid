package org.apache.commons.lang;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Locale;

import org.apache.commons.lang.exception.NestableRuntimeException;

public class StringEscapeUtils {
    private static final char CSV_DELIMITER = ',';
    private static final char CSV_QUOTE = '"';
    private static final String CSV_QUOTE_STR = String.valueOf('"');
    private static final char[] CSV_SEARCH_CHARS = {44, 34, 13, 10};

    public static String escapeCsv(String paramString) {
        if (StringUtils.containsNone(paramString, CSV_SEARCH_CHARS)) {
            return paramString;
        }
        try {
            StringWriter localStringWriter = new StringWriter();
            escapeCsv(localStringWriter, paramString);
            paramString = localStringWriter.toString();
            return paramString;
        } catch (IOException paramString) {
            throw new UnhandledException(paramString);
        }
    }

    public static void escapeCsv(Writer paramWriter, String paramString)
            throws IOException {
        if (StringUtils.containsNone(paramString, CSV_SEARCH_CHARS)) {
            if (paramString != null) {
                paramWriter.write(paramString);
            }
            return;
        }
        paramWriter.write(34);
        int i = 0;
        while (i < paramString.length()) {
            int j = paramString.charAt(i);
            if (j == 34) {
                paramWriter.write(34);
            }
            paramWriter.write(j);
            i += 1;
        }
        paramWriter.write(34);
    }

    public static String escapeHtml(String paramString) {
        if (paramString == null) {
            return null;
        }
        try {
            StringWriter localStringWriter = new StringWriter((int) (paramString.length() * 1.5D));
            escapeHtml(localStringWriter, paramString);
            paramString = localStringWriter.toString();
            return paramString;
        } catch (IOException paramString) {
            throw new UnhandledException(paramString);
        }
    }

    public static void escapeHtml(Writer paramWriter, String paramString)
            throws IOException {
        if (paramWriter == null) {
            throw new IllegalArgumentException("The Writer must not be null.");
        }
        if (paramString == null) {
            return;
        }
        Entities.HTML40.escape(paramWriter, paramString);
    }

    public static String escapeJava(String paramString) {
        return escapeJavaStyleString(paramString, false, false);
    }

    public static void escapeJava(Writer paramWriter, String paramString)
            throws IOException {
        escapeJavaStyleString(paramWriter, paramString, false, false);
    }

    public static String escapeJavaScript(String paramString) {
        return escapeJavaStyleString(paramString, true, true);
    }

    public static void escapeJavaScript(Writer paramWriter, String paramString)
            throws IOException {
        escapeJavaStyleString(paramWriter, paramString, true, true);
    }

    private static String escapeJavaStyleString(String paramString, boolean paramBoolean1, boolean paramBoolean2) {
        if (paramString == null) {
            return null;
        }
        try {
            StringWriter localStringWriter = new StringWriter(paramString.length() * 2);
            escapeJavaStyleString(localStringWriter, paramString, paramBoolean1, paramBoolean2);
            paramString = localStringWriter.toString();
            return paramString;
        } catch (IOException paramString) {
            throw new UnhandledException(paramString);
        }
    }

    private static void escapeJavaStyleString(Writer paramWriter, String paramString, boolean paramBoolean1, boolean paramBoolean2)
            throws IOException {
        if (paramWriter == null) {
            throw new IllegalArgumentException("The Writer must not be null");
        }
        if (paramString == null) {
            return;
        }
        int j = paramString.length();
        int i = 0;
        label28:
        char c;
        if (i < j) {
            c = paramString.charAt(i);
            if (c <= '࿿') {
                break label87;
            }
            paramWriter.write("\\u" + hex(c));
        }
        for (; ; ) {
            i += 1;
            break label28;
            break;
            label87:
            if (c > 'ÿ') {
                paramWriter.write("\\u0" + hex(c));
            } else if (c > '') {
                paramWriter.write("\\u00" + hex(c));
            } else if (c < ' ') {
                switch (c) {
                    case '\013':
                    default:
                        if (c > '\017') {
                            paramWriter.write("\\u00" + hex(c));
                        }
                        break;
                    case '\b':
                        paramWriter.write(92);
                        paramWriter.write(98);
                        break;
                    case '\n':
                        paramWriter.write(92);
                        paramWriter.write(110);
                        break;
                    case '\t':
                        paramWriter.write(92);
                        paramWriter.write(116);
                        break;
                    case '\f':
                        paramWriter.write(92);
                        paramWriter.write(102);
                        break;
                    case '\r':
                        paramWriter.write(92);
                        paramWriter.write(114);
                        continue;
                        paramWriter.write("\\u000" + hex(c));
                        break;
                }
            } else {
                switch (c) {
                    default:
                        paramWriter.write(c);
                        break;
                    case '\'':
                        if (paramBoolean1) {
                            paramWriter.write(92);
                        }
                        paramWriter.write(39);
                        break;
                    case '"':
                        paramWriter.write(92);
                        paramWriter.write(34);
                        break;
                    case '\\':
                        paramWriter.write(92);
                        paramWriter.write(92);
                        break;
                    case '/':
                        if (paramBoolean2) {
                            paramWriter.write(92);
                        }
                        paramWriter.write(47);
                }
            }
        }
    }

    public static String escapeSql(String paramString) {
        if (paramString == null) {
            return null;
        }
        return StringUtils.replace(paramString, "'", "''");
    }

    public static String escapeXml(String paramString) {
        if (paramString == null) {
            return null;
        }
        return Entities.XML.escape(paramString);
    }

    public static void escapeXml(Writer paramWriter, String paramString)
            throws IOException {
        if (paramWriter == null) {
            throw new IllegalArgumentException("The Writer must not be null.");
        }
        if (paramString == null) {
            return;
        }
        Entities.XML.escape(paramWriter, paramString);
    }

    private static String hex(char paramChar) {
        return Integer.toHexString(paramChar).toUpperCase(Locale.ENGLISH);
    }

    public static String unescapeCsv(String paramString) {
        if (paramString == null) {
            return null;
        }
        try {
            StringWriter localStringWriter = new StringWriter();
            unescapeCsv(localStringWriter, paramString);
            paramString = localStringWriter.toString();
            return paramString;
        } catch (IOException paramString) {
            throw new UnhandledException(paramString);
        }
    }

    public static void unescapeCsv(Writer paramWriter, String paramString)
            throws IOException {
        if (paramString == null) {
            return;
        }
        if (paramString.length() < 2) {
            paramWriter.write(paramString);
            return;
        }
        if ((paramString.charAt(0) != '"') || (paramString.charAt(paramString.length() - 1) != '"')) {
            paramWriter.write(paramString);
            return;
        }
        String str = paramString.substring(1, paramString.length() - 1);
        if (StringUtils.containsAny(str, CSV_SEARCH_CHARS)) {
            paramString = StringUtils.replace(str, CSV_QUOTE_STR + CSV_QUOTE_STR, CSV_QUOTE_STR);
        }
        paramWriter.write(paramString);
    }

    public static String unescapeHtml(String paramString) {
        if (paramString == null) {
            return null;
        }
        try {
            StringWriter localStringWriter = new StringWriter((int) (paramString.length() * 1.5D));
            unescapeHtml(localStringWriter, paramString);
            paramString = localStringWriter.toString();
            return paramString;
        } catch (IOException paramString) {
            throw new UnhandledException(paramString);
        }
    }

    public static void unescapeHtml(Writer paramWriter, String paramString)
            throws IOException {
        if (paramWriter == null) {
            throw new IllegalArgumentException("The Writer must not be null.");
        }
        if (paramString == null) {
            return;
        }
        Entities.HTML40.unescape(paramWriter, paramString);
    }

    public static String unescapeJava(String paramString) {
        if (paramString == null) {
            return null;
        }
        try {
            StringWriter localStringWriter = new StringWriter(paramString.length());
            unescapeJava(localStringWriter, paramString);
            paramString = localStringWriter.toString();
            return paramString;
        } catch (IOException paramString) {
            throw new UnhandledException(paramString);
        }
    }

    public static void unescapeJava(Writer paramWriter, String paramString)
            throws IOException {
        if (paramWriter == null) {
            throw new IllegalArgumentException("The Writer must not be null");
        }
        if (paramString == null) {
        }
        int i;
        do {
            return;
            int m = paramString.length();
            StringBuffer localStringBuffer = new StringBuffer(4);
            i = 0;
            int j = 0;
            int k = 0;
            if (k < m) {
                char c = paramString.charAt(k);
                if (j != 0) {
                    localStringBuffer.append(c);
                    if (localStringBuffer.length() != 4) {
                    }
                }
                for (; ; ) {
                    try {
                        paramWriter.write((char) Integer.parseInt(localStringBuffer.toString(), 16));
                        localStringBuffer.setLength(0);
                        j = 0;
                        i = 0;
                        k += 1;
                    } catch (NumberFormatException paramWriter) {
                        throw new NestableRuntimeException("Unable to parse unicode value: " + localStringBuffer, paramWriter);
                    }
                    if (i != 0) {
                        i = 0;
                        switch (c) {
                            default:
                                paramWriter.write(c);
                                break;
                            case '\\':
                                paramWriter.write(92);
                                break;
                            case '\'':
                                paramWriter.write(39);
                                break;
                            case '"':
                                paramWriter.write(34);
                                break;
                            case 'r':
                                paramWriter.write(13);
                                break;
                            case 'f':
                                paramWriter.write(12);
                                break;
                            case 't':
                                paramWriter.write(9);
                                break;
                            case 'n':
                                paramWriter.write(10);
                                break;
                            case 'b':
                                paramWriter.write(8);
                                break;
                            case 'u':
                                j = 1;
                                break;
                        }
                    } else if (c == '\\') {
                        i = 1;
                    } else {
                        paramWriter.write(c);
                    }
                }
            }
        } while (i == 0);
        paramWriter.write(92);
    }

    public static String unescapeJavaScript(String paramString) {
        return unescapeJava(paramString);
    }

    public static void unescapeJavaScript(Writer paramWriter, String paramString)
            throws IOException {
        unescapeJava(paramWriter, paramString);
    }

    public static String unescapeXml(String paramString) {
        if (paramString == null) {
            return null;
        }
        return Entities.XML.unescape(paramString);
    }

    public static void unescapeXml(Writer paramWriter, String paramString)
            throws IOException {
        if (paramWriter == null) {
            throw new IllegalArgumentException("The Writer must not be null.");
        }
        if (paramString == null) {
            return;
        }
        Entities.XML.unescape(paramWriter, paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/org/apache/commons/lang/StringEscapeUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */