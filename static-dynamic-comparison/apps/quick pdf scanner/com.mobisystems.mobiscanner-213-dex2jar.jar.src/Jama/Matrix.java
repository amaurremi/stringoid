package Jama;

import java.io.Serializable;
import java.lang.reflect.Array;

public class Matrix
  implements Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private double[][] A;
  private int m;
  private int n;
  
  public Matrix(int paramInt1, int paramInt2)
  {
    this.m = paramInt1;
    this.n = paramInt2;
    this.A = ((double[][])Array.newInstance(Double.TYPE, new int[] { paramInt1, paramInt2 }));
  }
  
  public Matrix(double[][] paramArrayOfDouble)
  {
    this.m = paramArrayOfDouble.length;
    this.n = paramArrayOfDouble[0].length;
    while (i < this.m)
    {
      if (paramArrayOfDouble[i].length != this.n) {
        throw new IllegalArgumentException("All rows must have the same length.");
      }
      i += 1;
    }
    this.A = paramArrayOfDouble;
  }
  
  public Matrix(double[][] paramArrayOfDouble, int paramInt1, int paramInt2)
  {
    this.A = paramArrayOfDouble;
    this.m = paramInt1;
    this.n = paramInt2;
  }
  
  private void d(Matrix paramMatrix)
  {
    if ((paramMatrix.m != this.m) || (paramMatrix.n != this.n)) {
      throw new IllegalArgumentException("Matrix dimensions must agree.");
    }
  }
  
  public double a(int paramInt1, int paramInt2)
  {
    return this.A[paramInt1][paramInt2];
  }
  
  public Matrix a(double paramDouble)
  {
    Matrix localMatrix = new Matrix(this.m, this.n);
    double[][] arrayOfDouble = localMatrix.d();
    int i = 0;
    while (i < this.m)
    {
      int j = 0;
      while (j < this.n)
      {
        arrayOfDouble[i][j] = (this.A[i][j] * paramDouble);
        j += 1;
      }
      i += 1;
    }
    return localMatrix;
  }
  
  public Matrix a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Matrix localMatrix = new Matrix(paramInt2 - paramInt1 + 1, paramInt4 - paramInt3 + 1);
    double[][] arrayOfDouble = localMatrix.d();
    int i = paramInt1;
    while (i <= paramInt2)
    {
      int j = paramInt3;
      for (;;)
      {
        if (j <= paramInt4) {}
        try
        {
          arrayOfDouble[(i - paramInt1)][(j - paramInt3)] = this.A[i][j];
          j += 1;
        }
        catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
        {
          throw new ArrayIndexOutOfBoundsException("Submatrix indices");
        }
      }
      i += 1;
    }
    return localArrayIndexOutOfBoundsException;
  }
  
  public Matrix a(Matrix paramMatrix)
  {
    if (this.m == this.n) {
      return new LUDecomposition(this).a(paramMatrix);
    }
    return new QRDecomposition(this).a(paramMatrix);
  }
  
  public Matrix a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    localMatrix = new Matrix(paramArrayOfInt.length, paramInt2 - paramInt1 + 1);
    double[][] arrayOfDouble = localMatrix.d();
    int i = 0;
    try
    {
      while (i < paramArrayOfInt.length)
      {
        int j = paramInt1;
        while (j <= paramInt2)
        {
          arrayOfDouble[i][(j - paramInt1)] = this.A[paramArrayOfInt[i]][j];
          j += 1;
        }
        i += 1;
      }
      return localMatrix;
    }
    catch (ArrayIndexOutOfBoundsException paramArrayOfInt)
    {
      throw new ArrayIndexOutOfBoundsException("Submatrix indices");
    }
  }
  
  public double b()
  {
    return new LUDecomposition(this).b();
  }
  
  public Matrix b(Matrix paramMatrix)
  {
    d(paramMatrix);
    Matrix localMatrix = new Matrix(this.m, this.n);
    double[][] arrayOfDouble = localMatrix.d();
    int i = 0;
    while (i < this.m)
    {
      int j = 0;
      while (j < this.n)
      {
        arrayOfDouble[i][j] = (this.A[i][j] - paramMatrix.A[i][j]);
        j += 1;
      }
      i += 1;
    }
    return localMatrix;
  }
  
  public Matrix c()
  {
    Matrix localMatrix = new Matrix(this.m, this.n);
    double[][] arrayOfDouble = localMatrix.d();
    int i = 0;
    while (i < this.m)
    {
      int j = 0;
      while (j < this.n)
      {
        arrayOfDouble[i][j] = this.A[i][j];
        j += 1;
      }
      i += 1;
    }
    return localMatrix;
  }
  
  public Matrix c(Matrix paramMatrix)
  {
    if (paramMatrix.m != this.n) {
      throw new IllegalArgumentException("Matrix inner dimensions must agree.");
    }
    Matrix localMatrix = new Matrix(this.m, paramMatrix.n);
    double[][] arrayOfDouble = localMatrix.d();
    double[] arrayOfDouble1 = new double[this.n];
    int i = 0;
    while (i < paramMatrix.n)
    {
      int j = 0;
      while (j < this.n)
      {
        arrayOfDouble1[j] = paramMatrix.A[j][i];
        j += 1;
      }
      j = 0;
      while (j < this.m)
      {
        double[] arrayOfDouble2 = this.A[j];
        double d = 0.0D;
        int k = 0;
        while (k < this.n)
        {
          d += arrayOfDouble2[k] * arrayOfDouble1[k];
          k += 1;
        }
        arrayOfDouble[j][i] = d;
        j += 1;
      }
      i += 1;
    }
    return localMatrix;
  }
  
  public Object clone()
  {
    return c();
  }
  
  public double[][] d()
  {
    return this.A;
  }
  
  public double[][] e()
  {
    int i = this.m;
    int j = this.n;
    double[][] arrayOfDouble = (double[][])Array.newInstance(Double.TYPE, new int[] { i, j });
    i = 0;
    while (i < this.m)
    {
      j = 0;
      while (j < this.n)
      {
        arrayOfDouble[i][j] = this.A[i][j];
        j += 1;
      }
      i += 1;
    }
    return arrayOfDouble;
  }
  
  public int f()
  {
    return this.m;
  }
  
  public int g()
  {
    return this.n;
  }
  
  public Matrix h()
  {
    Matrix localMatrix = new Matrix(this.n, this.m);
    double[][] arrayOfDouble = localMatrix.d();
    int i = 0;
    while (i < this.m)
    {
      int j = 0;
      while (j < this.n)
      {
        arrayOfDouble[j][i] = this.A[i][j];
        j += 1;
      }
      i += 1;
    }
    return localMatrix;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/Jama/Matrix.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */