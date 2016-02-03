package mobi.beyondpod.htmlbuilder;

import java.util.HashMap;
import java.util.List;
import mobi.beyondpod.R.raw;
import mobi.beyondpod.rsscore.Configuration;

public class InfoMessageTemplate
  extends TemplateBase
{
  private static final String TAG = InfoMessageTemplate.class.getSimpleName();
  private static List<TemplateBase.KeyValuePair> _Template;
  
  public InfoMessageTemplate(int paramInt)
  {
    super(paramInt);
    this._Parameters.put("#SYS_COLOR_A#", Configuration.getContentViewColor());
    this._Parameters.put("#IMAGE_FOLDER#", Configuration.RssTemplatesImagePath());
  }
  
  public static void RefreshTemplate()
  {
    _Template = null;
  }
  
  /* Error */
  public boolean SaveAsHtml(java.io.File paramFile)
    throws java.io.IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_3
    //   6: astore_2
    //   7: new 57	java/io/FileOutputStream
    //   10: dup
    //   11: aload_1
    //   12: invokespecial 60	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   15: astore 5
    //   17: aload_3
    //   18: astore_2
    //   19: new 62	java/io/OutputStreamWriter
    //   22: dup
    //   23: new 64	java/io/BufferedOutputStream
    //   26: dup
    //   27: aload 5
    //   29: invokespecial 67	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   32: invokespecial 68	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   35: astore_3
    //   36: aload_0
    //   37: aload_3
    //   38: invokevirtual 72	mobi/beyondpod/htmlbuilder/InfoMessageTemplate:ToHtml	(Ljava/io/Writer;)V
    //   41: aload 5
    //   43: invokestatic 78	mobi/beyondpod/rsscore/helpers/CoreHelper:sync	(Ljava/io/FileOutputStream;)Z
    //   46: pop
    //   47: aload 5
    //   49: invokevirtual 81	java/io/FileOutputStream:close	()V
    //   52: aload_3
    //   53: ifnull +7 -> 60
    //   56: aload_3
    //   57: invokevirtual 82	java/io/OutputStreamWriter:close	()V
    //   60: iconst_1
    //   61: ireturn
    //   62: astore_2
    //   63: aload 4
    //   65: astore_3
    //   66: aload_2
    //   67: astore 4
    //   69: aload_3
    //   70: astore_2
    //   71: getstatic 19	mobi/beyondpod/htmlbuilder/InfoMessageTemplate:TAG	Ljava/lang/String;
    //   74: new 84	java/lang/StringBuilder
    //   77: dup
    //   78: ldc 86
    //   80: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   83: aload_1
    //   84: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   87: ldc 95
    //   89: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: aload 4
    //   94: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 105	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteLogEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   103: aload_3
    //   104: ifnull +7 -> 111
    //   107: aload_3
    //   108: invokevirtual 82	java/io/OutputStreamWriter:close	()V
    //   111: iconst_0
    //   112: ireturn
    //   113: astore_1
    //   114: aload_2
    //   115: ifnull +7 -> 122
    //   118: aload_2
    //   119: invokevirtual 82	java/io/OutputStreamWriter:close	()V
    //   122: aload_1
    //   123: athrow
    //   124: astore_1
    //   125: aload_3
    //   126: astore_2
    //   127: goto -13 -> 114
    //   130: astore 4
    //   132: goto -63 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	InfoMessageTemplate
    //   0	135	1	paramFile	java.io.File
    //   6	13	2	localObject1	Object
    //   62	5	2	localException1	Exception
    //   70	57	2	localObject2	Object
    //   1	125	3	localObject3	Object
    //   3	90	4	localObject4	Object
    //   130	1	4	localException2	Exception
    //   15	33	5	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   7	17	62	java/lang/Exception
    //   19	36	62	java/lang/Exception
    //   7	17	113	finally
    //   19	36	113	finally
    //   71	103	113	finally
    //   36	52	124	finally
    //   36	52	130	java/lang/Exception
  }
  
  public List<TemplateBase.KeyValuePair> Template()
  {
    if (_Template == null)
    {
      this._TemplateResourceId = R.raw.info_message;
      _Template = LoadTemplate();
    }
    return _Template;
  }
  
  public String getFeedName()
  {
    return (String)this._Parameters.get("#FEED_NAME#");
  }
  
  public void setFeedName(String paramString)
  {
    this._Parameters.put("#FEED_NAME#", paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/htmlbuilder/InfoMessageTemplate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */