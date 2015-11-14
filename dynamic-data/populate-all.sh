#!/usr/bin/env bash

(cd apps ; ./populate.sh)

(cd static-app-content ; ./populate.sh)

(cd http-traffic; ./populate.sh)
