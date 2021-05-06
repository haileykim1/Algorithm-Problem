import kotlin.math.abs

class Solution {
    fun solution(numbers: IntArray, hand: String): String {
        var answer = ""
        var leftNum = arrayOf(1, 4, 7)
        var rightNum = arrayOf(3, 6, 9)
        var nowLeft = Pair(1, 4)
        var nowRight = Pair(3, 4)
        var midMap = hashMapOf(2 to 1, 5 to 2, 8 to 3, 0 to 4)
        
        numbers.forEach{
            if(leftNum.contains(it)){
                answer += "L"
                nowLeft = Pair(1, (it + 2) / 3)
            }
            else if(rightNum.contains(it)){
                answer += "R"
                nowRight = Pair(3, it / 3)
            }
            else{
                val now = midMap[it]!!
                val leftDist = (2 - nowLeft.first) + abs(now - nowLeft.second)
                val rightDist = (nowRight.first - 2) + abs(now - nowRight.second)
                if(leftDist == rightDist){
                    if(hand == "left"){
                        answer += "L"
                        nowLeft = Pair(2, now)
                    }else{
                        answer += "R"
                        nowRight = Pair(2, now)
                    }
                }
                else if(leftDist < rightDist){
                    answer += "L"
                    nowLeft = Pair(2, now)
                }
                else{
                    answer += "R"
                    nowRight = Pair(2, now)
                }
            }
        }
        
        
        return answer
    }
}