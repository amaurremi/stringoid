package com.parse.entity.mime.content;

public abstract class AbstractContentBody
  implements ContentBody
{
  private final String mediaType;
  private final String mimeType;
  private final String subType;
  
  public AbstractContentBody(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("MIME type may not be null");
    }
    this.mimeType = paramString;
    int i = paramString.indexOf('/');
    if (i != -1)
    {
      this.mediaType = paramString.substring(0, i);
      this.subType = paramString.substring(i + 1);
      return;
    }
    this.mediaType = paramString;
    this.subType = null;
  }
  
  public String getMediaType()
  {
    return this.mediaType;
  }
  
  public String getMimeType()
  {
    return this.mimeType;
  }
  
  public String getSubType()
  {
    return this.subType;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/entity/mime/content/AbstractContentBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */