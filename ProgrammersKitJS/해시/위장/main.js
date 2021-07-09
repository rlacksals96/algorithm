function solution(clothes) {
    let fashion={}
    clothes.forEach((type) => {
        if(type[1] in fashion){
            fashion[type[1]]++;
        }else{
            fashion[type[1]]=1;
        }
    });
    let ans=1;
    for(let i of Object.values(fashion)){
        ans*=(i+1);
    }
    return ans-1;
}

c=[["crowmask", "face"], ["bluesunglasses", "face"], ["smoky_makeup", "face"]];
console.log(solution(c));