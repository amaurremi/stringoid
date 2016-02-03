package org.apache.commons.lang;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class Entities {
    private static final String[][] APOS_ARRAY;
    private static final String[][] BASIC_ARRAY = {{"quot", "34"}, {"amp", "38"}, {"lt", "60"}, {"gt", "62"}};
    public static final Entities HTML32;
    public static final Entities HTML40;
    static final String[][] HTML40_ARRAY;
    static final String[][] ISO8859_1_ARRAY;
    public static final Entities XML;
    private final EntityMap map;

    static {
        APOS_ARRAY = new String[][]{{"apos", "39"}};
        Object localObject = {"nbsp", "160"};
        String[] arrayOfString1 = {"iexcl", "161"};
        String[] arrayOfString2 = {"cent", "162"};
        String[] arrayOfString3 = {"curren", "164"};
        String[] arrayOfString4 = {"brvbar", "166"};
        String[] arrayOfString5 = {"sect", "167"};
        String[] arrayOfString6 = {"uml", "168"};
        String[] arrayOfString7 = {"copy", "169"};
        String[] arrayOfString8 = {"ordf", "170"};
        String[] arrayOfString9 = {"laquo", "171"};
        String[] arrayOfString10 = {"not", "172"};
        String[] arrayOfString11 = {"shy", "173"};
        String[] arrayOfString12 = {"reg", "174"};
        String[] arrayOfString13 = {"macr", "175"};
        String[] arrayOfString14 = {"deg", "176"};
        String[] arrayOfString15 = {"plusmn", "177"};
        String[] arrayOfString16 = {"sup2", "178"};
        String[] arrayOfString17 = {"sup3", "179"};
        String[] arrayOfString18 = {"acute", "180"};
        String[] arrayOfString19 = {"micro", "181"};
        String[] arrayOfString20 = {"para", "182"};
        String[] arrayOfString21 = {"middot", "183"};
        String[] arrayOfString22 = {"cedil", "184"};
        String[] arrayOfString23 = {"sup1", "185"};
        String[] arrayOfString24 = {"ordm", "186"};
        String[] arrayOfString25 = {"raquo", "187"};
        String[] arrayOfString26 = {"frac12", "189"};
        String[] arrayOfString27 = {"frac34", "190"};
        String[] arrayOfString28 = {"iquest", "191"};
        String[] arrayOfString29 = {"Agrave", "192"};
        String[] arrayOfString30 = {"Aacute", "193"};
        String[] arrayOfString31 = {"Acirc", "194"};
        String[] arrayOfString32 = {"Atilde", "195"};
        String[] arrayOfString33 = {"Auml", "196"};
        String[] arrayOfString34 = {"Aring", "197"};
        String[] arrayOfString35 = {"AElig", "198"};
        String[] arrayOfString36 = {"Ccedil", "199"};
        String[] arrayOfString37 = {"Eacute", "201"};
        String[] arrayOfString38 = {"Ecirc", "202"};
        String[] arrayOfString39 = {"Euml", "203"};
        String[] arrayOfString40 = {"Iacute", "205"};
        String[] arrayOfString41 = {"Icirc", "206"};
        String[] arrayOfString42 = {"Iuml", "207"};
        String[] arrayOfString43 = {"ETH", "208"};
        String[] arrayOfString44 = {"Ntilde", "209"};
        String[] arrayOfString45 = {"Ograve", "210"};
        String[] arrayOfString46 = {"Ocirc", "212"};
        String[] arrayOfString47 = {"Otilde", "213"};
        String[] arrayOfString48 = {"Oslash", "216"};
        String[] arrayOfString49 = {"Ugrave", "217"};
        String[] arrayOfString50 = {"Uacute", "218"};
        String[] arrayOfString51 = {"Ucirc", "219"};
        String[] arrayOfString52 = {"Uuml", "220"};
        String[] arrayOfString53 = {"Yacute", "221"};
        String[] arrayOfString54 = {"THORN", "222"};
        String[] arrayOfString55 = {"szlig", "223"};
        String[] arrayOfString56 = {"agrave", "224"};
        String[] arrayOfString57 = {"aacute", "225"};
        String[] arrayOfString58 = {"acirc", "226"};
        String[] arrayOfString59 = {"auml", "228"};
        String[] arrayOfString60 = {"aring", "229"};
        String[] arrayOfString61 = {"aelig", "230"};
        String[] arrayOfString62 = {"ccedil", "231"};
        String[] arrayOfString63 = {"ecirc", "234"};
        String[] arrayOfString64 = {"euml", "235"};
        String[] arrayOfString65 = {"igrave", "236"};
        String[] arrayOfString66 = {"iacute", "237"};
        String[] arrayOfString67 = {"icirc", "238"};
        String[] arrayOfString68 = {"iuml", "239"};
        String[] arrayOfString69 = {"eth", "240"};
        String[] arrayOfString70 = {"ntilde", "241"};
        String[] arrayOfString71 = {"ograve", "242"};
        String[] arrayOfString72 = {"oacute", "243"};
        String[] arrayOfString73 = {"ocirc", "244"};
        String[] arrayOfString74 = {"otilde", "245"};
        String[] arrayOfString75 = {"ouml", "246"};
        String[] arrayOfString76 = {"oslash", "248"};
        String[] arrayOfString77 = {"ugrave", "249"};
        String[] arrayOfString78 = {"uacute", "250"};
        String[] arrayOfString79 = {"ucirc", "251"};
        String[] arrayOfString80 = {"uuml", "252"};
        String[] arrayOfString81 = {"yacute", "253"};
        String[] arrayOfString82 = {"thorn", "254"};
        String[] arrayOfString83 = {"yuml", "255"};
        ISO8859_1_ARRAY = new String[][]{localObject, arrayOfString1, arrayOfString2, {"pound", "163"}, arrayOfString3, {"yen", "165"}, arrayOfString4, arrayOfString5, arrayOfString6, arrayOfString7, arrayOfString8, arrayOfString9, arrayOfString10, arrayOfString11, arrayOfString12, arrayOfString13, arrayOfString14, arrayOfString15, arrayOfString16, arrayOfString17, arrayOfString18, arrayOfString19, arrayOfString20, arrayOfString21, arrayOfString22, arrayOfString23, arrayOfString24, arrayOfString25, {"frac14", "188"}, arrayOfString26, arrayOfString27, arrayOfString28, arrayOfString29, arrayOfString30, arrayOfString31, arrayOfString32, arrayOfString33, arrayOfString34, arrayOfString35, arrayOfString36, {"Egrave", "200"}, arrayOfString37, arrayOfString38, arrayOfString39, {"Igrave", "204"}, arrayOfString40, arrayOfString41, arrayOfString42, arrayOfString43, arrayOfString44, arrayOfString45, {"Oacute", "211"}, arrayOfString46, arrayOfString47, {"Ouml", "214"}, {"times", "215"}, arrayOfString48, arrayOfString49, arrayOfString50, arrayOfString51, arrayOfString52, arrayOfString53, arrayOfString54, arrayOfString55, arrayOfString56, arrayOfString57, arrayOfString58, {"atilde", "227"}, arrayOfString59, arrayOfString60, arrayOfString61, arrayOfString62, {"egrave", "232"}, {"eacute", "233"}, arrayOfString63, arrayOfString64, arrayOfString65, arrayOfString66, arrayOfString67, arrayOfString68, arrayOfString69, arrayOfString70, arrayOfString71, arrayOfString72, arrayOfString73, arrayOfString74, arrayOfString75, {"divide", "247"}, arrayOfString76, arrayOfString77, arrayOfString78, arrayOfString79, arrayOfString80, arrayOfString81, arrayOfString82, arrayOfString83};
        localObject = new String[]{"Alpha", "913"};
        arrayOfString1 = new String[]{"Gamma", "915"};
        arrayOfString2 = new String[]{"Epsilon", "917"};
        arrayOfString3 = new String[]{"Zeta", "918"};
        arrayOfString4 = new String[]{"Eta", "919"};
        arrayOfString5 = new String[]{"Iota", "921"};
        arrayOfString6 = new String[]{"Lambda", "923"};
        arrayOfString7 = new String[]{"Mu", "924"};
        arrayOfString8 = new String[]{"Omicron", "927"};
        arrayOfString9 = new String[]{"Pi", "928"};
        arrayOfString10 = new String[]{"Tau", "932"};
        arrayOfString11 = new String[]{"Upsilon", "933"};
        arrayOfString12 = new String[]{"Phi", "934"};
        arrayOfString13 = new String[]{"Chi", "935"};
        arrayOfString14 = new String[]{"Psi", "936"};
        arrayOfString15 = new String[]{"Omega", "937"};
        arrayOfString16 = new String[]{"alpha", "945"};
        arrayOfString17 = new String[]{"gamma", "947"};
        arrayOfString18 = new String[]{"delta", "948"};
        arrayOfString19 = new String[]{"epsilon", "949"};
        arrayOfString20 = new String[]{"zeta", "950"};
        arrayOfString21 = new String[]{"eta", "951"};
        arrayOfString22 = new String[]{"theta", "952"};
        arrayOfString23 = new String[]{"iota", "953"};
        arrayOfString24 = new String[]{"lambda", "955"};
        arrayOfString25 = new String[]{"mu", "956"};
        arrayOfString26 = new String[]{"nu", "957"};
        arrayOfString27 = new String[]{"xi", "958"};
        arrayOfString28 = new String[]{"rho", "961"};
        arrayOfString29 = new String[]{"tau", "964"};
        arrayOfString30 = new String[]{"chi", "967"};
        arrayOfString31 = new String[]{"omega", "969"};
        arrayOfString32 = new String[]{"upsih", "978"};
        arrayOfString33 = new String[]{"piv", "982"};
        arrayOfString34 = new String[]{"hellip", "8230"};
        arrayOfString35 = new String[]{"Prime", "8243"};
        arrayOfString36 = new String[]{"oline", "8254"};
        arrayOfString37 = new String[]{"frasl", "8260"};
        arrayOfString38 = new String[]{"image", "8465"};
        arrayOfString39 = new String[]{"real", "8476"};
        arrayOfString40 = new String[]{"trade", "8482"};
        arrayOfString41 = new String[]{"alefsym", "8501"};
        arrayOfString42 = new String[]{"larr", "8592"};
        arrayOfString43 = new String[]{"uarr", "8593"};
        arrayOfString44 = new String[]{"darr", "8595"};
        arrayOfString45 = new String[]{"harr", "8596"};
        arrayOfString46 = new String[]{"uArr", "8657"};
        arrayOfString47 = new String[]{"hArr", "8660"};
        arrayOfString48 = new String[]{"nabla", "8711"};
        arrayOfString49 = new String[]{"isin", "8712"};
        arrayOfString50 = new String[]{"prod", "8719"};
        arrayOfString51 = new String[]{"sum", "8721"};
        arrayOfString52 = new String[]{"minus", "8722"};
        arrayOfString53 = new String[]{"radic", "8730"};
        arrayOfString54 = new String[]{"prop", "8733"};
        arrayOfString55 = new String[]{"ang", "8736"};
        arrayOfString56 = new String[]{"and", "8743"};
        arrayOfString57 = new String[]{"or", "8744"};
        arrayOfString58 = new String[]{"cap", "8745"};
        arrayOfString59 = new String[]{"cup", "8746"};
        arrayOfString60 = new String[]{"there4", "8756"};
        arrayOfString61 = new String[]{"sim", "8764"};
        arrayOfString62 = new String[]{"cong", "8773"};
        arrayOfString63 = new String[]{"asymp", "8776"};
        arrayOfString64 = new String[]{"ne", "8800"};
        arrayOfString65 = new String[]{"equiv", "8801"};
        arrayOfString66 = new String[]{"le", "8804"};
        arrayOfString67 = new String[]{"ge", "8805"};
        arrayOfString68 = new String[]{"sub", "8834"};
        arrayOfString69 = new String[]{"sup", "8835"};
        arrayOfString70 = new String[]{"sube", "8838"};
        arrayOfString71 = new String[]{"supe", "8839"};
        arrayOfString72 = new String[]{"oplus", "8853"};
        arrayOfString73 = new String[]{"perp", "8869"};
        arrayOfString74 = new String[]{"sdot", "8901"};
        arrayOfString75 = new String[]{"lceil", "8968"};
        arrayOfString76 = new String[]{"rfloor", "8971"};
        arrayOfString77 = new String[]{"rang", "9002"};
        arrayOfString78 = new String[]{"spades", "9824"};
        arrayOfString79 = new String[]{"clubs", "9827"};
        arrayOfString80 = new String[]{"hearts", "9829"};
        arrayOfString81 = new String[]{"diams", "9830"};
        arrayOfString82 = new String[]{"OElig", "338"};
        arrayOfString83 = new String[]{"oelig", "339"};
        String[] arrayOfString84 = {"Scaron", "352"};
        String[] arrayOfString85 = {"scaron", "353"};
        String[] arrayOfString86 = {"Yuml", "376"};
        String[] arrayOfString87 = {"circ", "710"};
        String[] arrayOfString88 = {"tilde", "732"};
        String[] arrayOfString89 = {"ensp", "8194"};
        String[] arrayOfString90 = {"zwnj", "8204"};
        String[] arrayOfString91 = {"zwj", "8205"};
        String[] arrayOfString92 = {"rlm", "8207"};
        String[] arrayOfString93 = {"ndash", "8211"};
        String[] arrayOfString94 = {"lsquo", "8216"};
        String[] arrayOfString95 = {"rsquo", "8217"};
        String[] arrayOfString96 = {"sbquo", "8218"};
        String[] arrayOfString97 = {"ldquo", "8220"};
        String[] arrayOfString98 = {"bdquo", "8222"};
        String[] arrayOfString99 = {"Dagger", "8225"};
        String[] arrayOfString100 = {"permil", "8240"};
        String[] arrayOfString101 = {"rsaquo", "8250"};
        String[] arrayOfString102 = {"euro", "8364"};
        HTML40_ARRAY = new String[][]{{"fnof", "402"}, localObject, {"Beta", "914"}, arrayOfString1, {"Delta", "916"}, arrayOfString2, arrayOfString3, arrayOfString4, {"Theta", "920"}, arrayOfString5, {"Kappa", "922"}, arrayOfString6, arrayOfString7, {"Nu", "925"}, {"Xi", "926"}, arrayOfString8, arrayOfString9, {"Rho", "929"}, {"Sigma", "931"}, arrayOfString10, arrayOfString11, arrayOfString12, arrayOfString13, arrayOfString14, arrayOfString15, arrayOfString16, {"beta", "946"}, arrayOfString17, arrayOfString18, arrayOfString19, arrayOfString20, arrayOfString21, arrayOfString22, arrayOfString23, {"kappa", "954"}, arrayOfString24, arrayOfString25, arrayOfString26, arrayOfString27, {"omicron", "959"}, {"pi", "960"}, arrayOfString28, {"sigmaf", "962"}, {"sigma", "963"}, arrayOfString29, {"upsilon", "965"}, {"phi", "966"}, arrayOfString30, {"psi", "968"}, arrayOfString31, {"thetasym", "977"}, arrayOfString32, arrayOfString33, {"bull", "8226"}, arrayOfString34, {"prime", "8242"}, arrayOfString35, arrayOfString36, arrayOfString37, {"weierp", "8472"}, arrayOfString38, arrayOfString39, arrayOfString40, arrayOfString41, arrayOfString42, arrayOfString43, {"rarr", "8594"}, arrayOfString44, arrayOfString45, {"crarr", "8629"}, {"lArr", "8656"}, arrayOfString46, {"rArr", "8658"}, {"dArr", "8659"}, arrayOfString47, {"forall", "8704"}, {"part", "8706"}, {"exist", "8707"}, {"empty", "8709"}, arrayOfString48, arrayOfString49, {"notin", "8713"}, {"ni", "8715"}, arrayOfString50, arrayOfString51, arrayOfString52, {"lowast", "8727"}, arrayOfString53, arrayOfString54, {"infin", "8734"}, arrayOfString55, arrayOfString56, arrayOfString57, arrayOfString58, arrayOfString59, {"int", "8747"}, arrayOfString60, arrayOfString61, arrayOfString62, arrayOfString63, arrayOfString64, arrayOfString65, arrayOfString66, arrayOfString67, arrayOfString68, arrayOfString69, arrayOfString70, arrayOfString71, arrayOfString72, {"otimes", "8855"}, arrayOfString73, arrayOfString74, arrayOfString75, {"rceil", "8969"}, {"lfloor", "8970"}, arrayOfString76, {"lang", "9001"}, arrayOfString77, {"loz", "9674"}, arrayOfString78, arrayOfString79, arrayOfString80, arrayOfString81, arrayOfString82, arrayOfString83, arrayOfString84, arrayOfString85, arrayOfString86, arrayOfString87, arrayOfString88, arrayOfString89, {"emsp", "8195"}, {"thinsp", "8201"}, arrayOfString90, arrayOfString91, {"lrm", "8206"}, arrayOfString92, arrayOfString93, {"mdash", "8212"}, arrayOfString94, arrayOfString95, arrayOfString96, arrayOfString97, {"rdquo", "8221"}, arrayOfString98, {"dagger", "8224"}, arrayOfString99, arrayOfString100, {"lsaquo", "8249"}, arrayOfString101, arrayOfString102};
        localObject = new Entities();
        ((Entities) localObject).addEntities(BASIC_ARRAY);
        ((Entities) localObject).addEntities(APOS_ARRAY);
        XML = (Entities) localObject;
        localObject = new Entities();
        ((Entities) localObject).addEntities(BASIC_ARRAY);
        ((Entities) localObject).addEntities(ISO8859_1_ARRAY);
        HTML32 = (Entities) localObject;
        localObject = new Entities();
        fillWithHtml40Entities((Entities) localObject);
        HTML40 = (Entities) localObject;
    }

    public Entities() {
        this.map = new LookupEntityMap();
    }

    Entities(EntityMap paramEntityMap) {
        this.map = paramEntityMap;
    }

    private StringWriter createStringWriter(String paramString) {
        return new StringWriter((int) (paramString.length() + paramString.length() * 0.1D));
    }

    private void doUnescape(Writer paramWriter, String paramString, int paramInt)
            throws IOException {
        paramWriter.write(paramString, 0, paramInt);
        int k = paramString.length();
        if (paramInt < k) {
            int i = paramString.charAt(paramInt);
            int m;
            int j;
            if (i == 38) {
                m = paramInt + 1;
                j = paramString.indexOf(';', m);
                if (j == -1) {
                    paramWriter.write(i);
                }
            }
            for (; ; ) {
                paramInt += 1;
                break;
                int n = paramString.indexOf('&', paramInt + 1);
                if ((n != -1) && (n < j)) {
                    paramWriter.write(i);
                } else {
                    String str = paramString.substring(m, j);
                    i = -1;
                    m = str.length();
                    paramInt = i;
                    if (m > 0) {
                        if (str.charAt(0) != '#') {
                            break label258;
                        }
                        paramInt = i;
                        if (m > 1) {
                            switch (str.charAt(1)) {
                            }
                        }
                    }
                    try {
                        i = Integer.parseInt(str.substring(1), 10);
                        label193:
                        paramInt = i;
                        if (i > 65535) {
                            paramInt = -1;
                        }
                    } catch (NumberFormatException localNumberFormatException) {
                        for (; ; ) {
                            label206:
                            paramInt = -1;
                        }
                    }
                    if (paramInt == -1) {
                        paramWriter.write(38);
                        paramWriter.write(str);
                        paramWriter.write(59);
                    }
                    for (; ; ) {
                        paramInt = j;
                        break;
                        i = Integer.parseInt(str.substring(2), 16);
                        break label193;
                        label258:
                        paramInt = entityValue(str);
                        break label206;
                        paramWriter.write(paramInt);
                    }
                    paramWriter.write(i);
                }
            }
        }
    }

    static void fillWithHtml40Entities(Entities paramEntities) {
        paramEntities.addEntities(BASIC_ARRAY);
        paramEntities.addEntities(ISO8859_1_ARRAY);
        paramEntities.addEntities(HTML40_ARRAY);
    }

    public void addEntities(String[][] paramArrayOfString) {
        int i = 0;
        while (i < paramArrayOfString.length) {
            addEntity(paramArrayOfString[i][0], Integer.parseInt(paramArrayOfString[i][1]));
            i += 1;
        }
    }

    public void addEntity(String paramString, int paramInt) {
        this.map.add(paramString, paramInt);
    }

    public String entityName(int paramInt) {
        return this.map.name(paramInt);
    }

    public int entityValue(String paramString) {
        return this.map.value(paramString);
    }

    public String escape(String paramString) {
        StringWriter localStringWriter = createStringWriter(paramString);
        try {
            escape(localStringWriter, paramString);
            return localStringWriter.toString();
        } catch (IOException paramString) {
            throw new UnhandledException(paramString);
        }
    }

    public void escape(Writer paramWriter, String paramString)
            throws IOException {
        int j = paramString.length();
        int i = 0;
        if (i < j) {
            int k = paramString.charAt(i);
            String str = entityName(k);
            if (str == null) {
                if (k > 127) {
                    paramWriter.write("&#");
                    paramWriter.write(Integer.toString(k, 10));
                    paramWriter.write(59);
                }
            }
            for (; ; ) {
                i += 1;
                break;
                paramWriter.write(k);
                continue;
                paramWriter.write(38);
                paramWriter.write(str);
                paramWriter.write(59);
            }
        }
    }

    public String unescape(String paramString) {
        int i = paramString.indexOf('&');
        if (i < 0) {
            return paramString;
        }
        StringWriter localStringWriter = createStringWriter(paramString);
        try {
            doUnescape(localStringWriter, paramString, i);
            return localStringWriter.toString();
        } catch (IOException paramString) {
            throw new UnhandledException(paramString);
        }
    }

    public void unescape(Writer paramWriter, String paramString)
            throws IOException {
        int i = paramString.indexOf('&');
        if (i < 0) {
            paramWriter.write(paramString);
            return;
        }
        doUnescape(paramWriter, paramString, i);
    }

    static class ArrayEntityMap
            implements Entities.EntityMap {
        protected final int growBy;
        protected String[] names;
        protected int size = 0;
        protected int[] values;

        public ArrayEntityMap() {
            this.growBy = 100;
            this.names = new String[this.growBy];
            this.values = new int[this.growBy];
        }

        public ArrayEntityMap(int paramInt) {
            this.growBy = paramInt;
            this.names = new String[paramInt];
            this.values = new int[paramInt];
        }

        public void add(String paramString, int paramInt) {
            ensureCapacity(this.size + 1);
            this.names[this.size] = paramString;
            this.values[this.size] = paramInt;
            this.size += 1;
        }

        protected void ensureCapacity(int paramInt) {
            if (paramInt > this.names.length) {
                paramInt = Math.max(paramInt, this.size + this.growBy);
                Object localObject = new String[paramInt];
                System.arraycopy(this.names, 0, localObject, 0, this.size);
                this.names = ((String[]) localObject);
                localObject = new int[paramInt];
                System.arraycopy(this.values, 0, localObject, 0, this.size);
                this.values = ((int[]) localObject);
            }
        }

        public String name(int paramInt) {
            int i = 0;
            while (i < this.size) {
                if (this.values[i] == paramInt) {
                    return this.names[i];
                }
                i += 1;
            }
            return null;
        }

        public int value(String paramString) {
            int i = 0;
            while (i < this.size) {
                if (this.names[i].equals(paramString)) {
                    return this.values[i];
                }
                i += 1;
            }
            return -1;
        }
    }

    static class BinaryEntityMap
            extends Entities.ArrayEntityMap {
        public BinaryEntityMap() {
        }

        public BinaryEntityMap(int paramInt) {
            super();
        }

        private int binarySearch(int paramInt) {
            int i = 0;
            int j = this.size - 1;
            while (i <= j) {
                int k = i + j >>> 1;
                int m = this.values[k];
                if (m < paramInt) {
                    i = k + 1;
                } else {
                    j = k;
                    if (m <= paramInt) {
                        return j;
                    }
                    j = k - 1;
                }
            }
            j = -(i + 1);
            return j;
        }

        public void add(String paramString, int paramInt) {
            ensureCapacity(this.size + 1);
            int i = binarySearch(paramInt);
            if (i > 0) {
                return;
            }
            i = -(i + 1);
            System.arraycopy(this.values, i, this.values, i + 1, this.size - i);
            this.values[i] = paramInt;
            System.arraycopy(this.names, i, this.names, i + 1, this.size - i);
            this.names[i] = paramString;
            this.size += 1;
        }

        public String name(int paramInt) {
            paramInt = binarySearch(paramInt);
            if (paramInt < 0) {
                return null;
            }
            return this.names[paramInt];
        }
    }

    static abstract interface EntityMap {
        public abstract void add(String paramString, int paramInt);

        public abstract String name(int paramInt);

        public abstract int value(String paramString);
    }

    static class HashEntityMap
            extends Entities.MapIntMap {
        public HashEntityMap() {
            super(new HashMap());
        }
    }

    static class LookupEntityMap
            extends Entities.PrimitiveEntityMap {
        private final int LOOKUP_TABLE_SIZE = 256;
        private String[] lookupTable;

        private void createLookupTable() {
            this.lookupTable = new String['Ā'];
            int i = 0;
            while (i < 256) {
                this.lookupTable[i] = super.name(i);
                i += 1;
            }
        }

        private String[] lookupTable() {
            if (this.lookupTable == null) {
                createLookupTable();
            }
            return this.lookupTable;
        }

        public String name(int paramInt) {
            if (paramInt < 256) {
                return lookupTable()[paramInt];
            }
            return super.name(paramInt);
        }
    }

    static abstract class MapIntMap
            implements Entities.EntityMap {
        protected final Map mapNameToValue;
        protected final Map mapValueToName;

        MapIntMap(Map paramMap1, Map paramMap2) {
            this.mapNameToValue = paramMap1;
            this.mapValueToName = paramMap2;
        }

        public void add(String paramString, int paramInt) {
            this.mapNameToValue.put(paramString, new Integer(paramInt));
            this.mapValueToName.put(new Integer(paramInt), paramString);
        }

        public String name(int paramInt) {
            return (String) this.mapValueToName.get(new Integer(paramInt));
        }

        public int value(String paramString) {
            paramString = this.mapNameToValue.get(paramString);
            if (paramString == null) {
                return -1;
            }
            return ((Integer) paramString).intValue();
        }
    }

    static class PrimitiveEntityMap
            implements Entities.EntityMap {
        private final Map mapNameToValue = new HashMap();
        private final IntHashMap mapValueToName = new IntHashMap();

        public void add(String paramString, int paramInt) {
            this.mapNameToValue.put(paramString, new Integer(paramInt));
            this.mapValueToName.put(paramInt, paramString);
        }

        public String name(int paramInt) {
            return (String) this.mapValueToName.get(paramInt);
        }

        public int value(String paramString) {
            paramString = this.mapNameToValue.get(paramString);
            if (paramString == null) {
                return -1;
            }
            return ((Integer) paramString).intValue();
        }
    }

    static class TreeEntityMap
            extends Entities.MapIntMap {
        public TreeEntityMap() {
            super(new TreeMap());
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/org/apache/commons/lang/Entities.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */