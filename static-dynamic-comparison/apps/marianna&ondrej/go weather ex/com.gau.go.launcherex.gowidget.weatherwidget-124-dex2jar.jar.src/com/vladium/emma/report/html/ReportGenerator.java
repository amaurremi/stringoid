package com.vladium.emma.report.html;

import com.vladium.emma.EMMAProperties;
import com.vladium.emma.EMMARuntimeException;
import com.vladium.emma.IAppErrorCodes;
import com.vladium.emma.data.ICoverageData;
import com.vladium.emma.data.IMetaData;
import com.vladium.emma.report.AbstractReportGenerator;
import com.vladium.emma.report.AllItem;
import com.vladium.emma.report.ClassItem;
import com.vladium.emma.report.IItem;
import com.vladium.emma.report.IItemAttribute;
import com.vladium.emma.report.IItemMetadata;
import com.vladium.emma.report.IItemMetadata.Factory;
import com.vladium.emma.report.IReportDataView;
import com.vladium.emma.report.ItemComparator;
import com.vladium.emma.report.MethodItem;
import com.vladium.emma.report.PackageItem;
import com.vladium.emma.report.ReportProperties.ParsedProperties;
import com.vladium.emma.report.SourcePathCache;
import com.vladium.emma.report.SrcFileItem;
import com.vladium.emma.report.html.doc.ElementList;
import com.vladium.emma.report.html.doc.HTMLDocument;
import com.vladium.emma.report.html.doc.HTMLTable;
import com.vladium.emma.report.html.doc.HTMLTable.ICell;
import com.vladium.emma.report.html.doc.HTMLTable.IRow;
import com.vladium.emma.report.html.doc.HTMLWriter;
import com.vladium.emma.report.html.doc.HyperRef;
import com.vladium.emma.report.html.doc.IContent;
import com.vladium.emma.report.html.doc.IElement;
import com.vladium.emma.report.html.doc.IElement.Factory;
import com.vladium.emma.report.html.doc.IElementList;
import com.vladium.emma.report.html.doc.Tag;
import com.vladium.emma.report.html.doc.Text;
import com.vladium.logging.Logger;
import com.vladium.util.Files;
import com.vladium.util.IProperties;
import com.vladium.util.IntObjectMap;
import com.vladium.util.IntVector;
import com.vladium.util.ObjectIntMap;
import com.vladium.util.Property;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

