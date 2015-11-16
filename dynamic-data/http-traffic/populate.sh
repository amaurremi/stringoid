#!/usr/bin/env bash

unzip -n 20_apps.zip

for f in *_content.txt; do
    base=$(basename $f "_content.txt")
    target="${base}_responses.txt"

    cat $f | grep -v "^---[0-9]" > $target
done
