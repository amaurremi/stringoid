package com.parse.codec.language;

import com.parse.codec.EncoderException;
import com.parse.codec.StringEncoder;
import java.util.Locale;

public class DoubleMetaphone
  implements StringEncoder
{
  private static final String[] ES_EP_EB_EL_EY_IB_IL_IN_IE_EI_ER = { "ES", "EP", "EB", "EL", "EY", "IB", "IL", "IN", "IE", "EI", "ER" };
  private static final String[] L_R_N_M_B_H_F_V_W_SPACE;
  private static final String[] L_T_K_S_N_M_B_Z = { "L", "T", "K", "S", "N", "M", "B", "Z" };
  private static final String[] SILENT_START = { "GN", "KN", "PN", "WR", "PS" };
  private static final String VOWELS = "AEIOUY";
  private int maxCodeLen = 4;
  
  static
  {
    L_R_N_M_B_H_F_V_W_SPACE = new String[] { "L", "R", "N", "M", "B", "H", "F", "V", "W", " " };
  }
  
  private String cleanInput(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      paramString = paramString.trim();
    } while (paramString.length() == 0);
    return paramString.toUpperCase(Locale.ENGLISH);
  }
  
  private boolean conditionC0(String paramString, int paramInt)
  {
    if (contains(paramString, paramInt, 4, "CHIA")) {}
    int i;
    do
    {
      return true;
      if (paramInt <= 1) {
        return false;
      }
      if (isVowel(charAt(paramString, paramInt - 2))) {
        return false;
      }
      if (!contains(paramString, paramInt - 1, 3, "ACH")) {
        return false;
      }
      i = charAt(paramString, paramInt + 2);
    } while (((i != 73) && (i != 69)) || (contains(paramString, paramInt - 2, 6, "BACHER", "MACHER")));
    return false;
  }
  
  private boolean conditionCH0(String paramString, int paramInt)
  {
    if (paramInt != 0) {
      return false;
    }
    if ((!contains(paramString, paramInt + 1, 5, "HARAC", "HARIS")) && (!contains(paramString, paramInt + 1, 3, "HOR", "HYM", "HIA", "HEM"))) {
      return false;
    }
    return !contains(paramString, 0, 5, "CHORE");
  }
  
  private boolean conditionCH1(String paramString, int paramInt)
  {
    return (contains(paramString, 0, 4, "VAN ", "VON ")) || (contains(paramString, 0, 3, "SCH")) || (contains(paramString, paramInt - 2, 6, "ORCHES", "ARCHIT", "ORCHID")) || (contains(paramString, paramInt + 2, 1, "T", "S")) || (((contains(paramString, paramInt - 1, 1, "A", "O", "U", "E")) || (paramInt == 0)) && ((contains(paramString, paramInt + 2, 1, L_R_N_M_B_H_F_V_W_SPACE)) || (paramInt + 1 == paramString.length() - 1)));
  }
  
  private boolean conditionL0(String paramString, int paramInt)
  {
    if ((paramInt == paramString.length() - 3) && (contains(paramString, paramInt - 1, 4, "ILLO", "ILLA", "ALLE"))) {
      return true;
    }
    return ((contains(paramString, paramString.length() - 2, 2, "AS", "OS")) || (contains(paramString, paramString.length() - 1, 1, "A", "O"))) && (contains(paramString, paramInt - 1, 4, "ALLE"));
  }
  
  private boolean conditionM0(String paramString, int paramInt)
  {
    if (charAt(paramString, paramInt + 1) == 'M') {}
    while ((contains(paramString, paramInt - 1, 3, "UMB")) && ((paramInt + 1 == paramString.length() - 1) || (contains(paramString, paramInt + 2, 2, "ER")))) {
      return true;
    }
    return false;
  }
  
  private static boolean contains(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    return contains(paramString1, paramInt1, paramInt2, new String[] { paramString2 });
  }
  
  private static boolean contains(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    return contains(paramString1, paramInt1, paramInt2, new String[] { paramString2, paramString3 });
  }
  
  private static boolean contains(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4)
  {
    return contains(paramString1, paramInt1, paramInt2, new String[] { paramString2, paramString3, paramString4 });
  }
  
  private static boolean contains(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    return contains(paramString1, paramInt1, paramInt2, new String[] { paramString2, paramString3, paramString4, paramString5 });
  }
  
  private static boolean contains(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return contains(paramString1, paramInt1, paramInt2, new String[] { paramString2, paramString3, paramString4, paramString5, paramString6 });
  }
  
  private static boolean contains(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    return contains(paramString1, paramInt1, paramInt2, new String[] { paramString2, paramString3, paramString4, paramString5, paramString6, paramString7 });
  }
  
  protected static boolean contains(String paramString, int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    if ((paramInt1 >= 0) && (paramInt1 + paramInt2 <= paramString.length()))
    {
      paramString = paramString.substring(paramInt1, paramInt1 + paramInt2);
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramInt1 >= paramArrayOfString.length) {
        return false;
      }
      if (paramString.equals(paramArrayOfString[paramInt1])) {
        return true;
      }
      paramInt1 += 1;
    }
  }
  
  private int handleAEIOUY(DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt)
  {
    if (paramInt == 0) {
      paramDoubleMetaphoneResult.append('A');
    }
    return paramInt + 1;
  }
  
  private int handleC(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt)
  {
    if (conditionC0(paramString, paramInt))
    {
      paramDoubleMetaphoneResult.append('K');
      paramInt += 2;
    }
    for (;;)
    {
      return paramInt;
      if ((paramInt == 0) && (contains(paramString, paramInt, 6, "CAESAR")))
      {
        paramDoubleMetaphoneResult.append('S');
        paramInt += 2;
      }
      else if (contains(paramString, paramInt, 2, "CH"))
      {
        paramInt = handleCH(paramString, paramDoubleMetaphoneResult, paramInt);
      }
      else if ((contains(paramString, paramInt, 2, "CZ")) && (!contains(paramString, paramInt - 2, 4, "WICZ")))
      {
        paramDoubleMetaphoneResult.append('S', 'X');
        paramInt += 2;
      }
      else if (contains(paramString, paramInt + 1, 3, "CIA"))
      {
        paramDoubleMetaphoneResult.append('X');
        paramInt += 3;
      }
      else
      {
        if ((contains(paramString, paramInt, 2, "CC")) && ((paramInt != 1) || (charAt(paramString, 0) != 'M'))) {
          return handleCC(paramString, paramDoubleMetaphoneResult, paramInt);
        }
        if (contains(paramString, paramInt, 2, "CK", "CG", "CQ"))
        {
          paramDoubleMetaphoneResult.append('K');
          paramInt += 2;
        }
        else
        {
          if (contains(paramString, paramInt, 2, "CI", "CE", "CY"))
          {
            if (contains(paramString, paramInt, 3, "CIO", "CIE", "CIA")) {
              paramDoubleMetaphoneResult.append('S', 'X');
            }
            for (;;)
            {
              paramInt += 2;
              break;
              paramDoubleMetaphoneResult.append('S');
            }
          }
          paramDoubleMetaphoneResult.append('K');
          if (contains(paramString, paramInt + 1, 2, " C", " Q", " G")) {
            paramInt += 3;
          } else if ((contains(paramString, paramInt + 1, 1, "C", "K", "Q")) && (!contains(paramString, paramInt + 1, 2, "CE", "CI"))) {
            paramInt += 2;
          } else {
            paramInt += 1;
          }
        }
      }
    }
  }
  
  private int handleCC(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt)
  {
    if ((contains(paramString, paramInt + 2, 1, "I", "E", "H")) && (!contains(paramString, paramInt + 2, 2, "HU")))
    {
      if (((paramInt == 1) && (charAt(paramString, paramInt - 1) == 'A')) || (contains(paramString, paramInt - 1, 5, "UCCEE", "UCCES"))) {
        paramDoubleMetaphoneResult.append("KS");
      }
      for (;;)
      {
        return paramInt + 3;
        paramDoubleMetaphoneResult.append('X');
      }
    }
    paramDoubleMetaphoneResult.append('K');
    return paramInt + 2;
  }
  
  private int handleCH(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt)
  {
    if ((paramInt > 0) && (contains(paramString, paramInt, 4, "CHAE")))
    {
      paramDoubleMetaphoneResult.append('K', 'X');
      return paramInt + 2;
    }
    if (conditionCH0(paramString, paramInt))
    {
      paramDoubleMetaphoneResult.append('K');
      return paramInt + 2;
    }
    if (conditionCH1(paramString, paramInt))
    {
      paramDoubleMetaphoneResult.append('K');
      return paramInt + 2;
    }
    if (paramInt > 0) {
      if (contains(paramString, 0, 2, "MC")) {
        paramDoubleMetaphoneResult.append('K');
      }
    }
    for (;;)
    {
      return paramInt + 2;
      paramDoubleMetaphoneResult.append('X', 'K');
      continue;
      paramDoubleMetaphoneResult.append('X');
    }
  }
  
  private int handleD(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt)
  {
    if (contains(paramString, paramInt, 2, "DG"))
    {
      if (contains(paramString, paramInt + 2, 1, "I", "E", "Y"))
      {
        paramDoubleMetaphoneResult.append('J');
        return paramInt + 3;
      }
      paramDoubleMetaphoneResult.append("TK");
      return paramInt + 2;
    }
    if (contains(paramString, paramInt, 2, "DT", "DD"))
    {
      paramDoubleMetaphoneResult.append('T');
      return paramInt + 2;
    }
    paramDoubleMetaphoneResult.append('T');
    return paramInt + 1;
  }
  
  private int handleG(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt, boolean paramBoolean)
  {
    if (charAt(paramString, paramInt + 1) == 'H') {
      return handleGH(paramString, paramDoubleMetaphoneResult, paramInt);
    }
    if (charAt(paramString, paramInt + 1) == 'N')
    {
      if ((paramInt == 1) && (isVowel(charAt(paramString, 0))) && (!paramBoolean)) {
        paramDoubleMetaphoneResult.append("KN", "N");
      }
      for (;;)
      {
        return paramInt + 2;
        if ((!contains(paramString, paramInt + 2, 2, "EY")) && (charAt(paramString, paramInt + 1) != 'Y') && (!paramBoolean)) {
          paramDoubleMetaphoneResult.append("N", "KN");
        } else {
          paramDoubleMetaphoneResult.append("KN");
        }
      }
    }
    if ((contains(paramString, paramInt + 1, 2, "LI")) && (!paramBoolean))
    {
      paramDoubleMetaphoneResult.append("KL", "L");
      return paramInt + 2;
    }
    if ((paramInt == 0) && ((charAt(paramString, paramInt + 1) == 'Y') || (contains(paramString, paramInt + 1, 2, ES_EP_EB_EL_EY_IB_IL_IN_IE_EI_ER))))
    {
      paramDoubleMetaphoneResult.append('K', 'J');
      return paramInt + 2;
    }
    if (((contains(paramString, paramInt + 1, 2, "ER")) || (charAt(paramString, paramInt + 1) == 'Y')) && (!contains(paramString, 0, 6, "DANGER", "RANGER", "MANGER")) && (!contains(paramString, paramInt - 1, 1, "E", "I")) && (!contains(paramString, paramInt - 1, 3, "RGY", "OGY")))
    {
      paramDoubleMetaphoneResult.append('K', 'J');
      return paramInt + 2;
    }
    if ((contains(paramString, paramInt + 1, 1, "E", "I", "Y")) || (contains(paramString, paramInt - 1, 4, "AGGI", "OGGI")))
    {
      if ((contains(paramString, 0, 4, "VAN ", "VON ")) || (contains(paramString, 0, 3, "SCH")) || (contains(paramString, paramInt + 1, 2, "ET"))) {
        paramDoubleMetaphoneResult.append('K');
      }
      for (;;)
      {
        return paramInt + 2;
        if (contains(paramString, paramInt + 1, 3, "IER")) {
          paramDoubleMetaphoneResult.append('J');
        } else {
          paramDoubleMetaphoneResult.append('J', 'K');
        }
      }
    }
    if (charAt(paramString, paramInt + 1) == 'G')
    {
      paramDoubleMetaphoneResult.append('K');
      return paramInt + 2;
    }
    paramDoubleMetaphoneResult.append('K');
    return paramInt + 1;
  }
  
  private int handleGH(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt)
  {
    if ((paramInt > 0) && (!isVowel(charAt(paramString, paramInt - 1))))
    {
      paramDoubleMetaphoneResult.append('K');
      return paramInt + 2;
    }
    if (paramInt == 0)
    {
      if (charAt(paramString, paramInt + 2) == 'I') {
        paramDoubleMetaphoneResult.append('J');
      }
      for (;;)
      {
        return paramInt + 2;
        paramDoubleMetaphoneResult.append('K');
      }
    }
    if (((paramInt > 1) && (contains(paramString, paramInt - 2, 1, "B", "H", "D"))) || ((paramInt > 2) && (contains(paramString, paramInt - 3, 1, "B", "H", "D"))) || ((paramInt > 3) && (contains(paramString, paramInt - 4, 1, "B", "H")))) {
      return paramInt + 2;
    }
    if ((paramInt > 2) && (charAt(paramString, paramInt - 1) == 'U') && (contains(paramString, paramInt - 3, 1, "C", "G", "L", "R", "T"))) {
      paramDoubleMetaphoneResult.append('F');
    }
    for (;;)
    {
      return paramInt + 2;
      if ((paramInt > 0) && (charAt(paramString, paramInt - 1) != 'I')) {
        paramDoubleMetaphoneResult.append('K');
      }
    }
  }
  
  private int handleH(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt)
  {
    if (((paramInt == 0) || (isVowel(charAt(paramString, paramInt - 1)))) && (isVowel(charAt(paramString, paramInt + 1))))
    {
      paramDoubleMetaphoneResult.append('H');
      return paramInt + 2;
    }
    return paramInt + 1;
  }
  
  private int handleJ(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt, boolean paramBoolean)
  {
    if ((contains(paramString, paramInt, 4, "JOSE")) || (contains(paramString, 0, 4, "SAN ")))
    {
      if (((paramInt == 0) && (charAt(paramString, paramInt + 4) == ' ')) || (paramString.length() == 4) || (contains(paramString, 0, 4, "SAN "))) {
        paramDoubleMetaphoneResult.append('H');
      }
      for (;;)
      {
        return paramInt + 1;
        paramDoubleMetaphoneResult.append('J', 'H');
      }
    }
    if ((paramInt == 0) && (!contains(paramString, paramInt, 4, "JOSE"))) {
      paramDoubleMetaphoneResult.append('J', 'A');
    }
    while (charAt(paramString, paramInt + 1) == 'J')
    {
      return paramInt + 2;
      if ((isVowel(charAt(paramString, paramInt - 1))) && (!paramBoolean) && ((charAt(paramString, paramInt + 1) == 'A') || (charAt(paramString, paramInt + 1) == 'O'))) {
        paramDoubleMetaphoneResult.append('J', 'H');
      } else if (paramInt == paramString.length() - 1) {
        paramDoubleMetaphoneResult.append('J', ' ');
      } else if ((!contains(paramString, paramInt + 1, 1, L_T_K_S_N_M_B_Z)) && (!contains(paramString, paramInt - 1, 1, "S", "K", "L"))) {
        paramDoubleMetaphoneResult.append('J');
      }
    }
    return paramInt + 1;
  }
  
  private int handleL(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt)
  {
    if (charAt(paramString, paramInt + 1) == 'L')
    {
      if (conditionL0(paramString, paramInt)) {
        paramDoubleMetaphoneResult.appendPrimary('L');
      }
      for (;;)
      {
        return paramInt + 2;
        paramDoubleMetaphoneResult.append('L');
      }
    }
    paramDoubleMetaphoneResult.append('L');
    return paramInt + 1;
  }
  
  private int handleP(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt)
  {
    if (charAt(paramString, paramInt + 1) == 'H')
    {
      paramDoubleMetaphoneResult.append('F');
      return paramInt + 2;
    }
    paramDoubleMetaphoneResult.append('P');
    if (contains(paramString, paramInt + 1, 1, "P", "B")) {
      return paramInt + 2;
    }
    return paramInt + 1;
  }
  
  private int handleR(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt, boolean paramBoolean)
  {
    if ((paramInt == paramString.length() - 1) && (!paramBoolean) && (contains(paramString, paramInt - 2, 2, "IE")) && (!contains(paramString, paramInt - 4, 2, "ME", "MA"))) {
      paramDoubleMetaphoneResult.appendAlternate('R');
    }
    while (charAt(paramString, paramInt + 1) == 'R')
    {
      return paramInt + 2;
      paramDoubleMetaphoneResult.append('R');
    }
    return paramInt + 1;
  }
  
  private int handleS(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt, boolean paramBoolean)
  {
    if (contains(paramString, paramInt - 1, 3, "ISL", "YSL")) {
      return paramInt + 1;
    }
    if ((paramInt == 0) && (contains(paramString, paramInt, 5, "SUGAR")))
    {
      paramDoubleMetaphoneResult.append('X', 'S');
      return paramInt + 1;
    }
    if (contains(paramString, paramInt, 2, "SH"))
    {
      if (contains(paramString, paramInt + 1, 4, "HEIM", "HOEK", "HOLM", "HOLZ")) {
        paramDoubleMetaphoneResult.append('S');
      }
      for (;;)
      {
        return paramInt + 2;
        paramDoubleMetaphoneResult.append('X');
      }
    }
    if ((contains(paramString, paramInt, 3, "SIO", "SIA")) || (contains(paramString, paramInt, 4, "SIAN")))
    {
      if (paramBoolean) {
        paramDoubleMetaphoneResult.append('S');
      }
      for (;;)
      {
        return paramInt + 3;
        paramDoubleMetaphoneResult.append('S', 'X');
      }
    }
    if (((paramInt == 0) && (contains(paramString, paramInt + 1, 1, "M", "N", "L", "W"))) || (contains(paramString, paramInt + 1, 1, "Z")))
    {
      paramDoubleMetaphoneResult.append('S', 'X');
      if (contains(paramString, paramInt + 1, 1, "Z")) {
        return paramInt + 2;
      }
      return paramInt + 1;
    }
    if (contains(paramString, paramInt, 2, "SC")) {
      return handleSC(paramString, paramDoubleMetaphoneResult, paramInt);
    }
    if ((paramInt == paramString.length() - 1) && (contains(paramString, paramInt - 2, 2, "AI", "OI"))) {
      paramDoubleMetaphoneResult.appendAlternate('S');
    }
    while (contains(paramString, paramInt + 1, 1, "S", "Z"))
    {
      return paramInt + 2;
      paramDoubleMetaphoneResult.append('S');
    }
    return paramInt + 1;
  }
  
  private int handleSC(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt)
  {
    if (charAt(paramString, paramInt + 2) == 'H') {
      if (contains(paramString, paramInt + 3, 2, "OO", "ER", "EN", "UY", "ED", "EM")) {
        if (contains(paramString, paramInt + 3, 2, "ER", "EN")) {
          paramDoubleMetaphoneResult.append("X", "SK");
        }
      }
    }
    for (;;)
    {
      return paramInt + 3;
      paramDoubleMetaphoneResult.append("SK");
      continue;
      if ((paramInt == 0) && (!isVowel(charAt(paramString, 3))) && (charAt(paramString, 3) != 'W'))
      {
        paramDoubleMetaphoneResult.append('X', 'S');
      }
      else
      {
        paramDoubleMetaphoneResult.append('X');
        continue;
        if (contains(paramString, paramInt + 2, 1, "I", "E", "Y")) {
          paramDoubleMetaphoneResult.append('S');
        } else {
          paramDoubleMetaphoneResult.append("SK");
        }
      }
    }
  }
  
  private int handleT(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt)
  {
    if (contains(paramString, paramInt, 4, "TION"))
    {
      paramDoubleMetaphoneResult.append('X');
      return paramInt + 3;
    }
    if (contains(paramString, paramInt, 3, "TIA", "TCH"))
    {
      paramDoubleMetaphoneResult.append('X');
      return paramInt + 3;
    }
    if ((contains(paramString, paramInt, 2, "TH")) || (contains(paramString, paramInt, 3, "TTH")))
    {
      if ((contains(paramString, paramInt + 2, 2, "OM", "AM")) || (contains(paramString, 0, 4, "VAN ", "VON ")) || (contains(paramString, 0, 3, "SCH"))) {
        paramDoubleMetaphoneResult.append('T');
      }
      for (;;)
      {
        return paramInt + 2;
        paramDoubleMetaphoneResult.append('0', 'T');
      }
    }
    paramDoubleMetaphoneResult.append('T');
    if (contains(paramString, paramInt + 1, 1, "T", "D")) {
      return paramInt + 2;
    }
    return paramInt + 1;
  }
  
  private int handleW(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt)
  {
    if (contains(paramString, paramInt, 2, "WR"))
    {
      paramDoubleMetaphoneResult.append('R');
      return paramInt + 2;
    }
    if ((paramInt == 0) && ((isVowel(charAt(paramString, paramInt + 1))) || (contains(paramString, paramInt, 2, "WH"))))
    {
      if (isVowel(charAt(paramString, paramInt + 1))) {
        paramDoubleMetaphoneResult.append('A', 'F');
      }
      for (;;)
      {
        return paramInt + 1;
        paramDoubleMetaphoneResult.append('A');
      }
    }
    if (((paramInt == paramString.length() - 1) && (isVowel(charAt(paramString, paramInt - 1)))) || (contains(paramString, paramInt - 1, 5, "EWSKI", "EWSKY", "OWSKI", "OWSKY")) || (contains(paramString, 0, 3, "SCH")))
    {
      paramDoubleMetaphoneResult.appendAlternate('F');
      return paramInt + 1;
    }
    if (contains(paramString, paramInt, 4, "WICZ", "WITZ"))
    {
      paramDoubleMetaphoneResult.append("TS", "FX");
      return paramInt + 4;
    }
    return paramInt + 1;
  }
  
  private int handleX(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt)
  {
    if (paramInt == 0)
    {
      paramDoubleMetaphoneResult.append('S');
      return paramInt + 1;
    }
    if ((paramInt != paramString.length() - 1) || ((!contains(paramString, paramInt - 3, 3, "IAU", "EAU")) && (!contains(paramString, paramInt - 2, 2, "AU", "OU")))) {
      paramDoubleMetaphoneResult.append("KS");
    }
    if (contains(paramString, paramInt + 1, 1, "C", "X")) {
      return paramInt + 2;
    }
    return paramInt + 1;
  }
  
  private int handleZ(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt, boolean paramBoolean)
  {
    if (charAt(paramString, paramInt + 1) == 'H')
    {
      paramDoubleMetaphoneResult.append('J');
      return paramInt + 2;
    }
    if ((contains(paramString, paramInt + 1, 2, "ZO", "ZI", "ZA")) || ((paramBoolean) && (paramInt > 0) && (charAt(paramString, paramInt - 1) != 'T'))) {
      paramDoubleMetaphoneResult.append("S", "TS");
    }
    while (charAt(paramString, paramInt + 1) == 'Z')
    {
      return paramInt + 2;
      paramDoubleMetaphoneResult.append('S');
    }
    return paramInt + 1;
  }
  
  private boolean isSilentStart(String paramString)
  {
    int i = 0;
    for (;;)
    {
      if (i >= SILENT_START.length) {
        return false;
      }
      if (paramString.startsWith(SILENT_START[i])) {
        return true;
      }
      i += 1;
    }
  }
  
  private boolean isSlavoGermanic(String paramString)
  {
    return (paramString.indexOf('W') > -1) || (paramString.indexOf('K') > -1) || (paramString.indexOf("CZ") > -1) || (paramString.indexOf("WITZ") > -1);
  }
  
  private boolean isVowel(char paramChar)
  {
    return "AEIOUY".indexOf(paramChar) != -1;
  }
  
  protected char charAt(String paramString, int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= paramString.length())) {
      return '\000';
    }
    return paramString.charAt(paramInt);
  }
  
  public String doubleMetaphone(String paramString)
  {
    return doubleMetaphone(paramString, false);
  }
  
  public String doubleMetaphone(String paramString, boolean paramBoolean)
  {
    paramString = cleanInput(paramString);
    if (paramString == null) {
      return null;
    }
    boolean bool = isSlavoGermanic(paramString);
    int i;
    DoubleMetaphoneResult localDoubleMetaphoneResult;
    if (isSilentStart(paramString))
    {
      i = 1;
      localDoubleMetaphoneResult = new DoubleMetaphoneResult(getMaxCodeLen());
    }
    for (;;)
    {
      if ((localDoubleMetaphoneResult.isComplete()) || (i > paramString.length() - 1))
      {
        if (!paramBoolean) {
          break label762;
        }
        return localDoubleMetaphoneResult.getAlternate();
        i = 0;
        break;
      }
      switch (paramString.charAt(i))
      {
      default: 
        i += 1;
        break;
      case 'A': 
      case 'E': 
      case 'I': 
      case 'O': 
      case 'U': 
      case 'Y': 
        i = handleAEIOUY(localDoubleMetaphoneResult, i);
        break;
      case 'B': 
        localDoubleMetaphoneResult.append('P');
        if (charAt(paramString, i + 1) == 'B') {
          i += 2;
        }
        for (;;)
        {
          break;
          i += 1;
        }
      case 'Ç': 
        localDoubleMetaphoneResult.append('S');
        i += 1;
        break;
      case 'C': 
        i = handleC(paramString, localDoubleMetaphoneResult, i);
        break;
      case 'D': 
        i = handleD(paramString, localDoubleMetaphoneResult, i);
        break;
      case 'F': 
        localDoubleMetaphoneResult.append('F');
        if (charAt(paramString, i + 1) == 'F') {
          i += 2;
        }
        for (;;)
        {
          break;
          i += 1;
        }
      case 'G': 
        i = handleG(paramString, localDoubleMetaphoneResult, i, bool);
        break;
      case 'H': 
        i = handleH(paramString, localDoubleMetaphoneResult, i);
        break;
      case 'J': 
        i = handleJ(paramString, localDoubleMetaphoneResult, i, bool);
        break;
      case 'K': 
        localDoubleMetaphoneResult.append('K');
        if (charAt(paramString, i + 1) == 'K') {
          i += 2;
        }
        for (;;)
        {
          break;
          i += 1;
        }
      case 'L': 
        i = handleL(paramString, localDoubleMetaphoneResult, i);
        break;
      case 'M': 
        localDoubleMetaphoneResult.append('M');
        if (conditionM0(paramString, i)) {
          i += 2;
        }
        for (;;)
        {
          break;
          i += 1;
        }
      case 'N': 
        localDoubleMetaphoneResult.append('N');
        if (charAt(paramString, i + 1) == 'N') {
          i += 2;
        }
        for (;;)
        {
          break;
          i += 1;
        }
      case 'Ñ': 
        localDoubleMetaphoneResult.append('N');
        i += 1;
        break;
      case 'P': 
        i = handleP(paramString, localDoubleMetaphoneResult, i);
        break;
      case 'Q': 
        localDoubleMetaphoneResult.append('K');
        if (charAt(paramString, i + 1) == 'Q') {
          i += 2;
        }
        for (;;)
        {
          break;
          i += 1;
        }
      case 'R': 
        i = handleR(paramString, localDoubleMetaphoneResult, i, bool);
        break;
      case 'S': 
        i = handleS(paramString, localDoubleMetaphoneResult, i, bool);
        break;
      case 'T': 
        i = handleT(paramString, localDoubleMetaphoneResult, i);
        break;
      case 'V': 
        localDoubleMetaphoneResult.append('F');
        if (charAt(paramString, i + 1) == 'V') {
          i += 2;
        }
        for (;;)
        {
          break;
          i += 1;
        }
      case 'W': 
        i = handleW(paramString, localDoubleMetaphoneResult, i);
        break;
      case 'X': 
        i = handleX(paramString, localDoubleMetaphoneResult, i);
        break;
      case 'Z': 
        i = handleZ(paramString, localDoubleMetaphoneResult, i, bool);
      }
    }
    label762:
    return localDoubleMetaphoneResult.getPrimary();
  }
  
  public Object encode(Object paramObject)
    throws EncoderException
  {
    if (!(paramObject instanceof String)) {
      throw new EncoderException("DoubleMetaphone encode parameter is not of type String");
    }
    return doubleMetaphone((String)paramObject);
  }
  
  public String encode(String paramString)
  {
    return doubleMetaphone(paramString);
  }
  
  public int getMaxCodeLen()
  {
    return this.maxCodeLen;
  }
  
  public boolean isDoubleMetaphoneEqual(String paramString1, String paramString2)
  {
    return isDoubleMetaphoneEqual(paramString1, paramString2, false);
  }
  
  public boolean isDoubleMetaphoneEqual(String paramString1, String paramString2, boolean paramBoolean)
  {
    return doubleMetaphone(paramString1, paramBoolean).equals(doubleMetaphone(paramString2, paramBoolean));
  }
  
  public void setMaxCodeLen(int paramInt)
  {
    this.maxCodeLen = paramInt;
  }
  
  public class DoubleMetaphoneResult
  {
    private StringBuffer alternate = new StringBuffer(DoubleMetaphone.this.getMaxCodeLen());
    private int maxLength;
    private StringBuffer primary = new StringBuffer(DoubleMetaphone.this.getMaxCodeLen());
    
    public DoubleMetaphoneResult(int paramInt)
    {
      this.maxLength = paramInt;
    }
    
    public void append(char paramChar)
    {
      appendPrimary(paramChar);
      appendAlternate(paramChar);
    }
    
    public void append(char paramChar1, char paramChar2)
    {
      appendPrimary(paramChar1);
      appendAlternate(paramChar2);
    }
    
    public void append(String paramString)
    {
      appendPrimary(paramString);
      appendAlternate(paramString);
    }
    
    public void append(String paramString1, String paramString2)
    {
      appendPrimary(paramString1);
      appendAlternate(paramString2);
    }
    
    public void appendAlternate(char paramChar)
    {
      if (this.alternate.length() < this.maxLength) {
        this.alternate.append(paramChar);
      }
    }
    
    public void appendAlternate(String paramString)
    {
      int i = this.maxLength - this.alternate.length();
      if (paramString.length() <= i)
      {
        this.alternate.append(paramString);
        return;
      }
      this.alternate.append(paramString.substring(0, i));
    }
    
    public void appendPrimary(char paramChar)
    {
      if (this.primary.length() < this.maxLength) {
        this.primary.append(paramChar);
      }
    }
    
    public void appendPrimary(String paramString)
    {
      int i = this.maxLength - this.primary.length();
      if (paramString.length() <= i)
      {
        this.primary.append(paramString);
        return;
      }
      this.primary.append(paramString.substring(0, i));
    }
    
    public String getAlternate()
    {
      return this.alternate.toString();
    }
    
    public String getPrimary()
    {
      return this.primary.toString();
    }
    
    public boolean isComplete()
    {
      return (this.primary.length() >= this.maxLength) && (this.alternate.length() >= this.maxLength);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/codec/language/DoubleMetaphone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */