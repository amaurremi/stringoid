package com.squareup.okhttp;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class MediaType
{
  private static final Pattern PARAMETER = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
  private static final String QUOTED = "\"([^\"]*)\"";
  private static final String TOKEN = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
  private static final Pattern TYPE_SUBTYPE = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
  private final String charset;
  private final String mediaType;
  private final String subtype;
  private final String type;
  
  private MediaType(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.mediaType = paramString1;
    this.type = paramString2;
    this.subtype = paramString3;
    this.charset = paramString4;
  }
  
  public static MediaType parse(String paramString)
  {
    Object localObject2 = TYPE_SUBTYPE.matcher(paramString);
    if (!((Matcher)localObject2).lookingAt()) {
      return null;
    }
    String str1 = ((Matcher)localObject2).group(1).toLowerCase(Locale.US);
    String str2 = ((Matcher)localObject2).group(2).toLowerCase(Locale.US);
    Object localObject1 = null;
    Matcher localMatcher = PARAMETER.matcher(paramString);
    int i = ((Matcher)localObject2).end();
    for (;;)
    {
      if (i < paramString.length())
      {
        localMatcher.region(i, paramString.length());
        if (!localMatcher.lookingAt()) {
          break;
        }
        String str3 = localMatcher.group(1);
        localObject2 = localObject1;
        if (str3 != null)
        {
          if (!str3.equalsIgnoreCase("charset")) {
            localObject2 = localObject1;
          }
        }
        else
        {
          i = localMatcher.end();
          localObject1 = localObject2;
          continue;
        }
        if (localObject1 != null) {
          throw new IllegalArgumentException("Multiple charsets: " + paramString);
        }
        if (localMatcher.group(2) != null) {}
        for (localObject1 = localMatcher.group(2);; localObject1 = localMatcher.group(3))
        {
          localObject2 = localObject1;
          break;
        }
      }
    }
    return new MediaType(paramString, str1, str2, (String)localObject1);
  }
  
  public Charset charset()
  {
    if (this.charset != null) {
      return Charset.forName(this.charset);
    }
    return null;
  }
  
  public Charset charset(Charset paramCharset)
  {
    if (this.charset != null) {
      paramCharset = Charset.forName(this.charset);
    }
    return paramCharset;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof MediaType)) && (((MediaType)paramObject).mediaType.equals(this.mediaType));
  }
  
  public int hashCode()
  {
    return this.mediaType.hashCode();
  }
  
  public String subtype()
  {
    return this.subtype;
  }
  
  public String toString()
  {
    return this.mediaType;
  }
  
  public String type()
  {
    return this.type;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/squareup/okhttp/MediaType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */