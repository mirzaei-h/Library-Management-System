package library;

import java.sql.*;

public class Book_User {

//    private Connection connection = null;
//    private Statement statement = null;
//    private ResultSet resultSet = null;
    private long actionID;
    Status status;
    private Date createDate;
    private long BookFK;
    private long UserFK;

    public Book_User(long actionID, Status status, Date createDate, long bookFK, long userFK) {
        this.actionID = actionID;
        this.status = status;
        this.createDate = createDate;
        BookFK = bookFK;
        UserFK = userFK;
    }

    public long getActionID() {
        return actionID;
    }

    public void setActionID(long actionID) {
        this.actionID = actionID;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public long getBookFK() {
        return BookFK;
    }

    public void setBookFK(long bookFK) {
        BookFK = bookFK;
    }

    public long getUserFK() {
        return UserFK;
    }

    public void setUserFK(long userFK) {
        UserFK = userFK;
    }

    @Override
    public String toString() {
        return "Book_User{" +
                "actionID=" + actionID +
                ", status=" + status +
                ", createDate=" + createDate +
                ", BookFK=" + BookFK +
                ", UserFK=" + UserFK +
                '}';
    }


}