public final class ReportGenerator
  extends AbstractReportGenerator
  implements IAppErrorCodes
{
  private static final long[] ATTRIBUTE_SETS;
  private static final String CSS = " TABLE,TD,TH {border-style:solid; border-color:black;} TD,TH {background:white;margin:0;line-height:100%;padding-left:0.5em;padding-right:0.5em;} TD {border-width:0 1px 0 0;} TH {border-width:1px 1px 1px 0;} TR TD.h {color:red;} TABLE {border-spacing:0; border-collapse:collapse;border-width:0 0 1px 1px;} P,H1,H2,H3,TH {font-family:verdana,arial,sans-serif;font-size:10pt;} TD {font-family:courier,monospace;font-size:10pt;} TABLE.hdft {border-spacing:0;border-collapse:collapse;border-style:none;} TABLE.hdft TH,TABLE.hdft TD {border-style:none;line-height:normal;} TABLE.hdft TH.tl,TABLE.hdft TD.tl {background:#6699CC;color:white;} TABLE.hdft TD.nv {background:#6633DD;color:white;} .nv A:link {color:white;} .nv A:visited {color:white;} .nv A:active {color:yellow;} TABLE.hdft A:link {color:white;} TABLE.hdft A:visited {color:white;} TABLE.hdft A:active {color:yellow;} .in {color:#356085;} TABLE.s TD {padding-left:0.25em;padding-right:0.25em;} TABLE.s TD.l {padding-left:0.25em;padding-right:0.25em;text-align:right;background:#F0F0F0;} TABLE.s TR.z TD {background:#FF9999;} TABLE.s TR.p TD {background:#FFFF88;} TABLE.s TR.c TD {background:#CCFFCC;} A:link {color:#0000EE;text-decoration:none;} A:visited {color:#0000EE;text-decoration:none;} A:hover {color:#0000EE;text-decoration:underline;} TABLE.cn {border-width:0 0 1px 0;} TABLE.s {border-width:1px 0 1px 1px;} TD.h {color:red;border-width:0 1px 0 0;} TD.f {border-width:0 1px 0 1px;} TD.hf {color:red;border-width:0 1px 0 1px;} TH.f {border-width:1px 1px 1px 1px;} TR.cis TD {background:#F0F0F0;} TR.cis TD {border-width:1px 1px 1px 0;} TR.cis TD.h {color:red;border-width:1px 1px 1px 0;} TR.cis TD.f {border-width:1px 1px 1px 1px;} TR.cis TD.hf {color:red;border-width:1px 1px 1px 1px;} TD.b {border-style:none;background:transparent;line-height:50%;}  TD.bt {border-width:1px 0 0 0;background:transparent;line-height:50%;} TR.o TD {background:#F0F0F0;}TABLE.it {border-style:none;}TABLE.it TD,TABLE.it TH {border-style:none;}";
  private static final String CSS_BLANK = "b";
  private static final String CSS_BOTTOM = "bt";
  private static final String CSS_CLASS_ITEM_SPECIAL = "cis";
  private static final String CSS_CLS_NOLEFT = "cn";
  private static final String CSS_COVERAGE_COMPLETE = "c";
  private static final String CSS_COVERAGE_PARTIAL = "p";
  private static final String CSS_COVERAGE_ZERO = "z";
  private static final String CSS_DATA = "";
  private static final String CSS_DATA_FIRST = "f";
  private static final String CSS_DATA_HIGHLIGHT = "h";
  private static final String CSS_DATA_HIGHLIGHT_FIRST = "hf";
  private static final String CSS_HEADER = "";
  private static final String CSS_HEADER_FIRST = "f";
  private static final String CSS_HEADER_FOOTER = "hdft";
  private static final String CSS_INVISIBLE_TABLE = "it";
  private static final String CSS_ITEM_NAME = "in";
  private static final String CSS_LINENUM = "l";
  private static final String CSS_NAV = "nv";
  private static final String CSS_ODDROW = "o";
  private static final String CSS_SOURCE = "s";
  private static final String CSS_TITLE = "tl";
  private static final String DARKER_BACKGROUND = "#F0F0F0";
  private static final String FILE_EXTENSION = ".html";
  private static final int IO_BUF_SIZE = 32768;
  private static final IContent LEFT_BRACKET = new Text("[", false);
  private static final int MAX_DISPLAY_NAME_LENGTH = 80;
  private static final String NAV_BACKGROUND = "#6633DD";
  private static final File NESTED_ITEMS_PARENT_DIR;
  private static final String NESTED_ITEMS_PARENT_DIRNAME = "_files";
  private static final int[][] NESTING;
  private static final String REPORT_HEADER_TITLE = "EMMA Coverage Report";
  private static final IContent RIGHT_BRACKET = new Text("]", false);
  private static final int SRC_LINE_OFFSET = 4;
  private static final String TITLE_BACKGROUND = "#6699CC";
  private static final String TYPE = "html";
  private static final boolean USE_LINE_COVERAGE_TOOLTIPS = true;
  private final FieldPosition m_fieldPosition = new FieldPosition(0);
  private IContent m_footerBottom;
  private final DecimalFormat m_format = (DecimalFormat)NumberFormat.getPercentInstance();
  private IContent m_pageTitle;
  private LinkedList m_queue;
  private IDGenerator m_reportIDNamespace;
  
  static
  {
    NESTED_ITEMS_PARENT_DIR = new File("_files");
    IItemMetadata[] arrayOfIItemMetadata = IItemMetadata.Factory.getAllTypes();
    ATTRIBUTE_SETS = new long[arrayOfIItemMetadata.length];
    int i = 0;
    while (i < arrayOfIItemMetadata.length)
    {
      ATTRIBUTE_SETS[arrayOfIItemMetadata[i].getTypeID()] = arrayOfIItemMetadata[i].getAttributeIDs();
      i += 1;
    }
    NESTING = (int[][])Array.newInstance(Integer.TYPE, new int[] { 4, 4 });
    i = AllItem.getTypeMetadata().getTypeID();
    NESTING[i][PackageItem.getTypeMetadata().getTypeID()] = 1;
    NESTING[i][SrcFileItem.getTypeMetadata().getTypeID()] = 1;
    NESTING[i][ClassItem.getTypeMetadata().getTypeID()] = 1;
    i = PackageItem.getTypeMetadata().getTypeID();
    NESTING[i][AllItem.getTypeMetadata().getTypeID()] = -1;
    i = SrcFileItem.getTypeMetadata().getTypeID();
    NESTING[i][AllItem.getTypeMetadata().getTypeID()] = -1;
    i = ClassItem.getTypeMetadata().getTypeID();
    NESTING[i][AllItem.getTypeMetadata().getTypeID()] = -1;
  }
  
  public ReportGenerator()
  {
    this.m_format.setMaximumFractionDigits(0);
  }
  
  private void addClassItemRow(IItem paramIItem, boolean paramBoolean1, HTMLTable paramHTMLTable, int[] paramArrayOfInt, String paramString, boolean paramBoolean2)
  {
    HTMLTable.IRow localIRow = paramHTMLTable.newRow();
    if (paramBoolean1) {
      localIRow.setClass("o");
    }
    StringBuffer localStringBuffer = new StringBuffer(11);
    int i = 0;
    if (i < paramArrayOfInt.length)
    {
      int j = paramArrayOfInt[i];
      paramHTMLTable = paramIItem.getAttribute(j, this.m_settings.getUnitsType());
      HTMLTable.ICell localICell;
      if (paramHTMLTable != null)
      {
        localICell = localIRow.newCell();
        paramBoolean1 = false;
        if ((paramString != null) && (j == 0))
        {
          localStringBuffer.setLength(0);
          paramHTMLTable.format(paramIItem, localStringBuffer);
          trimForDisplay(localStringBuffer);
          if (paramBoolean2)
          {
            paramHTMLTable = "#".concat(paramString);
            label124:
            localICell.add(new HyperRef(paramHTMLTable, localStringBuffer.toString(), true));
            localICell.setClass(dataCellStyle(i, paramBoolean1));
          }
        }
      }
      for (;;)
      {
        i += 1;
        break;
        paramHTMLTable = paramString;
        break label124;
        if ((this.m_metrics[j] > 0) && (!paramHTMLTable.passes(paramIItem, this.m_metrics[j]))) {}
        for (paramBoolean1 = true;; paramBoolean1 = false)
        {
          localStringBuffer.setLength(0);
          paramHTMLTable.format(paramIItem, localStringBuffer);
          trimForDisplay(localStringBuffer);
          localICell.setText(localStringBuffer.toString(), true);
          break;
        }
        paramHTMLTable = localIRow.newCell();
        paramHTMLTable.setText(" ", true);
        paramHTMLTable.setClass(dataCellStyle(i, false));
      }
    }
  }
  
  private void addClassRow(ClassItem paramClassItem, int paramInt, HTMLTable paramHTMLTable, int[] paramArrayOfInt, String paramString, boolean paramBoolean)
  {
    HTMLTable.IRow localIRow1 = paramHTMLTable.newRow();
    HTMLTable.IRow localIRow2 = paramHTMLTable.newRow();
    localIRow2.setClass("cis");
    StringBuffer localStringBuffer = new StringBuffer(11);
    int i = 0;
    if (i < paramArrayOfInt.length)
    {
      int j = paramArrayOfInt[i];
      IItemAttribute localIItemAttribute = paramClassItem.getAttribute(j, this.m_settings.getUnitsType());
      HTMLTable.ICell localICell;
      label103:
      boolean bool;
      if (localIItemAttribute != null)
      {
        localStringBuffer.setLength(0);
        localIItemAttribute.format(paramClassItem, localStringBuffer);
        localICell = localIRow1.newCell();
        if (paramInt == 0)
        {
          paramHTMLTable = "b";
          localICell.setClass(paramHTMLTable);
          localICell.setText(" ", true);
          localICell = localIRow2.newCell();
          bool = false;
          if (j != 0) {
            break label273;
          }
          if (paramString == null) {
            break label237;
          }
          if (!paramBoolean) {
            break label231;
          }
          paramHTMLTable = "#".concat(paramString);
          label160:
          localICell.add(new Text("class ", true));
          localICell.add(new HyperRef(paramHTMLTable, localStringBuffer.toString(), true));
          label201:
          localICell.setClass(dataCellStyle(i, bool));
        }
      }
      for (;;)
      {
        i += 1;
        break;
        paramHTMLTable = "bt";
        break label103;
        label231:
        paramHTMLTable = paramString;
        break label160;
        label237:
        localICell.setText("class " + localStringBuffer.toString(), true);
        break label201;
        label273:
        if ((this.m_metrics[j] > 0) && (!localIItemAttribute.passes(paramClassItem, this.m_metrics[j]))) {}
        for (bool = true;; bool = false)
        {
          localICell.setText(localStringBuffer.toString(), true);
          break;
        }
        paramHTMLTable = localIRow2.newCell();
        paramHTMLTable.setText(" ", true);
        paramHTMLTable.setClass(dataCellStyle(i, false));
      }
    }
  }
  
  private int[] addHeaderRow(IItem paramIItem, HTMLTable paramHTMLTable, int[] paramArrayOfInt)
  {
    paramHTMLTable = paramHTMLTable.newTitleRow();
    IntVector localIntVector = new IntVector(paramArrayOfInt.length);
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      int j = paramArrayOfInt[i];
      IItemAttribute localIItemAttribute = paramIItem.getAttribute(j, this.m_settings.getUnitsType());
      if (localIItemAttribute != null)
      {
        HTMLTable.ICell localICell = paramHTMLTable.newCell();
        localICell.setText(localIItemAttribute.getName(), true);
        localICell.setClass(headerCellStyle(i));
        localIntVector.add(j);
      }
      i += 1;
    }
    return localIntVector.values();
  }
  
  private void addItemRow(IItem paramIItem, boolean paramBoolean1, HTMLTable paramHTMLTable, int[] paramArrayOfInt, String paramString, boolean paramBoolean2)
  {
    HTMLTable.IRow localIRow = paramHTMLTable.newRow();
    if (paramBoolean1) {
      localIRow.setClass("o");
    }
    StringBuffer localStringBuffer = new StringBuffer(11);
    int i = 0;
    if (i < paramArrayOfInt.length)
    {
      int j = paramArrayOfInt[i];
      paramHTMLTable = paramIItem.getAttribute(j, this.m_settings.getUnitsType());
      HTMLTable.ICell localICell;
      if (paramHTMLTable != null)
      {
        localICell = localIRow.newCell();
        if ((paramString != null) && (j == 0))
        {
          localStringBuffer.setLength(0);
          paramHTMLTable.format(paramIItem, localStringBuffer);
          trimForDisplay(localStringBuffer);
          if (paramBoolean2)
          {
            paramHTMLTable = "#".concat(paramString);
            label122:
            localICell.add(new HyperRef(paramHTMLTable, localStringBuffer.toString(), true));
          }
        }
      }
      for (;;)
      {
        i += 1;
        break;
        paramHTMLTable = paramString;
        break label122;
        if ((this.m_metrics[j] > 0) && (!paramHTMLTable.passes(paramIItem, this.m_metrics[j]))) {}
        for (j = 1;; j = 0)
        {
          localStringBuffer.setLength(0);
          paramHTMLTable.format(paramIItem, localStringBuffer);
          trimForDisplay(localStringBuffer);
          localICell.setText(localStringBuffer.toString(), true);
          if (j == 0) {
            break;
          }
          localICell.setClass("h");
          break;
        }
        localIRow.newCell().setText(" ", true);
      }
    }
  }
  
  private static String addLineAnchorID(int paramInt, String paramString, IntObjectMap paramIntObjectMap)
  {
    if (paramInt > 0)
    {
      String str = (String)paramIntObjectMap.get(paramInt);
      if (str != null) {
        return str;
      }
      paramIntObjectMap.put(paramInt, paramString);
      return paramString;
    }
    return null;
  }
  
  private IElement addPageFooter(HTMLDocument paramHTMLDocument, IItem paramIItem, IItem[] paramArrayOfIItem)
  {
    HTMLTable localHTMLTable = new HTMLTable("100%", null, null, "0");
    localHTMLTable.setClass("hdft");
    HTMLTable.ICell localICell = localHTMLTable.newRow().newCell();
    localICell.setClass("nv");
    if (paramArrayOfIItem.length > 1) {}
    for (int i = paramArrayOfIItem.length - 1;; i = paramArrayOfIItem.length)
    {
      int j = 0;
      while (j < i)
      {
        localICell.add(LEFT_BRACKET);
        String str = paramArrayOfIItem[j].getName();
        localICell.add(new HyperRef(getItemHREF(paramIItem, paramArrayOfIItem[j]), str, true));
        localICell.add(RIGHT_BRACKET);
        j += 1;
      }
    }
    paramIItem = localHTMLTable.newRow().newCell();
    paramIItem.setClass("tl");
    paramIItem.add(getFooterBottom());
    paramIItem = new ElementList();
    paramIItem.add(IElement.Factory.create(Tag.P));
    paramIItem.add(localHTMLTable);
    paramHTMLDocument.setFooter(paramIItem);
    return localHTMLTable;
  }
  
  private IElement addPageHeader(HTMLDocument paramHTMLDocument, IItem paramIItem, IItem[] paramArrayOfIItem)
  {
    HTMLTable localHTMLTable = new HTMLTable("100%", null, null, "0");
    localHTMLTable.setClass("hdft");
    addPageHeaderTitleRow(localHTMLTable);
    HTMLTable.ICell localICell = localHTMLTable.newRow().newCell();
    localICell.setClass("nv");
    if (paramArrayOfIItem.length > 1) {}
    for (int i = paramArrayOfIItem.length - 1;; i = paramArrayOfIItem.length)
    {
      int j = 0;
      while (j < i)
      {
        localICell.add(LEFT_BRACKET);
        String str = paramArrayOfIItem[j].getName();
        localICell.add(new HyperRef(getItemHREF(paramIItem, paramArrayOfIItem[j]), str, true));
        localICell.add(RIGHT_BRACKET);
        j += 1;
      }
    }
    paramHTMLDocument.setHeader(localHTMLTable);
    return localHTMLTable;
  }
  
  private void addPageHeaderTitleRow(HTMLTable paramHTMLTable)
  {
    paramHTMLTable = paramHTMLTable.newTitleRow().newCell();
    paramHTMLTable.setClass("tl");
    paramHTMLTable.add(getPageTitle());
  }
  
  private HTMLDocument createPage(String paramString)
  {
    paramString = new HTMLDocument(paramString, this.m_settings.getOutEncoding());
    paramString.addStyle(" TABLE,TD,TH {border-style:solid; border-color:black;} TD,TH {background:white;margin:0;line-height:100%;padding-left:0.5em;padding-right:0.5em;} TD {border-width:0 1px 0 0;} TH {border-width:1px 1px 1px 0;} TR TD.h {color:red;} TABLE {border-spacing:0; border-collapse:collapse;border-width:0 0 1px 1px;} P,H1,H2,H3,TH {font-family:verdana,arial,sans-serif;font-size:10pt;} TD {font-family:courier,monospace;font-size:10pt;} TABLE.hdft {border-spacing:0;border-collapse:collapse;border-style:none;} TABLE.hdft TH,TABLE.hdft TD {border-style:none;line-height:normal;} TABLE.hdft TH.tl,TABLE.hdft TD.tl {background:#6699CC;color:white;} TABLE.hdft TD.nv {background:#6633DD;color:white;} .nv A:link {color:white;} .nv A:visited {color:white;} .nv A:active {color:yellow;} TABLE.hdft A:link {color:white;} TABLE.hdft A:visited {color:white;} TABLE.hdft A:active {color:yellow;} .in {color:#356085;} TABLE.s TD {padding-left:0.25em;padding-right:0.25em;} TABLE.s TD.l {padding-left:0.25em;padding-right:0.25em;text-align:right;background:#F0F0F0;} TABLE.s TR.z TD {background:#FF9999;} TABLE.s TR.p TD {background:#FFFF88;} TABLE.s TR.c TD {background:#CCFFCC;} A:link {color:#0000EE;text-decoration:none;} A:visited {color:#0000EE;text-decoration:none;} A:hover {color:#0000EE;text-decoration:underline;} TABLE.cn {border-width:0 0 1px 0;} TABLE.s {border-width:1px 0 1px 1px;} TD.h {color:red;border-width:0 1px 0 0;} TD.f {border-width:0 1px 0 1px;} TD.hf {color:red;border-width:0 1px 0 1px;} TH.f {border-width:1px 1px 1px 1px;} TR.cis TD {background:#F0F0F0;} TR.cis TD {border-width:1px 1px 1px 0;} TR.cis TD.h {color:red;border-width:1px 1px 1px 0;} TR.cis TD.f {border-width:1px 1px 1px 1px;} TR.cis TD.hf {color:red;border-width:1px 1px 1px 1px;} TD.b {border-style:none;background:transparent;line-height:50%;}  TD.bt {border-width:1px 0 0 0;background:transparent;line-height:50%;} TR.o TD {background:#F0F0F0;}TABLE.it {border-style:none;}TABLE.it TD,TABLE.it TH {border-style:none;}");
    return paramString;
  }
  
  private static String dataCellStyle(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 0)
    {
      if (paramBoolean) {
        return "hf";
      }
      return "f";
    }
    if (paramBoolean) {
      return "h";
    }
    return "";
  }
  
  /* Error */
  private void embedSrcFile(SrcFileItem paramSrcFileItem, HTMLDocument paramHTMLDocument, IntObjectMap paramIntObjectMap, SourcePathCache paramSourcePathCache)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 421	com/vladium/emma/report/SrcFileItem:getName	()Ljava/lang/String;
    //   4: astore 13
    //   6: aload_1
    //   7: invokevirtual 425	com/vladium/emma/report/SrcFileItem:getParent	()Lcom/vladium/emma/report/IItem;
    //   10: checkcast 185	com/vladium/emma/report/PackageItem
    //   13: invokevirtual 428	com/vladium/emma/report/PackageItem:getVMName	()Ljava/lang/String;
    //   16: astore 14
    //   18: iconst_0
    //   19: istore 6
    //   21: new 219	com/vladium/emma/report/html/doc/HTMLTable
    //   24: dup
    //   25: ldc_w 357
    //   28: aconst_null
    //   29: aconst_null
    //   30: ldc_w 359
    //   33: invokespecial 362	com/vladium/emma/report/html/doc/HTMLTable:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   36: astore 15
    //   38: iload 6
    //   40: istore 5
    //   42: aload 4
    //   44: ifnull +380 -> 424
    //   47: aload 15
    //   49: ldc 71
    //   51: invokevirtual 363	com/vladium/emma/report/html/doc/HTMLTable:setClass	(Ljava/lang/String;)Lcom/vladium/emma/report/html/doc/ISimpleElement;
    //   54: pop
    //   55: aload 4
    //   57: aload 14
    //   59: aload 13
    //   61: invokevirtual 434	com/vladium/emma/report/SourcePathCache:find	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   64: astore 11
    //   66: iload 6
    //   68: istore 5
    //   70: aload 11
    //   72: ifnull +352 -> 424
    //   75: aconst_null
    //   76: astore 4
    //   78: aconst_null
    //   79: astore 12
    //   81: new 436	java/io/BufferedReader
    //   84: dup
    //   85: new 438	java/io/FileReader
    //   88: dup
    //   89: aload 11
    //   91: invokespecial 441	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   94: ldc 83
    //   96: invokespecial 444	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   99: astore 11
    //   101: aload_0
    //   102: getfield 447	com/vladium/emma/report/html/ReportGenerator:m_hasLineNumberInfo	Z
    //   105: istore 10
    //   107: aload_0
    //   108: getfield 236	com/vladium/emma/report/html/ReportGenerator:m_settings	Lcom/vladium/emma/report/ReportProperties$ParsedProperties;
    //   111: invokevirtual 241	com/vladium/emma/report/ReportProperties$ParsedProperties:getUnitsType	()I
    //   114: istore 7
    //   116: aconst_null
    //   117: astore 4
    //   119: aconst_null
    //   120: astore 12
    //   122: iload 10
    //   124: ifeq +653 -> 777
    //   127: aload_1
    //   128: invokevirtual 451	com/vladium/emma/report/SrcFileItem:getLineCoverage	()Lcom/vladium/util/IntObjectMap;
    //   131: astore 4
    //   133: aload 4
    //   135: ifnull +660 -> 795
    //   138: iconst_1
    //   139: istore 9
    //   141: iload 9
    //   143: ldc_w 453
    //   146: invokestatic 459	com/vladium/util/asserts/$assert:ASSERT	(ZLjava/lang/String;)V
    //   149: new 231	java/lang/StringBuffer
    //   152: dup
    //   153: bipush 64
    //   155: invokespecial 232	java/lang/StringBuffer:<init>	(I)V
    //   158: astore 12
    //   160: goto +617 -> 777
    //   163: aload 11
    //   165: invokevirtual 462	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   168: astore_1
    //   169: aload_1
    //   170: ifnull +568 -> 738
    //   173: aload 15
    //   175: invokevirtual 223	com/vladium/emma/report/html/doc/HTMLTable:newRow	()Lcom/vladium/emma/report/html/doc/HTMLTable$IRow;
    //   178: astore 17
    //   180: aload 17
    //   182: invokeinterface 251 1 0
    //   187: astore 16
    //   189: aload 16
    //   191: ldc 62
    //   193: invokeinterface 292 2 0
    //   198: pop
    //   199: aload_3
    //   200: ifnull +294 -> 494
    //   203: iload 5
    //   205: iconst_4
    //   206: if_icmpge +595 -> 801
    //   209: iload 5
    //   211: istore 6
    //   213: aload_3
    //   214: iload 6
    //   216: invokevirtual 349	com/vladium/util/IntObjectMap:get	(I)Ljava/lang/Object;
    //   219: checkcast 268	java/lang/String
    //   222: astore 18
    //   224: aload 18
    //   226: ifnull +156 -> 382
    //   229: getstatic 465	com/vladium/emma/report/html/doc/Tag:A	Lcom/vladium/emma/report/html/doc/Tag;
    //   232: invokestatic 387	com/vladium/emma/report/html/doc/IElement$Factory:create	(Lcom/vladium/emma/report/html/doc/Tag;)Lcom/vladium/emma/report/html/doc/IElement;
    //   235: astore 19
    //   237: aload 19
    //   239: invokeinterface 471 1 0
    //   244: getstatic 477	com/vladium/emma/report/html/doc/Attribute:NAME	Lcom/vladium/emma/report/html/doc/Attribute;
    //   247: aload 18
    //   249: invokevirtual 483	com/vladium/emma/report/html/doc/AttributeSet:set	(Lcom/vladium/emma/report/html/doc/Attribute;Ljava/lang/String;)Lcom/vladium/emma/report/html/doc/AttributeSet;
    //   252: pop
    //   253: aload 19
    //   255: iload 5
    //   257: invokestatic 485	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   260: iconst_1
    //   261: invokeinterface 486 3 0
    //   266: pop
    //   267: aload 16
    //   269: aload 19
    //   271: invokeinterface 287 2 0
    //   276: pop
    //   277: aload 17
    //   279: invokeinterface 251 1 0
    //   284: astore 18
    //   286: aload_1
    //   287: invokevirtual 489	java/lang/String:length	()I
    //   290: ifle +238 -> 528
    //   293: aload 18
    //   295: aload_1
    //   296: iconst_1
    //   297: invokeinterface 304 3 0
    //   302: pop
    //   303: iload 10
    //   305: ifeq +481 -> 786
    //   308: aload 4
    //   310: iload 5
    //   312: invokevirtual 349	com/vladium/util/IntObjectMap:get	(I)Ljava/lang/Object;
    //   315: checkcast 491	com/vladium/emma/report/SrcFileItem$LineCoverageData
    //   318: astore_1
    //   319: aload_1
    //   320: ifnull +466 -> 786
    //   323: aload_1
    //   324: getfield 494	com/vladium/emma/report/SrcFileItem$LineCoverageData:m_coverageStatus	I
    //   327: tableswitch	default:+456->783, 0:+208->535, 1:+221->548, 2:+398->725
    //   352: iconst_0
    //   353: new 313	java/lang/StringBuilder
    //   356: dup
    //   357: invokespecial 314	java/lang/StringBuilder:<init>	()V
    //   360: ldc_w 496
    //   363: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: aload_1
    //   367: getfield 494	com/vladium/emma/report/SrcFileItem$LineCoverageData:m_coverageStatus	I
    //   370: invokevirtual 499	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   373: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   376: invokestatic 459	com/vladium/util/asserts/$assert:ASSERT	(ZLjava/lang/String;)V
    //   379: goto +407 -> 786
    //   382: aload 16
    //   384: iload 5
    //   386: invokestatic 485	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   389: iconst_1
    //   390: invokeinterface 304 3 0
    //   395: pop
    //   396: goto -119 -> 277
    //   399: astore_3
    //   400: aload 11
    //   402: astore_1
    //   403: aload_1
    //   404: astore 4
    //   406: aload_3
    //   407: getstatic 505	java/lang/System:out	Ljava/io/PrintStream;
    //   410: invokevirtual 509	java/lang/Throwable:printStackTrace	(Ljava/io/PrintStream;)V
    //   413: iconst_0
    //   414: istore 5
    //   416: aload_1
    //   417: ifnull +7 -> 424
    //   420: aload_1
    //   421: invokevirtual 512	java/io/BufferedReader:close	()V
    //   424: iload 5
    //   426: ifne +60 -> 486
    //   429: aload 15
    //   431: ldc 56
    //   433: invokevirtual 363	com/vladium/emma/report/html/doc/HTMLTable:setClass	(Ljava/lang/String;)Lcom/vladium/emma/report/html/doc/ISimpleElement;
    //   436: pop
    //   437: aload 15
    //   439: invokevirtual 324	com/vladium/emma/report/html/doc/HTMLTable:newTitleRow	()Lcom/vladium/emma/report/html/doc/HTMLTable$IRow;
    //   442: invokeinterface 251 1 0
    //   447: new 313	java/lang/StringBuilder
    //   450: dup
    //   451: invokespecial 314	java/lang/StringBuilder:<init>	()V
    //   454: ldc_w 514
    //   457: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: aload 14
    //   462: aload 13
    //   464: invokestatic 520	com/vladium/util/Descriptors:combineVMName	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   467: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: ldc_w 522
    //   473: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   479: iconst_0
    //   480: invokeinterface 304 3 0
    //   485: pop
    //   486: aload_2
    //   487: aload 15
    //   489: invokevirtual 523	com/vladium/emma/report/html/doc/HTMLDocument:add	(Lcom/vladium/emma/report/html/doc/IContent;)Lcom/vladium/emma/report/html/doc/IElementList;
    //   492: pop
    //   493: return
    //   494: aload 16
    //   496: iload 5
    //   498: invokestatic 485	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   501: iconst_1
    //   502: invokeinterface 304 3 0
    //   507: pop
    //   508: goto -231 -> 277
    //   511: astore_1
    //   512: aload 11
    //   514: astore 4
    //   516: aload 4
    //   518: ifnull +8 -> 526
    //   521: aload 4
    //   523: invokevirtual 512	java/io/BufferedReader:close	()V
    //   526: aload_1
    //   527: athrow
    //   528: ldc_w 306
    //   531: astore_1
    //   532: goto -239 -> 293
    //   535: aload 17
    //   537: ldc 36
    //   539: invokeinterface 229 2 0
    //   544: pop
    //   545: goto +241 -> 786
    //   548: aload 17
    //   550: ldc 33
    //   552: invokeinterface 229 2 0
    //   557: pop
    //   558: aload 12
    //   560: iconst_0
    //   561: invokevirtual 254	java/lang/StringBuffer:setLength	(I)V
    //   564: aload_1
    //   565: getfield 526	com/vladium/emma/report/SrcFileItem$LineCoverageData:m_coverageRatio	[[I
    //   568: iload 7
    //   570: aaload
    //   571: astore_1
    //   572: aload_1
    //   573: iconst_0
    //   574: iaload
    //   575: istore 6
    //   577: aload_1
    //   578: iconst_1
    //   579: iaload
    //   580: istore 8
    //   582: aload_0
    //   583: getfield 205	com/vladium/emma/report/html/ReportGenerator:m_format	Ljava/text/DecimalFormat;
    //   586: iload 8
    //   588: i2d
    //   589: iload 6
    //   591: i2d
    //   592: ddiv
    //   593: aload 12
    //   595: aload_0
    //   596: getfield 212	com/vladium/emma/report/html/ReportGenerator:m_fieldPosition	Ljava/text/FieldPosition;
    //   599: invokevirtual 529	java/text/DecimalFormat:format	(DLjava/lang/StringBuffer;Ljava/text/FieldPosition;)Ljava/lang/StringBuffer;
    //   602: pop
    //   603: aload 12
    //   605: ldc_w 531
    //   608: invokevirtual 534	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   611: pop
    //   612: aload 12
    //   614: iload 8
    //   616: invokevirtual 537	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   619: pop
    //   620: aload 12
    //   622: ldc_w 539
    //   625: invokevirtual 534	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   628: pop
    //   629: aload 12
    //   631: iload 6
    //   633: invokevirtual 537	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   636: pop
    //   637: iload 7
    //   639: tableswitch	default:+171->810, 0:+62->701, 1:+74->713
    //   660: aload 16
    //   662: invokeinterface 540 1 0
    //   667: getstatic 543	com/vladium/emma/report/html/doc/Attribute:TITLE	Lcom/vladium/emma/report/html/doc/Attribute;
    //   670: aload 12
    //   672: invokevirtual 278	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   675: invokevirtual 483	com/vladium/emma/report/html/doc/AttributeSet:set	(Lcom/vladium/emma/report/html/doc/Attribute;Ljava/lang/String;)Lcom/vladium/emma/report/html/doc/AttributeSet;
    //   678: pop
    //   679: aload 18
    //   681: invokeinterface 540 1 0
    //   686: getstatic 543	com/vladium/emma/report/html/doc/Attribute:TITLE	Lcom/vladium/emma/report/html/doc/Attribute;
    //   689: aload 12
    //   691: invokevirtual 278	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   694: invokevirtual 483	com/vladium/emma/report/html/doc/AttributeSet:set	(Lcom/vladium/emma/report/html/doc/Attribute;Ljava/lang/String;)Lcom/vladium/emma/report/html/doc/AttributeSet;
    //   697: pop
    //   698: goto +88 -> 786
    //   701: aload 12
    //   703: ldc_w 545
    //   706: invokevirtual 534	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   709: pop
    //   710: goto -50 -> 660
    //   713: aload 12
    //   715: ldc_w 547
    //   718: invokevirtual 534	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   721: pop
    //   722: goto -62 -> 660
    //   725: aload 17
    //   727: ldc 30
    //   729: invokeinterface 229 2 0
    //   734: pop
    //   735: goto +51 -> 786
    //   738: iconst_1
    //   739: istore 5
    //   741: aload 11
    //   743: ifnull +8 -> 751
    //   746: aload 11
    //   748: invokevirtual 512	java/io/BufferedReader:close	()V
    //   751: goto -327 -> 424
    //   754: astore_1
    //   755: goto -4 -> 751
    //   758: astore_1
    //   759: goto -335 -> 424
    //   762: astore_2
    //   763: goto -237 -> 526
    //   766: astore_1
    //   767: goto -251 -> 516
    //   770: astore_3
    //   771: aload 12
    //   773: astore_1
    //   774: goto -371 -> 403
    //   777: iconst_1
    //   778: istore 5
    //   780: goto -617 -> 163
    //   783: goto -431 -> 352
    //   786: iload 5
    //   788: iconst_1
    //   789: iadd
    //   790: istore 5
    //   792: goto -629 -> 163
    //   795: iconst_0
    //   796: istore 9
    //   798: goto -657 -> 141
    //   801: iload 5
    //   803: iconst_4
    //   804: iadd
    //   805: istore 6
    //   807: goto -594 -> 213
    //   810: goto -150 -> 660
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	813	0	this	ReportGenerator
    //   0	813	1	paramSrcFileItem	SrcFileItem
    //   0	813	2	paramHTMLDocument	HTMLDocument
    //   0	813	3	paramIntObjectMap	IntObjectMap
    //   0	813	4	paramSourcePathCache	SourcePathCache
    //   40	765	5	i	int
    //   19	787	6	j	int
    //   114	524	7	k	int
    //   580	35	8	m	int
    //   139	658	9	bool1	boolean
    //   105	199	10	bool2	boolean
    //   64	683	11	localObject1	Object
    //   79	693	12	localStringBuffer	StringBuffer
    //   4	459	13	str1	String
    //   16	445	14	str2	String
    //   36	452	15	localHTMLTable	HTMLTable
    //   187	474	16	localICell	HTMLTable.ICell
    //   178	548	17	localIRow	HTMLTable.IRow
    //   222	458	18	localObject2	Object
    //   235	35	19	localIElement	IElement
    // Exception table:
    //   from	to	target	type
    //   101	116	399	java/lang/Throwable
    //   127	133	399	java/lang/Throwable
    //   141	160	399	java/lang/Throwable
    //   163	169	399	java/lang/Throwable
    //   173	199	399	java/lang/Throwable
    //   213	224	399	java/lang/Throwable
    //   229	277	399	java/lang/Throwable
    //   277	293	399	java/lang/Throwable
    //   293	303	399	java/lang/Throwable
    //   308	319	399	java/lang/Throwable
    //   323	352	399	java/lang/Throwable
    //   352	379	399	java/lang/Throwable
    //   382	396	399	java/lang/Throwable
    //   494	508	399	java/lang/Throwable
    //   535	545	399	java/lang/Throwable
    //   548	572	399	java/lang/Throwable
    //   582	637	399	java/lang/Throwable
    //   660	698	399	java/lang/Throwable
    //   701	710	399	java/lang/Throwable
    //   713	722	399	java/lang/Throwable
    //   725	735	399	java/lang/Throwable
    //   101	116	511	finally
    //   127	133	511	finally
    //   141	160	511	finally
    //   163	169	511	finally
    //   173	199	511	finally
    //   213	224	511	finally
    //   229	277	511	finally
    //   277	293	511	finally
    //   293	303	511	finally
    //   308	319	511	finally
    //   323	352	511	finally
    //   352	379	511	finally
    //   382	396	511	finally
    //   494	508	511	finally
    //   535	545	511	finally
    //   548	572	511	finally
    //   582	637	511	finally
    //   660	698	511	finally
    //   701	710	511	finally
    //   713	722	511	finally
    //   725	735	511	finally
    //   746	751	754	java/lang/Throwable
    //   420	424	758	java/lang/Throwable
    //   521	526	762	java/lang/Throwable
    //   81	101	766	finally
    //   406	413	766	finally
    //   81	101	770	java/lang/Throwable
  }
  
  private IContent getFooterBottom()
  {
    Object localObject2 = this.m_footerBottom;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = new ElementList();
      ((IElementList)localObject2).add(new HyperRef("this private build is unsupported", "EMMA 0.0.0 (unsupported private build)", true));
      ((IElementList)localObject2).add(new Text(" (C) Vladimir Roubtsov", true));
      localObject1 = localObject2;
      this.m_footerBottom = ((IContent)localObject2);
    }
    return (IContent)localObject1;
  }
  
  private static File getItemFile(File paramFile, String paramString)
  {
    if (paramFile == null) {
      return new File(paramString.concat(".html"));
    }
    return new File(paramFile, paramString.concat(".html"));
  }
  
  private String getItemHREF(IItem paramIItem1, IItem paramIItem2)
  {
    if ((paramIItem2 instanceof AllItem)) {}
    for (String str = this.m_settings.getOutFile().getName(); paramIItem1 == null; str = this.m_reportIDNamespace.getID(getItemKey(paramIItem2)).concat(".html")) {
      return str;
    }
    int i = NESTING[paramIItem1.getMetadata().getTypeID()][paramIItem2.getMetadata().getTypeID()];
    if (i == 1) {
      return "_files".concat("/").concat(str);
    }
    if (i == -1) {
      return "../".concat(str);
    }
    return str;
  }
  
  private static String getItemKey(IItem paramIItem)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    while (paramIItem != null)
    {
      localStringBuffer.append(paramIItem.getName());
      localStringBuffer.append(':');
      paramIItem = paramIItem.getParent();
    }
    return localStringBuffer.toString();
  }
  
  private IContent getPageTitle()
  {
    Object localObject2 = this.m_pageTitle;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = new ElementList();
      ((IElementList)localObject2).add(new HyperRef("this private build is unsupported", "EMMA", true));
      localObject1 = new StringBuffer(" Coverage Report (generated ");
      ((StringBuffer)localObject1).append(new Date(EMMAProperties.getTimeStamp()));
      ((StringBuffer)localObject1).append(')');
      ((IElementList)localObject2).add(new Text(((StringBuffer)localObject1).toString(), true));
      localObject1 = localObject2;
      this.m_pageTitle = ((IContent)localObject2);
    }
    return (IContent)localObject1;
  }
  
  private IItem[] getParentPath(IItem paramIItem)
  {
    Object localObject = new LinkedList();
    while (paramIItem != null)
    {
      ((LinkedList)localObject).add(paramIItem);
      paramIItem = paramIItem.getParent();
    }
    paramIItem = new IItem[((LinkedList)localObject).size()];
    int i = paramIItem.length - 1;
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramIItem[i] = ((IItem)((Iterator)localObject).next());
      i -= 1;
    }
    return paramIItem;
  }
  
  private static String headerCellStyle(int paramInt)
  {
    if (paramInt == 0) {
      return "f";
    }
    return "";
  }
  
  private static HTMLWriter openOutFile(File paramFile, String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      File localFile = paramFile.getParentFile();
      if (localFile != null) {
        localFile.mkdirs();
      }
      paramFile = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(paramFile), paramString), 32768);
      return new HTMLWriter(paramFile);
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
  
  private boolean srcFileAvailable(SrcFileItem paramSrcFileItem, SourcePathCache paramSourcePathCache)
  {
    if (paramSourcePathCache == null) {
      return false;
    }
    String str = paramSrcFileItem.getName();
    if (paramSourcePathCache.find(((PackageItem)paramSrcFileItem.getParent()).getVMName(), str) != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static void trimForDisplay(StringBuffer paramStringBuffer)
  {
    if (paramStringBuffer.length() > 80)
    {
      paramStringBuffer.setLength(77);
      paramStringBuffer.append("...");
    }
  }
  
  public void cleanup()
  {
    this.m_queue = null;
    this.m_reportIDNamespace = null;
    super.cleanup();
  }
  
  public final String getType()
  {
    return "html";
  }
  
  public void process(IMetaData paramIMetaData, ICoverageData paramICoverageData, SourcePathCache paramSourcePathCache, IProperties paramIProperties)
    throws EMMARuntimeException
  {
    initialize(paramIMetaData, paramICoverageData, paramSourcePathCache, paramIProperties);
    this.m_pageTitle = null;
    this.m_footerBottom = null;
    paramICoverageData = this.m_settings.getOutDir();
    if ((paramICoverageData == null) || (paramICoverageData.equals(new File(Property.getSystemProperty("user.dir", "")))))
    {
      paramICoverageData = new File("coverage");
      this.m_settings.setOutDir(paramICoverageData);
    }
    long l1 = 0L;
    boolean bool = this.m_log.atTRACE1();
    if (bool) {
      l1 = System.currentTimeMillis();
    }
    this.m_queue = new LinkedList();
    this.m_reportIDNamespace = new IDGenerator(paramIMetaData.size());
    this.m_queue.add(this.m_view.getRoot());
    while (!this.m_queue.isEmpty()) {
      ((IItem)this.m_queue.removeFirst()).accept(this, null);
    }
    this.m_reportIDNamespace = null;
    if (bool)
    {
      long l2 = System.currentTimeMillis();
      this.m_log.trace1("process", "[" + getType() + "] report generated in " + (l2 - l1) + " ms");
    }
  }
  
  public Object visit(AllItem paramAllItem, Object paramObject)
  {
    Object localObject3 = null;
    Object localObject1 = localObject3;
    Object localObject2;
    int i;
    for (;;)
    {
      try
      {
        Object localObject4 = this.m_settings.getOutFile();
        localObject2 = localObject4;
        if (localObject4 == null)
        {
          localObject1 = localObject3;
          localObject2 = new File("index".concat(".html"));
          localObject1 = localObject3;
          this.m_settings.setOutFile((File)localObject2);
        }
        localObject1 = localObject3;
        localObject2 = Files.newFile(this.m_settings.getOutDir(), (File)localObject2);
        localObject1 = localObject3;
        this.m_log.info("writing [" + getType() + "] report to [" + ((File)localObject2).getAbsolutePath() + "] ...");
        localObject1 = localObject3;
        localObject4 = openOutFile((File)localObject2, this.m_settings.getOutEncoding(), true);
        localObject1 = localObject4;
        int[] arrayOfInt = this.m_settings.getColumnOrder();
        localObject1 = localObject4;
        localObject2 = new StringBuffer();
        localObject1 = localObject4;
        localObject3 = new StringBuffer("EMMA Coverage Report");
        localObject1 = localObject4;
        ((StringBuffer)localObject3).append(" (generated ");
        localObject1 = localObject4;
        ((StringBuffer)localObject3).append(new Date(EMMAProperties.getTimeStamp()));
        localObject1 = localObject4;
        ((StringBuffer)localObject3).append(')');
        localObject1 = localObject4;
        HTMLDocument localHTMLDocument = createPage(((StringBuffer)localObject3).toString());
        localObject1 = localObject4;
        localObject3 = getParentPath(paramAllItem);
        localObject1 = localObject4;
        addPageHeader(localHTMLDocument, paramAllItem, (IItem[])localObject3);
        localObject1 = localObject4;
        addPageFooter(localHTMLDocument, paramAllItem, (IItem[])localObject3);
        localObject1 = localObject4;
        localHTMLDocument.addH(1, "OVERALL COVERAGE SUMMARY", null);
        localObject1 = localObject4;
        localObject3 = new HTMLTable("100%", null, null, "0");
        localObject1 = localObject4;
        Object localObject5 = ((HTMLTable)localObject3).newTitleRow();
        localObject1 = localObject4;
        Object localObject6 = ((HTMLTable)localObject3).newRow();
        i = 0;
        localObject1 = localObject4;
        Object localObject7;
        if (i < arrayOfInt.length)
        {
          j = arrayOfInt[i];
          localObject1 = localObject4;
          localObject7 = paramAllItem.getAttribute(j, this.m_settings.getUnitsType());
          localObject1 = localObject4;
          ((HTMLTable.IRow)localObject5).newCell().setText(((IItemAttribute)localObject7).getName(), true);
          if (localObject7 != null)
          {
            localObject1 = localObject4;
            if (this.m_metrics[j] <= 0) {
              break label1290;
            }
            localObject1 = localObject4;
            if (((IItemAttribute)localObject7).passes(paramAllItem, this.m_metrics[j])) {
              break label1290;
            }
            j = 1;
            localObject1 = localObject4;
            ((StringBuffer)localObject2).setLength(0);
            localObject1 = localObject4;
            ((IItemAttribute)localObject7).format(paramAllItem, (StringBuffer)localObject2);
            localObject1 = localObject4;
            localObject7 = ((HTMLTable.IRow)localObject6).newCell();
            localObject1 = localObject4;
            ((HTMLTable.ICell)localObject7).setText(((StringBuffer)localObject2).toString(), true);
            if (j != 0)
            {
              localObject1 = localObject4;
              ((HTMLTable.ICell)localObject7).setClass("h");
            }
          }
        }
        else
        {
          localObject1 = localObject4;
          localHTMLDocument.add((IContent)localObject3);
          localObject1 = localObject4;
          localHTMLDocument.addH(2, "OVERALL STATS SUMMARY", null);
          localObject1 = localObject4;
          localObject2 = new HTMLTable(null, null, null, "0");
          localObject1 = localObject4;
          ((HTMLTable)localObject2).setClass("it");
          localObject1 = localObject4;
          localObject3 = ((HTMLTable)localObject2).newRow();
          localObject1 = localObject4;
          ((HTMLTable.IRow)localObject3).newCell().setText("total packages:", true);
          localObject1 = localObject4;
          ((HTMLTable.IRow)localObject3).newCell().setText("" + paramAllItem.getChildCount(), false);
          localObject1 = localObject4;
          if (this.m_srcView)
          {
            localObject1 = localObject4;
            if (this.m_hasSrcFileInfo)
            {
              localObject1 = localObject4;
              localObject3 = ((HTMLTable)localObject2).newRow();
              localObject1 = localObject4;
              ((HTMLTable.IRow)localObject3).newCell().setText("total executable files:", true);
              localObject1 = localObject4;
              ((HTMLTable.IRow)localObject3).newCell().setText("" + paramAllItem.getAggregate(12), false);
            }
          }
          localObject1 = localObject4;
          localObject3 = ((HTMLTable)localObject2).newRow();
          localObject1 = localObject4;
          ((HTMLTable.IRow)localObject3).newCell().setText("total classes:", true);
          localObject1 = localObject4;
          ((HTMLTable.IRow)localObject3).newCell().setText("" + paramAllItem.getAggregate(11), true);
          localObject1 = localObject4;
          localObject3 = ((HTMLTable)localObject2).newRow();
          localObject1 = localObject4;
          ((HTMLTable.IRow)localObject3).newCell().setText("total methods:", true);
          localObject1 = localObject4;
          ((HTMLTable.IRow)localObject3).newCell().setText("" + paramAllItem.getAggregate(10), true);
          localObject1 = localObject4;
          if (this.m_srcView)
          {
            localObject1 = localObject4;
            if (this.m_hasSrcFileInfo)
            {
              localObject1 = localObject4;
              if (this.m_hasLineNumberInfo)
              {
                localObject1 = localObject4;
                localObject3 = ((HTMLTable)localObject2).newRow();
                localObject1 = localObject4;
                ((HTMLTable.IRow)localObject3).newCell().setText("total executable lines:", true);
                localObject1 = localObject4;
                ((HTMLTable.IRow)localObject3).newCell().setText("" + paramAllItem.getAggregate(7), true);
              }
            }
          }
          localObject1 = localObject4;
          localHTMLDocument.add((IContent)localObject2);
          localObject1 = localObject4;
          if (this.m_settings.getDepth() <= paramAllItem.getMetadata().getTypeID()) {
            break label1311;
          }
          i = 1;
          localObject1 = localObject4;
          localHTMLDocument.addH(2, "COVERAGE BREAKDOWN BY PACKAGE", null);
          localObject1 = localObject4;
          localObject5 = new HTMLTable("100%", null, null, "0");
          localObject3 = null;
          bool = true;
          localObject1 = localObject4;
          localObject6 = paramAllItem.getChildren(this.m_typeSortComparators[PackageItem.getTypeMetadata().getTypeID()]);
          label1112:
          localObject1 = localObject4;
          if (((Iterator)localObject6).hasNext())
          {
            localObject1 = localObject4;
            localObject7 = (IItem)((Iterator)localObject6).next();
            localObject2 = localObject3;
            if (localObject3 == null)
            {
              localObject1 = localObject4;
              localObject2 = addHeaderRow((IItem)localObject7, (HTMLTable)localObject5, arrayOfInt);
            }
            localObject3 = null;
            if (i != 0)
            {
              localObject1 = localObject4;
              localObject3 = getItemHREF(paramAllItem, (IItem)localObject7);
            }
            localObject1 = localObject4;
            addItemRow((IItem)localObject7, bool, (HTMLTable)localObject5, (int[])localObject2, (String)localObject3, false);
            if (i == 0) {
              break;
            }
            localObject1 = localObject4;
            this.m_queue.addLast(localObject7);
            break;
          }
          localObject1 = localObject4;
          localHTMLDocument.add((IContent)localObject5);
          localObject1 = localObject4;
          localHTMLDocument.emit((HTMLWriter)localObject4);
          localObject1 = localObject4;
          ((HTMLWriter)localObject4).flush();
          return paramObject;
        }
      }
      finally
      {
        if (localObject1 != null) {
          ((HTMLWriter)localObject1).close();
        }
      }
      i += 1;
      continue;
      label1290:
      int j = 0;
    }
    if (!bool) {}
    for (boolean bool = true;; bool = false)
    {
      localObject3 = localObject2;
      break label1112;
      label1311:
      i = 0;
      break;
    }
  }
  
  public Object visit(ClassItem paramClassItem, Object paramObject)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    boolean bool;
    for (;;)
    {
      int i;
      try
      {
        Object localObject3 = getItemFile(NESTED_ITEMS_PARENT_DIR, this.m_reportIDNamespace.getID(getItemKey(paramClassItem)));
        localObject1 = localObject2;
        localObject3 = openOutFile(Files.newFile(this.m_settings.getOutDir(), (File)localObject3), this.m_settings.getOutEncoding(), true);
        localObject1 = localObject3;
        int[] arrayOfInt = this.m_settings.getColumnOrder();
        localObject1 = localObject3;
        localObject2 = new StringBuffer();
        localObject1 = localObject3;
        HTMLDocument localHTMLDocument = createPage("EMMA Coverage Report");
        localObject1 = localObject3;
        Object localObject4 = getParentPath(paramClassItem);
        localObject1 = localObject3;
        addPageHeader(localHTMLDocument, paramClassItem, (IItem[])localObject4);
        localObject1 = localObject3;
        addPageFooter(localHTMLDocument, paramClassItem, (IItem[])localObject4);
        localObject1 = localObject3;
        localObject4 = IElement.Factory.create(Tag.SPAN);
        localObject1 = localObject3;
        ((IElement)localObject4).setText(paramClassItem.getName(), true);
        localObject1 = localObject3;
        ((IElement)localObject4).setClass("in");
        localObject1 = localObject3;
        Object localObject5 = new ElementList();
        localObject1 = localObject3;
        ((IElementList)localObject5).add(new Text("COVERAGE SUMMARY FOR CLASS [", true));
        localObject1 = localObject3;
        ((IElementList)localObject5).add((IContent)localObject4);
        localObject1 = localObject3;
        ((IElementList)localObject5).add(new Text("]", true));
        localObject1 = localObject3;
        localHTMLDocument.addH(1, (IContent)localObject5, null);
        localObject1 = localObject3;
        localObject4 = new HTMLTable("100%", null, null, "0");
        localObject1 = localObject3;
        localObject5 = ((HTMLTable)localObject4).newTitleRow();
        localObject1 = localObject3;
        Object localObject6 = ((HTMLTable)localObject4).newRow();
        i = 0;
        localObject1 = localObject3;
        if (i < arrayOfInt.length)
        {
          j = arrayOfInt[i];
          localObject1 = localObject3;
          Object localObject7 = paramClassItem.getAttribute(j, this.m_settings.getUnitsType());
          localObject1 = localObject3;
          ((HTMLTable.IRow)localObject5).newCell().setText(((IItemAttribute)localObject7).getName(), true);
          if (localObject7 != null)
          {
            localObject1 = localObject3;
            if (this.m_metrics[j] <= 0) {
              break label712;
            }
            localObject1 = localObject3;
            if (((IItemAttribute)localObject7).passes(paramClassItem, this.m_metrics[j])) {
              break label712;
            }
            j = 1;
            localObject1 = localObject3;
            ((StringBuffer)localObject2).setLength(0);
            localObject1 = localObject3;
            ((IItemAttribute)localObject7).format(paramClassItem, (StringBuffer)localObject2);
            localObject1 = localObject3;
            localObject7 = ((HTMLTable.IRow)localObject6).newCell();
            localObject1 = localObject3;
            ((HTMLTable.ICell)localObject7).setText(((StringBuffer)localObject2).toString(), true);
            if (j != 0)
            {
              localObject1 = localObject3;
              ((HTMLTable.ICell)localObject7).setClass("h");
            }
          }
        }
        else
        {
          localObject1 = localObject3;
          localHTMLDocument.add((IContent)localObject4);
          localObject1 = localObject3;
          localHTMLDocument.addH(2, "COVERAGE BREAKDOWN BY METHOD", null);
          localObject1 = localObject3;
          localObject4 = new HTMLTable("100%", null, null, "0");
          localObject2 = null;
          bool = true;
          localObject1 = localObject3;
          localObject5 = paramClassItem.getChildren(this.m_typeSortComparators[MethodItem.getTypeMetadata().getTypeID()]);
          paramClassItem = (ClassItem)localObject2;
          localObject1 = localObject3;
          if (((Iterator)localObject5).hasNext())
          {
            localObject1 = localObject3;
            localObject6 = (MethodItem)((Iterator)localObject5).next();
            localObject2 = paramClassItem;
            if (paramClassItem == null)
            {
              localObject1 = localObject3;
              localObject2 = addHeaderRow((IItem)localObject6, (HTMLTable)localObject4, arrayOfInt);
            }
            localObject1 = localObject3;
            addItemRow((IItem)localObject6, bool, (HTMLTable)localObject4, (int[])localObject2, null, false);
            if (bool) {
              break label724;
            }
            bool = true;
            break;
          }
          localObject1 = localObject3;
          localHTMLDocument.add((IContent)localObject4);
          localObject1 = localObject3;
          localHTMLDocument.emit((HTMLWriter)localObject3);
          localObject1 = localObject3;
          ((HTMLWriter)localObject3).flush();
          return paramObject;
        }
      }
      finally
      {
        if (localObject1 != null) {
          ((HTMLWriter)localObject1).close();
        }
      }
      i += 1;
      continue;
      label712:
      int j = 0;
    }
    for (;;)
    {
      paramClassItem = (ClassItem)localObject2;
      break;
      label724:
      bool = false;
    }
  }
  
  public Object visit(PackageItem paramPackageItem, Object paramObject)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    Object localObject3;
    int i;
    for (;;)
    {
      try
      {
        if (this.m_verbose)
        {
          localObject1 = localObject2;
          this.m_log.verbose("  report: processing package [" + paramPackageItem.getName() + "] ...");
        }
        localObject1 = localObject2;
        localObject3 = getItemFile(NESTED_ITEMS_PARENT_DIR, this.m_reportIDNamespace.getID(getItemKey(paramPackageItem)));
        localObject1 = localObject2;
        HTMLWriter localHTMLWriter = openOutFile(Files.newFile(this.m_settings.getOutDir(), (File)localObject3), this.m_settings.getOutEncoding(), true);
        localObject1 = localHTMLWriter;
        int[] arrayOfInt = this.m_settings.getColumnOrder();
        localObject1 = localHTMLWriter;
        localObject2 = new StringBuffer();
        localObject1 = localHTMLWriter;
        HTMLDocument localHTMLDocument = createPage("EMMA Coverage Report");
        localObject1 = localHTMLWriter;
        localObject3 = getParentPath(paramPackageItem);
        localObject1 = localHTMLWriter;
        addPageHeader(localHTMLDocument, paramPackageItem, (IItem[])localObject3);
        localObject1 = localHTMLWriter;
        addPageFooter(localHTMLDocument, paramPackageItem, (IItem[])localObject3);
        localObject1 = localHTMLWriter;
        localObject3 = IElement.Factory.create(Tag.SPAN);
        localObject1 = localHTMLWriter;
        ((IElement)localObject3).setText(paramPackageItem.getName(), true);
        localObject1 = localHTMLWriter;
        ((IElement)localObject3).setClass("in");
        localObject1 = localHTMLWriter;
        Object localObject4 = new ElementList();
        localObject1 = localHTMLWriter;
        ((IElementList)localObject4).add(new Text("COVERAGE SUMMARY FOR PACKAGE [", true));
        localObject1 = localHTMLWriter;
        ((IElementList)localObject4).add((IContent)localObject3);
        localObject1 = localHTMLWriter;
        ((IElementList)localObject4).add(new Text("]", true));
        localObject1 = localHTMLWriter;
        localHTMLDocument.addH(1, (IContent)localObject4, null);
        localObject1 = localHTMLWriter;
        localObject3 = new HTMLTable("100%", null, null, "0");
        localObject1 = localHTMLWriter;
        localObject4 = ((HTMLTable)localObject3).newTitleRow();
        localObject1 = localHTMLWriter;
        Object localObject5 = ((HTMLTable)localObject3).newRow();
        i = 0;
        localObject1 = localHTMLWriter;
        Object localObject6;
        if (i < arrayOfInt.length)
        {
          j = arrayOfInt[i];
          localObject1 = localHTMLWriter;
          localObject6 = paramPackageItem.getAttribute(j, this.m_settings.getUnitsType());
          localObject1 = localHTMLWriter;
          ((HTMLTable.IRow)localObject4).newCell().setText(((IItemAttribute)localObject6).getName(), true);
          if (localObject6 != null)
          {
            localObject1 = localHTMLWriter;
            if (this.m_metrics[j] <= 0) {
              break label876;
            }
            localObject1 = localHTMLWriter;
            if (((IItemAttribute)localObject6).passes(paramPackageItem, this.m_metrics[j])) {
              break label876;
            }
            j = 1;
            localObject1 = localHTMLWriter;
            ((StringBuffer)localObject2).setLength(0);
            localObject1 = localHTMLWriter;
            ((IItemAttribute)localObject6).format(paramPackageItem, (StringBuffer)localObject2);
            localObject1 = localHTMLWriter;
            localObject6 = ((HTMLTable.IRow)localObject5).newCell();
            localObject1 = localHTMLWriter;
            ((HTMLTable.ICell)localObject6).setText(((StringBuffer)localObject2).toString(), true);
            if (j != 0)
            {
              localObject1 = localHTMLWriter;
              ((HTMLTable.ICell)localObject6).setClass("h");
            }
          }
        }
        else
        {
          localObject1 = localHTMLWriter;
          localHTMLDocument.add((IContent)localObject3);
          localObject1 = localHTMLWriter;
          if (this.m_settings.getDepth() <= paramPackageItem.getMetadata().getTypeID()) {
            break label897;
          }
          i = 1;
          localObject1 = localHTMLWriter;
          if (!this.m_srcView) {
            break label902;
          }
          localObject2 = "COVERAGE BREAKDOWN BY SOURCE FILE";
          label591:
          localObject1 = localHTMLWriter;
          localHTMLDocument.addH(2, (String)localObject2, null);
          localObject1 = localHTMLWriter;
          localObject4 = new HTMLTable("100%", null, null, "0");
          localObject3 = null;
          bool = true;
          localObject1 = localHTMLWriter;
          localObject2 = this.m_typeSortComparators;
          localObject1 = localHTMLWriter;
          if (this.m_srcView)
          {
            localObject1 = localHTMLWriter;
            j = SrcFileItem.getTypeMetadata().getTypeID();
            localObject1 = localHTMLWriter;
            localObject5 = paramPackageItem.getChildren(localObject2[j]);
            label681:
            localObject1 = localHTMLWriter;
            if (((Iterator)localObject5).hasNext())
            {
              localObject1 = localHTMLWriter;
              localObject6 = (IItem)((Iterator)localObject5).next();
              localObject2 = localObject3;
              if (localObject3 == null)
              {
                localObject1 = localHTMLWriter;
                localObject2 = addHeaderRow((IItem)localObject6, (HTMLTable)localObject4, arrayOfInt);
              }
              localObject3 = null;
              if (i != 0)
              {
                localObject1 = localHTMLWriter;
                localObject3 = getItemHREF(paramPackageItem, (IItem)localObject6);
              }
              localObject1 = localHTMLWriter;
              addItemRow((IItem)localObject6, bool, (HTMLTable)localObject4, (int[])localObject2, (String)localObject3, false);
              if (i == 0) {
                break;
              }
              localObject1 = localHTMLWriter;
              this.m_queue.addLast(localObject6);
              break;
            }
          }
          else
          {
            localObject1 = localHTMLWriter;
            j = ClassItem.getTypeMetadata().getTypeID();
            continue;
          }
          localObject1 = localHTMLWriter;
          localHTMLDocument.add((IContent)localObject4);
          localObject1 = localHTMLWriter;
          localHTMLDocument.emit(localHTMLWriter);
          localObject1 = localHTMLWriter;
          localHTMLWriter.flush();
          if (localHTMLWriter != null) {
            localHTMLWriter.close();
          }
          return paramObject;
        }
      }
      finally
      {
        if (localObject1 != null) {
          ((HTMLWriter)localObject1).close();
        }
      }
      i += 1;
      continue;
      label876:
      int j = 0;
    }
    if (!bool) {}
    for (boolean bool = true;; bool = false)
    {
      localObject3 = localObject2;
      break label681;
      label897:
      i = 0;
      break;
      label902:
      localObject2 = "COVERAGE BREAKDOWN BY CLASS";
      break label591;
    }
  }
  
  public Object visit(SrcFileItem paramSrcFileItem, Object paramObject)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    for (;;)
    {
      Object localObject3;
      Object localObject4;
      int i;
      label546:
      boolean bool2;
      label565:
      label583:
      label615:
      boolean bool1;
      try
      {
        localObject3 = getItemFile(NESTED_ITEMS_PARENT_DIR, this.m_reportIDNamespace.getID(getItemKey(paramSrcFileItem)));
        localObject1 = localObject2;
        HTMLWriter localHTMLWriter = openOutFile(Files.newFile(this.m_settings.getOutDir(), (File)localObject3), this.m_settings.getOutEncoding(), true);
        localObject1 = localHTMLWriter;
        int[] arrayOfInt = this.m_settings.getColumnOrder();
        localObject1 = localHTMLWriter;
        localObject2 = new StringBuffer();
        localObject1 = localHTMLWriter;
        HTMLDocument localHTMLDocument = createPage("EMMA Coverage Report");
        localObject1 = localHTMLWriter;
        localObject3 = getParentPath(paramSrcFileItem);
        localObject1 = localHTMLWriter;
        addPageHeader(localHTMLDocument, paramSrcFileItem, (IItem[])localObject3);
        localObject1 = localHTMLWriter;
        addPageFooter(localHTMLDocument, paramSrcFileItem, (IItem[])localObject3);
        localObject1 = localHTMLWriter;
        localObject3 = IElement.Factory.create(Tag.SPAN);
        localObject1 = localHTMLWriter;
        ((IElement)localObject3).setText(paramSrcFileItem.getName(), true);
        localObject1 = localHTMLWriter;
        ((IElement)localObject3).setClass("in");
        localObject1 = localHTMLWriter;
        localObject4 = new ElementList();
        localObject1 = localHTMLWriter;
        ((IElementList)localObject4).add(new Text("COVERAGE SUMMARY FOR SOURCE FILE [", true));
        localObject1 = localHTMLWriter;
        ((IElementList)localObject4).add((IContent)localObject3);
        localObject1 = localHTMLWriter;
        ((IElementList)localObject4).add(new Text("]", true));
        localObject1 = localHTMLWriter;
        localHTMLDocument.addH(1, (IContent)localObject4, null);
        localObject1 = localHTMLWriter;
        localObject3 = new HTMLTable("100%", null, null, "0");
        localObject1 = localHTMLWriter;
        localObject4 = ((HTMLTable)localObject3).newTitleRow();
        localObject1 = localHTMLWriter;
        localObject5 = ((HTMLTable)localObject3).newRow();
        i = 0;
        localObject1 = localHTMLWriter;
        Object localObject6;
        if (i < arrayOfInt.length)
        {
          j = arrayOfInt[i];
          localObject1 = localHTMLWriter;
          localObject6 = paramSrcFileItem.getAttribute(j, this.m_settings.getUnitsType());
          localObject1 = localHTMLWriter;
          ((HTMLTable.IRow)localObject4).newCell().setText(((IItemAttribute)localObject6).getName(), true);
          if (localObject6 != null)
          {
            localObject1 = localHTMLWriter;
            if (this.m_metrics[j] <= 0) {
              break label1026;
            }
            localObject1 = localHTMLWriter;
            if (((IItemAttribute)localObject6).passes(paramSrcFileItem, this.m_metrics[j])) {
              break label1026;
            }
            j = 1;
            localObject1 = localHTMLWriter;
            ((StringBuffer)localObject2).setLength(0);
            localObject1 = localHTMLWriter;
            ((IItemAttribute)localObject6).format(paramSrcFileItem, (StringBuffer)localObject2);
            localObject1 = localHTMLWriter;
            localObject6 = ((HTMLTable.IRow)localObject5).newCell();
            localObject1 = localHTMLWriter;
            ((HTMLTable.ICell)localObject6).setText(((StringBuffer)localObject2).toString(), true);
            if (j != 0)
            {
              localObject1 = localHTMLWriter;
              ((HTMLTable.ICell)localObject6).setClass("h");
            }
          }
        }
        else
        {
          localObject1 = localHTMLWriter;
          localHTMLDocument.add((IContent)localObject3);
          localObject1 = localHTMLWriter;
          if (this.m_settings.getDepth() <= ClassItem.getTypeMetadata().getTypeID()) {
            break label1035;
          }
          i = 1;
          if (i == 0) {
            break label1040;
          }
          localObject1 = localHTMLWriter;
          if (!srcFileAvailable(paramSrcFileItem, this.m_cache)) {
            break label1040;
          }
          j = 1;
          if (j == 0) {
            break label1046;
          }
          localObject1 = localHTMLWriter;
          if (!this.m_hasLineNumberInfo) {
            break label1046;
          }
          bool2 = true;
          if (!bool2) {
            break label1052;
          }
          localObject1 = localHTMLWriter;
          localObject2 = new IDGenerator();
          localObject1 = localHTMLWriter;
          localHTMLDocument.addH(2, "COVERAGE BREAKDOWN BY CLASS AND METHOD", null);
          if (j == 0) {
            break label1058;
          }
          localObject1 = localHTMLWriter;
          localObject3 = new IntObjectMap();
          localObject1 = localHTMLWriter;
          localObject6 = new HTMLTable("100%", null, null, "0");
          localObject1 = localHTMLWriter;
          ((HTMLTable)localObject6).setClass("cn");
          localObject5 = null;
          localObject1 = localHTMLWriter;
          localObject4 = this.m_typeSortComparators[ClassItem.getTypeMetadata().getTypeID()];
          j = 0;
          localObject1 = localHTMLWriter;
          Iterator localIterator = paramSrcFileItem.getChildren((ItemComparator)localObject4);
          localObject1 = localHTMLWriter;
          if (localIterator.hasNext())
          {
            localObject1 = localHTMLWriter;
            Object localObject7 = (ClassItem)localIterator.next();
            localObject4 = localObject5;
            if (localObject5 == null)
            {
              localObject1 = localHTMLWriter;
              localObject4 = addHeaderRow((IItem)localObject7, (HTMLTable)localObject6, arrayOfInt);
            }
            localObject5 = null;
            if (bool2)
            {
              localObject1 = localHTMLWriter;
              localObject5 = getItemKey((IItem)localObject7);
              localObject1 = localHTMLWriter;
              localObject5 = addLineAnchorID(((ClassItem)localObject7).getFirstLine(), ((IDGenerator)localObject2).getID((String)localObject5), (IntObjectMap)localObject3);
            }
            localObject1 = localHTMLWriter;
            addClassRow((ClassItem)localObject7, j, (HTMLTable)localObject6, (int[])localObject4, (String)localObject5, bool2);
            bool1 = false;
            localObject1 = localHTMLWriter;
            localObject7 = ((ClassItem)localObject7).getChildren(this.m_typeSortComparators[MethodItem.getTypeMetadata().getTypeID()]);
            label829:
            localObject1 = localHTMLWriter;
            if (!((Iterator)localObject7).hasNext()) {
              break label1070;
            }
            localObject1 = localHTMLWriter;
            MethodItem localMethodItem = (MethodItem)((Iterator)localObject7).next();
            localObject5 = null;
            if (bool2)
            {
              localObject1 = localHTMLWriter;
              localObject5 = getItemKey(localMethodItem);
              localObject1 = localHTMLWriter;
              localObject5 = addLineAnchorID(localMethodItem.getFirstLine(), ((IDGenerator)localObject2).getID((String)localObject5), (IntObjectMap)localObject3);
            }
            localObject1 = localHTMLWriter;
            addClassItemRow(localMethodItem, bool1, (HTMLTable)localObject6, (int[])localObject4, (String)localObject5, bool2);
            if (bool1) {
              break label1064;
            }
            bool1 = true;
            break label1032;
          }
          localObject1 = localHTMLWriter;
          localHTMLDocument.add((IContent)localObject6);
          if (i != 0)
          {
            localObject1 = localHTMLWriter;
            localHTMLDocument.addEmptyP();
            localObject1 = localHTMLWriter;
            embedSrcFile(paramSrcFileItem, localHTMLDocument, (IntObjectMap)localObject3, this.m_cache);
          }
          localObject1 = localHTMLWriter;
          localHTMLDocument.emit(localHTMLWriter);
          localObject1 = localHTMLWriter;
          localHTMLWriter.flush();
          if (localHTMLWriter != null) {
            localHTMLWriter.close();
          }
          return paramObject;
        }
      }
      finally
      {
        if (localObject1 != null) {
          ((HTMLWriter)localObject1).close();
        }
      }
      i += 1;
      continue;
      label1026:
      int j = 0;
      continue;
      for (;;)
      {
        label1032:
        break label829;
        label1035:
        i = 0;
        break;
        label1040:
        j = 0;
        break label546;
        label1046:
        bool2 = false;
        break label565;
        label1052:
        localObject2 = null;
        break label583;
        label1058:
        localObject3 = null;
        break label615;
        label1064:
        bool1 = false;
      }
      label1070:
      j += 1;
      Object localObject5 = localObject4;
    }
  }
  
  private static final class IDGenerator
  {
    private final ObjectIntMap m_namespace;
    private final int[] m_out;
    
    IDGenerator()
    {
      this.m_namespace = new ObjectIntMap(101);
      this.m_out = new int[1];
    }
    
    IDGenerator(int paramInt)
    {
      this.m_namespace = new ObjectIntMap(paramInt);
      this.m_out = new int[1];
    }
    
    String getID(String paramString)
    {
      int[] arrayOfInt = this.m_out;
      int i;
      if (this.m_namespace.get(paramString, arrayOfInt)) {
        i = arrayOfInt[0];
      }
      for (;;)
      {
        return Integer.toHexString(i);
        i = this.m_namespace.size();
        this.m_namespace.put(paramString, i);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/report/html/ReportGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */