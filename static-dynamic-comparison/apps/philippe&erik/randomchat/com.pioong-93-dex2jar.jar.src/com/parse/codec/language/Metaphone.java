package com.parse.codec.language;

import com.parse.codec.EncoderException;
import com.parse.codec.StringEncoder;
import java.util.Locale;

public class Metaphone
  implements StringEncoder
{
  private static final String FRONTV = "EIY";
  private static final String VARSON = "CSPTG";
  private static final String VOWELS = "AEIOU";
  private int maxCodeLen = 4;
  
  private boolean isLastChar(int paramInt1, int paramInt2)
  {
    return paramInt2 + 1 == paramInt1;
  }
  
  private boolean isNextChar(StringBuffer paramStringBuffer, int paramInt, char paramChar)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt >= 0)
    {
      bool1 = bool2;
      if (paramInt < paramStringBuffer.length() - 1)
      {
        if (paramStringBuffer.charAt(paramInt + 1) != paramChar) {
          break label42;
        }
        bool1 = true;
      }
    }
    return bool1;
    label42:
    return false;
  }
  
  private boolean isPreviousChar(StringBuffer paramStringBuffer, int paramInt, char paramChar)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt > 0)
    {
      bool1 = bool2;
      if (paramInt < paramStringBuffer.length())
      {
        if (paramStringBuffer.charAt(paramInt - 1) != paramChar) {
          break label40;
        }
        bool1 = true;
      }
    }
    return bool1;
    label40:
    return false;
  }
  
  private boolean isVowel(StringBuffer paramStringBuffer, int paramInt)
  {
    return "AEIOU".indexOf(paramStringBuffer.charAt(paramInt)) >= 0;
  }
  
  private boolean regionMatch(StringBuffer paramStringBuffer, int paramInt, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt >= 0)
    {
      bool1 = bool2;
      if (paramString.length() + paramInt - 1 < paramStringBuffer.length()) {
        bool1 = paramStringBuffer.substring(paramInt, paramString.length() + paramInt).equals(paramString);
      }
    }
    return bool1;
  }
  
  public Object encode(Object paramObject)
    throws EncoderException
  {
    if (!(paramObject instanceof String)) {
      throw new EncoderException("Parameter supplied to Metaphone encode is not of type java.lang.String");
    }
    return metaphone((String)paramObject);
  }
  
  public String encode(String paramString)
  {
    return metaphone(paramString);
  }
  
  public int getMaxCodeLen()
  {
    return this.maxCodeLen;
  }
  
  public boolean isMetaphoneEqual(String paramString1, String paramString2)
  {
    return metaphone(paramString1).equals(metaphone(paramString2));
  }
  
  public String metaphone(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return "";
    }
    if (paramString.length() == 1) {
      return paramString.toUpperCase(Locale.ENGLISH);
    }
    paramString = paramString.toUpperCase(Locale.ENGLISH).toCharArray();
    StringBuffer localStringBuffer1 = new StringBuffer(40);
    StringBuffer localStringBuffer2 = new StringBuffer(10);
    int k;
    int i;
    switch (paramString[0])
    {
    default: 
      localStringBuffer1.append(paramString);
      k = localStringBuffer1.length();
      i = 0;
    }
    char c;
    int j;
    for (;;)
    {
      if ((localStringBuffer2.length() >= getMaxCodeLen()) || (i >= k))
      {
        return localStringBuffer2.toString();
        if (paramString[1] == 'N')
        {
          localStringBuffer1.append(paramString, 1, paramString.length - 1);
          break;
        }
        localStringBuffer1.append(paramString);
        break;
        if (paramString[1] == 'E')
        {
          localStringBuffer1.append(paramString, 1, paramString.length - 1);
          break;
        }
        localStringBuffer1.append(paramString);
        break;
        if (paramString[1] == 'R')
        {
          localStringBuffer1.append(paramString, 1, paramString.length - 1);
          break;
        }
        if (paramString[1] == 'H')
        {
          localStringBuffer1.append(paramString, 1, paramString.length - 1);
          localStringBuffer1.setCharAt(0, 'W');
          break;
        }
        localStringBuffer1.append(paramString);
        break;
        paramString[0] = 83;
        localStringBuffer1.append(paramString);
        break;
      }
      c = localStringBuffer1.charAt(i);
      if ((c == 'C') || (!isPreviousChar(localStringBuffer1, i, c))) {
        break label368;
      }
      j = i + 1;
      i = j;
      if (localStringBuffer2.length() > getMaxCodeLen())
      {
        localStringBuffer2.setLength(getMaxCodeLen());
        i = j;
      }
    }
    switch (c)
    {
    default: 
      label368:
      j = i;
    }
    for (;;)
    {
      j += 1;
      break;
      j = i;
      if (i == 0)
      {
        localStringBuffer2.append(c);
        j = i;
        continue;
        if (isPreviousChar(localStringBuffer1, i, 'M'))
        {
          j = i;
          if (isLastChar(k, i)) {}
        }
        else
        {
          localStringBuffer2.append(c);
          j = i;
          continue;
          if ((isPreviousChar(localStringBuffer1, i, 'S')) && (!isLastChar(k, i)))
          {
            j = i;
            if ("EIY".indexOf(localStringBuffer1.charAt(i + 1)) >= 0) {}
          }
          else if (regionMatch(localStringBuffer1, i, "CIA"))
          {
            localStringBuffer2.append('X');
            j = i;
          }
          else if ((!isLastChar(k, i)) && ("EIY".indexOf(localStringBuffer1.charAt(i + 1)) >= 0))
          {
            localStringBuffer2.append('S');
            j = i;
          }
          else if ((isPreviousChar(localStringBuffer1, i, 'S')) && (isNextChar(localStringBuffer1, i, 'H')))
          {
            localStringBuffer2.append('K');
            j = i;
          }
          else if (isNextChar(localStringBuffer1, i, 'H'))
          {
            if ((i == 0) && (k >= 3) && (isVowel(localStringBuffer1, 2)))
            {
              localStringBuffer2.append('K');
              j = i;
            }
            else
            {
              localStringBuffer2.append('X');
              j = i;
            }
          }
          else
          {
            localStringBuffer2.append('K');
            j = i;
            continue;
            if ((!isLastChar(k, i + 1)) && (isNextChar(localStringBuffer1, i, 'G')) && ("EIY".indexOf(localStringBuffer1.charAt(i + 2)) >= 0))
            {
              localStringBuffer2.append('J');
              j = i + 2;
            }
            else
            {
              localStringBuffer2.append('T');
              j = i;
              continue;
              if (isLastChar(k, i + 1))
              {
                j = i;
                if (isNextChar(localStringBuffer1, i, 'H')) {}
              }
              else if ((!isLastChar(k, i + 1)) && (isNextChar(localStringBuffer1, i, 'H')))
              {
                j = i;
                if (!isVowel(localStringBuffer1, i + 2)) {}
              }
              else if (i > 0)
              {
                j = i;
                if (!regionMatch(localStringBuffer1, i, "GN"))
                {
                  j = i;
                  if (regionMatch(localStringBuffer1, i, "GNED")) {}
                }
              }
              else
              {
                if (isPreviousChar(localStringBuffer1, i, 'G')) {}
                for (j = 1;; j = 0)
                {
                  if ((isLastChar(k, i)) || ("EIY".indexOf(localStringBuffer1.charAt(i + 1)) < 0) || (j != 0)) {
                    break label1013;
                  }
                  localStringBuffer2.append('J');
                  j = i;
                  break;
                }
                label1013:
                localStringBuffer2.append('K');
                j = i;
                continue;
                j = i;
                if (!isLastChar(k, i)) {
                  if (i > 0)
                  {
                    j = i;
                    if ("CSPTG".indexOf(localStringBuffer1.charAt(i - 1)) >= 0) {}
                  }
                  else
                  {
                    j = i;
                    if (isVowel(localStringBuffer1, i + 1))
                    {
                      localStringBuffer2.append('H');
                      j = i;
                      continue;
                      localStringBuffer2.append(c);
                      j = i;
                      continue;
                      if (i > 0)
                      {
                        j = i;
                        if (!isPreviousChar(localStringBuffer1, i, 'C'))
                        {
                          localStringBuffer2.append(c);
                          j = i;
                        }
                      }
                      else
                      {
                        localStringBuffer2.append(c);
                        j = i;
                        continue;
                        if (isNextChar(localStringBuffer1, i, 'H'))
                        {
                          localStringBuffer2.append('F');
                          j = i;
                        }
                        else
                        {
                          localStringBuffer2.append(c);
                          j = i;
                          continue;
                          localStringBuffer2.append('K');
                          j = i;
                          continue;
                          if ((regionMatch(localStringBuffer1, i, "SH")) || (regionMatch(localStringBuffer1, i, "SIO")) || (regionMatch(localStringBuffer1, i, "SIA")))
                          {
                            localStringBuffer2.append('X');
                            j = i;
                          }
                          else
                          {
                            localStringBuffer2.append('S');
                            j = i;
                            continue;
                            if ((regionMatch(localStringBuffer1, i, "TIA")) || (regionMatch(localStringBuffer1, i, "TIO")))
                            {
                              localStringBuffer2.append('X');
                              j = i;
                            }
                            else
                            {
                              j = i;
                              if (!regionMatch(localStringBuffer1, i, "TCH")) {
                                if (regionMatch(localStringBuffer1, i, "TH"))
                                {
                                  localStringBuffer2.append('0');
                                  j = i;
                                }
                                else
                                {
                                  localStringBuffer2.append('T');
                                  j = i;
                                  continue;
                                  localStringBuffer2.append('F');
                                  j = i;
                                  continue;
                                  j = i;
                                  if (!isLastChar(k, i))
                                  {
                                    j = i;
                                    if (isVowel(localStringBuffer1, i + 1))
                                    {
                                      localStringBuffer2.append(c);
                                      j = i;
                                      continue;
                                      localStringBuffer2.append('K');
                                      localStringBuffer2.append('S');
                                      j = i;
                                      continue;
                                      localStringBuffer2.append('S');
                                      j = i;
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void setMaxCodeLen(int paramInt)
  {
    this.maxCodeLen = paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/codec/language/Metaphone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */