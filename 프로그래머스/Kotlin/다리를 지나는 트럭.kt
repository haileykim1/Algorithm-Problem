class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var answer = 0
        var bridgeW = 0
        var onBridge = ArrayList<Int>()
        var crossCnt = ArrayList<Int>()
        var pos = 0
        var truckCnt = truck_weights.size
        var crossed = false
        do{
            crossed = false
            for(i in 0..onBridge.size - 1){
                if(++crossCnt[i] > bridge_length){
                    bridgeW -= onBridge[i]
                    crossed = true
                }
            }
            if(crossed){
                onBridge.removeAt(0)
                crossCnt.removeAt(0)
            }
            
            if((pos < truckCnt) && ((bridgeW + truck_weights[pos]) <= weight)){
                onBridge.add(truck_weights[pos])
                crossCnt.add(1)
                bridgeW += truck_weights[pos++]
            }
            ++answer
        }while(onBridge.isNotEmpty())
        
        return answer
    }
}