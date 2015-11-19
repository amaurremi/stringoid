import sys
import json
import os
import re
import subprocess
import urlparse

def urls_to_bits(urls):
    domains    = set([])
    paths      = set([])
    query      = set([])
    query_vals = set([])

    for url in urls:
        portless = re.sub(":[0-9]+/", "/", url)
        p = urlparse.urlparse(portless)
        if not p.scheme:
            continue

        domains.add(p.netloc)
        if p.path:
            paths.add((p.netloc, p.path))
        for k,v in urlparse.parse_qsl(p.query):
            query.add((p.netloc, k))
            query_vals.add((p.netloc, k, v))

    return (domains, paths, query, query_vals)

def bits_recall(urls, enumerated_file):
    enumerated = []

    with open(enumerated_file) as fp:
        for line in fp:
            enumerated.append(line[:-1])

    enumerated = set(enumerated)

    (ud, up, uq, uv) = urls_to_bits(urls)
    (sd, sp, sq, sv) = urls_to_bits(list(enumerated))

    def rec(s1, s2):
        if len(s1) == 0:
            return None

        return (len(s1), len(s1 & s2), float(len(s1 & s2)) / float(len(s1)))

    return {
        "in_requests" : {
            "domains" : len(ud),
            "paths"   : len(up),
            "query"   : len(uq),
            "values"  : len(uv)
        },
        "recalled" : {
            "domains" : rec(ud, sd),
            "paths"   : rec(up, sp),
            "query"   : rec(uq, sq),
            "values"  : rec(uv, sv)
        }
    }

def get_app_name(apk):
    proc = subprocess.Popen([ 'aapt', 'dump', 'badging', apk ], stdout=subprocess.PIPE)

    for line in proc.stdout:
        m = re.match("""application-label:'(.*)'$""", line)
        if m is not None:
            return m.group(1)

    return None

def pattern_to_regex(pattern):
    non_patterns = pattern.split("___")
    regex = ".*".join(map(lambda v : re.escape(v), non_patterns))

    if regex.startswith("https"):
        regex = "https?" + regex[5:]
    elif regex.startswith("http"):
        regex = "https?" + regex[4:]

    return "^%s$" % regex

def patterns_to_regexes(patterns):
    urls_only = filter(lambda u : u.lower().startswith("http"), patterns)
    non_empty_only = filter(lambda u : len(re.sub("[_/:?=&]", "", u)) > 5, urls_only)

    regexes = map(lambda u : pattern_to_regex(u), non_empty_only)
    prefix_regexes = map(lambda r : r[:-1], regexes)

    return (regexes, prefix_regexes)

def recall(urls, enumerated_file):
    enumerated = []

    with open(enumerated_file) as fp:
        for line in fp:
            enumerated.append(line[:-1])

    enumerated = set(enumerated)

    (regexes, prefix_regexes) = patterns_to_regexes(list(enumerated))

    exact_matches = 0
    full_matches = 0
    prefix_matches = 0 
    unmatched = []

    for url in urls:
        portless = re.sub(":[0-9]+/", "/", url)

        found_exact = False
        found_full = False
        found_prefix = False

        if portless in enumerated or url in enumerated:
            found_exact = True

        longest = ""
        for r in regexes:
            if re.match(r, portless) is not None or re.match(r, url) is not None:
                if len(r) > len(longest):
                    longest = r
                found_full = True

        for r in prefix_regexes:
            if re.match(r, portless) is not None or re.match(r, url) is not None:
                found_prefix = True

        if found_exact:
            exact_matches += 1
        elif found_full:
            #print longest
            full_matches += 1
        elif found_prefix:
            prefix_matches += 1
        else:
            unmatched.append(url)

    return (exact_matches, full_matches, prefix_matches, unmatched)

if __name__ == "__main__":
    if len(sys.argv) != 2:
        sys.stderr.write("Please provide an app.\n")
        sys.exit(1)

    quasi_app = sys.argv[1]

    base = os.path.basename(quasi_app)
    if base.endswith(".apk"):
        base = base[:-4]

    apk_file = "./apps/%s.apk" % base
    classified_file = "./classified/%s.json" % base
    enumerated_file = "./enumerated/%s.urls" % base

    app_name = get_app_name(apk_file)

    results = {}
    results["apk"] = apk_file
    results["app_name"] = app_name

    with open(classified_file) as cfp:
        classified_data = json.load(cfp)

    results["requests"] = classified_data["total"]
    results["unique_requests"] = classified_data["unique"]
    results["from_static_content"] = classified_data["in_static"]
    results["from_responses_auto"] = classified_data["in_response_exact"]
    results["from_responses_manual"] = classified_data["in_response_confirmed"]
    results["from_app"] = len(classified_data["unattributed"])

    (exact_matches, full_matches, prefix_matches, unmatched) = recall(classified_data["unattributed"], enumerated_file)

    results["stringoid_matches"] = {
        "exact" : exact_matches,
        "pattern_full" : full_matches,
        "pattern_prefix" : prefix_matches
    }

    results["url_elements"] = bits_recall(classified_data["unattributed"], enumerated_file)

    print json.dumps(results, indent=2)
