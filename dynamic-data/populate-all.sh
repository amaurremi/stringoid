#!/usr/bin/env bash

RESULTS=${1:?"Please provide results file (automaton format)."}

(cd apps ; ./populate.sh)

(cd static-app-content ; ./populate.sh)

(cd http-traffic; ./populate.sh)

(cd automata; ./populate.sh ${RESULTS})

(cd enumerated; ./populate.sh)
