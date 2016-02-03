package com.parse.entity.mime.content;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileBody
  extends AbstractContentBody
{
  private final String charset;
  private final File file;
  private final String filename;
  
  public FileBody(File paramFile)
  {
    this(paramFile, "application/octet-stream");
  }
  
  public FileBody(File paramFile, String paramString)
  {
    this(paramFile, paramString, null);
  }
  
  public FileBody(File paramFile, String paramString1, String paramString2)
  {
    this(paramFile, null, paramString1, paramString2);
  }
  
  public FileBody(File paramFile, String paramString1, String paramString2, String paramString3)
  {
    super(paramString2);
    if (paramFile == null) {
      throw new IllegalArgumentException("File may not be null");
    }
    this.file = paramFile;
    if (paramString1 != null) {}
    for (this.filename = paramString1;; this.filename = paramFile.getName())
    {
      this.charset = paramString3;
      return;
    }
  }
  
  public String getCharset()
  {
    return this.charset;
  }
  
  public long getContentLength()
  {
    return this.file.length();
  }
  
  public File getFile()
  {
    return this.file;
  }
  
  public String getFilename()
  {
    return this.filename;
  }
  
  public InputStream getInputStream()
    throws IOException
  {
    return new FileInputStream(this.file);
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
    //   4: new 28	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc 68
    //   10: invokespecial 31	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   13: athrow
    //   14: new 58	java/io/FileInputStream
    //   17: dup
    //   18: aload_0
    //   19: getfield 33	com/parse/entity/mime/content/FileBody:file	Ljava/io/File;
    //   22: invokespecial 60	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   25: astore_3
    //   26: sipush 4096
    //   29: newarray <illegal type>
    //   31: astore 4
    //   33: aload_3
    //   34: aload 4
    //   36: invokevirtual 74	java/io/InputStream:read	([B)I
    //   39: istore_2
    //   40: iload_2
    //   41: iconst_m1
    //   42: if_icmpne +12 -> 54
    //   45: aload_1
    //   46: invokevirtual 80	java/io/OutputStream:flush	()V
    //   49: aload_3
    //   50: invokevirtual 83	java/io/InputStream:close	()V
    //   53: return
    //   54: aload_1
    //   55: aload 4
    //   57: iconst_0
    //   58: iload_2
    //   59: invokevirtual 87	java/io/OutputStream:write	([BII)V
    //   62: goto -29 -> 33
    //   65: astore_1
    //   66: aload_3
    //   67: invokevirtual 83	java/io/InputStream:close	()V
    //   70: aload_1
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	FileBody
    //   0	72	1	paramOutputStream	OutputStream
    //   39	20	2	i	int
    //   25	42	3	localFileInputStream	FileInputStream
    //   31	25	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   26	33	65	finally
    //   33	40	65	finally
    //   45	49	65	finally
    //   54	62	65	finally
  }
  
  @Deprecated
  public void writeTo(OutputStream paramOutputStream, int paramInt)
    throws IOException
  {
    writeTo(paramOutputStream);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/entity/mime/content/FileBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */