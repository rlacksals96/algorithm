const input = [];
let inputIndex = 0;

let graph, columnCount, rowCount, cabbageCount, result=0;

const strToNumArr = (str) => str.split(" ").map((numString) => Number(numString));

require("readline")
  .createInterface(process.stdin, process.stdout)
  .on("line", function (line) {
    input.push(line.trim());
  })
  .on("close", function () {
      let t = Number(input[inputIndex++]);
      while(t--){
          [columnCount, rowCount, cabbageCount] = strToNumArr(input[inputIndex++]);
          graph = [...Array(rowCount)].map(()=>Array(columnCount).fill(0));
          result = 0;

          while(cabbageCount--){
            const [c, r] = strToNumArr(input[inputIndex++]);
            graph[r][c] = 1;
          }

          solution();
        
      }
  });
  
const solution=()=>{
    console.log(graph);
}
