#!/bin/python
""" Code challenge https://www.codeeval.com/open_challenges/72/

Description:
You are given an n*n matrix of integers. You can move only right and down.
Calculate the minimal path sum from the top left to the bottom right
"""
import itertools
import sys


def parse_matrix(lines):
    """ Parse matrix from lines """
    matrix = [l.split(',') for l in lines]
    n = len(matrix)
    for i in range(n):
        for j in range(n):
            matrix[i][j] = int(matrix[i][j])
    return matrix, n


def function(lines):
    """ Probably the best way to approach this: generate the last value. From
    that, we may generate the nth row and nth column since it could then only
    be reached going right or down. This will be simple adding, and we could
    follow this pattern up the diagonal only and calculate the rest quite fast.
    """
    #
    matrix, n = parse_matrix(lines)
    minimal = [[0]*n for _ in range(n)]
    minimal[n-1][n-1] = matrix[n-1][n-1]
    for d in range(n, 0, -1):
        # get diagonal value
        minimal[d-1][d-1] = matrix[d-1][d-1]
        import pdb; pdb.set_trace()
        # get vertical values
        for v in range(d, 1, -1):
            value = matrix[d-v-1][d-1] + min(matrix[d-v-1][d-2], matrix[d-v-2][d-1])
            minimal[d-v-1][d-1] = value
        # get horizontal values
        for h in range(d, 1, -1):
            value = matrix[d-1][d-h-1] + min(matrix[d-2][d-h-1], matrix[d-1][d-h-2])
            minimal[d-1][d-v-1] = value
    return minimal[0][0]


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
