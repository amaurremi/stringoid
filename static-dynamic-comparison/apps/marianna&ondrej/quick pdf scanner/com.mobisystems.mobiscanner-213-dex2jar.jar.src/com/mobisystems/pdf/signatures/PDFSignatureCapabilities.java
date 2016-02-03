package com.mobisystems.pdf.signatures;

public class PDFSignatureCapabilities
{
  public class DigestAlgorithm
  {
    public static final int ALL = Integer.MAX_VALUE;
    public static final int GOST_R3411_94 = 1024;
    public static final int MD2 = 32;
    public static final int MD4 = 64;
    public static final int MD5 = 128;
    public static final int MDC2 = 256;
    public static final int NONE = 0;
    public static final int RIPEMD160 = 16;
    public static final int SHA = 512;
    public static final int SHA1 = 1;
    public static final int SHA256 = 2;
    public static final int SHA384 = 4;
    public static final int SHA512 = 8;
    public static final int UNKNOWN = 0;
    
    public DigestAlgorithm() {}
  }
  
  public class EncryptAlgorithm
  {
    public static final int ALL = Integer.MAX_VALUE;
    public static final int DH = 4;
    public static final int DSA = 2;
    public static final int DSA2 = 16;
    public static final int EC = 8;
    public static final int GOST_R3410_2001 = 64;
    public static final int GOST_R3410_2001_CC = 256;
    public static final int GOST_R3410_94 = 32;
    public static final int GOST_R3410_94_CC = 128;
    public static final int NONE = 0;
    public static final int RSA = 1;
    public static final int UNKNOWN = 0;
    
    public EncryptAlgorithm() {}
  }
  
  public class Filter
  {
    public static final int ADOBE_PPKLITE = 1;
    public static final int ALL = Integer.MAX_VALUE;
    public static final int NONE = 0;
    public static final int UNKNOWN = 0;
    
    public Filter() {}
  }
  
  public class SubFilter
  {
    public static final int ADBE_PKCS7_Detached = 2;
    public static final int ADBE_PKCS7_SHA1 = 4;
    public static final int ADBE_X509_RSA_SHA1 = 1;
    public static final int ALL = Integer.MAX_VALUE;
    public static final int ETSI_CADES_DETACHED = 8;
    public static final int ETSI_RFC3161 = 16;
    public static final int NONE = 0;
    public static final int UNKNOWN = 0;
    
    public SubFilter() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/signatures/PDFSignatureCapabilities.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */