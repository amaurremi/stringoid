package com.mobisystems.mobiscanner.model;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import com.mobisystems.mobiscanner.common.CommonPreferences.Keys;
import com.mobisystems.mobiscanner.common.CommonPreferences.OCRLanguage;
import com.mobisystems.mobiscanner.common.CommonPreferences.PDFImageDensity;
import com.mobisystems.mobiscanner.common.CommonPreferences.PDFImageQuality;
import com.mobisystems.mobiscanner.common.CommonPreferences.PageOrientation;
import com.mobisystems.mobiscanner.common.CommonPreferences.PageSize;

public class b
{
  private int aCf;
  private long aIS;
  private long aIT;
  private CommonPreferences.PageSize aIU;
  private float aIV;
  private float aIW;
  private CommonPreferences.PageOrientation aIX;
  private float aIY;
  private float aIZ;
  private float aJa;
  private float aJb;
  private CommonPreferences.PDFImageQuality aJc;
  private CommonPreferences.PDFImageDensity aJd;
  private int aJe;
  private long aJf;
  private long aJg;
  private boolean aJh;
  private CommonPreferences.OCRLanguage aJi;
  private CommonPreferences.OCRLanguage aJj;
  private String mName;
  
  public b()
  {
    this.aIS = -1L;
    this.mName = "";
    this.aIT = 0L;
    this.aIU = CommonPreferences.PageSize.dk(CommonPreferences.Keys.apx.Dl());
    this.aIV = CommonPreferences.Keys.apy.getFloatValue();
    this.aIW = CommonPreferences.Keys.apz.getFloatValue();
    this.aIX = CommonPreferences.PageOrientation.dj(CommonPreferences.Keys.apA.Dl());
    this.aIY = CommonPreferences.Keys.apC.getFloatValue();
    this.aIZ = CommonPreferences.Keys.apD.getFloatValue();
    this.aJa = CommonPreferences.Keys.apE.getFloatValue();
    this.aJb = CommonPreferences.Keys.apF.getFloatValue();
    this.aJc = CommonPreferences.PDFImageQuality.di(CommonPreferences.Keys.apG.Dl());
    this.aJd = CommonPreferences.PDFImageDensity.dh(CommonPreferences.Keys.apH.Dl());
    this.aJe = 0;
    this.aJf = 0L;
    this.aCf = 0;
    this.aJg = -1L;
    this.aJh = false;
    this.aJi = CommonPreferences.OCRLanguage.dg(CommonPreferences.Keys.apW.dd(String.valueOf(CommonPreferences.OCRLanguage.aqW.Dp())));
    this.aJj = CommonPreferences.OCRLanguage.dg(CommonPreferences.Keys.apX.dd(String.valueOf(CommonPreferences.OCRLanguage.asL.Dp())));
  }
  
  public b(Intent paramIntent)
  {
    this.aIS = paramIntent.getLongExtra("doc_id", -1L);
    this.mName = paramIntent.getStringExtra("doc_name");
    if (this.mName == null) {
      this.mName = "";
    }
    this.aIT = paramIntent.getLongExtra("doc_last_modification_time", 0L);
    this.aIU = CommonPreferences.PageSize.fZ(paramIntent.getIntExtra("doc_page_size", CommonPreferences.PageSize.auh.Dp()));
    this.aIV = paramIntent.getFloatExtra("doc_page_width", 0.0F);
    this.aIW = paramIntent.getFloatExtra("doc_page_height", 0.0F);
    this.aIX = CommonPreferences.PageOrientation.fX(paramIntent.getIntExtra("doc_page_orientation", CommonPreferences.PageOrientation.aud.Dp()));
    this.aIY = paramIntent.getFloatExtra("doc_page_left_margin", 0.0F);
    this.aIZ = paramIntent.getFloatExtra("doc_page_right_margin", 0.0F);
    this.aJa = paramIntent.getFloatExtra("doc_page_top_margin", 0.0F);
    this.aJb = paramIntent.getFloatExtra("doc_page_bottom_margin", 0.0F);
    this.aJc = CommonPreferences.PDFImageQuality.fV(paramIntent.getIntExtra("doc_image_quality", CommonPreferences.PDFImageQuality.atW.Dp()));
    this.aJd = CommonPreferences.PDFImageDensity.fT(paramIntent.getIntExtra("doc_image_density", CommonPreferences.PDFImageDensity.atO.Dp()));
    this.aJe = paramIntent.getIntExtra("doc_num_pages", 0);
    this.aJf = paramIntent.getLongExtra("doc_last_access_time", 0L);
    this.aCf = paramIntent.getIntExtra("doc_favorite_rank", 0);
    this.aJg = paramIntent.getLongExtra("doc_title_page_id", -1L);
    this.aJh = paramIntent.getBooleanExtra("doc_accessed_flag", false);
    this.aJi = CommonPreferences.OCRLanguage.fR(paramIntent.getIntExtra("doc_recognized_content_lang", CommonPreferences.OCRLanguage.aqh.Dp()));
    this.aJj = CommonPreferences.OCRLanguage.fR(paramIntent.getIntExtra("doc_recognized_content_second_lang", CommonPreferences.OCRLanguage.aqh.Dp()));
  }
  
  public b(Cursor paramCursor)
  {
    this.aIS = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
    this.mName = paramCursor.getString(paramCursor.getColumnIndex("doc_name"));
    this.aIT = paramCursor.getLong(paramCursor.getColumnIndex("doc_last_modification_time"));
    this.aIU = CommonPreferences.PageSize.fZ(paramCursor.getInt(paramCursor.getColumnIndex("doc_page_size")));
    this.aIV = paramCursor.getFloat(paramCursor.getColumnIndex("doc_page_width"));
    this.aIW = paramCursor.getFloat(paramCursor.getColumnIndex("doc_page_height"));
    this.aIX = CommonPreferences.PageOrientation.fX(paramCursor.getInt(paramCursor.getColumnIndex("doc_page_orientation")));
    this.aIY = paramCursor.getFloat(paramCursor.getColumnIndex("doc_page_left_margin"));
    this.aIZ = paramCursor.getFloat(paramCursor.getColumnIndex("doc_page_right_margin"));
    this.aJa = paramCursor.getFloat(paramCursor.getColumnIndex("doc_page_top_margin"));
    this.aJb = paramCursor.getFloat(paramCursor.getColumnIndex("doc_page_bottom_margin"));
    this.aJc = CommonPreferences.PDFImageQuality.fV(paramCursor.getInt(paramCursor.getColumnIndex("doc_image_quality")));
    this.aJd = CommonPreferences.PDFImageDensity.fT(paramCursor.getInt(paramCursor.getColumnIndex("doc_image_density")));
    this.aJe = paramCursor.getInt(paramCursor.getColumnIndex("doc_num_pages"));
    this.aJf = paramCursor.getLong(paramCursor.getColumnIndex("doc_last_access_time"));
    this.aCf = paramCursor.getInt(paramCursor.getColumnIndex("doc_favorite_rank"));
    this.aJg = paramCursor.getLong(paramCursor.getColumnIndex("doc_title_page_id"));
    if (paramCursor.getInt(paramCursor.getColumnIndex("doc_accessed_flag")) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.aJh = bool;
      this.aJi = CommonPreferences.OCRLanguage.fR(paramCursor.getInt(paramCursor.getColumnIndex("doc_recognized_content_lang")));
      this.aJj = CommonPreferences.OCRLanguage.fR(paramCursor.getInt(paramCursor.getColumnIndex("doc_recognized_content_second_lang")));
      return;
    }
  }
  
