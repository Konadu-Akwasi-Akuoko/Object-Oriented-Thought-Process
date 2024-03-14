import { CustomMath } from "./Maths";

const math = new CustomMath();

console.log(math.sum());

// Set the value of myInt1 and myInt2

math.setMyInt1 = 10;
math.setMyInt2 = 20;

console.log(math.sum());

// Get the values of myInt1 and myInt2 using the getters

console.log(math.getMyInt1);
console.log(math.getMyInt2);
