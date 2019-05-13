package PowerBall;

import java.util.Date;

/**
 * Created by nareshm on 12/11/2015.
 */
class PowerBallResult {
    private int id;
    private Date drawDate;
    private int numberOne;
    private int numberTwo;
    private int numberThree;
    private int numberFour;
    private int numberFive;
    private int numberSix;
    private int numberSeven;
    private int powerBall;
    public PowerBallResult(){

    }

    public void setId(int id) {
        this.id = id;
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

    public int getNumberSeven() {
        return numberSeven;
    }

    public void setNumberSeven(int numberSeven) {
        this.numberSeven = numberSeven;
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
        if (numberSeven != that.numberSeven) return false;
        return powerBall == that.powerBall;

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
          ", numberSeven=" + numberSeven +
                ", powerBall=" + powerBall +
                '}';
    }
}
