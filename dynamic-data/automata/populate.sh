#!/usr/bin/env bash

results=${1:?"Please provide a results file."}

for apk in ../apps/*.apk; do
    bse=$(basename ${apk} .apk)

    echo "Retrieving automaton for ${bse}..."

    out="${bse}.automaton"

    cat ${results} | grep "${bse}" > ${out}
done
    
