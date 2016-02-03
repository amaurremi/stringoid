package com.amazonaws.org.apache.http.message;

import com.amazonaws.org.apache.http.HeaderElement;
import com.amazonaws.org.apache.http.NameValuePair;
import com.amazonaws.org.apache.http.util.CharArrayBuffer;
import org.apache.http.annotation.Immutable;

@Immutable
public class BasicHeaderValueFormatter
{
  public static final BasicHeaderValueFormatter DEFAULT = new BasicHeaderValueFormatter();
  
  protected void doFormatValue(CharArrayBuffer paramCharArrayBuffer, String paramString, boolean paramBoolean)
  {
    int j = 0;
    boolean bool = paramBoolean;
    if (!paramBoolean)
    {
      i = 0;
      for (;;)
      {
        bool = paramBoolean;
        if (i >= paramString.length()) {
          break;
        }
        bool = paramBoolean;
        if (paramBoolean) {
          break;
        }
        paramBoolean = isSeparator(paramString.charAt(i));
        i += 1;
      }
    }
    int i = j;
    if (bool)
    {
      paramCharArrayBuffer.append('"');
      i = j;
    }
    while (i < paramString.length())
    {
      char c = paramString.charAt(i);
      if (isUnsafe(c)) {
        paramCharArrayBuffer.append('\\');
      }
      paramCharArrayBuffer.append(c);
      i += 1;
    }
    if (bool) {
      paramCharArrayBuffer.append('"');
    }
  }
  
  protected int estimateHeaderElementLen(HeaderElement paramHeaderElement)
  {
    int k = 0;
    int j;
    if (paramHeaderElement == null) {
      j = 0;
    }
    int i;
    int m;
    do
    {
      return j;
      j = paramHeaderElement.getName().length();
      String str = paramHeaderElement.getValue();
      i = j;
      if (str != null) {
        i = j + (str.length() + 3);
      }
      m = paramHeaderElement.getParameterCount();
      j = i;
    } while (m <= 0);
    for (;;)
    {
      j = i;
      if (k >= m) {
        break;
      }
      i += estimateNameValuePairLen(paramHeaderElement.getParameter(k)) + 2;
      k += 1;
    }
  }
  
  protected int estimateNameValuePairLen(NameValuePair paramNameValuePair)
  {
    int i;
    if (paramNameValuePair == null) {
      i = 0;
    }
    int j;
    do
    {
      return i;
      j = paramNameValuePair.getName().length();
      paramNameValuePair = paramNameValuePair.getValue();
      i = j;
    } while (paramNameValuePair == null);
    return j + (paramNameValuePair.length() + 3);
  }
  
  public CharArrayBuffer formatHeaderElement(CharArrayBuffer paramCharArrayBuffer, HeaderElement paramHeaderElement, boolean paramBoolean)
  {
    if (paramHeaderElement == null) {
      throw new IllegalArgumentException("Header element must not be null.");
    }
    int i = estimateHeaderElementLen(paramHeaderElement);
    if (paramCharArrayBuffer == null) {
      paramCharArrayBuffer = new CharArrayBuffer(i);
    }
    for (;;)
    {
      paramCharArrayBuffer.append(paramHeaderElement.getName());
      String str = paramHeaderElement.getValue();
      if (str != null)
      {
        paramCharArrayBuffer.append('=');
        doFormatValue(paramCharArrayBuffer, str, paramBoolean);
      }
      int j = paramHeaderElement.getParameterCount();
      if (j <= 0) {
        break;
      }
      i = 0;
      while (i < j)
      {
        paramCharArrayBuffer.append("; ");
        formatNameValuePair(paramCharArrayBuffer, paramHeaderElement.getParameter(i), paramBoolean);
        i += 1;
      }
      paramCharArrayBuffer.ensureCapacity(i);
    }
    return paramCharArrayBuffer;
  }
  
  public CharArrayBuffer formatNameValuePair(CharArrayBuffer paramCharArrayBuffer, NameValuePair paramNameValuePair, boolean paramBoolean)
  {
    if (paramNameValuePair == null) {
      throw new IllegalArgumentException("NameValuePair must not be null.");
    }
    int i = estimateNameValuePairLen(paramNameValuePair);
    if (paramCharArrayBuffer == null) {
      paramCharArrayBuffer = new CharArrayBuffer(i);
    }
    for (;;)
    {
      paramCharArrayBuffer.append(paramNameValuePair.getName());
      paramNameValuePair = paramNameValuePair.getValue();
      if (paramNameValuePair != null)
      {
        paramCharArrayBuffer.append('=');
        doFormatValue(paramCharArrayBuffer, paramNameValuePair, paramBoolean);
      }
      return paramCharArrayBuffer;
      paramCharArrayBuffer.ensureCapacity(i);
    }
  }
  
  protected boolean isSeparator(char paramChar)
  {
    return " ;,:@()<>\\\"/[]?={}\t".indexOf(paramChar) >= 0;
  }
  
  protected boolean isUnsafe(char paramChar)
  {
    return "\"\\".indexOf(paramChar) >= 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/message/BasicHeaderValueFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */