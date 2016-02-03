package com.amazonaws.org.apache.http.entity;

import com.amazonaws.org.apache.http.Consts;
import java.nio.charset.Charset;
import java.util.Locale;
import org.apache.http.annotation.Immutable;

@Immutable
public final class ContentType
{
  public static final ContentType APPLICATION_ATOM_XML = create("application/atom+xml", Consts.ISO_8859_1);
  public static final ContentType APPLICATION_FORM_URLENCODED = create("application/x-www-form-urlencoded", Consts.ISO_8859_1);
  public static final ContentType APPLICATION_JSON = create("application/json", Consts.UTF_8);
  public static final ContentType APPLICATION_OCTET_STREAM = create("application/octet-stream", (Charset)null);
  public static final ContentType APPLICATION_SVG_XML = create("application/svg+xml", Consts.ISO_8859_1);
  public static final ContentType APPLICATION_XHTML_XML = create("application/xhtml+xml", Consts.ISO_8859_1);
  public static final ContentType APPLICATION_XML = create("application/xml", Consts.ISO_8859_1);
  public static final ContentType DEFAULT_BINARY = APPLICATION_OCTET_STREAM;
  public static final ContentType DEFAULT_TEXT;
  public static final ContentType MULTIPART_FORM_DATA = create("multipart/form-data", Consts.ISO_8859_1);
  public static final ContentType TEXT_HTML = create("text/html", Consts.ISO_8859_1);
  public static final ContentType TEXT_PLAIN = create("text/plain", Consts.ISO_8859_1);
  public static final ContentType TEXT_XML = create("text/xml", Consts.ISO_8859_1);
  public static final ContentType WILDCARD = create("*/*", (Charset)null);
  private final Charset charset;
  private final String mimeType;
  
  static
  {
    DEFAULT_TEXT = TEXT_PLAIN;
  }
  
  ContentType(String paramString, Charset paramCharset)
  {
    this.mimeType = paramString;
    this.charset = paramCharset;
  }
  
  public static ContentType create(String paramString, Charset paramCharset)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("MIME type may not be null");
    }
    paramString = paramString.trim().toLowerCase(Locale.US);
    if (paramString.length() == 0) {
      throw new IllegalArgumentException("MIME type may not be empty");
    }
    if (!valid(paramString)) {
      throw new IllegalArgumentException("MIME type may not contain reserved characters");
    }
    return new ContentType(paramString, paramCharset);
  }
  
  private static boolean valid(String paramString)
  {
    int i = 0;
    while (i < paramString.length())
    {
      int j = paramString.charAt(i);
      if ((j == 34) || (j == 44) || (j == 59)) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public Charset getCharset()
  {
    return this.charset;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mimeType);
    if (this.charset != null)
    {
      localStringBuilder.append("; charset=");
      localStringBuilder.append(this.charset);
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/entity/ContentType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */