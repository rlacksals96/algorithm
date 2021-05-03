const getCombinations = (arr, selectNumber) => {
	const results = [];

	if (selectNumber == 1) {
		return arr.map((value) => [value]);
	}
	//배열의 각각의 item, 배열의 index, 배열 그 자체
	arr.forEach((fixed, index, origin) => {
		const rest = origin.slice(index + 1);
		const combinations = getCombinations(rest, selectNumber - 1);
		const attached = combinations.map((c) => [fixed, ...c]);
		results.push(...attached);
	});
	return results;
};

const findPrimeNum = (num) => {
	for (let i = 2; i < num; i++) {
		if (num % i == 0) {
			return false;
		}
	}
	return true;
};
function solution(nums) {
	const combinations = getCombinations(nums, 3);
	const sumArr = [];
	// for (let i = 0; i < combinations.length; i++) {
	// sumArr.push(combinations[i].reduce((a, b) => a + b));
	// }
	for (let c of combinations) {
		sumArr.push(c.reduce((a, b) => a + b));
	}
	let answer = 0;
	for (let i = 0; i < sumArr.length; i++) {
		if (findPrimeNum(sumArr[i])) {
			answer++;
		}
	}
	return answer;
}

const arr = [1, 2, 7, 6, 4];
console.log(solution(arr));
