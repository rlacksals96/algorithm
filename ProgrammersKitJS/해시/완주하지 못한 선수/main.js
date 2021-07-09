function solution(participant, completion) {
    let answer = '';
    p={};
    participant.forEach(element => {
        if(element in p){
            p[element]++;
        }else{
            p[element]=1;
        }
    });

    completion.forEach(e=>{
        p[e]--;
    });
    for(let i of Object.keys(p)){
        if(p[i]==1){
            return i;
        }
    }
    
}

p=["leo", "kiki", "eden"]	;
c=["eden", "kiki"]	;
console.log(solution(p,c));
// console.log(1);