  public b(Bundle paramBundle)
  {
    this.aIS = paramBundle.getLong("doc_id", -1L);
    this.mName = paramBundle.getString("doc_name");
    if (this.mName == null) {
      this.mName = "";
    }
    this.aIT = paramBundle.getLong("doc_last_modification_time", 0L);
    this.aIU = CommonPreferences.PageSize.fZ(paramBundle.getInt("doc_page_size", CommonPreferences.PageSize.auh.Dp()));
    this.aIV = paramBundle.getFloat("doc_page_width", 0.0F);
    this.aIW = paramBundle.getFloat("doc_page_height", 0.0F);
    this.aIX = CommonPreferences.PageOrientation.fX(paramBundle.getInt("doc_page_orientation", CommonPreferences.PageOrientation.aud.Dp()));
    this.aIY = paramBundle.getFloat("doc_page_left_margin", 0.0F);
    this.aIZ = paramBundle.getFloat("doc_page_right_margin", 0.0F);
    this.aJa = paramBundle.getFloat("doc_page_top_margin", 0.0F);
    this.aJb = paramBundle.getFloat("doc_page_bottom_margin", 0.0F);
    this.aJc = CommonPreferences.PDFImageQuality.fV(paramBundle.getInt("doc_image_quality", CommonPreferences.PDFImageQuality.atW.Dp()));
    this.aJd = CommonPreferences.PDFImageDensity.fT(paramBundle.getInt("doc_image_density", CommonPreferences.PDFImageDensity.atO.Dp()));
    this.aJe = paramBundle.getInt("doc_num_pages", 0);
    this.aJf = paramBundle.getLong("doc_last_access_time", 0L);
    this.aCf = paramBundle.getInt("doc_favorite_rank", 0);
    this.aJg = paramBundle.getLong("doc_title_page_id", -1L);
    this.aJh = paramBundle.getBoolean("doc_accessed_flag", false);
    this.aJi = CommonPreferences.OCRLanguage.fR(paramBundle.getInt("doc_recognized_content_lang", CommonPreferences.OCRLanguage.aqh.Dp()));
    this.aJj = CommonPreferences.OCRLanguage.fR(paramBundle.getInt("doc_recognized_content_second_lang", CommonPreferences.OCRLanguage.aqh.Dp()));
  }
  
  public b(b paramb)
  {
    this.aIS = paramb.getId();
    this.mName = paramb.getName();
    this.aIT = paramb.IA();
    this.aIU = paramb.IB();
    this.aIV = paramb.IC();
    this.aIW = paramb.ID();
    this.aIX = paramb.IE();
    this.aIY = paramb.IF();
    this.aIZ = paramb.IG();
    this.aJa = paramb.IH();
    this.aJb = paramb.II();
    this.aJc = paramb.IJ();
    this.aJd = paramb.IK();
    this.aJe = paramb.IL();
    this.aJf = paramb.IM();
    this.aCf = paramb.IN();
    this.aJg = paramb.IO();
    this.aJh = paramb.IP();
    this.aJi = paramb.IQ();
    this.aJj = paramb.IR();
  }
  
  public void E(float paramFloat)
  {
    this.aIV = paramFloat;
  }
  
  public void F(float paramFloat)
  {
    this.aIW = paramFloat;
  }
  
  public void G(float paramFloat)
  {
    this.aIY = paramFloat;
  }
  
  public void H(float paramFloat)
  {
    this.aIZ = paramFloat;
  }
  
  public void I(float paramFloat)
  {
    this.aJa = paramFloat;
  }
  
  public long IA()
  {
    return this.aIT;
  }
  
  public CommonPreferences.PageSize IB()
  {
    return this.aIU;
  }
  
  public float IC()
  {
    return this.aIV;
  }
  
  public float ID()
  {
    return this.aIW;
  }
  
  public CommonPreferences.PageOrientation IE()
  {
    return this.aIX;
  }
  
  public float IF()
  {
    return this.aIY;
  }
  
  public float IG()
  {
    return this.aIZ;
  }
  
  public float IH()
  {
    return this.aJa;
  }
  
  public float II()
  {
    return this.aJb;
  }
  
  public CommonPreferences.PDFImageQuality IJ()
  {
    return this.aJc;
  }
  
  public CommonPreferences.PDFImageDensity IK()
  {
    return this.aJd;
  }
  
  public int IL()
  {
    return this.aJe;
  }
  
  public long IM()
  {
    return this.aJf;
  }
  
  public int IN()
  {
    return this.aCf;
  }
  
  public long IO()
  {
    return this.aJg;
  }
  
  public boolean IP()
  {
    return this.aJh;
  }
  
  public CommonPreferences.OCRLanguage IQ()
  {
    return this.aJi;
  }
  
  public CommonPreferences.OCRLanguage IR()
  {
    return this.aJj;
  }
  
  public void J(float paramFloat)
  {
    this.aJb = paramFloat;
  }
  
  public void a(CommonPreferences.OCRLanguage paramOCRLanguage)
  {
    this.aJi = paramOCRLanguage;
  }
  
  public void a(CommonPreferences.PDFImageDensity paramPDFImageDensity)
  {
    this.aJd = paramPDFImageDensity;
  }
  
  public void a(CommonPreferences.PDFImageQuality paramPDFImageQuality)
  {
    this.aJc = paramPDFImageQuality;
  }
  
  public void a(CommonPreferences.PageOrientation paramPageOrientation)
  {
    this.aIX = paramPageOrientation;
  }
  
  public void b(CommonPreferences.OCRLanguage paramOCRLanguage)
  {
    this.aJj = paramOCRLanguage;
  }
  
  public void b(CommonPreferences.PageSize paramPageSize)
  {
    this.aIU = paramPageSize;
  }
  
  public void f(Intent paramIntent)
  {
    paramIntent.putExtra("doc_id", this.aIS);
    paramIntent.putExtra("doc_name", this.mName);
    paramIntent.putExtra("doc_last_modification_time", this.aIT);
    paramIntent.putExtra("doc_page_size", this.aIU.Dp());
    paramIntent.putExtra("doc_page_width", this.aIV);
    paramIntent.putExtra("doc_page_height", this.aIW);
    paramIntent.putExtra("doc_page_orientation", this.aIX.Dp());
    paramIntent.putExtra("doc_page_left_margin", this.aIY);
    paramIntent.putExtra("doc_page_right_margin", this.aIZ);
    paramIntent.putExtra("doc_page_top_margin", this.aJa);
    paramIntent.putExtra("doc_page_bottom_margin", this.aJb);
    paramIntent.putExtra("doc_image_quality", this.aJc.Dp());
    paramIntent.putExtra("doc_image_density", this.aJd.Dp());
    paramIntent.putExtra("doc_num_pages", this.aJe);
    paramIntent.putExtra("doc_last_access_time", this.aJf);
    paramIntent.putExtra("doc_favorite_rank", this.aCf);
    paramIntent.putExtra("doc_title_page_id", this.aJg);
    paramIntent.putExtra("doc_accessed_flag", this.aJh);
    paramIntent.putExtra("doc_recognized_content_lang", this.aJi.Dp());
    paramIntent.putExtra("doc_recognized_content_second_lang", this.aJj.Dp());
  }
  
  public long getId()
  {
    return this.aIS;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public void gw(int paramInt)
  {
    this.aCf = paramInt;
  }
  
  public void p(Bundle paramBundle)
  {
    paramBundle.putLong("doc_id", this.aIS);
    paramBundle.putString("doc_name", this.mName);
    paramBundle.putLong("doc_last_modification_time", this.aIT);
    paramBundle.putInt("doc_page_size", this.aIU.Dp());
    paramBundle.putFloat("doc_page_width", this.aIV);
    paramBundle.putFloat("doc_page_height", this.aIW);
    paramBundle.putInt("doc_page_orientation", this.aIX.Dp());
    paramBundle.putFloat("doc_page_left_margin", this.aIY);
    paramBundle.putFloat("doc_page_right_margin", this.aIZ);
    paramBundle.putFloat("doc_page_top_margin", this.aJa);
    paramBundle.putFloat("doc_page_bottom_margin", this.aJb);
    paramBundle.putInt("doc_image_quality", this.aJc.Dp());
    paramBundle.putInt("doc_image_density", this.aJd.Dp());
    paramBundle.putInt("doc_num_pages", this.aJe);
    paramBundle.putLong("doc_last_access_time", this.aJf);
    paramBundle.putInt("doc_favorite_rank", this.aCf);
    paramBundle.putLong("doc_title_page_id", this.aJg);
    paramBundle.putBoolean("doc_accessed_flag", this.aJh);
    paramBundle.putInt("doc_recognized_content_lang", this.aJi.Dp());
    paramBundle.putInt("doc_recognized_content_second_lang", this.aJj.Dp());
  }
  
  public void setName(String paramString)
  {
    this.mName = paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/model/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */