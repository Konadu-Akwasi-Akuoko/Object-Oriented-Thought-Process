export class CustomMath {
  private myInt1 = 1;
  private myInt2 = 2;

  get getMyInt1(): number {
    return this.myInt1;
  }

  get getMyInt2(): number {
    return this.myInt2;
  }

  set setMyInt1(value: number) {
    this.myInt1 = value;
  }

  set setMyInt2(value: number) {
    this.myInt2 = value;
  }
  sum(): number {
    return this.myInt1 + this.myInt2;
  }
}
