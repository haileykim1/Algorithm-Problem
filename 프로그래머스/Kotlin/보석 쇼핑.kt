class Solution {
    var gemArr = intArrayOf()
    var gemCnt = 0
    
    fun HasAllGem():Boolean{
        var ret = true
        for(i in 0..gemCnt - 1){
            if(gemArr[i] == 0){
                ret = false
                break
            }
        }
        return ret
    }
    
    fun solution(gems: Array<String>): IntArray {
        
        var gemMap = HashMap<String, Int>()
        var part = ArrayList<Pair<Int, Int>>()
        gems.forEach{
            if(!gemMap.containsKey(it))
                gemMap.put(it, gemCnt++)
        }
        gemArr = IntArray(gemCnt){0}
        
        var start = 0
        var end = 0
        
        while(end < gems.size + 1){
            if(HasAllGem()){
                part.add(Pair(start, end))
                gemArr[gemMap[gems[start++]]!!]--
            }else{
                if(end <= gems.size - 1)
                    gemArr[gemMap[gems[end]]!!]++
                ++end
            }
        }
        part.sortWith(Comparator{o1, o2 -> (o1.second - o1.first) - (o2.second - o2.first)})
        var answer = intArrayOf(part[0].first + 1, part[0].second)
        return answer
    }
}