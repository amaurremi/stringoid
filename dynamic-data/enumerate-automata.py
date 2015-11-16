import sys
import json
import re

def enumerate_automaton(automaton):
    initial = automaton["initial"]
    final = set(automaton["final"])

    constant_transitions = filter(lambda o: o["label"]["kind"] == "constant", automaton["transitions"])
    constant_transitions = map(lambda o : (o["src"], o["label"]["value"], o["dest"]), constant_transitions)

    variable_transitions = filter(lambda o: o["label"]["kind"] == "variable" or o["label"]["kind"] == "missing", automaton["transitions"])
    variable_transitions = list(set(map(lambda o: (o["src"], o["dest"]), variable_transitions)))


    return e(initial, final, constant_transitions, variable_transitions, "")
         
def e(at, final, ct, vt, prefix):
    if at in final:
        yield prefix

    for (s0, v, s1) in ct:
        if s0 == at:
            for r in e(s1, final, ct, vt, prefix + v):
                yield r

    for (s0, s1) in vt:
        if s0 == at:
            for r in e(s1, final, ct, vt, prefix + "___"):
                yield r

with open(sys.argv[1]) as result_file:
    content = result_file.read()
    m = re.match("""^\(hdfs.*,Success\((.*)\)\)$""", content)

    if m is None:
        sys.stderr.write("Couldn't parse the file. Is it an output of stringoid?\n")
        sys.exit(1)

    data = json.loads(m.group(1))
    results = data["result"]

    automata = []

    for (automaton, _) in results:
        for s in enumerate_automaton(automaton):
            print s
