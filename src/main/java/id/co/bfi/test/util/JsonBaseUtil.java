package id.co.bfi.test.util;

import org.springframework.data.domain.Page;

import id.co.bfi.test.api.server.response.base.JsonBasePage;

public class JsonBaseUtil {

	private JsonBaseUtil() {
	}

	public static <T> JsonBasePage<T> toJsonBasePage(Page<T> pageFromSpring) {
		var body = new JsonBasePage<T>();

		body.setPage(pageFromSpring.getPageable().getPageNumber());
		body.setSize(pageFromSpring.getPageable().getPageSize());
		body.setData(pageFromSpring.getContent());
		body.setTotalPage(pageFromSpring.getTotalPages());
		body.setTotalRecords(pageFromSpring.getTotalElements());

		return body;
	}

}
