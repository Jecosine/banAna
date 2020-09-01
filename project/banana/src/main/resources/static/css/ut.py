import pprint
'''
Date: 2020-08-29 11:07:54
LastEditors: Jecosine
LastEditTime: 2020-08-29 11:23:21
'''
class Solution:
    """
    @param s: a string.
    @return: return the values of all the intervals.
    """
    def calc(self, a, s, i, j):
        if i == j:
            a[i][j] = 1
            return 1
        delta = j - i + 1
        c = 0
        mid = delta // 2
        for x in range(mid):
            if s[i + x] == s[j - x]: 
                c += 1
        a[i][j] = c
        return a[i][j]
        
    def suffixQuery(self, s):
        # write your code here
        l = len(s)
        a = [[-1 for i in range(l)] for i in range(l)]
        sm = 0
        for i in range(l):
            for j in range(i, l):
                sm += self.calc(a, s, i, j)
        

        pprint.pprint(a)

        return sm

t = Solution()
print(t.suffixQuery("bacbdab"))
