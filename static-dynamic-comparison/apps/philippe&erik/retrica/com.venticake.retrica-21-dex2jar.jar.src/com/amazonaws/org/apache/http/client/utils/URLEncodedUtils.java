package com.amazonaws.org.apache.http.client.utils;

import com.amazonaws.org.apache.http.Consts;
import com.amazonaws.org.apache.http.NameValuePair;
import com.amazonaws.org.apache.http.message.BasicHeaderValueParser;
import com.amazonaws.org.apache.http.message.BasicNameValuePair;
import com.amazonaws.org.apache.http.message.ParserCursor;
import com.amazonaws.org.apache.http.util.CharArrayBuffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.http.annotation.Immutable;

@Immutable
public class URLEncodedUtils
{
  private static final char[] DELIM = { '&' };
  private static final BitSet FRAGMENT;
  private static final BitSet PATHSAFE;
  private static final BitSet PUNCT;
  private static final BitSet RESERVED;
  private static final BitSet UNRESERVED = new BitSet(256);
  private static final BitSet URLENCODER;
  private static final BitSet USERINFO;
  
  static
  {
    PUNCT = new BitSet(256);
    USERINFO = new BitSet(256);
    PATHSAFE = new BitSet(256);
    FRAGMENT = new BitSet(256);
    RESERVED = new BitSet(256);
    URLENCODER = new BitSet(256);
    int i = 97;
    while (i <= 122)
    {
      UNRESERVED.set(i);
      i += 1;
    }
    i = 65;
    while (i <= 90)
    {
      UNRESERVED.set(i);
      i += 1;
    }
    i = 48;
    while (i <= 57)
    {
      UNRESERVED.set(i);
      i += 1;
    }
    UNRESERVED.set(95);
    UNRESERVED.set(45);
    UNRESERVED.set(46);
    UNRESERVED.set(42);
    URLENCODER.or(UNRESERVED);
    UNRESERVED.set(33);
    UNRESERVED.set(126);
    UNRESERVED.set(39);
    UNRESERVED.set(40);
    UNRESERVED.set(41);
    PUNCT.set(44);
    PUNCT.set(59);
    PUNCT.set(58);
    PUNCT.set(36);
    PUNCT.set(38);
    PUNCT.set(43);
    PUNCT.set(61);
    USERINFO.or(UNRESERVED);
    USERINFO.or(PUNCT);
    PATHSAFE.or(UNRESERVED);
    PATHSAFE.set(47);
    PATHSAFE.set(59);
    PATHSAFE.set(58);
    PATHSAFE.set(64);
    PATHSAFE.set(38);
    PATHSAFE.set(61);
    PATHSAFE.set(43);
    PATHSAFE.set(36);
    PATHSAFE.set(44);
    RESERVED.set(59);
    RESERVED.set(47);
    RESERVED.set(63);
    RESERVED.set(58);
    RESERVED.set(64);
    RESERVED.set(38);
    RESERVED.set(61);
    RESERVED.set(43);
    RESERVED.set(36);
    RESERVED.set(44);
    RESERVED.set(91);
    RESERVED.set(93);
    FRAGMENT.or(RESERVED);
    FRAGMENT.or(UNRESERVED);
  }
  
  private static String decodeFormFields(String paramString, Charset paramCharset)
  {
    if (paramString == null) {
      return null;
    }
    if (paramCharset != null) {}
    for (;;)
    {
      return urldecode(paramString, paramCharset, true);
      paramCharset = Consts.UTF_8;
    }
  }
  
  static String encFragment(String paramString, Charset paramCharset)
  {
    return urlencode(paramString, paramCharset, FRAGMENT, false);
  }
  
  static String encPath(String paramString, Charset paramCharset)
  {
    return urlencode(paramString, paramCharset, PATHSAFE, false);
  }
  
  static String encUserInfo(String paramString, Charset paramCharset)
  {
    return urlencode(paramString, paramCharset, USERINFO, false);
  }
  
