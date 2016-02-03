package com.mobisystems.office.pdfExport;

import java.io.InputStream;

public class c
  extends d
{
  private int _height;
  private int _width;
  private InputStream aMb;
  
  static
  {
    if (!c.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public c(String paramString, InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    super(paramString, null, 0);
    assert (paramInputStream != null);
    this.aMb = paramInputStream;
    this._width = paramInt1;
    this._height = paramInt2;
  }
  
  private void Kc() {}
  
  /* Error */
  protected void d(PdfWriter paramPdfWriter)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 6
    //   9: aload 6
    //   11: astore 4
    //   13: aload 7
    //   15: astore_3
    //   16: aload 8
    //   18: astore 5
    //   20: aload_0
    //   21: getfield 33	com/mobisystems/office/pdfExport/c:aMb	Ljava/io/InputStream;
    //   24: ifnonnull +67 -> 91
    //   27: aload 6
    //   29: astore 4
    //   31: aload 7
    //   33: astore_3
    //   34: aload 8
    //   36: astore 5
    //   38: new 42	java/io/IOException
    //   41: dup
    //   42: invokespecial 45	java/io/IOException:<init>	()V
    //   45: athrow
    //   46: astore_1
    //   47: aload 4
    //   49: astore_3
    //   50: aload_1
    //   51: invokevirtual 48	java/io/IOException:printStackTrace	()V
    //   54: aload 4
    //   56: astore_3
    //   57: new 50	com/mobisystems/office/pdfExport/PdfWriter$WriteException
    //   60: dup
    //   61: aload_1
    //   62: invokespecial 53	com/mobisystems/office/pdfExport/PdfWriter$WriteException:<init>	(Ljava/io/IOException;)V
    //   65: athrow
    //   66: astore_1
    //   67: aload_0
    //   68: getfield 33	com/mobisystems/office/pdfExport/c:aMb	Ljava/io/InputStream;
    //   71: ifnull +10 -> 81
    //   74: aload_0
    //   75: getfield 33	com/mobisystems/office/pdfExport/c:aMb	Ljava/io/InputStream;
    //   78: invokevirtual 58	java/io/InputStream:close	()V
    //   81: aload_3
    //   82: ifnull +7 -> 89
    //   85: aload_3
    //   86: invokevirtual 61	java/io/OutputStream:close	()V
    //   89: aload_1
    //   90: athrow
    //   91: aload 6
    //   93: astore 4
    //   95: aload 7
    //   97: astore_3
    //   98: aload 8
    //   100: astore 5
    //   102: aload_1
    //   103: aload_0
    //   104: getfield 35	com/mobisystems/office/pdfExport/c:_width	I
    //   107: aload_0
    //   108: getfield 37	com/mobisystems/office/pdfExport/c:_height	I
    //   111: aconst_null
    //   112: invokevirtual 67	com/mobisystems/office/pdfExport/PdfWriter:a	(IILcom/mobisystems/office/pdfExport/f;)Ljava/io/OutputStream;
    //   115: astore_1
    //   116: aload_1
    //   117: astore 4
    //   119: aload_1
    //   120: astore_3
    //   121: aload_1
    //   122: astore 5
    //   124: sipush 8000
    //   127: newarray <illegal type>
    //   129: astore 6
    //   131: aload_1
    //   132: astore 4
    //   134: aload_1
    //   135: astore_3
    //   136: aload_1
    //   137: astore 5
    //   139: aload_0
    //   140: getfield 33	com/mobisystems/office/pdfExport/c:aMb	Ljava/io/InputStream;
    //   143: aload 6
    //   145: invokevirtual 71	java/io/InputStream:read	([B)I
    //   148: istore_2
    //   149: iload_2
    //   150: ifle +42 -> 192
    //   153: aload_1
    //   154: astore 4
    //   156: aload_1
    //   157: astore_3
    //   158: aload_1
    //   159: astore 5
    //   161: aload_1
    //   162: aload 6
    //   164: iconst_0
    //   165: iload_2
    //   166: invokevirtual 75	java/io/OutputStream:write	([BII)V
    //   169: goto -38 -> 131
    //   172: astore_1
    //   173: aload 5
    //   175: astore_3
    //   176: aload_1
    //   177: invokevirtual 76	java/lang/Exception:printStackTrace	()V
    //   180: aload 5
    //   182: astore_3
    //   183: new 78	java/lang/RuntimeException
    //   186: dup
    //   187: aload_1
    //   188: invokespecial 81	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   191: athrow
    //   192: aload_1
    //   193: astore 4
    //   195: aload_1
    //   196: astore_3
    //   197: aload_1
    //   198: astore 5
    //   200: aload_0
    //   201: invokespecial 83	com/mobisystems/office/pdfExport/c:Kc	()V
    //   204: aload_0
    //   205: getfield 33	com/mobisystems/office/pdfExport/c:aMb	Ljava/io/InputStream;
    //   208: ifnull +10 -> 218
    //   211: aload_0
    //   212: getfield 33	com/mobisystems/office/pdfExport/c:aMb	Ljava/io/InputStream;
    //   215: invokevirtual 58	java/io/InputStream:close	()V
    //   218: aload_1
    //   219: ifnull +7 -> 226
    //   222: aload_1
    //   223: invokevirtual 61	java/io/OutputStream:close	()V
    //   226: return
    //   227: astore_3
    //   228: aload_3
    //   229: invokevirtual 48	java/io/IOException:printStackTrace	()V
    //   232: goto -14 -> 218
    //   235: astore_1
    //   236: aload_1
    //   237: invokevirtual 48	java/io/IOException:printStackTrace	()V
    //   240: new 50	com/mobisystems/office/pdfExport/PdfWriter$WriteException
    //   243: dup
    //   244: aload_1
    //   245: invokespecial 53	com/mobisystems/office/pdfExport/PdfWriter$WriteException:<init>	(Ljava/io/IOException;)V
    //   248: athrow
    //   249: astore 4
    //   251: aload 4
    //   253: invokevirtual 48	java/io/IOException:printStackTrace	()V
    //   256: goto -175 -> 81
    //   259: astore_1
    //   260: aload_1
    //   261: invokevirtual 48	java/io/IOException:printStackTrace	()V
    //   264: new 50	com/mobisystems/office/pdfExport/PdfWriter$WriteException
    //   267: dup
    //   268: aload_1
    //   269: invokespecial 53	com/mobisystems/office/pdfExport/PdfWriter$WriteException:<init>	(Ljava/io/IOException;)V
    //   272: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	273	0	this	c
    //   0	273	1	paramPdfWriter	PdfWriter
    //   148	18	2	i	int
    //   15	182	3	localObject1	Object
    //   227	2	3	localIOException1	java.io.IOException
    //   11	183	4	localObject2	Object
    //   249	3	4	localIOException2	java.io.IOException
    //   18	181	5	localObject3	Object
    //   7	156	6	arrayOfByte	byte[]
    //   1	95	7	localObject4	Object
    //   4	95	8	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   20	27	46	java/io/IOException
    //   38	46	46	java/io/IOException
    //   102	116	46	java/io/IOException
    //   124	131	46	java/io/IOException
    //   139	149	46	java/io/IOException
    //   161	169	46	java/io/IOException
    //   200	204	46	java/io/IOException
    //   20	27	66	finally
    //   38	46	66	finally
    //   50	54	66	finally
    //   57	66	66	finally
    //   102	116	66	finally
    //   124	131	66	finally
    //   139	149	66	finally
    //   161	169	66	finally
    //   176	180	66	finally
    //   183	192	66	finally
    //   200	204	66	finally
    //   20	27	172	java/lang/Exception
    //   38	46	172	java/lang/Exception
    //   102	116	172	java/lang/Exception
    //   124	131	172	java/lang/Exception
    //   139	149	172	java/lang/Exception
    //   161	169	172	java/lang/Exception
    //   200	204	172	java/lang/Exception
    //   211	218	227	java/io/IOException
    //   222	226	235	java/io/IOException
    //   74	81	249	java/io/IOException
    //   85	89	259	java/io/IOException
  }
  
  protected void e(PdfWriter paramPdfWriter) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/office/pdfExport/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */