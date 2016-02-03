package Jama;

import java.io.Serializable;

public class LUDecomposition
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private double[][] LU;
  private int m;
  private int n;
  private int[] piv;
  private int pivsign;
  
  public LUDecomposition(Matrix paramMatrix)
  {
    this.LU = paramMatrix.e();
    this.m = paramMatrix.f();
    this.n = paramMatrix.g();
    this.piv = new int[this.m];
    int i = 0;
    while (i < this.m)
    {
      this.piv[i] = i;
      i += 1;
    }
    this.pivsign = 1;
    paramMatrix = new double[this.m];
    i = 0;
    while (i < this.n)
    {
      int j = 0;
      while (j < this.m)
      {
        paramMatrix[j] = this.LU[j][i];
        j += 1;
      }
      j = 0;
      double[] arrayOfDouble;
      int i1;
      while (j < this.m)
      {
        arrayOfDouble = this.LU[j];
        i1 = Math.min(j, i);
        double d = 0.0D;
        k = 0;
        while (k < i1)
        {
          d += arrayOfDouble[k] * paramMatrix[k];
          k += 1;
        }
        d = paramMatrix[j] - d;
        paramMatrix[j] = d;
        arrayOfDouble[i] = d;
        j += 1;
      }
      j = i + 1;
      for (int k = i; j < this.m; k = i1)
      {
        i1 = k;
        if (Math.abs(paramMatrix[j]) > Math.abs(paramMatrix[k])) {
          i1 = j;
        }
        j += 1;
      }
      if (k != i)
      {
        j = 0;
        while (j < this.n)
        {
          long l = this.LU[k][j];
          this.LU[k][j] = this.LU[i][j];
          this.LU[i][j] = l;
          j += 1;
        }
        j = this.piv[k];
        this.piv[k] = this.piv[i];
        this.piv[i] = j;
        this.pivsign = (-this.pivsign);
      }
      if (i < this.m)
      {
        j = 1;
        if (this.LU[i][i] == 0.0D) {
          break label487;
        }
      }
      label487:
      for (k = 1;; k = 0)
      {
        if ((j & k) == 0) {
          break label493;
        }
        j = i + 1;
        while (j < this.m)
        {
          arrayOfDouble = this.LU[j];
          arrayOfDouble[i] /= this.LU[i][i];
          j += 1;
        }
        j = 0;
        break;
      }
      label493:
      i += 1;
    }
  }
  
  public Matrix a(Matrix paramMatrix)
  {
    if (paramMatrix.f() != this.m) {
      throw new IllegalArgumentException("Matrix row dimensions must agree.");
    }
    if (!a()) {
      throw new RuntimeException("Matrix is singular.");
    }
    int i1 = paramMatrix.g();
    paramMatrix = paramMatrix.a(this.piv, 0, i1 - 1);
    double[][] arrayOfDouble = paramMatrix.d();
    int i = 0;
    int j;
    int k;
    double[] arrayOfDouble1;
    while (i < this.n)
    {
      j = i + 1;
      while (j < this.n)
      {
        k = 0;
        while (k < i1)
        {
          arrayOfDouble1 = arrayOfDouble[j];
          arrayOfDouble1[k] -= arrayOfDouble[i][k] * this.LU[j][i];
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
        arrayOfDouble1 = arrayOfDouble[i];
        arrayOfDouble1[j] /= this.LU[i][i];
        j += 1;
      }
      j = 0;
      while (j < i)
      {
        k = 0;
        while (k < i1)
        {
          arrayOfDouble1 = arrayOfDouble[j];
          arrayOfDouble1[k] -= arrayOfDouble[i][k] * this.LU[j][i];
          k += 1;
        }
        j += 1;
      }
      i -= 1;
    }
    return paramMatrix;
  }
  
  public boolean a()
  {
    int i = 0;
    while (i < this.n)
    {
      if (this.LU[i][i] == 0.0D) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public double b()
  {
    if (this.m != this.n) {
      throw new IllegalArgumentException("Matrix must be square.");
    }
    double d = this.pivsign;
    int i = 0;
    while (i < this.n)
    {
      d *= this.LU[i][i];
      i += 1;
    }
    return d;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/Jama/LUDecomposition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */