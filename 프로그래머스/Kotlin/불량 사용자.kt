class Solution {
    var userLen = 0
    var bannedLen = 0
    var checked = BooleanArray(8){false}
    var isfailed = false
    var userId: Array<String> = arrayOf<String>()
    var bannedId: Array<String> = arrayOf<String>()
    var ansSet = mutableSetOf<List<Int>>()
    var bannedList = intArrayOf()
    
    fun Matching(x:Int){
        if(x >= bannedLen){
            ansSet.add(bannedList.sorted())
            return
        }
        
        val nowStr = bannedId[x]
        for(i in 0..userLen - 1){
            if(nowStr.length == userId[i].length && !checked[i]){
                isfailed = false
                for(j in 0..nowStr.length - 1){
                    if(nowStr[j] == '*')
                        continue
                    if(nowStr[j] != userId[i][j]){
                        isfailed = true
                        break
                    }
                }
                if(!isfailed){
                    checked[i] = true
                    bannedList[x] = i
                    Matching(x + 1)
                    checked[i] = false
                }
            }
        }
        
    }
    
    fun solution(user_id: Array<String>, banned_id: Array<String>): Int {
        userLen = user_id.size
        bannedLen = banned_id.size
        userId = Array<String>(userLen){i ->user_id[i]}
        bannedId = Array<String>(bannedLen){i ->banned_id[i]}
        bannedList = IntArray(bannedLen)
        
        //0번 아이디 매칭해야함
        Matching(0)
        
        return ansSet.size
    }
}