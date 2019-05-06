package ua.itif.lms.dao.entity;

import java.util.Objects;

public class Note {
    private long id;
    private long user_id;
    private String text;
    private String title;

    public Note() {
    }

    public Note(long id, long user_id, String text, String title) {
        this.id = id;
        this.user_id = user_id;
        this.text = text;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", text='" + text + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return id == note.id &&
                user_id == note.user_id &&
                Objects.equals(text, note.text) &&
                Objects.equals(title, note.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user_id, text, title);
    }
}
