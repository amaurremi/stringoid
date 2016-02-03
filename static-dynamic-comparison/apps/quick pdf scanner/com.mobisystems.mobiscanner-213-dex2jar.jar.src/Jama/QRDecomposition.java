package Jama;

import Jama.a.a;
import java.io.Serializable;

public class QRDecomposition
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private double[][] QR;
  private double[] Rdiag;
  private int m;
  private int n;
  
  public QRDecomposition(Matrix paramMatrix)
  {
    this.QR = paramMatrix.e();
    this.m = paramMatrix.f();
    this.n = paramMatrix.g();
    this.Rdiag = new double[this.n];
    int i = 0;
    while (i < this.n)
    {
      int j = i;
      double d1 = 0.0D;
      while (j < this.m)
      {
        d1 = a.hypot(d1, this.QR[j][i]);
        j += 1;
      }
      double d3 = d1;
      if (d1 != 0.0D)
      {
        double d2 = d1;
        if (this.QR[i][i] < 0.0D) {
          d2 = -d1;
        }
        j = i;
        while (j < this.m)
        {
          paramMatrix = this.QR[j];
          paramMatrix[i] /= d2;
          j += 1;
        }
        paramMatrix = this.QR[i];
        paramMatrix[i] += 1.0D;
        j = i + 1;
        for (;;)
        {
          d3 = d2;
          if (j >= this.n) {
            break;
          }
          int k = i;
          d1 = 0.0D;
          while (k < this.m)
          {
            d1 += this.QR[k][i] * this.QR[k][j];
            k += 1;
          }
          d1 = -d1 / this.QR[i][i];
          k = i;
          while (k < this.m)
          {
            paramMatrix = this.QR[k];
            paramMatrix[j] += this.QR[k][i] * d1;
            k += 1;
          }
          j += 1;
        }
      }
      this.Rdiag[i] = (-d3);
      i += 1;
    }
  }
  
  public Matrix a(Matrix paramMatrix)
  {
    if (paramMatrix.f() != this.m) {
      throw new IllegalArgumentException("Matrix row dimensions must agree.");
    }
    if (!i()) {
      throw new RuntimeException("Matrix is rank deficient.");
    }
    int i1 = paramMatrix.g();
    paramMatrix = paramMatrix.e();
    int i = 0;
    int j;
    int k;
    Object localObject;
    while (i < this.n)
    {
      j = 0;
      while (j < i1)
      {
        double d = 0.0D;
        k = i;
        while (k < this.m)
        {
          d += this.QR[k][i] * paramMatrix[k][j];
          k += 1;
        }
        d = -d / this.QR[i][i];
        k = i;
        while (k < this.m)
        {
          localObject = paramMatrix[k];
          localObject[j] += this.QR[k][i] * d;
          k += 1;
        }
        j += 1;
      }
      i += 1;
    }
    i = this.n - 1;
    while (i >= 0)
    {
      j = 0;
      while (j < i1)
      {
        localObject = paramMatrix[i];
        localObject[j] /= this.Rdiag[i];
        j += 1;
      }
      j = 0;
      while (j < i)
      {
        k = 0;
        while (k < i1)
        {
          localObject = paramMatrix[j];
          localObject[k] -= paramMatrix[i][k] * this.QR[j][i];
          k += 1;
        }
        j += 1;
      }
      i -= 1;
    }
    return new Matrix(paramMatrix, this.n, i1).a(0, this.n - 1, 0, i1 - 1);
  }
  
  public boolean i()
  {
    int i = 0;
    while (i < this.n)
    {
      if (this.Rdiag[i] == 0.0D) {
        return false;
      }
      i += 1;
    }
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/Jama/QRDecomposition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */