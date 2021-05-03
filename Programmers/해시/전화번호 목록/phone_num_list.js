function solution(phone_book){
    let answer=true
    dic={}

    for(let p of phone_book){
        dic[p]=1
    }
    for(let p of phone_book){
        let tmp='';
        for(let num of p){
            tmp+=num;
            if(tmp in dic && tmp!==p){
                answer=false
            }
        }
    }
    return answer
}

const phone_book=["12","123","1235","567","88"]	;
console.log(solution(phone_book));