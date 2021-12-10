const input=[];
let inputIndex=0;
let graph,col,row,cabbageCnt,result=0;
//1줄에 여러개 받앗을때 숫자로 변환
const strToNumArr=(str)=>str.split('').map((numString)=>Number(numString));

require("readline")
    .createInterface(process.stdin, process.stdout)
    .on("line", function (line) {
        input.push(line.trim());
    })
    .on("close", function () {
        //1개 짜리 입력 받기
        let t=Number(input[inputIndex++]);
        while(t--){
            //1줄에서 여러개 입력 받을때 
            [col,row,cabbageCnt]=strToNumArr(input[inputIndex++]);
            //0으로 채워진 그래프 생성
            // graph=new Array(row);
            // for(let k=0;k<row;k++){
            //     graph[k]=new Array(col);
            //     graph[k].fill(0);
            // }
            graph = [...Array(row)].map(()=>Array(col).fill(0));
            result=0;
            //좌표값 입력하기
            // 받을땐 x,y로 받지만 그래프에 입력할때만 y,x순으로 넣는다.
            while(cabbageCnt--){
                const [posx,posy]=strToNumArr(input[inputIndex++]);
                graph[posy][posx]=1;
            }
            //solution code 작성하기
            console.log(graph);
            solution();
            // console.log(1);
        }
    });

const solution=()=>{
    console.log(graph);
    // for(let i=0;i<graph.length;i++){
    //     console.log(graph[i]);
    // }
}