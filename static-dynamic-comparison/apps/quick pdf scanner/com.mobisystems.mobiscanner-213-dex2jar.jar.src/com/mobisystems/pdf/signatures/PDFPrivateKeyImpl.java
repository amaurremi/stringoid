package com.mobisystems.pdf.signatures;

import android.annotation.TargetApi;
import android.content.Context;
import android.security.KeyChain;
import android.security.KeyChainException;
import com.mobisystems.pdf.PDFError;
import com.mobisystems.pdf.PDFTrace;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;

@TargetApi(14)
public class PDFPrivateKeyImpl
{
  private static AlgorithmMap mAlgorithmMap;
  private long _handle = 0L;
  private int _keyAlgorithm;
  private X509Certificate mCertificate;
  private PrivateKey mPrivateKey;
  
  public PDFPrivateKeyImpl(Context paramContext, String paramString)
  {
    mAlgorithmMap = new AlgorithmMap();
    mAlgorithmMap.add(new AlgorithmMapEntry(1, 1, "SHA1withRSA"));
    mAlgorithmMap.add(new AlgorithmMapEntry(2, 1, "SHA256WithRSA"));
    mAlgorithmMap.add(new AlgorithmMapEntry(4, 1, "SHA384WithRSA"));
    mAlgorithmMap.add(new AlgorithmMapEntry(8, 1, "SHA512WithRSA"));
    mAlgorithmMap.add(new AlgorithmMapEntry(128, 1, "MD5WithRSA"));
    mAlgorithmMap.add(new AlgorithmMapEntry(1, 2, "SHA1withDSA"));
    try
    {
      this.mPrivateKey = KeyChain.getPrivateKey(paramContext, paramString);
      if (this.mPrivateKey == null) {
        PDFError.throwError(64537);
      }
      paramContext = KeyChain.getCertificateChain(paramContext, paramString);
      if ((paramContext == null) || (paramContext.length == 0)) {
        PDFError.throwError(64537);
      }
      this.mCertificate = paramContext[0];
      paramContext = this.mCertificate.getEncoded();
      if ((paramContext == null) || (paramContext.length == 0)) {
        PDFError.throwError(64537);
      }
      PDFError.throwError(init(paramContext));
      return;
    }
    catch (KeyChainException paramContext)
    {
      PDFError.throwError(64537, paramContext);
      return;
    }
    catch (InterruptedException paramContext)
    {
      PDFError.throwError(64537, paramContext);
      return;
    }
    catch (CertificateEncodingException paramContext)
    {
      PDFError.throwError(64537, paramContext);
    }
  }
  
  private native void destroy();
  
  private native int init(byte[] paramArrayOfByte);
  
  private native int setHash(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong);
  
  protected void finalize()
  {
    destroy();
    super.finalize();
  }
  
  public long getHandle()
  {
    return this._handle;
  }
  
  public int sign(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    try
    {
      Object localObject = mAlgorithmMap.getSignatureAlgorithm(paramInt, this._keyAlgorithm);
      if (localObject == null)
      {
        PDFTrace.e("Unsupported algorithm pair: Digest=" + paramInt + ", Encrypt=" + this._keyAlgorithm);
        return 64547;
      }
      localObject = Signature.getInstance((String)localObject);
      ((Signature)localObject).initSign(this.mPrivateKey);
      ((Signature)localObject).update(paramArrayOfByte);
      paramInt = setHash(((Signature)localObject).sign(), paramInt, this._keyAlgorithm, paramLong);
      return paramInt;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      PDFTrace.e("Error signing data", paramArrayOfByte);
      return 64537;
    }
    catch (InvalidKeyException paramArrayOfByte)
    {
      PDFTrace.e("Error signing data", paramArrayOfByte);
      return 64537;
    }
    catch (SignatureException paramArrayOfByte)
    {
      PDFTrace.e("Error signing data", paramArrayOfByte);
    }
    return 64537;
  }
  
  private class AlgorithmMap
  {
    private ArrayList<PDFPrivateKeyImpl.AlgorithmMapEntry> _map = new ArrayList();
    
    public AlgorithmMap() {}
    
    public void add(PDFPrivateKeyImpl.AlgorithmMapEntry paramAlgorithmMapEntry)
    {
      this._map.add(paramAlgorithmMapEntry);
    }
    
    public String getSignatureAlgorithm(int paramInt1, int paramInt2)
    {
      Iterator localIterator = this._map.iterator();
      while (localIterator.hasNext())
      {
        PDFPrivateKeyImpl.AlgorithmMapEntry localAlgorithmMapEntry = (PDFPrivateKeyImpl.AlgorithmMapEntry)localIterator.next();
        if ((localAlgorithmMapEntry._digestAlgorithm == paramInt1) && (localAlgorithmMapEntry._encryptAlgorithm == paramInt2)) {
          return localAlgorithmMapEntry._signatureAlgorithm;
        }
      }
      return null;
    }
  }
  
  private class AlgorithmMapEntry
  {
    public final int _digestAlgorithm;
    public final int _encryptAlgorithm;
    public final String _signatureAlgorithm;
    
    public AlgorithmMapEntry(int paramInt1, int paramInt2, String paramString)
    {
      this._digestAlgorithm = paramInt1;
      this._encryptAlgorithm = paramInt2;
      this._signatureAlgorithm = paramString;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/signatures/PDFPrivateKeyImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */