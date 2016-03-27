#!/bin/python
""" Code challenge https://www.codeeval.com/open_challenges/42/

Description:
Once upon a time in a strange situation, people called a number ugly if it was
divisible by any of the one-digit primes (2, 3, 5 or 7). Thus, 14 is ugly, but
13 is fine. 39 is ugly, but 121 is not. Note that 0 is ugly. Also note that
negative numbers can also be ugly: -14 and -39 are examples of such numbers.

One day on your free time, you are gazing at a string of digits, something like:

123456

You are amused by how many possibilities there are if you are allowed to insert
plus or minus signs between the digits. For example you can make:

1 + 234 - 5 + 6 = 236

which is ugly. Or

123 + 4 - 56 = 71

which is not ugly.

It is easy to count the number of different ways you can play with the digits:
Between each two adjacent digits you may choose put a plus sign, a minus sign,
or nothing. Therefore, if you start with D digits there are 3^(D-1) expressions
you can make. Note that it is fine to have leading zeros for a number. If the
string is '01023', then '01023', '0+1-02+3' and '01-023' are legal expressions.

Your task is simple: Among the 3^(D-1) expressions, count how many of them
evaluate to an ugly number.
"""
import re
import sys


def is_ugly(number):
    """ Return true if a number is ugly, false if not """
    for prime in (2, 3, 5, 7):
        if number % prime == 0:
            return True
    return number == 0


zero_replacer = re.compile(r'\b0+(?!\b)')
def create_potential(used, manual=False):
    """ Generate and evaluate possibly ugle expression
    Arguments
        manual: If we should parse manually or use a regex
    """
    if manual:
        # eval appears to interpret leading 0s as octal, workaround is lstrip
        parts = [p.lstrip('0') for p in used.split('*')]
        parts = ['0' if not p else p for p in parts]
        return eval(''.join(parts))
    return eval(re.sub(zero_replacer, '', used))


def function(unused, used=''):
    uglies = 0
    if unused:
        if used:
            for action in ('', '-', '+'):
                uglies += function(unused[1:], used + action + unused[0])
        else:
            uglies += function(unused[1:], unused[0])
    else:
        if is_ugly(create_potential(used)):
            return 1
    return uglies


if __name__ == '__main__':
    exit_code = 0
    with open(sys.argv[1]) as f:
        for line in f.read().splitlines():
            try:
                print(function(line))
            except:
                exit_code = 1
                print('Failed to evaluate line: ' + line)
    sys.exit(exit_code)
