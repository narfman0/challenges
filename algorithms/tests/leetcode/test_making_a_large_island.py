from unittest import TestCase

from algorithms.leetcode import making_a_large_island as m

CASES = [
    ([[1, 0], [0, 1]], 3),
    ([[1, 1], [1, 0]], 4),
    ([[1, 1], [1, 1]], 4),
    (
        [
            [0, 0, 0, 0, 0, 0, 0],
            [0, 1, 1, 1, 1, 0, 0],
            [0, 1, 0, 0, 1, 0, 0],
            [1, 0, 1, 0, 1, 0, 0],
            [0, 1, 0, 0, 1, 0, 0],
            [0, 1, 0, 0, 1, 0, 0],
            [0, 1, 1, 1, 1, 0, 0],
        ],
        18,
    ),
]


class TestMakingALargeIsland(TestCase):
    def test_largest_island(self):
        for testcase, expected in CASES:
            self.assertEqual(expected, m.Solution().largestIsland(testcase))
