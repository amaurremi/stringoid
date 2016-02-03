package mobi.beyondpod.htmlbuilder;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;
import mobi.beyondpod.R.raw;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.StringUtils;

public class FeedContentItemTemplate
  extends TemplateBase
{
  private static final String TAG = FeedContentItemTemplate.class.getSimpleName();
  private static List<TemplateBase.KeyValuePair> m_Template;
  public String ItemContent;
  public String ItemLink;
  public String ItemPubDate;
  public CharSequence ItemTitle;
  public String OriginatingFeed;
  
  public static void RefreshTemplate()
  {
    m_Template = null;
  }
  
  /* Error */
  public boolean SaveAsHtml(java.io.File paramFile)
    throws java.lang.Exception
  {
    // Byte code:
    //   0: getstatic 25	mobi/beyondpod/htmlbuilder/FeedContentItemTemplate:TAG	Ljava/lang/String;
    //   3: ldc 38
    //   5: invokestatic 44	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   8: aconst_null
    //   9: astore 4
    //   11: aconst_null
    //   12: astore_3
    //   13: aload 4
    //   15: astore_2
    //   16: new 46	java/io/FileOutputStream
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 49	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   24: astore 5
    //   26: aload 4
    //   28: astore_2
    //   29: new 51	java/io/OutputStreamWriter
    //   32: dup
    //   33: new 53	java/io/BufferedOutputStream
    //   36: dup
    //   37: aload 5
    //   39: sipush 8192
    //   42: invokespecial 56	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   45: invokespecial 59	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   48: astore_1
    //   49: aload_0
    //   50: invokevirtual 63	mobi/beyondpod/htmlbuilder/FeedContentItemTemplate:Template	()Ljava/util/List;
    //   53: invokeinterface 69 1 0
    //   58: astore_2
    //   59: aload_2
    //   60: invokeinterface 75 1 0
    //   65: ifne +31 -> 96
    //   68: aload 5
    //   70: invokestatic 79	mobi/beyondpod/rsscore/helpers/CoreHelper:sync	(Ljava/io/FileOutputStream;)Z
    //   73: pop
    //   74: aload_1
    //   75: invokevirtual 82	java/io/OutputStreamWriter:close	()V
    //   78: aload_1
    //   79: ifnull +7 -> 86
    //   82: aload_1
    //   83: invokevirtual 82	java/io/OutputStreamWriter:close	()V
    //   86: getstatic 25	mobi/beyondpod/htmlbuilder/FeedContentItemTemplate:TAG	Ljava/lang/String;
    //   89: ldc 84
    //   91: invokestatic 44	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: iconst_1
    //   95: ireturn
    //   96: aload_0
    //   97: aload_2
    //   98: invokeinterface 88 1 0
    //   103: checkcast 90	mobi/beyondpod/htmlbuilder/TemplateBase$KeyValuePair
    //   106: aload_1
    //   107: invokevirtual 94	mobi/beyondpod/htmlbuilder/FeedContentItemTemplate:WriteTemplateFor	(Lmobi/beyondpod/htmlbuilder/TemplateBase$KeyValuePair;Ljava/io/Writer;)V
    //   110: goto -51 -> 59
    //   113: astore_3
    //   114: aload_1
    //   115: astore_2
    //   116: aload_3
    //   117: astore_1
    //   118: new 36	java/lang/Exception
    //   121: dup
    //   122: new 96	java/lang/StringBuilder
    //   125: dup
    //   126: ldc 98
    //   128: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   131: aload_1
    //   132: invokevirtual 104	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   135: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: aload_1
    //   142: invokespecial 114	java/lang/Exception:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   145: athrow
    //   146: astore_1
    //   147: aload_2
    //   148: ifnull +7 -> 155
    //   151: aload_2
    //   152: invokevirtual 82	java/io/OutputStreamWriter:close	()V
    //   155: getstatic 25	mobi/beyondpod/htmlbuilder/FeedContentItemTemplate:TAG	Ljava/lang/String;
    //   158: ldc 84
    //   160: invokestatic 44	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   163: aload_1
    //   164: athrow
    //   165: astore_3
    //   166: aload_1
    //   167: astore_2
    //   168: aload_3
    //   169: astore_1
    //   170: goto -23 -> 147
    //   173: astore_1
    //   174: aload_3
    //   175: astore_2
    //   176: goto -58 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	this	FeedContentItemTemplate
    //   0	179	1	paramFile	java.io.File
    //   15	161	2	localObject1	Object
    //   12	1	3	localObject2	Object
    //   113	4	3	localException	Exception
    //   165	10	3	localObject3	Object
    //   9	18	4	localObject4	Object
    //   24	45	5	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   49	59	113	java/lang/Exception
    //   59	78	113	java/lang/Exception
    //   96	110	113	java/lang/Exception
    //   16	26	146	finally
    //   29	49	146	finally
    //   118	146	146	finally
    //   49	59	165	finally
    //   59	78	165	finally
    //   96	110	165	finally
    //   16	26	173	java/lang/Exception
    //   29	49	173	java/lang/Exception
  }
  
  public void SwitchTemplateResourceTo(int paramInt)
  {
    if (this._TemplateResourceId == paramInt) {
      return;
    }
    this._TemplateResourceId = paramInt;
    if (m_Template != null) {
      m_Template.clear();
    }
    m_Template = null;
  }
  
  public List<TemplateBase.KeyValuePair> Template()
  {
    if (m_Template == null)
    {
      if (this._TemplateResourceId == 0) {
        this._TemplateResourceId = R.raw.rss_feed_content_item;
      }
      m_Template = LoadTemplate();
    }
    return m_Template;
  }
  
  public String ToHtml()
  {
    CoreHelper.WriteTraceEntry(TAG, "Generating Post HTML...");
    StringBuilder localStringBuilder = new StringBuilder(this.ItemContent.length() + 500);
    Iterator localIterator = Template().iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        CoreHelper.WriteTraceEntry(TAG, "DONE Generating Post HTML!");
        return localStringBuilder.toString();
      }
      WriteTemplateFor((TemplateBase.KeyValuePair)localIterator.next(), localStringBuilder);
    }
  }
  
  protected void WriteContentFor(String paramString, Writer paramWriter)
    throws IOException
  {
    if (paramString.equals("#DOCUMENT_FONT_SIZE#")) {
      if (StringUtils.IsNullOrEmpty(Configuration.getDefaultDocFontSize())) {
        paramWriter.write("medium");
      }
    }
    do
    {
      return;
      paramWriter.write(Configuration.getDefaultDocFontSize());
      return;
      if (paramString.equals("#DOCUMENT_THEME#"))
      {
        paramWriter.write(Configuration.ContentTheme());
        return;
      }
      if (paramString.equals("#FEEDITEM_DESCRIPTION#"))
      {
        paramWriter.write(this.ItemContent);
        return;
      }
      if (paramString.equals("#ITEM_TITLE#"))
      {
        paramWriter.write(this.ItemTitle.toString());
        return;
      }
      if (paramString.equals("#ITEM_PUB_DATE#"))
      {
        paramWriter.write(this.ItemPubDate);
        return;
      }
      if (paramString.equals("#ITEM_ORIG_FEED#"))
      {
        paramWriter.write(this.OriginatingFeed);
        return;
      }
    } while (!paramString.equals("#ITEM_LINK#"));
    paramWriter.write(this.ItemLink);
  }
  
  protected void WriteContentFor(String paramString, StringBuilder paramStringBuilder)
  {
    if (paramString.equals("#DOCUMENT_FONT_SIZE#")) {
      if (StringUtils.IsNullOrEmpty(Configuration.getDefaultDocFontSize())) {
        paramStringBuilder.append("medium");
      }
    }
    do
    {
      return;
      paramStringBuilder.append(Configuration.getDefaultDocFontSize());
      return;
      if (paramString.equals("#DOCUMENT_THEME#"))
      {
        paramStringBuilder.append(Configuration.ContentTheme());
        return;
      }
      if (paramString.equals("#FEEDITEM_DESCRIPTION#"))
      {
        paramStringBuilder.append(this.ItemContent);
        return;
      }
      if (paramString.equals("#ITEM_TITLE#"))
      {
        paramStringBuilder.append(this.ItemTitle.toString());
        return;
      }
      if (paramString.equals("#ITEM_PUB_DATE#"))
      {
        paramStringBuilder.append(this.ItemPubDate);
        return;
      }
      if (paramString.equals("#ITEM_ORIG_FEED#"))
      {
        paramStringBuilder.append(this.OriginatingFeed);
        return;
      }
    } while (!paramString.equals("#ITEM_LINK#"));
    paramStringBuilder.append(this.ItemLink);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/htmlbuilder/FeedContentItemTemplate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */