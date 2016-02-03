package com.mobisystems.mobiscanner.controller;

import android.os.AsyncTask;
import com.mobisystems.mobiscanner.image.Image;
import com.mobisystems.mobiscanner.image.Image.a;
import com.mobisystems.mobiscanner.image.ImageOrientation;
import com.mobisystems.mobiscanner.image.ImageProcessing;
import com.mobisystems.mobiscanner.image.ImageProcessing.ImageOperation;
import com.mobisystems.mobiscanner.model.DocumentModel;
import com.mobisystems.mobiscanner.model.c;

class ba
  extends AsyncTask<ImageProcessing.ImageOperation, Void, c>
{
  private c aEr;
  private a aFV;
  ImageProcessing.ImageOperation aFW;
  
  public ba(c paramc, a parama)
  {
    this.aFV = parama;
    this.aEr = paramc;
  }
  
  public c a(ImageProcessing.ImageOperation... paramVarArgs)
  {
    this.aFW = paramVarArgs[0];
    c localc = new c(this.aEr);
    DocumentModel localDocumentModel = new DocumentModel();
    long l = this.aEr.getId();
    ImageOrientation localImageOrientation = this.aEr.Jb();
    paramVarArgs = localImageOrientation;
    if (localImageOrientation == ImageOrientation.aHV)
    {
      Image localImage = localDocumentModel.aq(l);
      paramVarArgs = localImageOrientation;
      if (localImage != null) {
        paramVarArgs = localImage.HW().Ic();
      }
    }
    if (localDocumentModel.a(l, ImageProcessing.a(paramVarArgs, this.aFW))) {
      return localDocumentModel.aj(l);
    }
    return localc;
  }
  
  public void b(c paramc)
  {
    if (this.aFV != null) {
      this.aFV.c(paramc);
    }
  }
  
  public static abstract interface a
  {
    public abstract void c(c paramc);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */