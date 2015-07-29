package com.ibm.stringoid.retrieve.ir

/**
 * Retrieves the URLs in an application by extracting constant URL strings
 * found in the symbol table of the IRs of methods reachable in a call graph.
 */
object CgIrUrlRetriever extends ConstantUrlFromIrRetriever with IrFromCgRetriever