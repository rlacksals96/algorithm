function solution(array, commands) {
    let result=[];
    for(let cmd of commands){
        let sliced=array.slice(cmd[0]-1,cmd[1])
        sliced.sort((a,b)=>a-b);
        result.push(sliced[cmd[2]-1])
    }

    return result;
}
arr=[1, 5, 2, 6, 3, 7, 4];
commands=[[2, 5, 3], [4, 4, 1], [1, 7, 3]];
console.log(solution(arr,commands));

//숫자 대소 비교할때 javascript의 경우 기본적으로 문자열을 기준으로 비교하기 때문에 숫자 길이가 다르면 정확한 비교가 안된다. 따라서 반드시 화살표 함수를 통해 정렬 기준을 명시할 것!!!!!!