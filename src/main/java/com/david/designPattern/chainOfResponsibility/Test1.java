package com.david.designPattern.chainOfResponsibility;

public class Test1 {
    public static void main(String[] args) {
        String msg = "<script>, 敏感信息:)";
        MsgProcessor mp = new MsgProcessor();
        mp.setMsg(msg);

        FilterChain fc = new FilterChain();
        fc.addFilter(new FaceFilter())
                .addFilter(new SensitiveFilter());

        mp.setFc(fc);

        String result = mp.process();
        System.out.println(result);
    }
}
