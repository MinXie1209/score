package org.javatribe.score.enums;

/**
 * 返回数据
 */
public enum ResultEnum {
    UN_ERROR(-1, "未知错误"),
    SUCCESS(1, "成功"),
    ERROR(10000, "没有找到api"),
    CODE_ERROR(10001, "验证码错误"),
    TEAM_NULL(10002, "查找的队伍不存在"),
    RESCORE(10003, "重复打分"),
    TOKEN_ERROR(10004, "token错误"),
    JUDGE_ID_ERROR(10005, "评委id错误"),
    JUDGE_NAME_ERROR(10006, "评委名字错误"),
    BEYOND_NUMBER(10007,"评分范围0-100"), JUDGE_NAME_ROUND_ERROR(10008,"评委名字范围只能在8个字符之内");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
