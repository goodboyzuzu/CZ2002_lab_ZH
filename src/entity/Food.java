package entity;

import java.io.Serializable;

public class Food extends MenuItem implements Serializable {

    public enum CourseType {MAIN_COURSE, DESSERT, DRINKS};

    private CourseType coursetype;

    public Food(String foodName, String desc, double price, CourseType coursetype) {
        super(foodName,desc,price);
        this.coursetype = coursetype;
    }

    public CourseType getCoursetype() {
        return coursetype;
    }

}
