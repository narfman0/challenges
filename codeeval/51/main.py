#!/bin/python
""" Code challenge https://www.codeeval.com/open_challenges/51/

Description:
Credits: Programming Challenges by Steven S. Skiena and Miguel A. Revilla

You will be given the x/y co-ordinates of several locations. You will be laying
out 1 cable between two of these locations. In order to minimise the cost, your
task is to find the shortest distance between a pair of locations, so that pair
can be chosen for the cable installation.  """
import sys


def function(lines):
    import pdb; pdb.set_trace()
    points = [(float(x), float(y)) for x,y in line.split(' ') for line in lines]
    return points


if __name__ == '__main__':
    exit_code = 0
    input_path = 'input.txt' if len(sys.argv) < 1 else sys.argv[1]
    with open(input_path) as f:
        lines = f.read().splitlines()
        while lines:
            count = int(lines[0])
            points = lines[1:count]
            lines = lines[count+1:]
            print(str(function(points)))
    sys.exit(exit_code)
