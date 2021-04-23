class Solution {
    val steps = LongArray(2001){-1}
    
    fun Hop(x:Int):Long{
        if(steps[x] >= 0)
            return steps[x]
        steps[x] = (Hop(x - 1) + Hop(x - 2)) % 1234567
        return steps[x]
    }
    
    fun solution(n: Int): Long {
        var answer: Long = 0
        steps[0] = 1
        steps[1] = 1
        return Hop(n)
    }
}