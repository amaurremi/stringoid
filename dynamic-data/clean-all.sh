#!/usr/bin/env bash

set -e

doit=${1:?"Are you sure? If so, pass any argument."}

echo "---------------------------------------------------------------"
echo "This will not delete the apps. Do so yourself if feel inclined:"
echo ""
echo "       $ rm -f ./apps/*.apk"
echo "---------------------------------------------------------------"

# (cd apps ; rm -f *.apk)

(cd static-app-content ; rm -f *.content)

(cd http-traffic ; rm -f *.txt)

(cd automata ; rm -f *.automaton)

(cd enumerated ; rm -f *.urls)
