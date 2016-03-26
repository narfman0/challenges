import unittest
from main import function


class TestMethods(unittest.TestCase):
    def test_searching(self):
        with open('data.txt') as f:
            lines = f.readlines()
            self.assertEqual('4', function(lines[0]))
            self.assertEqual('', function(lines[1]))
            self.assertEqual('8,9', function(lines[2]))


if __name__ == '__main__':
    unittest.main()
