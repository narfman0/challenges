import unittest
from main import beauty


class TestStringMethods(unittest.TestCase):
    def test_beauty(self):
      self.assertEqual(152, beauty('ABbCcc'))
      self.assertEqual(754, beauty('Good luck in the Facebook Hacker Cup this year!'))
      self.assertEqual(491, beauty('Ignore punctuation, please :)'))
      self.assertEqual(729, beauty('Sometimes test cases are hard to make up.'))
      self.assertEqual(646, beauty('So I just go consult Professor Dalves'))


if __name__ == '__main__':
    unittest.main()
