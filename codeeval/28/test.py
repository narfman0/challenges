import unittest
from main import string_searching


class TestMethods(unittest.TestCase):
    def test_searching(self):
        with open('data.txt') as f:
            lines = f.readlines()
            self.assertEqual('true', string_searching(lines[0]))
            self.assertEqual('true', string_searching(lines[1]))
            self.assertEqual('true', string_searching(lines[2]))
            self.assertEqual('false', string_searching(lines[3]))


if __name__ == '__main__':
    unittest.main()
