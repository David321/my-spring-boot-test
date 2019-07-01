package com.davidcorp.yonxinyuan_test;

public class Hello {

    /**
     * 我认为的打印顺序：Annoyance,Sneeze,Hello
     * 运行验证，打印的顺序为：Annoyance,Sneeze,Hello
     * */
    public static void main(String[] args) throws Exception{
        try{
            try{
                throw new Sneeze();
            }catch (Annoyance a){
                System.out.println("Annoyance");
                throw a;
            }
        }catch(Sneeze s){
            System.out.println("Sneeze");
            return;
        }finally {
            System.out.println("Hello");
        }
    }
}
