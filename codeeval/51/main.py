#!/bin/python
""" Code challenge https://www.codeeval.com/open_challenges/51/

Description:
Credits: Programming Challenges by Steven S. Skiena and Miguel A. Revilla

You will be given the x/y co-ordinates of several locations. You will be laying
out 1 cable between two of these locations. In order to minimise the cost, your
task is to find the shortest distance between a pair of locations, so that pair
can be chosen for the cable installation.  """
import itertools
import sys


def parse_points(lines):
    """ Parse points out of lines """
    for line in lines:
        x, y = line.split(' ')
        yield (float(x), float(y))


def function(lines):
    points = list(parse_points(lines))
    min_distance_squared = float("inf")
    for p1, p2 in itertools.combinations(points, 2):
        x1, y1 = p1
        x2, y2 = p2
        distance_squared = (x1 - x2) ** 2 + (y1 - y2) ** 2
        min_distance_squared = min(min_distance_squared, distance_squared)
    min_distance = min_distance_squared ** .5
    return "%.4f" % min_distance if min_distance <= 10000 else "INFINITY"


if __name__ == '__main__':
    exit_code = 0
    input_path = 'input.txt' if len(sys.argv) < 1 else sys.argv[1]
    with open(input_path) as f:
        lines = f.read().splitlines()
        while lines:
            count = int(lines[0])
            if count:
                points = lines[1:count+1]
                lines = lines[count+1:]
                print(str(function(points)))
            else:
                lines = []
    sys.exit(exit_code)
