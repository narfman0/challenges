import unittest
from main import prefix


class TestMethods(unittest.TestCase):
    def test_prefix(self):
        with open('data.txt') as f:
            lines = f.readlines()
            self.assertEqual(122, prefix(lines[0]))
            self.assertEqual(0, prefix(lines[1]))
            self.assertEqual(20, prefix(lines[2]))


if __name__ == '__main__':
    unittest.main()
