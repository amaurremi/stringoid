#
# Script to format output from mitmdump.
# 
# Use via `-s format_output.py <output-file>`
#
from libmproxy.models import decoded

def start(context, argv):
  # Called once on startup, before any other events.

  # extract output file:
  if len(argv) != 2:
    raise ValueError('Usage: -s "format_output.py <output-file>"')

  context.output_file = argv[1]
  context.output_file_content = '.'.join(argv[1].split('.')[:-1]) + '_content.' + argv[1].split('.')[-1]

  # write header:
  with open(context.output_file, "w") as f:
    f.write("req_start_time;;;res_end_time;;;status_code;;;method;;;content_type;;;req_uri\n")
  return


def request(context, flow):
  # extract req data:
  context.req_uri = "%s://%s:%s%s" % (flow.request.scheme, flow.request.host, flow.request.port, flow.request.path)
  context.req_start_time = flow.request.timestamp_start
  context.method = flow.request.method
  
  print 
  print '\n%s' % context.req_uri


def response(context, flow):
  # extract res data:
  context.res_end_time = flow.response.timestamp_end
  context.status_code = flow.response.status_code
  context.content_type = ""
  try:
    context.content_type = flow.response.headers.get("content-type")
    if context.content_type is not None:
      context.content_type = context.content_type.replace(' ', '')
      context.content_type = ','.join(context.content_type.split(';'))
    else:
      context.content_type = ""
  except IndexError:
    pass

  # log request:
  print_line(context.output_file, 
    context.req_start_time, 
    context.res_end_time,
    context.status_code,
    context.method,
    context.content_type,
    context.req_uri)

  # print content to file:
  print_content_line(context.output_file_content,
    context.req_start_time, 
    context.res_end_time,
    context.status_code,
    context.method,
    context.content_type,
    context.req_uri,
    flow.response)
  return


def isprintable(s, codec='utf8'):
  try: 
    s.decode(codec)
  except UnicodeDecodeError:
    return False
  else: 
    return True


def serverdisconnect(context, server_conn):
  print_line(context.output_file, 
    context.req_start_time, 
    '',
    'SERVERDISCONNECT',
    context.method,
    '',
    context.req_uri)

  print_content_line(context.output_file_content,
    context.req_start_time, 
    '',
    'SERVERDISCONNECT',
    context.method,
    '',
    context.req_uri,
    'SERVERDISCONNECT')
  return


def clientdisconnect(context, root_layer):
  print_line(context.output_file, 
    context.req_start_time, 
    '',
    'CLIENTDISCONNECT',
    context.method,
    '',
    context.req_uri)

  print_content_line(context.output_file_content,
    context.req_start_time, 
    '',
    'CLIENTDISCONNECT',
    context.method,
    '',
    context.req_uri,
    'CLIENTDISCONNECT')
  return


def error(context, flow):
  print_line(context.output_file, 
    context.req_start_time, 
    '',
    'ERROR',
    context.method,
    '',
    context.req_uri)

  print_content_line(context.output_file_content,
    context.req_start_time, 
    '',
    'ERROR',
    context.method,
    '',
    context.req_uri,
    'ERROR')
  return



def print_line(file_name, req_start_time, res_end_time, status_code, method, content_type, req_uri):
  with open(file_name, "a") as f:
    f.write("%s;;;%s;;;%s;;;%s;;;%s;;;%s\n" % (req_start_time, res_end_time, status_code, method, content_type, req_uri))


def print_content_line(file_name, req_start_time, res_end_time, status_code, method, content_type, req_uri, flow_response):
  with open(file_name, "a") as f:
    f.write("\n\n\n")
    f.write("---%s;;;%s;;;%s;;;%s;;;%s;;;%s\n" % (req_start_time, res_end_time, status_code, method, content_type, req_uri))
    f.write("\n\n")
    if isinstance(flow_response, basestring):
      try:
        f.write(flow_response)
      except Exception, e:
        f.write('exception: %s' % str(e))
        pass
    else:
      with decoded(flow_response):  # automatically decode gzipped responses.
        if isprintable(flow_response.content):
          try:
            s = flow_response.content #cStringIO.StringIO(flow.response.content)
            f.write(s)
          except Exception, e:
            f.write('exception: %s' % str(e))
            pass
