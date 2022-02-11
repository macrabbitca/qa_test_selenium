package task1;

/**
 * Pairs of numbers class
 * @author Jim Wang
 * @createTime 2022-02-09
 */
public class PairNumber {

    Integer number1;

    Integer number2;

    public PairNumber() {
    }

    public PairNumber(Integer number1, Integer number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    public Integer getNumber1() {
        return number1;
    }

    public Integer getNumber2() {
        return number2;
    }

    public void setNumber1(Integer number1) {
        this.number1 = number1;
    }

    public void setNumber2(Integer number2) {
        this.number2 = number2;
    }

    @Override
    public String toString() {
        return "(" + number1 + ", " + number2 + ')';
    }
}
