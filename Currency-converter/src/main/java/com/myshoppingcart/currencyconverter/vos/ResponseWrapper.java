package com.myshoppingcart.currencyconverter.vos;

import com.myshoppingcart.currencyconverter.utility.ReflectionHelper;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ResponseWrapper {
    public final static Integer INTERNAL_NO_ERROR_1001_SUCCESSFULLY_DONE = 1001;
    public final static Integer INTERNAL_ERROR_1000_INTERNAL_SERVER_ERROR = 1000;
    public final static Integer INTERNAL_WARNING_1004_DATA_NOT_FOUND = 1004;
    public final static Integer INTERNAL_WARNING_1005_DATA_NOT_FOUND = 1005;

    @Data
    public class Result{
        private Integer response_code;
        private String response_message;
        private Object data;

        public Result() {
        }

        public Result(Integer response_code, Object data) {
            this.response_code = response_code;
            this.response_message = ResponseWrapper.get_error_message(response_code);
        }

        public Result(Integer response_code, String response_message, Object data, Integer count) {
            this.data = data;

            if(response_code==null)
                this.response_code = ResponseWrapper.INTERNAL_ERROR_1000_INTERNAL_SERVER_ERROR;
            else
                this.response_code = response_code;

            if(response_code==null)
                this.response_message = ResponseWrapper.get_error_message(this.response_code, count);
            else
                this.response_message = response_message;


        }

    }

    private Boolean status;
    private Integer status_code;
    private Result result;

    private List<String> errors;

    public ResponseWrapper() {
    }
    public ResponseWrapper(Object data) {
        reset(true, 200, INTERNAL_NO_ERROR_1001_SUCCESSFULLY_DONE, null, data, null, new ArrayList<>());
    }
    public ResponseWrapper(Object data, Integer count) {
        reset(true, 200, INTERNAL_NO_ERROR_1001_SUCCESSFULLY_DONE, null, data, count, new ArrayList<>());
    }
    public ResponseWrapper(Integer response_code, Object data) {
        reset(true, 200, response_code, null, data, null, new ArrayList<>());
    }
    public ResponseWrapper(Integer response_code, String response_message, Object data) {
        reset(true, 200, response_code, response_message, data, null, new ArrayList<>());
    }
    public ResponseWrapper(Boolean status, Integer status_code, Integer response_code, String response_message, Object data, List<String> errors) {
        reset(status, status_code, response_code, response_message, data, null, errors);
    }
    public void reset(Boolean status, Integer status_code,
                           Integer response_code, String response_message, Object data, Integer count, List<String> errors) {
        this.status = status;
        this.status_code = status_code;
        this.result =  new Result(response_code, response_message, data, count);
        if(errors != null) {
            this.errors = errors;
        }else{
            this.errors = new ArrayList<>();
        }
    }

    public static String get_error_message(Integer error_code) {
        return get_error_message(error_code, null);
    }
    public static String get_error_message(Integer error_code, Integer count) {
        if(error_code == ResponseWrapper.INTERNAL_NO_ERROR_1001_SUCCESSFULLY_DONE) {
            if (count != null && count == 0)
                return "No error found. Zero object retrieved.";
            else if (count != null && count == 1)
                return "Retrieved 1 object successfully.";
            else if (count != null && count > 1)
                return "Retrieved " + count + " object(s) successfully.";
            return "Successfully done, No error found.";
        }
        else if(error_code == ResponseWrapper.INTERNAL_ERROR_1000_INTERNAL_SERVER_ERROR)
            return "There are some problem on server.";
        else if(error_code == ResponseWrapper.INTERNAL_WARNING_1004_DATA_NOT_FOUND)
            return "Not found.";
        else if(error_code == ResponseWrapper.INTERNAL_WARNING_1005_DATA_NOT_FOUND)
            return "Not found, Due to method not allowed";
        else
            return "INTERNAL_SERVER_ERROR";
    }
}
