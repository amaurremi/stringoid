package com.google.api.client.json.gson;

import com.google.api.client.json.d;
import com.google.api.client.json.e;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.nio.charset.Charset;

public class a
  extends d
{
  public e a(OutputStream paramOutputStream, Charset paramCharset)
  {
    return a(new OutputStreamWriter(paramOutputStream, paramCharset));
  }
  
  public e a(Writer paramWriter)
  {
    return new GsonGenerator(this, new com.google.gson.stream.b(paramWriter));
  }
  
  public com.google.api.client.json.g a(InputStream paramInputStream, Charset paramCharset)
  {
    if (paramCharset == null) {
      return b(paramInputStream);
    }
    return a(new InputStreamReader(paramInputStream, paramCharset));
  }
  
  public com.google.api.client.json.g a(Reader paramReader)
  {
    return new b(this, new com.google.gson.stream.a(paramReader));
  }
  
  public com.google.api.client.json.g b(InputStream paramInputStream)
  {
    return a(new InputStreamReader(paramInputStream, com.google.api.client.util.g.UTF_8));
  }
  
  public com.google.api.client.json.g co(String paramString)
  {
    return a(new StringReader(paramString));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/json/gson/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */