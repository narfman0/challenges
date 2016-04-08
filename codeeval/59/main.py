#!/bin/python
""" Code challenge https://www.codeeval.com/open_challenges/59/

Description:

Given a 7 digit telephone number, print out all the possible sequences of
letters that can represent the given telephone number. Note that in a standard
12 key pad, 0 and 1 do not have any letters associated with them. They are to be
treated as such, i.e. a 0/1 in the telephone number will be retained in the
final word as well. You may use the following mapping between numbers and
characters.
"""
import itertools
import sys


CHARACTERS = {
    '0': '0',
    '1': '1',
    '2': 'abc',
    '3': 'def',
    '4': 'ghi',
    '5': 'jkl',
    '6': 'mno',
    '7': 'pqrs',
    '8': 'tuv',
    '9': 'wxyz',
}


def telephone_words(line):
    """ Return permutations of telephone number character mappings, comma
    delimited.

    Args:
        line: the number e.g. '4155230'
    """
    # get the different number combos it could be as a list
    potentials = [CHARACTERS[c] for c in line.strip()]
    # take cartesian product
    product = itertools.product(*potentials)
    # join products and return comma separated list
    return ','.join([''.join(s) for s in product])


if __name__ == '__main__':
    exit_code = 0
    with open(sys.argv[1]) as f:
        for line in f.readlines():
            try:
                print(telephone_words(line))
            except:
                exit_code = 1
                print('Failed to evaluate line: ' + line)
    sys.exit(exit_code)
