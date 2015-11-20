package PowerBall;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by nareshm on 12/11/2015.
 */
public class PowerBallResult {
    private int id;
    private Date drawDate;
    private int numberOne;
    private int numberTwo;
    private int numberThree;
    private int numberFour;
    private int numberFive;
    private int numberSix;
    private int powerBall;
    private BigDecimal divisionOneMoney;
    private BigDecimal divisionTwoMoney;
    private BigDecimal divisionThreeMoney;
    private BigDecimal divisionFourMoney;
    private BigDecimal divisionFiveMoney;
    private BigDecimal divisionSixMoney;
    private BigDecimal divisionSevenMoney;
    private BigDecimal divisionEightMoney;
    public PowerBallResult(){

    }
    public PowerBallResult(int id, Date drawDate, int numberOne, int numberTwo, int numberThree, int numberFour, int numberFive, int numberSix, int powerBall) {
        this.id = id;
        this.drawDate = drawDate;
        this.numberOne = numberOne;
        this.numberTwo = numberTwo;
        this.numberThree = numberThree;
        this.numberFour = numberFour;
        this.numberFive = numberFive;
        this.numberSix = numberSix;
        this.powerBall = powerBall;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDrawDate() {
        return drawDate;
    }

    public void setDrawDate(Date drawDate) {
        this.drawDate = drawDate;
    }

    public int getNumberOne() {
        return numberOne;
    }

    public void setNumberOne(int numberOne) {
        this.numberOne = numberOne;
    }

    public int getNumberTwo() {
        return numberTwo;
    }

    public void setNumberTwo(int numberTwo) {
        this.numberTwo = numberTwo;
    }

    public int getNumberThree() {
        return numberThree;
    }

    public void setNumberThree(int numberThree) {
        this.numberThree = numberThree;
    }

    public int getNumberFour() {
        return numberFour;
    }

    public void setNumberFour(int numberFour) {
        this.numberFour = numberFour;
    }

    public int getNumberFive() {
        return numberFive;
    }

    public void setNumberFive(int numberFive) {
        this.numberFive = numberFive;
    }

    public int getNumberSix() {
        return numberSix;
    }

    public void setNumberSix(int numberSix) {
        this.numberSix = numberSix;
    }

    public int getPowerBall() {
        return powerBall;
    }

    public void setPowerBall(int powerBall) {
        this.powerBall = powerBall;
    }

    public BigDecimal getDivisionOneMoney() {
        return divisionOneMoney;
    }

    public void setDivisionOneMoney(BigDecimal divisionOneMoney) {
        this.divisionOneMoney = divisionOneMoney;
    }

    public BigDecimal getDivisionTwoMoney() {
        return divisionTwoMoney;
    }

    public void setDivisionTwoMoney(BigDecimal divisionTwoMoney) {
        this.divisionTwoMoney = divisionTwoMoney;
    }

    public BigDecimal getDivisionThreeMoney() {
        return divisionThreeMoney;
    }

    public void setDivisionThreeMoney(BigDecimal divisionThreeMoney) {
        this.divisionThreeMoney = divisionThreeMoney;
    }

    public BigDecimal getDivisionFourMoney() {
        return divisionFourMoney;
    }

    public void setDivisionFourMoney(BigDecimal divisionFourMoney) {
        this.divisionFourMoney = divisionFourMoney;
    }

    public BigDecimal getDivisionFiveMoney() {
        return divisionFiveMoney;
    }

    public void setDivisionFiveMoney(BigDecimal divisionFiveMoney) {
        this.divisionFiveMoney = divisionFiveMoney;
    }

    public BigDecimal getDivisionSixMoney() {
        return divisionSixMoney;
    }

    public void setDivisionSixMoney(BigDecimal divisionSixMoney) {
        this.divisionSixMoney = divisionSixMoney;
    }

    public BigDecimal getDivisionSevenMoney() {
        return divisionSevenMoney;
    }

    public void setDivisionSevenMoney(BigDecimal divisionSevenMoney) {
        this.divisionSevenMoney = divisionSevenMoney;
    }

    public BigDecimal getDivisionEightMoney() {
        return divisionEightMoney;
    }

    public void setDivisionEightMoney(BigDecimal divisionEightMoney) {
        this.divisionEightMoney = divisionEightMoney;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PowerBallResult that = (PowerBallResult) o;

        if (numberFive != that.numberFive) return false;
        if (numberFour != that.numberFour) return false;
        if (numberOne != that.numberOne) return false;
        if (numberSix != that.numberSix) return false;
        if (numberThree != that.numberThree) return false;
        if (numberTwo != that.numberTwo) return false;
        if (powerBall != that.powerBall) return false;

        return true;
    }


    @Override
    public String toString() {
        return "PowerBallResult{" +
                "id=" + id +
                ", drawDate=" + drawDate +
                ", numberOne=" + numberOne +
                ", numberTwo=" + numberTwo +
                ", numberThree=" + numberThree +
                ", numberFour=" + numberFour +
                ", numberFive=" + numberFive +
                ", numberSix=" + numberSix +
                ", powerBall=" + powerBall +
                '}';
    }
}
