package ra.bussiness;

import java.util.Scanner;

public class Book {


    //field
    private int bookId;
    private String bookName, author, descriptions;
    private Double importPrice, exportPrice;

    private float interest;
    private Boolean bookStatus;

    //constructor

    public Book() {
        //this.interest = (float) (exportPrice - importPrice);
    }

    public Book(int bookId, String bookName, String author, String descriptions, Double importPrice, Double exportPrice, Boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.descriptions = descriptions;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.bookStatus = bookStatus;
        //this.interest = (float) (exportPrice - importPrice);
    }

    //getter

    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public Double getImportPrice() {
        return importPrice;
    }

    public Double getExportPrice() {
        return exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public Boolean getBookStatus() {
        return bookStatus;
    }

    //setter

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public void setImportPrice(Double importPrice) {
        this.importPrice = importPrice;
    }

    public void setExportPrice(Double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public void setBookStatus(Boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    //displayData()

    public void displayData() {
        System.out.println("Thông tin của sách là : ");
        System.out.println("Mã sách : " + this.bookId);
        System.out.println("Tên sách : " + this.bookName);
        System.out.println("Tác giả  : " + this.author);
        System.out.println("Mô tả về sách : " + this.descriptions);
        System.out.println("Giá nhập của sách : " + this.importPrice);
        System.out.println("Giá suất của sách : " + this.exportPrice);
        System.out.println("Lợi nhuận của sách : " + this.interest);
        System.out.println("Trạng thái sách : " + (this.bookStatus ? "Đang bán" : "Dừng bán"));
        System.out.println("-------------------------------------------");

    }

    //inputData()
    public void inputData(Scanner scanner, Book[] arrBook) {

        //bookID
        //BookName
        while (true) {
            System.out.println("Nhập tên sách(không được bỏ trống)");
            this.bookName = scanner.nextLine();
            if (bookName.isEmpty()) {
                System.out.println("Tên của sách không được để trống!");
            } else break;
        }

        //Author
        while (true) {
            System.out.println("Nhập tên tác giả (không được bỏ trống)");
            this.author = scanner.nextLine();
            if (author.isEmpty()) {
                System.out.println("Tên tác giả không được để trống!");
            } else break;
        }

        //Descriptions
        while (true) {
            System.out.println("Nhập mô tả cho sách (không được bỏ trống, ít nhất 10 kí tự)");
            this.descriptions = scanner.nextLine();
            if (descriptions.isEmpty()) {
                System.out.println("Mô tả của sách không được để trống!");
            } else if (descriptions.length() < 10) {
                System.out.println("Mô tả của sách phải có ít nhất 10 kí tự !");
            } else {
                break;
            }
        }

        //importPrice
        while (true) {
            System.out.println("Giá nhập của sách là (nhập số lớn hơn 0): ");
            this.importPrice = (double) Float.parseFloat(scanner.nextLine());
            if (importPrice <= 0)
                System.out.println("Giá nhập phải lớn hơn 0");
            else break;
        }

        //exportPrice
        while (true) {
            System.out.println("Giá xuất của sách là (phải lớn hơn 1.2 lần giá nhập): ");
            this.exportPrice = (double) Float.parseFloat(scanner.nextLine());
            if (this.exportPrice < 1.2 * this.importPrice)
                System.out.println("Giá xuất phải phải lớn hơn 1.2 lần giá nhập");
            else break;
        }

        //bookStatus
        System.out.println("Trạng thái của sách (mặc định là true)");
        this.bookStatus = true;

        //Interest
        if (importPrice != null && exportPrice != null )
        {
            this.interest = (float) (this.exportPrice - this.importPrice);
        }

    }
}
