
// for(let w of candi){
//   tree[w[0]].push(w[1]);
//   tree[w[1]].push(w[0]);
// }
function solution(n, wires) {
  let answer=[];
  for(let i=0;i<wires.length;i++){
    let tree={}
    for(let j=1;j<=n;j++){
      tree[j]=[];
    }
    for(let j=0;j<wires.length;j++){
      if(i==j)
        continue;
      tree[wires[j][0]].push(wires[j][1]);
      tree[wires[j][1]].push(wires[j][0]);

    }
    let node=-1;
    for(let j=1;j<=n;j++){
      if(tree[j].length){
        node=j;
        break;
      }
    }
    // console.log(tree);
    let result=bfs(tree,node,n);
    
    answer.push(Math.abs((n-result)-result));
  }
  
  
  return Math.min.apply(null,answer);
}
function bfs(tree,node,n){
  let visit=new Array(n+1);
  visit.fill(false);
  visit[0]=true;
  let queue=[];
  queue.push(node);
  visit[node]=true;
  let cnt=1;
  while(queue.length){
    let n=queue.shift();
    // console.log(tree[n]);
    if(tree[n]){
      for(let c of tree[n]){
        if(visit[c]==false){
          cnt++;
          visit[c]=true;
          queue.push(c);
        }
      }
    }
    
    
  }
  return cnt;
}
let n=7;
let wires=[[1,2],[2,7],[3,7],[3,4],[4,5],[6,7]]				;
console.log(solution(n,wires));