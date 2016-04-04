#!/bin/python
""" Code challenge https://www.codeeval.com/open_challenges/72/

Description:
You are given an n*n matrix of integers. You can move only right and down.
Calculate the minimal path sum from the top left to the bottom right
"""
import itertools
import sys


def function(lines):
    matrix = [l.split(',') for l in lines]
    """ Probably the best way to approach this: generate the last value. From
    that, we may generate the nth row and nth column since it could then only
    be reached going right or down. This will be simple adding, and we could
    follow this pattern up the diagonal only and calculate the rest quite fast.
    """
    return 1


if __name__ == '__main__':
    exit_code = 0
    input_path = 'input.txt' if len(sys.argv) < 1 else sys.argv[1]
    with open(input_path) as f:
        lines = f.read().splitlines()
        while lines:
            count = int(lines[0])
            points = lines[1:count+1]
            lines = lines[count+1:]
            print(str(function(points)))
    sys.exit(exit_code)
