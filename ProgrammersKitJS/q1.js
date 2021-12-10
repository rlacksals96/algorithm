function solution(d, m) {
  let answer=0;
  let curBox=1;
  for(let i=0;i<d.length;i++){
    answer++;
    if(d[i]>=curBox){
      m-=curBox;
      curBox*=2;

    }else{
      curBox=1;
    }
    if(m<=0){
      return answer;
    }
  }
  return -1;
}

let d=[2,2,4,3]	;
let m=8;
console.log(solution(d,m));