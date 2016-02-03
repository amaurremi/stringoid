package org.apache.http.entity.mime;

import org.apache.http.entity.mime.content.ContentBody;

public class FormBodyPart
{
  private final ContentBody body;
  private final Header header;
  private final String name;
  
  public FormBodyPart(String paramString, ContentBody paramContentBody)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Name may not be null");
    }
    if (paramContentBody == null) {
      throw new IllegalArgumentException("Body may not be null");
    }
    this.name = paramString;
    this.body = paramContentBody;
    this.header = new Header();
    generateContentDisp(paramContentBody);
    generateContentType(paramContentBody);
    generateTransferEncoding(paramContentBody);
  }
  
  public void addField(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("Field name may not be null");
    }
    this.header.addField(new MinimalField(paramString1, paramString2));
  }
  
  protected void generateContentDisp(ContentBody paramContentBody)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("form-data; name=\"");
    localStringBuilder.append(getName());
    localStringBuilder.append("\"");
    if (paramContentBody.getFilename() != null)
    {
      localStringBuilder.append("; filename=\"");
      localStringBuilder.append(paramContentBody.getFilename());
      localStringBuilder.append("\"");
    }
    addField("Content-Disposition", localStringBuilder.toString());
  }
  
  protected void generateContentType(ContentBody paramContentBody)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContentBody.getMimeType());
    if (paramContentBody.getCharset() != null)
    {
      localStringBuilder.append("; charset=");
      localStringBuilder.append(paramContentBody.getCharset());
    }
    addField("Content-Type", localStringBuilder.toString());
  }
  
  protected void generateTransferEncoding(ContentBody paramContentBody)
  {
    addField("Content-Transfer-Encoding", paramContentBody.getTransferEncoding());
  }
  
  public ContentBody getBody()
  {
    return this.body;
  }
  
  public Header getHeader()
  {
    return this.header;
  }
  
  public String getName()
  {
    return this.name;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/org/apache/http/entity/mime/FormBodyPart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */