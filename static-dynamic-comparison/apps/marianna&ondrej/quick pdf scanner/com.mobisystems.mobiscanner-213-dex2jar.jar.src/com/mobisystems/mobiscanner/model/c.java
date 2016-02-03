package com.mobisystems.mobiscanner.model;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Matrix;
import android.os.Bundle;
import com.mobisystems.mobiscanner.common.CommonPreferences.OCRLanguage;
import com.mobisystems.mobiscanner.common.CommonPreferences.PDFImageDensity;
import com.mobisystems.mobiscanner.common.CommonPreferences.PDFImageQuality;
import com.mobisystems.mobiscanner.common.CommonPreferences.PageOrientation;
import com.mobisystems.mobiscanner.common.CommonPreferences.PageSize;
import com.mobisystems.mobiscanner.image.ImageOrientation;
import java.util.Arrays;

public class c
{
  private int aDX;
  private Matrix aGo;
  private int aGq;
  private long aIS;
  private long aIT;
  private double aJA;
  private double aJB;
  private float aJC;
  private String aJD;
  private String aJE;
  private String aJF;
  private CommonPreferences.OCRLanguage aJG;
  private CommonPreferences.OCRLanguage aJH;
  private int aJI;
  private long aJJ;
  private int aJK;
  private float aJL;
  private CommonPreferences.PDFImageQuality aJc;
  private CommonPreferences.PDFImageDensity aJd;
  private long aJk;
  private CommonPreferences.PageSize aJl;
  private CommonPreferences.PageOrientation aJm;
  private float aJn;
  private float aJo;
  private float aJp;
  private float aJq;
  private ImageOrientation aJr;
  private long aJs;
  private boolean aJt;
  private float aJu;
  private float aJv;
  private float aJw;
  private String aJx;
  private int aJy;
  private double aJz;
  private b axZ;
  private float mHeight;
  private float mWidth;
  
  public c()
  {
    this.axZ = new b();
    this.aIS = -1L;
    this.aJk = -1L;
    this.aDX = 0;
    this.aIT = 0L;
    this.aJl = CommonPreferences.PageSize.auh;
    this.mWidth = 0.0F;
    this.mHeight = 0.0F;
    this.aJm = CommonPreferences.PageOrientation.aud;
    this.aJn = 0.0F;
    this.aJo = 0.0F;
    this.aJp = 0.0F;
    this.aJq = 0.0F;
    this.aJc = CommonPreferences.PDFImageQuality.atW;
    this.aJd = CommonPreferences.PDFImageDensity.atO;
    this.aJr = ImageOrientation.aHV;
    this.aJs = -1L;
    this.aGq = 0;
    this.aGo = new Matrix();
    this.aJt = false;
    this.aJu = 0.0F;
    this.aJv = 0.0F;
    this.aJw = 0.0F;
    this.aJy = 0;
    this.aJz = 0.0D;
    this.aJA = 0.0D;
    this.aJB = 0.0D;
    this.aJC = 0.0F;
    this.aJx = "";
    this.aJD = "";
    this.aJE = "";
    this.aJF = "";
    this.aJG = CommonPreferences.OCRLanguage.aqh;
    this.aJH = CommonPreferences.OCRLanguage.aqh;
    this.aJI = -1;
    this.aJJ = -1L;
    this.aJK = 0;
    this.aJL = 0.0F;
  }
  
  public c(Intent paramIntent)
  {
    this.axZ = new b(paramIntent);
    this.aIS = paramIntent.getLongExtra("page_id", -1L);
    this.aJk = paramIntent.getLongExtra("page_raw_image_id", -1L);
    this.aDX = paramIntent.getIntExtra("page_idx_within_doc", 0);
    this.aIT = paramIntent.getLongExtra("page_last_modification_time", 0L);
    this.aJl = CommonPreferences.PageSize.fZ(paramIntent.getIntExtra("page_size", CommonPreferences.PageSize.auh.Dp()));
    this.mWidth = paramIntent.getFloatExtra("page_width", 0.0F);
    this.mHeight = paramIntent.getFloatExtra("page_height", 0.0F);
    this.aJm = CommonPreferences.PageOrientation.fX(paramIntent.getIntExtra("page_orientation", CommonPreferences.PageOrientation.aud.Dp()));
    this.aJn = paramIntent.getFloatExtra("page_left_margin", 0.0F);
    this.aJo = paramIntent.getFloatExtra("page_right_margin", 0.0F);
    this.aJp = paramIntent.getFloatExtra("page_top_margin", 0.0F);
    this.aJq = paramIntent.getFloatExtra("page_bottom_margin", 0.0F);
    this.aJc = CommonPreferences.PDFImageQuality.fV(paramIntent.getIntExtra("page_image_quality", CommonPreferences.PDFImageQuality.atW.Dp()));
    this.aJd = CommonPreferences.PDFImageDensity.fT(paramIntent.getIntExtra("page_image_density", CommonPreferences.PDFImageDensity.atO.Dp()));
    this.aJr = ImageOrientation.gt(paramIntent.getIntExtra("page_proc_image_orientation", ImageOrientation.aHV.Dp()));
    this.aJs = paramIntent.getLongExtra("page_proc_image_id", -1L);
    this.aGq = paramIntent.getIntExtra("page_image_version", 0);
    this.aGo = new Matrix();
    float[] arrayOfFloat = paramIntent.getFloatArrayExtra("page_crop_matrix");
    if (arrayOfFloat != null) {
      this.aGo.setValues(arrayOfFloat);
    }
    this.aJt = paramIntent.getBooleanExtra("page_has_orientation_data", false);
    this.aJu = paramIntent.getFloatExtra("page_orientation_data_x", 0.0F);
    this.aJv = paramIntent.getFloatExtra("page_orientation_data_y", 0.0F);
    this.aJw = paramIntent.getFloatExtra("page_orientation_data_z", 0.0F);
    this.aJy = paramIntent.getIntExtra("page_has_location_data", 0);
    this.aJz = paramIntent.getDoubleExtra("page_location_data_long", 0.0D);
    this.aJA = paramIntent.getDoubleExtra("page_location_data_lat", 0.0D);
    this.aJB = paramIntent.getDoubleExtra("page_location_data_alt", 0.0D);
    this.aJC = paramIntent.getFloatExtra("page_location_data_accuracy", 0.0F);
    this.aJx = paramIntent.getStringExtra("page_original_image_name");
    if (this.aJx == null) {
      this.aJx = "";
    }
    this.aJD = paramIntent.getStringExtra("page_location_data)address");
    if (this.aJD == null) {
      this.aJD = "";
    }
    this.aJE = paramIntent.getStringExtra("page_recognized_content");
    if (this.aJE == null) {
      this.aJE = "";
    }
    this.aJF = paramIntent.getStringExtra("page_recognized_content_second");
    if (this.aJF == null) {
      this.aJF = "";
    }
    this.aJG = CommonPreferences.OCRLanguage.fR(paramIntent.getIntExtra("page_recognized_content_lang", CommonPreferences.OCRLanguage.aqh.Dp()));
    this.aJH = CommonPreferences.OCRLanguage.fR(paramIntent.getIntExtra("page_recognized_content_second_lang", CommonPreferences.OCRLanguage.aqh.Dp()));
    this.aJI = paramIntent.getIntExtra("page_has_recognized_content", -1);
    this.aJJ = paramIntent.getLongExtra("page_cropped_image_id", -1L);
    this.aJK = paramIntent.getIntExtra("page_has_crop_data", 0);
    this.aJL = paramIntent.getFloatExtra("page_crop_data_ratio", 0.0F);
  }
  
  public c(Bundle paramBundle)
  {
    this.axZ = new b(paramBundle);
    this.aIS = paramBundle.getLong("page_id", -1L);
    this.aJk = paramBundle.getLong("page_raw_image_id", -1L);
    this.aDX = paramBundle.getInt("page_idx_within_doc", 0);
    this.aIT = paramBundle.getLong("page_last_modification_time", 0L);
    this.aJl = CommonPreferences.PageSize.fZ(paramBundle.getInt("page_size", CommonPreferences.PageSize.auh.Dp()));
    this.mWidth = paramBundle.getFloat("page_width", 0.0F);
    this.mHeight = paramBundle.getFloat("page_height", 0.0F);
    this.aJm = CommonPreferences.PageOrientation.fX(paramBundle.getInt("page_orientation", CommonPreferences.PageOrientation.aud.Dp()));
    this.aJn = paramBundle.getFloat("page_left_margin", 0.0F);
    this.aJo = paramBundle.getFloat("page_right_margin", 0.0F);
    this.aJp = paramBundle.getFloat("page_top_margin", 0.0F);
    this.aJq = paramBundle.getFloat("page_bottom_margin", 0.0F);
    this.aJc = CommonPreferences.PDFImageQuality.fV(paramBundle.getInt("page_image_quality", CommonPreferences.PDFImageQuality.atW.Dp()));
    this.aJd = CommonPreferences.PDFImageDensity.fT(paramBundle.getInt("page_image_density", CommonPreferences.PDFImageDensity.atO.Dp()));
    this.aJr = ImageOrientation.gt(paramBundle.getInt("page_proc_image_orientation", ImageOrientation.aHV.Dp()));
    this.aJs = paramBundle.getLong("page_proc_image_id", -1L);
    this.aGq = paramBundle.getInt("page_image_version", 0);
    this.aGo = new Matrix();
    float[] arrayOfFloat = paramBundle.getFloatArray("page_crop_matrix");
    if (arrayOfFloat != null) {
      this.aGo.setValues(arrayOfFloat);
    }
    this.aJt = paramBundle.getBoolean("page_has_orientation_data", false);
    this.aJu = paramBundle.getFloat("page_orientation_data_x", 0.0F);
    this.aJv = paramBundle.getFloat("page_orientation_data_y", 0.0F);
    this.aJw = paramBundle.getFloat("page_orientation_data_z", 0.0F);
    this.aJy = paramBundle.getInt("page_has_location_data", 0);
    this.aJz = paramBundle.getDouble("page_location_data_long", 0.0D);
    this.aJA = paramBundle.getDouble("page_location_data_lat", 0.0D);
    this.aJB = paramBundle.getDouble("page_location_data_alt", 0.0D);
    this.aJC = paramBundle.getFloat("page_location_data_accuracy", 0.0F);
    this.aJx = paramBundle.getString("page_original_image_name", "");
    this.aJD = paramBundle.getString("page_location_data)address", "");
    this.aJE = paramBundle.getString("page_recognized_content", "");
    this.aJF = paramBundle.getString("page_recognized_content_second", "");
    this.aJG = CommonPreferences.OCRLanguage.fR(paramBundle.getInt("page_recognized_content_lang", CommonPreferences.OCRLanguage.aqh.Dp()));
    this.aJH = CommonPreferences.OCRLanguage.fR(paramBundle.getInt("page_recognized_content_second_lang", CommonPreferences.OCRLanguage.aqh.Dp()));
    this.aJI = paramBundle.getInt("page_has_recognized_content", -1);
    this.aJJ = paramBundle.getLong("page_cropped_image_id", -1L);
    this.aJK = paramBundle.getInt("page_has_crop_data", 0);
    this.aJL = paramBundle.getFloat("page_crop_data_ratio", 0.0F);
  }
  
  public c(b paramb, Cursor paramCursor)
  {
    this.axZ = new b(paramb);
    this.aIS = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
    this.aJk = paramCursor.getLong(paramCursor.getColumnIndex("page_raw_image_id"));
    this.aDX = paramCursor.getInt(paramCursor.getColumnIndex("page_idx_within_doc"));
    this.aIT = paramCursor.getLong(paramCursor.getColumnIndex("page_last_modification_time"));
    this.aJl = CommonPreferences.PageSize.fZ(paramCursor.getInt(paramCursor.getColumnIndex("page_size")));
    this.mWidth = paramCursor.getFloat(paramCursor.getColumnIndex("page_width"));
    this.mHeight = paramCursor.getFloat(paramCursor.getColumnIndex("page_height"));
    this.aJm = CommonPreferences.PageOrientation.fX(paramCursor.getInt(paramCursor.getColumnIndex("page_orientation")));
    this.aJn = paramCursor.getFloat(paramCursor.getColumnIndex("page_left_margin"));
    this.aJo = paramCursor.getFloat(paramCursor.getColumnIndex("page_right_margin"));
    this.aJp = paramCursor.getFloat(paramCursor.getColumnIndex("page_top_margin"));
    this.aJq = paramCursor.getFloat(paramCursor.getColumnIndex("page_bottom_margin"));
    this.aJc = CommonPreferences.PDFImageQuality.fV(paramCursor.getInt(paramCursor.getColumnIndex("page_image_quality")));
    this.aJd = CommonPreferences.PDFImageDensity.fT(paramCursor.getInt(paramCursor.getColumnIndex("page_image_density")));
    this.aJr = ImageOrientation.gt(paramCursor.getInt(paramCursor.getColumnIndex("page_proc_image_orientation")));
    this.aJs = paramCursor.getLong(paramCursor.getColumnIndex("page_proc_image_id"));
    this.aGq = paramCursor.getInt(paramCursor.getColumnIndex("page_image_version"));
    this.aGo = new Matrix();
    paramb = paramCursor.getString(paramCursor.getColumnIndex("page_crop_matrix"));
    if ((paramb != null) && (!paramb.equals("")))
    {
      paramb = paramb.substring(1, paramb.length() - 1).split(",");
      if (9 == paramb.length)
      {
        float[] arrayOfFloat = new float[9];
        int i = 0;
        while (i < 9)
        {
          arrayOfFloat[i] = Float.parseFloat(paramb[i]);
          i += 1;
        }
        this.aGo.setValues(arrayOfFloat);
      }
    }
    if (paramCursor.getInt(paramCursor.getColumnIndex("page_has_orientation_data")) != 0) {}
    for (;;)
    {
      this.aJt = bool;
      this.aJu = paramCursor.getFloat(paramCursor.getColumnIndex("page_orientation_data_x"));
      this.aJv = paramCursor.getFloat(paramCursor.getColumnIndex("page_orientation_data_y"));
      this.aJw = paramCursor.getFloat(paramCursor.getColumnIndex("page_orientation_data_z"));
      this.aJy = paramCursor.getInt(paramCursor.getColumnIndex("page_has_location_data"));
      this.aJz = paramCursor.getDouble(paramCursor.getColumnIndex("page_location_data_long"));
      this.aJA = paramCursor.getDouble(paramCursor.getColumnIndex("page_location_data_lat"));
      this.aJB = paramCursor.getDouble(paramCursor.getColumnIndex("page_location_data_alt"));
      this.aJC = paramCursor.getFloat(paramCursor.getColumnIndex("page_location_data_accuracy"));
      this.aJx = paramCursor.getString(paramCursor.getColumnIndex("page_original_image_name"));
      if (this.aJx == null) {
        this.aJx = "";
      }
      this.aJD = paramCursor.getString(paramCursor.getColumnIndex("page_location_data_address"));
      if (this.aJD == null) {
        this.aJD = "";
      }
      this.aJE = paramCursor.getString(paramCursor.getColumnIndex("page_recognized_content"));
      if (this.aJE == null) {
        this.aJE = "";
      }
      this.aJF = paramCursor.getString(paramCursor.getColumnIndex("page_recognized_content_second"));
      if (this.aJF == null) {
        this.aJF = "";
      }
      this.aJG = CommonPreferences.OCRLanguage.fR(paramCursor.getInt(paramCursor.getColumnIndex("page_recognized_content_lang")));
      this.aJH = CommonPreferences.OCRLanguage.fR(paramCursor.getInt(paramCursor.getColumnIndex("page_recognized_content_second_lang")));
      this.aJI = paramCursor.getInt(paramCursor.getColumnIndex("page_has_recognized_content"));
      this.aJJ = paramCursor.getLong(paramCursor.getColumnIndex("page_cropped_image_id"));
      this.aJK = paramCursor.getInt(paramCursor.getColumnIndex("page_has_crop_data"));
      this.aJL = paramCursor.getFloat(paramCursor.getColumnIndex("page_crop_data_ratio"));
      return;
      bool = false;
    }
  }
  
  public c(c paramc)
  {
    this.axZ = new b(paramc.IS());
    this.aIS = paramc.getId();
    this.aJk = paramc.IT();
    this.aDX = paramc.IU();
    this.aIT = paramc.IA();
    this.aJl = paramc.IV();
    this.mWidth = paramc.getWidth();
    this.mHeight = paramc.getHeight();
    this.aJm = paramc.IW();
    this.aJn = paramc.IX();
    this.aJo = paramc.IY();
    this.aJp = paramc.IZ();
    this.aJq = paramc.Ja();
    this.aJc = paramc.IJ();
    this.aJd = paramc.IK();
    this.aJr = paramc.Jb();
    this.aJs = paramc.Jc();
    this.aGq = paramc.Jd();
    this.aGo = paramc.Je();
    this.aJt = paramc.Jg();
    this.aJu = paramc.Jh();
    this.aJv = paramc.Ji();
    this.aJw = paramc.Jj();
    this.aJy = paramc.Jk();
    this.aJz = paramc.Jl();
    this.aJA = paramc.Jm();
    this.aJB = paramc.Jn();
    this.aJC = paramc.Jo();
    this.aJx = paramc.Jp();
    this.aJD = paramc.Jq();
    this.aJE = paramc.Jr();
    this.aJF = paramc.Js();
    this.aJG = paramc.Jt();
    this.aJH = paramc.Ju();
    this.aJI = paramc.Jv();
    this.aJJ = paramc.Jw();
    this.aJK = paramc.Jx();
    this.aJL = paramc.Jy();
  }
  
  public long IA()
  {
    return this.aIT;
  }
  
  public CommonPreferences.PDFImageQuality IJ()
  {
    return this.aJc;
  }
  
  public CommonPreferences.PDFImageDensity IK()
  {
    return this.aJd;
  }
  
  public b IS()
  {
    return this.axZ;
  }
  
  public long IT()
  {
    return this.aJk;
  }
  
  public int IU()
  {
    return this.aDX;
  }
  
  public CommonPreferences.PageSize IV()
  {
    return this.aJl;
  }
  
  public CommonPreferences.PageOrientation IW()
  {
    return this.aJm;
  }
  
  public float IX()
  {
    return this.aJn;
  }
  
  public float IY()
  {
    return this.aJo;
  }
  
  public float IZ()
  {
    return this.aJp;
  }
  
  public float Ja()
  {
    return this.aJq;
  }
  
  public ImageOrientation Jb()
  {
    return this.aJr;
  }
  
  public long Jc()
  {
    return this.aJs;
  }
  
  public int Jd()
  {
    return this.aGq;
  }
  
  public Matrix Je()
  {
    return this.aGo;
  }
  
  public String Jf()
  {
    float[] arrayOfFloat = new float[9];
    this.aGo.getValues(arrayOfFloat);
    return Arrays.toString(arrayOfFloat);
  }
  
  public boolean Jg()
  {
    return this.aJt;
  }
  
  public float Jh()
  {
    return this.aJu;
  }
  
  public float Ji()
  {
    return this.aJv;
  }
  
  public float Jj()
  {
    return this.aJw;
  }
  
  public int Jk()
  {
    return this.aJy;
  }
  
  public double Jl()
  {
    return this.aJz;
  }
  
  public double Jm()
  {
    return this.aJA;
  }
  
  public double Jn()
  {
    return this.aJB;
  }
  
  public float Jo()
  {
    return this.aJC;
  }
  
  public String Jp()
  {
    return this.aJx;
  }
  
  public String Jq()
  {
    return this.aJD;
  }
  
  public String Jr()
  {
    return this.aJE;
  }
  
  public String Js()
  {
    return this.aJF;
  }
  
  public CommonPreferences.OCRLanguage Jt()
  {
    return this.aJG;
  }
  
  public CommonPreferences.OCRLanguage Ju()
  {
    return this.aJH;
  }
  
  public int Jv()
  {
    return this.aJI;
  }
  
  public long Jw()
  {
    return this.aJJ;
  }
  
  public int Jx()
  {
    return this.aJK;
  }
  
  public float Jy()
  {
    return this.aJL;
  }
  
  public void K(float paramFloat)
  {
    this.mHeight = paramFloat;
  }
  
  public void L(float paramFloat)
  {
    this.aJn = paramFloat;
  }
  
  public void M(float paramFloat)
  {
    this.aJo = paramFloat;
  }
  
  public void N(float paramFloat)
  {
    this.aJp = paramFloat;
  }
  
  public void O(float paramFloat)
  {
    this.aJq = paramFloat;
  }
  
  public void P(float paramFloat)
  {
    this.aJu = paramFloat;
  }
  
  public void Q(float paramFloat)
  {
    this.aJv = paramFloat;
  }
  
  public void R(float paramFloat)
  {
    this.aJw = paramFloat;
  }
  
  public void a(CommonPreferences.PDFImageDensity paramPDFImageDensity)
  {
    this.aJd = paramPDFImageDensity;
  }
  
  public void a(CommonPreferences.PDFImageQuality paramPDFImageQuality)
  {
    this.aJc = paramPDFImageQuality;
  }
  
  public void aL(long paramLong)
  {
    this.aJs = paramLong;
  }
  
  public void b(CommonPreferences.PageOrientation paramPageOrientation)
  {
    this.aJm = paramPageOrientation;
  }
  
  public void br(boolean paramBoolean)
  {
    this.aJt = paramBoolean;
  }
  
  public void c(CommonPreferences.OCRLanguage paramOCRLanguage)
  {
    this.aJG = paramOCRLanguage;
  }
  
  public void c(CommonPreferences.PageSize paramPageSize)
  {
    this.aJl = paramPageSize;
  }
  
  public void d(CommonPreferences.OCRLanguage paramOCRLanguage)
  {
    this.aJH = paramOCRLanguage;
  }
  
  public void dR(String paramString)
  {
    this.aJD = paramString;
  }
  
  public void dS(String paramString)
  {
    this.aJE = paramString;
  }
  
  public void dT(String paramString)
  {
    this.aJF = paramString;
  }
  
  public void f(Intent paramIntent)
  {
    this.axZ.f(paramIntent);
    paramIntent.putExtra("page_id", this.aIS);
    paramIntent.putExtra("page_raw_image_id", this.aJk);
    paramIntent.putExtra("page_idx_within_doc", this.aDX);
    paramIntent.putExtra("page_last_modification_time", this.aIT);
    paramIntent.putExtra("page_size", this.aJl.Dp());
    paramIntent.putExtra("page_width", this.mWidth);
    paramIntent.putExtra("page_height", this.mHeight);
    paramIntent.putExtra("page_orientation", this.aJm.Dp());
    paramIntent.putExtra("page_left_margin", this.aJn);
    paramIntent.putExtra("page_right_margin", this.aJo);
    paramIntent.putExtra("page_top_margin", this.aJp);
    paramIntent.putExtra("page_bottom_margin", this.aJq);
    paramIntent.putExtra("page_image_quality", this.aJc.Dp());
    paramIntent.putExtra("page_image_density", this.aJd.Dp());
    paramIntent.putExtra("page_proc_image_orientation", this.aJr.Dp());
    paramIntent.putExtra("page_proc_image_id", this.aJs);
    paramIntent.putExtra("page_image_version", this.aGq);
    float[] arrayOfFloat = new float[9];
    this.aGo.getValues(arrayOfFloat);
    paramIntent.putExtra("page_crop_matrix", arrayOfFloat);
    paramIntent.putExtra("page_has_orientation_data", this.aJt);
    paramIntent.putExtra("page_orientation_data_x", this.aJu);
    paramIntent.putExtra("page_orientation_data_y", this.aJv);
    paramIntent.putExtra("page_orientation_data_z", this.aJw);
    paramIntent.putExtra("page_has_location_data", this.aJy);
    paramIntent.putExtra("page_location_data_long", this.aJz);
    paramIntent.putExtra("page_location_data_lat", this.aJA);
    paramIntent.putExtra("page_location_data_alt", this.aJB);
    paramIntent.putExtra("page_location_data_accuracy", this.aJC);
    paramIntent.putExtra("page_original_image_name", this.aJx);
    paramIntent.putExtra("page_location_data)address", this.aJD);
    paramIntent.putExtra("page_recognized_content", this.aJE);
    paramIntent.putExtra("page_recognized_content_second", this.aJF);
    paramIntent.putExtra("page_recognized_content_lang", this.aJG.Dp());
    paramIntent.putExtra("page_recognized_content_second_lang", this.aJH.Dp());
    paramIntent.putExtra("page_has_recognized_content", this.aJI);
    paramIntent.putExtra("page_cropped_image_id", this.aJJ);
    paramIntent.putExtra("page_has_crop_data", this.aJK);
    paramIntent.putExtra("page_crop_data_ratio", this.aJL);
  }
  
  public void g(b paramb)
  {
    this.axZ = new b(paramb);
  }
  
  public void gA(int paramInt)
  {
    this.aJK = paramInt;
  }
  
  public float getHeight()
  {
    return this.mHeight;
  }
  
  public long getId()
  {
    return this.aIS;
  }
  
  public float getWidth()
  {
    return this.mWidth;
  }
  
  public void gx(int paramInt)
  {
    this.aGq = paramInt;
  }
  
  public void gy(int paramInt)
  {
    this.aJy = paramInt;
  }
  
  public void gz(int paramInt)
  {
    this.aJI = paramInt;
  }
  
  public void n(float paramFloat)
  {
    this.mWidth = paramFloat;
  }
  
  public void p(double paramDouble)
  {
    this.aJz = paramDouble;
  }
  
  public void p(Bundle paramBundle)
  {
    this.axZ.p(paramBundle);
    paramBundle.putLong("page_id", this.aIS);
    paramBundle.putLong("page_raw_image_id", this.aJk);
    paramBundle.putInt("page_idx_within_doc", this.aDX);
    paramBundle.putLong("page_last_modification_time", this.aIT);
    paramBundle.putInt("page_size", this.aJl.Dp());
    paramBundle.putFloat("page_width", this.mWidth);
    paramBundle.putFloat("page_height", this.mHeight);
    paramBundle.putInt("page_orientation", this.aJm.Dp());
    paramBundle.putFloat("page_left_margin", this.aJn);
    paramBundle.putFloat("page_right_margin", this.aJo);
    paramBundle.putFloat("page_top_margin", this.aJp);
    paramBundle.putFloat("page_bottom_margin", this.aJq);
    paramBundle.putInt("page_image_quality", this.aJc.Dp());
    paramBundle.putInt("page_image_density", this.aJd.Dp());
    paramBundle.putInt("page_proc_image_orientation", this.aJr.Dp());
    paramBundle.putLong("page_proc_image_id", this.aJs);
    paramBundle.putInt("page_image_version", this.aGq);
    float[] arrayOfFloat = new float[9];
    this.aGo.getValues(arrayOfFloat);
    paramBundle.putFloatArray("page_crop_matrix", arrayOfFloat);
    paramBundle.putBoolean("page_has_orientation_data", this.aJt);
    paramBundle.putFloat("page_orientation_data_x", this.aJu);
    paramBundle.putFloat("page_orientation_data_y", this.aJv);
    paramBundle.putFloat("page_orientation_data_z", this.aJw);
    paramBundle.putInt("page_has_location_data", this.aJy);
    paramBundle.putDouble("page_location_data_long", this.aJz);
    paramBundle.putDouble("page_location_data_lat", this.aJA);
    paramBundle.putDouble("page_location_data_alt", this.aJB);
    paramBundle.putFloat("page_location_data_accuracy", this.aJC);
    paramBundle.putString("page_original_image_name", this.aJx);
    paramBundle.putString("page_location_data)address", this.aJD);
    paramBundle.putString("page_recognized_content", this.aJE);
    paramBundle.putString("page_recognized_content_second", this.aJF);
    paramBundle.putInt("page_recognized_content_lang", this.aJG.Dp());
    paramBundle.putInt("page_recognized_content_second_lang", this.aJH.Dp());
    paramBundle.putInt("page_has_recognized_content", this.aJI);
    paramBundle.putLong("page_cropped_image_id", this.aJJ);
    paramBundle.putInt("page_has_crop_data", this.aJK);
    paramBundle.putFloat("page_crop_data_ratio", this.aJL);
  }
  
  public void q(double paramDouble)
  {
    this.aJA = paramDouble;
  }
  
  public void r(double paramDouble)
  {
    this.aJB = paramDouble;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/model/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */