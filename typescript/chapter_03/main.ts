class Cabbie {
  name: string;
  constructor() {
    this.name = "";
  }
}

let cabbie: Cabbie = new Cabbie();

console.log(cabbie.name);

const returnNumber: () => number | string = () => {
  return "10";
};
