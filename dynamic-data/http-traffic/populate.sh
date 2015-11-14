#!/usr/bin/env bash

echo ""
echo "--------------------------------------------------"
echo "For now, ask Erik to give you the HTTP dump files."
echo "--------------------------------------------------"
echo ""

for f in *_content.txt; do
    base=$(basename $f "_content.txt")
    target="${base}_responses.txt"

    cat $f | grep -v "^---[0-9]" > $target
done
