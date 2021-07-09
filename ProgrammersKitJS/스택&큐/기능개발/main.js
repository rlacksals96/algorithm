function solution(progresses, speeds) {
    let answer=[];
    while(progresses.length>0){
        for(let i=0;i<progresses.length;i++)
            progresses[i]+=speeds[i];
        if(progresses[0]==100){
            let cnt=0;
            while(progresses[0]>=100){
                cnt++;
                progresses.shift();
                speeds.shift();
                
            }
            if(cnt>0)
                answer.push(cnt);
        }
    }
    
    return answer;
}

progresses=[95, 90, 99, 99, 80, 99]	;
speeds=[1, 1, 1, 1, 1, 1]	;
console.log(solution(progresses,speeds));