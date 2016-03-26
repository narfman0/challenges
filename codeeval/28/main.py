#!/bin/python
""" Code challenge https://www.codeeval.com/open_challenges/28/

Description:
You are given two strings. Determine if the second string is a substring of the
first (Do NOT use any substr type library function). The second string may
contain an asterisk(*) which should be treated as a regular expression i.e.
matches zero or more characters. The asterisk can be escaped by a \ char in
which case it should be interpreted as a regular '*' character. To summarize:
the strings can contain alphabets, numbers, * and \ characters.
"""
import re
import sys


def string_searching(line):
    """ Return permutations of string, comma delimited """
    first, second = line[:-1].split(',')
    second = second.replace('\\', '').replace('*', r'.*')
    return str(bool(re.search(second, first))).lower()


if __name__ == '__main__':
    exit_code = 0
    with open(sys.argv[1]) as f:
        for line in f.readlines():
            try:
                print string_searching(line)
            except:
                exit_code = 1
                print 'Failed to evaluate line: ' + line
    sys.exit(exit_code)