  private static String encodeFormFields(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return null;
    }
    if (paramString2 != null) {}
    for (paramString2 = Charset.forName(paramString2);; paramString2 = Consts.UTF_8) {
      return urlencode(paramString1, paramString2, URLENCODER, true);
    }
  }
  
  private static String encodeFormFields(String paramString, Charset paramCharset)
  {
    if (paramString == null) {
      return null;
    }
    if (paramCharset != null) {}
    for (;;)
    {
      return urlencode(paramString, paramCharset, URLENCODER, true);
      paramCharset = Consts.UTF_8;
    }
  }
  
  public static String format(Iterable<? extends NameValuePair> paramIterable, Charset paramCharset)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = (NameValuePair)paramIterable.next();
      String str = encodeFormFields(((NameValuePair)localObject).getName(), paramCharset);
      localObject = encodeFormFields(((NameValuePair)localObject).getValue(), paramCharset);
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append("&");
      }
      localStringBuilder.append(str);
      if (localObject != null)
      {
        localStringBuilder.append("=");
        localStringBuilder.append((String)localObject);
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String format(List<? extends NameValuePair> paramList, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (NameValuePair)paramList.next();
      String str = encodeFormFields(((NameValuePair)localObject).getName(), paramString);
      localObject = encodeFormFields(((NameValuePair)localObject).getValue(), paramString);
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append("&");
      }
      localStringBuilder.append(str);
      if (localObject != null)
      {
        localStringBuilder.append("=");
        localStringBuilder.append((String)localObject);
      }
    }
    return localStringBuilder.toString();
  }
  
  public static List<NameValuePair> parse(String paramString, Charset paramCharset)
  {
    if (paramString == null)
    {
      paramString = Collections.emptyList();
      return paramString;
    }
    BasicHeaderValueParser localBasicHeaderValueParser = BasicHeaderValueParser.DEFAULT;
    CharArrayBuffer localCharArrayBuffer = new CharArrayBuffer(paramString.length());
    localCharArrayBuffer.append(paramString);
    ParserCursor localParserCursor = new ParserCursor(0, localCharArrayBuffer.length());
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      paramString = localArrayList;
      if (localParserCursor.atEnd()) {
        break;
      }
      paramString = localBasicHeaderValueParser.parseNameValuePair(localCharArrayBuffer, localParserCursor, DELIM);
      if (paramString.getName().length() > 0) {
        localArrayList.add(new BasicNameValuePair(decodeFormFields(paramString.getName(), paramCharset), decodeFormFields(paramString.getValue(), paramCharset)));
      }
    }
  }
  
  private static String urldecode(String paramString, Charset paramCharset, boolean paramBoolean)
  {
    if (paramString == null) {
      return null;
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramString.length());
    paramString = CharBuffer.wrap(paramString);
    while (paramString.hasRemaining())
    {
      int i = paramString.get();
      if ((i == 37) && (paramString.remaining() >= 2))
      {
        char c1 = paramString.get();
        char c2 = paramString.get();
        i = Character.digit(c1, 16);
        int j = Character.digit(c2, 16);
        if ((i != -1) && (j != -1))
        {
          localByteBuffer.put((byte)((i << 4) + j));
        }
        else
        {
          localByteBuffer.put((byte)37);
          localByteBuffer.put((byte)c1);
          localByteBuffer.put((byte)c2);
        }
      }
      else if ((paramBoolean) && (i == 43))
      {
        localByteBuffer.put((byte)32);
      }
      else
      {
        localByteBuffer.put((byte)i);
      }
    }
    localByteBuffer.flip();
    return paramCharset.decode(localByteBuffer).toString();
  }
  
  private static String urlencode(String paramString, Charset paramCharset, BitSet paramBitSet, boolean paramBoolean)
  {
    if (paramString == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramString = paramCharset.encode(paramString);
    while (paramString.hasRemaining())
    {
      int i = paramString.get() & 0xFF;
      if (paramBitSet.get(i))
      {
        localStringBuilder.append((char)i);
      }
      else if ((paramBoolean) && (i == 32))
      {
        localStringBuilder.append('+');
      }
      else
      {
        localStringBuilder.append("%");
        char c1 = Character.toUpperCase(Character.forDigit(i >> 4 & 0xF, 16));
        char c2 = Character.toUpperCase(Character.forDigit(i & 0xF, 16));
        localStringBuilder.append(c1);
        localStringBuilder.append(c2);
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/client/utils/URLEncodedUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */