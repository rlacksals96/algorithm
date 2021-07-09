
let done=[];
let bridge=[];

function solution(bridge_length,weight,truck_weights){
    let answer=0;
    let total=truck_weights.length;
    
    while(done.length!=total){
        answer++;
        //밀어내기만 함.
        bridge.unshift(0);
        if(count_truck_on_bridge()>=bridge_length){
            
            if(bridge.length>bridge_length){
                done.push(bridge.pop());
            }
        }else{
            if(calc_weight_on_bridge(truck_weights[0])){
                bridge[0]=truck_weights.shift();
            }
        }
        
    }
}
function calc_weight_on_bridge(candi){
    return bridge.reduce((acc,cur)=>acc+cur,candi);
}
function count_truck_on_bridge(){
    let cnt=0;
    for(let t of bridge){
        if(t!=0){
            cnt++;
        }
    }
    return cnt;
}
let bl=100;
let w=100;
let tw=[10,10,10,10,10,10,10,10,10,10];
console.log(solution(bl,w,tw));