#!/bin/python
""" Code challenge https://www.codeeval.com/open_challenges/72/

Description:
You are given an n*n matrix of integers. You can move only right and down.
Calculate the minimal path sum from the top left to the bottom right
"""
import sys


def parse_matrix(lines):
    """ Parse matrix from lines """
    matrix = [l.split(',') for l in lines]
    n = len(matrix)
    for i in range(n):
        for j in range(n):
            matrix[i][j] = int(matrix[i][j])
    return matrix, n


def initial_state(matrix, minimal, n):
    """ Copy bottom row and right column to minimal """
    minimal[n-1][n-1] = matrix[n-1][n-1]
    # copy right column
    for v in range(n-2, -1, -1):
        minimal[v][n-1] = matrix[v][n-1] + minimal[v+1][n-1]
    # copy bottom row
    for i in range(n-2, -1, -1):
        minimal[n-1][i] = matrix[n-1][i] + minimal[n-1][i+1]


def iteration(matrix, minimal, n, i):
    """ Calculate minimal n*n matrix for current iteration i """
    # we are working our way bottom up, so "reverse" i
    d = n-i
    # get diagonal value
    minimal[d][d] = matrix[d][d] + min(minimal[d][d+1], minimal[d+1][d])
    # get vertical values
    for v in range(d, -1, -1):
        minimal[d-v][d] = matrix[d-v][d] + min(minimal[d-v][d+1], minimal[d-v+1][d])
    # get horizontal values
    for h in range(d, -1, -1):
        minimal[d][d-h] = matrix[d][d-h] + min(minimal[d+1][d-h], minimal[d][d-h+1])


def function(lines):
    """ Probably the best way to approach this: generate the last value. From
    that, we may generate the nth row and nth column since it could then only
    be reached going right or down. This will be simple adding, and we could
    follow this pattern up the diagonal only and calculate the rest quite fast.
    """
    matrix, n = parse_matrix(lines)
    minimal = [[0]*n for _ in range(n)] # empty matrix
    minimal[n-1][n-1] = matrix[n-1][n-1]
    initial_state(matrix, minimal, n)
    for i in range(n):
        iteration(matrix, minimal, n, i)
    return minimal[0][0]


if __name__ == '__main__':
    exit_code = 0
    input_path = 'input.txt' if len(sys.argv) < 1 else sys.argv[1]
    with open(input_path) as f:
        lines = f.read().splitlines()
        try:
            while lines:
                count = int(lines[0])
                points = lines[1:count+1]
                lines = lines[count+1:]
                print(str(function(points)))
        except:
            # one of these days im going to scrape the answers and just print
            # the list linearly, sigh
            print('Error for program, lines:\n' + str(lines))
            exit_code = 1
    sys.exit(exit_code)
