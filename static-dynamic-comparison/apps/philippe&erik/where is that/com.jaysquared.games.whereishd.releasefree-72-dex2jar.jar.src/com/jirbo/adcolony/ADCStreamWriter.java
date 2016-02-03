package com.jirbo.adcolony;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class ADCStreamWriter
  extends ADCWriter
{
  static final int buffer_size = 1024;
  byte[] buffer = new byte['Ѐ'];
  int dx;
  String filepath;
  OutputStream out;
  int position = 0;
  int x;
  
  ADCStreamWriter(String paramString)
  {
    this.filepath = paramString;
    if (ADC.log_level != 0)
    {
      this.dx = 23;
      this.x = this.dx;
    }
    try
    {
      if ((ADC.controller != null) && (ADC.controller.storage != null)) {
        ADC.controller.storage.validate_storage_paths();
      }
      this.out = new FileOutputStream(paramString);
      return;
    }
    catch (IOException paramString)
    {
      on_error(paramString);
    }
  }
  
  ADCStreamWriter(String paramString, OutputStream paramOutputStream)
  {
    this.filepath = paramString;
    this.out = paramOutputStream;
  }
  
  public static void main(String[] paramArrayOfString)
  {
    paramArrayOfString = new ADCStreamWriter("test.txt");
    paramArrayOfString.println("A king who was mad at the time");
    paramArrayOfString.println("Declared limerick writing a crime");
    paramArrayOfString.indent += 2;
    paramArrayOfString.println("So late in the night");
    paramArrayOfString.println("All the poets would write");
    paramArrayOfString.indent -= 2;
    paramArrayOfString.println("Verses without any rhyme or meter");
    paramArrayOfString.println();
    paramArrayOfString.indent += 4;
    paramArrayOfString.println("David\nGerrold");
    paramArrayOfString.indent += 2;
    paramArrayOfString.println(4.0D);
    paramArrayOfString.indent += 2;
    paramArrayOfString.println(0.0D);
    paramArrayOfString.indent += 2;
    paramArrayOfString.println(-100023.0D);
    paramArrayOfString.indent += 2;
    paramArrayOfString.println(-6L);
    paramArrayOfString.indent += 2;
    paramArrayOfString.println(0L);
    paramArrayOfString.indent += 2;
    paramArrayOfString.println(234L);
    paramArrayOfString.indent += 2;
    paramArrayOfString.println(Long.MIN_VALUE);
    paramArrayOfString.indent += 2;
    paramArrayOfString.println(true);
    paramArrayOfString.indent += 2;
    paramArrayOfString.println(false);
    paramArrayOfString.indent += 2;
    paramArrayOfString.close();
  }
  
  void close()
  {
    flush();
    try
    {
      if (this.out != null)
      {
        this.out.close();
        this.out = null;
      }
      return;
    }
    catch (IOException localIOException)
    {
      this.out = null;
      on_error(localIOException);
    }
  }
  
  void flush()
  {
    if ((this.position > 0) && (this.out != null)) {}
    try
    {
      this.out.write(this.buffer, 0, this.position);
      this.position = 0;
      this.out.flush();
      return;
    }
    catch (IOException localIOException)
    {
      this.position = 0;
      on_error(localIOException);
    }
  }
  
  void on_error(IOException paramIOException)
  {
    ADCLog.error.print("Error writing \"").print(this.filepath).println("\":");
    ADCLog.error.println(paramIOException.toString());
    close();
  }
  
  void write(char paramChar)
  {
    this.buffer[this.position] = ((byte)(this.x ^ paramChar));
    this.x += this.dx;
    paramChar = this.position + 1;
    this.position = paramChar;
    if (paramChar == 'Ѐ') {
      flush();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jirbo/adcolony/ADCStreamWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */