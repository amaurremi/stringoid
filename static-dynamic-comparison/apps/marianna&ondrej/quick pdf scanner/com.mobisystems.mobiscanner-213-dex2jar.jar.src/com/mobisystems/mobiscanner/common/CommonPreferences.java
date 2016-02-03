package com.mobisystems.mobiscanner.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import android.util.SparseArray;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class CommonPreferences
{
  public static void W(Context paramContext)
  {
    Keys.init(paramContext);
    MeasurementUnits.init(paramContext);
    PageSize.init(paramContext);
    PageOrientation.init(paramContext);
    PDFImageQuality.init(paramContext);
    PDFImageDensity.init(paramContext);
    OCRLanguage.init(paramContext);
  }
  
  public static enum Keys
  {
    private static Context mContext;
    private String mKeyStr;
    private final int mResId;
    
    private Keys(int paramInt)
    {
      this.mResId = paramInt;
    }
    
    public static void init(Context paramContext)
    {
      mContext = paramContext;
      paramContext = paramContext.getResources();
      int j = values().length;
      int i = 0;
      while (i < j)
      {
        values()[i].mKeyStr = paramContext.getString(values()[i].mResId);
        i += 1;
      }
    }
    
    public String Dl()
    {
      return PreferenceManager.getDefaultSharedPreferences(mContext).getString(this.mKeyStr, "");
    }
    
    public boolean Dm()
    {
      return PreferenceManager.getDefaultSharedPreferences(mContext).getBoolean(this.mKeyStr, false);
    }
    
    public String dd(String paramString)
    {
      return PreferenceManager.getDefaultSharedPreferences(mContext).getString(this.mKeyStr, paramString);
    }
    
    public float getFloatValue()
    {
      return PreferenceManager.getDefaultSharedPreferences(mContext).getFloat(this.mKeyStr, 0.0F);
    }
    
    public int getIntValue()
    {
      return PreferenceManager.getDefaultSharedPreferences(mContext).getInt(this.mKeyStr, 0);
    }
    
    public String getKey()
    {
      return this.mKeyStr;
    }
  }
  
  public static enum MeasurementUnits
  {
    private static SparseArray<MeasurementUnits> aqf;
    private final int mDialogResId;
    private String mDialogStr;
    private final int mDisplayResId;
    private String mDisplayStr;
    private int mPersistentValue;
    private final int mResId;
    
    private MeasurementUnits(int paramInt1, int paramInt2, int paramInt3)
    {
      this.mResId = paramInt1;
      this.mDisplayResId = paramInt2;
      this.mDialogResId = paramInt3;
    }
    
    public static float A(float paramFloat)
    {
      return Float.parseFloat(new DecimalFormat("###.##", new DecimalFormatSymbols(Locale.US)).format(paramFloat));
    }
    
    public static float a(float paramFloat, MeasurementUnits paramMeasurementUnits)
    {
      float f = paramFloat;
      if (paramMeasurementUnits.equals(aqe)) {
        f = paramFloat / 2.54F;
      }
      return f;
    }
    
    public static float b(float paramFloat, MeasurementUnits paramMeasurementUnits)
    {
      float f = paramFloat;
      if (paramMeasurementUnits.equals(aqe)) {
        f = paramFloat * 2.54F;
      }
      return f;
    }
    
    public static MeasurementUnits de(String paramString)
    {
      return (MeasurementUnits)aqf.get(Integer.parseInt(paramString));
    }
    
    public static float df(String paramString)
    {
      return new DecimalFormat("0.#", new DecimalFormatSymbols(Locale.US)).parse(paramString).floatValue();
    }
    
    public static void init(Context paramContext)
    {
      aqf = new SparseArray();
      Resources localResources = paramContext.getResources();
      int j = values().length;
      int i = 0;
      while (i < j)
      {
        values()[i].mPersistentValue = Integer.parseInt(localResources.getString(values()[i].mResId));
        aqf.put(values()[i].mPersistentValue, values()[i]);
        values()[i].mDisplayStr = paramContext.getResources().getString(values()[i].mDisplayResId);
        values()[i].mDialogStr = paramContext.getResources().getString(values()[i].mDialogResId);
        i += 1;
      }
    }
    
    public static String z(float paramFloat)
    {
      return new DecimalFormat("###.##", new DecimalFormatSymbols(Locale.US)).format(paramFloat);
    }
    
    public String Dn()
    {
      return this.mDisplayStr;
    }
    
    public String Do()
    {
      return this.mDialogStr;
    }
  }
  
  public static enum OCRLanguage
  {
    private static SparseArray<OCRLanguage> aqf;
    private static SparseArray<OCRLanguage> atK;
    private static String[] atL;
    private static String[] atM;
    private int mPersistentValue;
    private int mPosition = -1;
    private final int mResId;
    private String mValue;
    
    static
    {
      aqA = new OCRLanguage("BENGALI_BANGLA", 19, 2131296545, "bn");
      aqB = new OCRLanguage("BIHARI", 20, 2131296546, "bh");
      aqC = new OCRLanguage("BISLAMA", 21, 2131296547, "bi");
      aqD = new OCRLanguage("BOSNIAN", 22, 2131296548, "bs");
      aqE = new OCRLanguage("BRETON", 23, 2131296549, "br");
      aqF = new OCRLanguage("BULGARIAN", 24, 2131296550, "bg");
      aqG = new OCRLanguage("BURMESE", 25, 2131296551, "my");
      aqH = new OCRLanguage("CATALAN_VALENCIAN", 26, 2131296552, "ca");
      aqI = new OCRLanguage("CHAMORRO", 27, 2131296553, "ch");
      aqJ = new OCRLanguage("CHECHEN", 28, 2131296554, "ce");
      aqK = new OCRLanguage("CHICHEWA_CHEWA_NYANJA", 29, 2131296555, "ny");
      aqL = new OCRLanguage("CHINESE", 30, 2131296556, "zh");
      aqM = new OCRLanguage("CHUVASH", 31, 2131296557, "cv");
      aqN = new OCRLanguage("CORNISH", 32, 2131296558, "kw");
      aqO = new OCRLanguage("CORSICAN", 33, 2131296559, "co");
      aqP = new OCRLanguage("CREE", 34, 2131296560, "cr");
      aqQ = new OCRLanguage("CROATIAN", 35, 2131296561, "hr");
      aqR = new OCRLanguage("CZECH", 36, 2131296562, "cs");
      aqS = new OCRLanguage("DANISH", 37, 2131296563, "da");
      aqT = new OCRLanguage("DIVEHI_DHIVEHI_MALDIVIAN", 38, 2131296564, "dv");
      aqU = new OCRLanguage("DUTCH", 39, 2131296565, "nl");
      aqV = new OCRLanguage("DZONGKHA", 40, 2131296566, "dz");
      aqW = new OCRLanguage("ENGLISH", 41, 2131296567, "en");
      aqX = new OCRLanguage("ESPERANTO", 42, 2131296568, "eo");
      aqY = new OCRLanguage("ESTONIAN", 43, 2131296569, "et");
      aqZ = new OCRLanguage("EWE", 44, 2131296570, "ee");
      ara = new OCRLanguage("FAROESE", 45, 2131296571, "fo");
      arb = new OCRLanguage("FIJIAN", 46, 2131296572, "fj");
      arc = new OCRLanguage("FINNISH", 47, 2131296573, "fi");
      ard = new OCRLanguage("FRENCH", 48, 2131296574, "fr");
      are = new OCRLanguage("FULA_FULAH_PULAAR_PULAR", 49, 2131296575, "ff");
      arf = new OCRLanguage("GALICIAN", 50, 2131296576, "gl");
      arg = new OCRLanguage("GEORGIAN", 51, 2131296577, "ka");
      arh = new OCRLanguage("GERMAN", 52, 2131296578, "de");
      ari = new OCRLanguage("GREEK_MODERN", 53, 2131296579, "el");
      arj = new OCRLanguage("GUARANÍ", 54, 2131296580, "gn");
      ark = new OCRLanguage("GUJARATI", 55, 2131296581, "gu");
      arl = new OCRLanguage("HAITIAN_HAITIANCREOLE", 56, 2131296582, "ht");
      arm = new OCRLanguage("HAUSA", 57, 2131296583, "ha");
      arn = new OCRLanguage("HEBREW", 58, 2131296584, "he");
      aro = new OCRLanguage("HERERO", 59, 2131296585, "hz");
      arp = new OCRLanguage("HINDI", 60, 2131296586, "hi");
      arq = new OCRLanguage("HIRIMOTU", 61, 2131296587, "ho");
      arr = new OCRLanguage("HUNGARIAN", 62, 2131296588, "hu");
      ars = new OCRLanguage("INTERLINGUA", 63, 2131296589, "ia");
      art = new OCRLanguage("INDONESIAN", 64, 2131296590, "id");
      aru = new OCRLanguage("INTERLINGUE", 65, 2131296591, "ie");
      arv = new OCRLanguage("IRISH", 66, 2131296592, "ga");
      arw = new OCRLanguage("IGBO", 67, 2131296593, "ig");
      arx = new OCRLanguage("INUPIAQ", 68, 2131296594, "ik");
      ary = new OCRLanguage("IDO", 69, 2131296595, "io");
      arz = new OCRLanguage("ICELANDIC", 70, 2131296596, "is");
      arA = new OCRLanguage("ITALIAN", 71, 2131296597, "it");
      arB = new OCRLanguage("INUKTITUT", 72, 2131296598, "iu");
      arC = new OCRLanguage("JAPANESE", 73, 2131296599, "ja");
      arD = new OCRLanguage("JAVANESE", 74, 2131296600, "jv");
      arE = new OCRLanguage("KALAALLISUT_GREENLANDIC", 75, 2131296601, "kl");
      arF = new OCRLanguage("KANNADA", 76, 2131296602, "kn");
      arG = new OCRLanguage("KANURI", 77, 2131296603, "kr");
      arH = new OCRLanguage("KASHMIRI", 78, 2131296604, "ks");
      arI = new OCRLanguage("KAZAKH", 79, 2131296605, "kk");
      arJ = new OCRLanguage("KHMER", 80, 2131296606, "km");
      arK = new OCRLanguage("KIKUYU_GIKUYU", 81, 2131296607, "ki");
      arL = new OCRLanguage("KINYARWANDA", 82, 2131296608, "rw");
      arM = new OCRLanguage("KYRGYZ", 83, 2131296609, "ky");
      arN = new OCRLanguage("KOMI", 84, 2131296610, "kv");
      arO = new OCRLanguage("KONGO", 85, 2131296611, "kg");
      arP = new OCRLanguage("KOREAN", 86, 2131296612, "ko");
      arQ = new OCRLanguage("KURDISH", 87, 2131296613, "ku");
      arR = new OCRLanguage("KWANYAMA_KUANYAMA", 88, 2131296614, "kj");
      arS = new OCRLanguage("LATIN", 89, 2131296615, "la");
      arT = new OCRLanguage("LUXEMBOURGISH_LETZEBURGESCH", 90, 2131296616, "lb");
      arU = new OCRLanguage("GANDA", 91, 2131296617, "lg");
      arV = new OCRLanguage("LIMBURGISH_LIMBURGAN_LIMBURGER", 92, 2131296618, "li");
      arW = new OCRLanguage("LINGALA", 93, 2131296619, "ln");
      arX = new OCRLanguage("LAO", 94, 2131296620, "lo");
      arY = new OCRLanguage("LITHUANIAN", 95, 2131296621, "lt");
      arZ = new OCRLanguage("LUBA_KATANGA", 96, 2131296622, "lu");
      asa = new OCRLanguage("LATVIAN", 97, 2131296623, "lv");
      asb = new OCRLanguage("MANX", 98, 2131296624, "gv");
      asc = new OCRLanguage("MACEDONIAN", 99, 2131296625, "mk");
      asd = new OCRLanguage("MALAGASY", 100, 2131296626, "mg");
      ase = new OCRLanguage("MALAY", 101, 2131296627, "ms");
      asf = new OCRLanguage("MALAYALAM", 102, 2131296628, "ml");
      asg = new OCRLanguage("MALTESE", 103, 2131296629, "mt");
      ash = new OCRLanguage("MĀORI", 104, 2131296630, "mi");
      asi = new OCRLanguage("MARATHI", 105, 2131296631, "mr");
      asj = new OCRLanguage("MARSHALLESE", 106, 2131296632, "mh");
      ask = new OCRLanguage("MONGOLIAN", 107, 2131296633, "mn");
      asl = new OCRLanguage("NAURU", 108, 2131296634, "na");
      asm = new OCRLanguage("NAVAJO_NAVAHO", 109, 2131296635, "nv");
      asn = new OCRLanguage("NORWEGIANBOKMAL", 110, 2131296636, "nb");
      aso = new OCRLanguage("NORTHNDEBELE", 111, 2131296637, "nd");
      asp = new OCRLanguage("NEPALI", 112, 2131296638, "ne");
      asq = new OCRLanguage("NDONGA", 113, 2131296639, "ng");
      asr = new OCRLanguage("NORWEGIANNYNORSK", 114, 2131296640, "nn");
      ass = new OCRLanguage("NORWEGIAN", 115, 2131296641, "no");
      ast = new OCRLanguage("NUOSU", 116, 2131296642, "ii");
      asu = new OCRLanguage("SOUTHNDEBELE", 117, 2131296643, "nr");
      asv = new OCRLanguage("OCCITAN", 118, 2131296644, "oc");
      asw = new OCRLanguage("OJIBWE_OJIBWA", 119, 2131296645, "oj");
      asx = new OCRLanguage("OLDCHURCHSLAVONIC_CHURCHSLAVONIC_OLDBULGARIAN", 120, 2131296646, "cu");
      asy = new OCRLanguage("OROMO", 121, 2131296647, "om");
      asz = new OCRLanguage("ORIYA", 122, 2131296648, "or");
      asA = new OCRLanguage("OSSETIAN_OSSETIC", 123, 2131296649, "os");
      asB = new OCRLanguage("PANJABI_PUNJABI", 124, 2131296650, "pa");
      asC = new OCRLanguage("PALI", 125, 2131296651, "pi");
      asD = new OCRLanguage("PERSIAN", 126, 2131296652, "fa");
      asE = new OCRLanguage("POLISH", 127, 2131296653, "pl");
      asF = new OCRLanguage("PASHTO_PUSHTO", 128, 2131296654, "ps");
      asG = new OCRLanguage("PORTUGUESE", 129, 2131296655, "pt");
      asH = new OCRLanguage("QUECHUA", 130, 2131296656, "qu");
      asI = new OCRLanguage("ROMANSH", 131, 2131296657, "rm");
      asJ = new OCRLanguage("KIRUNDI", 132, 2131296658, "rn");
      asK = new OCRLanguage("ROMANIAN", 133, 2131296659, "ro");
      asL = new OCRLanguage("RUSSIAN", 134, 2131296660, "ru");
      asM = new OCRLanguage("SANSKRIT", 135, 2131296661, "sa");
      asN = new OCRLanguage("SARDINIAN", 136, 2131296662, "sc");
      asO = new OCRLanguage("SINDHI", 137, 2131296663, "sd");
      asP = new OCRLanguage("NORTHERNSAMI", 138, 2131296664, "se");
      asQ = new OCRLanguage("SAMOAN", 139, 2131296665, "sm");
      asR = new OCRLanguage("SANGO", 140, 2131296666, "sg");
      asS = new OCRLanguage("SERBIAN", 141, 2131296667, "sr");
      asT = new OCRLanguage("SCOTTISHGAELIC_GAELIC", 142, 2131296668, "gd");
      asU = new OCRLanguage("SHONA", 143, 2131296669, "sn");
      asV = new OCRLanguage("SINHALA_SINHALESE", 144, 2131296670, "si");
      asW = new OCRLanguage("SLOVAK", 145, 2131296671, "sk");
      asX = new OCRLanguage("SLOVENE", 146, 2131296672, "sl");
      asY = new OCRLanguage("SOMALI", 147, 2131296673, "so");
      asZ = new OCRLanguage("SOUTHERNSOTHO", 148, 2131296674, "st");
      ata = new OCRLanguage("SPANISH_CASTILIAN", 149, 2131296675, "es");
      atb = new OCRLanguage("SUNDANESE", 150, 2131296676, "su");
      atc = new OCRLanguage("SWAHILI", 151, 2131296677, "sw");
      atd = new OCRLanguage("SWATI", 152, 2131296678, "ss");
      ate = new OCRLanguage("SWEDISH", 153, 2131296679, "sv");
      atf = new OCRLanguage("TAMIL", 154, 2131296680, "ta");
      atg = new OCRLanguage("TELUGU", 155, 2131296681, "te");
      ath = new OCRLanguage("TAJIK", 156, 2131296682, "tg");
      ati = new OCRLanguage("THAI", 157, 2131296683, "th");
      atj = new OCRLanguage("TIGRINYA", 158, 2131296684, "ti");
      atk = new OCRLanguage("TIBETANSTANDARD_TIBETAN_CENTRAL", 159, 2131296685, "bo");
      atl = new OCRLanguage("TURKMEN", 160, 2131296686, "tk");
      atm = new OCRLanguage("TAGALOG", 161, 2131296687, "tl");
      atn = new OCRLanguage("TSWANA", 162, 2131296688, "tn");
      ato = new OCRLanguage("TONGA", 163, 2131296689, "to");
      atp = new OCRLanguage("TURKISH", 164, 2131296690, "tr");
      atq = new OCRLanguage("TSONGA", 165, 2131296691, "ts");
      atr = new OCRLanguage("TATAR", 166, 2131296692, "tt");
      ats = new OCRLanguage("TWI", 167, 2131296693, "tw");
      att = new OCRLanguage("TAHITIAN", 168, 2131296694, "ty");
      atu = new OCRLanguage("UYGHUR_UIGHUR", 169, 2131296695, "ug");
      atv = new OCRLanguage("UKRAINIAN", 170, 2131296696, "uk");
      atw = new OCRLanguage("URDU", 171, 2131296697, "ur");
      atx = new OCRLanguage("UZBEK", 172, 2131296698, "uz");
      aty = new OCRLanguage("VENDA", 173, 2131296699, "ve");
      atz = new OCRLanguage("VIETNAMESE", 174, 2131296700, "vi");
    }
    
    private OCRLanguage(int paramInt, String paramString)
    {
      this.mResId = paramInt;
      this.mValue = paramString;
    }
    
    public static String[] Dq()
    {
      String[] arrayOfString = new String[atL.length];
      int i = 0;
      while (i < atL.length)
      {
        arrayOfString[i] = String.valueOf(dg(atM[i]).getValue());
        i += 1;
      }
      return arrayOfString;
    }
    
    public static OCRLanguage dg(String paramString)
    {
      return (OCRLanguage)aqf.get(Integer.parseInt(paramString));
    }
    
    public static OCRLanguage fR(int paramInt)
    {
      return (OCRLanguage)aqf.get(paramInt);
    }
    
    public static OCRLanguage fS(int paramInt)
    {
      return (OCRLanguage)atK.get(paramInt);
    }
    
    public static void init(Context paramContext)
    {
      int j = 0;
      atL = paramContext.getResources().getStringArray(2131623950);
      atM = paramContext.getResources().getStringArray(2131623943);
      aqf = new SparseArray();
      Object localObject = paramContext.getResources();
      int k = values().length;
      int i = 0;
      while (i < k)
      {
        values()[i].mPersistentValue = Integer.parseInt(((Resources)localObject).getString(values()[i].mResId));
        aqf.put(values()[i].mPersistentValue, values()[i]);
        i += 1;
      }
      paramContext = paramContext.getResources().getStringArray(2131623943);
      atK = new SparseArray();
      i = j;
      while (i < paramContext.length)
      {
        localObject = dg(paramContext[i]);
        ((OCRLanguage)localObject).mPosition = i;
        atK.put(i, localObject);
        i += 1;
      }
    }
    
    public int Dp()
    {
      return this.mPersistentValue;
    }
    
    public int getPosition()
    {
      return this.mPosition;
    }
    
    public String getValue()
    {
      return this.mValue;
    }
  }
  
  public static enum PDFImageDensity
  {
    private static SparseArray<PDFImageDensity> aqf;
    private static SparseArray<PDFImageDensity> atK;
    private static String[] atL;
    private static String[] atM;
    private static String atU;
    private int mPersistentValue;
    private int mPosition = -1;
    private final int mResId;
    private int mValue;
    
    private PDFImageDensity(int paramInt1, int paramInt2)
    {
      this.mResId = paramInt1;
      this.mValue = paramInt2;
    }
    
    public static String[] Dq()
    {
      String[] arrayOfString = new String[atL.length];
      int i = 0;
      while (i < atL.length)
      {
        arrayOfString[i] = (String.valueOf(dh(atM[i]).getValue()) + " " + atU);
        i += 1;
      }
      return arrayOfString;
    }
    
    public static PDFImageDensity dh(String paramString)
    {
      return (PDFImageDensity)aqf.get(Integer.parseInt(paramString));
    }
    
    public static PDFImageDensity fT(int paramInt)
    {
      return (PDFImageDensity)aqf.get(paramInt);
    }
    
    public static PDFImageDensity fU(int paramInt)
    {
      return (PDFImageDensity)atK.get(paramInt);
    }
    
    public static void init(Context paramContext)
    {
      int j = 0;
      atL = paramContext.getResources().getStringArray(2131623948);
      atM = paramContext.getResources().getStringArray(2131623941);
      atU = paramContext.getResources().getString(2131297070);
      aqf = new SparseArray();
      Object localObject = paramContext.getResources();
      int k = values().length;
      int i = 0;
      while (i < k)
      {
        values()[i].mPersistentValue = Integer.parseInt(((Resources)localObject).getString(values()[i].mResId));
        aqf.put(values()[i].mPersistentValue, values()[i]);
        i += 1;
      }
      paramContext = paramContext.getResources().getStringArray(2131623941);
      atK = new SparseArray();
      i = j;
      while (i < paramContext.length)
      {
        localObject = dh(paramContext[i]);
        ((PDFImageDensity)localObject).mPosition = i;
        atK.put(i, localObject);
        i += 1;
      }
    }
    
    public int Dp()
    {
      return this.mPersistentValue;
    }
    
    public int getPosition()
    {
      return this.mPosition;
    }
    
    public int getValue()
    {
      return this.mValue;
    }
  }
  
  public static enum PDFImageQuality
  {
    private static SparseArray<PDFImageQuality> aqf;
    private static SparseArray<PDFImageQuality> atK;
    private static String[] atL;
    private int mPersistentValue;
    private int mPosition = -1;
    private final int mResId;
    private int mValue;
    
    private PDFImageQuality(int paramInt1, int paramInt2)
    {
      this.mResId = paramInt1;
      this.mValue = paramInt2;
    }
    
    public static String[] Dq()
    {
      String[] arrayOfString = new String[atL.length];
      System.arraycopy(atL, 0, arrayOfString, 0, atL.length);
      return arrayOfString;
    }
    
    public static PDFImageQuality di(String paramString)
    {
      return (PDFImageQuality)aqf.get(Integer.parseInt(paramString));
    }
    
    public static PDFImageQuality fV(int paramInt)
    {
      return (PDFImageQuality)aqf.get(paramInt);
    }
    
    public static PDFImageQuality fW(int paramInt)
    {
      return (PDFImageQuality)atK.get(paramInt);
    }
    
    public static void init(Context paramContext)
    {
      int j = 0;
      atL = paramContext.getResources().getStringArray(2131623947);
      aqf = new SparseArray();
      Object localObject = paramContext.getResources();
      int k = values().length;
      int i = 0;
      while (i < k)
      {
        values()[i].mPersistentValue = Integer.parseInt(((Resources)localObject).getString(values()[i].mResId));
        aqf.put(values()[i].mPersistentValue, values()[i]);
        i += 1;
      }
      paramContext = paramContext.getResources().getStringArray(2131623940);
      atK = new SparseArray();
      i = j;
      while (i < paramContext.length)
      {
        localObject = di(paramContext[i]);
        ((PDFImageQuality)localObject).mPosition = i;
        atK.put(i, localObject);
        i += 1;
      }
    }
    
    public int Dp()
    {
      return this.mPersistentValue;
    }
    
    public int getPosition()
    {
      return this.mPosition;
    }
    
    public int getValue()
    {
      return this.mValue;
    }
  }
  
  public static enum PageOrientation
  {
    private static SparseArray<PageOrientation> aqf;
    private static SparseArray<PageOrientation> atK;
    private static String[] atL;
    private int mPersistentValue;
    private int mPosition = -1;
    private final int mResId;
    
    private PageOrientation(int paramInt)
    {
      this.mResId = paramInt;
    }
    
    public static String[] Dq()
    {
      String[] arrayOfString = new String[atL.length];
      System.arraycopy(atL, 0, arrayOfString, 0, atL.length);
      return arrayOfString;
    }
    
    public static PageOrientation dj(String paramString)
    {
      return (PageOrientation)aqf.get(Integer.parseInt(paramString));
    }
    
    public static PageOrientation fX(int paramInt)
    {
      return (PageOrientation)aqf.get(paramInt);
    }
    
    public static PageOrientation fY(int paramInt)
    {
      return (PageOrientation)atK.get(paramInt);
    }
    
    public static void init(Context paramContext)
    {
      int j = 0;
      atL = paramContext.getResources().getStringArray(2131623946);
      aqf = new SparseArray();
      Object localObject = paramContext.getResources();
      int k = values().length;
      int i = 0;
      while (i < k)
      {
        values()[i].mPersistentValue = Integer.parseInt(((Resources)localObject).getString(values()[i].mResId));
        aqf.put(values()[i].mPersistentValue, values()[i]);
        i += 1;
      }
      paramContext = paramContext.getResources().getStringArray(2131623939);
      atK = new SparseArray();
      i = j;
      while (i < paramContext.length)
      {
        localObject = dj(paramContext[i]);
        ((PageOrientation)localObject).mPosition = i;
        atK.put(i, localObject);
        i += 1;
      }
    }
    
    public int Dp()
    {
      return this.mPersistentValue;
    }
    
    public int getPosition()
    {
      return this.mPosition;
    }
  }
  
  public static enum PageSize
  {
    private static SparseArray<PageSize> aqf;
    private static SparseArray<PageSize> atK;
    private static String[] atL;
    private final float mHeight;
    private int mPersistentValue;
    private int mPosition = -1;
    private final int mResId;
    private final float mWidth;
    
    private PageSize(int paramInt, float paramFloat1, float paramFloat2)
    {
      this.mResId = paramInt;
      this.mWidth = paramFloat1;
      this.mHeight = paramFloat2;
    }
    
    public static String[] a(CommonPreferences.MeasurementUnits paramMeasurementUnits)
    {
      int i = 0;
      String str = paramMeasurementUnits.Dn();
      String[] arrayOfString = new String[atL.length];
      System.arraycopy(atL, 0, arrayOfString, 0, atL.length);
      while (i < arrayOfString.length)
      {
        PageSize localPageSize = ga(i);
        if ((localPageSize != aui) && (localPageSize != auj))
        {
          float f1 = CommonPreferences.MeasurementUnits.a(localPageSize.getWidth(), paramMeasurementUnits);
          float f2 = CommonPreferences.MeasurementUnits.a(localPageSize.getHeight(), paramMeasurementUnits);
          arrayOfString[i] = (arrayOfString[i] + " (" + CommonPreferences.MeasurementUnits.z(f1) + str + " x " + CommonPreferences.MeasurementUnits.z(f2) + str + ")");
        }
        i += 1;
      }
      return arrayOfString;
    }
    
    public static PageSize dk(String paramString)
    {
      return (PageSize)aqf.get(Integer.parseInt(paramString));
    }
    
    public static PageSize fZ(int paramInt)
    {
      return (PageSize)aqf.get(paramInt);
    }
    
    public static PageSize ga(int paramInt)
    {
      return (PageSize)atK.get(paramInt);
    }
    
    public static void init(Context paramContext)
    {
      int j = 0;
      atL = paramContext.getResources().getStringArray(2131623945);
      aqf = new SparseArray();
      Object localObject = paramContext.getResources();
      int k = values().length;
      int i = 0;
      while (i < k)
      {
        PageSize localPageSize = values()[i];
        localPageSize.mPersistentValue = Integer.parseInt(((Resources)localObject).getString(localPageSize.mResId));
        aqf.put(localPageSize.mPersistentValue, localPageSize);
        i += 1;
      }
      paramContext = paramContext.getResources().getStringArray(2131623938);
      atK = new SparseArray();
      i = j;
      while (i < paramContext.length)
      {
        localObject = dk(paramContext[i]);
        ((PageSize)localObject).mPosition = i;
        atK.put(i, localObject);
        i += 1;
      }
    }
    
    public int Dp()
    {
      return this.mPersistentValue;
    }
    
    public float getHeight()
    {
      return this.mHeight;
    }
    
    public int getPosition()
    {
      return this.mPosition;
    }
    
    public float getWidth()
    {
      return this.mWidth;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/common/CommonPreferences.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */