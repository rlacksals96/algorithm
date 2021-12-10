function solution(deposit) {
  let answer = [];
  for(let d of deposit){
    if(d>0){
      answer.push(d);
    }else{
      let rest=d;
      while(rest<0){
        let money=answer.pop();
        rest+=money;
      }
      if(rest!=0){
        answer.push(rest);
      }
    }
  }
  return answer;
}

let deposit=[500, 1000, 2000, -1000, -1500, 500]	;
console.log(solution(deposit));