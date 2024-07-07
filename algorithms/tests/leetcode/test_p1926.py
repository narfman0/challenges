from unittest import TestCase

from algorithms.leetcode import p1926


class TestP1926(TestCase):
    def test_nearest_exit_1(self):
        maze = [["+", "+", ".", "+"], [".", ".", ".", "+"], ["+", "+", "+", "."]]
        entrance = [1, 2]
        self.assertEqual(1, p1926.Solution().nearestExit(maze, entrance))

    def test_nearest_exit_2(self):
        maze = [["+", "+", "+"], [".", ".", "."], ["+", "+", "+"]]
        entrance = [1, 2]
        self.assertEqual(2, p1926.Solution().nearestExit(maze, entrance))

    def test_nearest_exit_3(self):
        maze = [[".", "+"]]
        entrance = [0, 0]
        self.assertEqual(-1, p1926.Solution().nearestExit(maze, entrance))
