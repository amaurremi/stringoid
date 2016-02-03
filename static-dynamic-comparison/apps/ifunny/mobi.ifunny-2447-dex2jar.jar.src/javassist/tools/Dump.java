package javassist.tools;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

import javassist.bytecode.ClassFile;
import javassist.bytecode.ClassFilePrinter;
import javassist.bytecode.ConstPool;

public class Dump {
    public static void main(String[] paramArrayOfString) {
        if (paramArrayOfString.length != 1) {
            System.err.println("Usage: java Dump <class file name>");
            return;
        }
        paramArrayOfString = new ClassFile(new DataInputStream(new FileInputStream(paramArrayOfString[0])));
        PrintWriter localPrintWriter = new PrintWriter(System.out, true);
        localPrintWriter.println("*** constant pool ***");
        paramArrayOfString.getConstPool().print(localPrintWriter);
        localPrintWriter.println();
        localPrintWriter.println("*** members ***");
        ClassFilePrinter.print(paramArrayOfString, localPrintWriter);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/tools/Dump.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */