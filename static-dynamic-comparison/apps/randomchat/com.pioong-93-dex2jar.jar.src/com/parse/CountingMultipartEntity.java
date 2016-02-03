package com.parse;

import com.parse.entity.mime.HttpMultipartMode;
import com.parse.entity.mime.MultipartEntity;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

class CountingMultipartEntity
  extends MultipartEntity
{
  private final ProgressCallback progressCallback;
  
  public CountingMultipartEntity(ProgressCallback paramProgressCallback)
  {
    this.progressCallback = paramProgressCallback;
  }
  
  public CountingMultipartEntity(HttpMultipartMode paramHttpMultipartMode, ProgressCallback paramProgressCallback)
  {
    super(paramHttpMultipartMode);
    this.progressCallback = paramProgressCallback;
  }
  
  public CountingMultipartEntity(HttpMultipartMode paramHttpMultipartMode, String paramString, Charset paramCharset, ProgressCallback paramProgressCallback)
  {
    super(paramHttpMultipartMode, paramString, paramCharset);
    this.progressCallback = paramProgressCallback;
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    super.writeTo(new CountingOutputStream(paramOutputStream, this.progressCallback, getContentLength()));
  }
  
  public static class CountingOutputStream
    extends FilterOutputStream
  {
    private boolean hasReportedDone = false;
    private final ProgressCallback progressCallback;
    private long totalSize;
    private long uploadedSize;
    
    public CountingOutputStream(OutputStream paramOutputStream, ProgressCallback paramProgressCallback, long paramLong)
    {
      super();
      this.progressCallback = paramProgressCallback;
      this.totalSize = paramLong;
      this.uploadedSize = 0L;
    }
    
    private void notifyCallback()
    {
      if (this.hasReportedDone) {}
      int i;
      do
      {
        return;
        i = Math.round((float)this.uploadedSize / (float)this.totalSize * 100.0F);
        Parse.callbackOnMainThreadAsync(Task.forResult(Integer.valueOf(i)), this.progressCallback);
      } while (i != 100);
      this.hasReportedDone = true;
    }
    
    public void write(int paramInt)
      throws IOException
    {
      this.out.write(paramInt);
      this.uploadedSize += 1L;
      notifyCallback();
    }
    
    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      this.out.write(paramArrayOfByte, paramInt1, paramInt2);
      this.uploadedSize += paramInt2;
      notifyCallback();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/CountingMultipartEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */