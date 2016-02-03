package com.parse.entity.mime.content;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class InputStreamBody
  extends AbstractContentBody
{
  private final String filename;
  private final InputStream in;
  
  public InputStreamBody(InputStream paramInputStream, String paramString)
  {
    this(paramInputStream, "application/octet-stream", paramString);
  }
  
  public InputStreamBody(InputStream paramInputStream, String paramString1, String paramString2)
  {
    super(paramString1);
    if (paramInputStream == null) {
      throw new IllegalArgumentException("Input stream may not be null");
    }
    this.in = paramInputStream;
    this.filename = paramString2;
  }
  
  public String getCharset()
  {
    return null;
  }
  
  public long getContentLength()
  {
    return -1L;
  }
  
  public String getFilename()
  {
    return this.filename;
  }
  
  public InputStream getInputStream()
  {
    return this.in;
  }
  
  public String getTransferEncoding()
  {
    return "binary";
  }
  
  /* Error */
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +13 -> 14
    //   4: new 21	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc 46
    //   10: invokespecial 24	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   13: athrow
    //   14: sipush 4096
    //   17: newarray <illegal type>
    //   19: astore_3
    //   20: aload_0
    //   21: getfield 26	com/parse/entity/mime/content/InputStreamBody:in	Ljava/io/InputStream;
    //   24: aload_3
    //   25: invokevirtual 52	java/io/InputStream:read	([B)I
    //   28: istore_2
    //   29: iload_2
    //   30: iconst_m1
    //   31: if_icmpne +15 -> 46
    //   34: aload_1
    //   35: invokevirtual 58	java/io/OutputStream:flush	()V
    //   38: aload_0
    //   39: getfield 26	com/parse/entity/mime/content/InputStreamBody:in	Ljava/io/InputStream;
    //   42: invokevirtual 61	java/io/InputStream:close	()V
    //   45: return
    //   46: aload_1
    //   47: aload_3
    //   48: iconst_0
    //   49: iload_2
    //   50: invokevirtual 65	java/io/OutputStream:write	([BII)V
    //   53: goto -33 -> 20
    //   56: astore_1
    //   57: aload_0
    //   58: getfield 26	com/parse/entity/mime/content/InputStreamBody:in	Ljava/io/InputStream;
    //   61: invokevirtual 61	java/io/InputStream:close	()V
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	InputStreamBody
    //   0	66	1	paramOutputStream	OutputStream
    //   28	22	2	i	int
    //   19	29	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   14	20	56	finally
    //   20	29	56	finally
    //   34	38	56	finally
    //   46	53	56	finally
  }
  
  @Deprecated
  public void writeTo(OutputStream paramOutputStream, int paramInt)
    throws IOException
  {
    writeTo(paramOutputStream);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/entity/mime/content/InputStreamBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */