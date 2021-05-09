


function solution(weights,head2head){
    var answer=[];
    let players=[];
    for(let i=0;i<head2head.length;i++){
        let player={};
        player.num=i+1
        player.weight=weights[i];
        player.winRate=getWinRate(head2head[i])
        player.win=getWinCnt(head2head[i]);
        player.winHeavy=getWinHeavyCnt(i,weights,head2head[i])
        players.push(player);
    }
    console.log(players)
    players.sort((a,b)=>{
        //win rate
        if(a.winRate>b.winRate){
            return -1
        }
        else if(a.winRate<b.winRate){
            return 1
        }
        else{//win heavy player
           if(a.winHeavy>b.winHeavy){
               return -1;
           }else if(a.winHeavy<b.winHeavy){
               return 1;
           }else{
               if(a.weight<b.weight){
                   return 1
               }else if(a.weight>b.weight){
                   return -1
               }else{
                   if(a.num<b.num){
                       return 1
                   }else if(a.num>b.num){
                       return -1
                   }
               }
           }

        }
    })
    for(let i=0;i<head2head.length;i++){
        answer.push(players[i].num)
    }
    return answer;
}
function getWinHeavyCnt(n,weight,head2head){
    let myWeight=weight[n]
    let cnt=0
    for(let i=0;i<weight.length;i++){
        if(weight[i]>myWeight && head2head[i]==='W'){
            cnt++;
        }
    }
    return cnt;
}
function getWinRate(head2head){
    let win=getWinCnt(head2head);
    return win/head2head.length;
}
function getWinCnt(head2head){
    let cnt=0
    for(let i=0;i<head2head.length;i++){
        if(head2head[i]==='W'){
            cnt++;
        }
    }
    return cnt
}

console.log(solution([60,70,60]			,["NNN","NNN","NNN"]				))
