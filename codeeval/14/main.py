#!/bin/python
""" Code challenge https://www.codeeval.com/open_challenges/14/

Description:

Write a program which prints all the permutations of a string in alphabetical
order. We consider that digits < upper case letters < lower case letters. The
sorting should be performed in ascending order.
"""
import itertools
import sys


def string_permutations(line):
    """ Return permutations of string, comma delimited """
    sorted_line = sorted(line.strip())
    permutations = [''.join(p) for p in itertools.permutations(sorted_line)]
    return ','.join(permutations)


if __name__ == '__main__':
    exit_code = 0
    with open(sys.argv[1]) as f:
        for line in f.readlines():
            try:
                print string_permutations(line)
            except:
                exit_code = 1
                print 'Failed to evaluate line: ' + line
    sys.exit(exit_code)
