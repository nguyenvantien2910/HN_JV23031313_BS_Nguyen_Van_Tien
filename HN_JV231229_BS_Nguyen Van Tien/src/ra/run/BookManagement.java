package ra.run;

import ra.bussiness.Book;

import java.util.Scanner;

public class BookManagement {
    static Scanner scanner = new Scanner(System.in);
    static Book[] books = new Book[100];
    static int bookCount = 0;
    static int choise;
    private static int boodId;

    public static void main(String[] args) {
        while (true) {
            System.out.println("****************JAVAVAVA-HACKATATHON-05-BASIC-MENU***************");
            System.out.println("1. Nhập số lượng sách thêm mới và nhập thông tin cho từng cuốn sách");
            System.out.println("2. Hiển thị thông tin tất cả sách trong thư viện");
            System.out.println("3. Sắp xếp sách theo lợi nhuận tăng dần");
            System.out.println("4. Xóa sách theo mã sách");
            System.out.println("5. Tìm kiếm tương đối sách theo tên sách hoặc mô tả");
            System.out.println("6. Thay đổi thông tin sách theo mã sách");
            System.out.println("7. Thoát");

            System.out.println("Mời bạn nhập lựa chọn muốn thực hiện ( 1~7):");

            choise = Integer.parseInt(scanner.nextLine());

            switch (choise) {
                case 1:
                    System.out.println("Mời bạn nhập số lượng sách muốn thêm :");
                    int addNum = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < addNum; i++) {
                        System.out.println("Mời nhập thông tin của sản sách thứ " + (i + 1));
                        Book newBook = new Book();
                        newBook.inputData(scanner, books);
                        books[bookCount] = newBook;
                        bookCount++;
                        boodId++;
                    }
                    break;

                case 2:
                    if (bookCount <= 0) {
                        System.out.println("Hiện không có sách nào để hiển thị");
                        break;
                    }
                    for (int i = 0; i < bookCount; i++) {
                        books[i].displayData();
                    }
                    break;

                case 3:
                    if (bookCount <= 0) {
                        System.out.println("Hiện không có sách nào để sắp xếp");
                        break;
                    }
                    for (int i = 0; i < bookCount - 1; i++) {
                        Book temp = books[i];
                        for (int j = i + 1; j < bookCount; j++) {
                            if (temp.getInterest() > books[j].getInterest()) {
                                books[j - 1] = books[j];
                                books[j] = temp;
                            } else {
                                books[j - 1] = books[j];
                            }
                        }
                    }
                    for (Book p : books) {
                        p.displayData();
                    }
                    break;

                case 4:
                    System.out.println("Mời bạn nhập ID của sách muốn xóa :");
                    int deleteNum = Integer.parseInt(scanner.nextLine());

                    boolean isExit = false;
                    for (int i = 0; i < bookCount; i++) {
                        if (books[i].getBookId() == deleteNum) {
                            for (int j = i; j < bookCount - 1; j++) {
                                books[j] = books[j + 1];
                            }
                            books[bookCount - 1] = null;
                            bookCount--;
                            isExit = true;
                            break;
                        }
                    }
                    if (!isExit)
                        System.out.println("Id không tồn tại");
                    break;

                case 5:
                    System.out.println("Mời bạn nhập vào từ khóa tìm kiếm :");
                    String searcKey = scanner.nextLine();

                    for (int i = 0; i < bookCount; i++) {
                        if (books[i].getBookName().contains(searcKey) || books[i].getDescriptions().contains(searcKey)) {
                            books[i].displayData();
                        }
                    }
                    break;

                case 6:
                    System.out.println("Mời bạn nhập mã sách muốn thay đổi thông tin : ");
                    int editNum = Integer.parseInt(scanner.nextLine());
                    boolean existing = false;
                    for (int i = 0; i < bookCount; i++) {
                        if (books[i].getBookId() == editNum) {
                            //BookName
                            while (true) {
                                System.out.println("Nhập tên sách(không được bỏ trống)");
                                books[i].setBookName(scanner.nextLine());
                                if (books[i].getBookName().isEmpty()) {
                                    System.out.println("Tên của sách không được để trống!");
                                } else break;
                            }

                            //Author
                            while (true) {
                                System.out.println("Nhập tên tác giả (không được bỏ trống)");
                                books[i].setAuthor(scanner.nextLine());
                                if (books[i].getAuthor().isEmpty()) {
                                    System.out.println("Tên tác giả không được để trống!");
                                } else break;
                            }

                            //Descriptions
                            while (true) {
                                System.out.println("Nhập mô tả cho sách (không được bỏ trống, ít nhất 10 kí tự)");
                                books[i].setDescriptions(scanner.nextLine());
                                if (books[i].getDescriptions().isEmpty()) {
                                    System.out.println("Mô tả của sách không được để trống!");
                                } else if (books[i].getDescriptions().length() < 10) {
                                    System.out.println("Mô tả của sách phải có ít nhất 10 kí tự !");
                                } else {
                                    break;
                                }
                            }

                            //importPrice
                            while (true) {
                                System.out.println("Giá nhập của sách là (nhập số lớn hơn 0): ");
                                books[i].setImportPrice((double) Float.parseFloat(scanner.nextLine()));
                                if (books[i].getImportPrice() <= 0)
                                    System.out.println("Giá nhập phải lớn hơn 0");
                                else break;
                            }

                            //exportPrice
                            while (true) {
                                System.out.println("Giá xuất của sách là (phải lớn hơn 1.2 lần giá nhập): ");
                                books[i].setExportPrice((double) Float.parseFloat(scanner.nextLine()));
                                if (books[i].getExportPrice() < 1.2 * books[i].getImportPrice())
                                    System.out.println("Giá xuất phải phải lớn hơn 1.2 lần giá nhập");
                                else break;
                            }

                            //bookStatus
                            System.out.println("Trạng thái của sách (mặc định là true)");
                            books[i].setBookStatus(true);
                        }

                        existing = true;
                    }

                    if (!existing) {
                        System.out.println("Không tồn tại ID sách đã nhập!");
                    }
                    break;

                case 7:
                    System.exit(0);
                    break;
            }


        }
    }
}
