//fail
function solution(leave, day, holidays) {
	let answer = -1;
	let startDay = findStart(day);

	let cal = [];
	for (let i = 0; i < startDay; i++) cal[i] = 0;
	for (let i = 1; i < 31; i++) {
		startDay = startDay % 7;
		if (startDay === 0 || startDay === 6) {
			cal[i] = true;
		} else cal[i] = false;
		startDay++;
	}
	for (let i of holidays) {
		cal[i] = true;
	}

	// console.log(findBest(cal,leave,1))
	for (let i = 1; i < 31; i++) {
		findBest(cal, leave, i);
	}

	return Math.max(...ans);
}
function findBest(cal, leave, startDay) {
	if (leave === 0) {
		// startDay--;
		let cnt = 0;
		// console.log(startDay)

		while (cal[startDay] === true) {
			cnt++;
			startDay--;
		}
		ans.push(cnt);

		return;
	}
	if (cal[startDay] === true) {
		findBest(cal, leave, startDay + 1);
	} else {
		cal[startDay] = true;
		findBest(cal, leave - 1, startDay + 1);
		cal[startDay] = false;
	}
}
function findStart(day) {
	switch (day) {
		case "SUN":
			return 0;
		case "MON":
			return 1;
		case "TUE":
			return 2;
		case "WED":
			return 3;
		case "THU":
			return 4;
		case "FRI":
			return 5;
		case "SUN":
			return 6;
	}
}

leave = 30;
day = "MON";
holidays = [1, 2, 3, 4, 28, 29, 30];
ans = [];
console.log(solution(leave, day, holidays));
