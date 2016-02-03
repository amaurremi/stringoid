package mobi.beyondpod.rsscore.helpers;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetectEncoding
{
  private static final String TAG = DetectEncoding.class.getSimpleName();
  static Map<String, String> encoding_map = getEncodingMap();
  private int bomLength = 0;
  String defaultEncoding;
  private boolean error = false;
  private boolean isJson = false;
  final Magic[] magics = { new Magic("utf-32be", true, 0, 0, -2, -1), new Magic("utf-32le", true, -1, -2, 0, 0), new Magic("USC-4odd", true, 0, 0, -1, -2), new Magic("USC-4odder", true, -2, -1, 0, 0), new Magic("utf-16be", true, -2, -1), new Magic("utf-16le", true, -1, -2), new Magic("utf-8", true, -17, -69, -65), new Magic("utf-32be", false, 0, 0, 0, 60), new Magic("utf-32le", false, 60, 0, 0, 0), new Magic("USC-4 ASCII 2143", false, 0, 0, 60, 0), new Magic("USC-4 ASCII 3412", false, 0, 60, 0, 0), new Magic("utf-16be", false, 0, 60, 0, 63), new Magic("utf-16le", false, 60, 0, 63, 0), new Magic("UTF-8", false, 60, 63, 120, 109), new Magic("EBCDIC", false, 76, 111, -89, -108) };
  
  public DetectEncoding(String paramString)
  {
    this.defaultEncoding = paramString;
  }
  
  private byte[] asciiToEbcdic(byte[] paramArrayOfByte)
  {
    int[] arrayOfInt = new int['Ā'];
    arrayOfInt[1] = 1;
    arrayOfInt[2] = 2;
    arrayOfInt[3] = 3;
    arrayOfInt[4] = 156;
    arrayOfInt[5] = 9;
    arrayOfInt[6] = 134;
    arrayOfInt[7] = 127;
    arrayOfInt[8] = 151;
    arrayOfInt[9] = 141;
    arrayOfInt[10] = 142;
    arrayOfInt[11] = 11;
    arrayOfInt[12] = 12;
    arrayOfInt[13] = 13;
    arrayOfInt[14] = 14;
    arrayOfInt[15] = 15;
    arrayOfInt[16] = 16;
    arrayOfInt[17] = 17;
    arrayOfInt[18] = 18;
    arrayOfInt[19] = 19;
    arrayOfInt[20] = 157;
    arrayOfInt[21] = 133;
    arrayOfInt[22] = 8;
    arrayOfInt[23] = 135;
    arrayOfInt[24] = 24;
    arrayOfInt[25] = 25;
    arrayOfInt[26] = 146;
    arrayOfInt[27] = 143;
    arrayOfInt[28] = 28;
    arrayOfInt[29] = 29;
    arrayOfInt[30] = 30;
    arrayOfInt[31] = 31;
    arrayOfInt[32] = 128;
    arrayOfInt[33] = 129;
    arrayOfInt[34] = 130;
    arrayOfInt[35] = 131;
    arrayOfInt[36] = 132;
    arrayOfInt[37] = 10;
    arrayOfInt[38] = 23;
    arrayOfInt[39] = 27;
    arrayOfInt[40] = 136;
    arrayOfInt[41] = 137;
    arrayOfInt[42] = 138;
    arrayOfInt[43] = 139;
    arrayOfInt[44] = 140;
    arrayOfInt[45] = 5;
    arrayOfInt[46] = 6;
    arrayOfInt[47] = 7;
    arrayOfInt[48] = 144;
    arrayOfInt[49] = 145;
    arrayOfInt[50] = 22;
    arrayOfInt[51] = 147;
    arrayOfInt[52] = 148;
    arrayOfInt[53] = 149;
    arrayOfInt[54] = 150;
    arrayOfInt[55] = 4;
    arrayOfInt[56] = 152;
    arrayOfInt[57] = 153;
    arrayOfInt[58] = 154;
    arrayOfInt[59] = 155;
    arrayOfInt[60] = 20;
    arrayOfInt[61] = 21;
    arrayOfInt[62] = 158;
    arrayOfInt[63] = 26;
    arrayOfInt[64] = 32;
    arrayOfInt[65] = 160;
    arrayOfInt[66] = 161;
    arrayOfInt[67] = 162;
    arrayOfInt[68] = 163;
    arrayOfInt[69] = 164;
    arrayOfInt[70] = 165;
    arrayOfInt[71] = 166;
    arrayOfInt[72] = 167;
    arrayOfInt[73] = 168;
    arrayOfInt[74] = 91;
    arrayOfInt[75] = 46;
    arrayOfInt[76] = 60;
    arrayOfInt[77] = 40;
    arrayOfInt[78] = 43;
    arrayOfInt[79] = 33;
    arrayOfInt[80] = 38;
    arrayOfInt[81] = 169;
    arrayOfInt[82] = 170;
    arrayOfInt[83] = 171;
    arrayOfInt[84] = 172;
    arrayOfInt[85] = 173;
    arrayOfInt[86] = 174;
    arrayOfInt[87] = 175;
    arrayOfInt[88] = 176;
    arrayOfInt[89] = 177;
    arrayOfInt[90] = 93;
    arrayOfInt[91] = 36;
    arrayOfInt[92] = 42;
    arrayOfInt[93] = 41;
    arrayOfInt[94] = 59;
    arrayOfInt[95] = 94;
    arrayOfInt[96] = 45;
    arrayOfInt[97] = 47;
    arrayOfInt[98] = 178;
    arrayOfInt[99] = 179;
    arrayOfInt[100] = 180;
    arrayOfInt[101] = 181;
    arrayOfInt[102] = 182;
    arrayOfInt[103] = 183;
    arrayOfInt[104] = 184;
    arrayOfInt[105] = 185;
    arrayOfInt[106] = 124;
    arrayOfInt[107] = 44;
    arrayOfInt[108] = 37;
    arrayOfInt[109] = 95;
    arrayOfInt[110] = 62;
    arrayOfInt[111] = 63;
    arrayOfInt[112] = 186;
    arrayOfInt[113] = 187;
    arrayOfInt[114] = 188;
    arrayOfInt[115] = 189;
    arrayOfInt[116] = 190;
    arrayOfInt[117] = 191;
    arrayOfInt[118] = 192;
    arrayOfInt[119] = 193;
    arrayOfInt[120] = 194;
    arrayOfInt[121] = 96;
    arrayOfInt[122] = 58;
    arrayOfInt[123] = 35;
    arrayOfInt[124] = 64;
    arrayOfInt[125] = 39;
    arrayOfInt[126] = 61;
    arrayOfInt[127] = 34;
    arrayOfInt[''] = 195;
    arrayOfInt[''] = 97;
    arrayOfInt[''] = 98;
    arrayOfInt[''] = 99;
    arrayOfInt[''] = 100;
    arrayOfInt[''] = 101;
    arrayOfInt[''] = 102;
    arrayOfInt[''] = 103;
    arrayOfInt[''] = 104;
    arrayOfInt[''] = 105;
    arrayOfInt[''] = 196;
    arrayOfInt[''] = 197;
    arrayOfInt[''] = 198;
    arrayOfInt[''] = 199;
    arrayOfInt[''] = 200;
    arrayOfInt[''] = 201;
    arrayOfInt[''] = 202;
    arrayOfInt[''] = 106;
    arrayOfInt[''] = 107;
    arrayOfInt[''] = 108;
    arrayOfInt[''] = 109;
    arrayOfInt[''] = 110;
    arrayOfInt[''] = 111;
    arrayOfInt[''] = 112;
    arrayOfInt[''] = 113;
    arrayOfInt[''] = 114;
    arrayOfInt[''] = 203;
    arrayOfInt[''] = 204;
    arrayOfInt[''] = 205;
    arrayOfInt[''] = 206;
    arrayOfInt[''] = 207;
    arrayOfInt[''] = 208;
    arrayOfInt[' '] = 209;
    arrayOfInt['¡'] = 126;
    arrayOfInt['¢'] = 115;
    arrayOfInt['£'] = 116;
    arrayOfInt['¤'] = 117;
    arrayOfInt['¥'] = 118;
    arrayOfInt['¦'] = 119;
    arrayOfInt['§'] = 120;
    arrayOfInt['¨'] = 121;
    arrayOfInt['©'] = 122;
    arrayOfInt['ª'] = 210;
    arrayOfInt['«'] = 211;
    arrayOfInt['¬'] = 212;
    arrayOfInt['­'] = 213;
    arrayOfInt['®'] = 214;
    arrayOfInt['¯'] = 215;
    arrayOfInt['°'] = 216;
    arrayOfInt['±'] = 217;
    arrayOfInt['²'] = 218;
    arrayOfInt['³'] = 219;
    arrayOfInt['´'] = 220;
    arrayOfInt['µ'] = 221;
    arrayOfInt['¶'] = 222;
    arrayOfInt['·'] = 223;
    arrayOfInt['¸'] = 224;
    arrayOfInt['¹'] = 225;
    arrayOfInt['º'] = 226;
    arrayOfInt['»'] = 227;
    arrayOfInt['¼'] = 228;
    arrayOfInt['½'] = 229;
    arrayOfInt['¾'] = 230;
    arrayOfInt['¿'] = 231;
    arrayOfInt['À'] = 123;
    arrayOfInt['Á'] = 65;
    arrayOfInt['Â'] = 66;
    arrayOfInt['Ã'] = 67;
    arrayOfInt['Ä'] = 68;
    arrayOfInt['Å'] = 69;
    arrayOfInt['Æ'] = 70;
    arrayOfInt['Ç'] = 71;
    arrayOfInt['È'] = 72;
    arrayOfInt['É'] = 73;
    arrayOfInt['Ê'] = 232;
    arrayOfInt['Ë'] = 233;
    arrayOfInt['Ì'] = 234;
    arrayOfInt['Í'] = 235;
    arrayOfInt['Î'] = 236;
    arrayOfInt['Ï'] = 237;
    arrayOfInt['Ð'] = 125;
    arrayOfInt['Ñ'] = 74;
    arrayOfInt['Ò'] = 75;
    arrayOfInt['Ó'] = 76;
    arrayOfInt['Ô'] = 77;
    arrayOfInt['Õ'] = 78;
    arrayOfInt['Ö'] = 79;
    arrayOfInt['×'] = 80;
    arrayOfInt['Ø'] = 81;
    arrayOfInt['Ù'] = 82;
    arrayOfInt['Ú'] = 238;
    arrayOfInt['Û'] = 239;
    arrayOfInt['Ü'] = 240;
    arrayOfInt['Ý'] = 241;
    arrayOfInt['Þ'] = 242;
    arrayOfInt['ß'] = 243;
    arrayOfInt['à'] = 92;
    arrayOfInt['á'] = 159;
    arrayOfInt['â'] = 83;
    arrayOfInt['ã'] = 84;
    arrayOfInt['ä'] = 85;
    arrayOfInt['å'] = 86;
    arrayOfInt['æ'] = 87;
    arrayOfInt['ç'] = 88;
    arrayOfInt['è'] = 89;
    arrayOfInt['é'] = 90;
    arrayOfInt['ê'] = 244;
    arrayOfInt['ë'] = 245;
    arrayOfInt['ì'] = 246;
    arrayOfInt['í'] = 247;
    arrayOfInt['î'] = 248;
    arrayOfInt['ï'] = 249;
    arrayOfInt['ð'] = 48;
    arrayOfInt['ñ'] = 49;
    arrayOfInt['ò'] = 50;
    arrayOfInt['ó'] = 51;
    arrayOfInt['ô'] = 52;
    arrayOfInt['õ'] = 53;
    arrayOfInt['ö'] = 54;
    arrayOfInt['÷'] = 55;
    arrayOfInt['ø'] = 56;
    arrayOfInt['ù'] = 57;
    arrayOfInt['ú'] = 250;
    arrayOfInt['û'] = 251;
    arrayOfInt['ü'] = 252;
    arrayOfInt['ý'] = 253;
    arrayOfInt['þ'] = 254;
    arrayOfInt['ÿ'] = 255;
    int i = 0;
    if (i >= paramArrayOfByte.length) {
      return paramArrayOfByte;
    }
    if (paramArrayOfByte[i] > 0) {}
    for (int j = paramArrayOfByte[i];; j = paramArrayOfByte[i] + 256)
    {
      paramArrayOfByte[i] = ((byte)arrayOfInt[j]);
      i += 1;
      break;
    }
  }
  
  private boolean checkArray(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfByte2.length) {
        return true;
      }
      if (paramArrayOfByte1[i] != paramArrayOfByte2[i]) {
        return false;
      }
      i += 1;
    }
  }
  
  private boolean checkIfJson(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(paramArrayOfByte)), 20).readLine();
      if (StringUtils.IsNullOrEmpty(paramArrayOfByte)) {
        return false;
      }
      paramArrayOfByte = paramArrayOfByte.trim();
      if (!paramArrayOfByte.startsWith("{"))
      {
        boolean bool = paramArrayOfByte.startsWith("[");
        if (!bool) {}
      }
      else
      {
        return true;
      }
    }
    catch (IOException paramArrayOfByte) {}
    return false;
  }
  
  private String detect(byte[] paramArrayOfByte)
  {
    Object localObject;
    if ((paramArrayOfByte[0] == 60) && (paramArrayOfByte[1] == 63)) {
      localObject = detectUsingXML(paramArrayOfByte);
    }
    for (;;)
    {
      localObject = alias((String)localObject);
      paramArrayOfByte = (byte[])localObject;
      if (localObject == null) {
        paramArrayOfByte = this.defaultEncoding;
      }
      try
      {
        Charset.forName(paramArrayOfByte);
        CoreHelper.WriteTraceEntry(TAG, "Detected feed encoding: " + paramArrayOfByte);
        return paramArrayOfByte;
        String str = detectUsingMagic(paramArrayOfByte);
        localObject = str;
        if (!"EBCDIC".equals(str)) {
          continue;
        }
        localObject = detectEBCDIC(paramArrayOfByte);
      }
      catch (UnsupportedCharsetException localUnsupportedCharsetException)
      {
        for (;;)
        {
          CoreHelper.WriteTraceEntry(TAG, "Detected invalid encoding: " + paramArrayOfByte + ". Using default");
          paramArrayOfByte = this.defaultEncoding;
          this.error = true;
        }
      }
    }
  }
  
  private String detectEBCDIC(byte[] paramArrayOfByte)
  {
    return detectUsingXML(asciiToEbcdic(paramArrayOfByte));
  }
  
  private String detectUsingMagic(byte[] paramArrayOfByte)
  {
    String str = null;
    int j = 0;
    Magic[] arrayOfMagic = this.magics;
    int k = arrayOfMagic.length;
    int i = 0;
    for (;;)
    {
      if (i >= k) {
        paramArrayOfByte = str;
      }
      Magic localMagic;
      do
      {
        return paramArrayOfByte;
        localMagic = arrayOfMagic[i];
        if (!checkArray(paramArrayOfByte, localMagic.magic)) {
          break;
        }
        str = localMagic.name;
        paramArrayOfByte = str;
      } while (!localMagic.hasBOM);
      this.bomLength = localMagic.magic.length;
      return str;
      j += 1;
      i += 1;
    }
  }
  
  private String detectUsingXML(byte[] paramArrayOfByte)
  {
    Object localObject = null;
    try
    {
      paramArrayOfByte = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(paramArrayOfByte)), 100).readLine();
      Matcher localMatcher = Pattern.compile(".*encoding=\"([^\"]*)\".*").matcher(paramArrayOfByte);
      paramArrayOfByte = (byte[])localObject;
      if (localMatcher.matches()) {
        paramArrayOfByte = localMatcher.group(1);
      }
      return paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  private static Map<String, String> getEncodingMap()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("windows_1250", "windows-1250");
    localHashMap.put("windows_1251", "windows-1251");
    localHashMap.put("windows_1252", "windows-1252");
    localHashMap.put("windows_1253", "windows-1253");
    localHashMap.put("windows_1254", "windows-1254");
    localHashMap.put("windows_1255", "windows-1255");
    localHashMap.put("windows_1256", "windows-1256");
    localHashMap.put("windows_1257", "windows-1257");
    localHashMap.put("windows_1258", "windows-1258");
    localHashMap.put("ms-ee", "windows-1250");
    localHashMap.put("ms-cyrl", "windows-1251");
    localHashMap.put("ms-ansi", "windows-1252");
    localHashMap.put("ms-greek", "windows-1253");
    localHashMap.put("ms-turk", "windows-1254");
    localHashMap.put("ms-hebr", "windows-1255");
    localHashMap.put("ms-arab", "windows-1256");
    localHashMap.put("winbaltrim", "windows-1257");
    localHashMap.put("maclatin2", "x-MacRoman");
    localHashMap.put("macintosh", "x-MacRoman");
    localHashMap.put("csmacintosh", "x-MacRoman");
    localHashMap.put("mac", "x-MacRoman");
    localHashMap.put("mac-cyrillic", "x-MacCyrillic");
    localHashMap.put("us-ascii", "US-ASCII");
    localHashMap.put("cspc775baltic", "IBM775");
    localHashMap.put("iso-10646-ucs-2", "utf-16be");
    localHashMap.put("ebcdic_cp_be", "CP500");
    localHashMap.put("ebcdic_cp_us", "IBM037");
    localHashMap.put("ebcdic_cp_ca", "IBM037");
    localHashMap.put("ebcdic_cp_nl", "IBM037");
    localHashMap.put("ebcdic_cp_wt", "IBM037");
    localHashMap.put("ebcdic_cp_dk", "CP277");
    localHashMap.put("ebcdic_cp_no", "CP277");
    localHashMap.put("ebcdic_cp_fi", "CP278");
    localHashMap.put("ebcdic_cp_se", "CP278");
    localHashMap.put("ebcdic_cp_it", "CP280");
    localHashMap.put("ebcdic_cp_es", "CP284");
    localHashMap.put("ebcdic_cp_gb", "CP285");
    localHashMap.put("ebcdic_cp_fr", "CP297");
    localHashMap.put("ebcdic_cp_ch", "CP500");
    localHashMap.put("ebcdic_cp_be", "CP500");
    localHashMap.put("ebcdic-cp-be", "CP500");
    localHashMap.put("ebcdic-cp-us", "IBM037");
    localHashMap.put("ebcdic-cp-ca", "IBM037");
    localHashMap.put("ebcdic-cp-nl", "IBM037");
    localHashMap.put("ebcdic-cp-wt", "IBM037");
    localHashMap.put("ebcdic-cp-dk", "CP277");
    localHashMap.put("ebcdic-cp-no", "CP277");
    localHashMap.put("ebcdic-cp-fi", "CP278");
    localHashMap.put("ebcdic-cp-se", "CP278");
    localHashMap.put("ebcdic-cp-it", "CP280");
    localHashMap.put("ebcdic-cp-es", "CP284");
    localHashMap.put("ebcdic-cp-gb", "CP285");
    localHashMap.put("ebcdic-cp-fr", "CP297");
    localHashMap.put("ebcdic-cp-ch", "CP500");
    localHashMap.put("ebcdic-cp-be", "CP500");
    localHashMap.put("ibm039", "IBM037");
    localHashMap.put("ibm1140", "IBM037");
    localHashMap.put("dbcs", "CP1252");
    localHashMap.put("cp1125", "CP866");
    localHashMap.put("cp_is", "cp861");
    localHashMap.put("IBM277", "CP277");
    localHashMap.put("CP277", "CP277");
    localHashMap.put("CSIBM277", "CP277");
    localHashMap.put("IBM278", "CP278");
    localHashMap.put("CP278", "CP278");
    localHashMap.put("CSIBM278", "CP278");
    localHashMap.put("IBM280", "CP280");
    localHashMap.put("CP280", "CP280");
    localHashMap.put("CSIBM280", "CP280");
    localHashMap.put("IBM284", "CP284");
    localHashMap.put("CP284", "CP284");
    localHashMap.put("CSIBM284", "CP284");
    localHashMap.put("IBM285", "CP285");
    localHashMap.put("CP285", "CP285");
    localHashMap.put("CSIBM285", "CP285");
    localHashMap.put("IBM297", "CP297");
    localHashMap.put("CP297", "CP297");
    localHashMap.put("CSIBM297", "CP297");
    localHashMap.put("IBM420", "CP420");
    localHashMap.put("CP420", "CP420");
    localHashMap.put("CSIBM420", "CP420");
    localHashMap.put("ebcdic-cp-ar1", "CP420");
    localHashMap.put("ebcdic-cp-he", "CP424");
    localHashMap.put("IBM424", "CP424");
    localHashMap.put("CP424", "CP424");
    localHashMap.put("CSIBM424", "CP424");
    localHashMap.put("IBM500", "CP500");
    localHashMap.put("CP500", "CP500");
    localHashMap.put("CSIBM500", "CP500");
    localHashMap.put("csibm855", "CP855");
    localHashMap.put("IBM868", "CP868");
    localHashMap.put("CP868", "CP868");
    localHashMap.put("CSIBM868", "CP868");
    localHashMap.put("CP-AR", "CP868");
    localHashMap.put("IBM869", "CP869");
    localHashMap.put("CP869", "CP869");
    localHashMap.put("CSIBM869", "CP869");
    localHashMap.put("CP-GR", "CP869");
    localHashMap.put("IBM870", "CP870");
    localHashMap.put("CP870", "CP870");
    localHashMap.put("CSIBM870", "CP870");
    localHashMap.put("IBM871", "CP871");
    localHashMap.put("CP871", "CP871");
    localHashMap.put("CSIBM871", "CP871");
    localHashMap.put("ebcdic-cp-is", "CP871");
    localHashMap.put("IBM918", "CP918");
    localHashMap.put("CP918", "CP918");
    localHashMap.put("CSIBM918", "CP918");
    localHashMap.put("ebcdic-cp-ar2", "CP918");
    localHashMap.put("EUC-JP", "EUCJIS");
    localHashMap.put("CSEUCPkdFmtJapanese", "EUCJIS");
    localHashMap.put("EUC-KR", "KSC5601");
    localHashMap.put("GB2312", "GB2312");
    localHashMap.put("CSGB2312", "GB2312");
    localHashMap.put("ISO-2022-JP", "JIS");
    localHashMap.put("CSISO2022JP", "JIS");
    localHashMap.put("ISO-2022-KR", "ISO2022KR");
    localHashMap.put("CSISO2022KR", "ISO2022KR");
    localHashMap.put("ISO-2022-CN", "ISO2022CN");
    return localHashMap;
  }
  
  public String alias(String paramString)
  {
    String str = paramString;
    if (encoding_map.containsKey(paramString)) {
      str = (String)encoding_map.get(paramString);
    }
    return str;
  }
  
  public String detect(String paramString)
    throws IOException
  {
    byte[] arrayOfByte = new byte[100];
    str = null;
    for (;;)
    {
      try
      {
        paramString = new FileInputStream(paramString);
        if (str == null) {
          break label57;
        }
      }
      catch (Exception paramString)
      {
        try
        {
          paramString.read(arrayOfByte, 0, 100);
          paramString.close();
          this.isJson = checkIfJson(arrayOfByte);
          return detect(arrayOfByte);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            str = paramString;
            paramString = localException;
          }
        }
        paramString = paramString;
      }
      str.close();
      label57:
      CoreHelper.LogException(TAG, "Unable to check XML feed encoding", paramString);
    }
  }
  
  public boolean isError()
  {
    return this.error;
  }
  
  public boolean isJson()
  {
    return this.isJson;
  }
  
  public void stripBOM(InputStream paramInputStream)
    throws IOException
  {
    int i = 0;
    for (;;)
    {
      if (i >= this.bomLength) {
        return;
      }
      paramInputStream.read();
      i += 1;
    }
  }
  
  static class Magic
  {
    boolean hasBOM;
    byte[] magic;
    String name;
    
    public Magic(String paramString, boolean paramBoolean, byte paramByte1, byte paramByte2)
    {
      this.magic = new byte[2];
      this.magic[0] = paramByte1;
      this.magic[1] = paramByte2;
      this.hasBOM = paramBoolean;
      this.name = paramString;
    }
    
    public Magic(String paramString, boolean paramBoolean, byte paramByte1, byte paramByte2, byte paramByte3)
    {
      this.magic = new byte[3];
      this.magic[0] = paramByte1;
      this.magic[1] = paramByte2;
      this.magic[2] = paramByte3;
      this.hasBOM = paramBoolean;
      this.name = paramString;
    }
    
    public Magic(String paramString, boolean paramBoolean, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4)
    {
      this.magic = new byte[4];
      this.magic[0] = paramByte1;
      this.magic[1] = paramByte2;
      this.magic[2] = paramByte3;
      this.magic[3] = paramByte4;
      this.hasBOM = paramBoolean;
      this.name = paramString;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/helpers/DetectEncoding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */