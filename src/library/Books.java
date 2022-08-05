package library;

public class Books {
    private long idBook;
    private String name;
    private String author;
    Status status;


    public Books(long idBook, String name, String author, Status status) {
        this.idBook = idBook;
        this.name = name;
        this.author = author;
        this.status = status;
    }

    public long getIdBook() {
        return idBook;
    }

    public void setIdBook(long idBook) {
        this.idBook = idBook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }



    @Override
    public String toString() {
        return "Books{" +
                "idBook=" + idBook +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", status=" + status +
                '}';
    }
}
