#!/usr/bin/env bash

for automaton in ../automata/*.automaton; do
    out="$(basename ${automaton} .automaton).urls"

    echo "Enumerating patterns for $(basename ${automaton} .automaton)..."

    if [ ! -f "${out}" ]; then
        python ./enumerate-automata.py ${automaton} > ${out}
    else
        echo "${out} already exists."
    fi
done


