package com.livenaked.common.http;

import com.livenaked.common.Constants;
import com.livenaked.common.ResponseCode;
import com.livenaked.common.exception.GlobalException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.slf4j.MDC;

import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "xml")
public class Response {
    private Integer code;
    private String msg;
    private Object data;
    private String traceId = MDC.get(Constants.LOG_TRACE_PK_KEY);

    public Response(ResponseCode responseCode) {
        this.code = responseCode.getCode();
        this.msg = responseCode.getMsg();
    }

    public Response(ResponseCode responseCode, String msg) {
        this.code = responseCode.getCode();
        this.msg = msg;
    }

    public Response(GlobalException exception) {
        this.code = exception.getCode();
        this.msg = exception.getMsg();
    }
}
