package id.co.bfi.test.api.server.response.base;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Pagination wrapper
 * 
 * @author timpamungkas
 *
 * @param <T> data type
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JsonBasePage<T> {

	private int size;

	private int page;

	private int totalPage;

	private long totalRecords;

	private List<T> data;

}
