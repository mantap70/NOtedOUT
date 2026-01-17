package com.mantao.notedout;

public class Note {
    public String title;
    public String content;
    public boolean isFavorite;

    public Note(String title, String content, boolean isFavorite) {
        this.title = title;
        this.content = content;
        this.isFavorite = isFavorite;
    }
}