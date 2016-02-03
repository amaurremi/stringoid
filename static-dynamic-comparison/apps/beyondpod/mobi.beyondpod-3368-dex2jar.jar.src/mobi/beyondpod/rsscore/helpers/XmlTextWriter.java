package mobi.beyondpod.rsscore.helpers;

import java.io.FileOutputStream;
import java.io.IOException;
import org.kxml2.io.KXmlSerializer;
import org.xmlpull.v1.XmlSerializer;

public class XmlTextWriter
{
  private static final String ENCODING = "UTF8";
  private XmlSerializer _serializer = new KXmlSerializer();
  FileOutputStream _stream;
  
  public XmlTextWriter(String paramString)
    throws IOException
  {
    this._stream = new FileOutputStream(paramString);
    this._serializer.setOutput(this._stream, "UTF8");
  }
  
  public void WriteAttributeString(String paramString1, String paramString2)
    throws IllegalArgumentException, IllegalStateException, IOException
  {
    if (paramString2 == null) {
      return;
    }
    this._serializer.attribute(null, paramString1, paramString2);
  }
  
  public void WriteEndElement(String paramString)
    throws IllegalArgumentException, IllegalStateException, IOException
  {
    this._serializer.endTag(null, paramString);
  }
  
  public void WriteStartDocument()
    throws IllegalArgumentException, IllegalStateException, IOException
  {
    this._serializer.startDocument("utf-8", Boolean.valueOf(false));
  }
  
  public void WriteStartElement(String paramString)
    throws IllegalArgumentException, IllegalStateException, IOException
  {
    this._serializer.startTag(null, paramString);
  }
  
  public void WriteString(String paramString)
    throws IllegalArgumentException, IllegalStateException, IOException
  {
    this._serializer.text(paramString);
  }
  
  public void close()
    throws IllegalArgumentException, IllegalStateException, IOException
  {
    this._serializer.endDocument();
    this._serializer.flush();
    CoreHelper.sync(this._stream);
    this._stream.close();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/helpers/XmlTextWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */