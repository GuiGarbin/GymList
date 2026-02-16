package Models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Date;
@Entity(tableName = "assessment_table")

public class Assessment implements Serializable {
    @PrimaryKey(autoGenerate = true)
    int id;
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

    public Date getDate() {
        return date;
    }

    public double getWeight() {
        return weight;
    }

    public double getFat() {
        return fat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getRightArm() {
        return rightArm;
    }

    public double getLeftArm() {
        return leftArm;
    }

    public double getRightLeg() {
        return rightLeg;
    }

    public double getLeftLeg() {
        return leftLeg;
    }

    public double getRightLowerLeg() {
        return rightLowerLeg;
    }

    public double getLeftLowerLeg() {
        return leftLowerLeg;
    }

    public double getChest() {
        return chest;
    }

    public double getBelly() {
        return belly;
    }
}
