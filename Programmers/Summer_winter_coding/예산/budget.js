function solution(d, budget) {
	d.sort((a, b) => {
		return a - b;
	});
	let cnt = 0;
	while (budget > 0) {
		if (budget - d[0] >= 0) {
			budget -= d[0];
			d.shift();
			cnt++;
		} else {
			break;
		}
	}
	return cnt;
}

let d = [1, 3, 2, 5, 4];

let budget = 9;
console.log(solution(d, budget));
