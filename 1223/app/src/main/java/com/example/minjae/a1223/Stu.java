package com.example.minjae.a1223;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.Index;

/**
 * Created by Minjae on 2016-12-23.
 */

public class Stu extends RealmObject{
        @Index
        private long id;

        private String name;
        private int phone;
        private String image;

        public Stu(){}

        public Stu(String name, int phone, String image) {
                this.name = name;
                this.phone = phone;
                this.image = image;
        }

        public long getId() {
                return id;
        }

        public void setId(long id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public int getPhone() {
                return phone;
        }

        public void setPhone(int phone) {
                this.phone = phone;
        }

        public String getImage() {
                return image;
        }

        public void setImage(String image) {
                this.image = image;
        }
}
