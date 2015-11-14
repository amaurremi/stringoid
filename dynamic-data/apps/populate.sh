#!/usr/bin/env bash

for a in $(cat apk-urls); do
    filename=$(basename $a)

    if [ ! -f "${filename}" ]; then
        wget $a
    else
        echo "${filename} already exists."
    fi
done
