#!/bin/python
""" Code challenge https://www.codeeval.com/open_challenges/83/

Description:

Your program should accept as its first argument a path to a filename. Each line
in this file has a sentence
"""
import re
import sys


def beauty(source):
    """ When John was a little kid he didn't have much to do. There was no
    internet, no Facebook, and no programs to hack on. So he did the only thing
    he could... he evaluated the beauty of strings in a quest to discover the
    most beautiful string in the world.

    Given a string s, little Johnny defined the beauty of the string as the sum
    of the beauty of the letters in it. The beauty of each letter is an integer
    between 1 and 26, inclusive, and no two letters have the same beauty. Johnny
    doesn't care about whether letters are uppercase or lowercase, so that
    doesn't affect the beauty of a letter. (Uppercase 'F' is exactly as
    beautiful as lowercase 'f', for example.)

    You're a student writing a report on the youth of this famous hacker. You
    found the string that Johnny considered most beautiful. What is the maximum
    possible beauty of this string?
    """
    characters = "".join(re.findall("[a-zA-Z]+", source)).lower()
    character_map = {}
    for char in characters:
        character_map[char] = character_map.get(char, 0) + 1
    i = 26
    totals = []
    for char in sorted(character_map.values(), reverse=True):
        totals.append(char * i)
        i = i-1
    return sum(totals)


if __name__ == '__main__':
    with open(sys.argv[1]) as f:
        for line in f.readlines():
            print(str(beauty(line)))
