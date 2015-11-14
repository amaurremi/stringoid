#!/usr/bin/env bash

# Extracts all "text" content from Android static resources. This combines two things:
#   - all content that `grep` deems is non-binary
#   - all strings from decompressed XML resources

APK=${1:?"Please provide an apk file."}

UNPACK_DIR=$(mktemp -d)

unzip -q ${APK} -d ${UNPACK_DIR} 

grep -rI --no-filename '.*' ${UNPACK_DIR} | dos2unix

rm -rf ${UNPACK_DIR}

for res in $(aapt list ${APK} | grep 'xml$' | grep -v 'raw'); do
    aapt dump xmlstrings ${APK} "${res}"
done
