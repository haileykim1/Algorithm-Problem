import kotlin.math.min

class Solution {
    var minOps = Array(9){ArrayList<Int>()}
    
    
    fun solution(N: Int, number: Int): Int {
        var temp = 0
        
        for(i in 1..8){
            temp = temp * 10 + N
            minOps[i].add(temp)
            
            for(j in 1..i - 1){
                minOps[j].forEach{
                    for(k in 0..minOps[i - j].size - 1){
                        if(it + minOps[i - j][k] != 0)
                            minOps[i].add(it + minOps[i - j][k])
                        if(it - minOps[i - j][k] != 0)
                            minOps[i].add(it - minOps[i - j][k])
                        if(it * minOps[i - j][k] != 0)
                            minOps[i].add(it * minOps[i - j][k])
                        if(it / minOps[i - j][k] != 0)
                            minOps[i].add(it / minOps[i - j][k])
                    }
                }
            }
            
            if(minOps[i].contains(number))
                return i
        }
        return -1
    }
}