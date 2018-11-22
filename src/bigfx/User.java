/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigfx;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;

/**
 *
 * @author Ticu
 */
public class User {

    public String name;
    public String secondname;
    public int age;
    public String gender;
    public String family_status;
    public String kids;
    public String desc;
    public Image img;
    public boolean newsletter;
    public String unemployment;
    public int nrcars;
    public String favteam;
    public ObservableList interests;

    public User(String name, String secondname, int age, String gender, String familystatus, String kids,
            String desc, Image img, boolean newsletter, String unemployment, int cars, String favteam, ObservableList list) {
        this.name = name;
        this.secondname = secondname;
        this.age = age;
        this.gender = gender;
        this.family_status = familystatus;
        this.kids = kids;
        this.desc = desc;
        this.img = img;
        this.newsletter = newsletter;
        this.unemployment = unemployment;
        this.nrcars = cars;
        this.favteam = favteam;
        this.interests = list;
    }

    @Override
    public String toString() {
        return name + " " + secondname;
    }

    public String toStringForThatBox() {
        return "User{" + "name=" + name + ", secondname=" + secondname + ", age=" + age + ", gender=" + gender + ", family_status=" + family_status + ", kids=" + kids + ", desc=" + desc + ", img=" + img + ", newsletter=" + newsletter + ", unemployment=" + unemployment + ", nrcars=" + nrcars + ", favteam=" + favteam + ", interests=" + interests + '}';
    }

}
