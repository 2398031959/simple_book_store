package com.lei.po;

public class Book {
    private Integer bid;

    private String bname;

    private Integer btype;

    private Integer bamount;
    
    private Book_type book_type;

    @Override
	public String toString() {
		return "Book [bid=" + bid + ", bname=" + bname + ", btype=" + btype
				+ ", bamount=" + bamount + ", book_type=" + book_type + "]";
	}

	public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname == null ? null : bname.trim();
    }

    public Integer getBtype() {
        return btype;
    }

    public void setBtype(Integer btype) {
        this.btype = btype;
    }

    public Integer getBamount() {
        return bamount;
    }

    public void setBamount(Integer bamount) {
        this.bamount = bamount;
    }

	public Book_type getBook_type() {
		return book_type;
	}

	public void setBook_type(Book_type book_type) {
		this.book_type = book_type;
	}
}