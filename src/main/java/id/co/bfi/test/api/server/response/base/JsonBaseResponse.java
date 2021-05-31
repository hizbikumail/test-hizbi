package id.co.bfi.test.api.server.response.base;

import java.util.Arrays;
import java.util.List;

import lombok.Data;

/**
 * Wrapper class for JSON element on response body. Use your own class as
 * generic type replacement.
 * 
 * @author timpamungkas
 *
 */
@Data
public class JsonBaseResponse<T> {

	/**
	 * <code>header</code> section
	 */
	private JsonBaseHeader header;

	/**
	 * Actual data
	 */
	private T data;

	public JsonBaseResponse() {
		super();
	}

	/**
	 * Return no data, should be called if your API returns non 2xx response code
	 * 
	 * @param startTime processing start time millis
	 * @param errors
	 */
	public JsonBaseResponse(long startTime, JsonBaseError... errors) {
		this(startTime, Arrays.asList(errors));
	}

	/**
	 * Return no data, should be called if your API returns non 2xx response code
	 * 
	 * @param startTime processing start time millis
	 * @param errors
	 */
	public JsonBaseResponse(long startTime, List<JsonBaseError> errors) {
		this();

		var jsonBaseHeader = new JsonBaseHeader();
		jsonBaseHeader.setSuccess(false);
		jsonBaseHeader.setErrors(errors);
		jsonBaseHeader.setProcessTime(System.currentTimeMillis() - startTime);
		this.setHeader(jsonBaseHeader);
	}

	/**
	 * 
	 * @param data      data to be returned
	 * @param startTime processing start time millis
	 */
	public JsonBaseResponse(long startTime, T data) {
		this();

		var jsonBaseHeader = new JsonBaseHeader();
		jsonBaseHeader.setSuccess(true);
		jsonBaseHeader.setErrors(null);
		jsonBaseHeader.setProcessTime(System.currentTimeMillis() - startTime);
		this.setHeader(jsonBaseHeader);

		this.setData(data);
	}

}
