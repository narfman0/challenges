import unittest
from main import function


class TestMethods(unittest.TestCase):
    def test_function(self):
        with open('input.txt') as f:
            input = f.read().splitlines()
        with open('output.txt') as f:
            output = f.read().splitlines()
        for i, o in zip(input, output):
            self.assertEqual(str(function(i)), o)


if __name__ == '__main__':
    unittest.main()
