class Cabbie1 {
  name: string;
  constructor() {
    this.name = "";
  }
}

class Cabbie2 {
  name: string = "";
  constructor() {}
}

let cabbie: Cabbie1 = new Cabbie1();

console.log(cabbie.name);

const returnNumber: () => number | string = () => {
  return "10";
};
