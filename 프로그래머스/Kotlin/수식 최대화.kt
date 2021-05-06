import kotlin.math.abs
import kotlin.math.max
import java.util.ArrayDeque

class Solution {
    var numbers = ArrayList<Long>()
    var ops = ArrayList<Long>()
    var hashmap = IntArray(3){i -> i}
    
    fun Operation():Long{
        val deq = ArrayDeque<Long>()
        var cur = 0
        var itNum = ops.size
        var nextItNum = ops.size
        
        deq.addFirst(numbers[0])
        for(i in 0..itNum - 1){
            deq.addLast(ops[i])
            deq.addLast(numbers[i + 1])
        }
        
        for(i in 0..2){
            itNum = nextItNum
            nextItNum = 0
            deq.addLast(deq.remove())
            for(j in 1..itNum){
                if(hashmap[deq.first.toInt()] == i){
                    val nowOp = deq.remove().toInt()
                    if(nowOp == 0){
                        deq.addLast(deq.removeLast() + deq.remove())
                    }
                    else if(nowOp == 1){
                        deq.addLast(deq.removeLast() - deq.remove())
                    }
                    else{
                        deq.addLast(deq.removeLast() * deq.remove())
                    }
                }
                else{
                    deq.addLast(deq.remove())
                    deq.addLast(deq.remove())
                    ++nextItNum
                }
            }            
        }
        return deq.first
        
    }
        
    fun solution(expression: String): Long {
        var answer: Long = 0
        val str = expression.split("+", "-", "*")
        str.forEach{
            numbers.add(it.toLong())
        }
        for(i in 0..expression.length - 1){
            val now = expression[i]
            if(now == '+')
                ops.add(0)
            else if(now == '-')
                ops.add(1)
            else if(now == '*')
                ops.add(2)
        }
        
        for(i in 0..2){
            for(j in 0..2){
                hashmap[j] = (j + i) % 3 
            }            
            val ret = Operation()
            answer = max(answer, abs(ret))
        }
        
        for(i in 0..2){
            for(j in 0..2){
                hashmap[j] = (2 - j + i) % 3
            }
            val ret = Operation()
            answer = max(answer, abs(ret))
        }
        
        return answer
    }
}