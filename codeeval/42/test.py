import unittest
from main import function


class TestMethods(unittest.TestCase):
    def test_searching(self):
        with open('data.txt') as f:
            lines = f.read().splitlines()
            self.assertEqual(0, function(lines[0]))
            self.assertEqual(1, function(lines[1]))
            self.assertEqual(6, function(lines[2]))
            self.assertEqual(64, function(lines[3]))
            for line in lines[4:]:
                function(line)


if __name__ == '__main__':
    unittest.main()
