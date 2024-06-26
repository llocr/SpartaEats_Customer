package like.heocholi.spartaeats.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class ResponseMessage<T> {
	private Integer statusCode;
	private String message;
	private T data;
}
