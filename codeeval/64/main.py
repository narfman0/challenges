#!/bin/python
""" Code challenge https://www.codeeval.com/open_challenges/64/

Description:
You are climbing a stair case. It takes n steps to reach to the top. Each time
you can either climb 1 or 2 steps. In how many distinct ways can you climb to
the top?
"""
from functools import lru_cache
import sys


@lru_cache(maxsize=1000)
def climbing_stairs_neato_recursion_method(count):
    """ Return ways to climb count stairs. Maximum recursion can be hit easily, however. """
    if count <= 2:
        return count
    return climbing_stairs(count-1) + climbing_stairs(count-2)


results = {}
for i in range(0, 1000):
    if i<= 2:
        results[i] = i
    else:
        results[i] = results[i-2] + results[i-1]
def climbing_stairs(count):
    """ Return ways to climb count stairs """
    return results[count]


if __name__ == '__main__':
    exit_code = 0
    with open(sys.argv[1]) as f:
        for line in f.readlines():
            try:
                print(climbing_stairs(int(line)))
            except:
                exit_code = 1
                print('Failed to evaluate line: ' + line)
    sys.exit(exit_code)
