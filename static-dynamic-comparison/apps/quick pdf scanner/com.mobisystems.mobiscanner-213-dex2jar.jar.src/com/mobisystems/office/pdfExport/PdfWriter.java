package com.mobisystems.office.pdfExport;

import com.mobisystems.a.a;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.FieldPosition;
import java.util.ArrayList;
import java.util.Locale;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

public class PdfWriter
{
  private static final char[] aMC;
  private a aMD;
  private OutputStream aME;
  private ArrayList<f> aMF = new ArrayList();
  private g aMG = new g();
  private e aMH;
  private StringBuffer aMI = new StringBuffer(32);
  private FieldPosition aMJ = new FieldPosition(0);
  private DecimalFormat aMK = new DecimalFormat("######################################0.######", new DecimalFormatSymbols(Locale.US));
  private ArrayList<b> aML = new ArrayList();
  private int aMM = -1;
  private float aMN;
  private float aMO;
  private float aMP;
  private float aMQ;
  private i aMR = new i();
  private h aMS = new h();
  
  static
  {
    if (!PdfWriter.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      aMC = new char[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
      return;
    }
  }
  
  public PdfWriter(File paramFile)
  {
    paramFile = new a(new BufferedOutputStream(new FileOutputStream(paramFile)));
    this.aMD = paramFile;
    this.aME = paramFile;
  }
  
  private int Kf()
  {
    return this.aMD.position();
  }
  
  private void Kn()
  {
    a("endobj");
    Kg();
  }
  
  private void Kp()
  {
    assert (this.aMH == null);
    this.aMH = new e();
    int i = a(this.aMH);
    Ki();
    b("Length");
    gH(i);
  }
  
  private void Kq()
  {
    Kj();
  }
  
  private void Kr()
  {
    a("stream\n");
    int i = Kf();
    this.aMH.setValue(i);
  }
  
  private void Ks()
  {
    int i = Kf();
    this.aMH.setValue(i - this.aMH.getValue());
    Kg();
    a("endstream");
    Kg();
    this.aMH = null;
  }
  
  private b Kz()
  {
    return (b)this.aML.get(this.aML.size() - 1);
  }
  
  private void Q(int paramInt1, int paramInt2)
  {
    this.aMI.setLength(0);
    if (paramInt1 < 0) {
      writeByte(45);
    }
    while (paramInt1 != 0)
    {
      int i = -(paramInt1 % 10);
      paramInt1 /= 10;
      this.aMI.append((char)(i + 48));
      continue;
      paramInt1 = -paramInt1;
    }
    paramInt1 = this.aMI.length();
    while (paramInt1 < paramInt2)
    {
      writeByte(48);
      paramInt2 -= 1;
    }
    paramInt1 -= 1;
    while (paramInt1 >= 0)
    {
      writeByte(this.aMI.charAt(paramInt1));
      paramInt1 -= 1;
    }
  }
  
  private void U(float paramFloat)
  {
    int i = Float.floatToRawIntBits(paramFloat);
    int j = i >> 23 & 0xFF;
    if ((j == 0) || (j == 255)) {
      writeByte(48);
    }
    long l2;
    long l3;
    long l1;
    label89:
    label115:
    do
    {
      return;
      l2 = 0x7FFFFF & i | 0x800000;
      j -= 150;
      if (j >= 0) {
        break;
      }
      j = -j;
      if (j >= 63)
      {
        writeByte(48);
        return;
      }
      l3 = 1 << j;
      l1 = l3 - 1L & l2;
      l2 >>= j;
      if ((0x80000000 & i) != 0) {
        writeByte(45);
      }
      if (l2 != 0L) {
        break label302;
      }
      writeByte(48);
    } while (l1 == 0L);
    this.aMI.setLength(0);
    do
    {
      l1 *= 10L;
      i = (int)(l1 / l3);
      this.aMI.append((char)(i + 48));
      l1 %= l3;
    } while ((l1 != 0L) && (this.aMI.length() < 6));
    i = this.aMI.length() - 1;
    for (;;)
    {
      if ((i < 0) || (this.aMI.charAt(i) != '0'))
      {
        if (this.aMI.length() <= 0) {
          break;
        }
        writeByte(46);
        i = 0;
        j = this.aMI.length();
        while (i < j)
        {
          writeByte(this.aMI.charAt(i));
          i += 1;
        }
        break;
        if (j > 0)
        {
          if (j >= 40)
          {
            s(paramFloat);
            return;
          }
          l1 = 0L;
          l2 <<= j;
          l3 = 1L;
          break label89;
        }
        l1 = 0L;
        l3 = 1L;
        break label89;
        label302:
        this.aMI.setLength(0);
        long l4;
        do
        {
          i = (int)(l2 % 10L);
          l4 = l2 / 10L;
          this.aMI.append((char)(i + 48));
          l2 = l4;
        } while (l4 != 0L);
        i = this.aMI.length() - 1;
        while (i >= 0)
        {
          writeByte(this.aMI.charAt(i));
          i -= 1;
        }
        break label115;
      }
      this.aMI.deleteCharAt(i);
      i -= 1;
    }
  }
  
  private void a(CharSequence paramCharSequence)
  {
    int j = paramCharSequence.length();
    int i = 0;
    while (i < j)
    {
      int k = Character.codePointAt(paramCharSequence, i);
      i += Character.charCount(k);
      gE(k);
    }
  }
  
  private void gD(int paramInt)
  {
    writeByte(aMC[(paramInt >> 4 & 0xF)]);
    writeByte(aMC[(paramInt & 0xF)]);
  }
  
  private void gE(int paramInt)
  {
    if (paramInt <= 127)
    {
      assert (paramInt >= 0);
      writeByte(paramInt);
      return;
    }
    if (paramInt <= 2047)
    {
      writeByte(paramInt >> 6 | 0xC0);
      writeByte(paramInt & 0x3F | 0x80);
      return;
    }
    if (paramInt <= 65535) {
      writeByte(paramInt >> 12 | 0xE0);
    }
    for (;;)
    {
      writeByte(paramInt >> 6 & 0x3F | 0x80);
      break;
      assert (paramInt <= 1114111);
      writeByte(paramInt >> 18 | 0xF0);
      writeByte(paramInt >> 12 & 0x3F | 0x80);
    }
  }
  
  private void gF(int paramInt)
  {
    Q(paramInt, 1);
  }
  
  private int gG(int paramInt)
  {
    int i = this.aMF.size();
    while (paramInt < i)
    {
      f localf = (f)this.aMF.get(paramInt);
      if (localf.isCanceled()) {
        return localf.getId();
      }
      paramInt += 1;
    }
    return 0;
  }
  
  private void gI(int paramInt)
  {
    if (this.aMH != null) {
      throw new IllegalStateException();
    }
    gF(paramInt);
    a(" 0 obj");
    Kg();
  }
  
  private void s(double paramDouble)
  {
    this.aMI.setLength(0);
    this.aMK.format(paramDouble, this.aMI, this.aMJ);
    a(this.aMI);
  }
  
  private void writeByte(int paramInt)
  {
    try
    {
      this.aME.write(paramInt);
      return;
    }
    catch (IOException localIOException)
    {
      throw new WriteException(localIOException);
    }
  }
  
  public i KA()
  {
    if (this.aMM < 0) {
      throw new IllegalStateException();
    }
    return this.aMR;
  }
  
  public h KB()
  {
    return this.aMS;
  }
  
  public void Kg()
  {
    writeByte(10);
  }
  
  public void Kh()
  {
    a("%PDF-1.7");
    Kg();
    writeByte(37);
    writeByte(206);
    writeByte(204);
    writeByte(212);
    writeByte(195);
    Kg();
    a(this.aMG);
  }
  
  public void Ki()
  {
    writeByte(60);
    writeByte(60);
    Kk();
  }
  
  public void Kj()
  {
    writeByte(62);
    writeByte(62);
    Kk();
  }
  
  public void Kk()
  {
    Kg();
  }
  
  public int Kl()
  {
    f localf = new f();
    this.aMF.add(localf);
    int i = this.aMF.size();
    int j = Kf();
    gI(i);
    localf.a(j, this);
    return i;
  }
  
  public void Km()
  {
    Kn();
  }
  
  public void Ko()
  {
    if (this.aMM < 0) {
      throw new IllegalStateException();
    }
    while (this.aML.size() > 1) {
      Ky();
    }
    this.aML.clear();
    Kw();
    Km();
    int i = Kl();
    this.aMG.gC(i);
    Ki();
    dU("Page");
    b("Parent");
    gH(this.aMG.getId());
    b("Resources");
    Ki();
    this.aMR.i(this);
    Kj();
    b("MediaBox");
    b(0.0F, 0.0F, this.aMN, this.aMO);
    b("Contents");
    gH(this.aMM);
    Kj();
    Km();
    i = 0;
    while (i < this.aMF.size())
    {
      f localf = (f)this.aMF.get(i);
      if ((localf.Ke()) && ((d.class.isInstance(localf)) || (d.a.class.isInstance(localf))))
      {
        int j = Kf();
        gI(i + 1);
        localf.a(j, this);
        Kn();
      }
      i += 1;
    }
    this.aMR.clear();
    this.aMM = -1;
  }
  
  public void Kt()
  {
    Kp();
    b("Filter");
    b("FlateDecode");
  }
  
  public void Ku()
  {
    Kq();
    Kr();
    if (this.aME != this.aMD) {
      throw new IllegalStateException();
    }
    this.aME = new BufferedOutputStream(new a(this));
  }
  
  public void Kv()
  {
    Kt();
    Ku();
  }
  
  public void Kw()
  {
    OutputStream localOutputStream = this.aME;
    this.aME = this.aMD;
    try
    {
      localOutputStream.close();
      return;
    }
    catch (IOException localIOException)
    {
      throw new WriteException(localIOException);
    }
  }
  
  public void Kx()
  {
    c("q");
    this.aML.add(Kz().KC());
  }
  
  public void Ky()
  {
    this.aML.remove(this.aML.size() - 1);
    c("Q");
  }
  
  public OutputStream R(int paramInt1, int paramInt2)
  {
    Kp();
    b("Subtype");
    b("Image");
    b("Width");
    eK(paramInt1);
    b("Height");
    eK(paramInt2);
    b("ColorSpace");
    b("DeviceGray");
    b("BitsPerComponent");
    eK(8);
    b("Filter");
    b("FlateDecode");
    Kq();
    Kr();
    return new BufferedOutputStream(new a(this));
  }
  
  public int a(f paramf)
  {
    this.aMF.add(paramf);
    int i = this.aMF.size();
    paramf.setId(i);
    return i;
  }
  
  public OutputStream a(int paramInt1, int paramInt2, f paramf)
  {
    Kp();
    b("Subtype");
    b("Image");
    b("Width");
    eK(paramInt1);
    b("Height");
    eK(paramInt2);
    b("ColorSpace");
    b("DeviceRGB");
    b("BitsPerComponent");
    eK(8);
    if (paramf != null)
    {
      b("SMask");
      gH(paramf.getId());
    }
    b("Filter");
    b("DCTDecode");
    Kq();
    Kr();
    new FilterOutputStream(this.aMD)
    {
      public void close()
      {
        PdfWriter.h(PdfWriter.this);
      }
    };
  }
  
  public void b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (this.aMM >= 0) {
      throw new IllegalStateException();
    }
    this.aMP = paramFloat1;
    this.aMQ = paramFloat2;
    paramFloat3 = 72.0F / paramFloat3;
    this.aMN = (paramFloat1 * paramFloat3);
    this.aMO = (paramFloat2 * paramFloat3);
    this.aMM = Kl();
    Kv();
    s(paramFloat3);
    eK(0);
    eK(0);
    s(-paramFloat3);
    eK(0);
    s(this.aMO);
    c("cm");
    this.aML.add(new b());
  }
  
  public void b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    beginArray();
    s(paramFloat1);
    s(paramFloat2);
    s(paramFloat3);
    s(paramFloat4);
    endArray();
  }
  
  public void b(CharSequence paramCharSequence)
  {
    writeByte(47);
    int j = paramCharSequence.length();
    int i = 0;
    while (i < j)
    {
      int k = Character.codePointAt(paramCharSequence, i);
      i += Character.charCount(k);
      if (k <= 127)
      {
        assert (k >= 0);
        if ((k >= 33) && (k <= 126) && (k != 35))
        {
          writeByte(k);
        }
        else
        {
          writeByte(35);
          gD(k);
        }
      }
      else if (k <= 2047)
      {
        writeByte(35);
        gD(k >> 6 | 0xC0);
        writeByte(35);
        gD(k & 0x3F | 0x80);
      }
      else
      {
        if (k <= 65535)
        {
          writeByte(35);
          gD(k >> 12 | 0xE0);
        }
        for (;;)
        {
          writeByte(35);
          gD(k >> 6 & 0x3F | 0x80);
          break;
          assert (k <= 1114111);
          writeByte(35);
          gD(k >> 18 | 0xF0);
          writeByte(35);
          gD(k >> 12 & 0x3F | 0x80);
        }
      }
    }
    Kk();
  }
  
  public void beginArray()
  {
    writeByte(91);
    Kk();
  }
  
  public void c(CharSequence paramCharSequence)
  {
    a(paramCharSequence);
    Kk();
  }
  
  public void close()
  {
    try
    {
      this.aMD.close();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  public void dU(String paramString)
  {
    b("Type");
    b(paramString);
  }
  
  public void eK(int paramInt)
  {
    gF(paramInt);
    Kk();
  }
  
  public void endArray()
  {
    writeByte(93);
    Kk();
  }
  
  public void endDocument()
  {
    int j = 0;
    int k = Kl();
    Ki();
    dU("Catalog");
    b("Pages");
    gH(this.aMG.getId());
    Kj();
    Km();
    int i = 0;
    f localf;
    while (i < this.aMF.size())
    {
      localf = (f)this.aMF.get(i);
      if (localf.Ke())
      {
        m = Kf();
        gI(i + 1);
        localf.a(m, this);
        Kn();
      }
      i += 1;
    }
    int m = Kf();
    a("xref");
    Kg();
    int n = this.aMF.size() + 1;
    writeByte(48);
    writeByte(32);
    gF(n);
    Kg();
    Q(gG(0), 10);
    a(" 65535 f\r\n");
    int i1 = this.aMF.size();
    i = j;
    if (i < i1)
    {
      localf = (f)this.aMF.get(i);
      if (localf.isCanceled())
      {
        Q(gG(localf.getId()), 10);
        a(" 00000 f\r\n");
      }
      for (;;)
      {
        i += 1;
        break;
        Q(localf.Kd(), 10);
        a(" 00000 n\r\n");
      }
    }
    a("trailer");
    Kg();
    Ki();
    b("Size");
    eK(n);
    b("Root");
    gH(k);
    Kj();
    a("startxref");
    Kg();
    gF(m);
    Kg();
    a("%%EOF");
  }
  
  public void gH(int paramInt)
  {
    gF(paramInt);
    a(" 0 R");
    Kk();
  }
  
  public void s(float paramFloat)
  {
    U(paramFloat);
    Kk();
  }
  
  public static class WriteException
    extends RuntimeException
  {
    private static final long serialVersionUID = 1L;
    
    public WriteException(IOException paramIOException)
    {
      super();
    }
  }
  
  static class a
    extends DeflaterOutputStream
  {
    PdfWriter aMl;
    
    a(PdfWriter paramPdfWriter)
    {
      super(new Deflater(9, false));
      this.aMl = paramPdfWriter;
    }
    
    public void close()
    {
      try
      {
        finish();
        PdfWriter.h(this.aMl);
        return;
      }
      finally
      {
        this.aMl = null;
        this.def.end();
      }
    }
  }
  
  static class b
    implements Cloneable
  {
    int aMU = 0;
    int aMV = 0;
    int aMW = 0;
    float aMX = 1.0F;
    int aMY = 255;
    int aMZ = 255;
    float aNa = 10.0F;
    
    protected b KC()
    {
      try
      {
        b localb = (b)super.clone();
        return localb;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException) {}
      return null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/office/pdfExport/PdfWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */