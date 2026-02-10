package Models;

import java.util.Date;

public class Assessment {
    Date date;
    double weight;
    double fat;
    double rightArm;
    double leftArm;
    double rightLeg;
    double leftLeg;
    double rightLowerLeg;
    double leftLowerLeg;
    double chest;
    double belly;

    public Assessment(Date date, double weight, double fat, double rightArm, double leftArm,
                      double rightLeg, double leftLeg, double rightLowerLeg, double leftLowerLeg,
                      double chest, double belly) {
        this.date = date;
        this.weight = weight;
        this.fat = fat;
        this.rightArm = rightArm;
        this.leftArm = leftArm;
        this.rightLeg = rightLeg;
        this.leftLeg = leftLeg;
        this.rightLowerLeg = rightLowerLeg;
        this.leftLowerLeg = leftLowerLeg;
        this.chest = chest;
        this.belly = belly;
    }
}
