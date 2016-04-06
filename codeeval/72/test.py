import unittest
from main import iteration, initial_state


class TestMethods(unittest.TestCase):
    def setUp(self):
        self.matrix = [
            [1,2,3],
            [4,5,6],
            [7,8,9]]
        self.minimal = [
            [0,0,0],
            [0,0,0],
            [0,0,0]]
        self.end = [
            [21,20,18],
            [24,20,15],
            [24,17,9]]
        self.n = len(self.matrix)

    def test_initial_state(self):
        initial_state(self.matrix, self.minimal, self.n)
        self.assertEqual(self.minimal[0][0], 0)
        self.assertEqual(self.minimal[0][1], 0)
        self.assertEqual(self.minimal[0][2], self.end[0][2])
        self.assertEqual(self.minimal[1][0], 0)
        self.assertEqual(self.minimal[1][1], 0)
        self.assertEqual(self.minimal[1][2], self.end[1][2])
        self.assertEqual(self.minimal[2][0], self.end[2][0])
        self.assertEqual(self.minimal[2][1], self.end[2][1])
        self.assertEqual(self.minimal[2][2], self.end[2][2])

    def test_iteration(self):
        initial_state(self.matrix, self.minimal, self.n)
        iteration(self.matrix, self.minimal, self.n, 2)
        self.assertEqual(self.minimal[0][0], 0)
        self.assertEqual(self.minimal[0][1], self.end[0][1])
        self.assertEqual(self.minimal[1][0], self.end[1][0])
        self.assertEqual(self.minimal[1][1], self.end[1][1])
        iteration(self.matrix, self.minimal, self.n, 3)
        self.assertEqual(self.minimal[0][0], self.end[0][0])


if __name__ == '__main__':
    unittest.main()
