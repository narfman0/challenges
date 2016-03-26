#!/bin/python
""" Code challenge https://www.codeeval.com/open_challenges/30/

Description:
You are given two sorted list of numbers (ascending order). The lists
themselves are comma delimited and the two lists are semicolon delimited. Print
out the intersection of these two sets.
"""
import sys


def function(line):
    """ Return ways to climb count stairs. Maximum recursion can be hit easily,
    however.
    """
    set1, set2 = line[:-1].split(';')
    intersection = set(set2.split(',')) & set(set1.split(','))
    return ','.join(sorted(intersection))


if __name__ == '__main__':
    exit_code = 0
    with open(sys.argv[1]) as f:
        for line in f.readlines():
            try:
                print(function(line))
            except:
                exit_code = 1
                print('Failed to evaluate line: ' + line)
    sys.exit(exit_code)
