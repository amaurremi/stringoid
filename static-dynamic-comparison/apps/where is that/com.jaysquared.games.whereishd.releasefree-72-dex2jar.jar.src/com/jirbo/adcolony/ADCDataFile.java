package com.jirbo.adcolony;

import java.io.File;
import java.io.IOException;

class ADCDataFile
{
  static byte[] buffer = new byte['Ѐ'];
  String filepath;
  
  ADCDataFile(String paramString)
  {
    this.filepath = (ADC.controller.storage.data_path + paramString);
  }
  
  ADCParseReader create_reader()
  {
    try
    {
      ADCParseReader localADCParseReader = new ADCParseReader(new ADCStreamReader(this.filepath));
      return localADCParseReader;
    }
    catch (IOException localIOException) {}
    return null;
  }
  
  ADCStreamWriter create_writer()
  {
    return new ADCStreamWriter(this.filepath);
  }
  
  void delete()
  {
    new File(this.filepath).delete();
  }
  
  void save(String paramString)
  {
    ADCStreamWriter localADCStreamWriter = create_writer();
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      localADCStreamWriter.write(paramString.charAt(i));
      i += 1;
    }
    localADCStreamWriter.close();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jirbo/adcolony/ADCDataFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */