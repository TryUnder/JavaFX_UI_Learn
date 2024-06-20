public class Book {
    private String m_title;
    private String m_genre;
    private String m_author;
    private int m_quantity;
    private String m_publisher;
    private int m_pages;
    private String m_description;

    public Book(String title, String genre, String author, int quantity, String publisher, int pages, String description) {
        m_title = title;
        m_genre = genre;
        m_author = author;
        m_quantity = quantity;
        m_publisher = publisher;
        m_pages = pages;
        m_description = description;
    }

    public String getTitle() { return m_title; }
    public String getGenre() { return m_genre; }
    public String getAuthor() { return m_author; }
    public int getQuantity() { return m_quantity; }
    public String getPublisher() { return m_publisher; }
    public int getPages() { return m_pages; }
    public String getDescription() { return m_description; }

    public void setTitle(String title) { m_title = title; }
    public void setGenre(String genre) { m_genre = genre; }
    public void setAuthor(String author) { m_author = author; }
    public void setQuantity(int quantity) { m_quantity = quantity; }
    public void setPublisher(String publisher) { m_publisher = publisher; }
    public void setPages(int pages) { m_pages = pages; }
    public void setDescription(String description) { m_description = description; }
}
