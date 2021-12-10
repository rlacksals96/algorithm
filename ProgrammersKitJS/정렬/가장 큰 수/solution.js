function solution(numbers) {
    const result=numbers.sort((a,b)=>{
        return (''+b+a)-(''+a+b);
    }).join('');

    return result[0]==='0'?'0':result;
}
nums=[3, 30, 34, 5, 9];
console.log(solution(nums))