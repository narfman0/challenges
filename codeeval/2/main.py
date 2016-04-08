#!/bin/python
""" Code challenge https://www.codeeval.com/open_challenges/2/

Description:

Write a program which reads a file and prints to stdout the specified number of
the longest lines that are sorted based on their length in descending order.
Input sample:

Your program should accept a path to a file as its first argument. The file
contains multiple lines. The first line indicates the number of lines you should
output, the other lines are of different length and are presented randomly. You
may assume that the input file is formatted correctly and the number in the
first line is a valid positive integer.
"""
import sys
from operator import itemgetter


def longest_lines(f):
    """ Print specified count of longest lines """
    # parse file
    contents = f.readlines()
    count = int(contents[0])
    # run logic
    lengths = []
    for line in contents[1:]:
        lengths.append( (line.strip(), len(line)) )
    results = sorted(lengths, key=itemgetter(1), reverse=True)
    return [result[0] for result in results[:count]]


if __name__ == '__main__':
    with open(sys.argv[1]) as f:
        for result in longest_lines(f):
            print(result)
