import urlparse
import sys
import json
import re
import os

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


# url_patter = re.compile('https?://')
with open(sys.argv[1]) as result_file:
  line = 0
  for content in result_file:
    line += 1

    if line % 1000 == 0:
      sys.stderr.write("%d\n" % line)

    m = re.match("""^\((hdfs.*),Success\((.*)\)\)$""", content)

    if m is None:
      sys.stderr.write("Couldn't parse the file. Is it an output of stringoid?\n")
      sys.exit(1)

    app = m.group(1)
    data = json.loads(m.group(2))
    results = data["result"]

    automata = []

    for (automaton, _) in results:
      count = 0
      for s in enumerate_automaton(automaton):
        count += 1
        if count >= 10000:
          sys.stderr.write(app + "\n")
          break
        pass

        try:
          p = urlparse.urlparse(s.encode('utf-8'))
          if not p.scheme or not str(p.netloc):
            continue
          print '%s;;;%s' % (os.path.basename(app), s.encode('utf-8'))
        except Exception, fffff:
          pass


        # if url_patter.match(s):
        #   print '%s;;;%s' % (app, s.encode('utf-8'))

      # print count
