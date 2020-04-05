package com.david.designPattern.chainOfResponsibility;


public class SensitiveFilter implements Filter {
    @Override
    public String doFilter(String str) {
        String r = str.replace("敏感", "和谐");
        return r;
    }
}
