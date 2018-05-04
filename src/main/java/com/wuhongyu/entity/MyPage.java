package com.wuhongyu.entity;

import java.io.Serializable;

import com.github.pagehelper.PageInfo;

public class MyPage<T> implements Serializable {

	private static final long serialVersionUID = -7237208533826049603L;
	private int pageNum;
	private long total;
	private int pages;
	private int prePage;
	private int nextPage;
	private boolean isFirstPage = false;
	private boolean isLastPage = false;
	private boolean hasPreviousPage = false;
	private boolean hasNextPage = false;
	private String url;

	public MyPage(PageInfo<T> page) {
		this.pageNum = page.getPageNum();
		this.total = page.getTotal();
		this.pages = page.getPages();
		this.prePage = page.getPrePage();
		this.nextPage = page.getNextPage();
		this.isFirstPage = page.isIsFirstPage();
		this.isLastPage = page.isIsLastPage();
		this.hasPreviousPage = page.isHasPreviousPage();
		this.hasNextPage = page.isHasNextPage();
	}

	
	public int getFirstPage() {
		return 1;
	}



	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getPrePage() {
		return prePage;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public boolean isFirstPage() {
		return isFirstPage;
	}

	public void setFirstPage(boolean isFirstPage) {
		this.isFirstPage = isFirstPage;
	}

	public boolean isLastPage() {
		return isLastPage;
	}

	public void setLastPage(boolean isLastPage) {
		this.isLastPage = isLastPage;
	}

	public boolean isHasPreviousPage() {
		return hasPreviousPage;
	}

	public void setHasPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

}
