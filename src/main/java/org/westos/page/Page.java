package org.westos.page;

import java.util.List;

public class Page<T> {

	private Integer currentPage;
	private Integer count;
	private Integer allLine;
	private List<T> list;

	public Integer getAllPage() {
		return allLine % count == 0 ? allLine / count : allLine / count + 1;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getAllLine() {
		return allLine;
	}

	public void setAllLine(Integer allLine) {
		this.allLine = allLine;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
