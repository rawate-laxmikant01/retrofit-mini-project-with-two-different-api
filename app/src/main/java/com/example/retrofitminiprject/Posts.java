package com.example.retrofitminiprject;

public class Posts {
    int char_id;
    String name, nickname, img, mimage, birthday, status, portrayed, category;

    public Posts() {
    }

    public Posts(int char_id, String name, String nickname, String img, String mimage, String birthday, String status, String portrayed, String category) {
        this.char_id = char_id;

        this.name = name;
        this.nickname = nickname;
        this.img = img;
        this.mimage = mimage;
        this.birthday = birthday;
        this.status = status;
        this.portrayed = portrayed;
        this.category = category;
    }

    public int getChar_id() {
        return char_id;
    }

    public void setChar_id(int char_id) {
        this.char_id = char_id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getMimage() {
        return mimage;
    }

    public void setMimage(String mimage) {
        this.mimage = mimage;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPortrayed() {
        return portrayed;
    }

    public void setPortrayed(String portrayed) {
        this.portrayed = portrayed;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}