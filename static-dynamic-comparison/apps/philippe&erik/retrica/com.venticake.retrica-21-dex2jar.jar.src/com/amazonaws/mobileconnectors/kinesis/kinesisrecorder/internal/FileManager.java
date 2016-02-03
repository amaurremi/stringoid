package com.amazonaws.mobileconnectors.kinesis.kinesisrecorder.internal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

class FileManager
{
  private final File directory;
  
  public FileManager(File paramFile)
  {
    this.directory = paramFile;
  }
  
  public File createDirectory(String paramString)
  {
    File localFile = new File(this.directory, paramString);
    paramString = localFile;
    if (!localFile.exists())
    {
      paramString = localFile;
      if (!localFile.mkdirs()) {
        paramString = null;
      }
    }
    return paramString;
  }
  
  public File createFile(File paramFile)
  {
    File localFile = paramFile;
    if (!paramFile.exists())
    {
      localFile = paramFile;
      if (!paramFile.createNewFile()) {
        localFile = null;
      }
    }
    return localFile;
  }
  
  public InputStream newInputStream(File paramFile)
  {
    return new FileInputStream(paramFile);
  }
  
  public OutputStream newOutputStream(File paramFile, boolean paramBoolean)
  {
    return new FileOutputStream(paramFile, paramBoolean);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */