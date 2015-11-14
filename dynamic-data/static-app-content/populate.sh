#!/usr/bin/env bash

for apk in ../apps/*.apk; do
    out="$(basename ${apk} .apk).content"

    if [ ! -f "${out}" ]; then
        ./extract-content.sh ${apk} > ${out}
    else
        echo "${out} already exists."
    fi
done


