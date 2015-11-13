import re

import urllib
import urlparse

def strip_port_number(url):
    pr = urlparse.urlparse(url)
    
    netloc = str(pr.netloc)
    n = re.match("""([^:]*)(:\d*)""", netloc)
    
    if n is None:
        return urlparse.urlunparse(pr)
    else:
        domain = n.group(1)
        #port   = int(n.group(2)[1:])
        parts = list(pr)
        parts[1] = domain # overwrites the original netloc
        return urlparse.urlunparse(parts)

if __name__ == "__main__":
    print strip_port_number("https://google.com:80/ping/pong")
    print strip_port_number("https//192.168.0.1")
    print strip_port_number("https://facebook.com:432/feed?show=true")
    print strip_port_number("https://angrybirds.com/wy?not")
