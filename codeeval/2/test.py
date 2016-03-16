import unittest
from main import longest_lines


class TestMethods(unittest.TestCase):
    def test_longest_lines(self):
        with open('test_data.txt') as f:
            result = longest_lines(f)
            self.assertEqual(2, len(result))
            self.assertEqual(result[0], 'San Francisco')
            self.assertEqual(result[1], 'Hello World')


if __name__ == '__main__':
    unittest.main()
