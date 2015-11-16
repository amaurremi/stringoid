import sys
import json
import os
import re

def app_to_paths(quasi_name):
    base = os.path.basename(quasi_name)

    if base.endswith(".apk"):
        base = base[:-4]

    request_file   = "./http-traffic/%s.txt" % base
    response_file  = "./http-traffic/%s_responses.txt" % base
    static_file    = "./static-app-content/%s.content" % base
    automaton_file = "./automata/%s.automaton" % base

    return {
        "request_file"   : request_file,
        "response_file"  : response_file,
        "static_file"    : static_file,
        "automaton_file" : automaton_file
    }

def load_requests(request_file):
    rs = []
    with open(request_file) as rf:
        for line in rf:
            m = re.match("""^.*;;;(http.*)$""", line[:-1])
            if m is not None:
                rs.append(m.group(1))

    return rs

def load_file(path):
    with open(path) as fp:
        return fp.read()

def load_app_data(paths):
    obj = {}

    obj["requests"] = load_requests(paths["request_file"])
    obj["unique_requests"] = list(set(obj["requests"]))

    obj["static_content"] = load_file(paths["static_file"])
    obj["response_content"] = load_file(paths["response_file"])

    return obj

def attribute(obj):
    in_static = 0
    in_responses = 0
    in_none = []

    static   = obj["static_content"]
    response = obj["response_content"]


    for request in obj["unique_requests"]:
        found = False
        portless = re.sub(":[0-9]+/", "/", request)

        if request in static or portless in static:
            in_static += 1
            found = True

        if request in response or portless in response:
            in_responses += 1
            found = True

        if not found:
            in_none.append(request)

    return {
        "request_count"        : len(obj["requests"]),
        "unique_request_count" : len(obj["unique_requests"]),
        "in_static"            : in_static,
        "in_responses"         : in_responses,
        "not_found"            : in_none
    }

if __name__ == "__main__":
    if len(sys.argv) != 2:
        sys.stderr.write("Usage: %s app.apk.\n" % sys.argv[0])
        sys.exit(1)

    paths = app_to_paths(sys.argv[1])
    data  = load_app_data(paths)

    attributed = attribute(data)

    for nf in attributed["not-found"]:
        print nf
