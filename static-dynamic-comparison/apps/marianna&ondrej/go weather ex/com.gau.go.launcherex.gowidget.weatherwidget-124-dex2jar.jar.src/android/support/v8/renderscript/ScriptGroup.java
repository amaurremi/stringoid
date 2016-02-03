package android.support.v8.renderscript;

import java.util.ArrayList;

public class ScriptGroup
  extends BaseObj
{
  IO[] mInputs;
  IO[] mOutputs;
  
  ScriptGroup(int paramInt, RenderScript paramRenderScript)
  {
    super(paramInt, paramRenderScript);
  }
  
  public void execute()
  {
    this.mRS.nScriptGroupExecute(getID(this.mRS));
  }
  
  public void setInput(Script.KernelID paramKernelID, Allocation paramAllocation)
  {
    int i = 0;
    while (i < this.mInputs.length)
    {
      if (this.mInputs[i].mKID == paramKernelID)
      {
        this.mInputs[i].mAllocation = paramAllocation;
        this.mRS.nScriptGroupSetInput(getID(this.mRS), paramKernelID.getID(this.mRS), this.mRS.safeID(paramAllocation));
        return;
      }
      i += 1;
    }
    throw new RSIllegalArgumentException("Script not found");
  }
  
  public void setOutput(Script.KernelID paramKernelID, Allocation paramAllocation)
  {
    int i = 0;
    while (i < this.mOutputs.length)
    {
      if (this.mOutputs[i].mKID == paramKernelID)
      {
        this.mOutputs[i].mAllocation = paramAllocation;
        this.mRS.nScriptGroupSetOutput(getID(this.mRS), paramKernelID.getID(this.mRS), this.mRS.safeID(paramAllocation));
        return;
      }
      i += 1;
    }
    throw new RSIllegalArgumentException("Script not found");
  }
  
  public static final class Builder
  {
    private int mKernelCount;
    private ArrayList<ScriptGroup.ConnectLine> mLines = new ArrayList();
    private ArrayList<ScriptGroup.Node> mNodes = new ArrayList();
    private RenderScript mRS;
    private ScriptGroupThunker.Builder mT;
    
    public Builder(RenderScript paramRenderScript)
    {
      if (RenderScript.isNative) {
        this.mT = new ScriptGroupThunker.Builder(paramRenderScript);
      }
      this.mRS = paramRenderScript;
    }
    
    private ScriptGroup.Node findNode(Script.KernelID paramKernelID)
    {
      int i = 0;
      while (i < this.mNodes.size())
      {
        ScriptGroup.Node localNode = (ScriptGroup.Node)this.mNodes.get(i);
        int j = 0;
        while (j < localNode.mKernels.size())
        {
          if (paramKernelID == localNode.mKernels.get(j)) {
            return localNode;
          }
          j += 1;
        }
        i += 1;
      }
      return null;
    }
    
    private ScriptGroup.Node findNode(Script paramScript)
    {
      int i = 0;
      while (i < this.mNodes.size())
      {
        if (paramScript == ((ScriptGroup.Node)this.mNodes.get(i)).mScript) {
          return (ScriptGroup.Node)this.mNodes.get(i);
        }
        i += 1;
      }
      return null;
    }
    
    private void mergeDAGs(int paramInt1, int paramInt2)
    {
      int i = 0;
      while (i < this.mNodes.size())
      {
        if (((ScriptGroup.Node)this.mNodes.get(i)).dagNumber == paramInt2) {
          ((ScriptGroup.Node)this.mNodes.get(i)).dagNumber = paramInt1;
        }
        i += 1;
      }
    }
    
    private void validateCycle(ScriptGroup.Node paramNode1, ScriptGroup.Node paramNode2)
    {
      int i = 0;
      while (i < paramNode1.mOutputs.size())
      {
        Object localObject = (ScriptGroup.ConnectLine)paramNode1.mOutputs.get(i);
        if (((ScriptGroup.ConnectLine)localObject).mToK != null)
        {
          ScriptGroup.Node localNode = findNode(((ScriptGroup.ConnectLine)localObject).mToK.mScript);
          if (localNode.equals(paramNode2)) {
            throw new RSInvalidStateException("Loops in group not allowed.");
          }
          validateCycle(localNode, paramNode2);
        }
        if (((ScriptGroup.ConnectLine)localObject).mToF != null)
        {
          localObject = findNode(((ScriptGroup.ConnectLine)localObject).mToF.mScript);
          if (localObject.equals(paramNode2)) {
            throw new RSInvalidStateException("Loops in group not allowed.");
          }
          validateCycle((ScriptGroup.Node)localObject, paramNode2);
        }
        i += 1;
      }
    }
    
    private void validateDAG()
    {
      int i = 0;
      while (i < this.mNodes.size())
      {
        ScriptGroup.Node localNode = (ScriptGroup.Node)this.mNodes.get(i);
        if (localNode.mInputs.size() == 0)
        {
          if ((localNode.mOutputs.size() == 0) && (this.mNodes.size() > 1)) {
            throw new RSInvalidStateException("Groups cannot contain unconnected scripts");
          }
          validateDAGRecurse(localNode, i + 1);
        }
        i += 1;
      }
      int j = ((ScriptGroup.Node)this.mNodes.get(0)).dagNumber;
      i = 0;
      while (i < this.mNodes.size())
      {
        if (((ScriptGroup.Node)this.mNodes.get(i)).dagNumber != j) {
          throw new RSInvalidStateException("Multiple DAGs in group not allowed.");
        }
        i += 1;
      }
    }
    
    private void validateDAGRecurse(ScriptGroup.Node paramNode, int paramInt)
    {
      if ((paramNode.dagNumber != 0) && (paramNode.dagNumber != paramInt)) {
        mergeDAGs(paramNode.dagNumber, paramInt);
      }
      for (;;)
      {
        return;
        paramNode.dagNumber = paramInt;
        int i = 0;
        while (i < paramNode.mOutputs.size())
        {
          ScriptGroup.ConnectLine localConnectLine = (ScriptGroup.ConnectLine)paramNode.mOutputs.get(i);
          if (localConnectLine.mToK != null) {
            validateDAGRecurse(findNode(localConnectLine.mToK.mScript), paramInt);
          }
          if (localConnectLine.mToF != null) {
            validateDAGRecurse(findNode(localConnectLine.mToF.mScript), paramInt);
          }
          i += 1;
        }
      }
    }
    
    public Builder addConnection(Type paramType, Script.KernelID paramKernelID, Script.FieldID paramFieldID)
    {
      if (this.mT != null)
      {
        this.mT.addConnection(paramType, paramKernelID, paramFieldID);
        return this;
      }
      ScriptGroup.Node localNode1 = findNode(paramKernelID);
      if (localNode1 == null) {
        throw new RSInvalidStateException("From script not found.");
      }
      ScriptGroup.Node localNode2 = findNode(paramFieldID.mScript);
      if (localNode2 == null) {
        throw new RSInvalidStateException("To script not found.");
      }
      ScriptGroup.ConnectLine localConnectLine = new ScriptGroup.ConnectLine(paramType, paramKernelID, paramFieldID);
      this.mLines.add(new ScriptGroup.ConnectLine(paramType, paramKernelID, paramFieldID));
      localNode1.mOutputs.add(localConnectLine);
      localNode2.mInputs.add(localConnectLine);
      validateCycle(localNode1, localNode1);
      return this;
    }
    
    public Builder addConnection(Type paramType, Script.KernelID paramKernelID1, Script.KernelID paramKernelID2)
    {
      if (this.mT != null)
      {
        this.mT.addConnection(paramType, paramKernelID1, paramKernelID2);
        return this;
      }
      ScriptGroup.Node localNode1 = findNode(paramKernelID1);
      if (localNode1 == null) {
        throw new RSInvalidStateException("From script not found.");
      }
      ScriptGroup.Node localNode2 = findNode(paramKernelID2);
      if (localNode2 == null) {
        throw new RSInvalidStateException("To script not found.");
      }
      ScriptGroup.ConnectLine localConnectLine = new ScriptGroup.ConnectLine(paramType, paramKernelID1, paramKernelID2);
      this.mLines.add(new ScriptGroup.ConnectLine(paramType, paramKernelID1, paramKernelID2));
      localNode1.mOutputs.add(localConnectLine);
      localNode2.mInputs.add(localConnectLine);
      validateCycle(localNode1, localNode1);
      return this;
    }
    
    public Builder addKernel(Script.KernelID paramKernelID)
    {
      if (this.mT != null) {
        this.mT.addKernel(paramKernelID);
      }
      do
      {
        return this;
        if (this.mLines.size() != 0) {
          throw new RSInvalidStateException("Kernels may not be added once connections exist.");
        }
      } while (findNode(paramKernelID) != null);
      this.mKernelCount += 1;
      ScriptGroup.Node localNode2 = findNode(paramKernelID.mScript);
      ScriptGroup.Node localNode1 = localNode2;
      if (localNode2 == null)
      {
        localNode1 = new ScriptGroup.Node(paramKernelID.mScript);
        this.mNodes.add(localNode1);
      }
      localNode1.mKernels.add(paramKernelID);
      return this;
    }
    
    public ScriptGroup create()
    {
      if (this.mT != null)
      {
        localObject1 = this.mT.create();
        return (ScriptGroup)localObject1;
      }
      if (this.mNodes.size() == 0) {
        throw new RSInvalidStateException("Empty script groups are not allowed");
      }
      int i = 0;
      while (i < this.mNodes.size())
      {
        ((ScriptGroup.Node)this.mNodes.get(i)).dagNumber = 0;
        i += 1;
      }
      validateDAG();
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = new ArrayList();
      Object localObject2 = new int[this.mKernelCount];
      int j = 0;
      i = 0;
      while (i < this.mNodes.size())
      {
        localObject3 = (ScriptGroup.Node)this.mNodes.get(i);
        int k = 0;
        while (k < ((ScriptGroup.Node)localObject3).mKernels.size())
        {
          localObject4 = (Script.KernelID)((ScriptGroup.Node)localObject3).mKernels.get(k);
          localObject2[j] = ((Script.KernelID)localObject4).getID(this.mRS);
          int m = 0;
          int i1 = 0;
          int n = 0;
          while (n < ((ScriptGroup.Node)localObject3).mInputs.size())
          {
            if (((ScriptGroup.ConnectLine)((ScriptGroup.Node)localObject3).mInputs.get(n)).mToK == localObject4) {
              m = 1;
            }
            n += 1;
          }
          n = 0;
          while (n < ((ScriptGroup.Node)localObject3).mOutputs.size())
          {
            if (((ScriptGroup.ConnectLine)((ScriptGroup.Node)localObject3).mOutputs.get(n)).mFrom == localObject4) {
              i1 = 1;
            }
            n += 1;
          }
          if (m == 0) {
            localArrayList.add(new ScriptGroup.IO((Script.KernelID)localObject4));
          }
          if (i1 == 0) {
            ((ArrayList)localObject1).add(new ScriptGroup.IO((Script.KernelID)localObject4));
          }
          k += 1;
          j += 1;
        }
        i += 1;
      }
      if (j != this.mKernelCount) {
        throw new RSRuntimeException("Count mismatch, should not happen.");
      }
      Object localObject3 = new int[this.mLines.size()];
      Object localObject4 = new int[this.mLines.size()];
      int[] arrayOfInt1 = new int[this.mLines.size()];
      int[] arrayOfInt2 = new int[this.mLines.size()];
      i = 0;
      while (i < this.mLines.size())
      {
        ScriptGroup.ConnectLine localConnectLine = (ScriptGroup.ConnectLine)this.mLines.get(i);
        localObject3[i] = localConnectLine.mFrom.getID(this.mRS);
        if (localConnectLine.mToK != null) {
          localObject4[i] = localConnectLine.mToK.getID(this.mRS);
        }
        if (localConnectLine.mToF != null) {
          arrayOfInt1[i] = localConnectLine.mToF.getID(this.mRS);
        }
        arrayOfInt2[i] = localConnectLine.mAllocationType.getID(this.mRS);
        i += 1;
      }
      i = this.mRS.nScriptGroupCreate((int[])localObject2, (int[])localObject3, (int[])localObject4, arrayOfInt1, arrayOfInt2);
      if (i == 0) {
        throw new RSRuntimeException("Object creation error, should not happen.");
      }
      localObject2 = new ScriptGroup(i, this.mRS);
      ((ScriptGroup)localObject2).mOutputs = new ScriptGroup.IO[((ArrayList)localObject1).size()];
      i = 0;
      while (i < ((ArrayList)localObject1).size())
      {
        ((ScriptGroup)localObject2).mOutputs[i] = ((ScriptGroup.IO)((ArrayList)localObject1).get(i));
        i += 1;
      }
      ((ScriptGroup)localObject2).mInputs = new ScriptGroup.IO[localArrayList.size()];
      i = 0;
      for (;;)
      {
        localObject1 = localObject2;
        if (i >= localArrayList.size()) {
          break;
        }
        ((ScriptGroup)localObject2).mInputs[i] = ((ScriptGroup.IO)localArrayList.get(i));
        i += 1;
      }
    }
  }
  
  static class ConnectLine
  {
    Type mAllocationType;
    Script.KernelID mFrom;
    Script.FieldID mToF;
    Script.KernelID mToK;
    
    ConnectLine(Type paramType, Script.KernelID paramKernelID, Script.FieldID paramFieldID)
    {
      this.mFrom = paramKernelID;
      this.mToF = paramFieldID;
      this.mAllocationType = paramType;
    }
    
    ConnectLine(Type paramType, Script.KernelID paramKernelID1, Script.KernelID paramKernelID2)
    {
      this.mFrom = paramKernelID1;
      this.mToK = paramKernelID2;
      this.mAllocationType = paramType;
    }
  }
  
  static class IO
  {
    Allocation mAllocation;
    Script.KernelID mKID;
    
    IO(Script.KernelID paramKernelID)
    {
      this.mKID = paramKernelID;
    }
  }
  
  static class Node
  {
    int dagNumber;
    ArrayList<ScriptGroup.ConnectLine> mInputs = new ArrayList();
    ArrayList<Script.KernelID> mKernels = new ArrayList();
    Node mNext;
    ArrayList<ScriptGroup.ConnectLine> mOutputs = new ArrayList();
    Script mScript;
    
    Node(Script paramScript)
    {
      this.mScript = paramScript;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/android/support/v8/renderscript/ScriptGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */