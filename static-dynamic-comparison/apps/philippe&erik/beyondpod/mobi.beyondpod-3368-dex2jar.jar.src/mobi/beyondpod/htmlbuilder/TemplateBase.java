package mobi.beyondpod.htmlbuilder;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.StringUtils;

public abstract class TemplateBase
{
  private static final String TAG = TemplateBase.class.getSimpleName();
  public static int TemplateTypes_RSS = 1;
  public int TemplateTypes_TTS = 2;
  protected HashMap<String, String> _Parameters = new HashMap();
  protected int _TemplateResourceId;
  protected int _TemplateType = TemplateTypes_RSS;
  
  protected TemplateBase() {}
  
  protected TemplateBase(int paramInt)
  {
    this._TemplateType = paramInt;
  }
  
  private static List<KeyValuePair> ParseTemplate(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Matcher localMatcher = Pattern.compile("\\x23[A-Z_]*\\x23", 10).matcher(paramString);
    int i = 0;
    for (;;)
    {
      if (!localMatcher.find())
      {
        localArrayList.add(new KeyValuePair(paramString.substring(i), null));
        return localArrayList;
      }
      KeyValuePair localKeyValuePair = new KeyValuePair(paramString.substring(i, localMatcher.start()), localMatcher.group());
      i = localMatcher.end();
      localArrayList.add(localKeyValuePair);
    }
  }
  
  protected void ApplyParameters(Writer paramWriter)
    throws IOException
  {
    if (Template() == null) {
      paramWriter.write("Template file " + this._TemplateResourceId + " does not exist!");
    }
    Iterator localIterator = Template().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      KeyValuePair localKeyValuePair = (KeyValuePair)localIterator.next();
      if (!StringUtils.IsNullOrEmpty(localKeyValuePair.Key)) {
        paramWriter.write(localKeyValuePair.Key);
      }
      if ((!StringUtils.IsNullOrEmpty(localKeyValuePair.Value)) && (this._Parameters.containsKey(localKeyValuePair.Value))) {
        paramWriter.write((String)this._Parameters.get(localKeyValuePair.Value));
      }
    }
  }
  
  protected List<KeyValuePair> LoadTemplate()
  {
    try
    {
      List localList = ParseTemplate(CoreHelper.LoadResToString(this._TemplateResourceId));
      return localList;
    }
    catch (Exception localException)
    {
      CoreHelper.LogException(TAG, "Template " + this._TemplateResourceId + " does not exist!", localException);
    }
    return new ArrayList();
  }
  
  public List<KeyValuePair> Template()
  {
    return null;
  }
  
  public int TemplateType()
  {
    return this._TemplateType;
  }
  
  public void ToHtml(Writer paramWriter)
    throws IOException
  {
    ApplyParameters(paramWriter);
  }
  
  protected void WriteContentFor(String paramString, Writer paramWriter)
    throws IOException
  {
    if ((!StringUtils.IsNullOrEmpty(paramString)) && (this._Parameters.containsKey(paramString))) {
      paramWriter.write((String)this._Parameters.get(paramString));
    }
  }
  
  protected void WriteContentFor(String paramString, StringBuilder paramStringBuilder)
  {
    if ((!StringUtils.IsNullOrEmpty(paramString)) && (this._Parameters.containsKey(paramString))) {
      paramStringBuilder.append((String)this._Parameters.get(paramString));
    }
  }
  
  protected void WriteTemplateFor(KeyValuePair paramKeyValuePair, Writer paramWriter)
    throws IOException
  {
    if (!StringUtils.IsNullOrEmpty(paramKeyValuePair.Key)) {
      paramWriter.write(paramKeyValuePair.Key);
    }
    if (!StringUtils.IsNullOrEmpty(paramKeyValuePair.Value)) {
      WriteContentFor(paramKeyValuePair.Value, paramWriter);
    }
  }
  
  protected void WriteTemplateFor(KeyValuePair paramKeyValuePair, StringBuilder paramStringBuilder)
  {
    if (!StringUtils.IsNullOrEmpty(paramKeyValuePair.Key)) {
      paramStringBuilder.append(paramKeyValuePair.Key);
    }
    if (!StringUtils.IsNullOrEmpty(paramKeyValuePair.Value)) {
      WriteContentFor(paramKeyValuePair.Value, paramStringBuilder);
    }
  }
  
  static class KeyValuePair
  {
    public String Key;
    public String Value;
    
    public KeyValuePair(String paramString1, String paramString2)
    {
      this.Key = paramString1;
      this.Value = paramString2;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/htmlbuilder/TemplateBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */