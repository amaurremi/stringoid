#!/usr/bin/env bash

for app in ./apps/*.apk; do
    python recall.py $app;
done

(cd recall-results; python format.py)
