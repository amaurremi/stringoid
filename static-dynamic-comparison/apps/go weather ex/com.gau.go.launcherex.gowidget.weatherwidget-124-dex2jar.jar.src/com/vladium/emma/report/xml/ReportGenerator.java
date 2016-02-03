package com.vladium.emma.report.xml;

import com.vladium.emma.EMMARuntimeException;
import com.vladium.emma.IAppErrorCodes;
import com.vladium.emma.data.ICoverageData;
import com.vladium.emma.data.IMetaData;
import com.vladium.emma.report.AbstractReportGenerator;
import com.vladium.emma.report.ClassItem;
import com.vladium.emma.report.IItem;
import com.vladium.emma.report.IItemAttribute;
import com.vladium.emma.report.IItemMetadata;
import com.vladium.emma.report.IReportDataView;
import com.vladium.emma.report.ItemComparator;
import com.vladium.emma.report.MethodItem;
import com.vladium.emma.report.ReportProperties.ParsedProperties;
import com.vladium.emma.report.SourcePathCache;
import com.vladium.emma.report.SrcFileItem;
import com.vladium.logging.Logger;
import com.vladium.util.IConstants;
import com.vladium.util.IProperties;
import com.vladium.util.Strings;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Iterator;

public final class ReportGenerator
  extends AbstractReportGenerator
  implements IAppErrorCodes
{
  private static final int IO_BUF_SIZE = 65536;
  private static final String TYPE = "xml";
  private IndentingWriter m_out;
  
  private void close()
  {
    if (this.m_out != null) {}
    try
    {
      this.m_out.flush();
      this.m_out.close();
      return;
    }
    catch (IOException localIOException)
    {
      throw new EMMARuntimeException("REPORT_IO_FAILURE", localIOException);
    }
    finally
    {
      this.m_out = null;
    }
  }
  
  private void closeElementTag(boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean)
    {
      this.m_out.write("/>");
      return;
    }
    this.m_out.write(62);
  }
  
  private void emitItem(IItem paramIItem, ItemComparator paramItemComparator)
    throws IOException
  {
    int j = 0;
    IItemMetadata localIItemMetadata = paramIItem.getMetadata();
    int[] arrayOfInt = this.m_settings.getColumnOrder();
    String str = localIItemMetadata.getTypeName();
    eol();
    openElementTag(str);
    this.m_out.write(" name=\"");
    this.m_out.write(Strings.HTMLEscape(paramIItem.getName()));
    this.m_out.write(34);
    closeElementTag(false);
    eol();
    this.m_out.incIndent();
    emitItemCoverage(paramIItem, arrayOfInt);
    int i = j;
    if (paramItemComparator != null)
    {
      i = j;
      if (this.m_settings.getDepth() > localIItemMetadata.getTypeID())
      {
        i = j;
        if (paramIItem.getChildCount() > 0) {
          i = 1;
        }
      }
    }
    if (i != 0)
    {
      paramIItem = paramIItem.getChildren(paramItemComparator);
      while (paramIItem.hasNext()) {
        ((IItem)paramIItem.next()).accept(this, null);
      }
      eol();
    }
    this.m_out.decIndent();
    endElement(str);
  }
  
  private void emitItemCoverage(IItem paramIItem, int[] paramArrayOfInt)
    throws IOException
  {
    StringBuffer localStringBuffer = new StringBuffer(64);
    int i = 0;
    int j = paramArrayOfInt.length;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      if (k != 0)
      {
        IItemAttribute localIItemAttribute = paramIItem.getAttribute(k, this.m_settings.getUnitsType());
        if (localIItemAttribute != null)
        {
          openElementTag("coverage");
          this.m_out.write(" type=\"");
          this.m_out.write(Strings.HTMLEscape(localIItemAttribute.getName()));
          this.m_out.write("\" value=\"");
          localIItemAttribute.format(paramIItem, localStringBuffer);
          this.m_out.write(Strings.HTMLEscape(localStringBuffer.toString()));
          this.m_out.write(34);
          localStringBuffer.setLength(0);
          closeElementTag(true);
          eol();
        }
      }
      i += 1;
    }
  }
  
  private void emitStatsCount(String paramString, int paramInt)
    throws IOException
  {
    eol();
    openElementTag(paramString);
    this.m_out.write(" value=\"" + paramInt);
    this.m_out.write(34);
    closeElementTag(true);
  }
  
  private void endElement(String paramString)
    throws IOException
  {
    this.m_out.write("</");
    this.m_out.write(paramString);
    this.m_out.write(62);
  }
  
  private void eol()
    throws IOException
  {
    this.m_out.newLine();
  }
  
  private void openElementTag(String paramString)
    throws IOException
  {
    this.m_out.write(60);
    this.m_out.write(paramString);
  }
  
  private void openOutFile(File paramFile, String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      File localFile = paramFile.getParentFile();
      if (localFile != null) {
        localFile.mkdirs();
      }
      this.m_out = new IndentingWriter(new OutputStreamWriter(new FileOutputStream(paramFile), paramString), 65536, 0);
      return;
    }
    catch (UnsupportedEncodingException paramFile)
    {
      throw new EMMARuntimeException(paramFile);
    }
    catch (IOException paramFile)
    {
      throw new EMMARuntimeException(paramFile);
    }
  }
  
  public void cleanup()
  {
    close();
    super.cleanup();
  }
  
  public String getType()
  {
    return "xml";
  }
  
  public void process(IMetaData paramIMetaData, ICoverageData paramICoverageData, SourcePathCache paramSourcePathCache, IProperties paramIProperties)
    throws EMMARuntimeException
  {
    initialize(paramIMetaData, paramICoverageData, paramSourcePathCache, paramIProperties);
    long l1 = 0L;
    boolean bool = this.m_log.atTRACE1();
    if (bool) {
      l1 = System.currentTimeMillis();
    }
    this.m_view.getRoot().accept(this, null);
    close();
    if (bool)
    {
      long l2 = System.currentTimeMillis();
      this.m_log.trace1("process", "[" + getType() + "] report generated in " + (l2 - l1) + " ms");
    }
  }
  
  /* Error */
  public Object visit(com.vladium.emma.report.AllItem paramAllItem, Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 64	com/vladium/emma/report/xml/ReportGenerator:m_settings	Lcom/vladium/emma/report/ReportProperties$ParsedProperties;
    //   4: invokevirtual 271	com/vladium/emma/report/ReportProperties$ParsedProperties:getOutFile	()Ljava/io/File;
    //   7: astore 4
    //   9: aload 4
    //   11: astore_3
    //   12: aload 4
    //   14: ifnonnull +22 -> 36
    //   17: new 192	java/io/File
    //   20: dup
    //   21: ldc_w 273
    //   24: invokespecial 275	java/io/File:<init>	(Ljava/lang/String;)V
    //   27: astore_3
    //   28: aload_0
    //   29: getfield 64	com/vladium/emma/report/xml/ReportGenerator:m_settings	Lcom/vladium/emma/report/ReportProperties$ParsedProperties;
    //   32: aload_3
    //   33: invokevirtual 278	com/vladium/emma/report/ReportProperties$ParsedProperties:setOutFile	(Ljava/io/File;)V
    //   36: aload_0
    //   37: getfield 64	com/vladium/emma/report/xml/ReportGenerator:m_settings	Lcom/vladium/emma/report/ReportProperties$ParsedProperties;
    //   40: invokevirtual 281	com/vladium/emma/report/ReportProperties$ParsedProperties:getOutDir	()Ljava/io/File;
    //   43: aload_3
    //   44: invokestatic 287	com/vladium/util/Files:newFile	(Ljava/io/File;Ljava/io/File;)Ljava/io/File;
    //   47: astore_3
    //   48: aload_0
    //   49: getfield 229	com/vladium/emma/report/xml/ReportGenerator:m_log	Lcom/vladium/logging/Logger;
    //   52: new 170	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   59: ldc_w 289
    //   62: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: aload_0
    //   66: invokevirtual 255	com/vladium/emma/report/xml/ReportGenerator:getType	()Ljava/lang/String;
    //   69: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc_w 291
    //   75: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: aload_3
    //   79: invokevirtual 294	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   82: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: ldc_w 296
    //   88: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokevirtual 299	com/vladium/logging/Logger:info	(Ljava/lang/String;)V
    //   97: aload_0
    //   98: aload_3
    //   99: aload_0
    //   100: getfield 64	com/vladium/emma/report/xml/ReportGenerator:m_settings	Lcom/vladium/emma/report/ReportProperties$ParsedProperties;
    //   103: invokevirtual 302	com/vladium/emma/report/ReportProperties$ParsedProperties:getOutEncoding	()Ljava/lang/String;
    //   106: iconst_1
    //   107: invokespecial 304	com/vladium/emma/report/xml/ReportGenerator:openOutFile	(Ljava/io/File;Ljava/lang/String;Z)V
    //   110: aload_0
    //   111: getfield 28	com/vladium/emma/report/xml/ReportGenerator:m_out	Lcom/vladium/emma/report/xml/ReportGenerator$IndentingWriter;
    //   114: new 170	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   121: ldc_w 306
    //   124: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: aload_0
    //   128: getfield 64	com/vladium/emma/report/xml/ReportGenerator:m_settings	Lcom/vladium/emma/report/ReportProperties$ParsedProperties;
    //   131: invokevirtual 302	com/vladium/emma/report/ReportProperties$ParsedProperties:getOutEncoding	()Ljava/lang/String;
    //   134: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: ldc_w 308
    //   140: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokevirtual 48	com/vladium/emma/report/xml/ReportGenerator$IndentingWriter:write	(Ljava/lang/String;)V
    //   149: new 138	java/lang/StringBuffer
    //   152: dup
    //   153: bipush 101
    //   155: invokespecial 140	java/lang/StringBuffer:<init>	(I)V
    //   158: astore_3
    //   159: aload_3
    //   160: ldc_w 310
    //   163: invokevirtual 313	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   166: pop
    //   167: aload_3
    //   168: ldc_w 315
    //   171: invokevirtual 313	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   174: pop
    //   175: aload_3
    //   176: ldc_w 317
    //   179: invokevirtual 313	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   182: pop
    //   183: aload_3
    //   184: ldc_w 319
    //   187: invokevirtual 313	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   190: pop
    //   191: aload_3
    //   192: ldc_w 321
    //   195: invokevirtual 313	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   198: pop
    //   199: aload_3
    //   200: new 323	java/util/Date
    //   203: dup
    //   204: invokestatic 328	com/vladium/emma/EMMAProperties:getTimeStamp	()J
    //   207: invokespecial 331	java/util/Date:<init>	(J)V
    //   210: invokevirtual 334	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   213: pop
    //   214: aload_3
    //   215: ldc_w 336
    //   218: invokevirtual 313	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   221: pop
    //   222: aload_0
    //   223: getfield 28	com/vladium/emma/report/xml/ReportGenerator:m_out	Lcom/vladium/emma/report/xml/ReportGenerator$IndentingWriter;
    //   226: aload_3
    //   227: invokevirtual 163	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   230: invokevirtual 48	com/vladium/emma/report/xml/ReportGenerator$IndentingWriter:write	(Ljava/lang/String;)V
    //   233: aload_0
    //   234: getfield 28	com/vladium/emma/report/xml/ReportGenerator:m_out	Lcom/vladium/emma/report/xml/ReportGenerator$IndentingWriter;
    //   237: invokevirtual 186	com/vladium/emma/report/xml/ReportGenerator$IndentingWriter:newLine	()V
    //   240: aload_0
    //   241: getfield 28	com/vladium/emma/report/xml/ReportGenerator:m_out	Lcom/vladium/emma/report/xml/ReportGenerator$IndentingWriter;
    //   244: invokevirtual 31	com/vladium/emma/report/xml/ReportGenerator$IndentingWriter:flush	()V
    //   247: aload_0
    //   248: invokespecial 79	com/vladium/emma/report/xml/ReportGenerator:eol	()V
    //   251: aload_0
    //   252: ldc_w 338
    //   255: invokespecial 82	com/vladium/emma/report/xml/ReportGenerator:openElementTag	(Ljava/lang/String;)V
    //   258: aload_0
    //   259: iconst_0
    //   260: invokespecial 95	com/vladium/emma/report/xml/ReportGenerator:closeElementTag	(Z)V
    //   263: aload_0
    //   264: getfield 28	com/vladium/emma/report/xml/ReportGenerator:m_out	Lcom/vladium/emma/report/xml/ReportGenerator$IndentingWriter;
    //   267: invokevirtual 98	com/vladium/emma/report/xml/ReportGenerator$IndentingWriter:incIndent	()V
    //   270: aload_0
    //   271: invokespecial 79	com/vladium/emma/report/xml/ReportGenerator:eol	()V
    //   274: aload_0
    //   275: ldc_w 340
    //   278: invokespecial 82	com/vladium/emma/report/xml/ReportGenerator:openElementTag	(Ljava/lang/String;)V
    //   281: aload_0
    //   282: iconst_0
    //   283: invokespecial 95	com/vladium/emma/report/xml/ReportGenerator:closeElementTag	(Z)V
    //   286: aload_0
    //   287: getfield 28	com/vladium/emma/report/xml/ReportGenerator:m_out	Lcom/vladium/emma/report/xml/ReportGenerator$IndentingWriter;
    //   290: invokevirtual 98	com/vladium/emma/report/xml/ReportGenerator$IndentingWriter:incIndent	()V
    //   293: aload_0
    //   294: ldc_w 342
    //   297: aload_1
    //   298: invokevirtual 345	com/vladium/emma/report/AllItem:getChildCount	()I
    //   301: invokespecial 347	com/vladium/emma/report/xml/ReportGenerator:emitStatsCount	(Ljava/lang/String;I)V
    //   304: aload_0
    //   305: ldc_w 349
    //   308: aload_1
    //   309: bipush 11
    //   311: invokevirtual 353	com/vladium/emma/report/AllItem:getAggregate	(I)I
    //   314: invokespecial 347	com/vladium/emma/report/xml/ReportGenerator:emitStatsCount	(Ljava/lang/String;I)V
    //   317: aload_0
    //   318: ldc_w 355
    //   321: aload_1
    //   322: bipush 10
    //   324: invokevirtual 353	com/vladium/emma/report/AllItem:getAggregate	(I)I
    //   327: invokespecial 347	com/vladium/emma/report/xml/ReportGenerator:emitStatsCount	(Ljava/lang/String;I)V
    //   330: aload_0
    //   331: getfield 359	com/vladium/emma/report/xml/ReportGenerator:m_srcView	Z
    //   334: ifeq +43 -> 377
    //   337: aload_0
    //   338: getfield 362	com/vladium/emma/report/xml/ReportGenerator:m_hasSrcFileInfo	Z
    //   341: ifeq +36 -> 377
    //   344: aload_0
    //   345: ldc_w 364
    //   348: aload_1
    //   349: bipush 12
    //   351: invokevirtual 353	com/vladium/emma/report/AllItem:getAggregate	(I)I
    //   354: invokespecial 347	com/vladium/emma/report/xml/ReportGenerator:emitStatsCount	(Ljava/lang/String;I)V
    //   357: aload_0
    //   358: getfield 367	com/vladium/emma/report/xml/ReportGenerator:m_hasLineNumberInfo	Z
    //   361: ifeq +16 -> 377
    //   364: aload_0
    //   365: ldc_w 369
    //   368: aload_1
    //   369: bipush 7
    //   371: invokevirtual 353	com/vladium/emma/report/AllItem:getAggregate	(I)I
    //   374: invokespecial 347	com/vladium/emma/report/xml/ReportGenerator:emitStatsCount	(Ljava/lang/String;I)V
    //   377: aload_0
    //   378: getfield 28	com/vladium/emma/report/xml/ReportGenerator:m_out	Lcom/vladium/emma/report/xml/ReportGenerator$IndentingWriter;
    //   381: invokevirtual 133	com/vladium/emma/report/xml/ReportGenerator$IndentingWriter:decIndent	()V
    //   384: aload_0
    //   385: invokespecial 79	com/vladium/emma/report/xml/ReportGenerator:eol	()V
    //   388: aload_0
    //   389: ldc_w 340
    //   392: invokespecial 136	com/vladium/emma/report/xml/ReportGenerator:endElement	(Ljava/lang/String;)V
    //   395: aload_0
    //   396: invokespecial 79	com/vladium/emma/report/xml/ReportGenerator:eol	()V
    //   399: aload_0
    //   400: ldc_w 371
    //   403: invokespecial 82	com/vladium/emma/report/xml/ReportGenerator:openElementTag	(Ljava/lang/String;)V
    //   406: aload_0
    //   407: iconst_0
    //   408: invokespecial 95	com/vladium/emma/report/xml/ReportGenerator:closeElementTag	(Z)V
    //   411: aload_0
    //   412: getfield 28	com/vladium/emma/report/xml/ReportGenerator:m_out	Lcom/vladium/emma/report/xml/ReportGenerator$IndentingWriter;
    //   415: invokevirtual 98	com/vladium/emma/report/xml/ReportGenerator$IndentingWriter:incIndent	()V
    //   418: aload_0
    //   419: aload_1
    //   420: aload_0
    //   421: getfield 375	com/vladium/emma/report/xml/ReportGenerator:m_typeSortComparators	[Lcom/vladium/emma/report/ItemComparator;
    //   424: invokestatic 380	com/vladium/emma/report/PackageItem:getTypeMetadata	()Lcom/vladium/emma/report/IItemMetadata;
    //   427: invokeinterface 109 1 0
    //   432: aaload
    //   433: invokespecial 382	com/vladium/emma/report/xml/ReportGenerator:emitItem	(Lcom/vladium/emma/report/IItem;Lcom/vladium/emma/report/ItemComparator;)V
    //   436: aload_0
    //   437: getfield 28	com/vladium/emma/report/xml/ReportGenerator:m_out	Lcom/vladium/emma/report/xml/ReportGenerator$IndentingWriter;
    //   440: invokevirtual 133	com/vladium/emma/report/xml/ReportGenerator$IndentingWriter:decIndent	()V
    //   443: aload_0
    //   444: invokespecial 79	com/vladium/emma/report/xml/ReportGenerator:eol	()V
    //   447: aload_0
    //   448: ldc_w 371
    //   451: invokespecial 136	com/vladium/emma/report/xml/ReportGenerator:endElement	(Ljava/lang/String;)V
    //   454: aload_0
    //   455: getfield 28	com/vladium/emma/report/xml/ReportGenerator:m_out	Lcom/vladium/emma/report/xml/ReportGenerator$IndentingWriter;
    //   458: invokevirtual 133	com/vladium/emma/report/xml/ReportGenerator$IndentingWriter:decIndent	()V
    //   461: aload_0
    //   462: invokespecial 79	com/vladium/emma/report/xml/ReportGenerator:eol	()V
    //   465: aload_0
    //   466: ldc_w 338
    //   469: invokespecial 136	com/vladium/emma/report/xml/ReportGenerator:endElement	(Ljava/lang/String;)V
    //   472: aload_2
    //   473: areturn
    //   474: astore_1
    //   475: new 35	com/vladium/emma/EMMARuntimeException
    //   478: dup
    //   479: ldc 37
    //   481: aload_1
    //   482: invokespecial 40	com/vladium/emma/EMMARuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   485: athrow
    //   486: astore_1
    //   487: new 35	com/vladium/emma/EMMARuntimeException
    //   490: dup
    //   491: ldc 37
    //   493: aload_1
    //   494: invokespecial 40	com/vladium/emma/EMMARuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   497: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	498	0	this	ReportGenerator
    //   0	498	1	paramAllItem	com.vladium.emma.report.AllItem
    //   0	498	2	paramObject	Object
    //   11	216	3	localObject	Object
    //   7	6	4	localFile	File
    // Exception table:
    //   from	to	target	type
    //   149	247	474	java/io/IOException
    //   0	9	486	java/io/IOException
    //   17	36	486	java/io/IOException
    //   36	149	486	java/io/IOException
    //   247	377	486	java/io/IOException
    //   377	472	486	java/io/IOException
    //   475	486	486	java/io/IOException
  }
  
  public Object visit(ClassItem paramClassItem, Object paramObject)
  {
    try
    {
      emitItem(paramClassItem, this.m_typeSortComparators[MethodItem.getTypeMetadata().getTypeID()]);
      return paramObject;
    }
    catch (IOException paramClassItem)
    {
      throw new EMMARuntimeException("REPORT_IO_FAILURE", paramClassItem);
    }
  }
  
  public Object visit(MethodItem paramMethodItem, Object paramObject)
  {
    try
    {
      emitItem(paramMethodItem, null);
      return paramObject;
    }
    catch (IOException paramMethodItem)
    {
      throw new EMMARuntimeException("REPORT_IO_FAILURE", paramMethodItem);
    }
  }
  
  /* Error */
  public Object visit(com.vladium.emma.report.PackageItem paramPackageItem, Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 391	com/vladium/emma/report/xml/ReportGenerator:m_verbose	Z
    //   4: ifeq +39 -> 43
    //   7: aload_0
    //   8: getfield 229	com/vladium/emma/report/xml/ReportGenerator:m_log	Lcom/vladium/logging/Logger;
    //   11: new 170	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 393
    //   21: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 394	com/vladium/emma/report/PackageItem:getName	()Ljava/lang/String;
    //   28: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: ldc_w 296
    //   34: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokevirtual 397	com/vladium/logging/Logger:verbose	(Ljava/lang/String;)V
    //   43: aload_0
    //   44: getfield 375	com/vladium/emma/report/xml/ReportGenerator:m_typeSortComparators	[Lcom/vladium/emma/report/ItemComparator;
    //   47: astore 4
    //   49: aload_0
    //   50: getfield 359	com/vladium/emma/report/xml/ReportGenerator:m_srcView	Z
    //   53: ifeq +23 -> 76
    //   56: invokestatic 400	com/vladium/emma/report/SrcFileItem:getTypeMetadata	()Lcom/vladium/emma/report/IItemMetadata;
    //   59: invokeinterface 109 1 0
    //   64: istore_3
    //   65: aload_0
    //   66: aload_1
    //   67: aload 4
    //   69: iload_3
    //   70: aaload
    //   71: invokespecial 382	com/vladium/emma/report/xml/ReportGenerator:emitItem	(Lcom/vladium/emma/report/IItem;Lcom/vladium/emma/report/ItemComparator;)V
    //   74: aload_2
    //   75: areturn
    //   76: invokestatic 403	com/vladium/emma/report/ClassItem:getTypeMetadata	()Lcom/vladium/emma/report/IItemMetadata;
    //   79: invokeinterface 109 1 0
    //   84: istore_3
    //   85: goto -20 -> 65
    //   88: astore_1
    //   89: new 35	com/vladium/emma/EMMARuntimeException
    //   92: dup
    //   93: ldc 37
    //   95: aload_1
    //   96: invokespecial 40	com/vladium/emma/EMMARuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	ReportGenerator
    //   0	100	1	paramPackageItem	com.vladium.emma.report.PackageItem
    //   0	100	2	paramObject	Object
    //   64	21	3	i	int
    //   47	21	4	arrayOfItemComparator	ItemComparator[]
    // Exception table:
    //   from	to	target	type
    //   43	65	88	java/io/IOException
    //   65	74	88	java/io/IOException
    //   76	85	88	java/io/IOException
  }
  
  public Object visit(SrcFileItem paramSrcFileItem, Object paramObject)
  {
    try
    {
      emitItem(paramSrcFileItem, this.m_typeSortComparators[ClassItem.getTypeMetadata().getTypeID()]);
      return paramObject;
    }
    catch (IOException paramSrcFileItem)
    {
      throw new EMMARuntimeException("REPORT_IO_FAILURE", paramSrcFileItem);
    }
  }
  
  private static final class IndentingWriter
    extends BufferedWriter
  {
    private static final int INDENT_INCREMENT = 2;
    private int m_indent;
    private transient String m_sindent;
    private int m_state;
    
    IndentingWriter(Writer paramWriter, int paramInt1, int paramInt2)
    {
      super(paramInt1);
      this.m_indent = paramInt2;
    }
    
    private void indent()
      throws IOException
    {
      if (this.m_state == 0)
      {
        String str = getIndent();
        super.write(str, 0, str.length());
        this.m_state = 1;
      }
    }
    
    void decIndent()
    {
      decIndent(2);
    }
    
    void decIndent(int paramInt)
    {
      if (paramInt < 0) {
        throw new IllegalArgumentException("delta be non-negative: " + paramInt);
      }
      if (paramInt > this.m_indent) {
        throw new IllegalArgumentException("delta = " + paramInt + ", current indent = " + this.m_indent);
      }
      this.m_indent -= paramInt;
    }
    
    String getIndent()
    {
      if (this.m_indent <= 0) {
        return "";
      }
      if ((this.m_sindent == null) || (this.m_sindent.length() < this.m_indent))
      {
        char[] arrayOfChar = new char[this.m_indent];
        int i = 0;
        while (i < this.m_indent)
        {
          arrayOfChar[i] = ' ';
          i += 1;
        }
        this.m_sindent = new String(arrayOfChar);
        return this.m_sindent;
      }
      return this.m_sindent.substring(0, this.m_indent);
    }
    
    void incIndent()
    {
      incIndent(2);
    }
    
    void incIndent(int paramInt)
    {
      if (paramInt < 0) {
        throw new IllegalArgumentException("delta be non-negative: " + paramInt);
      }
      this.m_indent += paramInt;
    }
    
    public void newLine()
      throws IOException
    {
      this.m_state = 0;
      super.write(IConstants.EOL, 0, IConstants.EOL.length());
    }
    
    public void write(int paramInt)
      throws IOException
    {
      indent();
      super.write(paramInt);
    }
    
    public void write(String paramString, int paramInt1, int paramInt2)
      throws IOException
    {
      indent();
      super.write(paramString, paramInt1, paramInt2);
    }
    
    public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
      throws IOException
    {
      indent();
      super.write(paramArrayOfChar, paramInt1, paramInt2);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/report/xml/ReportGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */