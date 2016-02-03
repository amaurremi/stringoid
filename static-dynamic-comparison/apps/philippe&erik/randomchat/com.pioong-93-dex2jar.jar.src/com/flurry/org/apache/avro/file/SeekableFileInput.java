package com.flurry.org.apache.avro.file;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class SeekableFileInput
  extends FileInputStream
  implements SeekableInput
{
  public SeekableFileInput(File paramFile)
    throws IOException
  {
    super(paramFile);
  }
  
  public SeekableFileInput(FileDescriptor paramFileDescriptor)
    throws IOException
  {
    super(paramFileDescriptor);
  }
  
  public long length()
    throws IOException
  {
    return getChannel().size();
  }
  
  public void seek(long paramLong)
    throws IOException
  {
    getChannel().position(paramLong);
  }
  
  public long tell()
    throws IOException
  {
    return getChannel().position();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/file/SeekableFileInput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */