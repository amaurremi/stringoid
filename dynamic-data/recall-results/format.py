import json
import glob

def rec(i,j):
    if i == 0:
        return "-"
    else:
        return "%d/%d" % (j, i)

def rec2(i,j):
    return "%d/%d+%d" % (j[0], i, j[1])

def no_zero(i):
    if i == 0:
        return '-'
    else:
        return str(i)

if __name__ == "__main__":
    manually      = 0
    automatically = 0

    print '%-35s, %s, %s, %s, %s, %s, %s, %s, %s, %11s, %11s, %11s, %11s' % (
        '"Name"',
        '"Requests"',
        '"Uniques"',
        '"Static"',
        '"Responses"',
        '"Stringoid"',
        '"Exact"',
        '"Regex"',
        '"Prefix"',
        '"Domains"',
        '"Paths"',
        '"Params"',
        '"Values"'
    )

    for f in glob.glob("*.json"):
        with open(f) as fp:
            d = json.load(fp)

            elems = d["url_elements"]

            print '%-35s, %10d, %9d, %8s, %11d, %11s, %7d, %7d, %8d, %11s, %11s, %11s, %11s' % (
                '"' + d["app_name"] + '"',
                d["requests"],
                d["unique_requests"],
                no_zero(d["from_static_content"]),
                d["from_responses_auto"] + d["from_responses_manual"],
                rec(d["from_app"],
                    d["stringoid_matches"]["exact"] +
                    d["stringoid_matches"]["pattern_full"] +
                    d["stringoid_matches"]["pattern_prefix"]),
                d["stringoid_matches"]["exact"],
                d["stringoid_matches"]["pattern_full"],
                d["stringoid_matches"]["pattern_prefix"],
                rec2(elems["in_requests"]["domains"], elems["recalled"]["domains"]),
                rec2(elems["in_requests"]["paths"], elems["recalled"]["paths"]),
                rec2(elems["in_requests"]["query"], elems["recalled"]["query"]),
                rec2(elems["in_requests"]["values"], elems["recalled"]["values"])
            )


            automatically += d["from_responses_auto"]
            manually += d["from_responses_manual"]
            manually += d["from_app"]

    print "Automatically classified: %d" % automatically
    print "Manually classified     : %d" % manually 

