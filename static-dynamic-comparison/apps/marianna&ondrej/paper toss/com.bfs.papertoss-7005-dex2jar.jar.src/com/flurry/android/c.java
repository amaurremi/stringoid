package com.flurry.android;

import java.io.DataInput;
import java.io.DataOutput;

final class c
  extends aj
{
  private int A;
  private int B;
  private int C;
  private int D;
  private int E;
  private int F;
  private int G;
  private int H;
  private int I;
  private int J;
  private int K;
  private int L;
  private int M;
  private int N;
  private int O;
  private int P;
  private int Q;
  private int R;
  private int S;
  private int T;
  private int U;
  private int V;
  private int W;
  private int X;
  private int Y;
  private int Z;
  byte a;
  private int aa;
  private int ab;
  private int ac;
  private int ad;
  private int ae;
  private int af;
  private boolean ag;
  String b;
  long c;
  String d;
  int e;
  int f;
  String g;
  int h;
  int i;
  String j;
  int k;
  int l;
  int m;
  int n;
  int o;
  int p;
  int q;
  private long r;
  private String s;
  private int t;
  private int u;
  private String v;
  private int w;
  private int x;
  private String y;
  private int z;
  
  c() {}
  
  c(DataInput paramDataInput)
  {
    c(paramDataInput);
  }
  
  private void c(DataInput paramDataInput)
  {
    this.a = paramDataInput.readByte();
    this.b = paramDataInput.readUTF();
    this.c = paramDataInput.readLong();
    this.r = paramDataInput.readLong();
    this.d = paramDataInput.readUTF();
    this.e = paramDataInput.readUnsignedShort();
    this.f = paramDataInput.readInt();
    this.g = paramDataInput.readUTF();
    this.h = paramDataInput.readUnsignedShort();
    this.i = paramDataInput.readInt();
    this.j = paramDataInput.readUTF();
    this.k = paramDataInput.readUnsignedShort();
    this.l = paramDataInput.readInt();
  }
  
  final void a(DataInput paramDataInput)
  {
    this.s = paramDataInput.readUTF();
    this.t = paramDataInput.readUnsignedShort();
    this.u = paramDataInput.readInt();
    this.v = paramDataInput.readUTF();
    this.w = paramDataInput.readUnsignedShort();
    this.x = paramDataInput.readInt();
    this.y = paramDataInput.readUTF();
    this.z = paramDataInput.readUnsignedShort();
    this.A = paramDataInput.readInt();
    this.B = paramDataInput.readInt();
    this.C = paramDataInput.readInt();
    this.m = paramDataInput.readInt();
    this.n = paramDataInput.readInt();
    this.o = paramDataInput.readInt();
    this.p = paramDataInput.readInt();
    this.D = paramDataInput.readInt();
    this.E = paramDataInput.readInt();
    this.F = paramDataInput.readInt();
    this.G = paramDataInput.readInt();
    this.H = paramDataInput.readInt();
    this.I = paramDataInput.readInt();
    this.J = paramDataInput.readInt();
    this.K = paramDataInput.readInt();
    this.q = paramDataInput.readInt();
    this.L = paramDataInput.readInt();
    this.M = paramDataInput.readInt();
    this.N = paramDataInput.readInt();
    this.O = paramDataInput.readInt();
    this.P = paramDataInput.readInt();
    this.Q = paramDataInput.readInt();
    this.R = paramDataInput.readInt();
    this.S = paramDataInput.readInt();
    this.T = paramDataInput.readInt();
    this.U = paramDataInput.readInt();
    this.V = paramDataInput.readInt();
    this.W = paramDataInput.readInt();
    this.X = paramDataInput.readInt();
    this.Y = paramDataInput.readInt();
    this.Z = paramDataInput.readInt();
    this.aa = paramDataInput.readInt();
    this.ab = paramDataInput.readInt();
    this.ac = paramDataInput.readInt();
    this.ad = paramDataInput.readInt();
    this.ae = paramDataInput.readInt();
    this.af = paramDataInput.readInt();
    this.ag = true;
  }
  
  final void a(DataOutput paramDataOutput)
  {
    paramDataOutput.writeByte(this.a);
    paramDataOutput.writeUTF(this.b);
    paramDataOutput.writeLong(this.c);
    paramDataOutput.writeLong(this.r);
    paramDataOutput.writeUTF(this.d);
    paramDataOutput.writeShort(this.e);
    paramDataOutput.writeInt(this.f);
    paramDataOutput.writeUTF(this.g);
    paramDataOutput.writeShort(this.h);
    paramDataOutput.writeInt(this.i);
    paramDataOutput.writeUTF(this.j);
    paramDataOutput.writeShort(this.k);
    paramDataOutput.writeInt(this.l);
    paramDataOutput.writeBoolean(this.ag);
    if (this.ag)
    {
      paramDataOutput.writeUTF(this.s);
      paramDataOutput.writeShort(this.t);
      paramDataOutput.writeInt(this.u);
      paramDataOutput.writeUTF(this.v);
      paramDataOutput.writeShort(this.w);
      paramDataOutput.writeInt(this.x);
      paramDataOutput.writeUTF(this.y);
      paramDataOutput.writeShort(this.z);
      paramDataOutput.writeInt(this.A);
      paramDataOutput.writeInt(this.B);
      paramDataOutput.writeInt(this.C);
      paramDataOutput.writeInt(this.m);
      paramDataOutput.writeInt(this.n);
      paramDataOutput.writeInt(this.o);
      paramDataOutput.writeInt(this.p);
      paramDataOutput.writeInt(this.D);
      paramDataOutput.writeInt(this.E);
      paramDataOutput.writeInt(this.F);
      paramDataOutput.writeInt(this.G);
      paramDataOutput.writeInt(this.H);
      paramDataOutput.writeInt(this.I);
      paramDataOutput.writeInt(this.J);
      paramDataOutput.writeInt(this.K);
      paramDataOutput.writeInt(this.q);
      paramDataOutput.writeInt(this.L);
      paramDataOutput.writeInt(this.M);
      paramDataOutput.writeInt(this.N);
      paramDataOutput.writeInt(this.O);
      paramDataOutput.writeInt(this.P);
      paramDataOutput.writeInt(this.Q);
      paramDataOutput.writeInt(this.R);
      paramDataOutput.writeInt(this.S);
      paramDataOutput.writeInt(this.T);
      paramDataOutput.writeInt(this.U);
      paramDataOutput.writeInt(this.V);
      paramDataOutput.writeInt(this.W);
      paramDataOutput.writeInt(this.X);
      paramDataOutput.writeInt(this.Y);
      paramDataOutput.writeInt(this.Z);
      paramDataOutput.writeInt(this.aa);
      paramDataOutput.writeInt(this.ab);
      paramDataOutput.writeInt(this.ac);
      paramDataOutput.writeInt(this.ad);
      paramDataOutput.writeInt(this.ae);
      paramDataOutput.writeInt(this.af);
    }
  }
  
  final void b(DataInput paramDataInput)
  {
    c(paramDataInput);
    this.ag = paramDataInput.readBoolean();
    if (this.ag) {
      a(paramDataInput);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/flurry/android/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */