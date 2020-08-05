package com.creditcard.util;

public class ConstantUtil {

    public static class CommonFields{
        public static final String SHAHR_BANK = "6037";
    }

    public static class OperationStatus {
        public static final Long NOT_SEND = 1000L;    // ارسال نشده
        public static final Long SUCCESSFUL = 1200L;    // 	موفق
        public static final Long UNSUCCESSFUL = 1210L;    // ناموفق
        public static final Long UNKNOWN = 1220L;    // نامشخص
        public static final Long KNOWN = 1230L;    // مشخص
    }

}
