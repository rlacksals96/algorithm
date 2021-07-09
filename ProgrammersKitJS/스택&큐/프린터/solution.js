function solution(priorities, location) {
    let answer=0;
    let len=priorities.length;
    while(priorities.length){
        let flag=true;
        let cur=priorities.shift();
        location=update_location(location,len);
        for(let p of priorities){
            if(cur<p){
                priorities.push(cur);
                flag=false;
                break;
            }
        }
        if(flag){
            if(location==len-1){
                answer++;
                return answer;
            }else{
                answer+=1;
                len-=1;
            }
        }
        
    }
}
function update_location(location,len){
    if(location==0){
        return len-1;
    }else{
        return location-1;
    }
}

p=[1, 1, 9, 1, 1, 1];
l=0;
console.log(solution(p,l));