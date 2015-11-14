import sys
import json
import re

def accepts(automaton, string):
    at_states = [ automaton["initial"] ]
    final_states = set(automaton["final"])

    constant_transitions = filter(lambda o: o["label"]["kind"] == "constant", automaton["transitions"])
    constant_transitions = map(lambda o : (o["src"], o["label"]["value"], o["dest"]), constant_transitions)

    # FIXME this currently covers variable | cycle | missing, is that OK?
    variable_transitions = filter(lambda o: o["label"]["kind"] != "constant", automaton["transitions"])
    variable_transitions = list(set(map(lambda o: (o["src"], o["dest"]), variable_transitions)))

    # print json.dumps(constant_transitions)

    next_states_following_constants = []
    for at_state in at_states:
        for (s0, v, s1) in constant_transitions:
            if string.startswith(v):
                next_states_following_constants.append((v, s1))

    next_states_following_variable = []
    for at_state in at_states:
        for (s0, s1) in variable_transitions:
            next_states_following_variable.append(s1)

    print set(next_states_following_constants)
    #print set(next_states_following_variable)
    return None
    

with open(sys.argv[1]) as result_file:
    content = result_file.read()
    m = re.match("""^\(hdfs.*,Success\((.*)\)\)$""", content)

    if m is None:
        sys.stderr.write("Couldn't parse the file. Is it an output of stringoid?\n")
        sys.exit(1)

    data = json.loads(m.group(1))
    results = data["result"]

    automata = []

    for (automaton, method) in results:
        automata.append(automaton)

    URL = """http://www.beyondpod.mobi/api/feedPublishers?type=2&start=0&take=80"""

    for automaton in automata:
        accepts(automaton, URL)

