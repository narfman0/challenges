import unittest
from main import string_permutations


class TestMethods(unittest.TestCase):
    def test_prefix(self):
        with open('data.txt') as f:
            lines = f.readlines()
            self.assertEqual('aht,ath,hat,hta,tah,tha', string_permutations(lines[0]))
            self.assertEqual('abc,acb,bac,bca,cab,cba', string_permutations(lines[1]))
            self.assertEqual('6Zu,6uZ,Z6u,Zu6,u6Z,uZ6', string_permutations(lines[2]))


if __name__ == '__main__':
    unittest.main()
