package com.davidcorp.designPattern.chainOfResponsibility;

public class FaceFilter implements Filter {
    @Override
    public String doFilter(String str) {
        return str.replace(":)", "^V^");
    }
}
