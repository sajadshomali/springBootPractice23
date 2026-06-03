package ir.sajjad.springbootsession23.dto.response;



public class ExceptionResponse {
    private String massage;
    private String code;

    public ExceptionResponse(String massage, String code) {
        this.massage = massage;
        this.code = code;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMassage() {
        return massage;
    }

    public String getCode() {
        return code;
    }

    public static Build builder(){
        return new Build();
    }

    public static class Build{
        public String massage;
        public String code;

        public Build massage(String massage){
            this.massage =massage;
            return this;
        }

        public Build code(String code){
            this.code = code;
            return this;
        }

        public ExceptionResponse build(){
            return new ExceptionResponse(massage,code);
        }
    }
}
