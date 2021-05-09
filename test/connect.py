import errno
import socket
import sys
import time

if len(sys.argv)<2:
    print("usage: %s port" % sys.argv[0])
else:
    port= int(sys.argv[1])
    for i in range(65536):
        try:
            sock= socket.create_connection('localhost', port)
            print("connected", sock.getsockname(), sock.getpeername())
            time.sleep(60*60)
        except socket.error as e:
            if e.errno!= errno.ECONNREFUSED:
                break
