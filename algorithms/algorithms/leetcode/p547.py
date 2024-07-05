from typing import List


class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        n = len(isConnected)
        province_count = n
        city_to_province = {}
        for i in range(n):
            province = set()
            province.add(i)
            city_to_province[i] = province
        for i in range(n):
            for j in range(i + 1, n):
                if isConnected[i][j] and city_to_province[j] != city_to_province[i]:
                    for city in city_to_province[j]:
                        city_to_province[i].add(city)
                    # Update each city pointing to this set to the new one
                    old_province = city_to_province[j]
                    for k in range(n):
                        if city_to_province[k] == old_province:
                            city_to_province[k] = city_to_province[i]

                    province_count -= 1
                    print(f"Connected {i} with {j}, {province_count} provinces remain")
        return province_count
